
package views.html.executeLinking

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
/*4.2*/import controllers.transform.routes
/*5.2*/import org.silkframework.workbench.Context
/*6.2*/import org.silkframework.workspace.activity.linking.ExecuteLinking
/*7.2*/import org.silkframework.rule.LinkSpec
/*8.2*/import controllers.workspace.routes.TaskApi

object executeLinking extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Context[LinkSpec],play.api.mvc.Session,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*10.2*/(context: Context[LinkSpec])(implicit session: play.api.mvc.Session, request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*12.2*/header/*12.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*12.12*/("""
""")))};def /*15.2*/toolbar/*15.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*15.13*/("""
  """),format.raw/*16.3*/("""<ul>
    <li>
      """),_display_(/*18.8*/taskActivityControl(context.task.activity[ExecuteLinking], showButtons = true)),format.raw/*18.86*/("""
    """),format.raw/*19.5*/("""</li>
    <li>
      <a class="mdl-button mdl-js-button mdl-button--icon" href=""""),_display_(/*21.67*/TaskApi/*21.74*/.downloadOutput(context.project.name, context.task.id).url),format.raw/*21.132*/("""" target="_download">
        <i class="material-icons">file_download</i>
      </a>
    </li>
  </ul>
""")))};def /*28.2*/content/*28.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*28.13*/("""
""")))};
Seq[Any](format.raw/*11.1*/("""
"""),format.raw/*13.2*/("""

"""),format.raw/*26.2*/("""

"""),format.raw/*29.2*/("""

"""),_display_(/*31.2*/main(Some(context), titleLabel = context.task.taskLabel())/*31.60*/(header)/*31.68*/(toolbar)/*31.77*/(content)),format.raw/*31.86*/("""
"""))
      }
    }
  }

  def render(context:Context[LinkSpec],session:play.api.mvc.Session,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(context)(session,request)

  def f:((Context[LinkSpec]) => (play.api.mvc.Session,RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (context) => (session,request) => apply(context)(session,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/executeLinking/executeLinking.scala.html
                  HASH: d73078104d78e8af6fe1922a4fe5d1284d8f9076
                  MATRIX: 447->1|511->59|575->117|638->174|681->211|731->255|805->323|851->363|1255->409|1426->504|1440->510|1521->514|1546->519|1561->526|1642->530|1672->533|1719->554|1818->632|1850->637|1958->718|1974->725|2054->783|2181->890|2196->897|2277->901|2318->502|2346->516|2375->887|2404->903|2433->906|2500->964|2517->972|2535->981|2565->990
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|29->10|33->12|33->12|35->12|36->15|36->15|38->15|39->16|41->18|41->18|42->19|44->21|44->21|44->21|49->28|49->28|51->28|53->11|54->13|56->26|58->29|60->31|60->31|60->31|60->31|60->31
                  -- GENERATED --
              */
          