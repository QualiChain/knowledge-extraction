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

package org.silkframework.plugins.spatial.transformer

import org.silkframework.plugins.spatial.utils._
import org.silkframework.rule.input.SimpleTransformer
import org.silkframework.runtime.plugin.Plugin

/**
 * This plugin simplifies a geometry according to a given distance tolerance (It assumes that geometries are expressed in WKT and WGS 84 (latitude-longitude)).
 * In case that the literal is not a geometry, it is returned as it is.
 *
 * @author Panayiotis Smeros <psmeros@di.uoa.gr> (National and Kapodistrian University of Athens)
 */

@Plugin(
  id = "SimplifyTransformer",
  categories = Array("Spatial"),
  label = "Simplify Transformer",
  description = "Simplifies a geometry according to a given distance tolerance.")
case class SimplifyTransformer(distanceTolerance: Double = 0.0, preserveTopology: Boolean = false) extends SimpleTransformer {

  override def evaluate(value: String) = {
    Utils.simplifyGeometry(value, distanceTolerance, preserveTopology)
  }

}