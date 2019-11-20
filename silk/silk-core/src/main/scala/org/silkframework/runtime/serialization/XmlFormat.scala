package org.silkframework.runtime.serialization

import scala.reflect.ClassTag
import scala.xml.{Node, XML}

/**
 * XML serialization format.
 */
abstract class XmlFormat[T: ClassTag] extends SerializationFormat[T, Node] {

  /**
    * The XML tag names that are generated and read by this format.
    */
  def tagNames: Set[String] = Set.empty

  /**
    * The MIME types that can be formatted.
    */
  def mimeTypes: Set[String] = Set(XmlFormat.MIME_TYPE_TEXT, XmlFormat.MIME_TYPE_APPLICATION)

  /**
    * Formats a value as string.
    */
  def toString(value: T, mimeType: String)(implicit writeContext: WriteContext[Node]): String = {
    val printer = new scala.xml.PrettyPrinter(120, 2)
    val node = write(value)
    printer.format(node)
  }

  /**
    * Reads a value from an XML string.
    */
  def fromString(value: String, mimeType: String)(implicit readContext: ReadContext): T = {
    read(parse(value, mimeType))
  }

  /**
    * Read Serialization format from string
    */
  override def parse(value: String, mimeType: String): Node = XML.loadString(value)

  override def toString(values: Iterable[T], mimeType: String, containerName: Option[String])(implicit writeContext: WriteContext[Node]): String = {
    containerName match {
      case Some(name) =>
        val sb = new StringBuilder()
        sb.append(s"<$name>")
        for(v <- values) {
          sb.append(toString(v, mimeType))
        }
        sb.append(s"</$name>")
        sb.toString()
      case None =>
        throw new IllegalArgumentException("Must define a container name for serializing traversables to an XML String.")
    }
  }

}

object XmlFormat{
  val MIME_TYPE_TEXT = "text/xml"
  val MIME_TYPE_APPLICATION = "application/xml"
}