package org.silkframework.dataset.rdf

import scala.collection.immutable.SortedMap

case class SparqlResults(bindings: Traversable[SortedMap[String, RdfNode]]) {

  def variables: Seq[String] =
    if(bindings.isEmpty) Seq.empty
    else bindings.head.keys.toSeq
}
