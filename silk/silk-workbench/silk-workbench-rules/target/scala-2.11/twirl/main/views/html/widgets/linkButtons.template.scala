
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
/*1.2*/import controllers.rules.routes.Assets
/*2.2*/import java.net.URLEncoder
/*3.2*/import models.linking.EvalLink
/*4.2*/import models.linking.EvalLink._

object linkButtons extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[EvalLink,Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(link: EvalLink,
  rateButtons: Boolean):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*31.2*/encode/*31.8*/(link: EvalLink):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*31.28*/("""'"""),_display_(/*31.30*/link/*31.34*/.hashCode),format.raw/*31.43*/("""', '"""),_display_(/*31.48*/URLEncoder/*31.58*/.encode(link.source, "UTF-8")),format.raw/*31.87*/("""', '"""),_display_(/*31.92*/URLEncoder/*31.102*/.encode(link.target, "UTF-8")),format.raw/*31.131*/("""'""")))};def /*33.2*/id/*33.4*/(prefix: String = "") = {{ prefix + link.hashCode }};
Seq[Any](format.raw/*8.1*/("""
"""),_display_(/*9.2*/if(rateButtons)/*9.17*/ {_display_(Seq[Any](format.raw/*9.19*/("""
  """),format.raw/*10.3*/("""<div>
    <div class=""""),_display_(/*11.18*/if(link.correct == Correct)/*11.45*/ {_display_(Seq[Any](format.raw/*11.47*/("""displayAsBlock""")))}/*11.63*/else/*11.68*/{_display_(Seq[Any](format.raw/*11.69*/("""displayAsNone""")))}),format.raw/*11.83*/("""" id=""""),_display_(/*11.90*/id("confirmedLink")),format.raw/*11.109*/("""">
      <img src=""""),_display_(/*12.18*/Assets/*12.24*/.at("img/confirm.png")),format.raw/*12.46*/(""""/>
      <a class="link-buttons-undecided" onclick="resetLink("""),_display_(/*13.61*/encode(link)),format.raw/*13.73*/(""")"><img src=""""),_display_(/*13.87*/Assets/*13.93*/.at("img/undecided-disabled.png")),format.raw/*13.126*/(""""/></a>
      <a class="link-buttons-decline" onclick="addNegativeLink("""),_display_(/*14.65*/encode(link)),format.raw/*14.77*/(""")"><img src=""""),_display_(/*14.91*/Assets/*14.97*/.at("img/decline-disabled.png")),format.raw/*14.128*/(""""/></a>
    </div>
    <div class=""""),_display_(/*16.18*/if(link.correct == Incorrect)/*16.47*/ {_display_(Seq[Any](format.raw/*16.49*/("""displayAsBlock""")))}/*16.65*/else/*16.70*/{_display_(Seq[Any](format.raw/*16.71*/("""displayAsNone""")))}),format.raw/*16.85*/("""" id=""""),_display_(/*16.92*/id("declinedLink")),format.raw/*16.110*/("""">
      <a class="link-buttons-confirm" onclick="addPositiveLink("""),_display_(/*17.65*/encode(link)),format.raw/*17.77*/(""")"><img src=""""),_display_(/*17.91*/Assets/*17.97*/.at("img/confirm-disabled.png")),format.raw/*17.128*/(""""/></a>
      <a class="link-buttons-undecided" onclick="resetLink("""),_display_(/*18.61*/encode(link)),format.raw/*18.73*/(""")"><img src=""""),_display_(/*18.87*/Assets/*18.93*/.at("img/undecided-disabled.png")),format.raw/*18.126*/(""""/></a>
      <img src=""""),_display_(/*19.18*/Assets/*19.24*/.at("img/decline.png")),format.raw/*19.46*/(""""/>
    </div>
    <div class=""""),_display_(/*21.18*/if(link.correct == Unknown)/*21.45*/ {_display_(Seq[Any](format.raw/*21.47*/("""displayAsBlock""")))}/*21.63*/else/*21.68*/{_display_(Seq[Any](format.raw/*21.69*/("""displayAsNone""")))}),format.raw/*21.83*/("""" id=""""),_display_(/*21.90*/id("undecidedLink")),format.raw/*21.109*/("""">
      <a class="link-buttons-confirm" onclick="addPositiveLink("""),_display_(/*22.65*/encode(link)),format.raw/*22.77*/(""")"><img src=""""),_display_(/*22.91*/Assets/*22.97*/.at("img/confirm-disabled.png")),format.raw/*22.128*/(""""/></a>
      <img src=""""),_display_(/*23.18*/Assets/*23.24*/.at("img/undecided.png")),format.raw/*23.48*/(""""/>
      <a class="link-buttons-undecided" onclick="addNegativeLink("""),_display_(/*24.67*/encode(link)),format.raw/*24.79*/(""")"><img src=""""),_display_(/*24.93*/Assets/*24.99*/.at("img/decline-disabled.png")),format.raw/*24.130*/(""""/></a>
    </div>
  </div>
""")))}/*27.3*/else/*27.8*/{_display_(Seq[Any](format.raw/*27.9*/("""
  """),format.raw/*28.3*/("""<a onclick="deleteLink("""),_display_(/*28.27*/encode(link)),format.raw/*28.39*/(""")"><img title="Remove link" alt="Remove link" src=""""),_display_(/*28.91*/Assets/*28.97*/.at("img/delete.png")),format.raw/*28.118*/(""""/></a>
""")))}),format.raw/*29.2*/("""

"""),format.raw/*31.133*/("""

"""))
      }
    }
  }

  def render(link:EvalLink,rateButtons:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(link,rateButtons)

  def f:((EvalLink,Boolean) => play.twirl.api.HtmlFormat.Appendable) = (link,rateButtons) => apply(link,rateButtons)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/widgets/linkButtons.scala.html
                  HASH: dbc2715f26d81b0f8ba592dec590e56091342f76
                  MATRIX: 440->1|486->41|520->69|558->101|911->136|1030->1676|1044->1682|1141->1702|1170->1704|1183->1708|1213->1717|1245->1722|1264->1732|1314->1761|1346->1766|1366->1776|1417->1805|1442->1810|1452->1812|1532->177|1559->179|1582->194|1621->196|1651->199|1701->222|1737->249|1777->251|1811->267|1824->272|1863->273|1908->287|1942->294|1983->313|2030->333|2045->339|2088->361|2179->425|2212->437|2253->451|2268->457|2323->490|2422->562|2455->574|2496->588|2511->594|2564->625|2627->661|2665->690|2705->692|2739->708|2752->713|2791->714|2836->728|2870->735|2910->753|3004->820|3037->832|3078->846|3093->852|3146->883|3241->951|3274->963|3315->977|3330->983|3385->1016|3437->1041|3452->1047|3495->1069|3554->1101|3590->1128|3630->1130|3664->1146|3677->1151|3716->1152|3761->1166|3795->1173|3836->1192|3930->1259|3963->1271|4004->1285|4019->1291|4072->1322|4124->1347|4139->1353|4184->1377|4281->1447|4314->1459|4355->1473|4370->1479|4423->1510|4470->1540|4482->1545|4520->1546|4550->1549|4601->1573|4634->1585|4713->1637|4728->1643|4771->1664|4810->1673|4841->1807
                  LINES: 17->1|18->2|19->3|20->4|25->6|30->31|30->31|32->31|32->31|32->31|32->31|32->31|32->31|32->31|32->31|32->31|32->31|32->33|32->33|33->8|34->9|34->9|34->9|35->10|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|37->12|37->12|37->12|38->13|38->13|38->13|38->13|38->13|39->14|39->14|39->14|39->14|39->14|41->16|41->16|41->16|41->16|41->16|41->16|41->16|41->16|41->16|42->17|42->17|42->17|42->17|42->17|43->18|43->18|43->18|43->18|43->18|44->19|44->19|44->19|46->21|46->21|46->21|46->21|46->21|46->21|46->21|46->21|46->21|47->22|47->22|47->22|47->22|47->22|48->23|48->23|48->23|49->24|49->24|49->24|49->24|49->24|52->27|52->27|52->27|53->28|53->28|53->28|53->28|53->28|53->28|54->29|56->31
                  -- GENERATED --
              */
          