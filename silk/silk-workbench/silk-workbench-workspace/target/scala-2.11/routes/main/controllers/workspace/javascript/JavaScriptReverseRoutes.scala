// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/knowledge-extraction/silk/silk-workbench/silk-workbench-workspace/conf/workspace.routes
// @DATE:Sun Dec 15 09:27:21 CET 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers.workspace.javascript {

  // @LINE:148
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:148
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:69
  class ReverseProjectMarshalingApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:82
    def exportProjectViaPlugin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ProjectMarshalingApi.exportProjectViaPlugin",
      """
        function(project0,exportPlugin1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/export/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("exportPlugin", exportPlugin1))})
        }
      """
    )
  
    // @LINE:71
    def availableMarshallingPlugins: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ProjectMarshalingApi.availableMarshallingPlugins",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "marshallingPlugins"})
        }
      """
    )
  
    // @LINE:69
    def importWorkspaceViaPlugin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ProjectMarshalingApi.importWorkspaceViaPlugin",
      """
        function(importPlugin0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "import/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("importPlugin", importPlugin0))})
        }
      """
    )
  
    // @LINE:81
    def exportProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ProjectMarshalingApi.exportProject",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/export"})
        }
      """
    )
  
    // @LINE:80
    def importProjectViaPlugin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ProjectMarshalingApi.importProjectViaPlugin",
      """
        function(project0,importPlugin1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/import/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("importPlugin", importPlugin1))})
        }
      """
    )
  
    // @LINE:79
    def importProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ProjectMarshalingApi.importProject",
      """
        function(project0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/import"})
        }
      """
    )
  
    // @LINE:70
    def exportWorkspaceViaPlugin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ProjectMarshalingApi.exportWorkspaceViaPlugin",
      """
        function(exportPlugin0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "export/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("exportPlugin", exportPlugin0))})
        }
      """
    )
  
  }

  // @LINE:29
  class ReverseDatasetApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def getMappingCoverage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.getMappingCoverage",
      """
        function(project0,name1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/datasets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1)) + "/mappingCoverage"})
        }
      """
    )
  
    // @LINE:44
    def getDatasetTypes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.getDatasetTypes",
      """
        function(project0,name1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/datasets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1)) + "/types"})
        }
      """
    )
  
    // @LINE:37
    def types: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.types",
      """
        function(project0,task1,search2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "datasets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/types" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("search", search2)])})
        }
      """
    )
  
    // @LINE:41
    def getDataset: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.getDataset",
      """
        function(project0,name1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/datasets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1))})
        }
      """
    )
  
    // @LINE:29
    def datasetDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.datasetDialog",
      """
        function(project0,task1,title2,createDialog3) {
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """ && title2 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("Create Dataset") + """ && createDialog3 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(true) + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/newDataset/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
          }
        
          if (title2 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("Edit Dataset") + """ && createDialog3 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(false) + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/editDataset/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
          }
        
        }
      """
    )
  
    // @LINE:31
    def datasetDialogAutoConfigured: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.datasetDialogAutoConfigured",
      """
        function(project0,task1,pluginId2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/editDatasetAutoConfigured/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("pluginId", pluginId2))})
        }
      """
    )
  
    // @LINE:34
    def dataset: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.dataset",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "datasets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/dataset"})
        }
      """
    )
  
    // @LINE:42
    def deleteDataset: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.deleteDataset",
      """
        function(project0,name1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/datasets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1))})
        }
      """
    )
  
    // @LINE:36
    def sparql: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.sparql",
      """
        function(project0,task1,query2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "datasets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/sparql" + _qS([(query2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("query", query2))])})
        }
      """
    )
  
    // @LINE:35
    def table: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.table",
      """
        function(project0,task1,maxEntities2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "datasets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/table" + _qS([(maxEntities2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("maxEntities", maxEntities2))])})
        }
      """
    )
  
    // @LINE:43
    def getDatasetAutoConfigured: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.getDatasetAutoConfigured",
      """
        function(project0,name1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/datasets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1)) + "/autoConfigured"})
        }
      """
    )
  
    // @LINE:40
    def putDataset: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.putDataset",
      """
        function(project0,name1,autoConfigure2) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/datasets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1)) + _qS([(autoConfigure2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Boolean]].javascriptUnbind + """)("autoConfigure", autoConfigure2))])})
        }
      """
    )
  
    // @LINE:46
    def getMappingValueCoverage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.DatasetApi.getMappingValueCoverage",
      """
        function(project0,name1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/datasets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1)) + "/mappingCoverage/values"})
        }
      """
    )
  
  }

  // @LINE:97
  class ReverseTaskApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:103
    def getTaskMetadata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.TaskApi.getTaskMetadata",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/metadata"})
        }
      """
    )
  
    // @LINE:104
    def cloneTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.TaskApi.cloneTask",
      """
        function(project0,task1,newTask2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/clone" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("newTask", newTask2)])})
        }
      """
    )
  
    // @LINE:100
    def getTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.TaskApi.getTask",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
    // @LINE:97
    def postTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.TaskApi.postTask",
      """
        function(project0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks"})
        }
      """
    )
  
    // @LINE:102
    def putTaskMetadata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.TaskApi.putTaskMetadata",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/metadata"})
        }
      """
    )
  
    // @LINE:99
    def patchTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.TaskApi.patchTask",
      """
        function(project0,task1) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
    // @LINE:101
    def deleteTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.TaskApi.deleteTask",
      """
        function(project0,task1,removeDependentTasks2) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + _qS([(removeDependentTasks2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Boolean]].javascriptUnbind + """)("removeDependentTasks", removeDependentTasks2))])})
        }
      """
    )
  
    // @LINE:105
    def copyTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.TaskApi.copyTask",
      """
        function(project0,task1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/copy"})
        }
      """
    )
  
    // @LINE:107
    def downloadOutput: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.TaskApi.downloadOutput",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/downloadOutput"})
        }
      """
    )
  
    // @LINE:106
    def cachesLoaded: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.TaskApi.cachesLoaded",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/cachesLoaded"})
        }
      """
    )
  
    // @LINE:98
    def putTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.TaskApi.putTask",
      """
        function(project0,task1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
  }

  // @LINE:72
  class ReverseSearchApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:72
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.SearchApi.search",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "searchTasks"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseWorkspaceController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def removeTaskDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.removeTaskDialog",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/removetask/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
        }
      """
    )
  
    // @LINE:14
    def importLinkSpecDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.importLinkSpecDialog",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/importlinkspec/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
        }
      """
    )
  
    // @LINE:13
    def removeResourceDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.removeResourceDialog",
      """
        function(name0,path1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/removeresource/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0)) + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("path", path1)])})
        }
      """
    )
  
    // @LINE:9
    def newProjectDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.newProjectDialog",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/newproject"})
        }
      """
    )
  
    // @LINE:21
    def taskActivityConfigDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.taskActivityConfigDialog",
      """
        function(project0,task1,activity2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/activityConfig/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2))})
        }
      """
    )
  
    // @LINE:10
    def importProjectDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.importProjectDialog",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/importproject"})
        }
      """
    )
  
    // @LINE:16
    def resourcesDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.resourcesDialog",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/resources/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
        }
      """
    )
  
    // @LINE:17
    def executeProjectDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.executeProjectDialog",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/executeProject/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
        }
      """
    )
  
    // @LINE:20
    def projectActivityConfigDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.projectActivityConfigDialog",
      """
        function(project0,activity1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/activityConfig/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity1))})
        }
      """
    )
  
    // @LINE:22
    def importExample: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.importExample",
      """
        function(project0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/importExample"})
        }
      """
    )
  
    // @LINE:18
    def cloneProjectDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.cloneProjectDialog",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/cloneProject" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("project", project0)])})
        }
      """
    )
  
    // @LINE:19
    def cloneTaskDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.cloneTaskDialog",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/cloneTask" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("project", project0), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("task", task1)])})
        }
      """
    )
  
    // @LINE:6
    def tree: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.tree",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tree"})
        }
      """
    )
  
    // @LINE:15
    def prefixDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.prefixDialog",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/prefixes/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
        }
      """
    )
  
    // @LINE:11
    def removeProjectDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.removeProjectDialog",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialogs/removeproject/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
        }
      """
    )
  
    // @LINE:7
    def activities: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.activities",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allActivities"})
        }
      """
    )
  
    // @LINE:5
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:110
  class ReverseActivityApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:141
    def getActivityStatusUpdates: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.getActivityStatusUpdates",
      """
        function(project0,task1,activity2,timestamp3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "activities/updates" + _qS([(project0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("project", project0)), (task1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("task", task1)), (activity2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("activity", activity2)), (timestamp3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Long]].javascriptUnbind + """)("timestamp", timestamp3))])})
        }
      """
    )
  
    // @LINE:139
    def recentActivities: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.recentActivities",
      """
        function(maxCount0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "activities/recent" + _qS([(maxCount0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("maxCount", maxCount0))])})
        }
      """
    )
  
    // @LINE:142
    def activityStatusUpdatesWebSocket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.activityStatusUpdatesWebSocket",
      """
        function(project0,task1,activity2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "activities/updatesWebSocket" + _qS([(project0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("project", project0)), (task1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("task", task1)), (activity2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("activity", activity2))])})
        }
      """
    )
  
    // @LINE:121
    def getTaskActivities: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.getTaskActivities",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activities"})
        }
      """
    )
  
    // @LINE:116
    def postActivityConfig: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.postActivityConfig",
      """
        function(project0,task1,activity2) {
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/config"})
          }
        
          if (true) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/config"})
          }
        
        }
      """
    )
  
    // @LINE:115
    def getActivityConfig: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.getActivityConfig",
      """
        function(project0,task1,activity2) {
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/config"})
          }
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/config"})
          }
        
        }
      """
    )
  
    // @LINE:111
    def startActivity: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.startActivity",
      """
        function(project0,task1,activity2,blocking3) {
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """ && blocking3 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(false) + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/start"})
          }
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """ && blocking3 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(true) + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/startBlocking"})
          }
        
          if (blocking3 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(false) + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/start"})
          }
        
          if (blocking3 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(true) + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/startBlocking"})
          }
        
          if (blocking3 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(false) + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "activities/start" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("project", project0), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("task", task1), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("activity", activity2)])})
          }
        
          if (blocking3 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(true) + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "activities/startBlocking" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("project", project0), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("task", task1), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("activity", activity2)])})
          }
        
        }
      """
    )
  
    // @LINE:114
    def restartActivity: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.restartActivity",
      """
        function(project0,task1,activity2,blocking3) {
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/restart" + _qS([(blocking3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Boolean]].javascriptUnbind + """)("blocking", blocking3))])})
          }
        
          if (true) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/restart" + _qS([(blocking3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Boolean]].javascriptUnbind + """)("blocking", blocking3))])})
          }
        
        }
      """
    )
  
    // @LINE:110
    def getProjectActivities: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.getProjectActivities",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/activities"})
        }
      """
    )
  
    // @LINE:140
    def activityLog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.activityLog",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "activities/log"})
        }
      """
    )
  
    // @LINE:117
    def getActivityStatus: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.getActivityStatus",
      """
        function(project0,task1,activity2) {
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/status"})
          }
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/status"})
          }
        
        }
      """
    )
  
    // @LINE:113
    def cancelActivity: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.cancelActivity",
      """
        function(project0,task1,activity2) {
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/cancel"})
          }
        
          if (true) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/cancel"})
          }
        
        }
      """
    )
  
    // @LINE:118
    def getActivityValue: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.ActivityApi.getActivityValue",
      """
        function(project0,task1,activity2) {
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/value"})
          }
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/activities/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("activity", activity2)) + "/value"})
          }
        
        }
      """
    )
  
  }

  // @LINE:67
  class ReverseWorkspaceApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:75
    def projects: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.projects",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects"})
        }
      """
    )
  
    // @LINE:67
    def reload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.reload",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reload"})
        }
      """
    )
  
    // @LINE:68
    def reloadPrefixes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.reloadPrefixes",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reloadPrefixes"})
        }
      """
    )
  
    // @LINE:78
    def deleteProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.deleteProject",
      """
        function(project0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
        }
      """
    )
  
    // @LINE:90
    def getResources: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.getResources",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/resources"})
        }
      """
    )
  
    // @LINE:76
    def getProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.getProject",
      """
        function(project0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
        }
      """
    )
  
    // @LINE:77
    def newProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.newProject",
      """
        function(project0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
        }
      """
    )
  
    // @LINE:83
    def importLinkSpec: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.importLinkSpec",
      """
        function(project0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/importLinkSpec"})
        }
      """
    )
  
    // @LINE:86
    def executeProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.executeProject",
      """
        function(project0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/execute"})
        }
      """
    )
  
    // @LINE:91
    def getResource: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.getResource",
      """
        function(project0,name1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/resources/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1))})
        }
      """
    )
  
    // @LINE:85
    def updatePrefixes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.updatePrefixes",
      """
        function(project0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/prefixes"})
        }
      """
    )
  
    // @LINE:93
    def deleteResource: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.deleteResource",
      """
        function(project0,name1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/resources/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1))})
        }
      """
    )
  
    // @LINE:92
    def putResource: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.putResource",
      """
        function(project0,name1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/resources/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1))})
        }
      """
    )
  
    // @LINE:84
    def exportLinkSpec: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.exportLinkSpec",
      """
        function(project0,task1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1)) + "/exportLinkSpec"})
        }
      """
    )
  
    // @LINE:94
    def getResourceMetadata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.getResourceMetadata",
      """
        function(project0,name1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/resources/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1)) + "/metadata"})
        }
      """
    )
  
    // @LINE:87
    def cloneProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.WorkspaceApi.cloneProject",
      """
        function(project0,newProject1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/clone" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("newProject", newProject1)])})
        }
      """
    )
  
  }

  // @LINE:53
  class ReverseCustomTasks(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:57
    def getTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.CustomTasks.getTask",
      """
        function(project0,name1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/customTasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1))})
        }
      """
    )
  
    // @LINE:58
    def pushTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.CustomTasks.pushTask",
      """
        function(project0,name1,createOnly2) {
        
          if (createOnly2 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(true) + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/customTasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1))})
          }
        
          if (createOnly2 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(false) + """) {
            return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/customTasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1))})
          }
        
        }
      """
    )
  
    // @LINE:53
    def taskDialog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.CustomTasks.taskDialog",
      """
        function(project0,task1,createDialog2) {
        
          if (task1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("") + """ && createDialog2 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(true) + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "customTasks/newTaskDialog/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0))})
          }
        
          if (createDialog2 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(false) + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "customTasks/editTaskDialog/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("task", task1))})
          }
        
        }
      """
    )
  
    // @LINE:60
    def deleteTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workspace.CustomTasks.deleteTask",
      """
        function(project0,name1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/customTasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name1))})
        }
      """
    )
  
  }


}
