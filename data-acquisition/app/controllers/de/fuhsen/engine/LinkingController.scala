package controllers.de.fuhsen.engine

import javax.inject.Inject

import com.typesafe.config.ConfigFactory
import controllers.de.fuhsen.common.{ApiError, ApiResponse, ApiSuccess}
import controllers.de.fuhsen.wrappers.dataintegration.{EntityLinking, SilkConfig}
import play.Logger
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.ws.{WSClient, WSResponse}
import play.api.mvc.{Action, Controller}

import scala.concurrent.Future

class LinkingController @Inject()(ws: WSClient) extends Controller {

  def linkJobPostings = Action.async {
    Logger.info("Starting linking process on job postings")
    executeLinkingTask("","application/n-triples").map( r =>
      r match {
        case d: ApiSuccess => Ok(d.responseBody)
        case e: ApiError => InternalServerError(e.errorMessage)
      }
    )
  }

  private def executeLinkingTask(content: String, acceptType: String): Future[ApiResponse] = {
    val silkConfig = SilkConfig(
      projectId = ConfigFactory.load.getString("silk.socialApiProject.id"),
      linkingTaskId = ConfigFactory.load.getString("silk.linking.task.jobposting"),
      silkServerUrl = ConfigFactory.load.getString("silk.server.url")
    )
    val entityLinking = new EntityLinking(silkConfig)
    val linkRequest = ws.url(silkConfig.endpoint)
      .withHeaders("Content-Type" -> "application/xml")
      .withHeaders("Accept" -> acceptType)
    linkRequest.post(entityLinking.sparqlPointTemplate("http://dydra.com/collarad/edsatest/sparql",
                                                      "http://www.edsa-project.eu/edsa/demand/jooble",
                                                      "&auth_token="+ConfigFactory.load.getString("dydra.token"),
                                                      "http://dydra.com/collarad/edsatest/sparql",
                                                      "http://www.edsa-project.eu/edsa/demand/adzuna",
                                                      "&auth_token="+ConfigFactory.load.getString("dydra.token")))
      .map(convertToApiResponse("Silk linking service"))
  }

  private def convertToApiResponse(serviceName: String)(response: WSResponse): ApiResponse = {
    if (response.status >= 400) {
      ApiError(response.status, s"There was a problem with the $serviceName. Service response:\n\n" + response.body)
    } else if (response.status >= 300) {
      ApiError(response.status, s"$serviceName seems to be configured incorrectly, received a redirect.")
    } else {
      ApiSuccess(response.body)
    }
  }

}
