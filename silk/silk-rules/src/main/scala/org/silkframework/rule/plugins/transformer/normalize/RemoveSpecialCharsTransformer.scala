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
  id = "removeSpecialChars",
  categories = Array("Normalize"),
  label = "Remove special chars",
  description = "Remove special characters (including punctuation) from a string."
)
case class RemoveSpecialCharsTransformer() extends SimpleTransformer {
  private val compiledRegex = new Regex("[^\\d\\pL\\w]+")

  def evaluate(value: String) = {
    compiledRegex.replaceAllIn(value, "")
  }
}