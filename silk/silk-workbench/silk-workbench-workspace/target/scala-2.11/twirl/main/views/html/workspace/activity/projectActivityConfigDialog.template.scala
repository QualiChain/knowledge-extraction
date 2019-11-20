
package views.html.workspace.activity

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
/*1.2*/import controllers.workspace.routes
/*2.2*/import org.silkframework.runtime.plugin.{AnyPlugin, PluginDescription}
/*3.2*/import org.silkframework.workspace.activity.ProjectActivity
/*4.2*/import org.silkframework.runtime.activity.HasValue
/*5.2*/import scala.language.existentials
/*6.2*/import org.silkframework.runtime.activity.UserContext

object projectActivityConfigDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[ProjectActivity[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: HasValue
},UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*8.2*/(activity: ProjectActivity[_ <: HasValue])(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.1*/("""
"""),_display_(/*10.2*/widgets/*10.9*/.pluginDialog(
    activity.project,
    name = activity.name,
    plugins = PluginDescription(activity.factory.getClass) :: Nil,
    currentObj = Some(activity.factory.asInstanceOf[AnyPlugin]),
    resources = Nil)/*15.21*/ {_display_(Seq[Any](format.raw/*15.23*/("""

  """),format.raw/*17.3*/("""<script type="text/javascript">
    function savePlugin(pluginId, name, parameters) """),format.raw/*18.53*/("""{"""),format.raw/*18.54*/("""
      """),format.raw/*19.7*/("""$.post(
        '"""),_display_(/*20.11*/Html(routes.ActivityApi.postActivityConfig(activity.project.name, "", activity.name).url)),format.raw/*20.100*/("""',
        parameters
      ).done(function() """),format.raw/*22.25*/("""{"""),format.raw/*22.26*/("""
        """),format.raw/*23.9*/("""closeDialog();
      """),format.raw/*24.7*/("""}"""),format.raw/*24.8*/(""").fail(function(response) """),format.raw/*24.34*/("""{"""),format.raw/*24.35*/("""
        """),format.raw/*25.9*/("""alert(response.responseText);
      """),format.raw/*26.7*/("""}"""),format.raw/*26.8*/(""");
    """),format.raw/*27.5*/("""}"""),format.raw/*27.6*/("""
  """),format.raw/*28.3*/("""</script>
""")))}))
      }
    }
  }

  def render(activity:ProjectActivity[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: HasValue
},userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(activity)(userContext)

  def f:((ProjectActivity[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: HasValue
}) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (activity) => (userContext) => apply(activity)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/activity/projectActivityConfigDialog.scala.html
                  HASH: 8dff9ba6c652de0e0e2bbdbbfc0fe0bc5f4b2e9a
                  MATRIX: 451->1|494->38|572->110|639->171|697->223|739->259|1206->315|1377->393|1405->395|1420->402|1644->617|1684->619|1715->623|1827->707|1856->708|1890->715|1935->733|2046->822|2120->868|2149->869|2185->878|2233->899|2261->900|2315->926|2344->927|2380->936|2443->972|2471->973|2505->980|2533->981|2563->984
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|29->8|34->9|35->10|35->10|40->15|40->15|42->17|43->18|43->18|44->19|45->20|45->20|47->22|47->22|48->23|49->24|49->24|49->24|49->24|50->25|51->26|51->26|52->27|52->27|53->28
                  -- GENERATED --
              */
          