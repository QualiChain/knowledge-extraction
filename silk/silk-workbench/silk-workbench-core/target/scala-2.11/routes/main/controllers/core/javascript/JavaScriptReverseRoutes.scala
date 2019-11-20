// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/conf/core.routes
// @DATE:Tue Jul 30 22:35:14 CEST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.core.javascript {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.core.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseBranding(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def aboutDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.core.Branding.aboutDialog",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "aboutDialog"})
        }
      """
    )
  
    // @LINE:2
    def logo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.core.Branding.logo",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logo.png"})
        }
      """
    )
  
    // @LINE:4
    def mdlStyle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.core.Branding.mdlStyle",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mdlStyle"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseConfigController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.core.ConfigController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "config"})
        }
      """
    )
  
  }

  // @LINE:1
  class ReverseStart(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.core.Start.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "start"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReversePluginApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def pluginsForTypes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.core.PluginApi.pluginsForTypes",
      """
        function(pluginType0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "plugins/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("pluginType", pluginType0))})
        }
      """
    )
  
    // @LINE:6
    def plugins: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.core.PluginApi.plugins",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "plugins"})
        }
      """
    )
  
  }


}
