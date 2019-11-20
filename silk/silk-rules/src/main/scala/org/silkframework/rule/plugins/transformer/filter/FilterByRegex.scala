package org.silkframework.rule.plugins.transformer.filter

import org.silkframework.rule.input.Transformer
import org.silkframework.runtime.plugin.Plugin

/**
 * Removes all strings that do NOT match a regex.
 */
@Plugin(
  id = "filterByRegex",
  categories = Array("Filter"),
  label = "filter by regex",
  description = "Removes all strings that do NOT match a regex. If 'negate' is true, only strings will be removed that match the regex."
)
case class FilterByRegex(regex: String, negate: Boolean = false) extends Transformer {

  override def apply(values: Seq[Seq[String]]): Seq[String] = {
    if(!negate) {
      values.head.filter(str => str.matches(regex))
    } else {
      values.head.filterNot(str => str.matches(regex))
    }
  }
}
