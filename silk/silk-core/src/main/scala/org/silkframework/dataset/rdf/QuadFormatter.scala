package org.silkframework.dataset.rdf

/**
  * Serializes Quads
  */
trait QuadFormatter extends ElementFormatter[Quad] {

  /**
    * Serializes a [Quad] with context (if present).
    */
  def formatQuad(quad: org.silkframework.dataset.rdf.Quad): String

  /**
    * Serializes a [Quad] as a triple without context.
    */
  def formatAsTriple(triple: Triple): String

  /**
    * Parse a given line into a Quad
    * @param txt - serialized Quad
    */
  def parseQuad(txt: String): Quad

  /**
    * Parse a given line into a Triple
    * @param txt - serialized Triple
    */
  def parseTriple(txt: String): Triple

  /**
    * The pertaining html media type
    */
  def associatedMediaType: String

  override def formatElement(quad: Quad): String = formatQuad(quad)

}
