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

import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

import com.typesafe.config.ConfigFactory
import controllers.Application
import controllers.de.fuhsen.wrappers.dataintegration.{EntityLinking, SilkConfig, SilkTransformableTrait}
import controllers.de.fuhsen.wrappers.security.{RestApiOAuth2Trait, RestApiOAuthTrait}
import org.apache.jena.graph.Triple
import org.apache.jena.query.{Dataset, DatasetFactory, QueryExecutionFactory, QueryFactory}
import org.apache.jena.rdf.model.{Model, ModelFactory, Property, RDFNode, Resource, ResourceFactory, Statement, StmtIterator}
import org.apache.jena.riot.Lang
import org.apache.jena.sparql.core.Quad
import play.Logger
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json._
import play.api.libs.oauth.OAuthCalculator
import play.api.libs.ws.{WSClient, WSRequest, WSResponse}
import play.api.mvc.{Action, Controller, Result}
import utils.dataintegration.RDFUtil._
import utils.dataintegration.{RDFUtil, RequestMerger, UriTranslator}
import controllers.de.fuhsen.common.{ApiError, ApiResponse, ApiSuccess}

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.collection.JavaConversions.asScalaIterator
import scala.xml.Elem

/**
  * Handles requests to API wrappers. Wrappers must at least implement [[RestApiWrapperTrait]].
  * Depending on implemented traits also does transformation, linking and merging of entities.
  */
class WrapperController @Inject()(ws: WSClient) extends Controller {
  val requestCounter = new AtomicInteger(0)

  def search(wrapperId: String, query: String) = Action.async {
    WrapperController.wrapperMap.get(wrapperId) match {
      case Some(wrapper) =>
        Logger.info(s"Starting $wrapperId Search with query: " + query)
        execQueryAgainstWrapper(query, wrapper, None, None) map {
          case errorResult: ApiError =>
            InternalServerError(errorResult.errorMessage + " API status code: " + errorResult.statusCode)
          case success: ApiSuccess =>
            Ok(success.responseBody)
        }
      case None =>
        Future(NotFound("Wrapper " + wrapperId + " not found! Supported wrapper: " +
          WrapperController.sortedWrapperIds.mkString(", ")))
    }
  }

  def edsa_rdf2json_transform = Action {
    var json_from_dydra = None
    val dydra_push_response =
      ws.url(ConfigFactory.load.getString("dydra.endpoint.sparql"))
        .withQueryString("query"->ConfigFactory.load.getString("dydra.endpoint.query"))
        .withHeaders("Accept"->"application/sparql-results+json")
        .get()
        .map(
          response => rdf2json(Json.parse(response.body))
      )

    val json_to_push = Await.result(dydra_push_response, Duration.Inf)

    val qminer_push = ws.url(ConfigFactory.load.getString("qminer.endpoint.url"))
      .post(json_to_push)
      .map( response => Logger.info(response.body))

    Await.result(qminer_push, Duration.Inf)

    Ok("FINISHED QMINER PUSHING")
  }

  def rdf2json(json_from_dydra: JsValue): String =  {
      Logger.info(Json.stringify(json_from_dydra))
      val to_return = """
                        |[{
                        |   "date": "2017-10-02T05:24:32Z",
                        |   "description": "... availability and consistency for all stakeholders. About you : Bachelor\u2019s / master\u2019s degree in a STEM discipline or relevant work experience in the field of scientific <strong>computing<\/strong>. Possess ...  <strong>advanced<\/strong> skills in SQL, PostgreSQL or Python. Well versed in relational databases, data and data analysis. Proficient in handling large data sets and ideally have experience in data ...",
                        |   "title": "Data Warehouse Engineer Master Blaster",
                        |   "uri": "eyJhbGciOiJIUzI1NiJ0.eyJzIjoiZUFzTmhhYkpSNXVsSTJjTUREazBFZyIsImkiOiI0NDMzNTA0NzcifQ.nq-m-g-hZ3u1CQP0Um3EV6cosjv0C3peVXlluV8hwxc",
                        |   "url": "https://www.adzuna.de/land/ad/443350477?se=eAsNhabJR5ulI2cMDDk0Eg&utm_medium=api&utm_source=bf155b6a&v=E2048EFE2E9F3342709D855CEA5FED6917E9681A",
                        |   "inLocation": {
                        |    "name": "Seehof",
                        |    "coord": [52.47122, 13.32833],
                        |    "uri": "http://sws.geonames.org/2833755"
                        |   },
                        |   "inCountry": {
                        |    "name": "Germany",
                        |    "coord": [52.47122, 13.32833],
                        |    "uri": "http://sws.geonames.org/2921044"
                        |   },
                        |   "foundIn": {
                        |    "name": "Jooble"
                        |   },
                        |   "requiredSkills": [{
                        |    "name": "data warehouse",
                        |    "uri": "http://www.edsa-project.eu/skill/data warehouse"
                        |   }],
                        |   "forOrganization": {
                        |    "title": "Blacklane GmbH"
                        |   }
                        |  },
                        |  {
                        |   "date": "2016-10-02T05:24:32Z",
                        |   "description": "...  availability and consistency for all stakeholders. About you : Bachelor\u2019s / master\u2019s degree in a STEM discipline or relevant work experience in the field of scientific <strong>computing<\/strong>. Possess ...  <strong>advanced<\/strong> skills in SQL, PostgreSQL or Python. Well versed in relational databases, data and data analysis. Proficient in handling large data sets and ideally have experience in data ...",
                        |   "title": "Data Warehouse Engineer (f/m)",
                        |   "uri": "eyJhbGciOiJIUzI1NiJ9.eyJzIjoiZUFzTmhhYkpSNXVsSTJjTUREazBFZyIsImkiOiI0NDMzNTA0NzcifQ.nq-m-g-hZ3u1CQP0Um3EV6cosjv0C3peVXlluV8hwxc",
                        |   "url": "https://www.adzuna.de/land/ad/443350477?se=eAsNhabJR5ulI2cMDDk0Eg&utm_medium=api&utm_source=bf155b6a&v=E2048EFE2E9F3342709D855CEA5FED6917E9681F",
                        |   "inLocation": {
                        |    "name": "Seehof",
                        |    "coord": [52.47122, 13.32833],
                        |    "uri": "http://sws.geonames.org/2833755"
                        |   },
                        |   "inCountry": {
                        |    "name": "Germany",
                        |    "coord": [52.47122, 13.32833],
                        |    "uri": "http://sws.geonames.org/2921044"
                        |   },
                        |   "foundIn": {
                        |    "name": "Adzuna"
                        |   },
                        |   "requiredSkills": [{
                        |     "name": "data warehouse",
                        |     "uri": "http://www.edsa-project.eu/skill/data warehouse"
                        |    },
                        |    {
                        |     "name": "sql",
                        |     "uri": "http://www.edsa-project.eu/skill/sql"
                        |    },
                        |    {
                        |     "name": "postgresql",
                        |     "uri": "http://www.edsa-project.eu/skill/postgresql"
                        |    },
                        |    {
                        |     "name": "relational database",
                        |     "uri": "http://www.edsa-project.eu/skill/relational database"
                        |    }
                        |   ],
                        |   "foundConcepts": [{
                        |     "name": "Cloud Computing",
                        |     "uri": "http://de.wikipedia.org/wiki/Cloud_Computing"
                        |    },
                        |    {
                        |     "name": "Data-Warehouse",
                        |     "uri": "http://de.wikipedia.org/wiki/Data-Warehouse"
                        |    },
                        |    {
                        |     "name": "Warehouse",
                        |     "uri": "http://de.wikipedia.org/wiki/Warehouse"
                        |    },
                        |    {
                        |     "name": "Toningenieur",
                        |     "uri": "http://de.wikipedia.org/wiki/Toningenieur"
                        |    },
                        |    {
                        |     "name": "Klammer (Zeichen)",
                        |     "uri": "http://de.wikipedia.org/wiki/Klammer_(Zeichen)"
                        |    }
                        |   ],
                        |   "forOrganization": {
                        |    "title": "Blacklane GmbH"
                        |   }
                        |  }
                        |]
                      """
      return to_return
  }

  def suply_analysis(edsaWrapperId: String) = Action {

    Logger.info("STARTING SUPPLY")

    var requestMerger = new RequestMerger()
    val wrapper = WrapperController.wrapperMap.get(edsaWrapperId).get
    var exists_next_page = true
    var page_count = 1
    while(exists_next_page) {
      var res = Await.result(execQueryAgainstWrapper("", wrapper, Option(page_count.toString), None), Duration.Inf)
      res match {
        case ApiSuccess(responseBody) =>
          Logger.debug("AFTER-SILK: ")
          Logger.debug(responseBody)
          var current_model = rdfStringToModel(responseBody, Lang.TURTLE.getName)
          val countQuery = QueryFactory.create(
            s"""
               |SELECT (COUNT(?name) as ?count)
               |WHERE {?s <http://schema.org/name> ?name .
               |}
                """.stripMargin)
          val count_ids = QueryExecutionFactory.create(countQuery, current_model).execSelect()
          val value = count_ids.next.getLiteral("count").getValue.asInstanceOf[Int]
          Logger.info("Count: "+ value)
          value compare 0 match {
            case 0 => exists_next_page = false
            case -1 => page_count += 1
            case 1 => page_count += 1 //No deberia pasar nunca.
          }
          requestMerger.addWrapperResult(geonamesEnrichment(current_model), wrapper.sourceUri)

        case ApiError(status, message) =>
          Logger.error("ERROR: Executing the query returned a status code of" + status + " - Message: " + message)
          exists_next_page = false
          None
      }
    }

    val serializedN3:String = requestMerger.serializeMergedModel(Lang.N3)
    var res_dydra = Await.result(push2Dydra(serializedN3, ConfigFactory.load.getString("dydra.supply_analysis.graph")), Duration.Inf)

    Logger.info("FINISHED SUPPLY")
    Ok("FINISHED SUPPLY")
  }

  def push2Dydra(n3_model: String, graph: String): Future[String] = {
    val dydra_push_response =
      ws.url(ConfigFactory.load.getString("dydra.endpoint.url"))
        .withQueryString("auth_token"->ConfigFactory.load.getString("dydra.token")).withQueryString("graph"-> graph).withHeaders("Content-Type"->"text/rdf+n3").post(n3_model).map(
        response => "DYDRA.RESPONSE: "+response.body
      )

    dydra_push_response
  }

  def demand_analysis(edsaWrapperId: String, country: Option[String]) = Action {

    Logger.info("STARTING DEMAND")

    val model_skills: Model = ModelFactory.createDefaultModel()

    //Step 1) Load Skills and Country
    model_skills.read("EDSA_docs/skillNames.ttl")
    val skill_list = ListBuffer[String]()
    val skillsQuery = QueryFactory.create(
      s"""
         |PREFIX ns3: <http://www.edsa-project.eu/edsa#>
         |SELECT ?skill WHERE {
         |?s ns3:lexicalValue ?skill .
         |}
      """.stripMargin)
    val resultSet_skills = QueryExecutionFactory.create(skillsQuery, model_skills).execSelect()
    while (resultSet_skills.hasNext) {
      skill_list.append(resultSet_skills.next.get("skill").toString)
    }

    val country_list = ListBuffer[String]()

    country match {
      case Some(value) =>
        country_list.append(value)
      case None =>
        val model: Model = ModelFactory.createDefaultModel()
        model.read("EDSA_docs/countries_europe_eu_member_status.rdf")

        val keywordQuery = QueryFactory.create(
          s"""
             |PREFIX gn:<http://www.geonames.org/ontology#>
             |SELECT ?country WHERE {
             |?s gn:name ?country .
             |}
      """.stripMargin)
        val resultSet = QueryExecutionFactory.create(keywordQuery, model).execSelect()
        while (resultSet.hasNext) {
          countryToISO8601(resultSet.next.get("country").toString) match {
            case Some(value) => country_list.append(value)
            case None =>
          }
        }
    }

    Logger.info(s"Keywords: $skill_list and Countries: $country_list")

    //var requestMerger = new RequestMerger()
    val wrapper = WrapperController.wrapperMap.get(edsaWrapperId).get

    //Step 2) Loop to query the services for skill x country
    for(x <- country_list ;y <- skill_list){
      var exists_next_page = true
      var page_count = 1
      while(exists_next_page) {

        //Step 3) Calling the REST API services
        var res = Await.result(execQueryAgainstWrapper(y, wrapper, Option(page_count.toString), Option(x)), Duration.Inf)
        res match {
          case ApiSuccess(responseBody) =>
            Logger.debug("AFTER-SILK: ")
            Logger.debug(responseBody)

            //API Cursoring calculation
            var current_model = rdfStringToModel(responseBody, Lang.TURTLE.getName)
            val countQuery = QueryFactory.create(
              s"""
                 |PREFIX el:<http://www.semanticweb.org/elisasibarani/ontologies/2016/0/untitled-ontology-51#>
                 |SELECT (COUNT(DISTINCT ?id) as ?count)
                 |WHERE {?s el:id ?id .
                 |}
                  """.stripMargin)
            val count_ids = QueryExecutionFactory.create(countQuery, current_model).execSelect()

            val value = count_ids.next.getLiteral("count").getValue.asInstanceOf[Int]
            Logger.info("Count: "+ value)
            value compare wrapper.max_results match {
              case 0 => page_count += 1
              case -1 => exists_next_page = false
              case 1 => page_count += 1 //No deberia pasar nunca.
            }
            //Step 4) Enrichment
            val modelWithCountries = countryEnrichment(current_model, x)
            val modelWithGeo = geonamesEnrichment(modelWithCountries)
            Logger.info("Model size with Geo: "+modelWithGeo.size)
            val modelWithSkills = skillsEnrichment(current_model)
            val finalModel = modelWithGeo.add(modelWithSkills)

            //Step 5) Storing
            Logger.info("Storing final model: "+finalModel.size)
            var res_dydra = Await.result(push2Dydra(RDFUtil.modelToTripleString(finalModel, Lang.N3), ConfigFactory.load.getString("dydra.demand_analysis.graph")+"/"+wrapper.sourceLocalName), Duration.Inf)
            Logger.info("Stored: "+ res_dydra)
            //Removed because we store in every result page
            //requestMerger.addWrapperResult(finalModel, wrapper.sourceUri)

          case ApiError(status, message) =>
            Logger.error("ERROR: Executing the query returned a status code of" + status + " - Message: " + message)
            exists_next_page = false
            None
        }
      }

      //Removed because we store in every result page
      /*
      val serializedN3 : String = requestMerger.serializeMergedModel(Lang.N3)
      var res_dydra = Await.result(push2Dydra(serializedN3, ConfigFactory.load.getString("dydra.demand_analysis.graph")+"/"+wrapper.sourceLocalName), Duration.Inf)
      Logger.info("FINISHED: " + x + " - " + y + " - " + res_dydra)
      requestMerger = new RequestMerger()
      */
      Logger.info("FINISHED: " + x + " - " + y)

    }

    Logger.info("FINISHING DEMAND")
    Ok("FINISHED")

  }

  private def countryEnrichment(model: Model, countryCode: String) : Model = {
    Logger.info("Country Enrichment Process")
    val query = QueryFactory.create(
      s"""
         |PREFIX edsa: <http://www.edsa-project.eu/edsa#>
         |
         |CONSTRUCT { ?s edsa:countryCode "$countryCode" }
         |WHERE {
         |    ?s a edsa:JobPosting .
         |}
          """.stripMargin)
    val modelWithCountries = QueryExecutionFactory.create(query, model).execConstruct()
    model.add(modelWithCountries)
  }

  private def geonamesEnrichment(model: Model): Model = {

    if (ConfigFactory.defaultApplication.getBoolean("enrichment.geonames.enabled")) {
      Logger.info("GeoNames Enrichment Process")
      var iter: StmtIterator = model.listStatements(null, model.createProperty("http://schema.org/jobLocation"), null);

      val future_statements = ListBuffer[Future[Model]]()
      val complete_model = ModelFactory.createDefaultModel()

      while (iter.hasNext()) {
        var stmt: Statement = iter.nextStatement();
        // get next statement
        var subject: Resource = stmt.getSubject();
        // get the subject
        var predicate: Property = stmt.getPredicate();
        // get the predicate
        var rdf_object: RDFNode = stmt.getObject(); // get the object

        val future_stm =
          ws.url(ConfigFactory.load.getString("geonames.search.url"))
            .withQueryString("q" -> rdf_object.asLiteral().getString,
              "formatted" -> "true",
              "maxRows" -> "10",
              "username" -> "camilom",
              "style" -> "full").get.map(
            response => {
              val new_model = ModelFactory.createDefaultModel()
              val lat = (((Json.parse(response.body) \ "geonames") (0) \ "lat").get).toString()
              val lng = (((Json.parse(response.body) \ "geonames") (0) \ "lng").get).toString()

              new_model.add(ResourceFactory.createStatement(subject, ResourceFactory.createProperty("http://www.edsa-project.eu/edsa/wgs84_pos#lat"), ResourceFactory.createTypedLiteral(lat)))
              new_model.add(ResourceFactory.createStatement(subject, ResourceFactory.createProperty("http://www.edsa-project.eu/edsa/wgs84_pos#long"), ResourceFactory.createTypedLiteral(lng)))
              new_model
            }
          )

        future_statements += future_stm

        future_stm.map {
          res => {
            complete_model.add(res)
          }
        }
      }

      val f = Future.sequence(future_statements)
      Await.ready(f, Duration.Inf)

      complete_model.add(model)

    }
    else
      model

  }

  private def countryToISO8601(country: String): Option[String] = {
    country match {
      case "Germany" => Some("de")
      case "United Kingdom" => Some("gb") //Jooble is uk?
      case "France" => Some("fr")
      case "Netherlands" => Some("nl")
      case "Poland" => Some("pl")
      case "Russia" => Some("ru")
      case "Romania" => Some("ro")
      case "Belarus" => Some("by")
      case "Ukraine" => Some("ua")
      case "Bosnia and Herzegovina" => Some("ba")
      case "Slovakia" => Some("sk")
      case "Czech Republic" => Some("cz")
      case "Austria" => Some("at")
      case "Belgium" => Some("be")
      case "Denmark" => Some("dk")
      case "Switzerland" => Some("ch")
      case "Ireland" => Some("ie")
      case "Hungary" => Some("hu")
      case "Bulgaria" => Some("bg")
      case "Portugal" => Some("pt")
      case "Spain" => Some("es")
      case "Finland" => Some("fi")
      case "Greece" => Some("gr")
      case "Sweden" => Some("se")
      case "Norway" => Some("no")
      case "Croatia" => Some("hr")
      case _ => None
    }
  }

  private def skillsEnrichment(model: Model) : Model = {
    if (ConfigFactory.defaultApplication.getBoolean("enrichment.skills.enabled")) {
      Logger.info("Skills Enrichment Process")
      val _json = prepareAnnotationServiceJson(model)
      queryAnnotationServiceJson(_json)
    }
    else
      ModelFactory.createDefaultModel() //Retuning empty model
  }

  implicit val tasksWrites = new Writes[Skill] {
    def writes(skill: Skill) = Json.obj(
      "label" -> skill.label,
      "jobDescription" -> skill.jobDescription
    )
  }

  private def prepareAnnotationServiceJson(model: Model) : JsValue = {
    val query = s"""
                  PREFIX edsa: <http://www.edsa-project.eu/edsa#>
                  PREFIX sdo: <http://schema.org/>
                  PREFIX saro: <http://www.semanticweb.org/elisasibarani/ontologies/2016/0/untitled-ontology-51#>

                  SELECT ?id ?label ?description
                  WHERE
                  {
                    ?s a edsa:JobPosting .
                    ?s saro:id ?id .
                    ?s sdo:title ?label .
                    ?s sdo:description ?description .
                  }
                """
    val results = QueryExecutionFactory.create(query, model).execSelect()
    val seq = results.map(r => new Skill(r.getLiteral("id").getString, r.getLiteral("label").getString+" "+r.getLiteral("description").getString)).toList
    Json.obj("tasks" -> Json.toJson(seq))
  }

  private def queryAnnotationServiceJson(json: JsValue) : Model = {
    val model = ModelFactory.createDefaultModel()

    val future = ws.url(ConfigFactory.defaultApplication.getString("enrichment.skills.url"))
        .withHeaders("Content-Type" -> "application/json")
          .post(json).map( response => model.add(createRdfAnnotationModel(response.xml)))

    //Line required to sync with other thread, but it is not a good practice replace this in the next version
    Await.ready(future, Duration.Inf)

    Logger.info("Skill Model Size: "+model.size)
    model
  }

  private def createRdfAnnotationModel(annotations: Elem) : Model = {

    val model = ModelFactory.createDefaultModel()
    val docs = (annotations \ "GateDocument" \ "AnnotationSet").filter(!_.attribute("Name").isEmpty)
    docs.map { r =>
      val id = r.attribute("Name").get
      val jobPostUri = "http://www.edsa-project.eu/jobpost/" + id
      var skillId = ""
      (r \ "Annotation" \ "Feature").map { f =>
        val name = (f \ "Name").text
        val value = (f \ "Value").text
        if (name == "string") {
          Logger.info("Skill detected: "+value)
          model.createResource(jobPostUri)
            .addProperty(model.createProperty("http://www.edsa-project.eu/edsa#requiresSkill"), "http://www.edsa-project.eu/skill/"+value)
          skillId = value
        }
        else {
          if (skillId != "") {
            if (name == "frequencyOfMention")
              model.createResource("http://www.edsa-project.eu/skill/"+skillId)
                .addProperty(model.createProperty("http://www.edsa-project.eu/edsa#"+name), value+"^"+id)
            else
              model.createResource("http://www.edsa-project.eu/skill/"+skillId)
                .addProperty(model.createProperty("http://www.edsa-project.eu/edsa#"+name), value)
          }
        }
      }
    }
    Logger.info("Skills Model Size: "+model.size)
    model
  }

  private def execQueryAgainstWrapper(query: String, wrapper: RestApiWrapperTrait, page: Option[String], country: Option[String]): Future[ApiResponse] = {
    val apiRequest = createApiRequest(wrapper, query, page: Option[String], country: Option[String])
    val apiResponse = executeApiRequest(apiRequest, wrapper)
    val customApiResponse = customApiHandling(wrapper, apiResponse)
    transformApiResponse(wrapper, customApiResponse, query, country, page)
  }

  /**
    * Link and merge entities from different sources.
    *
    * @param wrappers
    * @param query
    * @return
    */
  private def fetchAndIntegrateWrapperResults(wrappers: Seq[Option[RestApiWrapperTrait]],
                                              query: String): Future[Result] = {
    // Fetch the transformed results from each wrapper
    val resultFutures = wrappers.flatten map (wrapper => execQueryAgainstWrapper(query, wrapper, None, None))
    Future.sequence(resultFutures) flatMap { results =>
      // Merge results
      val requestMerger = mergeWrapperResults(wrappers, results)
      // Link entities
      val sameAsTriples = personLinking(requestMerger.serializeMergedModel(Lang.TURTLE), langToAcceptType(Lang.TURTLE))
      val resultDataset = requestMerger.constructQuadDataset()
      // Rewrite/merge entities based on entity linking
      val rewrittenDataset = rewriteDatasetBasedOnSameAsLinks(resultDataset, sameAsTriples)
      datasetToNQuadsResult(rewrittenDataset)
    }
  }

  private def datasetToNQuadsResult(rewrittenDataset: Future[Dataset]): Future[Result] = {
    rewrittenDataset map { d =>
      Ok(datasetToQuadString(d, Lang.JSONLD)).
        withHeaders(("content-type", Lang.JSONLD.getContentType.getContentType))
    }
  }

  private def mergeWrapperResults(wrappers: Seq[Option[RestApiWrapperTrait]],
                                  results: Seq[ApiResponse]): RequestMerger = {
    val requestMerger = new RequestMerger()
    for ((wrapperResult, wrapper) <- results.zip(wrappers.flatten)) {
      wrapperResult match {
        case ApiSuccess(responseBody) =>
          val model = rdfStringToModel(responseBody, Lang.JSONLD.getName)
          requestMerger.addWrapperResult(model, wrapper.sourceUri)
        case _: ApiError =>
        // Ignore for now
      }
    }
    requestMerger
  }

  /**
    * Rewrites the entity URIs based on the sameAs links. All entities of each transitive closure will
    * have the same URI and point to the original URI via sameAs link (one per rewritten entity and source graph).
    *
    * @param inputDataset
    * @param sameAs
    * @return
    */
  private def rewriteDatasetBasedOnSameAsLinks(inputDataset: Dataset,
                                               sameAs: Future[Option[Traversable[Triple]]]): Future[Dataset] = {
    sameAs map {
      case Some(sameAsTriples) =>
        val it = inputDataset.asDatasetGraph().find()
        val quads = ArrayBuffer.empty[Quad]
        while(it.hasNext) {
          quads.append(it.next())
        }
        rewriteDatasetBasedOnSameAsLinks(sameAsTriples, quads)
      case None =>
        inputDataset
    }
  }

  private def rewriteDatasetBasedOnSameAsLinks(sameAsTriples: Traversable[Triple],
                                               quads: ArrayBuffer[Quad]): Dataset = {
    val translatedQuads = UriTranslator.translateQuads(
      quads = quads.toTraversable,
      links = sameAsTriples
    )
    val translatedDataset = DatasetFactory.create()
    val datasetGraph = translatedDataset.asDatasetGraph()
    for (quad <- translatedQuads) {
      datasetGraph.add(quad)
    }
    translatedDataset
  }

  def personLinking(entityRDF: String, acceptType: String): Future[Option[Traversable[Triple]]] = {
    executePersonLinking(entityRDF, acceptType) map {
      case ApiSuccess(body) =>
        Some(stringToTriple(body, acceptTypeToRdfLang(acceptType)))
      case ApiError(status, message) =>
        Logger.warn(s"Person linking service returned a status code of $status")
        None
    }
  }

  /** If a custom response handling is defined execute it against the response if has not been an error */
  private def customApiHandling(wrapper: RestApiWrapperTrait,
                                apiResponse: Future[ApiResponse]): Future[ApiResponse] = {
    wrapper.customResponseHandling(ws) match {
      case Some(customFn) =>
        apiResponse.flatMap {
          case ApiSuccess(body) =>
            customFn(body).
              map(customResult => ApiSuccess(customResult))
          case r: ApiError =>
            Future(r)
        }
      case None =>
        apiResponse
    }
  }

  /** Handles transformation if configured for the wrapper */
  private def transformApiResponse(wrapper: RestApiWrapperTrait,
                                   apiResponse: Future[ApiResponse],
                                   query: String,
                                   country: Option[String],
                                   page: Option[String]): Future[ApiResponse] = {
    if(wrapper.sourceLocalName.equals("jooble")) {
      val joobleResponse = new Application().postRequest(query, country.get, page.get)
      //Logger.debug("PRE-SILK (JOOBLE): "+joobleResponse )
      handleSilkTransformation(wrapper, joobleResponse.replace("\\r", ""))
    }else{
      //Logger.debug("PRE-SILK: "+ apiResponse.value )
      apiResponse.flatMap {
        case error: ApiError =>
          // There has been an error previously, don't go on.
          Future(error)
        case ApiSuccess(body) =>
          if(wrapper.sourceLocalName.equals("indeed")){
            val bodyS = body.replace("<?xml version='1.0' encoding='UTF-8'?>","")
            //Logger.info("PRE-SILKK: "+bodyS)
            handleSilkTransformation(wrapper, bodyS)
          } else{
            //Logger.debug("PRE-SILK: "+body)
            handleSilkTransformation(wrapper, body)
          }
      }
    }
  }

  /** Executes the request to the wrapped REST API */
  private def executeApiRequest(apiRequest: WSRequest, wrapper: RestApiWrapperTrait): Future[ApiResponse] = {
    if(wrapper.requestType.equals("POST")){
      Logger.info("POST wrapper request")
      //apiRequest.withHeaders("Content-Type"->"application/x-www-form-urlencoded", "Content-Length"->"31").post("{'keywords': 'account manager'}").map(convertToApiResponse("Wrapper or the wrapped service"))
      null
    }else{
      Logger.info("GET wrapper request")
      Logger.info(apiRequest.url)
      apiRequest.get.map(convertToApiResponse("Wrapper or the wrapped service"))
    }
  }

  /** If transformations are configured then execute them via the Silk REST API */
  def handleSilkTransformation(wrapper: RestApiWrapperTrait,
                               content: String,
                               acceptType: String = "text/turtle"): Future[ApiResponse] = {
    //acceptType: String = "text/csv"): Future[ApiResponse] = {
    wrapper match {
      case silkTransform: SilkTransformableTrait if silkTransform.silkTransformationRequestTasks.size > 0 =>
        Logger.info("Execute Silk Transformations")
        val lang = acceptTypeToRdfLang(acceptType)
        val futureResponses = executeTransformation(content, acceptType, silkTransform)
        val rdf = convertToRdf(lang, futureResponses)
        rdf.map(content => ApiSuccess(content))
      case _ =>
        // No transformation to be executed
        Future(ApiSuccess(content))
    }
  }

  /** Execute all transformation tasks on the content */
  private def executeTransformation(content: String,
                                    acceptType: String,
                                    silkTransform: RestApiWrapperTrait with SilkTransformableTrait): Seq[Future[ApiResponse]] = {
    for (transform <- silkTransform.silkTransformationRequestTasks) yield {
      Logger.info("Executing silk transformation: "+transform.transformationTaskId)
      //val task = silkTransform.silkTransformationRequestTasks.head
      val transformRequest = ws.url(silkTransform.transformationEndpoint(transform.transformationTaskId))
        //.withHeaders("Content-Type" -> "application/xml; charset=utf-8")
        //.withHeaders("Content-Type" -> "application/json; charset=utf-8")
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        //.withHeaders("Accept" -> acceptType)
      val response = transformRequest
        .post(transform.silkTransformationRequestBodyGenerator(content))
        .map(convertToApiResponse("Silk transformation endpoint"))
      response
    }
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

  /**
    * Executes the person linking rule and returns a set of sameAs links.
    *
    * @param content The RDF content as String.
    * @param acceptType An HTTP accept type that is used for serialization and deserialization from/to the REST
    *                   services.
    * @return
    */
  private def executePersonLinking(content: String,
                                   acceptType: String): Future[ApiResponse] = {
    val silkConfig = SilkConfig(
      projectId = ConfigFactory.load.getString("silk.socialApiProject.id"),
      linkingTaskId = ConfigFactory.load.getString("silk.linking.task.person"),
      silkServerUrl = ConfigFactory.load.getString("silk.server.url")
    )
    val entityLinking = new EntityLinking(silkConfig)
    val linkRequest = ws.url(silkConfig.endpoint)
      .withHeaders("Content-Type" -> "application/xml")
      .withHeaders("Accept" -> acceptType)
    linkRequest.post(entityLinking.linkTemplate(content, acceptTypeToRdfLang(acceptType)))
      .map(convertToApiResponse("Silk linking service"))
  }

  /** Merge all transformation results into a single model and return the serialized model */
  private def convertToRdf(lang: String,
                           futureResponses: Seq[Future[ApiResponse]]): Future[String] = {
    Future.sequence(futureResponses) map { responses =>
      val model = ModelFactory.createDefaultModel()
      responses.foreach {
        case ApiSuccess(body) =>
          model.add(rdfStringToModel(body, lang))
        case ApiError(statusCode, errorMessage) =>
          Logger.warn(s"Got status code $statusCode with message: $errorMessage")
      }
      modelToTripleString(model, "application/n-triples")
    }
  }

  /** Creates the complete API REST request and executes it asynchronously. */
  def createApiRequest(wrapper: RestApiWrapperTrait, query: String, page: Option[String], country: Option[String]): WSRequest = {
    val apiRequest: WSRequest = ws.url(wrapper.apiUrl)
    val apiRequestWithApiParams = addQueryParameters(wrapper, apiRequest, query, page: Option[String], country: Option[String])
    val apiRequestWithOAuthIfNeeded = handleOAuth(wrapper, apiRequestWithApiParams)
    apiRequestWithOAuthIfNeeded
  }

  /** Add all query parameters to the request. */
  private def addQueryParameters(wrapper: RestApiWrapperTrait,
                                 request: WSRequest,
                                 queryString: String,
                                 page: Option[String],
                                 country: Option[String]): WSRequest = {

    var url_with_params = wrapper.apiUrl+"?"

    if(wrapper.sourceLocalName.equals("adzuna")){
      var url_sb = new StringBuilder(wrapper.apiUrl)
      url_sb.setCharAt(34,country.get.charAt(0))
      url_sb.setCharAt(35,country.get.charAt(1))
      url_sb.append(page.get)
      url_with_params = url_sb.toString()+"?"
      }

    for ((k,v) <- wrapper.searchQueryAsParam(queryString)){
      url_with_params = url_with_params.concat(k+"="+v+"&")
    }

    for ((k,v) <- wrapper.queryParams){
      url_with_params = url_with_params.concat(k+"="+v+"&")
    }

    if(wrapper.sourceLocalName.equals("indeed")){
      url_with_params = url_with_params.concat("start="+ ((page.get.toInt - 1 ) * wrapper.max_results ) +"&")
      url_with_params = url_with_params.concat("co="+country.get+"&")
    }

    if(wrapper.sourceLocalName.equals("canvas") ||  wrapper.sourceLocalName.equals("openedx")){
      url_with_params = url_with_params.concat("page="+ page.get +"&")
    }

    val apiRequest: WSRequest = ws.url(url_with_params.dropRight(1))
    val final_url = apiRequest.withHeaders(wrapper.headersParams.toSeq: _*)
    print(final_url.url)
    final_url
  }

  /** Signs the request if the [[RestApiOAuthTrait]] is configured. */
  private def handleOAuth(wrapper: RestApiWrapperTrait,
                          request: WSRequest): WSRequest = {
    wrapper match {
      case oAuthWrapper: RestApiOAuthTrait =>
        request
          .sign(OAuthCalculator(
            oAuthWrapper.oAuthConsumerKey,
            oAuthWrapper.oAuthRequestToken))

      case oAuth2Wrapper: RestApiOAuth2Trait =>
        request.withQueryString("access_token" -> oAuth2Wrapper.oAuth2AccessToken)
      case _ =>
        request
    }
  }

  // Return all wrapper ids as a JSON list
  def wrapperIds() = {
    Action {
      Ok(JsArray(WrapperController.sortedWrapperIds.map(id => JsString(id))))
    }
  }
}

/**
  * For now, hard code all available wrappers here. Later this should probably be replaced by a plugin mechanism.
  */
object WrapperController {
  val wrapperMap = Map[String, RestApiWrapperTrait](
    //EDSA WRAPPERS:
    //ADZUNA
    "adzuna" -> new AdzunaWrapper(),
    //INDEED
    "indeed" -> new IndeedWrapper(),
    //JOOBLE
    "jooble" -> new JoobleWrapper(),
    //EDSA - DEMAND (Courses):
    //OPEN EDX
    "openedx"-> new OpenEDXWrapper(),
    //CANVAS LMS
    "canvas"-> new CanvasWrapper()
  )

  val sortedWrapperIds = wrapperMap.keys.toSeq.sortWith(_ < _)
}

case class Skill (label: String, jobDescription: String)
case class AnnotateSkill (uri: String, label: String, frequencyOfMention: Int, skillType: String)
