
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
/*1.2*/import org.silkframework.rule.execution.TransformReport
/*2.2*/import org.silkframework.rule.execution.TransformReport.RuleResult
/*3.2*/import org.silkframework.rule.execution.TransformReport.RuleError
/*4.2*/import org.silkframework.rule.TransformSpec
/*5.2*/import org.silkframework.config.Prefixes
/*6.2*/import org.silkframework.config.Task
/*7.2*/import org.silkframework.workbench.Context
/*8.2*/import org.silkframework.rule.TransformRule
/*9.2*/import controllers.core.routes.{Assets => CoreAssets}
/*10.2*/import org.silkframework.workspace.ProjectTask

object transformReport extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[ProjectTask[TransformSpec],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*12.2*/(task: ProjectTask[TransformSpec]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*13.1*/("""
"""),format.raw/*14.1*/("""<div>
  <script src=""""),_display_(/*15.17*/CoreAssets/*15.27*/.at("libs/silk-react-components/main.js")),format.raw/*15.68*/("""" type="text/javascript"></script>
  <script type="text/javascript">
    silkReactComponents.transformExecutionReport(
      'react-transformExecutionReport',
      """),format.raw/*19.7*/("""{"""),format.raw/*19.8*/("""
        """),format.raw/*20.9*/("""baseUrl: '"""),_display_(/*20.20*/config/*20.26*/.baseUrl),format.raw/*20.34*/("""',
        project: '"""),_display_(/*21.20*/task/*21.24*/.project.name),format.raw/*21.37*/("""',
        task: '"""),_display_(/*22.17*/task/*22.21*/.id),format.raw/*22.24*/("""',
      """),format.raw/*23.7*/("""}"""),format.raw/*23.8*/("""
    """),format.raw/*24.5*/(""");
  </script>
  <div id="react-transformExecutionReport"></div>
</div>
"""))
      }
    }
  }

  def render(task:ProjectTask[TransformSpec]): play.twirl.api.HtmlFormat.Appendable = apply(task)

  def f:((ProjectTask[TransformSpec]) => play.twirl.api.HtmlFormat.Appendable) = (task) => apply(task)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/executeTransform/transformReport.scala.html
                  HASH: fbe3e40ae8bcb028856563cef4c0916a488de5cb
                  MATRIX: 449->1|512->58|586->126|659->193|710->238|758->280|802->318|852->362|903->407|965->462|1347->511|1476->546|1504->547|1553->569|1572->579|1634->620|1826->785|1854->786|1890->795|1928->806|1943->812|1972->820|2021->842|2034->846|2068->859|2114->878|2127->882|2151->885|2187->894|2215->895|2247->900
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|25->9|26->10|31->12|36->13|37->14|38->15|38->15|38->15|42->19|42->19|43->20|43->20|43->20|43->20|44->21|44->21|44->21|45->22|45->22|45->22|46->23|46->23|47->24
                  -- GENERATED --
              */
          