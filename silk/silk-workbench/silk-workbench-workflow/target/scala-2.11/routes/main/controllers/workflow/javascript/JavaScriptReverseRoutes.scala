// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/knowledge-extraction/silk/silk-workbench/silk-workbench-workflow/conf/workflow.routes
// @DATE:Sun Dec 15 09:27:21 CET 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.workflow.javascript {

  // @LINE:6
  class ReverseWorkflowApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def deleteWorkflow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowApi.deleteWorkflow",
      """
        function(project0,task1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
    // @LINE:22
    def removeVariableWorkflowExecution: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowApi.removeVariableWorkflowExecution",
      """
        function(project0,task1,executionId2) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/execution/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("executionId", executionId2))})
        }
      """
    )
  
    // @LINE:10
    def getWorkflow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowApi.getWorkflow",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
    // @LINE:14
    def status: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowApi.status",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/status"})
        }
      """
    )
  
    // @LINE:6
    def getWorkflows: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowApi.getWorkflows",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
        }
      """
    )
  
    // @LINE:21
    def postVariableWorkflowInputAsynchronous: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowApi.postVariableWorkflowInputAsynchronous",
      """
        function(project0,task1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/executeOnPayloadAsynchronous"})
        }
      """
    )
  
    // @LINE:20
    def postVariableWorkflowInput: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowApi.postVariableWorkflowInput",
      """
        function(project0,task1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/executeOnPayload"})
        }
      """
    )
  
    // @LINE:13
    def executeWorkflow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowApi.executeWorkflow",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/execute"})
        }
      """
    )
  
    // @LINE:9
    def putWorkflow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowApi.putWorkflow",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
    // @LINE:8
    def postWorkflow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowApi.postWorkflow",
      """
        function(project0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
        }
      """
    )
  
  }

  // @LINE:3
  class ReverseWorkflowEditorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def report: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowEditorController.report",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "report/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
    // @LINE:3
    def editor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.WorkflowEditorController.editor",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "editor/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:1
  class ReverseDialogs(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def workflowTaskDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.Dialogs.workflowTaskDialog",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/workflowDialog"})
        }
      """
    )
  
  }


}
