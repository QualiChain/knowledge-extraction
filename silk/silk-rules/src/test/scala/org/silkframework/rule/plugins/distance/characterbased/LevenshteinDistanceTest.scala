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




class LevenshteinDistanceTest extends PluginTest {

  lazy val metric = new LevenshteinDistance()

  "LevenshteinDistance" should "return distance 0 for equal strings" in {
    metric.evaluate("kitten", "kitten") should equal(0)
    metric.evaluate("sitting", "sitting", 0.0) should equal(0)
  }

  "LevenshteinDistance" should "return distance 3 (kitten, sitting)" in {
    metric.evaluate("kitten", "sitting") should equal(3)
    metric.evaluate("sitting", "kitten") should equal(3)
    metric.evaluate("kitten", "sitting", 3.0) should equal(3)
    metric.evaluate("sitting", "kitten", 3.0) should equal(3)
  }

  "LevenshteinDistance" should "return distance 3 (Saturday, Sunday)" in {
    metric.evaluate("Saturday", "Sunday") should equal(3)
    metric.evaluate("Sunday", "Saturday") should equal(3)
  }

  "LevenshteinDistance" should "index correctly" in {
    (metric.indexValue("Sunday", 3, sourceOrTarget = false) matches metric.indexValue("Saturday", 3, sourceOrTarget = false)) should equal(true)
    (metric.indexValue("Sunday", 4, sourceOrTarget = false) matches metric.indexValue("Saturday", 4, sourceOrTarget = false)) should equal(true)
  }

  override def pluginObject = metric

//  "LevenshteinDistance" should "index '0' to the first block" in {
//    metric.indexValue("0", 0.0) should equal(Set(Seq(0)))
//  }
//
//  "LevenshteinDistance" should "index 'zzzzz' to the last block" in {
//    metric.indexValue("zzzzz", 0.0) should equal(Set(Seq(metric.blockCounts(0.0).head - 1)))
//  }

  // Invalid if q > 1:
  //  it should "generate one more index than the edit distance" in
  //  {
  //    val DPair(source, target) = randomValues(10, 5)
  //    val distance = metric.evaluate(source, target)
  //
  //    metric.index(source, distance).size should equal(distance + 1)
  //    metric.index(target, distance).size should equal(distance + 1)
  //  }
}

//object LevenshteinDistanceTest {
//  def main(args: Array[String]) {
//    val metric = new LevenshteinDistance()
//
//    for (run <- 0 until 100) {
//      val startTime = System.currentTimeMillis
//
//      for (i <- 0 until 100) {
//        val values = Seq.fill(100)(randomValues(30, 10))
//
//        metric.apply(values.map(_.source), values.map(_.target), 5)
//      }
//
//      val time = System.currentTimeMillis - startTime
//      println("Time: " + time)
//    }
//  }
//
//  /**
//   * Generates a pair of random strings with a specified maximum edit distance.
//   */
//  private def randomValues(size: Int, maxDistance: Int): DPair[String] = {
//    val sourceStr = Random.alphanumeric.take(size).mkString
//
//    val targetStr = randomEdits(sourceStr, maxDistance)
//
//    DPair(sourceStr, targetStr)
//  }
//
//  private def randomEdits(str: String, maxDistance: Int): String = {
//    Traversable.iterate(str, maxDistance + 1)(randomEdit).last
//  }
//
//  /**
//   * Modifies a string with a random edit operation.
//   */
//  private def randomEdit(str: String): String = {
//    val (prefix, suffix) = str.splitAt(Random.nextInt(str.length - 1))
//
//    Random.nextInt(3) match {
//      //Deletion
//      case 0 => prefix + suffix.tail
//      //Insertion
//      case 1 => prefix + Random.alphanumeric.head + suffix
//      //Substitution
//      case 2 => prefix + Random.alphanumeric.head + suffix.tail
//    }
//  }
//}