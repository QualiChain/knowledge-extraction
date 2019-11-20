
package views.html.workflow

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
/*1.2*/import org.silkframework.workspace.activity.workflow.WorkflowExecutionReport
/*2.2*/import org.silkframework.rule.execution.TransformReport
/*3.2*/import views.html.executeTransform.transformReport
/*4.2*/import views.html.widgets.linkingReport
/*5.2*/import org.silkframework.config.Prefixes
/*6.2*/import org.silkframework.execution.ExecutionReport
/*7.2*/import org.silkframework.workspace.activity.workflow.Workflow
/*8.2*/import org.silkframework.rule.execution.Linking
/*9.2*/import org.silkframework.config.Task
/*10.2*/import org.silkframework.rule.TransformSpec
/*11.2*/import org.silkframework.workbench.Context
/*12.2*/import org.silkframework.runtime.activity.UserContext
/*13.2*/import org.silkframework.workspace.ProjectTask
/*14.2*/import controllers.core.routes.{Assets => CoreAssets}

object executionReport extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[WorkflowExecutionReport,Prefixes,Context[Workflow],play.api.mvc.Session,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*16.2*/(report: WorkflowExecutionReport, prefixes: Prefixes, context: Context[Workflow])(implicit session: play.api.mvc.Session, userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*18.2*/header/*18.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*18.12*/("""
  """),format.raw/*19.3*/("""<script src=""""),_display_(/*19.17*/CoreAssets/*19.27*/.at("libs/silk-react-components/main.js")),format.raw/*19.68*/("""" type="text/javascript"></script>
""")))};def /*22.2*/toolbar/*22.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*22.13*/("""

""")))};def /*26.2*/content/*26.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*26.13*/("""
  """),format.raw/*27.3*/("""<div id="react-workflowExecutionReport"></div>

  <script type="text/javascript">
    silkReactComponents.workflowExecutionReport(
      'react-workflowExecutionReport',
      """),format.raw/*32.7*/("""{"""),format.raw/*32.8*/("""
        """),format.raw/*33.9*/("""baseUrl: '"""),_display_(/*33.20*/config/*33.26*/.baseUrl),format.raw/*33.34*/("""',
        project: '"""),_display_(/*34.20*/context/*34.27*/.project.name),format.raw/*34.40*/("""',
        task: '"""),_display_(/*35.17*/context/*35.24*/.task.id),format.raw/*35.32*/("""',
      """),format.raw/*36.7*/("""}"""),format.raw/*36.8*/("""
    """),format.raw/*37.5*/(""");
  </script>
""")))};
Seq[Any](format.raw/*17.1*/("""
"""),format.raw/*20.2*/("""

"""),format.raw/*24.2*/("""

"""),format.raw/*39.2*/("""

"""),_display_(/*41.2*/main(Some(context), titleLabel = context.task.taskLabel())/*41.60*/(header)/*41.68*/(toolbar)/*41.77*/(content)),format.raw/*41.86*/("""
"""))
      }
    }
  }

  def render(report:WorkflowExecutionReport,prefixes:Prefixes,context:Context[Workflow],session:play.api.mvc.Session,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(report,prefixes,context)(session,userContext)

  def f:((WorkflowExecutionReport,Prefixes,Context[Workflow]) => (play.api.mvc.Session,UserContext) => play.twirl.api.HtmlFormat.Appendable) = (report,prefixes,context) => (session,userContext) => apply(report,prefixes,context)(session,userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workflow/app/views/workflow/executionReport.scala.html
                  HASH: 5c59512f02bf70400e8298e16876115e6784bed5
                  MATRIX: 441->1|525->79|588->136|646->188|693->229|741->271|799->323|868->386|923->435|968->473|1020->518|1071->562|1133->617|1188->665|1634->721|1860->871|1874->877|1955->881|1985->884|2026->898|2045->908|2107->949|2166->988|2181->995|2262->999|2288->1005|2303->1012|2384->1016|2414->1019|2617->1195|2645->1196|2681->1205|2719->1216|2734->1222|2763->1230|2812->1252|2828->1259|2862->1272|2908->1291|2924->1298|2953->1306|2989->1315|3017->1316|3049->1321|3104->869|3132->985|3161->1002|3190->1337|3219->1340|3286->1398|3303->1406|3321->1415|3351->1424
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|25->9|26->10|27->11|28->12|29->13|30->14|35->16|39->18|39->18|41->18|42->19|42->19|42->19|42->19|43->22|43->22|45->22|47->26|47->26|49->26|50->27|55->32|55->32|56->33|56->33|56->33|56->33|57->34|57->34|57->34|58->35|58->35|58->35|59->36|59->36|60->37|63->17|64->20|66->24|68->39|70->41|70->41|70->41|70->41|70->41
                  -- GENERATED --
              */
          