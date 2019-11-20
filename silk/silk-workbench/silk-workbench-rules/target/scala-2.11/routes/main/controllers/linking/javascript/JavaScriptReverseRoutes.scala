// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/conf/linking.routes
// @DATE:Tue Jul 30 22:35:14 CEST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.linking.javascript {

  // @LINE:26
  class ReverseLearning(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def population: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.Learning.population",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/learn/population"})
        }
      """
    )
  
    // @LINE:28
    def activeLearn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.Learning.activeLearn",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activeLearn"})
        }
      """
    )
  
    // @LINE:27
    def learn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.Learning.learn",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/learn"})
        }
      """
    )
  
    // @LINE:34
    def activeLearnCandidate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.Learning.activeLearnCandidate",
      """
        function(project0,task1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activeLearn/nextCandidate"})
        }
      """
    )
  
    // @LINE:33
    def activeLearnDetails: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.Learning.activeLearnDetails",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activeLearnDetails"})
        }
      """
    )
  
    // @LINE:29
    def rule: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.Learning.rule",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/learn/rule"})
        }
      """
    )
  
    // @LINE:35
    def resetActiveLearningDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.Learning.resetActiveLearningDialog",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activeLearn/resetDialog"})
        }
      """
    )
  
    // @LINE:32
    def populationView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.Learning.populationView",
      """
        function(project0,task1,page2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/learn/populationView/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("page", page2))})
        }
      """
    )
  
    // @LINE:36
    def resetActiveLearning: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.Learning.resetActiveLearning",
      """
        function(project0,task1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activeLearn/reset"})
        }
      """
    )
  
    // @LINE:30
    def links: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.Learning.links",
      """
        function(project0,task1,sorting2,filter3,page4) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/learn/links/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("sorting", sorting2)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("filter", filter3)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("page", page4))})
        }
      """
    )
  
    // @LINE:26
    def start: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.Learning.start",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/learnStart"})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseLinkingDialogs(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def linkingTaskDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingDialogs.linkingTaskDialog",
      """
        function(project0,task1,createDialog2) {
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """ && createDialog2 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(true) + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/newLinkingTask/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
          }
        
          if (createDialog2 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(false) + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/editLinkingTask/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
          }
        
        }
      """
    )
  
  }

  // @LINE:19
  class ReverseReferenceLinksManager(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def removeLinksDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.ReferenceLinksManager.removeLinksDialog",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/referenceLinks/removeLinksDialog"})
        }
      """
    )
  
    // @LINE:19
    def referenceLinksView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.ReferenceLinksManager.referenceLinksView",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/referenceLinks"})
        }
      """
    )
  
    // @LINE:21
    def importDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.ReferenceLinksManager.importDialog",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/referenceLinks/importDialog"})
        }
      """
    )
  
    // @LINE:20
    def addLinkDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.ReferenceLinksManager.addLinkDialog",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/referenceLinks/addLinkDialog"})
        }
      """
    )
  
    // @LINE:23
    def referenceLinks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.ReferenceLinksManager.referenceLinks",
      """
        function(project0,task1,linkType2,sorting3,filter4,page5) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/referenceLinks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("linkType", linkType2)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("sorting", sorting3)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("filter", filter4)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("page", page5))})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseExecuteLinkingController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def execute: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.ExecuteLinkingController.execute",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/execute"})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseEvaluateLinkingController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def generateLinks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.EvaluateLinkingController.generateLinks",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/evaluate"})
        }
      """
    )
  
    // @LINE:13
    def linksWebsocket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.EvaluateLinkingController.linksWebsocket",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/evaluate/linksStream"})
        }
      """
    )
  
    // @LINE:12
    def links: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.EvaluateLinkingController.links",
      """
        function(project0,task1,sorting2,filter3,page4) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/evaluate/links/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("sorting", sorting2)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("filter", filter3)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("page", page4))})
        }
      """
    )
  
  }

  // @LINE:39
  class ReverseLinkingTaskApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def putLinkSpec: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.putLinkSpec",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/linkSpec"})
        }
      """
    )
  
    // @LINE:51
    def deleteReferenceLink: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.deleteReferenceLink",
      """
        function(project0,task1,source2,target3) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/referenceLink" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("source", source2), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("target", target3)])})
        }
      """
    )
  
    // @LINE:49
    def deleteReferenceLinks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.deleteReferenceLinks",
      """
        function(project0,task1,positive2,negative3,unlabeled4) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/referenceLinks" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Boolean]].javascriptUnbind + """)("positive", positive2), (""" + implicitly[play.api.mvc.QueryStringBindable[Boolean]].javascriptUnbind + """)("negative", negative3), (""" + implicitly[play.api.mvc.QueryStringBindable[Boolean]].javascriptUnbind + """)("unlabeled", unlabeled4)])})
        }
      """
    )
  
    // @LINE:50
    def putReferenceLink: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.putReferenceLink",
      """
        function(project0,task1,linkType2,source3,target4) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/referenceLink" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("linkType", linkType2), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("source", source3), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("target", target4)])})
        }
      """
    )
  
    // @LINE:44
    def putRule: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.putRule",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule"})
        }
      """
    )
  
    // @LINE:43
    def getRule: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.getRule",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/rule"})
        }
      """
    )
  
    // @LINE:45
    def getLinkSpec: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.getLinkSpec",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/linkSpec"})
        }
      """
    )
  
    // @LINE:60
    def postLinkDatasource: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.postLinkDatasource",
      """
        function(project0,task1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/postLinkDatasource"})
        }
      """
    )
  
    // @LINE:58
    def referenceLinksEvaluated: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.referenceLinksEvaluated",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/referenceLinksEvaluated"})
        }
      """
    )
  
    // @LINE:54
    def writeReferenceLinks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.writeReferenceLinks",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/writeReferenceLinks"})
        }
      """
    )
  
    // @LINE:42
    def deleteLinkingTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.deleteLinkingTask",
      """
        function(project0,task1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
    // @LINE:47
    def getReferenceLinks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.getReferenceLinks",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/referenceLinks"})
        }
      """
    )
  
    // @LINE:48
    def putReferenceLinks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.putReferenceLinks",
      """
        function(project0,task1,generateNegative2) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/referenceLinks" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Boolean]].javascriptUnbind + """)("generateNegative", generateNegative2)])})
        }
      """
    )
  
    // @LINE:56
    def activeLearningActivity: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.activeLearningActivity",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activeLearningTask"})
        }
      """
    )
  
    // @LINE:55
    def learningActivity: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.learningActivity",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/learningTask"})
        }
      """
    )
  
    // @LINE:39
    def getLinkingTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.getLinkingTask",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
    // @LINE:40
    def pushLinkingTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.pushLinkingTask",
      """
        function(project0,task1,createOnly2) {
        
          if (createOnly2 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(true) + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
          }
        
          if (createOnly2 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(false) + """) {
            return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
          }
        
        }
      """
    )
  
    // @LINE:53
    def reloadLinkingCache: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingTaskApi.reloadLinkingCache",
      """
        function(project0,task1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/reloadCache"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseLinkingEditor(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def score: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingEditor.score",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/editor/widgets/score"})
        }
      """
    )
  
    // @LINE:7
    def paths: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingEditor.paths",
      """
        function(project0,task1,groupPaths2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/editor/widgets/paths" + _qS([(groupPaths2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Boolean]].javascriptUnbind + """)("groupPaths", groupPaths2))])})
        }
      """
    )
  
    // @LINE:6
    def editor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.linking.LinkingEditor.editor",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/editor"})
        }
      """
    )
  
  }


}
