// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/conf/test.routes
// @DATE:Tue Jul 30 22:35:15 CEST 2019

package test

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  workspace_Routes_0: workspace.Routes,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    workspace_Routes_0: workspace.Routes
  ) = this(errorHandler, workspace_Routes_0, "/")

  def withPrefix(prefix: String): Routes = {
    test.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, workspace_Routes_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    prefixed_workspace_Routes_0_0.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] val prefixed_workspace_Routes_0_0 = Include(workspace_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "workspace"))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case prefixed_workspace_Routes_0_0(handler) => handler
  }
}
