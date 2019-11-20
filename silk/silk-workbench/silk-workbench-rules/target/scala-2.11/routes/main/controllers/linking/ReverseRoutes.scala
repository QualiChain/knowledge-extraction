// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/conf/linking.routes
// @DATE:Tue Jul 30 22:35:14 CEST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.linking {

  // @LINE:26
  class ReverseLearning(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def population(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/learn/population")
    }
  
    // @LINE:28
    def activeLearn(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activeLearn")
    }
  
    // @LINE:27
    def learn(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/learn")
    }
  
    // @LINE:34
    def activeLearnCandidate(project:String, task:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activeLearn/nextCandidate")
    }
  
    // @LINE:33
    def activeLearnDetails(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activeLearnDetails")
    }
  
    // @LINE:29
    def rule(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/learn/rule")
    }
  
    // @LINE:35
    def resetActiveLearningDialog(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activeLearn/resetDialog")
    }
  
    // @LINE:32
    def populationView(project:String, task:String, page:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/learn/populationView/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("page", page)))
    }
  
    // @LINE:36
    def resetActiveLearning(project:String, task:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activeLearn/reset")
    }
  
    // @LINE:30
    def links(project:String, task:String, sorting:String, filter:String, page:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/learn/links/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("sorting", sorting)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("filter", filter)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("page", page)))
    }
  
    // @LINE:26
    def start(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/learnStart")
    }
  
  }

  // @LINE:2
  class ReverseLinkingDialogs(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def linkingTaskDialog(project:String, task:String, createDialog:Boolean): Call = {
    
      (project: @unchecked, task: @unchecked, createDialog: @unchecked) match {
      
        // @LINE:2
        case (project, task, createDialog) if task == "" && createDialog == true =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""), ("createDialog", true))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "dialogs/newLinkingTask/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
      
        // @LINE:3
        case (project, task, createDialog) if createDialog == false =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("createDialog", false))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "dialogs/editLinkingTask/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
      
      }
    
    }
  
  }

  // @LINE:19
  class ReverseReferenceLinksManager(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def removeLinksDialog(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/referenceLinks/removeLinksDialog")
    }
  
    // @LINE:19
    def referenceLinksView(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/referenceLinks")
    }
  
    // @LINE:21
    def importDialog(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/referenceLinks/importDialog")
    }
  
    // @LINE:20
    def addLinkDialog(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/referenceLinks/addLinkDialog")
    }
  
    // @LINE:23
    def referenceLinks(project:String, task:String, linkType:String, sorting:String, filter:String, page:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/referenceLinks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("linkType", linkType)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("sorting", sorting)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("filter", filter)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("page", page)))
    }
  
  }

  // @LINE:16
  class ReverseExecuteLinkingController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def execute(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/execute")
    }
  
  }

  // @LINE:11
  class ReverseEvaluateLinkingController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def generateLinks(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/evaluate")
    }
  
    // @LINE:13
    def linksWebsocket(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/evaluate/linksStream")
    }
  
    // @LINE:12
    def links(project:String, task:String, sorting:String, filter:String, page:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/evaluate/links/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("sorting", sorting)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("filter", filter)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("page", page)))
    }
  
  }

  // @LINE:39
  class ReverseLinkingTaskApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def putLinkSpec(project:String, task:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/linkSpec")
    }
  
    // @LINE:51
    def deleteReferenceLink(project:String, task:String, source:String, target:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/referenceLink" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("source", source)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("target", target)))))
    }
  
    // @LINE:49
    def deleteReferenceLinks(project:String, task:String, positive:Boolean, negative:Boolean, unlabeled:Boolean): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/referenceLinks" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("positive", positive)), Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("negative", negative)), Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("unlabeled", unlabeled)))))
    }
  
    // @LINE:50
    def putReferenceLink(project:String, task:String, linkType:String, source:String, target:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/referenceLink" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("linkType", linkType)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("source", source)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("target", target)))))
    }
  
    // @LINE:44
    def putRule(project:String, task:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule")
    }
  
    // @LINE:43
    def getRule(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/rule")
    }
  
    // @LINE:45
    def getLinkSpec(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/linkSpec")
    }
  
    // @LINE:60
    def postLinkDatasource(project:String, task:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/postLinkDatasource")
    }
  
    // @LINE:58
    def referenceLinksEvaluated(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/referenceLinksEvaluated")
    }
  
    // @LINE:54
    def writeReferenceLinks(project:String, task:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/writeReferenceLinks")
    }
  
    // @LINE:42
    def deleteLinkingTask(project:String, task:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
    // @LINE:47
    def getReferenceLinks(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/referenceLinks")
    }
  
    // @LINE:48
    def putReferenceLinks(project:String, task:String, generateNegative:Boolean): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/referenceLinks" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("generateNegative", generateNegative)))))
    }
  
    // @LINE:56
    def activeLearningActivity(project:String, task:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activeLearningTask")
    }
  
    // @LINE:55
    def learningActivity(project:String, task:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/learningTask")
    }
  
    // @LINE:39
    def getLinkingTask(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
    // @LINE:40
    def pushLinkingTask(project:String, task:String, createOnly:Boolean): Call = {
    
      (project: @unchecked, task: @unchecked, createOnly: @unchecked) match {
      
        // @LINE:40
        case (project, task, createOnly) if createOnly == true =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("createOnly", true))); _rrc
          Call("POST", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
      
        // @LINE:41
        case (project, task, createOnly) if createOnly == false =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("createOnly", false))); _rrc
          Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
      
      }
    
    }
  
    // @LINE:53
    def reloadLinkingCache(project:String, task:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/reloadCache")
    }
  
  }

  // @LINE:6
  class ReverseLinkingEditor(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def score(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/editor/widgets/score")
    }
  
    // @LINE:7
    def paths(project:String, task:String, groupPaths:Boolean = true): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/editor/widgets/paths" + play.core.routing.queryString(List(if(groupPaths == true) None else Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("groupPaths", groupPaths)))))
    }
  
    // @LINE:6
    def editor(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/editor")
    }
  
  }


}
