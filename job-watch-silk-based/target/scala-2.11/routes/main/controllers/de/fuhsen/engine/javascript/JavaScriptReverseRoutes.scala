
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/data-acquisition-service/conf/routes
// @DATE:Sun Aug 04 15:02:29 CEST 2019

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:26
package controllers.de.fuhsen.engine.javascript {
  import ReverseRouteContext.empty

  // @LINE:26
  class ReverseQMinerController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def receive: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.de.fuhsen.engine.QMinerController.receive",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "qminer/receive"})
        }
      """
    )
  
    // @LINE:26
    def send: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.de.fuhsen.engine.QMinerController.send",
      """
        function(date,source,limit,offset) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "qminer/sent" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("date", date), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("source", source), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("limit", limit), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("offset", offset)])})
        }
      """
    )
  
  }

  // @LINE:30
  class ReverseLinkingController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def linkJobPostings: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.de.fuhsen.engine.LinkingController.linkJobPostings",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edsa/link/job"})
        }
      """
    )
  
  }


}