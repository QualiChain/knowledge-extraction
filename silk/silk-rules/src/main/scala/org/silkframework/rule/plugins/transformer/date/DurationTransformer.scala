package org.silkframework.rule.plugins.transformer.date

import javax.xml.bind.DatatypeConverter
import javax.xml.datatype.DatatypeFactory

import org.silkframework.rule.input.Transformer
import org.silkframework.runtime.plugin.Plugin

@Plugin(
  id = "duration",
  categories = Array("Date"),
  label = "Duration",
  description = "Computes the time difference between two data times."
)
case class DurationTransformer() extends Transformer {

  private val datatypeFactory = DatatypeFactory.newInstance()

  override def apply(values: Seq[Seq[String]]): Seq[String] = {
    // Check if we did get values from two transformers
    if (values.size < 2) {
      // We cannot build a difference from a single value
      values.head
    } else {
      // Compute a duration for each pair of values from both transformers
      for (v1 <- values.head; v2 <- values(1)) yield {
        duration(v1, v2)
      }
    }
  }

  private def duration(v1: String, v2: String) = {
    // Parse xsd:date values
    val date1 = DatatypeConverter.parseDateTime(v1)
    val date2 = DatatypeConverter.parseDateTime(v2)
    // Compute duration
    val duration = datatypeFactory.newDuration(date2.getTimeInMillis - date1.getTimeInMillis)
    // Convert to xsd:duration
    duration.toString
  }
}