package controllers.de.fuhsen.engine

import javax.inject.Inject
import java.util

import com.typesafe.config.ConfigFactory
import play.api.Logger
import org.apache.jena.rdf.model._
import org.apache.jena.riot.Lang
import org.apache.jena.vocabulary.{RDF, RDFS}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.{WSClient, WSResponse}
import play.api.mvc.{Action, Controller}
import scala.collection.{Seq, mutable}
import play.api.libs.json._
import scala.collection.JavaConversions._
import scala.concurrent.Future
import utils.dataintegration.RDFUtil
/**
  * Created by dcollarana on 5/19/2017.
  */
class QMinerController @Inject()(ws: WSClient) extends Controller {

  val schema = collection.immutable.HashMap(
    "date" ->         "http://schema.org/datePosted",
    "description" ->  "http://schema.org/description",
    "title" ->        "http://schema.org/title",
    "url" ->          "http://schema.org/url",
    "forOrganization" -> "http://schema.org/hiringOrganization",
    "inLocation.name" -> "http://schema.org/jobLocation",
    "inLocation.long" -> "http://www.edsa-project.eu/edsa/wgs84_pos#long",
    "inLocation.lat" -> "http://www.edsa-project.eu/edsa/wgs84_pos#lat",
    "inLocation.geo.long" -> "http://www.w3.org/2003/01/geo/wgs84_pos#long",
    "inLocation.geo.lat" -> "http://www.w3.org/2003/01/geo/wgs84_pos#lat",
    "inLocation.uri" -> "http://schema.org/jobLocationUri",
    "inCountry" -> "http://www.edsa-project.eu/edsa#countryCode",
    "requiredSkills" -> "http://www.edsa-project.eu/edsa#requiresSkill",
    "foundIn" -> "http://schema.org/source"
  )

  def send(date: String, source: String, limit: Int, offset: Int) = Action.async {
    Logger.info("Sending Json value")

    val query =
      s"""
         |PREFIX edsa: <http://www.edsa-project.eu/edsa#>
         |PREFIX sdo: <http://schema.org/>
         |
         |CONSTRUCT { ?s ?p ?o }
         |WHERE { GRAPH <http://www.edsa-project.eu/edsa/demand/$source> {
         |   { ?s ?p ?o } .
         |   {
         |      SELECT DISTINCT ?s WHERE {
         |        ?s a edsa:JobPosting .
         |        ?s sdo:datePosted ?date .
         |        BIND(strdt(?date, xsd:date) AS ?d)
         |        FILTER (?d > "$date"^^xsd:date) }
         |      ORDER BY ?s
         |      LIMIT $limit
         |      OFFSET $offset
         |   }
         |} }
          """.stripMargin

    val responseOne = ws.url(ConfigFactory.load.getString("dydra.endpoint.sparql"))
      .withQueryString("query" -> query)
      .withHeaders("Accept" -> "application/n-triples")
      .get

    responseOne.map { response =>
      if (response.status >= 300) {
        InternalServerError(s"${response.status} server error in the dydra service ${response.body}")
      } else {
        if (response.body.isEmpty) {
          Ok("NO_MORE_RESULTS")
        }
        else {
          val json = convertToJson(response.body)
          val responseTwo = ws.url(ConfigFactory.load.getString("qminer.endpoint.url"))
            .post(json)
          responseTwo.map { finalResponse =>
            if (finalResponse.status >= 300) {
              InternalServerError(s"${finalResponse.status} server error in the qminer service ${finalResponse.body}")
            }
          }
          Ok(json)
        }
      }
    }
  }

  def convertToJson(response:String) : JsValue = {
    if(response.isEmpty) return JsArray()
    val model = RDFUtil.rdfStringToModel(response, Lang.TTL)
    val iterator = model.listSubjects.toList
    var json = JsArray()
    iterator.map { x =>
      var jsObject = processStatement(model, x)
      json =  json :+ jsObject
    }
    json
  }

  def processStatement(model: Model, subj: Resource): JsValue = {
    val predicates = model.listStatements(subj, null, null).toList
    val date = getPredicateValue(predicates, schema.get("date"))
    val description = getPredicateValue(predicates, schema.get("description"))
    val title = getPredicateValue(predicates, schema.get("title"))
    val url = getPredicateValue(predicates, schema.get("url"))
    val uri = subj.toString
    val forOrganization = getPredicateValue(predicates, schema.get("forOrganization"))
    val foundIn = getPredicateValue(predicates, schema.get("foundIn"))
    val skills = getSkills(predicates)
    val countryCode = getPredicateValue(predicates, schema.get("inCountry"))
    val location = getLocation(predicates, countryCode)
    val countryName = getCountryName(countryCode)
    val coord = countryLocation(countryCode)
      val json: JsValue = Json.obj(
        "date" -> date,
        "description" -> description,
        "title" -> title,
        "url" -> url,
        "uri" -> uri,
        "inCountry" -> Json.obj(
          "name" -> countryName,
          "coord" -> coord
        ),
        "inLocation" -> location,
        "foundIn" -> Json.obj(
          "name" -> foundIn
        ),
        "requiredSkills" -> skills,
        "forOrganization" -> forOrganization
      )
      json
    }


  def getPredicateValue(predicates: java.util.List[Statement], property:Option[String]):String = {
    var value = ""
    predicates.map { predicate =>
      if(predicate.getPredicate().toString == property.get) value = predicate.getObject().toString
    }
    value
  }

  def getSkills(predicates: java.util.List[Statement]):JsArray = {
    var skills = JsArray()
    predicates.map { predicate =>
      if(predicate.getPredicate().toString == schema.get("requiredSkills").get){
        var jobUri = predicate.getObject().toString
        var jobName = jobUri.substring(33)
        var job = Json.obj(
          "name" -> jobName,
          "uri" -> jobUri
        )
        skills = skills :+ job
      }
    }
    skills
  }

  def getLocation(predicates: java.util.List[Statement], countryCode: String): JsObject = {
    val inLocationName = getPredicateValue(predicates, schema.get("inLocation.name"))
    val inLocationUri = getPredicateValue(predicates, schema.get("inLocation.uri"))
    var inLocationLong = getPredicateValue(predicates, schema.get("inLocation.long")).stripPrefix("\\\"").stripSuffix("\\\"").trim
    var inLocationLat = getPredicateValue(predicates, schema.get("inLocation.lat")).stripPrefix("\\\"").stripSuffix("\\\"").trim
    if(inLocationLong.isEmpty) inLocationLong = getPredicateValue(predicates, schema.get("inLocation.geo.long")).split("\\^\\^")(0)
    if(inLocationLat.isEmpty) inLocationLat = getPredicateValue(predicates, schema.get("inLocation.geo.lat")).split("\\^\\^")(0)
    var inLocationCoord = Array[Double]()
    if(inLocationLong.isEmpty || inLocationLat.isEmpty){
      inLocationCoord = countryLocation(countryCode)
    }
    else{
      inLocationCoord = Array(inLocationLat.toDouble, inLocationLong.toDouble)
    }
    val json = Json.obj(
      "name" -> inLocationName,
      "coord" -> inLocationCoord,
      "uri" -> inLocationUri
    )
    json
  }

  def receive = Action { request =>
    Logger.info("Starting to receive the Json")
    val json = request.body.asJson
    json match {
      case Some(value) =>
        Logger.info("Json value received")
        Logger.info(value.toString)
        Ok
      case None => BadRequest("No Json Sent!!!")
    }
  }

  def countryLocation(country: String): Array[Double] = {
    country match {
      case "at" =>Array(47.516231, 14.550072)
      case "ba" =>Array(43.915886, 17.679076)
      case "be" =>Array(50.503887, 4.469936)
      case "bg" =>Array(42.733883, 25.48583)
      case "by" =>Array(53.709807, 27.953389)
      case "ch" =>Array(46.818188, 8.227512)
      case "cz" =>Array(49.817492, 15.472962)
      case "de" =>Array(51.165691, 10.451526)
      case "dk" =>Array(56.26392, 9.501785)
      case "es" =>Array(40.463667, - 3.74922)
      case "fi" =>Array(61.92411, 25.748151)
      case "fr" =>Array(46.227638, 2.213749)
      case "gb" =>Array(55.378051, - 3.435973)
      case "gr" =>Array(39.074208, 21.824312)
      case "hr" =>Array(45.1, 15.2)
      case "hu" =>Array(47.162494, 19.503304)
      case "ie" =>Array(53.41291, - 8.24389)
      case "nl" =>Array(52.132633, 5.291266)
      case "no" =>Array(60.472024, 8.468946)
      case "pl" =>Array(51.919438, 19.145136)
      case "pt" =>Array(39.399872, - 8.224454)
      case "ro" =>Array(45.943161, 24.96676)
      case "ru" =>Array(61.52401, 105.318756)
      case "se" =>Array(60.128161, 18.643501)
      case "sk" =>Array(48.669026, 19.699024)
      case "ua" =>Array(48.379433, 31.16558)
      case _ =>Array(0.0, 0.0)
    }
  }

  def getCountryName(country: String): String = {
    country match {
      case "at" => "Austria"
      case "ba" =>"Bosnia and Herzegovina"
      case "be" =>"Belgium"
      case "bg" =>"Bulgaria"
      case "by" =>"Belarus"
      case "ch" =>"Switzerland"
      case "cz" =>"Czech Republic"
      case "de" =>"Germany"
      case "dk" =>"Denmark"
      case "es" =>"Spain"
      case "fi" =>"Finland"
      case "fr" =>"France"
      case "gb" =>"United Kingdom"
      case "gr" =>"Greece"
      case "hr" =>"Croatia"
      case "hu" =>"Hungary"
      case "ie" =>"Ireland"
      case "nl" =>"Netherlands"
      case "no" =>"Norway"
      case "pl" =>"Poland"
      case "pt" =>"Portugal"
      case "ro" =>"Romania"
      case "ru" =>"Russia"
      case "se" =>"Sweden"
      case "sk" =>"Slovakia"
      case "ua" =>"Ukraine"
      case _ =>""
    }
  }
}

