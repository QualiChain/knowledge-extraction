
package views.html.workflow.editor

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
/*1.2*/import org.silkframework.workspace.activity.workflow.Workflow
/*2.2*/import controllers.workflow.routes.Assets
/*3.2*/import controllers.core.routes.{Assets => CoreAssets}
/*4.2*/import views.html.workspace.activity.taskActivityControl
/*5.2*/import models.workflow.WorkflowConfig
/*6.2*/import org.silkframework.workbench.Context
/*7.2*/import org.silkframework.runtime.activity.UserContext

object editor extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Context[Workflow],Session,UserContext,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(context: Context[Workflow])(implicit session: Session, userContext: UserContext, request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*11.2*/header/*11.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*11.12*/("""
  """),format.raw/*12.3*/("""<link type="text/css" href=""""),_display_(/*12.32*/Assets/*12.38*/.at("editor/editor.css")),format.raw/*12.62*/("""" rel="stylesheet" />

  <script src=""""),_display_(/*14.17*/CoreAssets/*14.27*/.at("libs/jsplumb/dist/js/jsplumb.js")),format.raw/*14.65*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*15.17*/CoreAssets/*15.27*/.at("libs/dynep/dynep.js")),format.raw/*15.53*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*16.17*/Assets/*16.23*/.at("editor/editor.js")),format.raw/*16.46*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*17.17*/Assets/*17.23*/.at("editor/serializeWorkflow.js")),format.raw/*17.57*/("""" type="text/javascript"></script>

  <script type="text/javascript">
    var apiUrl = '"""),_display_(/*20.20*/config/*20.26*/.baseUrl),format.raw/*20.34*/("""/workflow/workflows/"""),_display_(/*20.55*/context/*20.62*/.project.name),format.raw/*20.75*/("""/"""),_display_(/*20.77*/context/*20.84*/.task.id),format.raw/*20.92*/("""';
    var workflowId = '"""),_display_(/*21.24*/context/*21.31*/.task.id),format.raw/*21.39*/("""';
    var editor = null;
  </script>
""")))};def /*26.2*/toolbar/*26.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*26.13*/("""
"""),format.raw/*27.1*/("""<ul>
  <li>
    <button class="mdl-button mdl-js-button mdl-button--raised" onclick="commitWorkflow()" >Save</button>
  </li>
  <li>
    <div class="spacer"/>
  </li>
  <li>
    """),_display_(/*35.6*/taskActivityControl(context.task.activity(WorkflowConfig.executorName), showButtons = true)),format.raw/*35.97*/("""
  """),format.raw/*36.3*/("""</li>
</ul>
""")))};def /*40.2*/content/*40.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*40.13*/("""
"""),_display_(/*41.2*/toolbox(context.project, context.task)),format.raw/*41.40*/("""

"""),format.raw/*43.1*/("""<div id="editorContent" style="position: relative;" class="mdl-shadow--2dp">
</div>
""")))};
Seq[Any](format.raw/*10.1*/("""
"""),format.raw/*24.2*/("""

"""),format.raw/*38.2*/("""

"""),format.raw/*45.2*/("""

"""),_display_(/*47.2*/main(Some(context), titleLabel = context.task.taskLabel())/*47.60*/(header)/*47.68*/(toolbar)/*47.77*/(content)))
      }
    }
  }

  def render(context:Context[Workflow],session:Session,userContext:UserContext,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(context)(session,userContext,request)

  def f:((Context[Workflow]) => (Session,UserContext,RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (context) => (session,userContext,request) => apply(context)(session,userContext,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workflow/app/views/workflow/editor/editor.scala.html
                  HASH: e08df1c86a514ffb8d7915505b660d6ee2c2f9ff
                  MATRIX: 448->1|517->64|566->107|627->162|691->220|736->259|786->303|1190->359|1374->467|1388->473|1469->477|1499->480|1555->509|1570->515|1615->539|1681->578|1700->588|1759->626|1837->677|1856->687|1903->713|1981->764|1996->770|2040->793|2118->844|2133->850|2188->884|2304->973|2319->979|2348->987|2396->1008|2412->1015|2446->1028|2475->1030|2491->1037|2520->1045|2573->1071|2589->1078|2618->1086|2680->1128|2695->1135|2776->1139|2804->1140|3009->1319|3121->1410|3151->1413|3187->1429|3202->1436|3283->1440|3311->1442|3370->1480|3399->1482|3523->465|3551->1125|3580->1426|3609->1567|3638->1570|3705->1628|3722->1636|3740->1645
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|28->9|32->11|32->11|34->11|35->12|35->12|35->12|35->12|37->14|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|40->17|40->17|40->17|43->20|43->20|43->20|43->20|43->20|43->20|43->20|43->20|43->20|44->21|44->21|44->21|47->26|47->26|49->26|50->27|58->35|58->35|59->36|61->40|61->40|63->40|64->41|64->41|66->43|69->10|70->24|72->38|74->45|76->47|76->47|76->47|76->47
                  -- GENERATED --
              */
          