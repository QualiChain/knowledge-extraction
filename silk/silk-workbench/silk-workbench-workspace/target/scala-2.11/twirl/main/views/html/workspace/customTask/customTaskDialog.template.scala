
package views.html.workspace.customTask

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
/*1.2*/import org.silkframework.config.CustomTask
/*2.2*/import org.silkframework.runtime.plugin.PluginRegistry
/*3.2*/import org.silkframework.workspace.Project
/*4.2*/import org.silkframework.runtime.activity.UserContext

object customTaskDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Project,String,Option[CustomTask],Boolean,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(project: Project, taskName: String, taskPlugin: Option[CustomTask], createDialog: Boolean)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.1*/("""
"""),_display_(/*8.2*/widgets/*8.9*/.pluginDialog(
  project,
  name = taskName,
  plugins = PluginRegistry.availablePlugins[CustomTask],
  currentObj = taskPlugin,
  resources = project.resources.list,
  createDialog = createDialog)/*14.31*/ {_display_(Seq[Any](format.raw/*14.33*/("""

    """),format.raw/*16.5*/("""<script type="text/javascript">
      function savePlugin(pluginId, name, parameters, callbacks) """),format.raw/*17.66*/("""{"""),format.raw/*17.67*/("""
        """),format.raw/*18.9*/("""// Build task json
        var json = """),format.raw/*19.20*/("""{"""),format.raw/*19.21*/("""
          """),format.raw/*20.11*/("""id: name,
          data: """),format.raw/*21.17*/("""{"""),format.raw/*21.18*/("""
            """),format.raw/*22.13*/("""taskType: "CustomTask",
            type: pluginId,
            parameters: parameters
          """),format.raw/*25.11*/("""}"""),format.raw/*25.12*/("""
        """),format.raw/*26.9*/("""}"""),format.raw/*26.10*/(""";

        // Submit task
        """),_display_(/*29.10*/if(createDialog)/*29.26*/ {_display_(Seq[Any](format.raw/*29.28*/("""
          """),format.raw/*30.11*/("""postTask('"""),_display_(/*30.22*/project/*30.29*/.name),format.raw/*30.34*/("""', json, callbacks);
        """)))}/*31.11*/else/*31.16*/{_display_(Seq[Any](format.raw/*31.17*/("""
          """),format.raw/*32.11*/("""putTask('"""),_display_(/*32.21*/project/*32.28*/.name),format.raw/*32.33*/("""', name, json, callbacks);
        """)))}),format.raw/*33.10*/("""
      """),format.raw/*34.7*/("""}"""),format.raw/*34.8*/("""
    """),format.raw/*35.5*/("""</script>
""")))}))
      }
    }
  }

  def render(project:Project,taskName:String,taskPlugin:Option[CustomTask],createDialog:Boolean,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(project,taskName,taskPlugin,createDialog)(userContext)

  def f:((Project,String,Option[CustomTask],Boolean) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (project,taskName,taskPlugin,createDialog) => (userContext) => apply(project,taskName,taskPlugin,createDialog)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/customTask/customTaskDialog.scala.html
                  HASH: ec42d6881c6b4c0e9eb62e5978a021324bc5f938
                  MATRIX: 453->1|503->45|565->101|615->145|1031->201|1251->328|1278->330|1292->337|1498->534|1538->536|1571->542|1696->639|1725->640|1761->649|1827->687|1856->688|1895->699|1949->725|1978->726|2019->739|2144->836|2173->837|2209->846|2238->847|2300->882|2325->898|2365->900|2404->911|2442->922|2458->929|2484->934|2533->965|2546->970|2585->971|2624->982|2661->992|2677->999|2703->1004|2770->1040|2804->1047|2832->1048|2864->1053
                  LINES: 17->1|18->2|19->3|20->4|25->6|30->7|31->8|31->8|37->14|37->14|39->16|40->17|40->17|41->18|42->19|42->19|43->20|44->21|44->21|45->22|48->25|48->25|49->26|49->26|52->29|52->29|52->29|53->30|53->30|53->30|53->30|54->31|54->31|54->31|55->32|55->32|55->32|55->32|56->33|57->34|57->34|58->35
                  -- GENERATED --
              */
          