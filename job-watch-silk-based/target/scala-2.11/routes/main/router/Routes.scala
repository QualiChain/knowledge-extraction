
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/data-acquisition-service/conf/routes
// @DATE:Sun Aug 04 15:02:29 CEST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_5: controllers.Application,
  // @LINE:10
  WrapperController_1: controllers.de.fuhsen.wrappers.WrapperController,
  // @LINE:12
  TokenRetrievalController_3: controllers.de.fuhsen.wrappers.security.TokenRetrievalController,
  // @LINE:23
  Assets_4: controllers.Assets,
  // @LINE:26
  QMinerController_0: controllers.de.fuhsen.engine.QMinerController,
  // @LINE:30
  LinkingController_2: controllers.de.fuhsen.engine.LinkingController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_5: controllers.Application,
    // @LINE:10
    WrapperController_1: controllers.de.fuhsen.wrappers.WrapperController,
    // @LINE:12
    TokenRetrievalController_3: controllers.de.fuhsen.wrappers.security.TokenRetrievalController,
    // @LINE:23
    Assets_4: controllers.Assets,
    // @LINE:26
    QMinerController_0: controllers.de.fuhsen.engine.QMinerController,
    // @LINE:30
    LinkingController_2: controllers.de.fuhsen.engine.LinkingController
  ) = this(errorHandler, Application_5, WrapperController_1, TokenRetrievalController_3, Assets_4, QMinerController_0, LinkingController_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_5, WrapperController_1, TokenRetrievalController_3, Assets_4, QMinerController_0, LinkingController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """keyword""", """controllers.Application.getKeyword()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ldw/restApiWrapper""", """controllers.de.fuhsen.wrappers.WrapperController.wrapperIds()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """$wrapperId<[^/]+>/getToken""", """controllers.de.fuhsen.wrappers.security.TokenRetrievalController.getToken(wrapperId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """$wrapperId<[^/]+>/code2token""", """controllers.de.fuhsen.wrappers.security.TokenRetrievalController.code2token(code:String, wrapperId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """$wrapperId<[^/]+>/code2tokenX""", """controllers.de.fuhsen.wrappers.security.TokenRetrievalController.code2tokenX(wrapperId:String, oauth_token:String, oauth_verifier:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """$wrapperId<[^/]+>/getTokenLifeLength""", """controllers.Application.TokenLifeLength(wrapperId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """edsa/$edsaWrapperId<[^/]+>/job_search""", """controllers.de.fuhsen.wrappers.WrapperController.demand_analysis(edsaWrapperId:String, country:Option[String])"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """edsa/$edsaWrapperId<[^/]+>/course_search""", """controllers.de.fuhsen.wrappers.WrapperController.suply_analysis(edsaWrapperId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """edsa/rdf2json""", """controllers.de.fuhsen.wrappers.WrapperController.edsa_rdf2json_transform()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """qminer/sent""", """controllers.de.fuhsen.engine.QMinerController.send(date:String, source:String, limit:Int, offset:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """qminer/receive""", """controllers.de.fuhsen.engine.QMinerController.receive"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """edsa/link/job""", """controllers.de.fuhsen.engine.LinkingController.linkJobPostings"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_5.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ User Interface routes""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_getKeyword1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("keyword")))
  )
  private[this] lazy val controllers_Application_getKeyword1_invoker = createInvoker(
    Application_5.getKeyword(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getKeyword",
      Nil,
      "GET",
      """""",
      this.prefix + """keyword"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_de_fuhsen_wrappers_WrapperController_wrapperIds2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ldw/restApiWrapper")))
  )
  private[this] lazy val controllers_de_fuhsen_wrappers_WrapperController_wrapperIds2_invoker = createInvoker(
    WrapperController_1.wrapperIds(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.de.fuhsen.wrappers.WrapperController",
      "wrapperIds",
      Nil,
      "GET",
      """ REST API Wrappers""",
      this.prefix + """ldw/restApiWrapper"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_de_fuhsen_wrappers_security_TokenRetrievalController_getToken3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("wrapperId", """[^/]+""",true), StaticPart("/getToken")))
  )
  private[this] lazy val controllers_de_fuhsen_wrappers_security_TokenRetrievalController_getToken3_invoker = createInvoker(
    TokenRetrievalController_3.getToken(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.de.fuhsen.wrappers.security.TokenRetrievalController",
      "getToken",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """$wrapperId<[^/]+>/getToken"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_de_fuhsen_wrappers_security_TokenRetrievalController_code2token4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("wrapperId", """[^/]+""",true), StaticPart("/code2token")))
  )
  private[this] lazy val controllers_de_fuhsen_wrappers_security_TokenRetrievalController_code2token4_invoker = createInvoker(
    TokenRetrievalController_3.code2token(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.de.fuhsen.wrappers.security.TokenRetrievalController",
      "code2token",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """$wrapperId<[^/]+>/code2token"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_de_fuhsen_wrappers_security_TokenRetrievalController_code2tokenX5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("wrapperId", """[^/]+""",true), StaticPart("/code2tokenX")))
  )
  private[this] lazy val controllers_de_fuhsen_wrappers_security_TokenRetrievalController_code2tokenX5_invoker = createInvoker(
    TokenRetrievalController_3.code2tokenX(fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.de.fuhsen.wrappers.security.TokenRetrievalController",
      "code2tokenX",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """$wrapperId<[^/]+>/code2tokenX"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Application_TokenLifeLength6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("wrapperId", """[^/]+""",true), StaticPart("/getTokenLifeLength")))
  )
  private[this] lazy val controllers_Application_TokenLifeLength6_invoker = createInvoker(
    Application_5.TokenLifeLength(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "TokenLifeLength",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """$wrapperId<[^/]+>/getTokenLifeLength"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_de_fuhsen_wrappers_WrapperController_demand_analysis7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("edsa/"), DynamicPart("edsaWrapperId", """[^/]+""",true), StaticPart("/job_search")))
  )
  private[this] lazy val controllers_de_fuhsen_wrappers_WrapperController_demand_analysis7_invoker = createInvoker(
    WrapperController_1.demand_analysis(fakeValue[String], fakeValue[Option[String]]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.de.fuhsen.wrappers.WrapperController",
      "demand_analysis",
      Seq(classOf[String], classOf[Option[String]]),
      "GET",
      """ EDSA endpoints""",
      this.prefix + """edsa/$edsaWrapperId<[^/]+>/job_search"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_de_fuhsen_wrappers_WrapperController_suply_analysis8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("edsa/"), DynamicPart("edsaWrapperId", """[^/]+""",true), StaticPart("/course_search")))
  )
  private[this] lazy val controllers_de_fuhsen_wrappers_WrapperController_suply_analysis8_invoker = createInvoker(
    WrapperController_1.suply_analysis(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.de.fuhsen.wrappers.WrapperController",
      "suply_analysis",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """edsa/$edsaWrapperId<[^/]+>/course_search"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_de_fuhsen_wrappers_WrapperController_edsa_rdf2json_transform9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("edsa/rdf2json")))
  )
  private[this] lazy val controllers_de_fuhsen_wrappers_WrapperController_edsa_rdf2json_transform9_invoker = createInvoker(
    WrapperController_1.edsa_rdf2json_transform(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.de.fuhsen.wrappers.WrapperController",
      "edsa_rdf2json_transform",
      Nil,
      "GET",
      """""",
      this.prefix + """edsa/rdf2json"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Assets_versioned10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned10_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_de_fuhsen_engine_QMinerController_send11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("qminer/sent")))
  )
  private[this] lazy val controllers_de_fuhsen_engine_QMinerController_send11_invoker = createInvoker(
    QMinerController_0.send(fakeValue[String], fakeValue[String], fakeValue[Int], fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.de.fuhsen.engine.QMinerController",
      "send",
      Seq(classOf[String], classOf[String], classOf[Int], classOf[Int]),
      "GET",
      """ QMine""",
      this.prefix + """qminer/sent"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_de_fuhsen_engine_QMinerController_receive12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("qminer/receive")))
  )
  private[this] lazy val controllers_de_fuhsen_engine_QMinerController_receive12_invoker = createInvoker(
    QMinerController_0.receive,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.de.fuhsen.engine.QMinerController",
      "receive",
      Nil,
      "POST",
      """""",
      this.prefix + """qminer/receive"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_de_fuhsen_engine_LinkingController_linkJobPostings13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("edsa/link/job")))
  )
  private[this] lazy val controllers_de_fuhsen_engine_LinkingController_linkJobPostings13_invoker = createInvoker(
    LinkingController_2.linkJobPostings,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.de.fuhsen.engine.LinkingController",
      "linkJobPostings",
      Nil,
      "GET",
      """Linking Datasets""",
      this.prefix + """edsa/link/job"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_5.index())
      }
  
    // @LINE:7
    case controllers_Application_getKeyword1_route(params) =>
      call { 
        controllers_Application_getKeyword1_invoker.call(Application_5.getKeyword())
      }
  
    // @LINE:10
    case controllers_de_fuhsen_wrappers_WrapperController_wrapperIds2_route(params) =>
      call { 
        controllers_de_fuhsen_wrappers_WrapperController_wrapperIds2_invoker.call(WrapperController_1.wrapperIds())
      }
  
    // @LINE:12
    case controllers_de_fuhsen_wrappers_security_TokenRetrievalController_getToken3_route(params) =>
      call(params.fromPath[String]("wrapperId", None)) { (wrapperId) =>
        controllers_de_fuhsen_wrappers_security_TokenRetrievalController_getToken3_invoker.call(TokenRetrievalController_3.getToken(wrapperId))
      }
  
    // @LINE:13
    case controllers_de_fuhsen_wrappers_security_TokenRetrievalController_code2token4_route(params) =>
      call(params.fromQuery[String]("code", None), params.fromPath[String]("wrapperId", None)) { (code, wrapperId) =>
        controllers_de_fuhsen_wrappers_security_TokenRetrievalController_code2token4_invoker.call(TokenRetrievalController_3.code2token(code, wrapperId))
      }
  
    // @LINE:14
    case controllers_de_fuhsen_wrappers_security_TokenRetrievalController_code2tokenX5_route(params) =>
      call(params.fromPath[String]("wrapperId", None), params.fromQuery[String]("oauth_token", None), params.fromQuery[String]("oauth_verifier", None)) { (wrapperId, oauth_token, oauth_verifier) =>
        controllers_de_fuhsen_wrappers_security_TokenRetrievalController_code2tokenX5_invoker.call(TokenRetrievalController_3.code2tokenX(wrapperId, oauth_token, oauth_verifier))
      }
  
    // @LINE:15
    case controllers_Application_TokenLifeLength6_route(params) =>
      call(params.fromPath[String]("wrapperId", None)) { (wrapperId) =>
        controllers_Application_TokenLifeLength6_invoker.call(Application_5.TokenLifeLength(wrapperId))
      }
  
    // @LINE:18
    case controllers_de_fuhsen_wrappers_WrapperController_demand_analysis7_route(params) =>
      call(params.fromPath[String]("edsaWrapperId", None), params.fromQuery[Option[String]]("country", None)) { (edsaWrapperId, country) =>
        controllers_de_fuhsen_wrappers_WrapperController_demand_analysis7_invoker.call(WrapperController_1.demand_analysis(edsaWrapperId, country))
      }
  
    // @LINE:19
    case controllers_de_fuhsen_wrappers_WrapperController_suply_analysis8_route(params) =>
      call(params.fromPath[String]("edsaWrapperId", None)) { (edsaWrapperId) =>
        controllers_de_fuhsen_wrappers_WrapperController_suply_analysis8_invoker.call(WrapperController_1.suply_analysis(edsaWrapperId))
      }
  
    // @LINE:20
    case controllers_de_fuhsen_wrappers_WrapperController_edsa_rdf2json_transform9_route(params) =>
      call { 
        controllers_de_fuhsen_wrappers_WrapperController_edsa_rdf2json_transform9_invoker.call(WrapperController_1.edsa_rdf2json_transform())
      }
  
    // @LINE:23
    case controllers_Assets_versioned10_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:26
    case controllers_de_fuhsen_engine_QMinerController_send11_route(params) =>
      call(params.fromQuery[String]("date", None), params.fromQuery[String]("source", None), params.fromQuery[Int]("limit", None), params.fromQuery[Int]("offset", None)) { (date, source, limit, offset) =>
        controllers_de_fuhsen_engine_QMinerController_send11_invoker.call(QMinerController_0.send(date, source, limit, offset))
      }
  
    // @LINE:27
    case controllers_de_fuhsen_engine_QMinerController_receive12_route(params) =>
      call { 
        controllers_de_fuhsen_engine_QMinerController_receive12_invoker.call(QMinerController_0.receive)
      }
  
    // @LINE:30
    case controllers_de_fuhsen_engine_LinkingController_linkJobPostings13_route(params) =>
      call { 
        controllers_de_fuhsen_engine_LinkingController_linkJobPostings13_invoker.call(LinkingController_2.linkJobPostings)
      }
  }
}