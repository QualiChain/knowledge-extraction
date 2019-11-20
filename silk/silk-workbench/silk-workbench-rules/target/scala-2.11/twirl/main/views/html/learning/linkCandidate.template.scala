
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
/*1.2*/import org.silkframework.util.DPair
/*2.2*/import org.silkframework.entity.Link
/*3.2*/import models.linking.LinkCandidateDecision
/*4.2*/import controllers.linking.routes
/*5.2*/import models.learning.PathValue
/*6.2*/import models.learning.PathValues
/*7.2*/import org.silkframework.rule.LinkSpec
/*8.2*/import org.silkframework.workbench.Context

object linkCandidate extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Link,Seq[PathValues],Seq[PathValues],Context[LinkSpec],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*10.2*/(link: Link, sourceValues: Seq[PathValues], targetValues: Seq[PathValues],context: Context[LinkSpec]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*24.2*/table/*24.7*/(selectedValues: Seq[PathValues]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*24.44*/("""
  """),format.raw/*25.3*/("""<div class="mdl-cell mdl-cell--6-col">
    <table style="width: 100%;">
      <thead>
        <tr>
          <th>Path</th>
          <th>Value</th>
        </tr>
      </thead>
      <tbody>
        """),_display_(/*34.10*/for(PathValues(path, pathValues) <- selectedValues) yield /*34.61*/ {_display_(Seq[Any](format.raw/*34.63*/("""
          """),format.raw/*35.11*/("""<tr>
            <td><span class="learning_path_label">"""),_display_(/*36.52*/path),format.raw/*36.56*/("""</span></td>
            <td>
              """),_display_(/*38.16*/for(PathValue(value, similarityClass) <- pathValues) yield /*38.68*/ {_display_(Seq[Any](format.raw/*38.70*/("""
                """),format.raw/*39.17*/("""<span class="learning-value"""),_display_(/*39.45*/similarityClass/*39.60*/.getOrElse(0)),format.raw/*39.73*/("""" >"""),_display_(/*39.77*/value),format.raw/*39.82*/("""</span>
              """)))}),format.raw/*40.16*/("""
            """),format.raw/*41.13*/("""</td>
          </tr>
        """)))}),format.raw/*43.10*/("""
      """),format.raw/*44.7*/("""</tbody>
    </table>
  </div>
""")))};
Seq[Any](format.raw/*11.1*/("""
"""),format.raw/*12.1*/("""<div id="link-candidate-buttons" class="button-set" style="text-align: center; margin-bottom: 20px;">
  <button id="confirmButton" class="mdl-button mdl-js-button mdl-button--raised" onclick="confirm()" title="Confirm this link candidate as correct." >Confirm</button>
  <button id="declineButton" class="mdl-button mdl-js-button mdl-button--raised" onclick="decline()" title="Confirm this link candidate as incorrect." >Decline</button>
  <button id="notSureButton" class="mdl-button mdl-js-button mdl-button--raised" onclick="pass()" title="Show the next link." >Not Sure</button>
  <button id="doneButton" class="mdl-button mdl-js-button mdl-button--raised" onclick="done()" title="Show generated linkage rules." >Done</button>
</div>

<div class="mdl-grid" style="clear: left">
  """),_display_(/*20.4*/table(sourceValues)),format.raw/*20.23*/("""
  """),_display_(/*21.4*/table(targetValues)),format.raw/*21.23*/("""
"""),format.raw/*22.1*/("""</div>

"""),format.raw/*47.2*/("""

"""),format.raw/*49.1*/("""<script type="text/javascript">

  function confirm() """),format.raw/*51.22*/("""{"""),format.raw/*51.23*/("""
    """),format.raw/*52.5*/("""nextLinkCandidate('"""),_display_(/*52.25*/routes/*52.31*/.Learning.activeLearnCandidate(context.project.name, context.task.id).url),format.raw/*52.104*/("""', '"""),_display_(/*52.109*/LinkCandidateDecision/*52.130*/.positive),format.raw/*52.139*/("""');
  """),format.raw/*53.3*/("""}"""),format.raw/*53.4*/("""

  """),format.raw/*55.3*/("""function decline() """),format.raw/*55.22*/("""{"""),format.raw/*55.23*/("""
    """),format.raw/*56.5*/("""nextLinkCandidate('"""),_display_(/*56.25*/routes/*56.31*/.Learning.activeLearnCandidate(context.project.name, context.task.id).url),format.raw/*56.104*/("""', '"""),_display_(/*56.109*/LinkCandidateDecision/*56.130*/.negative),format.raw/*56.139*/("""');
  """),format.raw/*57.3*/("""}"""),format.raw/*57.4*/("""

  """),format.raw/*59.3*/("""function pass() """),format.raw/*59.19*/("""{"""),format.raw/*59.20*/("""
    """),format.raw/*60.5*/("""nextLinkCandidate('"""),_display_(/*60.25*/routes/*60.31*/.Learning.activeLearnCandidate(context.project.name, context.task.id).url),format.raw/*60.104*/("""', '"""),_display_(/*60.109*/LinkCandidateDecision/*60.130*/.pass),format.raw/*60.135*/("""');
  """),format.raw/*61.3*/("""}"""),format.raw/*61.4*/("""

  """),format.raw/*63.3*/("""function done() """),format.raw/*63.19*/("""{"""),format.raw/*63.20*/("""
    """),format.raw/*64.5*/("""window.location = """"),_display_(/*64.25*/routes/*64.31*/.Learning.population(context.project.name, context.task.id).url),format.raw/*64.94*/(""""
  """),format.raw/*65.3*/("""}"""),format.raw/*65.4*/("""

  """),format.raw/*67.3*/("""function nextLinkCandidate(url, decision) """),format.raw/*67.45*/("""{"""),format.raw/*67.46*/("""
    """),format.raw/*68.5*/("""var buttons = $("#link-candidate-buttons").find("button");
    buttons.prop("disabled", true);

    $.post(
      url,
      """),format.raw/*73.7*/("""{"""),format.raw/*73.8*/("""
        """),format.raw/*74.9*/("""source: """"),_display_(/*74.19*/link/*74.23*/.source),format.raw/*74.30*/("""",
        target: """"),_display_(/*75.19*/link/*75.23*/.target),format.raw/*75.30*/("""",
        decision: decision
      """),format.raw/*77.7*/("""}"""),format.raw/*77.8*/(""",
      function(data) """),format.raw/*78.22*/("""{"""),format.raw/*78.23*/("""
        """),format.raw/*79.9*/("""$('#link-candidate-wrapper').html(data);
        buttons.prop("disabled", false);
      """),format.raw/*81.7*/("""}"""),format.raw/*81.8*/(""")
      .fail(function(request) """),format.raw/*82.31*/("""{"""),format.raw/*82.32*/(""" """),format.raw/*82.33*/("""alert(request.responseText); """),format.raw/*82.62*/("""}"""),format.raw/*82.63*/(""")
  """),format.raw/*83.3*/("""}"""),format.raw/*83.4*/("""

"""),format.raw/*85.1*/("""</script>
"""))
      }
    }
  }

  def render(link:Link,sourceValues:Seq[PathValues],targetValues:Seq[PathValues],context:Context[LinkSpec]): play.twirl.api.HtmlFormat.Appendable = apply(link,sourceValues,targetValues,context)

  def f:((Link,Seq[PathValues],Seq[PathValues],Context[LinkSpec]) => play.twirl.api.HtmlFormat.Appendable) = (link,sourceValues,targetValues,context) => apply(link,sourceValues,targetValues,context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/learning/linkCandidate.scala.html
                  HASH: 76f7ec3a892508f09293d0aa553f2eda333387d4
                  MATRIX: 441->1|484->38|528->76|579->121|620->156|660->190|701->225|747->265|1151->310|1331->1250|1344->1255|1458->1292|1488->1295|1715->1495|1782->1546|1822->1548|1861->1559|1944->1615|1969->1619|2041->1664|2109->1716|2149->1718|2194->1735|2249->1763|2273->1778|2307->1791|2338->1795|2364->1800|2418->1823|2459->1836|2521->1867|2555->1874|2626->412|2654->413|3465->1198|3505->1217|3535->1221|3575->1240|3603->1241|3638->1906|3667->1908|3749->1962|3778->1963|3810->1968|3857->1988|3872->1994|3967->2067|4000->2072|4031->2093|4062->2102|4095->2108|4123->2109|4154->2113|4201->2132|4230->2133|4262->2138|4309->2158|4324->2164|4419->2237|4452->2242|4483->2263|4514->2272|4547->2278|4575->2279|4606->2283|4650->2299|4679->2300|4711->2305|4758->2325|4773->2331|4868->2404|4901->2409|4932->2430|4959->2435|4992->2441|5020->2442|5051->2446|5095->2462|5124->2463|5156->2468|5203->2488|5218->2494|5302->2557|5333->2561|5361->2562|5392->2566|5462->2608|5491->2609|5523->2614|5675->2739|5703->2740|5739->2749|5776->2759|5789->2763|5817->2770|5865->2791|5878->2795|5906->2802|5969->2838|5997->2839|6048->2862|6077->2863|6113->2872|6228->2960|6256->2961|6316->2993|6345->2994|6374->2995|6431->3024|6460->3025|6491->3029|6519->3030|6548->3032
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|29->10|33->24|33->24|35->24|36->25|45->34|45->34|45->34|46->35|47->36|47->36|49->38|49->38|49->38|50->39|50->39|50->39|50->39|50->39|50->39|51->40|52->41|54->43|55->44|59->11|60->12|68->20|68->20|69->21|69->21|70->22|72->47|74->49|76->51|76->51|77->52|77->52|77->52|77->52|77->52|77->52|77->52|78->53|78->53|80->55|80->55|80->55|81->56|81->56|81->56|81->56|81->56|81->56|81->56|82->57|82->57|84->59|84->59|84->59|85->60|85->60|85->60|85->60|85->60|85->60|85->60|86->61|86->61|88->63|88->63|88->63|89->64|89->64|89->64|89->64|90->65|90->65|92->67|92->67|92->67|93->68|98->73|98->73|99->74|99->74|99->74|99->74|100->75|100->75|100->75|102->77|102->77|103->78|103->78|104->79|106->81|106->81|107->82|107->82|107->82|107->82|107->82|108->83|108->83|110->85
                  -- GENERATED --
              */
          