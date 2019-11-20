
package views.html.workspace

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
/*1.2*/import org.silkframework.runtime.plugin.PluginRegistry
/*2.2*/import org.silkframework.workspace.activity.ProjectExecutor
/*3.2*/import org.silkframework.workspace.Project
/*4.2*/import controllers.workspace.routes
/*5.2*/import org.silkframework.runtime.activity.UserContext

object executeProjectDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Project,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(project: Project)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),_display_(/*9.2*/widgets/*9.9*/.pluginDialog(project,
                      name = project.name,
                      plugins = PluginRegistry.availablePlugins[ProjectExecutor],
                      currentObj = None,
                      resources = Nil)/*13.39*/ {_display_(Seq[Any](format.raw/*13.41*/("""

  """),format.raw/*15.3*/("""<script type="text/javascript">
    function submit(pluginId, name, parameters) """),format.raw/*16.49*/("""{"""),format.raw/*16.50*/("""
      """),format.raw/*17.7*/("""$.post('"""),_display_(/*17.16*/routes/*17.22*/.WorkspaceApi.executeProject(project.name)),format.raw/*17.64*/("""');
      closeDialog();
    """),format.raw/*19.5*/("""}"""),format.raw/*19.6*/("""
  """),format.raw/*20.3*/("""</script>
""")))}))
      }
    }
  }

  def render(project:Project,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(project)(userContext)

  def f:((Project) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (project) => (userContext) => apply(project)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/executeProjectDialog.scala.html
                  HASH: 370109a67e81c22d50b684ced197e50ed9028a18
                  MATRIX: 442->1|504->57|571->118|621->162|664->199|1050->255|1197->309|1224->311|1238->318|1474->545|1514->547|1545->551|1653->631|1682->632|1716->639|1752->648|1767->654|1830->696|1886->725|1914->726|1944->729
                  LINES: 17->1|18->2|19->3|20->4|21->5|26->7|31->8|32->9|32->9|36->13|36->13|38->15|39->16|39->16|40->17|40->17|40->17|40->17|42->19|42->19|43->20
                  -- GENERATED --
              */
          