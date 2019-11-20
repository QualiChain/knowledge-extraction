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

package org.silkframework.learning

import org.silkframework.learning.LinkageRuleLearner.Result
import org.silkframework.learning.genlink.GenLinkLearner
import org.silkframework.rule.evaluation.LinkageRuleEvaluator
import org.silkframework.runtime.activity.{Activity, ActivityContext, UserContext}

/**
 * Learns a linkage rule from reference links.
 */
class LearningActivity(input: LearningInput = LearningInput.empty,
                       config: LearningConfiguration = LearningConfiguration.default) extends Activity[LearningResult] {

  private val learner = GenLinkLearner(config)

  /** The time when the learning task has been started. */
  @volatile private var startTime = 0L

  /** Checks if this task is empty. */
  def isEmpty = input.trainingEntities.isEmpty
  
  override def initialValue = Some(LearningResult())

  /**
   * Executes this learning task.
   */
  override def run(context: ActivityContext[LearningResult])
                  (implicit userContext: UserContext): Unit = {
    // Reset state
    startTime = System.currentTimeMillis
    cancelled = false

    // Execute linkage rule learner
    val learnerActivity = context.child(learner.learn(input.trainingEntities, input.seedLinkageRules), 1.0)
    learnerActivity.value.subscribe(updateValue(context))
    learnerActivity.startBlocking()
  }

  private def updateValue(context: ActivityContext[LearningResult])(value: Result): Unit = {
    val bestRule = value.population.bestIndividual.node.build
    // TODO build training and validation result lazily
    val result =
      LearningResult(
        iterations = value.iterations,
        time = System.currentTimeMillis() - startTime,
        population = value.population,
        trainingResult = LinkageRuleEvaluator(bestRule, input.trainingEntities),
        validationResult = LinkageRuleEvaluator(bestRule, input.validationEntities),
        status = value.message
      )
    context.value.update(result)
  }
}