
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/data-acquisition-service/conf/routes
// @DATE:Sun Aug 04 15:02:29 CEST 2019

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:10
package controllers.de.fuhsen.wrappers.javascript {
  import ReverseRouteContext.empty

  // @LINE:10
  class ReverseWrapperController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def demand_analysis: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.de.fuhsen.wrappers.WrapperController.demand_analysis",
      """
        function(edsaWrapperId,country) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edsa/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("edsaWrapperId", encodeURIComponent(edsaWrapperId)) + "/job_search" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("country", country)])})
        }
      """
    )
  
    // @LINE:10
    def wrapperIds: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.de.fuhsen.wrappers.WrapperController.wrapperIds",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ldw/restApiWrapper"})
        }
      """
    )
  
    // @LINE:20
    def edsa_rdf2json_transform: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.de.fuhsen.wrappers.WrapperController.edsa_rdf2json_transform",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edsa/rdf2json"})
        }
      """
    )
  
    // @LINE:19
    def suply_analysis: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.de.fuhsen.wrappers.WrapperController.suply_analysis",
      """
        function(edsaWrapperId) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edsa/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("edsaWrapperId", encodeURIComponent(edsaWrapperId)) + "/course_search"})
        }
      """
    )
  
  }


}