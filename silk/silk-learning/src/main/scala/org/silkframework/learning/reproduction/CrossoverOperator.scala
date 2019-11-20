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

package org.silkframework.learning.reproduction

import org.silkframework.learning.individual.LinkageRuleNode
import org.silkframework.runtime.plugin.{AnyPlugin, PluginFactory}
import org.silkframework.util.DPair

//TODO implement operators: toggle required, change plugin

/**
 * A crossover operator takes a pair of nodes and combines them into a new node.
 */
trait CrossoverOperator extends (DPair[LinkageRuleNode] => Option[LinkageRuleNode]) with AnyPlugin {
  /**
   * Applies this crossover operator to a specific pair of nodes.
   */
  def apply(nodePair: DPair[LinkageRuleNode]): Option[LinkageRuleNode]

  override def toString = getClass.getSimpleName
}

object CrossoverOperator extends PluginFactory[CrossoverOperator] {
  register(classOf[ThresholdCrossover])
  register(classOf[WeightCrossover])
  register(classOf[AggregationOperatorsCrossover])
  register(classOf[AggregationFunctionCrossover])
  register(classOf[OperatorCrossover])
  register(classOf[TransformationCrossover])
}
