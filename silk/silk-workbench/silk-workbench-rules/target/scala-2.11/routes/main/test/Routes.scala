// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/knowledge-extraction/silk/silk-workbench/silk-workbench-rules/conf/test.routes
// @DATE:Sun Dec 15 09:27:21 CET 2019

package test

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:4
  core_Routes_1: core.Routes,
  // @LINE:5
  workspace_Routes_3: workspace.Routes,
  // @LINE:6
  transform_Routes_2: transform.Routes,
  // @LINE:7
  linking_Routes_0: linking.Routes,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:4
    core_Routes_1: core.Routes,
    // @LINE:5
    workspace_Routes_3: workspace.Routes,
    // @LINE:6
    transform_Routes_2: transform.Routes,
    // @LINE:7
    linking_Routes_0: linking.Routes
  ) = this(errorHandler, core_Routes_1, workspace_Routes_3, transform_Routes_2, linking_Routes_0, "/")

  def withPrefix(prefix: String): Routes = {
    test.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, core_Routes_1, workspace_Routes_3, transform_Routes_2, linking_Routes_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    prefixed_core_Routes_1_0.router.documentation,
    prefixed_workspace_Routes_3_1.router.documentation,
    prefixed_transform_Routes_2_2.router.documentation,
    prefixed_linking_Routes_0_3.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:4
  private[this] val prefixed_core_Routes_1_0 = Include(core_Routes_1.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "core"))

  // @LINE:5
  private[this] val prefixed_workspace_Routes_3_1 = Include(workspace_Routes_3.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "workspace"))

  // @LINE:6
  private[this] val prefixed_transform_Routes_2_2 = Include(transform_Routes_2.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "transform"))

  // @LINE:7
  private[this] val prefixed_linking_Routes_0_3 = Include(linking_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "linking"))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:4
    case prefixed_core_Routes_1_0(handler) => handler
  
    // @LINE:5
    case prefixed_workspace_Routes_3_1(handler) => handler
  
    // @LINE:6
    case prefixed_transform_Routes_2_2(handler) => handler
  
    // @LINE:7
    case prefixed_linking_Routes_0_3(handler) => handler
  }
}
