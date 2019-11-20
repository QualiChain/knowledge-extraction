package org.silkframework.plugins.dataset.rdf.formatters

import java.io._

import org.silkframework.dataset.{EntitySink, TripleSink, TypedProperty}
import org.silkframework.entity.ValueType
import org.silkframework.runtime.activity.UserContext
import org.silkframework.runtime.resource.{FileResource, WritableResource}
import org.silkframework.util.Uri

/**
 * An entity sink that writes formatted entity output to an output resource.
 */
class FormattedEntitySink(resource: WritableResource, formatter: EntityFormatter) extends EntitySink with TripleSink {

  private var properties = Seq[TypedProperty]()

  // We optimize cases in which the resource is a file resource
  private val javaFile = resource match {
    case f: FileResource => Some(f.file)
    case _ => None
  }

  private var writer: Writer = _

  override def openTable(typeUri: Uri, properties: Seq[TypedProperty])
                        (implicit userContext: UserContext){
    this.properties = properties
    if(writer == null) {
      // If we got a java file, we write directly to it, otherwise we write to a temporary string
      writer = javaFile match {
        case Some(file) =>
          file.getParentFile.mkdirs()
          new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"))
        case None => new StringWriter()
      }
      //Write header
      writer.write(formatter.header)
    }
  }

  override def writeEntity(subject: String, values: Seq[Seq[String]])
                          (implicit userContext: UserContext): Unit = {
    for((property, valueSet) <- properties zip values;
        value <- valueSet) {
      if(property.isBackwardProperty) {
        writeStatement(value, property.propertyUri, subject, property.valueType)
      } else {
        writeStatement(subject, property.propertyUri, value, property.valueType)
      }
    }
  }

  private def writeStatement(subject: String, predicate: String, value: String, valueType: ValueType): Unit = {
    writer.write(formatter.formatLiteralStatement(subject, predicate, value, valueType))
  }

  override def closeTable()(implicit userContext: UserContext): Unit = {}

  override def close()(implicit userContext: UserContext) {
    if (Option(writer).isDefined) {
      writer.write(formatter.footer)
      writer.close()
      // In case we used a string writer, we still need to write the generated string.
      writer match {
        case stringWriter: StringWriter => resource.writeString(stringWriter.toString, append = true)
        case _ =>
      }
      writer = null
    }
  }

  override def init()(implicit userContext: UserContext): Unit = {
    openTable(typeUri = "", properties = Seq())
  }

  override def writeTriple(subject: String, predicate: String, value: String, valueType: ValueType)
                          (implicit userContext: UserContext): Unit = {
    writeStatement(subject, predicate, value, valueType)
  }

  /**
    * Makes sure that the next write will start from an empty dataset.
    */
  override def clear()(implicit userContext: UserContext): Unit = resource.delete()
}