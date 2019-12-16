// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/knowledge-extraction/silk/silk-workbench/silk-workbench-rules/conf/transform.routes
// @DATE:Sun Dec 15 09:27:21 CET 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.transform.javascript {

  // @LINE:24
  class ReverseTransformTaskApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def executeTransformTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.executeTransformTask",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/executeTransform"})
        }
      """
    )
  
    // @LINE:51
    def postTransformInput: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.postTransformInput",
      """
        function(project0,task1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/transformInput"})
        }
      """
    )
  
    // @LINE:25
    def putTransformTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.putTransformTask",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
    // @LINE:26
    def deleteTransformTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.deleteTransformTask",
      """
        function(project0,task1,removeDependentTasks2) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + _qS([(removeDependentTasks2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Boolean]].javascriptUnbind + """)("removeDependentTasks", removeDependentTasks2))])})
        }
      """
    )
  
    // @LINE:27
    def getRules: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.getRules",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rules"})
        }
      """
    )
  
    // @LINE:31
    def deleteRule: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.deleteRule",
      """
        function(project0,task1,rule2) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2))})
        }
      """
    )
  
    // @LINE:32
    def appendRule: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.appendRule",
      """
        function(project0,task1,rule2,afterRuleId3) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2)) + "/rules" + _qS([(afterRuleId3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Option[String]]].javascriptUnbind + """)("afterRuleId", afterRuleId3))])})
        }
      """
    )
  
    // @LINE:24
    def getTransformTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.getTransformTask",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
    // @LINE:35
    def reloadTransformCache: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.reloadTransformCache",
      """
        function(project0,task1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/reloadCache"})
        }
      """
    )
  
    // @LINE:29
    def getRule: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.getRule",
      """
        function(project0,task1,rule2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2))})
        }
      """
    )
  
    // @LINE:30
    def putRule: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.putRule",
      """
        function(project0,task1,rule2) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2))})
        }
      """
    )
  
    // @LINE:28
    def putRules: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.putRules",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rules"})
        }
      """
    )
  
    // @LINE:34
    def reorderRules: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.reorderRules",
      """
        function(project0,task1,rule2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2)) + "/rules/reorder"})
        }
      """
    )
  
    // @LINE:33
    def copyRule: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.copyRule",
      """
        function(project0,task1,rule2,sourceProject3,sourceTask4,sourceRule5,afterRuleId6) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2)) + "/rules/copyFrom" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("sourceProject", sourceProject3), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("sourceTask", sourceTask4), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("sourceRule", sourceRule5), (afterRuleId6 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Option[String]]].javascriptUnbind + """)("afterRuleId", afterRuleId6))])})
        }
      """
    )
  
    // @LINE:52
    def valueSourcePaths: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformTaskApi.valueSourcePaths",
      """
        function(project0,task1,rule2,maxDepth3,unusedOnly4) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2)) + "/valueSourcePaths" + _qS([(maxDepth3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("maxDepth", maxDepth3)), (unusedOnly4 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Boolean]].javascriptUnbind + """)("unusedOnly", unusedOnly4))])})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseTransformEditor(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def editor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformEditor.editor",
      """
        function(project0,task1,rule2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/editor/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2))})
        }
      """
    )
  
    // @LINE:7
    def start: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformEditor.start",
      """
        function(project0,task1,rule2) {
        
          if (rule2 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/editor"})
          }
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/editor/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2))})
          }
        
        }
      """
    )
  
    // @LINE:10
    def propertyDetails: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformEditor.propertyDetails",
      """
        function(project0,task1,property2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/editor/widgets/property" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("property", property2)])})
        }
      """
    )
  
    // @LINE:11
    def paths: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformEditor.paths",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/editor/widgets/paths"})
        }
      """
    )
  
    // @LINE:13
    def score: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformEditor.score",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/editor/widgets/score"})
        }
      """
    )
  
    // @LINE:12
    def rulePaths: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformEditor.rulePaths",
      """
        function(project0,task1,rule2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/editor/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2)) + "/widgets/paths"})
        }
      """
    )
  
  }

  // @LINE:41
  class ReverseAutoCompletionApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def sourcePaths: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.AutoCompletionApi.sourcePaths",
      """
        function(project0,task1,rule2,term3,maxResults4) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2)) + "/completions/sourcePaths" + _qS([(term3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("term", term3)), (maxResults4 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("maxResults", maxResults4))])})
        }
      """
    )
  
    // @LINE:43
    def targetProperties: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.AutoCompletionApi.targetProperties",
      """
        function(project0,task1,rule2,term3,maxResults4) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2)) + "/completions/targetProperties" + _qS([(term3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("term", term3)), (maxResults4 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("maxResults", maxResults4))])})
        }
      """
    )
  
    // @LINE:42
    def targetTypes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.AutoCompletionApi.targetTypes",
      """
        function(project0,task1,rule2,term3,maxResults4) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2)) + "/completions/targetTypes" + _qS([(term3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("term", term3)), (maxResults4 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("maxResults", maxResults4))])})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseExecuteTransformTab(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def executionReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.ExecuteTransformTab.executionReport",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/execute/report"})
        }
      """
    )
  
    // @LINE:20
    def execute: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.ExecuteTransformTab.execute",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/execute"})
        }
      """
    )
  
  }

  // @LINE:45
  class ReverseTargetVocabularyApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:48
    def propertiesByType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TargetVocabularyApi.propertiesByType",
      """
        function(project0,task1,classUri2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/targetVocabulary/propertiesByClass" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("classUri", classUri2)])})
        }
      """
    )
  
    // @LINE:49
    def relationsOfType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TargetVocabularyApi.relationsOfType",
      """
        function(project0,task1,classUri2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/targetVocabulary/relationsOfClass" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("classUri", classUri2)])})
        }
      """
    )
  
    // @LINE:46
    def getPropertyInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TargetVocabularyApi.getPropertyInfo",
      """
        function(project0,task1,uri2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/targetVocabulary/property" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("uri", uri2)])})
        }
      """
    )
  
    // @LINE:45
    def getTypeInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TargetVocabularyApi.getTypeInfo",
      """
        function(project0,task1,uri2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/targetVocabulary/type" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("uri", uri2)])})
        }
      """
    )
  
    // @LINE:47
    def getTypeOrPropertyInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TargetVocabularyApi.getTypeOrPropertyInfo",
      """
        function(project0,task1,uri2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/targetVocabulary/typeOrProperty" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("uri", uri2)])})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseEvaluateTransform(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def evaluate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.EvaluateTransform.evaluate",
      """
        function(project0,task1,offset2,limit3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/evaluate" + _qS([(offset2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("offset", offset2)), (limit3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("limit", limit3))])})
        }
      """
    )
  
    // @LINE:17
    def generatedEntities: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.EvaluateTransform.generatedEntities",
      """
        function(project0,task1,offset2,limit3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/evaluate/generatedEntities" + _qS([(offset2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("offset", offset2)), (limit3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("limit", limit3))])})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseTransformDialogs(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def transformationTaskDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformDialogs.transformationTaskDialog",
      """
        function(project0,task1,createDialog2) {
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """ && createDialog2 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(true) + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/newTransformTask/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
          }
        
          if (createDialog2 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(false) + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/editTransformTask/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
          }
        
        }
      """
    )
  
    // @LINE:4
    def deleteRuleDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.TransformDialogs.deleteRuleDialog",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/deleteRule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0))})
        }
      """
    )
  
  }

  // @LINE:38
  class ReversePeakTransformApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def peak: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.PeakTransformApi.peak",
      """
        function(project0,task1,rule2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/peak/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2))})
        }
      """
    )
  
    // @LINE:39
    def peakChildRule: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.transform.PeakTransformApi.peakChildRule",
      """
        function(project0,task1,rule2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/peak/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("rule", rule2)) + "/childRule"})
        }
      """
    )
  
  }


}
