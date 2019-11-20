
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
/*3.2*/import org.silkframework.workspace.activity.TaskActivity
/*4.2*/import org.silkframework.runtime.activity.UserContext
/*6.2*/import scala.language.existentials

object taskActivityConfigDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[TaskActivity[_$1, _$2] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any;
   type _$2 >: _root_.scala.Nothing <: _root_.scala.Any
},UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*8.2*/(activity: TaskActivity[_, _])(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.1*/("""
"""),_display_(/*10.2*/widgets/*10.9*/.pluginDialog(
    activity.project,
    name = activity.name,
    title = "Start activity",
    submitLabel = "start",
    plugins = PluginDescription(activity.factory.getClass) :: Nil,
    currentObj = Some(activity.factory.asInstanceOf[AnyPlugin]),
    resources = Nil)/*17.21*/ {_display_(Seq[Any](format.raw/*17.23*/("""

  """),format.raw/*19.3*/("""<script type="text/javascript">
    function savePlugin(pluginId, name, parameters) """),format.raw/*20.53*/("""{"""),format.raw/*20.54*/("""
      """),format.raw/*21.7*/("""const contentScrollTop = document.getElementsByClassName("mdl-layout__content")[0].scrollTop;
      sessionStorage.setItem("activityViewScrollPosition", contentScrollTop);
      $.post(
        '"""),_display_(/*24.11*/Html(routes.ActivityApi.startActivity(activity.task.project.name, activity.task.id, activity.name, blocking = false).url)),format.raw/*24.132*/("""',
        parameters
      ).done(function() """),format.raw/*26.25*/("""{"""),format.raw/*26.26*/("""
        """),format.raw/*27.9*/("""closeDialog();
        // Currently updating an activity means that all listeners are still listening to the old activity. That's why we have to reload
        location.reload();
      """),format.raw/*30.7*/("""}"""),format.raw/*30.8*/(""").fail(function(response) """),format.raw/*30.34*/("""{"""),format.raw/*30.35*/("""
        """),format.raw/*31.9*/("""alert(response.responseText);
      """),format.raw/*32.7*/("""}"""),format.raw/*32.8*/(""");
    """),format.raw/*33.5*/("""}"""),format.raw/*33.6*/("""
  """),format.raw/*34.3*/("""</script>
""")))}))
      }
    }
  }

  def render(activity:TaskActivity[_$1, _$2] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any;
   type _$2 >: _root_.scala.Nothing <: _root_.scala.Any
},userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(activity)(userContext)

  def f:((TaskActivity[_$1, _$2] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any;
   type _$2 >: _root_.scala.Nothing <: _root_.scala.Any
}) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (activity) => (userContext) => apply(activity)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/activity/taskActivityConfigDialog.scala.html
                  HASH: e0c79a6ab120da9d901b6a1328c0a5eb99dea4aa
                  MATRIX: 451->1|494->38|572->110|636->168|697->224|1209->261|1368->327|1396->329|1411->336|1692->608|1732->610|1763->614|1875->698|1904->699|1938->706|2161->902|2304->1023|2378->1069|2407->1070|2443->1079|2655->1264|2683->1265|2737->1291|2766->1292|2802->1301|2865->1337|2893->1338|2927->1345|2955->1346|2985->1349
                  LINES: 17->1|18->2|19->3|20->4|21->6|29->8|34->9|35->10|35->10|42->17|42->17|44->19|45->20|45->20|46->21|49->24|49->24|51->26|51->26|52->27|55->30|55->30|55->30|55->30|56->31|57->32|57->32|58->33|58->33|59->34
                  -- GENERATED --
              */
          