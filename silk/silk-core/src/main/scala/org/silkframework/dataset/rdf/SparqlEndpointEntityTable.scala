package org.silkframework.dataset.rdf

import org.silkframework.config.{SilkVocab, Task, TaskSpec}
import org.silkframework.entity._
import org.silkframework.execution.local.LocalEntities
import org.silkframework.runtime.activity.UserContext
import org.silkframework.util.Uri

/**
  * An entity table that does not contain data, but a SPARQL endpoint from the data source input that can be queried.
  */
class SparqlEndpointEntityTable(sparqlEndpoint: SparqlEndpoint, val task: Task[TaskSpec]) extends LocalEntities {
  override def entitySchema: EntitySchema = EntitySchema.empty

  override def entities: Traversable[Entity] = Traversable.empty

  def select(query: String, limit: Int = Integer.MAX_VALUE)
            (implicit userContext: UserContext): SparqlResults = sparqlEndpoint.select(query, limit)

  def construct(query: String)(implicit userContext: UserContext): QuadIterator = sparqlEndpoint.construct(query)
}

object SparqlEndpointEntitySchema {
  final val schema = EntitySchema(
    typeUri = Uri(SilkVocab.SparqlEndpointSchemaType),
    typedPaths = IndexedSeq.empty
  )
}