// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/conf/routes
// @DATE:Tue Jul 30 22:38:02 CEST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  Workbench_0: controllers.Workbench,
  // @LINE:4
  core_Routes_3: core.Routes,
  // @LINE:5
  workspace_Routes_5: workspace.Routes,
  // @LINE:6
  rules_Routes_2: rules.Routes,
  // @LINE:7
  linking_Routes_1: linking.Routes,
  // @LINE:8
  transform_Routes_4: transform.Routes,
  // @LINE:9
  workflow_Routes_0: workflow.Routes,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    Workbench_0: controllers.Workbench,
    // @LINE:4
    core_Routes_3: core.Routes,
    // @LINE:5
    workspace_Routes_5: workspace.Routes,
    // @LINE:6
    rules_Routes_2: rules.Routes,
    // @LINE:7
    linking_Routes_1: linking.Routes,
    // @LINE:8
    transform_Routes_4: transform.Routes,
    // @LINE:9
    workflow_Routes_0: workflow.Routes
  ) = this(errorHandler, Workbench_0, core_Routes_3, workspace_Routes_5, rules_Routes_2, linking_Routes_1, transform_Routes_4, workflow_Routes_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Workbench_0, core_Routes_3, workspace_Routes_5, rules_Routes_2, linking_Routes_1, transform_Routes_4, workflow_Routes_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Workbench.index"""),
    prefixed_core_Routes_3_1.router.documentation,
    prefixed_workspace_Routes_5_2.router.documentation,
    prefixed_rules_Routes_2_3.router.documentation,
    prefixed_linking_Routes_1_4.router.documentation,
    prefixed_transform_Routes_4_5.router.documentation,
    prefixed_workflow_Routes_0_6.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_Workbench_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Workbench_index0_invoker = createInvoker(
    Workbench_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Workbench",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] val prefixed_core_Routes_3_1 = Include(core_Routes_3.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "core"))

  // @LINE:5
  private[this] val prefixed_workspace_Routes_5_2 = Include(workspace_Routes_5.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "workspace"))

  // @LINE:6
  private[this] val prefixed_rules_Routes_2_3 = Include(rules_Routes_2.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "rules"))

  // @LINE:7
  private[this] val prefixed_linking_Routes_1_4 = Include(linking_Routes_1.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "linking"))

  // @LINE:8
  private[this] val prefixed_transform_Routes_4_5 = Include(transform_Routes_4.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "transform"))

  // @LINE:9
  private[this] val prefixed_workflow_Routes_0_6 = Include(workflow_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "workflow"))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_Workbench_index0_route(params@_) =>
      call { 
        controllers_Workbench_index0_invoker.call(Workbench_0.index)
      }
  
    // @LINE:4
    case prefixed_core_Routes_3_1(handler) => handler
  
    // @LINE:5
    case prefixed_workspace_Routes_5_2(handler) => handler
  
    // @LINE:6
    case prefixed_rules_Routes_2_3(handler) => handler
  
    // @LINE:7
    case prefixed_linking_Routes_1_4(handler) => handler
  
    // @LINE:8
    case prefixed_transform_Routes_4_5(handler) => handler
  
    // @LINE:9
    case prefixed_workflow_Routes_0_6(handler) => handler
  }
}
