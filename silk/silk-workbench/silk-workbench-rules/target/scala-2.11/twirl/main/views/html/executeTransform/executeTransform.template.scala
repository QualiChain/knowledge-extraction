
package views.html.executeTransform

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
/*1.2*/import org.silkframework.rule.execution.ExecuteTransform
/*2.2*/import views.html.workspace.activity.taskActivityControl
/*3.2*/import controllers.transform.routes.ExecuteTransformTab
/*4.2*/import org.silkframework.rule.TransformSpec
/*5.2*/import controllers.workspace.routes.TaskApi
/*6.2*/import org.silkframework.workbench.Context
/*7.2*/import controllers.core.routes.{Assets => CoreAssets}
/*8.2*/import org.silkframework.workspace.activity.transform.ExecuteTransformFactory
/*9.2*/import views.html.workspace.activity.autoReload

object executeTransform extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Context[TransformSpec],play.api.mvc.Session,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*11.2*/(context: Context[TransformSpec])(implicit session: play.api.mvc.Session, request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*13.2*/header/*13.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*13.12*/("""
  """),format.raw/*14.3*/("""<script src=""""),_display_(/*14.17*/CoreAssets/*14.27*/.at("libs/silk-react-components/main.js")),format.raw/*14.68*/("""" type="text/javascript"></script>
""")))};def /*17.2*/toolbar/*17.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*17.13*/("""
  """),format.raw/*18.3*/("""<ul>
    <li>
      """),_display_(/*20.8*/taskActivityControl(context.task.activity[ExecuteTransform], showButtons = true)),format.raw/*20.88*/("""
    """),format.raw/*21.5*/("""</li>
    <li>
      <a class="mdl-button mdl-js-button mdl-button--icon" href=""""),_display_(/*23.67*/{TaskApi.downloadOutput(context.project.name, context.task.id).url}),format.raw/*23.134*/("""" target="_download">
        <i class="material-icons">file_download</i>
      </a>
    </li>
  </ul>
""")))};def /*30.2*/content/*30.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*30.13*/("""
  """),_display_(/*31.4*/autoReload(
    context = context,
    contentPath = ExecuteTransformTab.executionReport(context.project.name, context.task.id).url,
    activityId = ExecuteTransformFactory.pluginId
  )),format.raw/*35.4*/("""
""")))};
Seq[Any](format.raw/*12.1*/("""
"""),format.raw/*15.2*/("""

"""),format.raw/*28.2*/("""

"""),format.raw/*36.2*/("""

"""),_display_(/*38.2*/main(Some(context), titleLabel = context.task.taskLabel())/*38.60*/(header)/*38.68*/(toolbar)/*38.77*/(content)),format.raw/*38.86*/("""
"""))
      }
    }
  }

  def render(context:Context[TransformSpec],session:play.api.mvc.Session,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(context)(session,request)

  def f:((Context[TransformSpec]) => (play.api.mvc.Session,RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (context) => (session,request) => apply(context)(session,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/executeTransform/executeTransform.scala.html
                  HASH: dcf444f74c6031c9828923f2012118ba0c91d6fa
                  MATRIX: 449->1|513->59|577->117|640->174|691->219|742->264|792->308|853->363|938->442|1353->492|1529->592|1543->598|1624->602|1654->605|1695->619|1714->629|1776->670|1835->709|1850->716|1931->720|1961->723|2008->744|2109->824|2141->829|2249->910|2338->977|2465->1084|2480->1091|2561->1095|2591->1099|2797->1285|2838->590|2866->706|2895->1081|2924->1287|2953->1290|3020->1348|3037->1356|3055->1365|3085->1374
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|25->9|30->11|34->13|34->13|36->13|37->14|37->14|37->14|37->14|38->17|38->17|40->17|41->18|43->20|43->20|44->21|46->23|46->23|51->30|51->30|53->30|54->31|58->35|60->12|61->15|63->28|65->36|67->38|67->38|67->38|67->38|67->38
                  -- GENERATED --
              */
          