
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
/*1.2*/import org.silkframework.rule.evaluation.ReferenceEntities
/*2.2*/import org.silkframework.rule.evaluation.EvaluationResult
/*3.2*/import org.silkframework.rule.evaluation.LinkageRuleEvaluator

object populationTable extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,String,Seq[org.silkframework.learning.individual.Individual],ReferenceEntities,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(project: String, task: String,
  individuals: Seq[org.silkframework.learning.individual.Individual],
  referenceEntities: ReferenceEntities):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*9.2*/import org.silkframework.learning.individual.Individual
/*10.2*/import org.silkframework.rule.evaluation.ReferenceEntities
/*11.2*/import org.silkframework.rule.evaluation.statistics.LinkageRuleComplexity
/*12.2*/import org.apache.commons.lang3.StringEscapeUtils
/*13.2*/import org.silkframework.runtime.serialization.XmlSerialization
/*14.2*/import controllers.rules.routes.Assets

def /*34.2*/renderIndividual/*34.18*/(individual: Individual, referenceEntities: ReferenceEntities, counter: Int):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*34.98*/("""
  """),format.raw/*35.3*/("""<div class="individual" id=""""),_display_(/*35.32*/id(individual)),format.raw/*35.46*/("""" >
    """),_display_(/*36.6*/renderIndividualHeader(individual, LinkageRuleEvaluator(individual.node.build, referenceEntities), counter)),format.raw/*36.113*/("""
    """),_display_(/*37.6*/renderIndividualContent(individual)),format.raw/*37.41*/("""
    """),format.raw/*38.5*/("""<div style="clear:both"></div>
  </div>
""")))};def /*45.2*/renderIndividualHeader/*45.24*/(individual: Individual, scores: EvaluationResult, counter: Int):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*45.92*/("""
  """),format.raw/*46.3*/("""<div class=""""),_display_(/*46.16*/if(counter % 2==0)/*46.34*/ {_display_(Seq[Any](format.raw/*46.36*/("""individual-header grey""")))}/*46.60*/else/*46.65*/{_display_(Seq[Any](format.raw/*46.66*/("""individual-header""")))}),format.raw/*46.84*/(""""
       onmouseover="$(this).addClass('individual-over');"
       onmouseout="$(this).removeClass('individual-over');">
    <div id=""""),_display_(/*49.15*/id(individual, "toggle")),format.raw/*49.39*/(""""><span class="ui-icon ui-icon ui-icon-triangle-1-e"></span></div>
    <div class="individual-desc">"""),_display_(/*50.35*/renderDescription(individual)),format.raw/*50.64*/("""</div>
    <div class="individual-score">"""),_display_(/*51.36*/renderScore(individual.fitness)),format.raw/*51.67*/("""</div>
    <div class="individual-mcc">"""),_display_(/*52.34*/renderScore(scores.mcc)),format.raw/*52.57*/("""</div>
    <div class="individual-f1">"""),_display_(/*53.33*/renderScore(scores.fMeasure)),format.raw/*53.61*/("""</div>
    <div class="individual-buttons">"""),_display_(/*54.38*/renderButtons(individual)),format.raw/*54.63*/("""</div>
  </div>
""")))};def /*70.2*/renderScore/*70.13*/(score: Double):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*70.32*/("""
  """),format.raw/*71.3*/("""<div class="confidencebar">
    <div class="confidence">"""),_display_(/*72.30*/{"%.1f".format(score * 100)}),format.raw/*72.58*/("""%</div>
  </div>
""")))};def /*79.2*/renderButtons/*79.15*/(individual: Individual):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*79.43*/("""
  """),format.raw/*80.3*/("""<a onclick=""""),_display_(/*80.16*/{id(individual, "loadIndividual")}),format.raw/*80.50*/("""()">
    <img src=""""),_display_(/*81.16*/Assets/*81.22*/.at("img/learn/load.png")),format.raw/*81.47*/("""" title="Load this linkage rule in the editor" />
  </a>
  <script type="text/javascript">//<![CDATA[
    function """),_display_(/*84.15*/{id(individual, "loadIndividual")}),format.raw/*84.49*/("""() """),format.raw/*84.52*/("""{"""),format.raw/*84.53*/("""
      """),format.raw/*85.7*/("""if(confirm("This will overwrite the current linkage rule! ")) """),format.raw/*85.69*/("""{"""),format.raw/*85.70*/("""
        """),format.raw/*86.9*/("""$.ajax("""),format.raw/*86.16*/("""{"""),format.raw/*86.17*/("""
          """),format.raw/*87.11*/("""type: 'PUT',
          url: '"""),_display_(/*88.18*/config/*88.24*/.baseUrl),format.raw/*88.32*/("""/linking/tasks/"""),_display_(/*88.48*/project),format.raw/*88.55*/("""/"""),_display_(/*88.57*/task),format.raw/*88.61*/("""/rule',
          data: '"""),_display_(/*89.19*/Html(StringEscapeUtils.escapeEcmaScript(XmlSerialization.toXml(individual.node.build).toString))),format.raw/*89.115*/("""',
          contentType: 'text/xml;charset=UTF-8',
          processData: false,
          success: function(response) """),format.raw/*92.39*/("""{"""),format.raw/*92.40*/("""
            """),format.raw/*93.13*/("""window.location = '../editor';
          """),format.raw/*94.11*/("""}"""),format.raw/*94.12*/(""",
          error: function(request) """),format.raw/*95.36*/("""{"""),format.raw/*95.37*/("""
            """),format.raw/*96.13*/("""alert(request.responseText);
          """),format.raw/*97.11*/("""}"""),format.raw/*97.12*/("""
        """),format.raw/*98.9*/("""}"""),format.raw/*98.10*/(""");
      """),format.raw/*99.7*/("""}"""),format.raw/*99.8*/("""
    """),format.raw/*100.5*/("""}"""),format.raw/*100.6*/("""
  """),format.raw/*101.3*/("""//]]>
  </script>
""")))};def /*108.2*/renderIndividualContent/*108.25*/(individual: Individual):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*108.53*/("""
  """),format.raw/*109.3*/("""<div class="individual-details" id=""""),_display_(/*109.40*/id(individual, "details")),format.raw/*109.65*/("""">
    """),_display_(/*110.6*/ruleTree(individual.node.build)),format.raw/*110.37*/("""
  """),format.raw/*111.3*/("""</div>
""")))};def /*61.2*/renderDescription/*61.19*/(individual: Individual) = {{
  val complexity = LinkageRuleComplexity(individual.node.build)

  complexity.comparisonCount + " Comparisons and " + complexity.transformationCount + " Transformations"
}};def /*117.2*/id/*117.4*/(individual : Individual, prefix : String = "") = {{
  prefix + individual.hashCode.toString.replace('-', '_')
}};
Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*15.1*/("""
"""),format.raw/*16.1*/("""<div>
  <div class="individual">
    <div class="individual-header heading">
      <div class="individual-desc">Description</div>
      <div class="individual-score">Score</div>
      <div class="individual-mcc">MCC</div>
      <div class="individual-f1">F-Measure</div>
      <div class="individual-buttons">Actions</div>
    </div>
  </div>
  """),_display_(/*26.4*/for((individual, count) <- individuals.zipWithIndex) yield /*26.56*/ {_display_(Seq[Any](format.raw/*26.58*/("""
    """),_display_(/*27.6*/renderIndividual(individual, referenceEntities, count)),format.raw/*27.60*/("""
  """)))}),format.raw/*28.4*/("""
"""),format.raw/*29.1*/("""</div>

"""),format.raw/*33.4*/("""
"""),format.raw/*40.2*/("""

"""),format.raw/*44.4*/("""
"""),format.raw/*56.2*/("""

"""),format.raw/*60.4*/("""
"""),format.raw/*65.2*/("""

"""),format.raw/*69.4*/("""
"""),format.raw/*74.2*/("""

"""),format.raw/*78.4*/("""
"""),format.raw/*103.2*/("""

"""),format.raw/*107.4*/("""
"""),format.raw/*112.2*/("""

"""),format.raw/*116.4*/("""
"""))
      }
    }
  }

  def render(project:String,task:String,individuals:Seq[org.silkframework.learning.individual.Individual],referenceEntities:ReferenceEntities): play.twirl.api.HtmlFormat.Appendable = apply(project,task,individuals,referenceEntities)

  def f:((String,String,Seq[org.silkframework.learning.individual.Individual],ReferenceEntities) => play.twirl.api.HtmlFormat.Appendable) = (project,task,individuals,referenceEntities) => apply(project,task,individuals,referenceEntities)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/learning/populationTable.scala.html
                  HASH: 168f27544e727c94a1cde8395e921cbed56f673d
                  MATRIX: 441->1|507->61|572->120|1027->184|1241->328|1305->385|1372->445|1454->520|1512->571|1584->636|1636->1190|1661->1206|1818->1286|1848->1289|1904->1318|1939->1332|1974->1341|2103->1448|2135->1454|2191->1489|2223->1494|2287->1597|2318->1619|2463->1687|2493->1690|2533->1703|2560->1721|2600->1723|2642->1747|2655->1752|2694->1753|2743->1771|2905->1906|2950->1930|3078->2031|3128->2060|3197->2102|3249->2133|3316->2173|3360->2196|3426->2235|3475->2263|3546->2307|3592->2332|3632->2675|3652->2686|3748->2705|3778->2708|3862->2765|3911->2793|3952->2871|3974->2884|4079->2912|4109->2915|4149->2928|4204->2962|4251->2982|4266->2988|4312->3013|4455->3129|4510->3163|4541->3166|4570->3167|4604->3174|4694->3236|4723->3237|4759->3246|4794->3253|4823->3254|4862->3265|4919->3295|4934->3301|4963->3309|5006->3325|5034->3332|5063->3334|5088->3338|5141->3364|5259->3460|5407->3580|5436->3581|5477->3594|5546->3635|5575->3636|5640->3673|5669->3674|5710->3687|5777->3726|5806->3727|5842->3736|5871->3737|5907->3746|5935->3747|5968->3752|5997->3753|6028->3756|6071->3831|6104->3854|6210->3882|6241->3885|6306->3922|6353->3947|6388->3955|6441->3986|6472->3989|6503->2405|6529->2422|6745->4054|6756->4056|6897->326|6925->675|6953->676|7325->1022|7393->1074|7433->1076|7465->1082|7540->1136|7574->1140|7602->1141|7637->1188|7665->1535|7694->1595|7722->2349|7751->2403|7779->2623|7808->2673|7836->2811|7865->2869|7894->3775|7924->3829|7953->3997|7983->4052
                  LINES: 17->1|18->2|19->3|24->5|29->9|30->10|31->11|32->12|33->13|34->14|36->34|36->34|38->34|39->35|39->35|39->35|40->36|40->36|41->37|41->37|42->38|44->45|44->45|46->45|47->46|47->46|47->46|47->46|47->46|47->46|47->46|47->46|50->49|50->49|51->50|51->50|52->51|52->51|53->52|53->52|54->53|54->53|55->54|55->54|57->70|57->70|59->70|60->71|61->72|61->72|63->79|63->79|65->79|66->80|66->80|66->80|67->81|67->81|67->81|70->84|70->84|70->84|70->84|71->85|71->85|71->85|72->86|72->86|72->86|73->87|74->88|74->88|74->88|74->88|74->88|74->88|74->88|75->89|75->89|78->92|78->92|79->93|80->94|80->94|81->95|81->95|82->96|83->97|83->97|84->98|84->98|85->99|85->99|86->100|86->100|87->101|89->108|89->108|91->108|92->109|92->109|92->109|93->110|93->110|94->111|95->61|95->61|99->117|99->117|102->8|103->15|104->16|114->26|114->26|114->26|115->27|115->27|116->28|117->29|119->33|120->40|122->44|123->56|125->60|126->65|128->69|129->74|131->78|132->103|134->107|135->112|137->116
                  -- GENERATED --
              */
          