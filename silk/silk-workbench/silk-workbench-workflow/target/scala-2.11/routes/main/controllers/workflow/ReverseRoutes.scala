// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workflow/conf/workflow.routes
// @DATE:Tue Jul 30 22:35:14 CEST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.workflow {

  // @LINE:6
  class ReverseWorkflowApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def deleteWorkflow(project:String, task:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "workflows/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
    // @LINE:22
    def removeVariableWorkflowExecution(project:String, task:String, executionId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "workflows/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/execution/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("executionId", executionId)))
    }
  
    // @LINE:10
    def getWorkflow(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "workflows/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
    // @LINE:14
    def status(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "workflows/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/status")
    }
  
    // @LINE:6
    def getWorkflows(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "workflows/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
    }
  
    // @LINE:21
    def postVariableWorkflowInputAsynchronous(project:String, task:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "workflows/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/executeOnPayloadAsynchronous")
    }
  
    // @LINE:20
    def postVariableWorkflowInput(project:String, task:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "workflows/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/executeOnPayload")
    }
  
    // @LINE:13
    def executeWorkflow(project:String, task:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "workflows/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/execute")
    }
  
    // @LINE:9
    def putWorkflow(project:String, task:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "workflows/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
    // @LINE:8
    def postWorkflow(project:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "workflows/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
    }
  
  }

  // @LINE:3
  class ReverseWorkflowEditorController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def report(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "report/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
    // @LINE:3
    def editor(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "editor/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
  }

  // @LINE:17
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public/lib/silk-workbench-workflow"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:1
  class ReverseDialogs(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def workflowTaskDialog(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/workflowDialog")
    }
  
  }


}
