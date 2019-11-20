
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
/*1.2*/import org.silkframework.learning.active.ActiveLearningState
/*3.2*/import org.silkframework.rule.input.Input
/*4.2*/import org.silkframework.rule.input.PathInput
/*5.2*/import org.silkframework.rule.input.TransformInput
/*6.2*/import org.silkframework.config.Prefixes

object activeLearnDetails extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[ActiveLearningState,Prefixes,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*8.2*/(state: ActiveLearningState, prefixes: Prefixes):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*29.2*/printInput/*29.12*/(input: Input) = {{ input match {
  case pathInput: PathInput => pathInput.path.serialize()(prefixes)
  case transformInput: TransformInput => "Transformed"
}}};
Seq[Any](format.raw/*9.1*/("""
"""),_display_(/*10.2*/widgets/*10.9*/.dialog(title = "Details", width = 500)/*10.48*/ {_display_(Seq[Any](format.raw/*10.50*/("""

  """),_display_(/*12.4*/state/*12.9*/.pool.links.size),format.raw/*12.25*/(""" """),format.raw/*12.26*/("""link candidates in the pool
  <br/>

  Comparison Generators:

  """),_display_(/*17.4*/for(generator <- state.generator.comparisonGenerators) yield /*17.58*/ {_display_(Seq[Any](format.raw/*17.60*/("""
    """),format.raw/*18.5*/("""<br/>
    """),_display_(/*19.6*/printInput(generator.inputGenerators.source.input.build)),format.raw/*19.62*/(""" """),format.raw/*19.63*/("""- """),_display_(/*19.66*/printInput(generator.inputGenerators.target.input.build)),format.raw/*19.122*/(""" """),format.raw/*19.123*/("""- """),_display_(/*19.126*/generator/*19.135*/.measure.build.toString),format.raw/*19.158*/("""
  """)))}),format.raw/*20.4*/("""

  """),format.raw/*22.3*/("""<script type="text/javascript">
    function submit() """),format.raw/*23.23*/("""{"""),format.raw/*23.24*/("""
      """),format.raw/*24.7*/("""closeDialog();
    """),format.raw/*25.5*/("""}"""),format.raw/*25.6*/("""
  """),format.raw/*26.3*/("""</script>
""")))}),format.raw/*27.2*/("""

"""))
      }
    }
  }

  def render(state:ActiveLearningState,prefixes:Prefixes): play.twirl.api.HtmlFormat.Appendable = apply(state,prefixes)

  def f:((ActiveLearningState,Prefixes) => play.twirl.api.HtmlFormat.Appendable) = (state,prefixes) => apply(state,prefixes)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/learning/activeLearnDetails.scala.html
                  HASH: c0e5d6f193a06da9107b05d87846082558e13ef6
                  MATRIX: 441->1|509->64|558->107|611->154|669->206|1049->249|1176->772|1195->782|1383->298|1411->300|1426->307|1474->346|1514->348|1545->353|1558->358|1595->374|1624->375|1716->441|1786->495|1826->497|1858->502|1895->513|1972->569|2001->570|2031->573|2109->629|2139->630|2170->633|2189->642|2234->665|2268->669|2299->673|2381->727|2410->728|2444->735|2490->754|2518->755|2548->758|2589->769
                  LINES: 17->1|18->3|19->4|20->5|21->6|26->8|30->29|30->29|34->9|35->10|35->10|35->10|35->10|37->12|37->12|37->12|37->12|42->17|42->17|42->17|43->18|44->19|44->19|44->19|44->19|44->19|44->19|44->19|44->19|44->19|45->20|47->22|48->23|48->23|49->24|50->25|50->25|51->26|52->27
                  -- GENERATED --
              */
          