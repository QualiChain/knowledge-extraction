
package views.html.editor

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._
/*1.2*/import org.silkframework.workspace.Project
/*2.2*/import org.silkframework.runtime.activity.UserContext

object transformationBox extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[String,org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Seq[String],Int,Int,Boolean,Project,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(id: String,
  plugin: org.silkframework.runtime.plugin.PluginDescription[_],
  parameterValues: Seq[String],
  x: Int, y: Int, display: Boolean,
  project: Project)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.1*/("""
"""),_display_(/*10.2*/operatorBox("Transform", id, plugin, parameterValues, x, y, display, project)/*10.79*/ {_display_(Seq[Any](format.raw/*10.81*/(""" """)))}))
      }
    }
  }

  def render(id:String,plugin:org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},parameterValues:Seq[String],x:Int,y:Int,display:Boolean,project:Project,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(id,plugin,parameterValues,x,y,display,project)(userContext)

  def f:((String,org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Seq[String],Int,Int,Boolean,Project) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (id,plugin,parameterValues,x,y,display,project) => (userContext) => apply(id,plugin,parameterValues,x,y,display,project)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/transformationBox.scala.html
                  HASH: b4737f11dcba8bbe56eff8576cedfb3d719494e3
                  MATRIX: 439->1|489->45|1032->101|1326->302|1354->304|1440->381|1480->383
                  LINES: 17->1|18->2|25->4|34->9|35->10|35->10|35->10
                  -- GENERATED --
              */
          