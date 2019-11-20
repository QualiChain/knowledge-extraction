/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.silkframework.entity

import java.io.{DataInput, DataOutput}

import org.silkframework.config.Prefixes
import org.silkframework.entity.metadata.{EntityMetadata, EntityMetadataXml, GenericExecutionFailure}
import org.silkframework.entity.paths.{TypedPath, UntypedPath}
import org.silkframework.failures.FailureClass
import org.silkframework.util.Uri

import scala.language.existentials
import scala.xml.Node

/**
  * An Entity can represent an instance of any given concept
  * @param uri         - an URI as identifier
  * @param vals        - A list of values of the properties defined in the provided EntitySchema
  * @param schema      - The EntitySchema defining the nature of this entity
  * @param subEntities - optional, each entity can be composed of multiple sub-entities if defined with a suitable MultiEntitiySchema
  * @param metadata    - metadata object containing all available metadata information about this object
  *                    an Entity is marked as 'failed' if [[org.silkframework.entity.metadata.EntityMetadata.failure]] is set. It becomes sealed.
  */
case class Entity private(
    uri: Uri,
    private val vals: IndexedSeq[Seq[String]],
    schema: EntitySchema,
    subEntities: IndexedSeq[Option[Entity]] = IndexedSeq.empty,
    metadata: EntityMetadata[_] = EntityMetadataXml()
  ) extends Serializable {

  def copy(
    uri: Uri = this.uri,
    values: IndexedSeq[Seq[String]] = this.values,
    schema: EntitySchema = this.schema,
    subEntities: IndexedSeq[Option[Entity]] = this.subEntities,
    metadata: EntityMetadata[_] = this.metadata,
    failureOpt: Option[FailureClass] = None,
    projectValuesIfNewSchema: Boolean = false
  ): Entity = this.failure match{
    case Some(_) => this                                // if origin entity has already failed, we forward it so the failure is not overwritten
    case None =>
      val actualVals = if(schema != this.schema && projectValuesIfNewSchema) shiftProperties(schema) else values  //here we remap value indices for possible shifts of typed paths
      val actualSubs = if(schema != this.schema && projectValuesIfNewSchema) subEntities.map(o => o.map(e => e.copy(schema = schema))) else subEntities
      val actualMetadata = failureOpt match{
        case Some(f) if metadata.failure.metadata.isEmpty => metadata.addFailure(f)
        case _ => metadata
      }
      new Entity(uri, actualVals, schema, actualSubs, actualMetadata)
  }

  /**
    * Will remap the index positions of values in case the typed paths of the EntitySchema were changed
    * @param es - the new schema
    * @return - the new value array
    */
  private def shiftProperties(es: EntitySchema): IndexedSeq[Seq[String]] ={
    es.typedPaths.map(tp => this.schema.typedPaths.find(p => p.equalsUntyped(tp)) match{
      case Some(fp) => this.evaluate(fp)
      case None => Seq()
    })
  }

  /**
    * Convenience function for applying a new schema without validating (e.g. when renaaming properties)
    * @param es - the schema
    * @return
    */
  def applyNewSchema(es: EntitySchema): Entity = copy(schema = es, projectValuesIfNewSchema = false)

  /**
    * The value-array containing as many values as properties in the schema
    */
  val values: IndexedSeq[Seq[String]] = vals.map(Entity.handleNullsInValueSeq)

  val failure: Option[GenericExecutionFailure] = {
    if(metadata.failure.metadata.isEmpty) {                                                    // if no failure has occurred yet
      if(schema.isInstanceOf[MultiEntitySchema] && schema.asInstanceOf[MultiEntitySchema].subSchemata.size < subEntities.size){
        // if sub entities size is not equal to sub schemata size
        Some(GenericExecutionFailure(new IllegalArgumentException("Number of sub-entities is not equal to the number of sub-schemata for: " + uri)))
      }
      else if(uri.uri.trim.isEmpty){
        Some(GenericExecutionFailure(new IllegalArgumentException("Entity with an empty URI is not allowed.")))
      }
      else if (! this.validate) { // if entity is not valid
        Some(GenericExecutionFailure(new IllegalArgumentException("Provided schema does not fit entity values or sub-entities.")))
      }
      else{
        None
      }}
    else {
      metadata.failure.metadata.map(_.rootCause)   //propagate former failure
    }
  }

  /**
    * Signals if the given [[Entity]] is marked as having failed to evaluate
    */
  def hasFailed: Boolean = failure.isDefined

  /**
    * Will retrieve the values of a given path (if available)
    * @param path - the property or path
    */
  @deprecated("Use evaluate(path: TypedPath) instead, since uniqueness of paths are only guaranteed with provided ValueType.", "18.03")
  def evaluate(path: UntypedPath): Seq[String] = {
    valueOfPath(path)
  }

  /**
    * Will retrieve the values of a given path (if available)
    * @param path - the property or path
    */
  def evaluate(path: TypedPath): Seq[String] = valueOfTypedPath(path)

  /**
    * returns the all values for the column index of the row representing this entity
    * @param pathIndex - the index in the value array
    */
  def evaluate(pathIndex: Int): Seq[String] = {
    this.schema match {
      case mes: MultiEntitySchema =>
        val schemata = Seq(mes.pivotSchema) ++ mes.subSchemata
        val pivotSize = mes.pivotSchema.typedPaths.size
        // create range sequence where the first entry is the EntitySchema belonging to the value of the index (and the second is out of range)
        val rangeMap = (schemata.zip(Seq(0) ++ mes.subSchemata.zipWithIndex.map(x => mes.subSchemata.
            splitAt(x._2)._1
            .foldLeft(pivotSize)((i, s) => s.typedPaths.size + i))
        ) ++ Seq((EntitySchema.empty, mes.typedPaths.size))).sliding(2)
        // now find the correct range and EntitySchema
        val zw = rangeMap.find(x => x.head._2 <= pathIndex && (x.tail.headOption match {
          case Some(o) => o._2 > pathIndex
          case None => true
        })).map(_.head)
        zw.flatMap(x =>
          if (x._1 == mes.pivotSchema) {
            Some(this.values(pathIndex))
          }
          else {
            this.subEntities.flatten.find(se => se.schema == x._1).map(e => e.evaluate(pathIndex - x._2))
          }
        ).getOrElse(Seq())
      case _: EntitySchema => this.values(pathIndex)
    }
  }

  /**
    * returns all values of a given property in the entity
    * @param path - the property or path
    */
  def valueOfTypedPath(path: TypedPath): Seq[String] ={
    if(path.operators.isEmpty) {
      Seq(uri)
    } else {
      schema.getSchemaOfProperty(path) match {
        case Some(es) =>
          //if pertaining schema is this schema or its the pivot schema of a MultiEntitySchema
          val ent = if (es == schema || schema.isInstanceOf[MultiEntitySchema] && schema.asInstanceOf[MultiEntitySchema].pivotSchema == es) {
            this
          }
          else {
            subEntities.flatten.find(e => e.schema == es).getOrElse(return Seq())
          }
          //now find the pertaining index and get values
          ent.evaluate(es.indexOfTypedPath(TypedPath.removePathPrefix(path, es.subPath)))
        case None => Seq()
      }
    }
  }

  /**
    * returns all values of a given property in the entity
    * NOTE: there might be a chance that a given path exists twice with different value types, use [[valueOfTypedPath()]] instead
    * @param path - the property or path
    */
  def valueOfPath(path: UntypedPath): Seq[String] ={
    if(path.operators.isEmpty) {
      Seq(uri)
    } else {
      schema.getSchemaOfPropertyIgnoreType(path) match {
        case Some(es) =>
          //if pertaining schema is this schema or its the pivot schema of a MultiEntitySchema
          val ent = if (es == schema || schema.isInstanceOf[MultiEntitySchema] && schema.asInstanceOf[MultiEntitySchema].pivotSchema == es) {
            this
          }
          else {
            subEntities.flatten.find(e => e.schema == es).getOrElse(return Seq())
          }
          //now find the pertaining index and get values
          ent.evaluate(es.indexOfPath(UntypedPath.removePathPrefix(path, es.subPath)))
        case None => Seq()
      }
    }
  }

  /**
    * returns the first value (of possibly many) for the property of the given name in this entity
    * NOTE: there might be a chance that a given path exists twice with different value types, use TypedPath based version instead
    * @param property - the property name to query
    * @return
    */
  def singleValue(property: String)(implicit prefixes: Prefixes = Prefixes.default): Option[String] = valueOfPath(UntypedPath.saveApply(property)).headOption

  /**
    * returns the first value (of possibly many) for the property of the given name in this entity
    * @param path - the path to query
    * @return
    */
  def singleValue(path: TypedPath): Option[String] = valueOfTypedPath(path).headOption

  /**
    * Validates the complete value row against the given types of the schema
    * @return - the result of the validation matrix (where all values are valid)
    */
  private def validate: Boolean = {
    val tps = schema match {
      case mes: MultiEntitySchema => mes.pivotSchema
      case _ => schema
    }
    val valsSize = values.size >= tps.typedPaths.size
    val valsConform = tps.typedPaths.zipWithIndex.forall(tp =>{
      if(tp._2 < values.size)
        values(tp._2).forall(v => tp._1.valueType.validate(v))
      else
        throw new ArrayIndexOutOfBoundsException(tp._2)
    })
    val subEntsValid = schema match{
      case mes: MultiEntitySchema => subEntities.zip(mes.subSchemata).forall(se => se._1.isEmpty || se._2 == se._1.get.schema && se._1.get.validate)
      case _: EntitySchema => true
    }
    valsSize && valsConform && subEntsValid
  }

  def toXML: Node = {
    <Entity uri={uri.toString}>
      <Values>      {
        for (valueSet <- values) yield {
          <Val> {
            for (value <- valueSet) yield {
              <e>{value}</e>
            }
            }
          </Val>
        }
        }
      </Values>
      <SubEntities>{
        for (sub <- subEntities) yield {
          <Sub>{sub.foreach(e => e.toXML)}</Sub>
          // NOTE: at the moment metadata is lost when serializing to XML
        }}
      </SubEntities>
    </Entity>
  }

  def serialize(stream: DataOutput) {
    stream.writeUTF(uri)
    for (valueSet <- values) {
      stream.writeInt(valueSet.size)
      for (value <- valueSet) {
        stream.writeUTF(value)
      }
    }
    stream.writeInt(subEntities.size)
    for (sub <- subEntities) {
      sub match{
        case Some(e) =>
          stream.writeBoolean(true)
          e.serialize(stream)
        case None =>
          stream.writeBoolean(false)
      }
    }
  }

  override def toString: String = failure match{
    case Some(f) => uri + " failed with: " + f.getMessage
    case None => uri + "{\n  " + (values ++ subEntities.flatMap(oe => oe.map(_.values)).flatten).mkString("\n  ") + "\n}"
  }


  override def equals(other: Any): Boolean = other match {
    case o: Entity => this.uri.toString == o.uri.toString && this.values == o.values && this.schema == o.schema
    case _ => false
  }

  override def hashCode(): Int = {
    var hashCode = uri.toString.hashCode
    hashCode = hashCode * 31 + values.foldLeft(1)(31 * _ + _.hashCode())
    hashCode = hashCode * 31 + schema.hashCode()
    hashCode
  }
}

object Entity {

  def empty(uri: Uri): Entity = new Entity(uri, IndexedSeq.empty, EntitySchema.empty)

  def apply(uri: Uri, values: IndexedSeq[Seq[String]], schema: EntitySchema, subEntities: IndexedSeq[Option[Entity]]): Entity = {
    new Entity(uri, values, schema, subEntities)
  }

  def apply(uri: String, values: IndexedSeq[Seq[String]], schema: EntitySchema, subEntities: IndexedSeq[Option[Entity]]): Entity = {
    new Entity(uri, values, schema, subEntities)
  }

  def apply(uri: Uri, values: IndexedSeq[Seq[String]], schema: EntitySchema): Entity = {
    new Entity(uri, values, schema)
  }

  def apply(uri: String, values: IndexedSeq[Seq[String]], schema: EntitySchema): Entity = {
    new Entity(uri, values, schema)
  }

  def apply(uri: String, values: IndexedSeq[Seq[String]], schema: EntitySchema, subEntities: IndexedSeq[Option[Entity]], failureOpt: Option[FailureClass]): Entity = {
    new Entity(uri, values, schema, subEntities, failureOpt match{
      case Some(t) => EntityMetadataXml(t)
      case None => EntityMetadataXml()
    })
  }

  def handleNullsInValueSeq(valueSeq: Seq[String]): Seq[String] = if(valueSeq == null) Seq() else valueSeq.flatMap(x => Option(x))

  /**
    * Instantiates a new Entity and fails it with the given Throwable
    * NOTE: values are all set to empty.
    * @param uri - uri of the entity
    * @param schema - the EntitySchema pertaining to the Entity
    * @param failure - the Throwable which failed this Enity as [[FailureClass]]
    * @return - the failed Entity
    */
  def apply(uri: Uri, schema: EntitySchema, failure: FailureClass): Entity = {
    val emptyValues = schema.typedPaths.map(_ => Seq.empty)
    Entity(uri, emptyValues, schema, IndexedSeq(), Some(failure))
  }

  /**
    * Instantiates a new Entity and fails it with the given Throwable
    * @param uri - uri of the entity
    * @param values - the values applied for the failed Entity
    * @param schema - the EntitySchema pertaining to the Entity
    * @param failure - the Throwable which failed this Enity as [[FailureClass]]
    * @return - the failed Entity
    */
  def apply(uri: Uri, values: IndexedSeq[Seq[String]], schema: EntitySchema, failure: FailureClass): Entity = Entity(uri, values, schema, IndexedSeq(), Some(failure))


  def fromXML(node: Node, desc: EntitySchema): Entity = {
    if(node == null)
      return null
    new Entity(
      uri = (node \ "@uri").text.trim,
      vals = {
        for (valNode <- node \ "Values" \ "Val") yield {
          for (e <- valNode \ "e") yield e.text
        }
      }.toIndexedSeq,
      schema = desc,
      subEntities = {
        var ind = -1
        for (valNode <- node \ "SubEntities" \ "Sub") yield {
          ind = ind + 1
          Option(fromXML(valNode, desc.asInstanceOf[MultiEntitySchema].subSchemata(ind)))
        }
      }.toIndexedSeq
    )
  }

  def deserialize(stream: DataInput, desc: EntitySchema): Entity = {
    //Read URI
    val uri = stream.readUTF()

    //Read Values
    def readValue = Seq.fill(stream.readInt)(stream.readUTF)

    desc match{
      case mes: MultiEntitySchema =>
        val values = IndexedSeq.fill(mes.pivotSchema.typedPaths.size)(readValue)
        val subs = mes.subSchemata.map(se => {
          if(stream.readBoolean())
            Some(deserialize(stream, se))
          else
            None
        })
        Entity(uri, values, mes, subs)
      case es: EntitySchema =>
        val values = IndexedSeq.fill(desc.typedPaths.size)(readValue)
        Entity(uri, values, es)
    }
  }
}
