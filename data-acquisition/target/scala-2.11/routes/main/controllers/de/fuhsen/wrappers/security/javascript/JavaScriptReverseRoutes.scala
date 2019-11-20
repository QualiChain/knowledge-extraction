
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/data-acquisition-service/conf/routes
// @DATE:Sun Aug 04 15:02:29 CEST 2019

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:12
package controllers.de.fuhsen.wrappers.security.javascript {
  import ReverseRouteContext.empty

  // @LINE:12
  class ReverseTokenRetrievalController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def getToken: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.de.fuhsen.wrappers.security.TokenRetrievalController.getToken",
      """
        function(wrapperId) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("wrapperId", encodeURIComponent(wrapperId)) + "/getToken"})
        }
      """
    )
  
    // @LINE:14
    def code2tokenX: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.de.fuhsen.wrappers.security.TokenRetrievalController.code2tokenX",
      """
        function(wrapperId,oauth_token,oauth_verifier) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("wrapperId", encodeURIComponent(wrapperId)) + "/code2tokenX" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("oauth_token", oauth_token), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("oauth_verifier", oauth_verifier)])})
        }
      """
    )
  
    // @LINE:13
    def code2token: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.de.fuhsen.wrappers.security.TokenRetrievalController.code2token",
      """
        function(code,wrapperId) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("wrapperId", encodeURIComponent(wrapperId)) + "/code2token" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("code", code)])})
        }
      """
    )
  
  }


}