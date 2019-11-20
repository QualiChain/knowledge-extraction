
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
/*2.2*/import controllers.rules.routes.Assets
/*3.2*/import controllers.linking.routes
/*4.2*/import controllers.linking.routes.Learning
/*5.2*/import controllers.workspace.routes.ActivityApi
/*6.2*/import org.silkframework.learning.active.ActiveLearning
/*7.2*/import views.html.workspace.activity.taskActivityControl
/*8.2*/import models.linking.LinkCandidateDecision
/*9.2*/import org.silkframework.rule.LinkSpec
/*10.2*/import org.silkframework.workbench.Context
/*11.2*/import org.silkframework.learning.active.ActiveLearningFactory
/*12.2*/import views.html.workspace.activity.autoReload

object activeLearn extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Context[LinkSpec],play.api.mvc.Session,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*14.2*/(context: Context[LinkSpec])(implicit session: play.api.mvc.Session, request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*16.2*/header/*16.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*16.12*/("""
  """),format.raw/*17.3*/("""<link type="text/css" href=""""),_display_(/*17.32*/Assets/*17.38*/.at("stylesheets/table.css")),format.raw/*17.66*/("""" rel="stylesheet" />
  <link type="text/css" href=""""),_display_(/*18.32*/Assets/*18.38*/.at("stylesheets/activeLearning.css")),format.raw/*18.75*/("""" rel="stylesheet" />
  <link type="text/css" href=""""),_display_(/*19.32*/Assets/*19.38*/.at("stylesheets/editor/editor.css")),format.raw/*19.74*/("""" rel="stylesheet" />
  <link type="text/css" href=""""),_display_(/*20.32*/Assets/*20.38*/.at("stylesheets/learningEditor.css")),format.raw/*20.75*/("""" rel="stylesheet" />

  <script src=""""),_display_(/*22.17*/CoreAssets/*22.27*/.at("libs/twbs-pagination/jquery.twbsPagination.js")),format.raw/*22.79*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*23.17*/CoreAssets/*23.27*/.at("libs/jsplumb/dist/js/jsplumb.js")),format.raw/*23.65*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*24.17*/Assets/*24.23*/.at("js/editor/editor.js")),format.raw/*24.49*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*25.17*/Assets/*25.23*/.at("js/editor/status.js")),format.raw/*25.49*/("""" type="text/javascript"></script>

  <script type="text/javascript">
    var inEditorEnv = false;
    var apiUrl = '"""),_display_(/*29.20*/config/*29.26*/.baseUrl),format.raw/*29.34*/("""/linking/tasks/"""),_display_(/*29.50*/context/*29.57*/.project.name),format.raw/*29.70*/("""/"""),_display_(/*29.72*/context/*29.79*/.task.id),format.raw/*29.87*/("""/referenceLink';
    var taskUrl = '"""),_display_(/*30.21*/config/*30.27*/.baseUrl),format.raw/*30.35*/("""/linking/tasks/"""),_display_(/*30.51*/context/*30.58*/.project.name),format.raw/*30.71*/("""/"""),_display_(/*30.73*/context/*30.80*/.task.id),format.raw/*30.88*/("""';

    function back() """),format.raw/*32.21*/("""{"""),format.raw/*32.22*/("""
      """),format.raw/*33.7*/("""window.location = """"),_display_(/*33.27*/config/*33.33*/.baseUrl),format.raw/*33.41*/("""/linking/"""),_display_(/*33.51*/context/*33.58*/.project.name),format.raw/*33.71*/("""/"""),_display_(/*33.73*/context/*33.80*/.task.id),format.raw/*33.88*/("""/learnStart"
    """),format.raw/*34.5*/("""}"""),format.raw/*34.6*/("""

    """),format.raw/*36.5*/("""function showLinkCandidate() """),format.raw/*36.34*/("""{"""),format.raw/*36.35*/("""
      """),format.raw/*37.7*/("""// Show pending icon
      $('#link-candidate-wrapper').html('<img src=""""),_display_(/*38.53*/Assets/*38.59*/.at("img/pending.gif")),format.raw/*38.81*/("""" ></img>');
      // Request next link candidate
      var url = '"""),_display_(/*40.19*/routes/*40.25*/.Learning.activeLearnCandidate(context.project.name, context.task.id).url),format.raw/*40.98*/("""';
      $.post(
        url,
        """),format.raw/*43.9*/("""{"""),format.raw/*43.10*/("""
          """),format.raw/*44.11*/("""source: "_",
          target: "_",
          decision: """"),_display_(/*46.23*/LinkCandidateDecision/*46.44*/.pass),format.raw/*46.49*/(""""
        """),format.raw/*47.9*/("""}"""),format.raw/*47.10*/(""",
        function(data) """),format.raw/*48.24*/("""{"""),format.raw/*48.25*/("""
          """),format.raw/*49.11*/("""$('#link-candidate-wrapper').html(data);
        """),format.raw/*50.9*/("""}"""),format.raw/*50.10*/(""")
        .fail(errorHandler)
    """),format.raw/*52.5*/("""}"""),format.raw/*52.6*/("""

    """),format.raw/*54.5*/("""$(function() """),format.raw/*54.18*/("""{"""),format.raw/*54.19*/("""
      """),format.raw/*55.7*/("""showLinkCandidate();
    """),format.raw/*56.5*/("""}"""),format.raw/*56.6*/(""");
  </script>
""")))};def /*60.2*/toolbar/*60.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*60.13*/("""
  """),format.raw/*61.3*/("""<ul>
    <li>
      """),_display_(/*63.8*/taskActivityControl(context.task.activity[ActiveLearning])),format.raw/*63.66*/("""
    """),format.raw/*64.5*/("""</li>
    <li>
      <button class="mdl-button mdl-js-button mdl-button--raised" onclick="back()">Back</button>
    </li>
    <li>
      <button class="mdl-button mdl-js-button mdl-button--raised" onclick="showDialog('"""),_display_(/*69.89*/routes/*69.95*/.Learning.resetActiveLearningDialog(context.project.name, context.task.id)),format.raw/*69.169*/("""')">Reset</button>
    </li>
    <li>
      <button class="mdl-button mdl-js-button mdl-button--raised" onclick="showDialog('"""),_display_(/*72.89*/routes/*72.95*/.Learning.activeLearnDetails(context.project.name, context.task.id)),format.raw/*72.162*/("""')">Details</button>
    </li>
  </ul>
""")))};def /*77.2*/content/*77.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*77.13*/("""
  """),format.raw/*78.3*/("""<div class="mdl-shadow--2dp">
    <div class="wrapper-header">
      <div class="wrapper-title">Linkage Rule Candidate</div>
      <button id="show_graph_button" class="mdl-button mdl-js-button mdl-button--icon toggle_graph_button" style="display: none;">
        <i class="material-icons">expand_more</i>
      </button>
      <div class="mdl-tooltip mdl-tooltip--left" for="show_graph_button">
        Show the current Linking Rule Candidate
      </div>
      <button id="hide_graph_button" class="mdl-button mdl-js-button mdl-button--icon toggle_graph_button" disabled>
        <i class="material-icons">expand_less</i>
      </button>
      <div class="mdl-tooltip mdl-tooltip--left" for="hide_graph_button">
        Hide the current Linking Rule Candidate
      </div>
      <div id="learning_fitness_info">--</div>
    </div>

    <div class="wrapper">
      <div id="rule_view" class="clearfix">
        """),_display_(/*98.10*/autoReload(
          context = context,
          contentPath = Learning.rule(context.project.name, context.task.id).url,
          activityId = ActiveLearningFactory.pluginId
        )),format.raw/*102.10*/("""
      """),format.raw/*103.7*/("""</div>
    </div>
    <script type="text/javascript">
      $("#show_graph_button").click(function() """),format.raw/*106.48*/("""{"""),format.raw/*106.49*/("""
        """),format.raw/*107.9*/("""$(".toggle_graph_button").toggle();
        $("#rule_view").slideDown();
       """),format.raw/*109.8*/("""}"""),format.raw/*109.9*/(""");
      $("#hide_graph_button").click(function() """),format.raw/*110.48*/("""{"""),format.raw/*110.49*/("""
        """),format.raw/*111.9*/("""$(".toggle_graph_button").toggle();
        $("#rule_view").slideUp();
      """),format.raw/*113.7*/("""}"""),format.raw/*113.8*/(""");
    </script>
  </div>

  <div class="mdl-shadow--2dp">
    <div class="wrapper-header">
      <div class="wrapper-title">Uncertain links</div>
    </div>

    <div class="wrapper" style="overflow: auto;">
      <div id="tree-header">
        <div class="middle">
          <ul class="navigation"></ul>
        </div>
      </div>

      <div id="link-candidate-wrapper">
      </div>
    </div>
  </div>
""")))};
Seq[Any](format.raw/*15.1*/("""
"""),format.raw/*58.2*/("""

"""),format.raw/*75.2*/("""

"""),format.raw/*133.2*/("""

"""),_display_(/*135.2*/main(Some(context), titleLabel = context.task.taskLabel())/*135.60*/(header)/*135.68*/(toolbar)/*135.77*/(content)))
      }
    }
  }

  def render(context:Context[LinkSpec],session:play.api.mvc.Session,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(context)(session,request)

  def f:((Context[LinkSpec]) => (play.api.mvc.Session,RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (context) => (session,request) => apply(context)(session,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/learning/activeLearn.scala.html
                  HASH: 0996f1325978b49ae532ef009d63b181e2695f1e
                  MATRIX: 441->1|502->56|548->96|589->131|639->175|694->224|757->281|821->339|872->384|919->424|970->468|1041->532|1446->582|1617->677|1631->683|1712->687|1742->690|1798->719|1813->725|1862->753|1942->806|1957->812|2015->849|2095->902|2110->908|2167->944|2247->997|2262->1003|2320->1040|2386->1079|2405->1089|2478->1141|2556->1192|2575->1202|2634->1240|2712->1291|2727->1297|2774->1323|2852->1374|2867->1380|2914->1406|3059->1524|3074->1530|3103->1538|3146->1554|3162->1561|3196->1574|3225->1576|3241->1583|3270->1591|3334->1628|3349->1634|3378->1642|3421->1658|3437->1665|3471->1678|3500->1680|3516->1687|3545->1695|3597->1719|3626->1720|3660->1727|3707->1747|3722->1753|3751->1761|3788->1771|3804->1778|3838->1791|3867->1793|3883->1800|3912->1808|3956->1825|3984->1826|4017->1832|4074->1861|4103->1862|4137->1869|4237->1942|4252->1948|4295->1970|4390->2038|4405->2044|4499->2117|4564->2155|4593->2156|4632->2167|4717->2225|4747->2246|4773->2251|4810->2261|4839->2262|4892->2287|4921->2288|4960->2299|5036->2348|5065->2349|5126->2383|5154->2384|5187->2390|5228->2403|5257->2404|5291->2411|5343->2436|5371->2437|5410->2456|5425->2463|5506->2467|5536->2470|5583->2491|5662->2549|5694->2554|5940->2773|5955->2779|6051->2853|6204->2979|6219->2985|6308->3052|6371->3095|6386->3102|6467->3106|6497->3109|7437->4022|7645->4208|7680->4215|7810->4316|7840->4317|7877->4326|7985->4406|8014->4407|8093->4457|8123->4458|8160->4467|8265->4544|8294->4545|8742->675|8770->2453|8799->3092|8829->4954|8859->4957|8927->5015|8945->5023|8964->5032
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|25->9|26->10|27->11|28->12|33->14|37->16|37->16|39->16|40->17|40->17|40->17|40->17|41->18|41->18|41->18|42->19|42->19|42->19|43->20|43->20|43->20|45->22|45->22|45->22|46->23|46->23|46->23|47->24|47->24|47->24|48->25|48->25|48->25|52->29|52->29|52->29|52->29|52->29|52->29|52->29|52->29|52->29|53->30|53->30|53->30|53->30|53->30|53->30|53->30|53->30|53->30|55->32|55->32|56->33|56->33|56->33|56->33|56->33|56->33|56->33|56->33|56->33|56->33|57->34|57->34|59->36|59->36|59->36|60->37|61->38|61->38|61->38|63->40|63->40|63->40|66->43|66->43|67->44|69->46|69->46|69->46|70->47|70->47|71->48|71->48|72->49|73->50|73->50|75->52|75->52|77->54|77->54|77->54|78->55|79->56|79->56|81->60|81->60|83->60|84->61|86->63|86->63|87->64|92->69|92->69|92->69|95->72|95->72|95->72|98->77|98->77|100->77|101->78|121->98|125->102|126->103|129->106|129->106|130->107|132->109|132->109|133->110|133->110|134->111|136->113|136->113|157->15|158->58|160->75|162->133|164->135|164->135|164->135|164->135
                  -- GENERATED --
              */
          