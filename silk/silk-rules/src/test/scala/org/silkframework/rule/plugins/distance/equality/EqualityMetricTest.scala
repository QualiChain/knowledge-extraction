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

package org.silkframework.rule.plugins.distance.equality

import org.silkframework.test.PluginTest
import org.silkframework.testutil.approximatelyEqualTo


class EqualityMetricTest extends PluginTest {
  lazy val metric = new EqualityMetric()
  val t = 1.0

  "EqualityMetric" should "return 1.0 if the string differ" in {
    metric.evaluate("aaa", "aab", t) should be(approximatelyEqualTo(1.0))
    metric.evaluate("123", "124", t) should be(approximatelyEqualTo(1.0))
    metric.evaluate("", "xxx", t) should be(approximatelyEqualTo(1.0))
  }

  "EqualityMetric" should "return 0.0 if the string are equal" in {
    metric.evaluate("aaa", "aaa", t) should be(approximatelyEqualTo(0.0))
    metric.evaluate("  _", "  _", t) should be(approximatelyEqualTo(0.0))
    metric.evaluate("123", "123", t) should be(approximatelyEqualTo(0.0))
  }

  override def pluginObject = metric
}