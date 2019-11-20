
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
/*3.2*/import org.silkframework.runtime.activity.UserContext

object pathBox extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[String,Boolean,String,Int,Int,Boolean,Project,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(id: String,
  isSource: Boolean,
  path: String,
  x: Int, y: Int, display: Boolean,
  project: Project)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*10.2*/import org.silkframework.runtime.plugin.PluginDescription


Seq[Any](format.raw/*9.1*/("""
"""),format.raw/*11.1*/("""
"""),_display_(/*12.2*/operatorBox(
  opType = if(isSource) "Source" else "Target",
  id = id,
  plugin = new PluginDescription(id, Seq.empty, "Path", "Path", "", Seq.empty, null),
  parameterValues = Seq.empty,
  x = x,
  y = y,
  display = display,
  project = project)/*20.21*/ {_display_(Seq[Any](format.raw/*20.23*/("""
    """),format.raw/*21.5*/("""<input class="param_value" type="text" name="path" value=""""),_display_(/*21.64*/path),format.raw/*21.68*/("""" style="width:100%"/>
  """)))}))
      }
    }
  }

  def render(id:String,isSource:Boolean,path:String,x:Int,y:Int,display:Boolean,project:Project,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(id,isSource,path,x,y,display,project)(userContext)

  def f:((String,Boolean,String,Int,Int,Boolean,Project) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (id,isSource,path,x,y,display,project) => (userContext) => apply(id,isSource,path,x,y,display,project)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/pathBox.scala.html
                  HASH: 9d77dcbb080cf895f51424a19c626373b70543cf
                  MATRIX: 439->1|489->46|900->101|1114->244|1200->242|1228->302|1256->304|1513->552|1553->554|1585->559|1671->618|1696->622
                  LINES: 17->1|18->3|23->4|30->10|33->9|34->11|35->12|43->20|43->20|44->21|44->21|44->21
                  -- GENERATED --
              */
          