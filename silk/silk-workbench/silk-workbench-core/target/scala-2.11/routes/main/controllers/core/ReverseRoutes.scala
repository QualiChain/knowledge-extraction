// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/conf/core.routes
// @DATE:Tue Jul 30 22:35:14 CEST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.core {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public/lib/silk-workbench-core"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:2
  class ReverseBranding(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def aboutDialog(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "aboutDialog")
    }
  
    // @LINE:2
    def logo(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logo.png")
    }
  
    // @LINE:4
    def mdlStyle(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "mdlStyle")
    }
  
  }

  // @LINE:5
  class ReverseConfigController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "config")
    }
  
  }

  // @LINE:1
  class ReverseStart(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "start")
    }
  
  }

  // @LINE:6
  class ReversePluginApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def pluginsForTypes(pluginType:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "plugins/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("pluginType", pluginType)))
    }
  
    // @LINE:6
    def plugins(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "plugins")
    }
  
  }


}
