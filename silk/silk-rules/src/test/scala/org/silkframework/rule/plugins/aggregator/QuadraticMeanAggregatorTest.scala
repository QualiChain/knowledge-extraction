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

package org.silkframework.rule.plugins.aggregator

import org.scalatest.{FlatSpec, Matchers}
import org.silkframework.rule.plugins.aggegrator.QuadraticMeanAggregator
import org.silkframework.test.PluginTest
import org.silkframework.testutil.approximatelyEqualTo


class QuadraticMeanAggregatorTest extends PluginTest {

  val aggregator = new QuadraticMeanAggregator()

  it should "compute the weighted quadratic mean" in {
    aggregator.evaluate((1, 1.0) :: (1, 1.0) :: (1, 1.0) :: Nil).get should be(approximatelyEqualTo(1.0))
    aggregator.evaluate((1, 1.0) :: (1, 0.0) :: Nil).get should be(approximatelyEqualTo(0.707107))
    aggregator.evaluate((1, 0.4) :: (1, 0.5) :: (1, 0.6) :: Nil).get should be(approximatelyEqualTo(0.506623))
    aggregator.evaluate((1, 0.0) :: (1, 0.0) :: Nil).get should be(approximatelyEqualTo(0.0))
    aggregator.evaluate((2, 1.0) :: (1, 0.0) :: (1, 0.0) :: Nil).get should be(approximatelyEqualTo(0.707107))
    aggregator.evaluate((1, 0.4) :: (2, 0.5) :: (3, 0.6) :: Nil).get should be(approximatelyEqualTo(0.538516))
  }

  override def pluginObject = QuadraticMeanAggregator()

}