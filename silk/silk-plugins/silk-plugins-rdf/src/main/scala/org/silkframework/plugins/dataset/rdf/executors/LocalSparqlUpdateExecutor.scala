package org.silkframework.plugins.dataset.rdf.executors

import org.silkframework.config.Task
import org.silkframework.dataset.DataSource
import org.silkframework.entity.{Entity, EntitySchema}
import org.silkframework.execution.ExecutionReport
import org.silkframework.execution.local._
import org.silkframework.plugins.dataset.rdf.tasks.SparqlUpdateCustomTask
import org.silkframework.runtime.activity.{ActivityContext, UserContext}
import org.silkframework.runtime.validation.ValidationException

/**
  * Local executor for [[SparqlUpdateCustomTask]].
  */
case class LocalSparqlUpdateExecutor() extends LocalExecutor[SparqlUpdateCustomTask] {
  override def execute(task: Task[SparqlUpdateCustomTask],
                       inputs: Seq[LocalEntities],
                       outputSchema: Option[EntitySchema],
                       execution: LocalExecution,
                       context: ActivityContext[ExecutionReport])
                      (implicit userContext: UserContext): Option[LocalEntities] = {
    val updateTask = task.data
    val expectedSchema = updateTask.expectedInputSchema

    // Generate SPARQL Update queries for input entities
    def executeOnInput[U](batchEmitter: BatchSparqlUpdateEmitter[U],
                          expectedProperties: IndexedSeq[String],
                          input: LocalEntities): Unit = {
      val inputProperties = getInputProperties(input.entitySchema).distinct
      checkInputSchema(expectedProperties, inputProperties.toSet)
      for (entity <- input.entities;
           values = expectedSchema.typedPaths.map(tp => entity.valueOfPath(tp.toUntypedPath)) if values.forall(_.nonEmpty)) {
        val it = CrossProductIterator(values, expectedProperties)
        while (it.hasNext) {
          batchEmitter.update(updateTask.generate(it.next()))
        }
      }
    }

    val traversable = new Traversable[Entity] {
      override def foreach[U](f: Entity => U): Unit = {
        val batchEmitter = BatchSparqlUpdateEmitter(f, updateTask.batchSize)
        val expectedProperties = getInputProperties(expectedSchema)
        if (expectedProperties.isEmpty) {
          // Static template needs only to be executed once
          batchEmitter.update(updateTask.generate(Map.empty))
        } else {
          for (input <- inputs) {
            executeOnInput(batchEmitter, expectedProperties, input)
          }
        }
        batchEmitter.close()
      }
    }

    Some(new SparqlUpdateEntityTable(traversable, task))
  }

  // Check that expected schema is subset of input schema
  private def checkInputSchema[U](expectedProperties: Seq[String], inputProperties: Set[String]): Unit = {
    if (expectedProperties.exists(p => !inputProperties.contains(p))) {
      val missingProperties = expectedProperties.filterNot(inputProperties.contains)
      throw new ValidationException("SPARQL Update executor: The input schema does not match the expected schema. Missing properties: " +
          missingProperties.mkString(", "))
    }
  }

  private def getInputProperties(entitySchema: EntitySchema): IndexedSeq[String] = {
    entitySchema.typedPaths.flatMap(_.property).map(_.propertyUri)
  }
}

case class CrossProductIterator(values: IndexedSeq[Seq[String]],
                                properties: IndexedSeq[String]) extends Iterator[Map[String, String]] {
  assert(values.nonEmpty)
  private val sizes = values.map(_.size).toArray
  // Holds the current index combination
  private val indexes = new Array[Int](values.size)
  private val lastIndex = values.size - 1
  private val emptyIndexExists = sizes.contains(0)

  override def hasNext: Boolean = indexes(0) < sizes(0) && !emptyIndexExists

  override def next(): Map[String, String] = {
    if(!hasNext) {
      throw new IllegalStateException("Iterator is fully consumed and has no more values!")
    }
    val nextValue = properties.zip(indexes.zipWithIndex.map { case (valueIdx, valuesIdx) => values(valuesIdx)(valueIdx) }).toMap
    setNextIndexCombinations()
    nextValue
  }

  private def setNextIndexCombinations(): Unit = {
    var idx = lastIndex
    while(idx > -1) {
      indexes(idx) += 1
      if(indexes(idx) >= sizes(idx) && idx != 0) { // Do not reset the first index, because of hasNext check
        indexes(idx) = 0
        idx -= 1
      } else if(idx > 0) {
        for(i <- (idx + 1) to lastIndex) { // null all index values after this index
          indexes(i) = 0
        }
        idx = -1
      } else {
        idx = -1
      }
    }
  }
}

case class BatchSparqlUpdateEmitter[U](f: Entity => U, batchSize: Int) {
  private var sparqlUpdateQueries = new StringBuffer()
  private var queryCount = 0

  def update(query: String): Unit = {
    if(queryCount > 0) {
      sparqlUpdateQueries.append("\n")
    }
    queryCount += 1

    sparqlUpdateQueries.append(query)
    if(queryCount >= batchSize) {
      emitEntity()
    }
  }

  private var entityCount = 0
  private def emitEntity(): Unit = {
    f(Entity(DataSource.URN_NID_PREFIX + entityCount, values = IndexedSeq(Seq(sparqlUpdateQueries.toString)), schema = SparqlUpdateEntitySchema.schema))
    sparqlUpdateQueries = new StringBuffer()
    queryCount = 0
    entityCount += 1
  }

  def close(): Unit = {
    if(queryCount > 0) {
      emitEntity()
    }
  }
}