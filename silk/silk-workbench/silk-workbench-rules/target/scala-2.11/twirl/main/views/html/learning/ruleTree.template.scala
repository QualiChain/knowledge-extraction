
package views.html.learning

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

object ruleTree extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[org.silkframework.rule.LinkageRule,play.twirl.api.HtmlFormat.Appendable] {

  /**
 * Renders a linkage rule as a tree.
 * jQuery.treeview.js and linkageRuleTree.css must be in the header.
 */
  def apply/*5.2*/(rule: org.silkframework.rule.LinkageRule):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*7.2*/import org.silkframework.rule.Operator
/*8.2*/import org.silkframework.rule.similarity.{Comparison, Aggregation}
/*9.2*/import org.silkframework.util.DPair
/*10.2*/import org.silkframework.rule.input.{PathInput, TransformInput}

def /*21.2*/renderOperator/*21.16*/(op: Operator):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*21.34*/(""" """),_display_(/*21.36*/op/*21.38*/ match/*21.44*/ {/*22.3*/case Aggregation(id, required, weight, aggregator, operators) =>/*22.67*/ {_display_(Seq[Any](format.raw/*22.69*/("""
    """),format.raw/*23.5*/("""<li>
      <span class="aggregation">Aggregation: """),_display_(/*24.47*/aggregator/*24.57*/.pluginSpec.id),format.raw/*24.71*/("""</span>
      <ul>
        """),_display_(/*26.10*/operators/*26.19*/.map(renderOperator)),format.raw/*26.39*/("""
      """),format.raw/*27.7*/("""</ul>
    </li>
  """)))}/*30.3*/case Comparison(id, required, weight, threshold, indexing, metric, DPair(input1, input2)) =>/*30.95*/ {_display_(Seq[Any](format.raw/*30.97*/("""
    """),format.raw/*31.5*/("""<li>
      <span class="comparison">Comparison: """),_display_(/*32.45*/metric/*32.51*/.pluginSpec.id),format.raw/*32.65*/(""" """),format.raw/*32.66*/("""("""),_display_(/*32.68*/threshold/*32.77*/.toString),format.raw/*32.86*/(""")</span>
      <ul>
        """),_display_(/*34.10*/renderOperator(input1)),format.raw/*34.32*/("""
        """),_display_(/*35.10*/renderOperator(input2)),format.raw/*35.32*/("""
      """),format.raw/*36.7*/("""</ul>
    </li>
  """)))}/*39.3*/case TransformInput(id, transformer, inputs) =>/*39.50*/ {_display_(Seq[Any](format.raw/*39.52*/("""
    """),format.raw/*40.5*/("""<li>
      <span class="transform">Transformation: """),_display_(/*41.48*/transformer/*41.59*/.pluginSpec.id),format.raw/*41.73*/("""</span>
      <ul>
        """),_display_(/*43.10*/inputs/*43.16*/.map(renderOperator)),format.raw/*43.36*/("""
      """),format.raw/*44.7*/("""</ul>
    </li>
  """)))}/*47.3*/case PathInput(id, path) =>/*47.30*/ {_display_(Seq[Any](format.raw/*47.32*/("""
    """),format.raw/*48.5*/("""<li>
      <span class="input">Input: """),_display_(/*49.35*/path/*49.39*/.toString),format.raw/*49.48*/("""</span>
    </li>
  """)))}})))};
Seq[Any](format.raw/*6.1*/("""
"""),format.raw/*11.1*/("""
"""),format.raw/*12.1*/("""<ul class="details-tree">
  """),_display_(/*13.4*/for(aggregation <- rule.operator.toList) yield /*13.44*/ {_display_(Seq[Any](format.raw/*13.46*/("""
    """),_display_(/*14.6*/renderOperator(aggregation)),format.raw/*14.33*/("""
  """)))}),format.raw/*15.4*/("""
"""),format.raw/*16.1*/("""</ul>

"""),format.raw/*20.4*/("""
"""),format.raw/*52.3*/("""
"""))
      }
    }
  }

  def render(rule:org.silkframework.rule.LinkageRule): play.twirl.api.HtmlFormat.Appendable = apply(rule)

  def f:((org.silkframework.rule.LinkageRule) => play.twirl.api.HtmlFormat.Appendable) = (rule) => apply(rule)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/learning/ruleTree.scala.html
                  HASH: ec0ec93e76315b13f8b0a72c6f8f6a17644dec95
                  MATRIX: 878->115|993->160|1039->200|1113->268|1157->305|1234->531|1257->545|1352->563|1381->565|1392->567|1407->573|1417->578|1490->642|1530->644|1562->649|1640->700|1659->710|1694->724|1749->752|1767->761|1808->781|1842->788|1879->810|1980->902|2020->904|2052->909|2128->958|2143->964|2178->978|2207->979|2236->981|2254->990|2284->999|2340->1028|2383->1050|2420->1060|2463->1082|2497->1089|2534->1111|2590->1158|2630->1160|2662->1165|2741->1217|2761->1228|2796->1242|2851->1270|2866->1276|2907->1296|2941->1303|2978->1325|3014->1352|3054->1354|3086->1359|3152->1398|3165->1402|3195->1411|3259->158|3287->369|3315->370|3370->399|3426->439|3466->441|3498->447|3546->474|3580->478|3608->479|3642->529|3670->1435
                  LINES: 24->5|27->7|28->8|29->9|30->10|32->21|32->21|34->21|34->21|34->21|34->21|34->22|34->22|34->22|35->23|36->24|36->24|36->24|38->26|38->26|38->26|39->27|41->30|41->30|41->30|42->31|43->32|43->32|43->32|43->32|43->32|43->32|43->32|45->34|45->34|46->35|46->35|47->36|49->39|49->39|49->39|50->40|51->41|51->41|51->41|53->43|53->43|53->43|54->44|56->47|56->47|56->47|57->48|58->49|58->49|58->49|61->6|62->11|63->12|64->13|64->13|64->13|65->14|65->14|66->15|67->16|69->20|70->52
                  -- GENERATED --
              */
          