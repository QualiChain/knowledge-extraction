// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/knowledge-extraction/silk/silk-workbench/silk-workbench-workspace/conf/workspace.routes
// @DATE:Sun Dec 15 09:27:21 CET 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers.workspace {

  // @LINE:148
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:148
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public/lib/silk-workbench-workspace"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:69
  class ReverseProjectMarshalingApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:82
    def exportProjectViaPlugin(project:String, exportPlugin:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/export/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("exportPlugin", exportPlugin)))
    }
  
    // @LINE:71
    def availableMarshallingPlugins(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "marshallingPlugins")
    }
  
    // @LINE:69
    def importWorkspaceViaPlugin(importPlugin:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "import/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("importPlugin", importPlugin)))
    }
  
    // @LINE:81
    def exportProject(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/export")
    }
  
    // @LINE:80
    def importProjectViaPlugin(project:String, importPlugin:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/import/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("importPlugin", importPlugin)))
    }
  
    // @LINE:79
    def importProject(project:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/import")
    }
  
    // @LINE:70
    def exportWorkspaceViaPlugin(exportPlugin:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "export/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("exportPlugin", exportPlugin)))
    }
  
  }

  // @LINE:29
  class ReverseDatasetApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def getMappingCoverage(project:String, name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/datasets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)) + "/mappingCoverage")
    }
  
    // @LINE:44
    def getDatasetTypes(project:String, name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/datasets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)) + "/types")
    }
  
    // @LINE:37
    def types(project:String, task:String, search:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "datasets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/types" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("search", search)))))
    }
  
    // @LINE:41
    def getDataset(project:String, name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/datasets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:29
    def datasetDialog(project:String, task:String, title:String, createDialog:Boolean): Call = {
    
      (project: @unchecked, task: @unchecked, title: @unchecked, createDialog: @unchecked) match {
      
        // @LINE:29
        case (project, task, title, createDialog) if task == "" && title == "Create Dataset" && createDialog == true =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""), ("title", "Create Dataset"), ("createDialog", true))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "dialogs/newDataset/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
      
        // @LINE:30
        case (project, task, title, createDialog) if title == "Edit Dataset" && createDialog == false =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("title", "Edit Dataset"), ("createDialog", false))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "dialogs/editDataset/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
      
      }
    
    }
  
    // @LINE:31
    def datasetDialogAutoConfigured(project:String, task:String, pluginId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/editDatasetAutoConfigured/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("pluginId", pluginId)))
    }
  
    // @LINE:34
    def dataset(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "datasets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/dataset")
    }
  
    // @LINE:42
    def deleteDataset(project:String, name:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/datasets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:36
    def sparql(project:String, task:String, query:String = ""): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "datasets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/sparql" + play.core.routing.queryString(List(if(query == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("query", query)))))
    }
  
    // @LINE:35
    def table(project:String, task:String, maxEntities:Int = 20): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "datasets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/table" + play.core.routing.queryString(List(if(maxEntities == 20) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("maxEntities", maxEntities)))))
    }
  
    // @LINE:43
    def getDatasetAutoConfigured(project:String, name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/datasets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)) + "/autoConfigured")
    }
  
    // @LINE:40
    def putDataset(project:String, name:String, autoConfigure:Boolean = false): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/datasets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)) + play.core.routing.queryString(List(if(autoConfigure == false) None else Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("autoConfigure", autoConfigure)))))
    }
  
    // @LINE:46
    def getMappingValueCoverage(project:String, name:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/datasets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)) + "/mappingCoverage/values")
    }
  
  }

  // @LINE:97
  class ReverseTaskApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:103
    def getTaskMetadata(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/metadata")
    }
  
    // @LINE:104
    def cloneTask(project:String, task:String, newTask:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/clone" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("newTask", newTask)))))
    }
  
    // @LINE:100
    def getTask(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
    // @LINE:97
    def postTask(project:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks")
    }
  
    // @LINE:102
    def putTaskMetadata(project:String, task:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/metadata")
    }
  
    // @LINE:99
    def patchTask(project:String, task:String): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
    // @LINE:101
    def deleteTask(project:String, task:String, removeDependentTasks:Boolean = false): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + play.core.routing.queryString(List(if(removeDependentTasks == false) None else Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("removeDependentTasks", removeDependentTasks)))))
    }
  
    // @LINE:105
    def copyTask(project:String, task:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/copy")
    }
  
    // @LINE:107
    def downloadOutput(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/downloadOutput")
    }
  
    // @LINE:106
    def cachesLoaded(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/cachesLoaded")
    }
  
    // @LINE:98
    def putTask(project:String, task:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
  }

  // @LINE:72
  class ReverseSearchApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:72
    def search(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "searchTasks")
    }
  
  }

  // @LINE:5
  class ReverseWorkspaceController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def removeTaskDialog(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/removetask/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
    }
  
    // @LINE:14
    def importLinkSpecDialog(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/importlinkspec/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
    }
  
    // @LINE:13
    def removeResourceDialog(name:String, path:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/removeresource/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)) + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("path", path)))))
    }
  
    // @LINE:9
    def newProjectDialog(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/newproject")
    }
  
    // @LINE:21
    def taskActivityConfigDialog(project:String, task:String, activity:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/activityConfig/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)))
    }
  
    // @LINE:10
    def importProjectDialog(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/importproject")
    }
  
    // @LINE:16
    def resourcesDialog(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/resources/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
    }
  
    // @LINE:17
    def executeProjectDialog(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/executeProject/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
    }
  
    // @LINE:20
    def projectActivityConfigDialog(project:String, activity:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/activityConfig/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)))
    }
  
    // @LINE:22
    def importExample(project:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/importExample")
    }
  
    // @LINE:18
    def cloneProjectDialog(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/cloneProject" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("project", project)))))
    }
  
    // @LINE:19
    def cloneTaskDialog(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/cloneTask" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("project", project)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("task", task)))))
    }
  
    // @LINE:6
    def tree(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tree")
    }
  
    // @LINE:15
    def prefixDialog(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/prefixes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
    }
  
    // @LINE:11
    def removeProjectDialog(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "dialogs/removeproject/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
    }
  
    // @LINE:7
    def activities(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "allActivities")
    }
  
    // @LINE:5
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:110
  class ReverseActivityApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:141
    def getActivityStatusUpdates(project:String = "", task:String = "", activity:String = "", timestamp:Long = 0L): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "activities/updates" + play.core.routing.queryString(List(if(project == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("project", project)), if(task == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("task", task)), if(activity == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("activity", activity)), if(timestamp == 0L) None else Some(implicitly[play.api.mvc.QueryStringBindable[Long]].unbind("timestamp", timestamp)))))
    }
  
    // @LINE:139
    def recentActivities(maxCount:Int = 10): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "activities/recent" + play.core.routing.queryString(List(if(maxCount == 10) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("maxCount", maxCount)))))
    }
  
    // @LINE:142
    def activityStatusUpdatesWebSocket(project:String = "", task:String = "", activity:String = ""): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "activities/updatesWebSocket" + play.core.routing.queryString(List(if(project == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("project", project)), if(task == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("task", task)), if(activity == "") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("activity", activity)))))
    }
  
    // @LINE:121
    def getTaskActivities(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activities")
    }
  
    // @LINE:116
    def postActivityConfig(project:String, task:String, activity:String): Call = {
    
      (project: @unchecked, task: @unchecked, activity: @unchecked) match {
      
        // @LINE:116
        case (project, task, activity) if task == "" =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""))); _rrc
          Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/config")
      
        // @LINE:127
        case (project, task, activity)  =>
          
          Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/config")
      
      }
    
    }
  
    // @LINE:115
    def getActivityConfig(project:String, task:String, activity:String): Call = {
    
      (project: @unchecked, task: @unchecked, activity: @unchecked) match {
      
        // @LINE:115
        case (project, task, activity) if task == "" =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/config")
      
        // @LINE:126
        case (project, task, activity)  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/config")
      
      }
    
    }
  
    // @LINE:111
    def startActivity(project:String, task:String, activity:String, blocking:Boolean): Call = {
    
      (project: @unchecked, task: @unchecked, activity: @unchecked, blocking: @unchecked) match {
      
        // @LINE:111
        case (project, task, activity, blocking) if task == "" && blocking == false =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""), ("blocking", false))); _rrc
          Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/start")
      
        // @LINE:112
        case (project, task, activity, blocking) if task == "" && blocking == true =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""), ("blocking", true))); _rrc
          Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/startBlocking")
      
        // @LINE:122
        case (project, task, activity, blocking) if blocking == false =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("blocking", false))); _rrc
          Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/start")
      
        // @LINE:123
        case (project, task, activity, blocking) if blocking == true =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("blocking", true))); _rrc
          Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/startBlocking")
      
      }
    
    }
  
    // @LINE:114
    def restartActivity(project:String, task:String, activity:String, blocking:Boolean = false): Call = {
    
      (project: @unchecked, task: @unchecked, activity: @unchecked, blocking: @unchecked) match {
      
        // @LINE:114
        case (project, task, activity, blocking) if task == "" =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""))); _rrc
          Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/restart" + play.core.routing.queryString(List(if(blocking == false) None else Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("blocking", blocking)))))
      
        // @LINE:125
        case (project, task, activity, blocking)  =>
          
          Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/restart" + play.core.routing.queryString(List(if(blocking == false) None else Some(implicitly[play.api.mvc.QueryStringBindable[Boolean]].unbind("blocking", blocking)))))
      
      }
    
    }
  
    // @LINE:110
    def getProjectActivities(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/activities")
    }
  
    // @LINE:140
    def activityLog(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "activities/log")
    }
  
    // @LINE:117
    def getActivityStatus(project:String, task:String, activity:String): Call = {
    
      (project: @unchecked, task: @unchecked, activity: @unchecked) match {
      
        // @LINE:117
        case (project, task, activity) if task == "" =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/status")
      
        // @LINE:128
        case (project, task, activity)  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/status")
      
      }
    
    }
  
    // @LINE:113
    def cancelActivity(project:String, task:String, activity:String): Call = {
    
      (project: @unchecked, task: @unchecked, activity: @unchecked) match {
      
        // @LINE:113
        case (project, task, activity) if task == "" =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""))); _rrc
          Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/cancel")
      
        // @LINE:124
        case (project, task, activity)  =>
          
          Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/cancel")
      
      }
    
    }
  
    // @LINE:118
    def getActivityValue(project:String, task:String, activity:String): Call = {
    
      (project: @unchecked, task: @unchecked, activity: @unchecked) match {
      
        // @LINE:118
        case (project, task, activity) if task == "" =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/value")
      
        // @LINE:129
        case (project, task, activity)  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/activities/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("activity", activity)) + "/value")
      
      }
    
    }
  
  }

  // @LINE:67
  class ReverseWorkspaceApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:75
    def projects(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects")
    }
  
    // @LINE:67
    def reload(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "reload")
    }
  
    // @LINE:68
    def reloadPrefixes(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "reloadPrefixes")
    }
  
    // @LINE:78
    def deleteProject(project:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
    }
  
    // @LINE:90
    def getResources(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/resources")
    }
  
    // @LINE:76
    def getProject(project:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
    }
  
    // @LINE:77
    def newProject(project:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
    }
  
    // @LINE:83
    def importLinkSpec(project:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/importLinkSpec")
    }
  
    // @LINE:86
    def executeProject(project:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/execute")
    }
  
    // @LINE:91
    def getResource(project:String, name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/resources/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:85
    def updatePrefixes(project:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/prefixes")
    }
  
    // @LINE:93
    def deleteResource(project:String, name:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/resources/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:92
    def putResource(project:String, name:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/resources/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:84
    def exportLinkSpec(project:String, task:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)) + "/exportLinkSpec")
    }
  
    // @LINE:94
    def getResourceMetadata(project:String, name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/resources/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)) + "/metadata")
    }
  
    // @LINE:87
    def cloneProject(project:String, newProject:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/clone" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("newProject", newProject)))))
    }
  
  }

  // @LINE:53
  class ReverseCustomTasks(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:57
    def getTask(project:String, name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/customTasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:58
    def pushTask(project:String, name:String, createOnly:Boolean): Call = {
    
      (project: @unchecked, name: @unchecked, createOnly: @unchecked) match {
      
        // @LINE:58
        case (project, name, createOnly) if createOnly == true =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("createOnly", true))); _rrc
          Call("POST", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/customTasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
      
        // @LINE:59
        case (project, name, createOnly) if createOnly == false =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("createOnly", false))); _rrc
          Call("PUT", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/customTasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
      
      }
    
    }
  
    // @LINE:53
    def taskDialog(project:String, task:String, createDialog:Boolean): Call = {
    
      (project: @unchecked, task: @unchecked, createDialog: @unchecked) match {
      
        // @LINE:53
        case (project, task, createDialog) if task == "" && createDialog == true =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("task", ""), ("createDialog", true))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "customTasks/newTaskDialog/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)))
      
        // @LINE:54
        case (project, task, createDialog) if createDialog == false =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("createDialog", false))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "customTasks/editTaskDialog/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("task", task)))
      
      }
    
    }
  
    // @LINE:60
    def deleteTask(project:String, name:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/customTasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
  }


}
