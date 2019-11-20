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

package org.silkframework.plugins.spatial.distance

import org.scalatest.{FlatSpec, Matchers}

/**
 * Tests the MinDistance Metric.
 * @author Panayiotis Smeros <psmeros@di.uoa.gr> (National and Kapodistrian University of Athens)
 */


class MinDistanceMetricTest extends FlatSpec with Matchers {

  val metric = new MinDistanceMetric()

  //Same point.
  "MinDinstaceMetric test 1" should "return '0.0'" in {
    metric.evaluate("POINT (0 0)", "POINT (0 0)") should equal(0.0)
  }

  //Same centroid.
  "MinDinstaceMetric test 2" should "return '0.0'" in {
    metric.evaluate("POLYGON ((0 0, 0 2, 2 2, 2 0, 0 0))", "POINT (1 1)") should equal(0.0)

  }

  //Big threshold.
  "MinDinstaceMetric test 3" should "not return 'Double.PositiveInfinity'" in {
    metric.evaluate("POINT (37.9889023 23.7180747)", "POINT (37.9884826 23.7181476)", 100.0) should not equal(Double.PositiveInfinity)
  }

  //Small threshold.
  "MinDinstaceMetric test 4" should "return 'Double.PositiveInfinity'" in {
    metric.evaluate("POINT (37.9889023 23.7180747)", "POINT (37.9884826 23.7181476)", 10.0) should equal(Double.PositiveInfinity)
  }
}
