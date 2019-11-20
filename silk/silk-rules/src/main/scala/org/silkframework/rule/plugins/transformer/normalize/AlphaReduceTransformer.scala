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

package org.silkframework.rule.plugins.transformer.normalize

import org.silkframework.rule.input.SimpleTransformer
import org.silkframework.runtime.plugin.Plugin

import scala.util.matching.Regex

@Plugin(
  id = "alphaReduce",
  categories = Array("Normalize"),
  label = "Alpha reduce",
  description = "Strips all non-alphabetic characters from a string. Spaces are retained."
)
case class AlphaReduceTransformer() extends SimpleTransformer {
  private val compiledRegex = new Regex("[^\\s\\pL]+")

  override def evaluate(value: String) = {
    compiledRegex.replaceAllIn(value, "")
  }
}