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

package org.silkframework.rule.plugins.distance.characterbased

import org.scalatest.{FlatSpec, Matchers}
import org.silkframework.test.PluginTest
import org.silkframework.testutil.approximatelyEqualTo


class QGramsMetricTest extends PluginTest {
  lazy val metric = new QGramsMetric()
  val t = 0.9

  "QGramsMetric" should "return 1.0 if the input strings do not share a single q-gram" in {
    metric.evaluate("abcd", "dcba", t) should be(approximatelyEqualTo(1.0))
  }

  "QGramsMetric" should "return 0.0 if the input strings are equal" in {
    metric.evaluate("abcd", "abcd", t) should be(approximatelyEqualTo(0.0))
  }

  "QGramsMetric" should "return (1.0 - matchingQGrams) / numQGrams" in {
    //q-grams = (#a, ab, b#) and (#a, ac, c#), matchingQGrams = 1, numQGrams = 5
    metric.evaluate("ab", "ac", t) should be(approximatelyEqualTo(4.0 / 5.0))
  }

  override def pluginObject = metric
}