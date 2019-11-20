
package views.html.widgets

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
/*1.2*/import org.silkframework.rule.execution.LinkingStatistics

object linkingReport extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[LinkingStatistics,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(statistics: LinkingStatistics, linkCount: Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""
"""),format.raw/*5.1*/("""<div class="linkingStatistics">
  <div class="linkingStatisticsHeader">
    Linking Statistics
  </div>
  <table>
    <tr>
      <td>Number of source entities:</td>
      <td>"""),_display_(/*12.12*/statistics/*12.22*/.entityCount.source),format.raw/*12.41*/("""</td>
    </tr>
    <tr>
      <td>Number of target entities:</td>
      <td>"""),_display_(/*16.12*/statistics/*16.22*/.entityCount.target),format.raw/*16.41*/("""</td>
    </tr>
    <tr>
      <td>Number of links:</td>
      <td>"""),_display_(/*20.12*/linkCount),format.raw/*20.21*/("""</td>
    </tr>
  </table>
</div>
"""))
      }
    }
  }

  def render(statistics:LinkingStatistics,linkCount:Int): play.twirl.api.HtmlFormat.Appendable = apply(statistics,linkCount)

  def f:((LinkingStatistics,Int) => play.twirl.api.HtmlFormat.Appendable) = (statistics,linkCount) => apply(statistics,linkCount)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/widgets/linkingReport.scala.html
                  HASH: 5e2be91f5bc1607e22d7620727d93d358f0fdf41
                  MATRIX: 440->1|825->61|966->109|993->110|1196->286|1215->296|1255->315|1360->393|1379->403|1419->422|1514->490|1544->499
                  LINES: 17->1|22->3|27->4|28->5|35->12|35->12|35->12|39->16|39->16|39->16|43->20|43->20
                  -- GENERATED --
              */
          