
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/data-acquisition-service/conf/routes
// @DATE:Sun Aug 04 15:02:29 CEST 2019

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:10
package controllers.de.fuhsen.wrappers {

  // @LINE:10
  class ReverseWrapperController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def demand_analysis(edsaWrapperId:String, country:Option[String]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "edsa/" + implicitly[PathBindable[String]].unbind("edsaWrapperId", dynamicString(edsaWrapperId)) + "/job_search" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("country", country)))))
    }
  
    // @LINE:10
    def wrapperIds(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "ldw/restApiWrapper")
    }
  
    // @LINE:20
    def edsa_rdf2json_transform(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "edsa/rdf2json")
    }
  
    // @LINE:19
    def suply_analysis(edsaWrapperId:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "edsa/" + implicitly[PathBindable[String]].unbind("edsaWrapperId", dynamicString(edsaWrapperId)) + "/course_search")
    }
  
  }


}