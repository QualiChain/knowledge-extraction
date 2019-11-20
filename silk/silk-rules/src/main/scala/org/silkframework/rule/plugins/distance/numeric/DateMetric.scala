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

package org.silkframework.rule.plugins.distance.numeric

import javax.xml.datatype.DatatypeFactory

import org.silkframework.entity.Index
import org.silkframework.rule.similarity.SimpleDistanceMeasure
import org.silkframework.runtime.plugin.Plugin

import scala.math._

@Plugin(
  id = "date",
  categories = Array("Numeric"),
  label = "Date",
  description = "The distance in days between two dates ('YYYY-MM-DD' format).")
case class DateMetric() extends SimpleDistanceMeasure {

  import DateMetric._

  private val minDays = 0

  private val maxDays = 3000 * 365

  private final val millisPerDay = 1000 * 60 * 60 * 24

  override def evaluate(str1: String, str2: String, threshold: Double) = {
    try {
      val date1 = dataTypeFactory.newXMLGregorianCalendar(str1)

      val date2 = dataTypeFactory.newXMLGregorianCalendar(str2)

      val days1 = date1.toGregorianCalendar.getTimeInMillis / millisPerDay
      val days2 = date2.toGregorianCalendar.getTimeInMillis / millisPerDay

      abs(days1 - days2).toDouble
    } catch {
      case ex: IllegalArgumentException => Double.PositiveInfinity
    }
  }

  override def indexValue(str: String, limit: Double, sourceOrTarget: Boolean): Index = {
    try {
      val date = dataTypeFactory.newXMLGregorianCalendar(str)
      val days = date.toGregorianCalendar.getTimeInMillis / millisPerDay
      Index.continuous(days, minDays, maxDays, limit)
    } catch {
      case ex: IllegalArgumentException => Index.empty
    }
  }
}

object DateMetric {
  private val dataTypeFactory = DatatypeFactory.newInstance
}
