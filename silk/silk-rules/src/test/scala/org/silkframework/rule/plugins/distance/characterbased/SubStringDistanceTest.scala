package org.silkframework.rule.plugins.distance.characterbased

import org.silkframework.test.PluginTest

/**
  * Substring distance measure. Compares overlap of substrings of two strings and factors in dissimilar substrings.
  */
class SubStringDistanceTest extends PluginTest {
  behavior of "Substring distance"

  lazy val substring = new SubStringDistance()
  def eval(str1: String, str2: String): Double = substring.evaluate(str1, str2, 1.0)

  it should "calculate correct relative distances " in {
    val str1 = "ABCDEF"
    val str2 = str1 + "123"
    val str3 = str1 + "4567"
    eval(str1, str2) shouldBe < (eval(str1, str3))
    eval(str1, str3) shouldBe < (eval(str2, str3))
  }

  it should "use the granularity correctly" in {
    val s = new SubStringDistance("2")
    val str1 = "AB12"
    val str2 = "12AB"
    substring.indexValue(str1, 1.0, sourceOrTarget = false) should not be s.indexValue(str1, 1.0, sourceOrTarget = false)
    eval(str1, str2) shouldBe 1.0
    s.evaluate(str1, str2) shouldBe 0.0
  }

  it should "match strings smaller than 'granularity' if they match exactly" in {
    val str1 = "id"
    val str2 = "id"
    substring.indexValue(str1, Double.MaxValue, sourceOrTarget = false).size shouldBe 1
    eval(str1, str2) shouldBe 0.0
  }

  override def pluginObject: SubStringDistance = substring
}