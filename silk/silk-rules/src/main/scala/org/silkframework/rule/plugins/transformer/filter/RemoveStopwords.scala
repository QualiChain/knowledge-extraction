package org.silkframework.rule.plugins.transformer.filter

import org.silkframework.rule.input.SimpleTransformer
import org.silkframework.runtime.plugin.Plugin
import org.silkframework.runtime.resource.Resource

@Plugin(
  id = "removeStopwords",
  categories = Array("Filter"),
  label = "Remove stopwords",
  description = "Removes stopwords from all values. Each line in the stopword list contains a stopword. The separator defines a regex that is used for detecting words."
)
case class RemoveStopwords(stopwordList: Resource, separator: String = "[\\s-]+") extends SimpleTransformer {

  val stopwords = stopwordList.loadAsString.split("\n").toSet

  val regex = separator.r

  override def evaluate(value: String): String = {
    val result = new StringBuilder
    for(word <- regex.split(value) if !stopwords.contains(word)) {
      result.append(word)
      result.append(" ")
    }
    result.toString()
  }
}
