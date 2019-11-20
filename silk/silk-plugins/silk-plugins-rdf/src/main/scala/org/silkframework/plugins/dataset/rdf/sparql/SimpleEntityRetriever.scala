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

package org.silkframework.plugins.dataset.rdf.sparql

import java.util.logging.Logger

import org.silkframework.dataset.rdf.{RdfNode, Resource, SparqlEndpoint}
import org.silkframework.entity.rdf.{SparqlEntitySchema, SparqlPathBuilder}
import org.silkframework.entity.{Entity, EntitySchema}
import org.silkframework.runtime.activity.UserContext
import org.silkframework.util.Uri

/**
 * EntityRetriever which executes a single SPARQL query to retrieve the entities.
 */
class SimpleEntityRetriever(endpoint: SparqlEndpoint,
                            pageSize: Int = SimpleEntityRetriever.DEFAULT_PAGE_SIZE,
                            graphUri: Option[String] = None,
                            useOrderBy: Boolean = true,
                            useSubSelect: Boolean = false) extends EntityRetriever {
  private val log: Logger = Logger.getLogger(getClass.getName)
  private val varPrefix = "v"

  /**
   * Retrieves entities with a given entity description.
   *
   * @param entitySchema The entity description
   * @param entities The URIs of the entities to be retrieved. If empty, all entities will be retrieved.
   * @return The retrieved entities
   */
  override def retrieve(entitySchema: EntitySchema, entities: Seq[Uri], limit: Option[Int])
                       (implicit userContext: UserContext): Traversable[Entity] = {
    retrieveAll(entitySchema, limit, entities)
  }

  /**
   * Retrieves all entities with a given entity description.
   *
   * @param entitySchema The entity schema
   * @return The retrieved entities
   */
  private def retrieveAll(entitySchema: EntitySchema, limit: Option[Int], entities: Seq[Uri])
                         (implicit userContext: UserContext): Traversable[Entity] = {
    val sparqlEntitySchema = SparqlEntitySchema.fromSchema(entitySchema, entities)
    val sparqlQuery: String = buildSparqlQuery(sparqlEntitySchema, useDistinct = true)

    val sparqlResults = endpoint.select(sparqlQuery, limit.getOrElse(Int.MaxValue))

    new EntityTraversable(sparqlResults.bindings, entitySchema, None, limit, sparqlEntitySchema)
  }

  def buildSparqlQuery(sparqlEntitySchema: SparqlEntitySchema, useDistinct: Boolean): String = {
    //Select
    val sparql = new StringBuilder
    sparql append "SELECT "
    if(useDistinct) {
      sparql append "DISTINCT "
    }
    val selectVariables = genSelectVariables(sparqlEntitySchema)
    sparql append selectVariables
    sparql append "\n"

    addFrom(sparql)

    //Body
    sparql append "WHERE {\n"
    // GRAPH in subselect case
    for (graph <- graphUri if !graph.isEmpty && useSubSelect) sparql append s"GRAPH <$graph> {\n"

    addRestrictions(sparqlEntitySchema, sparql)

    sparql append SparqlPathBuilder(sparqlEntitySchema.paths, "?" + sparqlEntitySchema.variable, "?" + varPrefix)
    // End GRAPH in subselect case
    for (graph <- graphUri if !graph.isEmpty && useSubSelect) sparql append s"}"
    sparql append "}" // END WHERE
    if (useOrderBy) sparql append (" ORDER BY ?" + sparqlEntitySchema.variable)

    if (useSubSelect) {
      s"SELECT $selectVariables\nWHERE {\n${sparql.toString}\n}"
    } else {
      sparql.toString()
    }
  }

  private def addFrom(sparql: StringBuilder) = {
    // Graph. If the sub-select strategy should be used we have to use GRAPH instead of FROM
    for (graph <- graphUri if !graph.isEmpty && !useSubSelect) sparql append s"FROM <$graph>\n"
  }

  private def addRestrictions(sparqlEntitySchema: SparqlEntitySchema, sparql: StringBuilder) = {
    if (!sparqlEntitySchema.restrictions.toSparql.isEmpty) {
      sparql append (sparqlEntitySchema.restrictions.toSparql + "\n")
    } else {
      sparql append s"?${sparqlEntitySchema.variable} ?${varPrefix}_p ?${varPrefix}_o .\n"
    }
  }

  private def genSelectVariables(sparqlEntitySchema: SparqlEntitySchema) = {
    var temp = "?" + sparqlEntitySchema.variable + " "
    for (i <- sparqlEntitySchema.paths.indices) {
      temp += "?" + varPrefix + i + " "
    }
    temp
  }

  /**
   * Wraps a Traversable of SPARQL results and retrieves entities from them.
   */
  private class EntityTraversable(sparqlResults: Traversable[Map[String, RdfNode]],
                                  entitySchema: EntitySchema,
                                  subject: Option[Uri],
                                  limit: Option[Int],
                                  sparqlEntitySchema: SparqlEntitySchema) extends Traversable[Entity] {
    override def foreach[U](f: Entity => U): Unit = {
      //Remember current subject
      var curSubject: Option[String] = subject.map(_.uri)

      //Collect values of the current subject
      var values = Array.fill(entitySchema.typedPaths.size)(Seq[String]())

      // Count retrieved entities
      var counter = 0
      val startTime = System.currentTimeMillis()

      for (result <- sparqlResults) {
        //If the subject is unknown, find binding for subject variable
        if (subject.isEmpty) {
          //Check if we are still reading values for the current subject
          val resultSubject = result.get(sparqlEntitySchema.variable) match {
            case Some(Resource(value)) => Some(value)
            case _ => None
          }

          if (resultSubject != curSubject) {
            for (curSubjectUri <- curSubject) {
              f(Entity(curSubjectUri, values.map(_.distinct).toIndexedSeq, entitySchema))
              counter += 1
              if(limit.exists(counter >= _))
                return
            }

            curSubject = resultSubject
            values = Array.fill(entitySchema.typedPaths.size)(Seq[String]())
          }
        }

        //Find results for values for the current subject
        if (curSubject.isDefined) {
          for ((variable, node) <- result if variable.startsWith(varPrefix)) {
            val id = variable.substring(varPrefix.length).toInt

            values(id) = values(id) :+ node.value
          }
        }
      }

      for (curSubjectUri <- curSubject) {
        f(Entity(curSubjectUri, values.map(_.distinct).toIndexedSeq, entitySchema))
        counter += 1
      }

      log.info(s"Retrieved $counter entities of type '${entitySchema.typeUri}'" +
          s"${graphUri.map(g => s" from graph '$g'").getOrElse("")} in ${System.currentTimeMillis() - startTime}ms.")
    }
  }

}

object SimpleEntityRetriever {
  final val DEFAULT_PAGE_SIZE = 1000
}