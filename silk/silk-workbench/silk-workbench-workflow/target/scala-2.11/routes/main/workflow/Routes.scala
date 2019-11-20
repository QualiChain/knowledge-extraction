// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workflow/conf/workflow.routes
// @DATE:Tue Jul 30 22:35:14 CEST 2019

package workflow

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  Dialogs_1: controllers.workflow.Dialogs,
  // @LINE:3
  WorkflowEditorController_0: controllers.workflow.WorkflowEditorController,
  // @LINE:6
  WorkflowApi_2: controllers.workflow.WorkflowApi,
  // @LINE:17
  Assets_3: controllers.workflow.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    Dialogs_1: controllers.workflow.Dialogs,
    // @LINE:3
    WorkflowEditorController_0: controllers.workflow.WorkflowEditorController,
    // @LINE:6
    WorkflowApi_2: controllers.workflow.WorkflowApi,
    // @LINE:17
    Assets_3: controllers.workflow.Assets
  ) = this(errorHandler, Dialogs_1, WorkflowEditorController_0, WorkflowApi_2, Assets_3, "/")

  def withPrefix(prefix: String): Routes = {
    workflow.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Dialogs_1, WorkflowEditorController_0, WorkflowApi_2, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/""" + "$" + """project<[^/]+>/workflowDialog""", """controllers.workflow.Dialogs.workflowTaskDialog(project:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editor/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.workflow.WorkflowEditorController.editor(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """report/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.workflow.WorkflowEditorController.report(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflows/""" + "$" + """project<[^/]+>""", """controllers.workflow.WorkflowApi.getWorkflows(project:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflows/""" + "$" + """project<[^/]+>""", """controllers.workflow.WorkflowApi.postWorkflow(project:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.workflow.WorkflowApi.putWorkflow(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.workflow.WorkflowApi.getWorkflow(project:String, task:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.workflow.WorkflowApi.deleteWorkflow(project:String, task:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/execute""", """controllers.workflow.WorkflowApi.executeWorkflow(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/status""", """controllers.workflow.WorkflowApi.status(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.workflow.Assets.at(path:String = "/public/lib/silk-workbench-workflow", file:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/executeOnPayload""", """controllers.workflow.WorkflowApi.postVariableWorkflowInput(project:String, task:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/executeOnPayloadAsynchronous""", """controllers.workflow.WorkflowApi.postVariableWorkflowInputAsynchronous(project:String, task:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/execution/""" + "$" + """executionId<[^/]+>""", """controllers.workflow.WorkflowApi.removeVariableWorkflowExecution(project:String, task:String, executionId:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_workflow_Dialogs_workflowTaskDialog0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/"), DynamicPart("project", """[^/]+""",true), StaticPart("/workflowDialog")))
  )
  private[this] lazy val controllers_workflow_Dialogs_workflowTaskDialog0_invoker = createInvoker(
    Dialogs_1.workflowTaskDialog(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.Dialogs",
      "workflowTaskDialog",
      Seq(classOf[String]),
      "GET",
      this.prefix + """dialogs/""" + "$" + """project<[^/]+>/workflowDialog""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_workflow_WorkflowEditorController_editor1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editor/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workflow_WorkflowEditorController_editor1_invoker = createInvoker(
    WorkflowEditorController_0.editor(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowEditorController",
      "editor",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """editor/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_workflow_WorkflowEditorController_report2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("report/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workflow_WorkflowEditorController_report2_invoker = createInvoker(
    WorkflowEditorController_0.report(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowEditorController",
      "report",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """report/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_workflow_WorkflowApi_getWorkflows3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workflow_WorkflowApi_getWorkflows3_invoker = createInvoker(
    WorkflowApi_2.getWorkflows(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowApi",
      "getWorkflows",
      Seq(classOf[String]),
      "GET",
      this.prefix + """workflows/""" + "$" + """project<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_workflow_WorkflowApi_postWorkflow4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workflow_WorkflowApi_postWorkflow4_invoker = createInvoker(
    WorkflowApi_2.postWorkflow(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowApi",
      "postWorkflow",
      Seq(classOf[String]),
      "POST",
      this.prefix + """workflows/""" + "$" + """project<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_workflow_WorkflowApi_putWorkflow5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workflow_WorkflowApi_putWorkflow5_invoker = createInvoker(
    WorkflowApi_2.putWorkflow(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowApi",
      "putWorkflow",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_workflow_WorkflowApi_getWorkflow6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workflow_WorkflowApi_getWorkflow6_invoker = createInvoker(
    WorkflowApi_2.getWorkflow(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowApi",
      "getWorkflow",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_workflow_WorkflowApi_deleteWorkflow7_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workflow_WorkflowApi_deleteWorkflow7_invoker = createInvoker(
    WorkflowApi_2.deleteWorkflow(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowApi",
      "deleteWorkflow",
      Seq(classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_workflow_WorkflowApi_executeWorkflow8_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/execute")))
  )
  private[this] lazy val controllers_workflow_WorkflowApi_executeWorkflow8_invoker = createInvoker(
    WorkflowApi_2.executeWorkflow(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowApi",
      "executeWorkflow",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/execute""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_workflow_WorkflowApi_status9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/status")))
  )
  private[this] lazy val controllers_workflow_WorkflowApi_status9_invoker = createInvoker(
    WorkflowApi_2.status(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowApi",
      "status",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/status""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_workflow_Assets_at10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_workflow_Assets_at10_invoker = createInvoker(
    Assets_3.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Assests""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_workflow_WorkflowApi_postVariableWorkflowInput11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/executeOnPayload")))
  )
  private[this] lazy val controllers_workflow_WorkflowApi_postVariableWorkflowInput11_invoker = createInvoker(
    WorkflowApi_2.postVariableWorkflowInput(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowApi",
      "postVariableWorkflowInput",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/executeOnPayload""",
      """ Execution""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_workflow_WorkflowApi_postVariableWorkflowInputAsynchronous12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/executeOnPayloadAsynchronous")))
  )
  private[this] lazy val controllers_workflow_WorkflowApi_postVariableWorkflowInputAsynchronous12_invoker = createInvoker(
    WorkflowApi_2.postVariableWorkflowInputAsynchronous(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowApi",
      "postVariableWorkflowInputAsynchronous",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/executeOnPayloadAsynchronous""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_workflow_WorkflowApi_removeVariableWorkflowExecution13_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/execution/"), DynamicPart("executionId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_workflow_WorkflowApi_removeVariableWorkflowExecution13_invoker = createInvoker(
    WorkflowApi_2.removeVariableWorkflowExecution(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "workflow",
      "controllers.workflow.WorkflowApi",
      "removeVariableWorkflowExecution",
      Seq(classOf[String], classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """workflows/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/execution/""" + "$" + """executionId<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_workflow_Dialogs_workflowTaskDialog0_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workflow_Dialogs_workflowTaskDialog0_invoker.call(Dialogs_1.workflowTaskDialog(project))
      }
  
    // @LINE:3
    case controllers_workflow_WorkflowEditorController_editor1_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workflow_WorkflowEditorController_editor1_invoker.call(WorkflowEditorController_0.editor(project, task))
      }
  
    // @LINE:4
    case controllers_workflow_WorkflowEditorController_report2_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workflow_WorkflowEditorController_report2_invoker.call(WorkflowEditorController_0.report(project, task))
      }
  
    // @LINE:6
    case controllers_workflow_WorkflowApi_getWorkflows3_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workflow_WorkflowApi_getWorkflows3_invoker.call(WorkflowApi_2.getWorkflows(project))
      }
  
    // @LINE:8
    case controllers_workflow_WorkflowApi_postWorkflow4_route(params@_) =>
      call(params.fromPath[String]("project", None)) { (project) =>
        controllers_workflow_WorkflowApi_postWorkflow4_invoker.call(WorkflowApi_2.postWorkflow(project))
      }
  
    // @LINE:9
    case controllers_workflow_WorkflowApi_putWorkflow5_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workflow_WorkflowApi_putWorkflow5_invoker.call(WorkflowApi_2.putWorkflow(project, task))
      }
  
    // @LINE:10
    case controllers_workflow_WorkflowApi_getWorkflow6_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workflow_WorkflowApi_getWorkflow6_invoker.call(WorkflowApi_2.getWorkflow(project, task))
      }
  
    // @LINE:11
    case controllers_workflow_WorkflowApi_deleteWorkflow7_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workflow_WorkflowApi_deleteWorkflow7_invoker.call(WorkflowApi_2.deleteWorkflow(project, task))
      }
  
    // @LINE:13
    case controllers_workflow_WorkflowApi_executeWorkflow8_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workflow_WorkflowApi_executeWorkflow8_invoker.call(WorkflowApi_2.executeWorkflow(project, task))
      }
  
    // @LINE:14
    case controllers_workflow_WorkflowApi_status9_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workflow_WorkflowApi_status9_invoker.call(WorkflowApi_2.status(project, task))
      }
  
    // @LINE:17
    case controllers_workflow_Assets_at10_route(params@_) =>
      call(Param[String]("path", Right("/public/lib/silk-workbench-workflow")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_workflow_Assets_at10_invoker.call(Assets_3.at(path, file))
      }
  
    // @LINE:20
    case controllers_workflow_WorkflowApi_postVariableWorkflowInput11_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workflow_WorkflowApi_postVariableWorkflowInput11_invoker.call(WorkflowApi_2.postVariableWorkflowInput(project, task))
      }
  
    // @LINE:21
    case controllers_workflow_WorkflowApi_postVariableWorkflowInputAsynchronous12_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_workflow_WorkflowApi_postVariableWorkflowInputAsynchronous12_invoker.call(WorkflowApi_2.postVariableWorkflowInputAsynchronous(project, task))
      }
  
    // @LINE:22
    case controllers_workflow_WorkflowApi_removeVariableWorkflowExecution13_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("executionId", None)) { (project, task, executionId) =>
        controllers_workflow_WorkflowApi_removeVariableWorkflowExecution13_invoker.call(WorkflowApi_2.removeVariableWorkflowExecution(project, task, executionId))
      }
  }
}
