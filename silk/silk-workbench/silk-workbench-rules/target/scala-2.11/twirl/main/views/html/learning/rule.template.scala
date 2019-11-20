
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
/*1.2*/import controllers.core.routes.{Assets => CoreAssets}
/*2.2*/import org.silkframework.rule.LinkSpec
/*3.2*/import org.silkframework.rule.evaluation.ReferenceLinks
/*4.2*/import org.silkframework.workbench.Context
/*6.2*/import org.silkframework.runtime.activity.UserContext

object rule extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[org.silkframework.learning.individual.Population,ReferenceLinks,Context[LinkSpec],UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(population: org.silkframework.learning.individual.Population,
  referenceLinks: ReferenceLinks,
  context: Context[LinkSpec])(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*10.1*/("""
"""),_display_(/*11.2*/defining(3)/*11.13*/ { threshold =>_display_(Seq[Any](format.raw/*11.28*/("""


  """),_display_(/*14.4*/if(population.isEmpty)/*14.26*/ {_display_(Seq[Any](format.raw/*14.28*/("""
    """),format.raw/*15.5*/("""<div class="alert alert-info"><strong>No linkage rule learned yet.</strong></div>
  """)))}/*16.5*/else/*16.10*/{_display_(Seq[Any](format.raw/*16.11*/("""
    """),_display_(/*17.6*/if(referenceLinks.positive.size >= threshold)/*17.51*/ {_display_(Seq[Any](format.raw/*17.53*/("""
      """),_display_(/*18.8*/ruleGraph(population.bestIndividual.node.build, context)),format.raw/*18.64*/("""
      """),format.raw/*19.7*/("""<script type="text/javascript">
        $("#hide_graph_button").prop('disabled', false);
      </script>
    """)))}/*22.7*/else/*22.12*/{_display_(Seq[Any](format.raw/*22.13*/("""
      """),format.raw/*23.7*/("""<div class="alert alert-info"><strong>You need to confirm at least """),_display_(/*23.75*/{threshold}),format.raw/*23.86*/(""" """),format.raw/*23.87*/("""resource pairs, before a candidate rule can be shown.</strong></div>
    """)))}),format.raw/*24.6*/("""

    """),format.raw/*26.5*/("""<script type="text/javascript">
      """),_display_(/*27.8*/if(!population.isEmpty)/*27.31*/ {_display_(Seq[Any](format.raw/*27.33*/("""
        """),format.raw/*28.9*/("""$("#learning_fitness_info").html("Fitness: """),_display_(/*28.53*/{"%.1f".format(population.bestIndividual.fitness * 100)}),format.raw/*28.109*/(""" """),format.raw/*28.110*/("""(based on """),_display_(/*28.121*/referenceLinks/*28.135*/.positive.size),format.raw/*28.149*/(""" """),format.raw/*28.150*/("""positive and """),_display_(/*28.164*/referenceLinks/*28.178*/.negative.size),format.raw/*28.192*/(""" """),format.raw/*28.193*/("""negative reference links)");
      """)))}),format.raw/*29.8*/("""
    """),format.raw/*30.5*/("""</script>

  """)))}),format.raw/*32.4*/("""

""")))}))
      }
    }
  }

  def render(population:org.silkframework.learning.individual.Population,referenceLinks:ReferenceLinks,context:Context[LinkSpec],userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(population,referenceLinks,context)(userContext)

  def f:((org.silkframework.learning.individual.Population,ReferenceLinks,Context[LinkSpec]) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (population,referenceLinks,context) => (userContext) => apply(population,referenceLinks,context)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/learning/rule.scala.html
                  HASH: 2af460479f51a050d45089e776b94a7f0f270d13
                  MATRIX: 441->1|502->56|548->96|611->153|661->198|1105->253|1361->415|1389->417|1409->428|1462->443|1494->449|1525->471|1565->473|1597->478|1700->564|1713->569|1752->570|1784->576|1838->621|1878->623|1912->631|1989->687|2023->694|2151->805|2164->810|2203->811|2237->818|2332->886|2364->897|2393->898|2497->972|2530->978|2595->1017|2627->1040|2667->1042|2703->1051|2774->1095|2852->1151|2882->1152|2921->1163|2945->1177|2981->1191|3011->1192|3053->1206|3077->1220|3113->1234|3143->1235|3209->1271|3241->1276|3285->1290
                  LINES: 17->1|18->2|19->3|20->4|21->6|26->7|33->10|34->11|34->11|34->11|37->14|37->14|37->14|38->15|39->16|39->16|39->16|40->17|40->17|40->17|41->18|41->18|42->19|45->22|45->22|45->22|46->23|46->23|46->23|46->23|47->24|49->26|50->27|50->27|50->27|51->28|51->28|51->28|51->28|51->28|51->28|51->28|51->28|51->28|51->28|51->28|51->28|52->29|53->30|55->32
                  -- GENERATED --
              */
          