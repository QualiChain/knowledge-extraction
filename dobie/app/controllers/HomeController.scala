package controllers

import javax.inject._
import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import services.annotation.Main
import scala.collection.JavaConversions._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def annotate = Action { request =>
    val json = request.body.asJson
    json match {
      case Some(value) =>
        val tasks = (value \ "tasks").as[List[Skill]]
        val files = new java.util.ArrayList[java.util.Map.Entry[String,String]]
        //tasks.map( t => files.add(createDocument(t.uri, t.jobDescription)))
        tasks.map( t => files.add(new java.util.AbstractMap.SimpleEntry(t.label,t.jobDescription)))
        val m = new Main()
        val result = buildResponse(m.Pipeline(files))
        Logger.info("Size of files: "+files.size.toString)
        Ok(result)
      case None => BadRequest("No Json Sent!!!")
    }
  }

  private def buildResponse(files : java.util.List[String]) : String = {
    var response = "<SkillAnnotations>"
    files.foreach(f => response += f.replaceAll("\\<\\?xml version='1.0' encoding='windows-1252'\\?\\>", ""))
    response + "</SkillAnnotations>"
  }

  implicit val similarTaskReader = Json.reads[Skill]
  implicit val similarTaskWrites = Json.writes[Skill]

}

case class Skill (label: String, jobDescription: String)
