// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/conf/workspace.routes
// @DATE:Tue Jul 30 22:35:14 CEST 2019

package workspace

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  WorkspaceController_3: controllers.workspace.WorkspaceController,
  // @LINE:29
  DatasetApi_0: controllers.workspace.DatasetApi,
  // @LINE:53
  CustomTasks_1: controllers.workspace.CustomTasks,
  // @LINE:67
  WorkspaceApi_8: controllers.workspace.WorkspaceApi,
  // @LINE:69
  ProjectMarshalingApi_4: controllers.workspace.ProjectMarshalingApi,
  // @LINE:72
  SearchApi_2: controllers.workspace.SearchApi,
  // @LINE:97
  TaskApi_7: controllers.workspace.TaskApi,
  // @LINE:110
  ActivityApi_5: controllers.workspace.ActivityApi,
  // @LINE:148
  Assets_6: controllers.workspace.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    WorkspaceController_3: controllers.workspace.WorkspaceController,
    // @LINE:29
    DatasetApi_0: controllers.workspace.DatasetApi,
    // @LINE:53
    CustomTasks_1: controllers.workspace.CustomTasks,
    // @LINE:67
    WorkspaceApi_8: controllers.workspace.WorkspaceApi,
    // @LINE:69
    ProjectMarshalingApi_4: controllers.workspace.ProjectMarshalingApi,
    // @LINE:72
    SearchApi_2: controllers.workspace.SearchApi,
    // @LINE:97
    TaskApi_7: controllers.workspace.TaskApi,
    // @LINE:110
    ActivityApi_5: controllers.workspace.ActivityApi,
    // @LINE:148
    Assets_6: controllers.workspace.Assets
  ) = this(errorHandler, WorkspaceController_3, DatasetApi_0, CustomTasks_1, WorkspaceApi_8, ProjectMarshalingApi_4, SearchApi_2, TaskApi_7, ActivityApi_5, Assets_6, "/")

  def withPrefix(prefix: String): Routes = {
    workspace.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, WorkspaceController_3, DatasetApi_0, CustomTasks_1, WorkspaceApi_8, ProjectMarshalingApi_4, SearchApi_2, TaskApi_7, ActivityApi_5, Assets_6, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.workspace.WorkspaceController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tree""", """controllers.workspace.WorkspaceController.tree"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allActivities""", """controllers.workspace.WorkspaceController.activities"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/newproject""", """controllers.workspace.WorkspaceController.newProjectDialog()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/importproject""", """controllers.workspace.WorkspaceController.importProjectDialog()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/removeproject/""" + "$" + """project<[^/]+>""", """controllers.workspace.WorkspaceController.removeProjectDialog(project:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/removetask/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.workspace.WorkspaceController.removeTaskDialog(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/removeresource/""" + "$" + """name<[^/]+>""", """controllers.workspace.WorkspaceController.removeResourceDialog(name:String, path:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/importlinkspec/""" + "$" + """project<[^/]+>""", """controllers.workspace.WorkspaceController.importLinkSpecDialog(project:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/prefixes/""" + "$" + """project<[^/]+>""", """controllers.workspace.WorkspaceController.prefixDialog(project:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/resources/""" + "$" + """project<[^/]+>""", """controllers.workspace.WorkspaceController.resourcesDialog(project:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/executeProject/""" + "$" + """project<[^/]+>""", """controllers.workspace.WorkspaceController.executeProjectDialog(project:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/cloneProject""", """controllers.workspace.WorkspaceController.cloneProjectDialog(project:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/cloneTask""", """controllers.workspace.WorkspaceController.cloneTaskDialog(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/activityConfig/""" + "$" + """project<[^/]+>/""" + "$" + """activity<[^/]+>""", """controllers.workspace.WorkspaceController.projectActivityConfigDialog(project:String, activity:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/activityConfig/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/""" + "$" + """activity<[^/]+>""", """controllers.workspace.WorkspaceController.taskActivityConfigDialog(project:String, task:String, activity:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/importExample""", """controllers.workspace.WorkspaceController.importExample(project:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/newDataset/""" + "$" + """project<[^/]+>""", """controllers.workspace.DatasetApi.datasetDialog(project:String, task:String = "", title:String = "Create Dataset", createDialog:Boolean = true)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/editDataset/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.workspace.DatasetApi.datasetDialog(project:String, task:String, title:String = "Edit Dataset", createDialog:Boolean = false)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/editDatasetAutoConfigured/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/""" + "$" + """pluginId<[^/]+>""", """controllers.workspace.DatasetApi.datasetDialogAutoConfigured(project:String, task:String, pluginId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """datasets/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/dataset""", """controllers.workspace.DatasetApi.dataset(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """datasets/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/table""", """controllers.workspace.DatasetApi.table(project:String, task:String, maxEntities:Int ?= 20)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """datasets/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/sparql""", """controllers.workspace.DatasetApi.sparql(project:String, task:String, query:String ?= "")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """datasets/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/types""", """controllers.workspace.DatasetApi.types(project:String, task:String, search:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>""", """controllers.workspace.DatasetApi.putDataset(project:String, name:String, autoConfigure:Boolean ?= false)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>""", """controllers.workspace.DatasetApi.getDataset(project:String, name:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>""", """controllers.workspace.DatasetApi.deleteDataset(project:String, name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>/autoConfigured""", """controllers.workspace.DatasetApi.getDatasetAutoConfigured(project:String, name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>/types""", """controllers.workspace.DatasetApi.getDatasetTypes(project:String, name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>/mappingCoverage""", """controllers.workspace.DatasetApi.getMappingCoverage(project:String, name:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>/mappingCoverage/values""", """controllers.workspace.DatasetApi.getMappingValueCoverage(project:String, name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """customTasks/newTaskDialog/""" + "$" + """project<[^/]+>""", """controllers.workspace.CustomTasks.taskDialog(project:String, task:String = "", createDialog:Boolean = true)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """customTasks/editTaskDialog/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.workspace.CustomTasks.taskDialog(project:String, task:String, createDialog:Boolean = false)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/customTasks/""" + "$" + """name<[^/]+>""", """controllers.workspace.CustomTasks.getTask(project:String, name:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/customTasks/""" + "$" + """name<[^/]+>""", """controllers.workspace.CustomTasks.pushTask(project:String, name:String, createOnly:Boolean = true)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/customTasks/""" + "$" + """name<[^/]+>""", """controllers.workspace.CustomTasks.pushTask(project:String, name:String, createOnly:Boolean = false)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/customTasks/""" + "$" + """name<[^/]+>""", """controllers.workspace.CustomTasks.deleteTask(project:String, name:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """reload""", """controllers.workspace.WorkspaceApi.reload"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """reloadPrefixes""", """controllers.workspace.WorkspaceApi.reloadPrefixes"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """import/""" + "$" + """importPlugin<[^/]+>""", """controllers.workspace.ProjectMarshalingApi.importWorkspaceViaPlugin(importPlugin:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """export/""" + "$" + """exportPlugin<[^/]+>""", """controllers.workspace.ProjectMarshalingApi.exportWorkspaceViaPlugin(exportPlugin:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """marshallingPlugins""", """controllers.workspace.ProjectMarshalingApi.availableMarshallingPlugins()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchTasks""", """controllers.workspace.SearchApi.search()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects""", """controllers.workspace.WorkspaceApi.projects"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>""", """controllers.workspace.WorkspaceApi.getProject(project:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>""", """controllers.workspace.WorkspaceApi.newProject(project:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>""", """controllers.workspace.WorkspaceApi.deleteProject(project:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/import""", """controllers.workspace.ProjectMarshalingApi.importProject(project:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/import/""" + "$" + """importPlugin<[^/]+>""", """controllers.workspace.ProjectMarshalingApi.importProjectViaPlugin(project:String, importPlugin:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/export""", """controllers.workspace.ProjectMarshalingApi.exportProject(project:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/export/""" + "$" + """exportPlugin<[^/]+>""", """controllers.workspace.ProjectMarshalingApi.exportProjectViaPlugin(project:String, exportPlugin:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/importLinkSpec""", """controllers.workspace.WorkspaceApi.importLinkSpec(project:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/exportLinkSpec""", """controllers.workspace.WorkspaceApi.exportLinkSpec(project:String, task:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/prefixes""", """controllers.workspace.WorkspaceApi.updatePrefixes(project:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/execute""", """controllers.workspace.WorkspaceApi.executeProject(project:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/clone""", """controllers.workspace.WorkspaceApi.cloneProject(project:String, newProject:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/resources""", """controllers.workspace.WorkspaceApi.getResources(project:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/resources/""" + "$" + """name<[^/]+>""", """controllers.workspace.WorkspaceApi.getResource(project:String, name:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/resources/""" + "$" + """name<[^/]+>""", """controllers.workspace.WorkspaceApi.putResource(project:String, name:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/resources/""" + "$" + """name<[^/]+>""", """controllers.workspace.WorkspaceApi.deleteResource(project:String, name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/resources/""" + "$" + """name<[^/]+>/metadata""", """controllers.workspace.WorkspaceApi.getResourceMetadata(project:String, name:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks""", """controllers.workspace.TaskApi.postTask(project:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>""", """controllers.workspace.TaskApi.putTask(project:String, task:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>""", """controllers.workspace.TaskApi.patchTask(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>""", """controllers.workspace.TaskApi.getTask(project:String, task:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>""", """controllers.workspace.TaskApi.deleteTask(project:String, task:String, removeDependentTasks:Boolean ?= false)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/metadata""", """controllers.workspace.TaskApi.putTaskMetadata(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/metadata""", """controllers.workspace.TaskApi.getTaskMetadata(project:String, task:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/clone""", """controllers.workspace.TaskApi.cloneTask(project:String, task:String, newTask:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/copy""", """controllers.workspace.TaskApi.copyTask(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/cachesLoaded""", """controllers.workspace.TaskApi.cachesLoaded(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/downloadOutput""", """controllers.workspace.TaskApi.downloadOutput(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/activities""", """controllers.workspace.ActivityApi.getProjectActivities(project:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/start""", """controllers.workspace.ActivityApi.startActivity(project:String, task:String = "", activity:String, blocking:Boolean = false)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/startBlocking""", """controllers.workspace.ActivityApi.startActivity(project:String, task:String = "", activity:String, blocking:Boolean = true)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/cancel""", """controllers.workspace.ActivityApi.cancelActivity(project:String, task:String = "", activity:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/restart""", """controllers.workspace.ActivityApi.restartActivity(project:String, task:String = "", activity:String, blocking:Boolean ?= false)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/config""", """controllers.workspace.ActivityApi.getActivityConfig(project:String, task:String = "", activity:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/config""", """controllers.workspace.ActivityApi.postActivityConfig(project:String, task:String = "", activity:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/status""", """controllers.workspace.ActivityApi.getActivityStatus(project:String, task:String = "", activity:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/value""", """controllers.workspace.ActivityApi.getActivityValue(project:String, task:String = "", activity:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities""", """controllers.workspace.ActivityApi.getTaskActivities(project:String, task:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/start""", """controllers.workspace.ActivityApi.startActivity(project:String, task:String, activity:String, blocking:Boolean = false)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/startBlocking""", """controllers.workspace.ActivityApi.startActivity(project:String, task:String, activity:String, blocking:Boolean = true)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/cancel""", """controllers.workspace.ActivityApi.cancelActivity(project:String, task:String, activity:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/restart""", """controllers.workspace.ActivityApi.restartActivity(project:String, task:String, activity:String, blocking:Boolean ?= false)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/config""", """controllers.workspace.ActivityApi.getActivityConfig(project:String, task:String, activity:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/config""", """controllers.workspace.ActivityApi.postActivityConfig(project:String, task:String, activity:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/status""", """controllers.workspace.ActivityApi.getActivityStatus(project:String, task:String, activity:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/value""", """controllers.workspace.ActivityApi.getActivityValue(project:String, task:String, activity:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activities/start""", """controllers.workspace.ActivityApi.startActivity(project:String, task:String, activity:String, blocking:Boolean = false)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activities/startBlocking""", """controllers.workspace.ActivityApi.startActivity(project:String, task:String, activity:String, blocking:Boolean = true)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activities/cancel""", """controllers.workspace.ActivityApi.cancelActivity(project:String, task:String, activity:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activities/restart""", """controllers.workspace.ActivityApi.restartActivity(project:String, task:String, activity:String, blocking:Boolean ?= false)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activities/config""", """controllers.workspace.ActivityApi.getActivityConfig(project:String, task:String, activity:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activities/config""", """controllers.workspace.ActivityApi.postActivityConfig(project:String, task:String, activity:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activities/status""", """controllers.workspace.ActivityApi.getActivityStatus(project:String, task:String, activity:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activities/recent""", """controllers.workspace.ActivityApi.recentActivities(maxCount:Int ?= 10)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activities/log""", """controllers.workspace.ActivityApi.activityLog()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activities/updates""", """controllers.workspace.ActivityApi.getActivityStatusUpdates(project:String ?= "", task:String ?= "", activity:String ?= "", timestamp:Long ?= 0L)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """activities/updatesWebSocket""", """controllers.workspace.ActivityApi.activityStatusUpdatesWebSocket(project:String ?= "", task:String ?= "", activity:String ?= "")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.workspace.Assets.at(path:String = "/public/lib/silk-workbench-workspace", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_workspace_WorkspaceController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_index0_invoker = createInvoker(
    WorkspaceController_3.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_workspace_WorkspaceController_tree1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tree")))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_tree1_invoker = createInvoker(
    WorkspaceController_3.tree,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "tree",
      Nil,
      "GET",
      this.prefix + """tree""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_workspace_WorkspaceController_activities2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allActivities")))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_activities2_invoker = createInvoker(
    WorkspaceController_3.activities,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "activities",
      Nil,
      "GET",
      this.prefix + """allActivities""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_workspace_WorkspaceController_newProjectDialog3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/newproject")))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_newProjectDialog3_invoker = createInvoker(
    WorkspaceController_3.newProjectDialog(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "newProjectDialog",
      Nil,
      "GET",
      this.prefix + """dialogs/newproject""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_workspace_WorkspaceController_importProjectDialog4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/importproject")))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_importProjectDialog4_invoker = createInvoker(
    WorkspaceController_3.importProjectDialog(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "importProjectDialog",
      Nil,
      "GET",
      this.prefix + """dialogs/importproject""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_workspace_WorkspaceController_removeProjectDialog5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/removeproject/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_removeProjectDialog5_invoker = createInvoker(
    WorkspaceController_3.removeProjectDialog(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "removeProjectDialog",
      Seq(classOf[String]),
      "GET",
      this.prefix + """dialogs/removeproject/""" + "$" + """project<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_workspace_WorkspaceController_removeTaskDialog6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/removetask/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_removeTaskDialog6_invoker = createInvoker(
    WorkspaceController_3.removeTaskDialog(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "removeTaskDialog",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """dialogs/removetask/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_workspace_WorkspaceController_removeResourceDialog7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/removeresource/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_removeResourceDialog7_invoker = createInvoker(
    WorkspaceController_3.removeResourceDialog(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "removeResourceDialog",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """dialogs/removeresource/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_workspace_WorkspaceController_importLinkSpecDialog8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/importlinkspec/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_importLinkSpecDialog8_invoker = createInvoker(
    WorkspaceController_3.importLinkSpecDialog(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "importLinkSpecDialog",
      Seq(classOf[String]),
      "GET",
      this.prefix + """dialogs/importlinkspec/""" + "$" + """project<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_workspace_WorkspaceController_prefixDialog9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/prefixes/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_prefixDialog9_invoker = createInvoker(
    WorkspaceController_3.prefixDialog(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "prefixDialog",
      Seq(classOf[String]),
      "GET",
      this.prefix + """dialogs/prefixes/""" + "$" + """project<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_workspace_WorkspaceController_resourcesDialog10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/resources/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_resourcesDialog10_invoker = createInvoker(
    WorkspaceController_3.resourcesDialog(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "resourcesDialog",
      Seq(classOf[String]),
      "GET",
      this.prefix + """dialogs/resources/""" + "$" + """project<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_workspace_WorkspaceController_executeProjectDialog11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/executeProject/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_executeProjectDialog11_invoker = createInvoker(
    WorkspaceController_3.executeProjectDialog(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "executeProjectDialog",
      Seq(classOf[String]),
      "GET",
      this.prefix + """dialogs/executeProject/""" + "$" + """project<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_workspace_WorkspaceController_cloneProjectDialog12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/cloneProject")))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_cloneProjectDialog12_invoker = createInvoker(
    WorkspaceController_3.cloneProjectDialog(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "cloneProjectDialog",
      Seq(classOf[String]),
      "GET",
      this.prefix + """dialogs/cloneProject""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_workspace_WorkspaceController_cloneTaskDialog13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/cloneTask")))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_cloneTaskDialog13_invoker = createInvoker(
    WorkspaceController_3.cloneTaskDialog(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "cloneTaskDialog",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """dialogs/cloneTask""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_workspace_WorkspaceController_projectActivityConfigDialog14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/activityConfig/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("activity", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_projectActivityConfigDialog14_invoker = createInvoker(
    WorkspaceController_3.projectActivityConfigDialog(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "projectActivityConfigDialog",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """dialogs/activityConfig/""" + "$" + """project<[^/]+>/""" + "$" + """activity<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_workspace_WorkspaceController_taskActivityConfigDialog15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/activityConfig/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/"), DynamicPart("activity", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_taskActivityConfigDialog15_invoker = createInvoker(
    WorkspaceController_3.taskActivityConfigDialog(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "taskActivityConfigDialog",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """dialogs/activityConfig/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/""" + "$" + """activity<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_workspace_WorkspaceController_importExample16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/importExample")))
  )
  private[this] lazy val controllers_workspace_WorkspaceController_importExample16_invoker = createInvoker(
    WorkspaceController_3.importExample(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceController",
      "importExample",
      Seq(classOf[String]),
      "POST",
      this.prefix + """""" + "$" + """project<[^/]+>/importExample""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_workspace_DatasetApi_datasetDialog17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/newDataset/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_DatasetApi_datasetDialog17_invoker = createInvoker(
    DatasetApi_0.datasetDialog(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "datasetDialog",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """dialogs/newDataset/""" + "$" + """project<[^/]+>""",
      """ Dialogs""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_workspace_DatasetApi_datasetDialog18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/editDataset/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_DatasetApi_datasetDialog18_invoker = createInvoker(
    DatasetApi_0.datasetDialog(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "datasetDialog",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """dialogs/editDataset/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_workspace_DatasetApi_datasetDialogAutoConfigured19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/editDatasetAutoConfigured/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/"), DynamicPart("pluginId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_DatasetApi_datasetDialogAutoConfigured19_invoker = createInvoker(
    DatasetApi_0.datasetDialogAutoConfigured(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "datasetDialogAutoConfigured",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """dialogs/editDatasetAutoConfigured/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/""" + "$" + """pluginId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_workspace_DatasetApi_dataset20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("datasets/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/dataset")))
  )
  private[this] lazy val controllers_workspace_DatasetApi_dataset20_invoker = createInvoker(
    DatasetApi_0.dataset(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "dataset",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """datasets/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/dataset""",
      """ Tabs""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_workspace_DatasetApi_table21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("datasets/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/table")))
  )
  private[this] lazy val controllers_workspace_DatasetApi_table21_invoker = createInvoker(
    DatasetApi_0.table(fakeValue[String], fakeValue[String], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "table",
      Seq(classOf[String], classOf[String], classOf[Int]),
      "GET",
      this.prefix + """datasets/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/table""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_workspace_DatasetApi_sparql22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("datasets/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/sparql")))
  )
  private[this] lazy val controllers_workspace_DatasetApi_sparql22_invoker = createInvoker(
    DatasetApi_0.sparql(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "sparql",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """datasets/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/sparql""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_workspace_DatasetApi_types23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("datasets/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/types")))
  )
  private[this] lazy val controllers_workspace_DatasetApi_types23_invoker = createInvoker(
    DatasetApi_0.types(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "types",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """datasets/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/types""",
      """""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_workspace_DatasetApi_putDataset24_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/datasets/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_DatasetApi_putDataset24_invoker = createInvoker(
    DatasetApi_0.putDataset(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "putDataset",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "PUT",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>""",
      """ API""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_workspace_DatasetApi_getDataset25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/datasets/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_DatasetApi_getDataset25_invoker = createInvoker(
    DatasetApi_0.getDataset(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "getDataset",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_workspace_DatasetApi_deleteDataset26_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/datasets/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_DatasetApi_deleteDataset26_invoker = createInvoker(
    DatasetApi_0.deleteDataset(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "deleteDataset",
      Seq(classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_workspace_DatasetApi_getDatasetAutoConfigured27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/datasets/"), DynamicPart("name", """[^/]+""",true), StaticPart("/autoConfigured")))
  )
  private[this] lazy val controllers_workspace_DatasetApi_getDatasetAutoConfigured27_invoker = createInvoker(
    DatasetApi_0.getDatasetAutoConfigured(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "getDatasetAutoConfigured",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>/autoConfigured""",
      """""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val controllers_workspace_DatasetApi_getDatasetTypes28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/datasets/"), DynamicPart("name", """[^/]+""",true), StaticPart("/types")))
  )
  private[this] lazy val controllers_workspace_DatasetApi_getDatasetTypes28_invoker = createInvoker(
    DatasetApi_0.getDatasetTypes(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "getDatasetTypes",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>/types""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_workspace_DatasetApi_getMappingCoverage29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/datasets/"), DynamicPart("name", """[^/]+""",true), StaticPart("/mappingCoverage")))
  )
  private[this] lazy val controllers_workspace_DatasetApi_getMappingCoverage29_invoker = createInvoker(
    DatasetApi_0.getMappingCoverage(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "getMappingCoverage",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>/mappingCoverage""",
      """""",
      Seq()
    )
  )

  // @LINE:46
  private[this] lazy val controllers_workspace_DatasetApi_getMappingValueCoverage30_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/datasets/"), DynamicPart("name", """[^/]+""",true), StaticPart("/mappingCoverage/values")))
  )
  private[this] lazy val controllers_workspace_DatasetApi_getMappingValueCoverage30_invoker = createInvoker(
    DatasetApi_0.getMappingValueCoverage(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.DatasetApi",
      "getMappingValueCoverage",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/datasets/""" + "$" + """name<[^/]+>/mappingCoverage/values""",
      """""",
      Seq()
    )
  )

  // @LINE:53
  private[this] lazy val controllers_workspace_CustomTasks_taskDialog31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("customTasks/newTaskDialog/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_CustomTasks_taskDialog31_invoker = createInvoker(
    CustomTasks_1.taskDialog(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.CustomTasks",
      "taskDialog",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """customTasks/newTaskDialog/""" + "$" + """project<[^/]+>""",
      """ Dialogs""",
      Seq()
    )
  )

  // @LINE:54
  private[this] lazy val controllers_workspace_CustomTasks_taskDialog32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("customTasks/editTaskDialog/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_CustomTasks_taskDialog32_invoker = createInvoker(
    CustomTasks_1.taskDialog(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.CustomTasks",
      "taskDialog",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """customTasks/editTaskDialog/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:57
  private[this] lazy val controllers_workspace_CustomTasks_getTask33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/customTasks/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_CustomTasks_getTask33_invoker = createInvoker(
    CustomTasks_1.getTask(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.CustomTasks",
      "getTask",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/customTasks/""" + "$" + """name<[^/]+>""",
      """ API""",
      Seq()
    )
  )

  // @LINE:58
  private[this] lazy val controllers_workspace_CustomTasks_pushTask34_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/customTasks/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_CustomTasks_pushTask34_invoker = createInvoker(
    CustomTasks_1.pushTask(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.CustomTasks",
      "pushTask",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/customTasks/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:59
  private[this] lazy val controllers_workspace_CustomTasks_pushTask35_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/customTasks/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_CustomTasks_pushTask35_invoker = createInvoker(
    CustomTasks_1.pushTask(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.CustomTasks",
      "pushTask",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "PUT",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/customTasks/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:60
  private[this] lazy val controllers_workspace_CustomTasks_deleteTask36_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/customTasks/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_CustomTasks_deleteTask36_invoker = createInvoker(
    CustomTasks_1.deleteTask(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.CustomTasks",
      "deleteTask",
      Seq(classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/customTasks/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:67
  private[this] lazy val controllers_workspace_WorkspaceApi_reload37_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("reload")))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_reload37_invoker = createInvoker(
    WorkspaceApi_8.reload,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "reload",
      Nil,
      "POST",
      this.prefix + """reload""",
      """ Reload Workspace""",
      Seq()
    )
  )

  // @LINE:68
  private[this] lazy val controllers_workspace_WorkspaceApi_reloadPrefixes38_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("reloadPrefixes")))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_reloadPrefixes38_invoker = createInvoker(
    WorkspaceApi_8.reloadPrefixes,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "reloadPrefixes",
      Nil,
      "POST",
      this.prefix + """reloadPrefixes""",
      """""",
      Seq()
    )
  )

  // @LINE:69
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_importWorkspaceViaPlugin39_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("import/"), DynamicPart("importPlugin", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_importWorkspaceViaPlugin39_invoker = createInvoker(
    ProjectMarshalingApi_4.importWorkspaceViaPlugin(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ProjectMarshalingApi",
      "importWorkspaceViaPlugin",
      Seq(classOf[String]),
      "POST",
      this.prefix + """import/""" + "$" + """importPlugin<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:70
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_exportWorkspaceViaPlugin40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("export/"), DynamicPart("exportPlugin", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_exportWorkspaceViaPlugin40_invoker = createInvoker(
    ProjectMarshalingApi_4.exportWorkspaceViaPlugin(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ProjectMarshalingApi",
      "exportWorkspaceViaPlugin",
      Seq(classOf[String]),
      "GET",
      this.prefix + """export/""" + "$" + """exportPlugin<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:71
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_availableMarshallingPlugins41_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("marshallingPlugins")))
  )
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_availableMarshallingPlugins41_invoker = createInvoker(
    ProjectMarshalingApi_4.availableMarshallingPlugins(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ProjectMarshalingApi",
      "availableMarshallingPlugins",
      Nil,
      "GET",
      this.prefix + """marshallingPlugins""",
      """""",
      Seq()
    )
  )

  // @LINE:72
  private[this] lazy val controllers_workspace_SearchApi_search42_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchTasks")))
  )
  private[this] lazy val controllers_workspace_SearchApi_search42_invoker = createInvoker(
    SearchApi_2.search(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.SearchApi",
      "search",
      Nil,
      "POST",
      this.prefix + """searchTasks""",
      """""",
      Seq()
    )
  )

  // @LINE:75
  private[this] lazy val controllers_workspace_WorkspaceApi_projects43_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects")))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_projects43_invoker = createInvoker(
    WorkspaceApi_8.projects,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "projects",
      Nil,
      "GET",
      this.prefix + """projects""",
      """ Projects""",
      Seq()
    )
  )

  // @LINE:76
  private[this] lazy val controllers_workspace_WorkspaceApi_getProject44_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_getProject44_invoker = createInvoker(
    WorkspaceApi_8.getProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "getProject",
      Seq(classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:77
  private[this] lazy val controllers_workspace_WorkspaceApi_newProject45_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_newProject45_invoker = createInvoker(
    WorkspaceApi_8.newProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "newProject",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """projects/""" + "$" + """project<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:78
  private[this] lazy val controllers_workspace_WorkspaceApi_deleteProject46_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_deleteProject46_invoker = createInvoker(
    WorkspaceApi_8.deleteProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "deleteProject",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """projects/""" + "$" + """project<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:79
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_importProject47_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/import")))
  )
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_importProject47_invoker = createInvoker(
    ProjectMarshalingApi_4.importProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ProjectMarshalingApi",
      "importProject",
      Seq(classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/import""",
      """""",
      Seq()
    )
  )

  // @LINE:80
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_importProjectViaPlugin48_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/import/"), DynamicPart("importPlugin", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_importProjectViaPlugin48_invoker = createInvoker(
    ProjectMarshalingApi_4.importProjectViaPlugin(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ProjectMarshalingApi",
      "importProjectViaPlugin",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/import/""" + "$" + """importPlugin<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:81
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_exportProject49_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/export")))
  )
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_exportProject49_invoker = createInvoker(
    ProjectMarshalingApi_4.exportProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ProjectMarshalingApi",
      "exportProject",
      Seq(classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/export""",
      """""",
      Seq()
    )
  )

  // @LINE:82
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_exportProjectViaPlugin50_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/export/"), DynamicPart("exportPlugin", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_ProjectMarshalingApi_exportProjectViaPlugin50_invoker = createInvoker(
    ProjectMarshalingApi_4.exportProjectViaPlugin(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ProjectMarshalingApi",
      "exportProjectViaPlugin",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/export/""" + "$" + """exportPlugin<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:83
  private[this] lazy val controllers_workspace_WorkspaceApi_importLinkSpec51_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/importLinkSpec")))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_importLinkSpec51_invoker = createInvoker(
    WorkspaceApi_8.importLinkSpec(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "importLinkSpec",
      Seq(classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/importLinkSpec""",
      """""",
      Seq()
    )
  )

  // @LINE:84
  private[this] lazy val controllers_workspace_WorkspaceApi_exportLinkSpec52_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/exportLinkSpec")))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_exportLinkSpec52_invoker = createInvoker(
    WorkspaceApi_8.exportLinkSpec(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "exportLinkSpec",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/exportLinkSpec""",
      """""",
      Seq()
    )
  )

  // @LINE:85
  private[this] lazy val controllers_workspace_WorkspaceApi_updatePrefixes53_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/prefixes")))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_updatePrefixes53_invoker = createInvoker(
    WorkspaceApi_8.updatePrefixes(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "updatePrefixes",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/prefixes""",
      """""",
      Seq()
    )
  )

  // @LINE:86
  private[this] lazy val controllers_workspace_WorkspaceApi_executeProject54_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/execute")))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_executeProject54_invoker = createInvoker(
    WorkspaceApi_8.executeProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "executeProject",
      Seq(classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/execute""",
      """""",
      Seq()
    )
  )

  // @LINE:87
  private[this] lazy val controllers_workspace_WorkspaceApi_cloneProject55_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/clone")))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_cloneProject55_invoker = createInvoker(
    WorkspaceApi_8.cloneProject(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "cloneProject",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/clone""",
      """""",
      Seq()
    )
  )

  // @LINE:90
  private[this] lazy val controllers_workspace_WorkspaceApi_getResources56_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/resources")))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_getResources56_invoker = createInvoker(
    WorkspaceApi_8.getResources(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "getResources",
      Seq(classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/resources""",
      """ Resources""",
      Seq()
    )
  )

  // @LINE:91
  private[this] lazy val controllers_workspace_WorkspaceApi_getResource57_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/resources/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_getResource57_invoker = createInvoker(
    WorkspaceApi_8.getResource(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "getResource",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/resources/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:92
  private[this] lazy val controllers_workspace_WorkspaceApi_putResource58_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/resources/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_putResource58_invoker = createInvoker(
    WorkspaceApi_8.putResource(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "putResource",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/resources/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:93
  private[this] lazy val controllers_workspace_WorkspaceApi_deleteResource59_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/resources/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_deleteResource59_invoker = createInvoker(
    WorkspaceApi_8.deleteResource(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "deleteResource",
      Seq(classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/resources/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:94
  private[this] lazy val controllers_workspace_WorkspaceApi_getResourceMetadata60_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/resources/"), DynamicPart("name", """[^/]+""",true), StaticPart("/metadata")))
  )
  private[this] lazy val controllers_workspace_WorkspaceApi_getResourceMetadata60_invoker = createInvoker(
    WorkspaceApi_8.getResourceMetadata(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.WorkspaceApi",
      "getResourceMetadata",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/resources/""" + "$" + """name<[^/]+>/metadata""",
      """""",
      Seq()
    )
  )

  // @LINE:97
  private[this] lazy val controllers_workspace_TaskApi_postTask61_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks")))
  )
  private[this] lazy val controllers_workspace_TaskApi_postTask61_invoker = createInvoker(
    TaskApi_7.postTask(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.TaskApi",
      "postTask",
      Seq(classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks""",
      """ Tasks""",
      Seq()
    )
  )

  // @LINE:98
  private[this] lazy val controllers_workspace_TaskApi_putTask62_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_TaskApi_putTask62_invoker = createInvoker(
    TaskApi_7.putTask(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.TaskApi",
      "putTask",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:99
  private[this] lazy val controllers_workspace_TaskApi_patchTask63_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_TaskApi_patchTask63_invoker = createInvoker(
    TaskApi_7.patchTask(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.TaskApi",
      "patchTask",
      Seq(classOf[String], classOf[String]),
      "PATCH",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:100
  private[this] lazy val controllers_workspace_TaskApi_getTask64_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_TaskApi_getTask64_invoker = createInvoker(
    TaskApi_7.getTask(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.TaskApi",
      "getTask",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:101
  private[this] lazy val controllers_workspace_TaskApi_deleteTask65_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workspace_TaskApi_deleteTask65_invoker = createInvoker(
    TaskApi_7.deleteTask(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.TaskApi",
      "deleteTask",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "DELETE",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:102
  private[this] lazy val controllers_workspace_TaskApi_putTaskMetadata66_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/metadata")))
  )
  private[this] lazy val controllers_workspace_TaskApi_putTaskMetadata66_invoker = createInvoker(
    TaskApi_7.putTaskMetadata(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.TaskApi",
      "putTaskMetadata",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/metadata""",
      """""",
      Seq()
    )
  )

  // @LINE:103
  private[this] lazy val controllers_workspace_TaskApi_getTaskMetadata67_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/metadata")))
  )
  private[this] lazy val controllers_workspace_TaskApi_getTaskMetadata67_invoker = createInvoker(
    TaskApi_7.getTaskMetadata(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.TaskApi",
      "getTaskMetadata",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/metadata""",
      """""",
      Seq()
    )
  )

  // @LINE:104
  private[this] lazy val controllers_workspace_TaskApi_cloneTask68_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/clone")))
  )
  private[this] lazy val controllers_workspace_TaskApi_cloneTask68_invoker = createInvoker(
    TaskApi_7.cloneTask(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.TaskApi",
      "cloneTask",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/clone""",
      """""",
      Seq()
    )
  )

  // @LINE:105
  private[this] lazy val controllers_workspace_TaskApi_copyTask69_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/copy")))
  )
  private[this] lazy val controllers_workspace_TaskApi_copyTask69_invoker = createInvoker(
    TaskApi_7.copyTask(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.TaskApi",
      "copyTask",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/copy""",
      """""",
      Seq()
    )
  )

  // @LINE:106
  private[this] lazy val controllers_workspace_TaskApi_cachesLoaded70_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/cachesLoaded")))
  )
  private[this] lazy val controllers_workspace_TaskApi_cachesLoaded70_invoker = createInvoker(
    TaskApi_7.cachesLoaded(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.TaskApi",
      "cachesLoaded",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/cachesLoaded""",
      """""",
      Seq()
    )
  )

  // @LINE:107
  private[this] lazy val controllers_workspace_TaskApi_downloadOutput71_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/downloadOutput")))
  )
  private[this] lazy val controllers_workspace_TaskApi_downloadOutput71_invoker = createInvoker(
    TaskApi_7.downloadOutput(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.TaskApi",
      "downloadOutput",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/downloadOutput""",
      """""",
      Seq()
    )
  )

  // @LINE:110
  private[this] lazy val controllers_workspace_ActivityApi_getProjectActivities72_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/activities")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_getProjectActivities72_invoker = createInvoker(
    ActivityApi_5.getProjectActivities(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "getProjectActivities",
      Seq(classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/activities""",
      """ Project Activities""",
      Seq()
    )
  )

  // @LINE:111
  private[this] lazy val controllers_workspace_ActivityApi_startActivity73_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/start")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_startActivity73_invoker = createInvoker(
    ActivityApi_5.startActivity(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "startActivity",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Boolean]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/start""",
      """""",
      Seq()
    )
  )

  // @LINE:112
  private[this] lazy val controllers_workspace_ActivityApi_startActivity74_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/startBlocking")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_startActivity74_invoker = createInvoker(
    ActivityApi_5.startActivity(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "startActivity",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Boolean]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/startBlocking""",
      """""",
      Seq()
    )
  )

  // @LINE:113
  private[this] lazy val controllers_workspace_ActivityApi_cancelActivity75_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/cancel")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_cancelActivity75_invoker = createInvoker(
    ActivityApi_5.cancelActivity(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "cancelActivity",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/cancel""",
      """""",
      Seq()
    )
  )

  // @LINE:114
  private[this] lazy val controllers_workspace_ActivityApi_restartActivity76_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/restart")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_restartActivity76_invoker = createInvoker(
    ActivityApi_5.restartActivity(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "restartActivity",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Boolean]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/restart""",
      """""",
      Seq()
    )
  )

  // @LINE:115
  private[this] lazy val controllers_workspace_ActivityApi_getActivityConfig77_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/config")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_getActivityConfig77_invoker = createInvoker(
    ActivityApi_5.getActivityConfig(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "getActivityConfig",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/config""",
      """""",
      Seq()
    )
  )

  // @LINE:116
  private[this] lazy val controllers_workspace_ActivityApi_postActivityConfig78_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/config")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_postActivityConfig78_invoker = createInvoker(
    ActivityApi_5.postActivityConfig(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "postActivityConfig",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/config""",
      """""",
      Seq()
    )
  )

  // @LINE:117
  private[this] lazy val controllers_workspace_ActivityApi_getActivityStatus79_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/status")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_getActivityStatus79_invoker = createInvoker(
    ActivityApi_5.getActivityStatus(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "getActivityStatus",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/status""",
      """""",
      Seq()
    )
  )

  // @LINE:118
  private[this] lazy val controllers_workspace_ActivityApi_getActivityValue80_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/value")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_getActivityValue80_invoker = createInvoker(
    ActivityApi_5.getActivityValue(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "getActivityValue",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/activities/""" + "$" + """activity<[^/]+>/value""",
      """""",
      Seq()
    )
  )

  // @LINE:121
  private[this] lazy val controllers_workspace_ActivityApi_getTaskActivities81_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activities")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_getTaskActivities81_invoker = createInvoker(
    ActivityApi_5.getTaskActivities(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "getTaskActivities",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities""",
      """ Task Activities""",
      Seq()
    )
  )

  // @LINE:122
  private[this] lazy val controllers_workspace_ActivityApi_startActivity82_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/start")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_startActivity82_invoker = createInvoker(
    ActivityApi_5.startActivity(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "startActivity",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Boolean]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/start""",
      """""",
      Seq()
    )
  )

  // @LINE:123
  private[this] lazy val controllers_workspace_ActivityApi_startActivity83_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/startBlocking")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_startActivity83_invoker = createInvoker(
    ActivityApi_5.startActivity(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "startActivity",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Boolean]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/startBlocking""",
      """""",
      Seq()
    )
  )

  // @LINE:124
  private[this] lazy val controllers_workspace_ActivityApi_cancelActivity84_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/cancel")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_cancelActivity84_invoker = createInvoker(
    ActivityApi_5.cancelActivity(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "cancelActivity",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/cancel""",
      """""",
      Seq()
    )
  )

  // @LINE:125
  private[this] lazy val controllers_workspace_ActivityApi_restartActivity85_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/restart")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_restartActivity85_invoker = createInvoker(
    ActivityApi_5.restartActivity(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "restartActivity",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Boolean]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/restart""",
      """""",
      Seq()
    )
  )

  // @LINE:126
  private[this] lazy val controllers_workspace_ActivityApi_getActivityConfig86_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/config")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_getActivityConfig86_invoker = createInvoker(
    ActivityApi_5.getActivityConfig(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "getActivityConfig",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/config""",
      """""",
      Seq()
    )
  )

  // @LINE:127
  private[this] lazy val controllers_workspace_ActivityApi_postActivityConfig87_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/config")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_postActivityConfig87_invoker = createInvoker(
    ActivityApi_5.postActivityConfig(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "postActivityConfig",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/config""",
      """""",
      Seq()
    )
  )

  // @LINE:128
  private[this] lazy val controllers_workspace_ActivityApi_getActivityStatus88_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/status")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_getActivityStatus88_invoker = createInvoker(
    ActivityApi_5.getActivityStatus(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "getActivityStatus",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/status""",
      """""",
      Seq()
    )
  )

  // @LINE:129
  private[this] lazy val controllers_workspace_ActivityApi_getActivityValue89_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projects/"), DynamicPart("project", """[^/]+""",true), StaticPart("/tasks/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activities/"), DynamicPart("activity", """[^/]+""",true), StaticPart("/value")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_getActivityValue89_invoker = createInvoker(
    ActivityApi_5.getActivityValue(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "getActivityValue",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """projects/""" + "$" + """project<[^/]+>/tasks/""" + "$" + """task<[^/]+>/activities/""" + "$" + """activity<[^/]+>/value""",
      """""",
      Seq()
    )
  )

  // @LINE:132
  private[this] lazy val controllers_workspace_ActivityApi_startActivity90_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activities/start")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_startActivity90_invoker = createInvoker(
    ActivityApi_5.startActivity(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "startActivity",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Boolean]),
      "POST",
      this.prefix + """activities/start""",
      """ General Activities API""",
      Seq()
    )
  )

  // @LINE:133
  private[this] lazy val controllers_workspace_ActivityApi_startActivity91_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activities/startBlocking")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_startActivity91_invoker = createInvoker(
    ActivityApi_5.startActivity(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "startActivity",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Boolean]),
      "POST",
      this.prefix + """activities/startBlocking""",
      """""",
      Seq()
    )
  )

  // @LINE:134
  private[this] lazy val controllers_workspace_ActivityApi_cancelActivity92_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activities/cancel")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_cancelActivity92_invoker = createInvoker(
    ActivityApi_5.cancelActivity(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "cancelActivity",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """activities/cancel""",
      """""",
      Seq()
    )
  )

  // @LINE:135
  private[this] lazy val controllers_workspace_ActivityApi_restartActivity93_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activities/restart")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_restartActivity93_invoker = createInvoker(
    ActivityApi_5.restartActivity(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "restartActivity",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Boolean]),
      "POST",
      this.prefix + """activities/restart""",
      """""",
      Seq()
    )
  )

  // @LINE:136
  private[this] lazy val controllers_workspace_ActivityApi_getActivityConfig94_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activities/config")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_getActivityConfig94_invoker = createInvoker(
    ActivityApi_5.getActivityConfig(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "getActivityConfig",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """activities/config""",
      """""",
      Seq()
    )
  )

  // @LINE:137
  private[this] lazy val controllers_workspace_ActivityApi_postActivityConfig95_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activities/config")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_postActivityConfig95_invoker = createInvoker(
    ActivityApi_5.postActivityConfig(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "postActivityConfig",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """activities/config""",
      """""",
      Seq()
    )
  )

  // @LINE:138
  private[this] lazy val controllers_workspace_ActivityApi_getActivityStatus96_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activities/status")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_getActivityStatus96_invoker = createInvoker(
    ActivityApi_5.getActivityStatus(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "getActivityStatus",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """activities/status""",
      """""",
      Seq()
    )
  )

  // @LINE:139
  private[this] lazy val controllers_workspace_ActivityApi_recentActivities97_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activities/recent")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_recentActivities97_invoker = createInvoker(
    ActivityApi_5.recentActivities(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "recentActivities",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """activities/recent""",
      """""",
      Seq()
    )
  )

  // @LINE:140
  private[this] lazy val controllers_workspace_ActivityApi_activityLog98_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activities/log")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_activityLog98_invoker = createInvoker(
    ActivityApi_5.activityLog(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "activityLog",
      Nil,
      "GET",
      this.prefix + """activities/log""",
      """""",
      Seq()
    )
  )

  // @LINE:141
  private[this] lazy val controllers_workspace_ActivityApi_getActivityStatusUpdates99_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activities/updates")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_getActivityStatusUpdates99_invoker = createInvoker(
    ActivityApi_5.getActivityStatusUpdates(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "getActivityStatusUpdates",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Long]),
      "GET",
      this.prefix + """activities/updates""",
      """""",
      Seq()
    )
  )

  // @LINE:142
  private[this] lazy val controllers_workspace_ActivityApi_activityStatusUpdatesWebSocket100_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("activities/updatesWebSocket")))
  )
  private[this] lazy val controllers_workspace_ActivityApi_activityStatusUpdatesWebSocket100_invoker = createInvoker(
    ActivityApi_5.activityStatusUpdatesWebSocket(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.ActivityApi",
      "activityStatusUpdatesWebSocket",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """activities/updatesWebSocket""",
      """""",
      Seq()
    )
  )

  // @LINE:148
  private[this] lazy val controllers_workspace_Assets_at101_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_workspace_Assets_at101_invoker = createInvoker(
    Assets_6.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workspace",
      "controllers.workspace.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_workspace_WorkspaceController_index0_route(params@_) =>
      call { 
        controllers_workspace_WorkspaceController_index0_invoker.call(WorkspaceController_3.index)
      }
  
    // @LINE:6
    case controllers_workspace_WorkspaceController_tree1_route(params@_) =>
      call { 
        controllers_workspace_WorkspaceController_tree1_invoker.call(WorkspaceController_3.tree)
      }
  
    // @LINE:7
    case controllers_workspace_WorkspaceController_activities2_route(params@_) =>
      call { 
        controllers_workspace_WorkspaceController_activities2_invoker.call(WorkspaceController_3.activities)
      }
  
    // @LINE:9
    case controllers_workspace_WorkspaceController_newProjectDialog3_route(params@_) =>
      call { 
        controllers_workspace_WorkspaceController_newProjectDialog3_invoker.call(WorkspaceController_3.newProjectDialog())
      }
  
    // @LINE:10
    case controllers_workspace_WorkspaceController_importProjectDialog4_route(params@_) =>
      call { 
        controllers_workspace_WorkspaceController_importProjectDialog4_invoker.call(WorkspaceController_3.importProjectDialog())
      }
  
    // @LINE:11
    case controllers_workspace_WorkspaceController_removeProjectDialog5_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceController_removeProjectDialog5_invoker.call(WorkspaceController_3.removeProjectDialog(project))
      }
  
    // @LINE:12
    case controllers_workspace_WorkspaceController_removeTaskDialog6_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_WorkspaceController_removeTaskDialog6_invoker.call(WorkspaceController_3.removeTaskDialog(project, task))
      }
  
    // @LINE:13
    case controllers_workspace_WorkspaceController_removeResourceDialog7_route(params@_) =>
      call(params.fromPath[String]("name", None), params.fromQuery[String]("path", None)) { (name, path) =>
        controllers_workspace_WorkspaceController_removeResourceDialog7_invoker.call(WorkspaceController_3.removeResourceDialog(name, path))
      }
  
    // @LINE:14
    case controllers_workspace_WorkspaceController_importLinkSpecDialog8_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceController_importLinkSpecDialog8_invoker.call(WorkspaceController_3.importLinkSpecDialog(project))
      }
  
    // @LINE:15
    case controllers_workspace_WorkspaceController_prefixDialog9_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceController_prefixDialog9_invoker.call(WorkspaceController_3.prefixDialog(project))
      }
  
    // @LINE:16
    case controllers_workspace_WorkspaceController_resourcesDialog10_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceController_resourcesDialog10_invoker.call(WorkspaceController_3.resourcesDialog(project))
      }
  
    // @LINE:17
    case controllers_workspace_WorkspaceController_executeProjectDialog11_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceController_executeProjectDialog11_invoker.call(WorkspaceController_3.executeProjectDialog(project))
      }
  
    // @LINE:18
    case controllers_workspace_WorkspaceController_cloneProjectDialog12_route(params@_) =>
      call(params.fromQuery[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceController_cloneProjectDialog12_invoker.call(WorkspaceController_3.cloneProjectDialog(project))
      }
  
    // @LINE:19
    case controllers_workspace_WorkspaceController_cloneTaskDialog13_route(params@_) =>
      call(params.fromQuery[String]("project", None), params.fromQuery[String]("task", None)) { (project, task) =>
        controllers_workspace_WorkspaceController_cloneTaskDialog13_invoker.call(WorkspaceController_3.cloneTaskDialog(project, task))
      }
  
    // @LINE:20
    case controllers_workspace_WorkspaceController_projectActivityConfigDialog14_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("activity", None)) { (project, activity) =>
        controllers_workspace_WorkspaceController_projectActivityConfigDialog14_invoker.call(WorkspaceController_3.projectActivityConfigDialog(project, activity))
      }
  
    // @LINE:21
    case controllers_workspace_WorkspaceController_taskActivityConfigDialog15_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_WorkspaceController_taskActivityConfigDialog15_invoker.call(WorkspaceController_3.taskActivityConfigDialog(project, task, activity))
      }
  
    // @LINE:22
    case controllers_workspace_WorkspaceController_importExample16_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceController_importExample16_invoker.call(WorkspaceController_3.importExample(project))
      }
  
    // @LINE:29
    case controllers_workspace_DatasetApi_datasetDialog17_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), Param[String]("title", Right("Create Dataset")), Param[Boolean]("createDialog", Right(true))) { (project, task, title, createDialog) =>
        controllers_workspace_DatasetApi_datasetDialog17_invoker.call(DatasetApi_0.datasetDialog(project, task, title, createDialog))
      }
  
    // @LINE:30
    case controllers_workspace_DatasetApi_datasetDialog18_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), Param[String]("title", Right("Edit Dataset")), Param[Boolean]("createDialog", Right(false))) { (project, task, title, createDialog) =>
        controllers_workspace_DatasetApi_datasetDialog18_invoker.call(DatasetApi_0.datasetDialog(project, task, title, createDialog))
      }
  
    // @LINE:31
    case controllers_workspace_DatasetApi_datasetDialogAutoConfigured19_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("pluginId", None)) { (project, task, pluginId) =>
        controllers_workspace_DatasetApi_datasetDialogAutoConfigured19_invoker.call(DatasetApi_0.datasetDialogAutoConfigured(project, task, pluginId))
      }
  
    // @LINE:34
    case controllers_workspace_DatasetApi_dataset20_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_DatasetApi_dataset20_invoker.call(DatasetApi_0.dataset(project, task))
      }
  
    // @LINE:35
    case controllers_workspace_DatasetApi_table21_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[Int]("maxEntities", Some(20))) { (project, task, maxEntities) =>
        controllers_workspace_DatasetApi_table21_invoker.call(DatasetApi_0.table(project, task, maxEntities))
      }
  
    // @LINE:36
    case controllers_workspace_DatasetApi_sparql22_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[String]("query", Some(""))) { (project, task, query) =>
        controllers_workspace_DatasetApi_sparql22_invoker.call(DatasetApi_0.sparql(project, task, query))
      }
  
    // @LINE:37
    case controllers_workspace_DatasetApi_types23_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[String]("search", None)) { (project, task, search) =>
        controllers_workspace_DatasetApi_types23_invoker.call(DatasetApi_0.types(project, task, search))
      }
  
    // @LINE:40
    case controllers_workspace_DatasetApi_putDataset24_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None), params.fromQuery[Boolean]("autoConfigure", Some(false))) { (project, name, autoConfigure) =>
        controllers_workspace_DatasetApi_putDataset24_invoker.call(DatasetApi_0.putDataset(project, name, autoConfigure))
      }
  
    // @LINE:41
    case controllers_workspace_DatasetApi_getDataset25_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_DatasetApi_getDataset25_invoker.call(DatasetApi_0.getDataset(project, name))
      }
  
    // @LINE:42
    case controllers_workspace_DatasetApi_deleteDataset26_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_DatasetApi_deleteDataset26_invoker.call(DatasetApi_0.deleteDataset(project, name))
      }
  
    // @LINE:43
    case controllers_workspace_DatasetApi_getDatasetAutoConfigured27_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_DatasetApi_getDatasetAutoConfigured27_invoker.call(DatasetApi_0.getDatasetAutoConfigured(project, name))
      }
  
    // @LINE:44
    case controllers_workspace_DatasetApi_getDatasetTypes28_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_DatasetApi_getDatasetTypes28_invoker.call(DatasetApi_0.getDatasetTypes(project, name))
      }
  
    // @LINE:45
    case controllers_workspace_DatasetApi_getMappingCoverage29_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_DatasetApi_getMappingCoverage29_invoker.call(DatasetApi_0.getMappingCoverage(project, name))
      }
  
    // @LINE:46
    case controllers_workspace_DatasetApi_getMappingValueCoverage30_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_DatasetApi_getMappingValueCoverage30_invoker.call(DatasetApi_0.getMappingValueCoverage(project, name))
      }
  
    // @LINE:53
    case controllers_workspace_CustomTasks_taskDialog31_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), Param[Boolean]("createDialog", Right(true))) { (project, task, createDialog) =>
        controllers_workspace_CustomTasks_taskDialog31_invoker.call(CustomTasks_1.taskDialog(project, task, createDialog))
      }
  
    // @LINE:54
    case controllers_workspace_CustomTasks_taskDialog32_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), Param[Boolean]("createDialog", Right(false))) { (project, task, createDialog) =>
        controllers_workspace_CustomTasks_taskDialog32_invoker.call(CustomTasks_1.taskDialog(project, task, createDialog))
      }
  
    // @LINE:57
    case controllers_workspace_CustomTasks_getTask33_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_CustomTasks_getTask33_invoker.call(CustomTasks_1.getTask(project, name))
      }
  
    // @LINE:58
    case controllers_workspace_CustomTasks_pushTask34_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None), Param[Boolean]("createOnly", Right(true))) { (project, name, createOnly) =>
        controllers_workspace_CustomTasks_pushTask34_invoker.call(CustomTasks_1.pushTask(project, name, createOnly))
      }
  
    // @LINE:59
    case controllers_workspace_CustomTasks_pushTask35_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None), Param[Boolean]("createOnly", Right(false))) { (project, name, createOnly) =>
        controllers_workspace_CustomTasks_pushTask35_invoker.call(CustomTasks_1.pushTask(project, name, createOnly))
      }
  
    // @LINE:60
    case controllers_workspace_CustomTasks_deleteTask36_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_CustomTasks_deleteTask36_invoker.call(CustomTasks_1.deleteTask(project, name))
      }
  
    // @LINE:67
    case controllers_workspace_WorkspaceApi_reload37_route(params@_) =>
      call { 
        controllers_workspace_WorkspaceApi_reload37_invoker.call(WorkspaceApi_8.reload)
      }
  
    // @LINE:68
    case controllers_workspace_WorkspaceApi_reloadPrefixes38_route(params@_) =>
      call { 
        controllers_workspace_WorkspaceApi_reloadPrefixes38_invoker.call(WorkspaceApi_8.reloadPrefixes)
      }
  
    // @LINE:69
    case controllers_workspace_ProjectMarshalingApi_importWorkspaceViaPlugin39_route(params@_) =>
      call(params.fromPath[String]("importPlugin", None)) { (importPlugin) =>
        controllers_workspace_ProjectMarshalingApi_importWorkspaceViaPlugin39_invoker.call(ProjectMarshalingApi_4.importWorkspaceViaPlugin(importPlugin))
      }
  
    // @LINE:70
    case controllers_workspace_ProjectMarshalingApi_exportWorkspaceViaPlugin40_route(params@_) =>
      call(params.fromPath[String]("exportPlugin", None)) { (exportPlugin) =>
        controllers_workspace_ProjectMarshalingApi_exportWorkspaceViaPlugin40_invoker.call(ProjectMarshalingApi_4.exportWorkspaceViaPlugin(exportPlugin))
      }
  
    // @LINE:71
    case controllers_workspace_ProjectMarshalingApi_availableMarshallingPlugins41_route(params@_) =>
      call { 
        controllers_workspace_ProjectMarshalingApi_availableMarshallingPlugins41_invoker.call(ProjectMarshalingApi_4.availableMarshallingPlugins())
      }
  
    // @LINE:72
    case controllers_workspace_SearchApi_search42_route(params@_) =>
      call { 
        controllers_workspace_SearchApi_search42_invoker.call(SearchApi_2.search())
      }
  
    // @LINE:75
    case controllers_workspace_WorkspaceApi_projects43_route(params@_) =>
      call { 
        controllers_workspace_WorkspaceApi_projects43_invoker.call(WorkspaceApi_8.projects)
      }
  
    // @LINE:76
    case controllers_workspace_WorkspaceApi_getProject44_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceApi_getProject44_invoker.call(WorkspaceApi_8.getProject(project))
      }
  
    // @LINE:77
    case controllers_workspace_WorkspaceApi_newProject45_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceApi_newProject45_invoker.call(WorkspaceApi_8.newProject(project))
      }
  
    // @LINE:78
    case controllers_workspace_WorkspaceApi_deleteProject46_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceApi_deleteProject46_invoker.call(WorkspaceApi_8.deleteProject(project))
      }
  
    // @LINE:79
    case controllers_workspace_ProjectMarshalingApi_importProject47_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_ProjectMarshalingApi_importProject47_invoker.call(ProjectMarshalingApi_4.importProject(project))
      }
  
    // @LINE:80
    case controllers_workspace_ProjectMarshalingApi_importProjectViaPlugin48_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("importPlugin", None)) { (project, importPlugin) =>
        controllers_workspace_ProjectMarshalingApi_importProjectViaPlugin48_invoker.call(ProjectMarshalingApi_4.importProjectViaPlugin(project, importPlugin))
      }
  
    // @LINE:81
    case controllers_workspace_ProjectMarshalingApi_exportProject49_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_ProjectMarshalingApi_exportProject49_invoker.call(ProjectMarshalingApi_4.exportProject(project))
      }
  
    // @LINE:82
    case controllers_workspace_ProjectMarshalingApi_exportProjectViaPlugin50_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("exportPlugin", None)) { (project, exportPlugin) =>
        controllers_workspace_ProjectMarshalingApi_exportProjectViaPlugin50_invoker.call(ProjectMarshalingApi_4.exportProjectViaPlugin(project, exportPlugin))
      }
  
    // @LINE:83
    case controllers_workspace_WorkspaceApi_importLinkSpec51_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceApi_importLinkSpec51_invoker.call(WorkspaceApi_8.importLinkSpec(project))
      }
  
    // @LINE:84
    case controllers_workspace_WorkspaceApi_exportLinkSpec52_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_WorkspaceApi_exportLinkSpec52_invoker.call(WorkspaceApi_8.exportLinkSpec(project, task))
      }
  
    // @LINE:85
    case controllers_workspace_WorkspaceApi_updatePrefixes53_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceApi_updatePrefixes53_invoker.call(WorkspaceApi_8.updatePrefixes(project))
      }
  
    // @LINE:86
    case controllers_workspace_WorkspaceApi_executeProject54_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceApi_executeProject54_invoker.call(WorkspaceApi_8.executeProject(project))
      }
  
    // @LINE:87
    case controllers_workspace_WorkspaceApi_cloneProject55_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromQuery[String]("newProject", None)) { (project, newProject) =>
        controllers_workspace_WorkspaceApi_cloneProject55_invoker.call(WorkspaceApi_8.cloneProject(project, newProject))
      }
  
    // @LINE:90
    case controllers_workspace_WorkspaceApi_getResources56_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_WorkspaceApi_getResources56_invoker.call(WorkspaceApi_8.getResources(project))
      }
  
    // @LINE:91
    case controllers_workspace_WorkspaceApi_getResource57_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_WorkspaceApi_getResource57_invoker.call(WorkspaceApi_8.getResource(project, name))
      }
  
    // @LINE:92
    case controllers_workspace_WorkspaceApi_putResource58_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_WorkspaceApi_putResource58_invoker.call(WorkspaceApi_8.putResource(project, name))
      }
  
    // @LINE:93
    case controllers_workspace_WorkspaceApi_deleteResource59_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_WorkspaceApi_deleteResource59_invoker.call(WorkspaceApi_8.deleteResource(project, name))
      }
  
    // @LINE:94
    case controllers_workspace_WorkspaceApi_getResourceMetadata60_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("name", None)) { (project, name) =>
        controllers_workspace_WorkspaceApi_getResourceMetadata60_invoker.call(WorkspaceApi_8.getResourceMetadata(project, name))
      }
  
    // @LINE:97
    case controllers_workspace_TaskApi_postTask61_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_TaskApi_postTask61_invoker.call(TaskApi_7.postTask(project))
      }
  
    // @LINE:98
    case controllers_workspace_TaskApi_putTask62_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_TaskApi_putTask62_invoker.call(TaskApi_7.putTask(project, task))
      }
  
    // @LINE:99
    case controllers_workspace_TaskApi_patchTask63_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_TaskApi_patchTask63_invoker.call(TaskApi_7.patchTask(project, task))
      }
  
    // @LINE:100
    case controllers_workspace_TaskApi_getTask64_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_TaskApi_getTask64_invoker.call(TaskApi_7.getTask(project, task))
      }
  
    // @LINE:101
    case controllers_workspace_TaskApi_deleteTask65_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[Boolean]("removeDependentTasks", Some(false))) { (project, task, removeDependentTasks) =>
        controllers_workspace_TaskApi_deleteTask65_invoker.call(TaskApi_7.deleteTask(project, task, removeDependentTasks))
      }
  
    // @LINE:102
    case controllers_workspace_TaskApi_putTaskMetadata66_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_TaskApi_putTaskMetadata66_invoker.call(TaskApi_7.putTaskMetadata(project, task))
      }
  
    // @LINE:103
    case controllers_workspace_TaskApi_getTaskMetadata67_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_TaskApi_getTaskMetadata67_invoker.call(TaskApi_7.getTaskMetadata(project, task))
      }
  
    // @LINE:104
    case controllers_workspace_TaskApi_cloneTask68_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[String]("newTask", None)) { (project, task, newTask) =>
        controllers_workspace_TaskApi_cloneTask68_invoker.call(TaskApi_7.cloneTask(project, task, newTask))
      }
  
    // @LINE:105
    case controllers_workspace_TaskApi_copyTask69_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_TaskApi_copyTask69_invoker.call(TaskApi_7.copyTask(project, task))
      }
  
    // @LINE:106
    case controllers_workspace_TaskApi_cachesLoaded70_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_TaskApi_cachesLoaded70_invoker.call(TaskApi_7.cachesLoaded(project, task))
      }
  
    // @LINE:107
    case controllers_workspace_TaskApi_downloadOutput71_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_TaskApi_downloadOutput71_invoker.call(TaskApi_7.downloadOutput(project, task))
      }
  
    // @LINE:110
    case controllers_workspace_ActivityApi_getProjectActivities72_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workspace_ActivityApi_getProjectActivities72_invoker.call(ActivityApi_5.getProjectActivities(project))
      }
  
    // @LINE:111
    case controllers_workspace_ActivityApi_startActivity73_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), params.fromPath[String]("activity", None), Param[Boolean]("blocking", Right(false))) { (project, task, activity, blocking) =>
        controllers_workspace_ActivityApi_startActivity73_invoker.call(ActivityApi_5.startActivity(project, task, activity, blocking))
      }
  
    // @LINE:112
    case controllers_workspace_ActivityApi_startActivity74_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), params.fromPath[String]("activity", None), Param[Boolean]("blocking", Right(true))) { (project, task, activity, blocking) =>
        controllers_workspace_ActivityApi_startActivity74_invoker.call(ActivityApi_5.startActivity(project, task, activity, blocking))
      }
  
    // @LINE:113
    case controllers_workspace_ActivityApi_cancelActivity75_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), params.fromPath[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_cancelActivity75_invoker.call(ActivityApi_5.cancelActivity(project, task, activity))
      }
  
    // @LINE:114
    case controllers_workspace_ActivityApi_restartActivity76_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), params.fromPath[String]("activity", None), params.fromQuery[Boolean]("blocking", Some(false))) { (project, task, activity, blocking) =>
        controllers_workspace_ActivityApi_restartActivity76_invoker.call(ActivityApi_5.restartActivity(project, task, activity, blocking))
      }
  
    // @LINE:115
    case controllers_workspace_ActivityApi_getActivityConfig77_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), params.fromPath[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_getActivityConfig77_invoker.call(ActivityApi_5.getActivityConfig(project, task, activity))
      }
  
    // @LINE:116
    case controllers_workspace_ActivityApi_postActivityConfig78_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), params.fromPath[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_postActivityConfig78_invoker.call(ActivityApi_5.postActivityConfig(project, task, activity))
      }
  
    // @LINE:117
    case controllers_workspace_ActivityApi_getActivityStatus79_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), params.fromPath[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_getActivityStatus79_invoker.call(ActivityApi_5.getActivityStatus(project, task, activity))
      }
  
    // @LINE:118
    case controllers_workspace_ActivityApi_getActivityValue80_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), params.fromPath[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_getActivityValue80_invoker.call(ActivityApi_5.getActivityValue(project, task, activity))
      }
  
    // @LINE:121
    case controllers_workspace_ActivityApi_getTaskActivities81_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workspace_ActivityApi_getTaskActivities81_invoker.call(ActivityApi_5.getTaskActivities(project, task))
      }
  
    // @LINE:122
    case controllers_workspace_ActivityApi_startActivity82_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("activity", None), Param[Boolean]("blocking", Right(false))) { (project, task, activity, blocking) =>
        controllers_workspace_ActivityApi_startActivity82_invoker.call(ActivityApi_5.startActivity(project, task, activity, blocking))
      }
  
    // @LINE:123
    case controllers_workspace_ActivityApi_startActivity83_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("activity", None), Param[Boolean]("blocking", Right(true))) { (project, task, activity, blocking) =>
        controllers_workspace_ActivityApi_startActivity83_invoker.call(ActivityApi_5.startActivity(project, task, activity, blocking))
      }
  
    // @LINE:124
    case controllers_workspace_ActivityApi_cancelActivity84_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_cancelActivity84_invoker.call(ActivityApi_5.cancelActivity(project, task, activity))
      }
  
    // @LINE:125
    case controllers_workspace_ActivityApi_restartActivity85_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("activity", None), params.fromQuery[Boolean]("blocking", Some(false))) { (project, task, activity, blocking) =>
        controllers_workspace_ActivityApi_restartActivity85_invoker.call(ActivityApi_5.restartActivity(project, task, activity, blocking))
      }
  
    // @LINE:126
    case controllers_workspace_ActivityApi_getActivityConfig86_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_getActivityConfig86_invoker.call(ActivityApi_5.getActivityConfig(project, task, activity))
      }
  
    // @LINE:127
    case controllers_workspace_ActivityApi_postActivityConfig87_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_postActivityConfig87_invoker.call(ActivityApi_5.postActivityConfig(project, task, activity))
      }
  
    // @LINE:128
    case controllers_workspace_ActivityApi_getActivityStatus88_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_getActivityStatus88_invoker.call(ActivityApi_5.getActivityStatus(project, task, activity))
      }
  
    // @LINE:129
    case controllers_workspace_ActivityApi_getActivityValue89_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_getActivityValue89_invoker.call(ActivityApi_5.getActivityValue(project, task, activity))
      }
  
    // @LINE:132
    case controllers_workspace_ActivityApi_startActivity90_route(params@_) =>
      call(params.fromQuery[String]("project", None), params.fromQuery[String]("task", None), params.fromQuery[String]("activity", None), Param[Boolean]("blocking", Right(false))) { (project, task, activity, blocking) =>
        controllers_workspace_ActivityApi_startActivity90_invoker.call(ActivityApi_5.startActivity(project, task, activity, blocking))
      }
  
    // @LINE:133
    case controllers_workspace_ActivityApi_startActivity91_route(params@_) =>
      call(params.fromQuery[String]("project", None), params.fromQuery[String]("task", None), params.fromQuery[String]("activity", None), Param[Boolean]("blocking", Right(true))) { (project, task, activity, blocking) =>
        controllers_workspace_ActivityApi_startActivity91_invoker.call(ActivityApi_5.startActivity(project, task, activity, blocking))
      }
  
    // @LINE:134
    case controllers_workspace_ActivityApi_cancelActivity92_route(params@_) =>
      call(params.fromQuery[String]("project", None), params.fromQuery[String]("task", None), params.fromQuery[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_cancelActivity92_invoker.call(ActivityApi_5.cancelActivity(project, task, activity))
      }
  
    // @LINE:135
    case controllers_workspace_ActivityApi_restartActivity93_route(params@_) =>
      call(params.fromQuery[String]("project", None), params.fromQuery[String]("task", None), params.fromQuery[String]("activity", None), params.fromQuery[Boolean]("blocking", Some(false))) { (project, task, activity, blocking) =>
        controllers_workspace_ActivityApi_restartActivity93_invoker.call(ActivityApi_5.restartActivity(project, task, activity, blocking))
      }
  
    // @LINE:136
    case controllers_workspace_ActivityApi_getActivityConfig94_route(params@_) =>
      call(params.fromQuery[String]("project", None), params.fromQuery[String]("task", None), params.fromQuery[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_getActivityConfig94_invoker.call(ActivityApi_5.getActivityConfig(project, task, activity))
      }
  
    // @LINE:137
    case controllers_workspace_ActivityApi_postActivityConfig95_route(params@_) =>
      call(params.fromQuery[String]("project", None), params.fromQuery[String]("task", None), params.fromQuery[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_postActivityConfig95_invoker.call(ActivityApi_5.postActivityConfig(project, task, activity))
      }
  
    // @LINE:138
    case controllers_workspace_ActivityApi_getActivityStatus96_route(params@_) =>
      call(params.fromQuery[String]("project", None), params.fromQuery[String]("task", None), params.fromQuery[String]("activity", None)) { (project, task, activity) =>
        controllers_workspace_ActivityApi_getActivityStatus96_invoker.call(ActivityApi_5.getActivityStatus(project, task, activity))
      }
  
    // @LINE:139
    case controllers_workspace_ActivityApi_recentActivities97_route(params@_) =>
      call(params.fromQuery[Int]("maxCount", Some(10))) { (maxCount) =>
        controllers_workspace_ActivityApi_recentActivities97_invoker.call(ActivityApi_5.recentActivities(maxCount))
      }
  
    // @LINE:140
    case controllers_workspace_ActivityApi_activityLog98_route(params@_) =>
      call { 
        controllers_workspace_ActivityApi_activityLog98_invoker.call(ActivityApi_5.activityLog())
      }
  
    // @LINE:141
    case controllers_workspace_ActivityApi_getActivityStatusUpdates99_route(params@_) =>
      call(params.fromQuery[String]("project", Some("")), params.fromQuery[String]("task", Some("")), params.fromQuery[String]("activity", Some("")), params.fromQuery[Long]("timestamp", Some(0L))) { (project, task, activity, timestamp) =>
        controllers_workspace_ActivityApi_getActivityStatusUpdates99_invoker.call(ActivityApi_5.getActivityStatusUpdates(project, task, activity, timestamp))
      }
  
    // @LINE:142
    case controllers_workspace_ActivityApi_activityStatusUpdatesWebSocket100_route(params@_) =>
      call(params.fromQuery[String]("project", Some("")), params.fromQuery[String]("task", Some("")), params.fromQuery[String]("activity", Some(""))) { (project, task, activity) =>
        controllers_workspace_ActivityApi_activityStatusUpdatesWebSocket100_invoker.call(ActivityApi_5.activityStatusUpdatesWebSocket(project, task, activity))
      }
  
    // @LINE:148
    case controllers_workspace_Assets_at101_route(params@_) =>
      call(Param[String]("path", Right("/public/lib/silk-workbench-workspace")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_workspace_Assets_at101_invoker.call(Assets_6.at(path, file))
      }
  }
}
