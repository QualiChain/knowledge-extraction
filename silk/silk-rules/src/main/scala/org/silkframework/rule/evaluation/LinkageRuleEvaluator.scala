package org.silkframework.rule.evaluation

import java.util.logging.Logger

import org.silkframework.rule.LinkageRule

object LinkageRuleEvaluator {
  val log: Logger = Logger.getLogger(this.getClass.getName)

  def apply(rule: LinkageRule,
            entity: ReferenceEntities,
            threshold: Double = 0.0,
            logFalseNegatives: Boolean = false,
            logFalsePositives: Boolean = false): EvaluationResult = {
    var truePositives: Int = 0
    var trueNegatives: Int = 0
    var falsePositives: Int = 0
    var falseNegatives: Int = 0

    var positiveScore = 0.0
    var negativeScore = 0.0
    var positiveError = 0.0
    var negativeError = 0.0

    for (entityPair <- entity.positiveEntities) {
      val confidence = rule(entityPair, threshold)

      if (confidence >= threshold) {
        truePositives += 1
        positiveScore += confidence
      }
      else {
        falseNegatives += 1
        positiveError += -confidence
        if(logFalseNegatives) {
          log.warning("False Negative: " + entityPair)
        }
      }
    }

    for (entityPair <- entity.negativeEntities) {
      val confidence = rule(entityPair, threshold)

      if (confidence >= threshold) {
        falsePositives += 1
        negativeError += confidence
        if(logFalsePositives) {
          log.warning("False Positive: " + entityPair)
        }
      }
      else {
        trueNegatives += 1
        negativeScore += -confidence
      }
    }

    //    val score =
    //    {
    //      val positiveScore = 1.0 - positiveError / entities.positive.size
    //      val negativeScore = 1.0 - negativeError / entities.negative.size
    //
    //      if(positiveScore + negativeScore == 0.0)
    //      {
    //        0.0
    //      }
    //      else
    //      {
    //        2.0 * positiveScore * negativeScore / (positiveScore + negativeScore)
    //      }
    //    }

    //        val score =
    //        {
    //          val cross = positiveScore * negativeScore - negativeError * positiveError
    //          val sum = (positiveScore + negativeError) * (positiveScore + positiveError) * (negativeScore + negativeError) * (negativeScore + positiveError)
    //
    //          if(sum != 0.0) cross.toDouble / math.sqrt(sum.toDouble) else 0.0
    //        }
    //
    //    val score = {
    //      (positiveScore / (positiveScore + positiveError)) * (negativeScore / (negativeScore + negativeError))
    //    }

    new EvaluationResult(truePositives, trueNegatives, falsePositives, falseNegatives)
  }
}
