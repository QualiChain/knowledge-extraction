
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/data-acquisition-service/conf/routes
// @DATE:Sun Aug 04 15:02:29 CEST 2019

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:26
package controllers.de.fuhsen.engine {

  // @LINE:26
  class ReverseQMinerController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def receive(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "qminer/receive")
    }
  
    // @LINE:26
    def send(date:String, source:String, limit:Int, offset:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "qminer/sent" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("date", date)), Some(implicitly[QueryStringBindable[String]].unbind("source", source)), Some(implicitly[QueryStringBindable[Int]].unbind("limit", limit)), Some(implicitly[QueryStringBindable[Int]].unbind("offset", offset)))))
    }
  
  }

  // @LINE:30
  class ReverseLinkingController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def linkJobPostings(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "edsa/link/job")
    }
  
  }


}