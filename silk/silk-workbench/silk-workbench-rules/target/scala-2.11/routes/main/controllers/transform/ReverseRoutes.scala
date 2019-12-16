// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/knowledge-extraction/silk/silk-workbench/silk-workbench-rules/conf/transform.routes
// @DATE:Sun Dec 15 09:27:21 CET 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.transform {

  // @LINE:24
  class ReverseTransformTaskApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def executeTransformTask(project:String, task:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/executeTransform")
    }
  
    // @LINE:51
    def postTransformInput(project:String, task:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/transformInput")
    }
  
    // @LINE:25
    def putTransformTask(project:String, task:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("createOnly", false))); _rrc
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
    // @LINE:26
    def deleteTransformTask(project:String, task:String, removeDependentTasks:Boolean = false): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + play.core.routing.queryString(List(if(removeDependentTasks == false) None else Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("removeDependentTasks", removeDependentTasks)))))
    }
  
    // @LINE:27
    def getRules(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rules")
    }
  
    // @LINE:31
    def deleteRule(project:String, task:String, rule:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)))
    }
  
    // @LINE:32
    def appendRule(project:String, task:String, rule:String, afterRuleId:Option[String] = None): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)) + "/rules" + play.core.routing.queryString(List(if(afterRuleId == None) None else Some(implicitly[play.api.mvc.QueryStringBindable[Option[String]]].unbind("afterRuleId", afterRuleId)))))
    }
  
    // @LINE:24
    def getTransformTask(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
    // @LINE:35
    def reloadTransformCache(project:String, task:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/reloadCache")
    }
  
    // @LINE:29
    def getRule(project:String, task:String, rule:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)))
    }
  
    // @LINE:30
    def putRule(project:String, task:String, rule:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)))
    }
  
    // @LINE:28
    def putRules(project:String, task:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rules")
    }
  
    // @LINE:34
    def reorderRules(project:String, task:String, rule:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)) + "/rules/reorder")
    }
  
    // @LINE:33
    def copyRule(project:String, task:String, rule:String, sourceProject:String, sourceTask:String, sourceRule:String, afterRuleId:Option[String] = None): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)) + "/rules/copyFrom" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("sourceProject", sourceProject)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("sourceTask", sourceTask)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("sourceRule", sourceRule)), if(afterRuleId == None) None else Some(implicitly[play.api.mvc.QueryStringBindable[Option[String]]].unbind("afterRuleId", afterRuleId)))))
    }
  
    // @LINE:52
    def valueSourcePaths(project:String, task:String, rule:String, maxDepth:Int = Int.MaxValue, unusedOnly:Boolean = false): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)) + "/valueSourcePaths" + play.core.routing.queryString(List(if(maxDepth == Int.MaxValue) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("maxDepth", maxDepth)), if(unusedOnly == false) None else Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("unusedOnly", unusedOnly)))))
    }
  
  }

  // @LINE:7
  class ReverseTransformEditor(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def editor(project:String, task:String, rule:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/editor/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)))
    }
  
    // @LINE:7
    def start(project:String, task:String, rule:String): Call = {
    
      (project: @unchecked, task: @unchecked, rule: @unchecked) match {
      
        // @LINE:7
        case (project, task, rule) if rule == "" =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("rule", ""))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/editor")
      
        // @LINE:8
        case (project, task, rule)  =>
          
          Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/editor/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)))
      
      }
    
    }
  
    // @LINE:10
    def propertyDetails(project:String, task:String, property:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/editor/widgets/property" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("property", property)))))
    }
  
    // @LINE:11
    def paths(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/editor/widgets/paths")
    }
  
    // @LINE:13
    def score(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/editor/widgets/score")
    }
  
    // @LINE:12
    def rulePaths(project:String, task:String, rule:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/editor/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)) + "/widgets/paths")
    }
  
  }

  // @LINE:41
  class ReverseAutoCompletionApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def sourcePaths(project:String, task:String, rule:String, term:String = "", maxResults:Int = 30): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)) + "/completions/sourcePaths" + play.core.routing.queryString(List(if(term == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("term", term)), if(maxResults == 30) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("maxResults", maxResults)))))
    }
  
    // @LINE:43
    def targetProperties(project:String, task:String, rule:String, term:String = "", maxResults:Int = 30): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)) + "/completions/targetProperties" + play.core.routing.queryString(List(if(term == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("term", term)), if(maxResults == 30) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("maxResults", maxResults)))))
    }
  
    // @LINE:42
    def targetTypes(project:String, task:String, rule:String, term:String = "", maxResults:Int = 30): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)) + "/completions/targetTypes" + play.core.routing.queryString(List(if(term == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("term", term)), if(maxResults == 30) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("maxResults", maxResults)))))
    }
  
  }

  // @LINE:20
  class ReverseExecuteTransformTab(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def executionReport(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/execute/report")
    }
  
    // @LINE:20
    def execute(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/execute")
    }
  
  }

  // @LINE:45
  class ReverseTargetVocabularyApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:48
    def propertiesByType(project:String, task:String, classUri:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/targetVocabulary/propertiesByClass" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("classUri", classUri)))))
    }
  
    // @LINE:49
    def relationsOfType(project:String, task:String, classUri:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/targetVocabulary/relationsOfClass" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("classUri", classUri)))))
    }
  
    // @LINE:46
    def getPropertyInfo(project:String, task:String, uri:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/targetVocabulary/property" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("uri", uri)))))
    }
  
    // @LINE:45
    def getTypeInfo(project:String, task:String, uri:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/targetVocabulary/type" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("uri", uri)))))
    }
  
    // @LINE:47
    def getTypeOrPropertyInfo(project:String, task:String, uri:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/targetVocabulary/typeOrProperty" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("uri", uri)))))
    }
  
  }

  // @LINE:16
  class ReverseEvaluateTransform(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def evaluate(project:String, task:String, offset:Int = 0, limit:Int = 100): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/evaluate" + play.core.routing.queryString(List(if(offset == 0) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("offset", offset)), if(limit == 100) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("limit", limit)))))
    }
  
    // @LINE:17
    def generatedEntities(project:String, task:String, offset:Int = 0, limit:Int = 100): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/evaluate/generatedEntities" + play.core.routing.queryString(List(if(offset == 0) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("offset", offset)), if(limit == 100) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("limit", limit)))))
    }
  
  }

  // @LINE:2
  class ReverseTransformDialogs(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def transformationTaskDialog(project:String, task:String, createDialog:Boolean): Call = {
    
      (project: @unchecked, task: @unchecked, createDialog: @unchecked) match {
      
        // @LINE:2
        case (project, task, createDialog) if task == "" && createDialog == true =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""), ("createDialog", true))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "dialogs/newTransformTask/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
      
        // @LINE:3
        case (project, task, createDialog) if createDialog == false =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("createDialog", false))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "dialogs/editTransformTask/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
      
      }
    
    }
  
    // @LINE:4
    def deleteRuleDialog(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/deleteRule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
  }

  // @LINE:38
  class ReversePeakTransformApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def peak(project:String, task:String, rule:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/peak/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)))
    }
  
    // @LINE:39
    def peakChildRule(project:String, task:String, rule:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/peak/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("rule", rule)) + "/childRule")
    }
  
  }


}
