
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/data-acquisition-service/conf/routes
// @DATE:Sun Aug 04 15:02:29 CEST 2019

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:12
package controllers.de.fuhsen.wrappers.security {

  // @LINE:12
  class ReverseTokenRetrievalController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def getToken(wrapperId:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("wrapperId", dynamicString(wrapperId)) + "/getToken")
    }
  
    // @LINE:14
    def code2tokenX(wrapperId:String, oauth_token:String, oauth_verifier:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("wrapperId", dynamicString(wrapperId)) + "/code2tokenX" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("oauth_token", oauth_token)), Some(implicitly[QueryStringBindable[String]].unbind("oauth_verifier", oauth_verifier)))))
    }
  
    // @LINE:13
    def code2token(code:String, wrapperId:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("wrapperId", dynamicString(wrapperId)) + "/code2token" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("code", code)))))
    }
  
  }


}