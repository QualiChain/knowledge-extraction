package org.silkframework.rule.evaluation

import org.silkframework.entity.{Entity, Index}
import org.silkframework.rule.LinkageRule
import org.silkframework.rule.evaluation.DetailedIndex._
import org.silkframework.rule.similarity.{Aggregation, Comparison, SimilarityOperator}

/**
 * In addition to the overall index built from an linkage rule, this indexer also retains
 * all sub indices which have been build from all similarity operators in the linkage rule.
 * This can be used for closer inspection of the indexing e.g. for debugging and performance optimization.
 */
object DetailedIndexer {
  def apply(rule: LinkageRule, entity: Entity, sourceOrTarget: Boolean, limit: Double = -1.0): DetailedIndex = {
    val rootIndex = for(rootOp <- rule.operator) yield indexOperator(rootOp, entity, sourceOrTarget, limit)

    DetailedIndex(rootIndex.map(_.index).getOrElse(Index.empty), entity, rootIndex)
  }

  def indexOperator(op: SimilarityOperator, entity: Entity, sourceOrTarget: Boolean, limit: Double): OperatorIndex = op match {
    case aggregation: Aggregation => indexAggregation(aggregation, entity, sourceOrTarget, limit)
    case comparison: Comparison => indexComparison(comparison, entity, sourceOrTarget, limit)
  }

  def indexAggregation(agg: Aggregation, entity: Entity, sourceOrTarget: Boolean, limit: Double): AggregationIndex = {
    val totalWeights = agg.operators.map(_.weight).sum

    //Compute the detailed indices for each child operator
    var foundRequiredEmptyIndex = false
    val detailedIndices = {
      for (op <- agg.operators if op.indexing) yield {
        val opLimit = agg.aggregator.computeThreshold(limit, op.weight.toDouble / totalWeights)
        val index = indexOperator(op, entity, sourceOrTarget, opLimit)

        if (op.required && index.index.isEmpty) {
          foundRequiredEmptyIndex = true
        }

        index
      }
    }.filterNot(_.index.isEmpty)

    //Compute the overall index from the child operator indices
    val overallIndex = if (foundRequiredEmptyIndex) {
      Index.empty
    } else {
      agg.aggregator.aggregateIndexes(detailedIndices.map(_.index))
    }

    AggregationIndex(overallIndex, agg, detailedIndices)
  }

  def indexComparison(cmp: Comparison, entity: Entity, sourceOrTarget: Boolean, limit: Double): ComparisonIndex = {
    val values = if(sourceOrTarget) cmp.inputs.source(entity) else cmp.inputs.target(entity)
    val distanceLimit = cmp.threshold * (1.0 - limit)

    ComparisonIndex(cmp.metric.index(values, distanceLimit, sourceOrTarget), values, cmp)
  }
}
