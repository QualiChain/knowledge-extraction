/*
 * Copyright (C) 2016 EIS Uni-Bonn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package controllers.de.fuhsen.wrappers

import com.typesafe.config.ConfigFactory
import controllers.de.fuhsen.wrappers.dataintegration.{SilkTransformableTrait, SilkTransformationTask}

/**
  * Wrapper for the Linked Leaks REST API.
  */
class IndeedWrapper extends RestApiWrapperTrait with SilkTransformableTrait {

  /** Query parameters that should be added to the request. */
  override def queryParams: Map[String, String] = Map("publisher" -> ConfigFactory.load.getString("indeed.search.publisher"),
    //"q" -> "java",
    "l" -> "",
    "sort" -> "",
    "radius" -> "",
    "st" -> "",
    "jt" -> "",
    //"start" -> "",
    "limit" -> "25",
    "fromage" -> "",
    "filter" -> "",
    "latlong" -> "",
    //"co" -> "de",
    "chnl" -> "",
    "userip" -> "1.2.3.4",
    "v" -> "2")

  /** Headers that should be added to the request. */
  override def headersParams: Map[String, String] = Map( "Content-Type" -> "application/xml", "Accept" -> "application/json")

  /** Returns for a given query string the representation as query parameter for the specific API. */
  override def searchQueryAsParam(queryString: String): Map[String, String] = {
    Map("q" -> queryString)
  }

  /** The REST endpoint URL */
  override def apiUrl: String = ConfigFactory.load.getString("indeed.search.url")

  /**
    * Returns the globally unique URI String of the source that is wrapped. This is used to track provenance.
    */
  override def sourceLocalName: String = "indeed"

  /** SILK Transformation Trait **/
  override def silkTransformationRequestTasks = Seq(
    SilkTransformationTask(
      transformationTaskId = "IndeedTransformationTask",
      createSilkTransformationRequestBody(
        basePath = "/results/result",
        uriPattern = "http://www.edsa-project.eu/jobpost/{jobkey}"
      )
    )
  )

  /** The type of the transformation input. */
  override def datasetPluginType: DatasetPluginType = DatasetPluginType.XmlDatasetPlugin

  /** The project id of the Silk project */
  override def projectId: String = ConfigFactory.load.getString("silk.socialApiProject.id")

  override def max_results: Int = 25
}
