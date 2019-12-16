// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/knowledge-extraction/silk/silk-workbench/silk-workbench-core/conf/core.routes
// @DATE:Sun Dec 15 09:27:21 CET 2019

package core

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  Start_4: controllers.core.Start,
  // @LINE:2
  Branding_2: controllers.core.Branding,
  // @LINE:5
  ConfigController_1: controllers.core.ConfigController,
  // @LINE:6
  PluginApi_0: controllers.core.PluginApi,
  // @LINE:9
  Assets_3: controllers.core.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    Start_4: controllers.core.Start,
    // @LINE:2
    Branding_2: controllers.core.Branding,
    // @LINE:5
    ConfigController_1: controllers.core.ConfigController,
    // @LINE:6
    PluginApi_0: controllers.core.PluginApi,
    // @LINE:9
    Assets_3: controllers.core.Assets
  ) = this(errorHandler, Start_4, Branding_2, ConfigController_1, PluginApi_0, Assets_3, "/")

  def withPrefix(prefix: String): Routes = {
    core.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Start_4, Branding_2, ConfigController_1, PluginApi_0, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """start""", """controllers.core.Start.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logo.png""", """controllers.core.Branding.logo"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """aboutDialog""", """controllers.core.Branding.aboutDialog"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mdlStyle""", """controllers.core.Branding.mdlStyle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """config""", """controllers.core.ConfigController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """plugins""", """controllers.core.PluginApi.plugins()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """plugins/""" + "$" + """pluginType<[^/]+>""", """controllers.core.PluginApi.pluginsForTypes(pluginType:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.core.Assets.at(path:String = "/public/lib/silk-workbench-core", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_core_Start_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("start")))
  )
  private[this] lazy val controllers_core_Start_index0_invoker = createInvoker(
    Start_4.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "core",
      "controllers.core.Start",
      "index",
      Nil,
      "GET",
      this.prefix + """start""",
      """""",
      Seq()
    )
  )

  // @LINE:2
  private[this] lazy val controllers_core_Branding_logo1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logo.png")))
  )
  private[this] lazy val controllers_core_Branding_logo1_invoker = createInvoker(
    Branding_2.logo,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "core",
      "controllers.core.Branding",
      "logo",
      Nil,
      "GET",
      this.prefix + """logo.png""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_core_Branding_aboutDialog2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("aboutDialog")))
  )
  private[this] lazy val controllers_core_Branding_aboutDialog2_invoker = createInvoker(
    Branding_2.aboutDialog,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "core",
      "controllers.core.Branding",
      "aboutDialog",
      Nil,
      "GET",
      this.prefix + """aboutDialog""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_core_Branding_mdlStyle3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mdlStyle")))
  )
  private[this] lazy val controllers_core_Branding_mdlStyle3_invoker = createInvoker(
    Branding_2.mdlStyle,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "core",
      "controllers.core.Branding",
      "mdlStyle",
      Nil,
      "GET",
      this.prefix + """mdlStyle""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_core_ConfigController_index4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("config")))
  )
  private[this] lazy val controllers_core_ConfigController_index4_invoker = createInvoker(
    ConfigController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "core",
      "controllers.core.ConfigController",
      "index",
      Nil,
      "GET",
      this.prefix + """config""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_core_PluginApi_plugins5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("plugins")))
  )
  private[this] lazy val controllers_core_PluginApi_plugins5_invoker = createInvoker(
    PluginApi_0.plugins(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "core",
      "controllers.core.PluginApi",
      "plugins",
      Nil,
      "GET",
      this.prefix + """plugins""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_core_PluginApi_pluginsForTypes6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("plugins/"), DynamicPart("pluginType", """[^/]+""",true)))
  )
  private[this] lazy val controllers_core_PluginApi_pluginsForTypes6_invoker = createInvoker(
    PluginApi_0.pluginsForTypes(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "core",
      "controllers.core.PluginApi",
      "pluginsForTypes",
      Seq(classOf[String]),
      "GET",
      this.prefix + """plugins/""" + "$" + """pluginType<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_core_Assets_at7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_core_Assets_at7_invoker = createInvoker(
    Assets_3.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "core",
      "controllers.core.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_core_Start_index0_route(params@_) =>
      call { 
        controllers_core_Start_index0_invoker.call(Start_4.index)
      }
  
    // @LINE:2
    case controllers_core_Branding_logo1_route(params@_) =>
      call { 
        controllers_core_Branding_logo1_invoker.call(Branding_2.logo)
      }
  
    // @LINE:3
    case controllers_core_Branding_aboutDialog2_route(params@_) =>
      call { 
        controllers_core_Branding_aboutDialog2_invoker.call(Branding_2.aboutDialog)
      }
  
    // @LINE:4
    case controllers_core_Branding_mdlStyle3_route(params@_) =>
      call { 
        controllers_core_Branding_mdlStyle3_invoker.call(Branding_2.mdlStyle)
      }
  
    // @LINE:5
    case controllers_core_ConfigController_index4_route(params@_) =>
      call { 
        controllers_core_ConfigController_index4_invoker.call(ConfigController_1.index)
      }
  
    // @LINE:6
    case controllers_core_PluginApi_plugins5_route(params@_) =>
      call { 
        controllers_core_PluginApi_plugins5_invoker.call(PluginApi_0.plugins())
      }
  
    // @LINE:7
    case controllers_core_PluginApi_pluginsForTypes6_route(params@_) =>
      call(params.fromPath[String]("pluginType", None)) { (pluginType) =>
        controllers_core_PluginApi_pluginsForTypes6_invoker.call(PluginApi_0.pluginsForTypes(pluginType))
      }
  
    // @LINE:9
    case controllers_core_Assets_at7_route(params@_) =>
      call(Param[String]("path", Right("/public/lib/silk-workbench-core")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_core_Assets_at7_invoker.call(Assets_3.at(path, file))
      }
  }
}
