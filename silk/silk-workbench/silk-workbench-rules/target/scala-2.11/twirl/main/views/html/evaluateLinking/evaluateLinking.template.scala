
package views.html.evaluateLinking

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
/*3.2*/import controllers.workspace.routes.WorkspaceApi
/*4.2*/import controllers.workspace.routes.ActivityApi
/*5.2*/import controllers.linking.routes.EvaluateLinkingController
/*6.2*/import org.silkframework.rule.execution.GenerateLinks
/*7.2*/import org.silkframework.rule.LinkSpec
/*8.2*/import org.silkframework.workbench.Context
/*9.2*/import views.html.workspace.activity.taskActivityControl
/*10.2*/import org.silkframework.workspace.activity.linking.EvaluateLinkingActivity
/*11.2*/import org.silkframework.workspace.activity.linking.EvaluateLinkingFactory
/*12.2*/import config.WorkbenchConfig

object evaluateLinking extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Context[LinkSpec],play.api.mvc.Session,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*14.2*/(context: Context[LinkSpec])(implicit session: play.api.mvc.Session, request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*16.2*/header/*16.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*16.12*/("""
  """),format.raw/*17.3*/("""<link type="text/css" href=""""),_display_(/*17.32*/Assets/*17.38*/.at("stylesheets/table.css")),format.raw/*17.66*/("""" rel="stylesheet" />
  <link type="text/css" href=""""),_display_(/*18.32*/Assets/*18.38*/.at("stylesheets/links.css")),format.raw/*18.66*/("""" rel="stylesheet" />
  <link rel="stylesheet" href=""""),_display_(/*19.33*/CoreAssets/*19.43*/.at("libs/jquery.treeview/jquery.treeview.css")),format.raw/*19.90*/("""" type="text/css" />

  <script src=""""),_display_(/*21.17*/CoreAssets/*21.27*/.at("libs/twbs-pagination/jquery.twbsPagination.js")),format.raw/*21.79*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*22.17*/CoreAssets/*22.27*/.at("libs/jquery.treeview/jquery.treeview.js")),format.raw/*22.73*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*23.17*/Assets/*23.23*/.at("js/links.js")),format.raw/*23.41*/("""" type="text/javascript"></script>
  
  <script type="text/javascript">
    var apiUrl = '"""),_display_(/*26.20*/config/*26.26*/.baseUrl),format.raw/*26.34*/("""/linking/tasks/"""),_display_(/*26.50*/context/*26.57*/.project.name),format.raw/*26.70*/("""/"""),_display_(/*26.72*/context/*26.79*/.task.id),format.raw/*26.87*/("""/referenceLink';
    var taskUrl = '"""),_display_(/*27.21*/config/*27.27*/.baseUrl),format.raw/*27.35*/("""/linking/tasks/"""),_display_(/*27.51*/context/*27.58*/.project.name),format.raw/*27.71*/("""/"""),_display_(/*27.73*/context/*27.80*/.task.id),format.raw/*27.88*/("""';

    initLinks('evaluate', 'links');

    $( window ).on("load", function() """),format.raw/*31.39*/("""{"""),format.raw/*31.40*/("""
      """),format.raw/*32.7*/("""connectWebSocket(
        '"""),_display_(/*33.11*/Html(EvaluateLinkingController.linksWebsocket(context.project.name, context.task.id).webSocketURL(WorkbenchConfig().useHttps))),format.raw/*33.137*/("""',
        '"""),_display_(/*34.11*/Html(ActivityApi.getActivityStatusUpdates(context.project.name, context.task.id, EvaluateLinkingFactory.ActivityId).url)),format.raw/*34.131*/("""',
        updateLinks
      )
    """),format.raw/*37.5*/("""}"""),format.raw/*37.6*/(""");
  </script>
""")))};def /*41.2*/toolbar/*41.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*41.13*/("""
  """),format.raw/*42.3*/("""<ul>
    <li>
      """),_display_(/*44.8*/taskActivityControl(context.task.activity[EvaluateLinkingActivity], showButtons = true)),format.raw/*44.95*/("""
    """),format.raw/*45.5*/("""</li>
  </ul>
""")))};def /*49.2*/content/*49.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*49.13*/("""
  """),format.raw/*50.3*/("""<div class="mdl-shadow--2dp">
    <div class="wrapper">

      <div id="tree-header">
        <div class="left">
          <button id="button_expand_all" class="mdl-button mdl-js-button mdl-button--icon" onclick="expand_all();">
            <i class="material-icons">expand_more</i>
          </button>
          <div class="mdl-tooltip" for="button_expand_all">
            Expand all
          </div>
          <button id="button_hide_all" class="mdl-button mdl-js-button mdl-button--icon" onclick="hide_all();">
            <i class="material-icons">expand_less</i>
          </button>
          <div class="mdl-tooltip" for="button_hide_all">
            Collapse all
          </div>
          <!--
                  <div class="toggle-all"><div class="plus"></div><a href="#" onclick="expand_all();">Expand All</a></div>
                  <div class="toggle-all"><div class="minus"></div><a href="#" onclick="hide_all();">Collapse All</a></div>
          -->
        </div>
        <div class="middle">
          <ul class="navigation"></ul>
        </div>
        <div class="right">
          Filter:
          <input onkeyup="updateFilter(this.value)"></input>
        </div>
        <div id="pending"><img src=""""),_display_(/*79.38*/Assets/*79.44*/.at("img/pending.gif")),format.raw/*79.66*/(""""></div>
      </div>

      <div id="links"></div>

    </div>
  </div>
""")))};
Seq[Any](format.raw/*15.1*/("""
"""),format.raw/*39.2*/("""

"""),format.raw/*47.2*/("""

"""),format.raw/*86.2*/("""

"""),_display_(/*88.2*/main(Some(context), titleLabel = context.task.taskLabel())/*88.60*/(header)/*88.68*/(toolbar)/*88.77*/(content)))
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
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/evaluateLinking/evaluateLinking.scala.html
                  HASH: e98f277546aeadbbd94a0baa6266a46f0de1284a
                  MATRIX: 448->1|509->56|555->96|611->146|666->195|733->256|794->311|840->351|890->395|955->453|1039->530|1122->606|1513->638|1684->733|1698->739|1779->743|1809->746|1865->775|1880->781|1929->809|2009->862|2024->868|2073->896|2154->950|2173->960|2241->1007|2306->1045|2325->1055|2398->1107|2476->1158|2495->1168|2562->1214|2640->1265|2655->1271|2694->1289|2812->1380|2827->1386|2856->1394|2899->1410|2915->1417|2949->1430|2978->1432|2994->1439|3023->1447|3087->1484|3102->1490|3131->1498|3174->1514|3190->1521|3224->1534|3253->1536|3269->1543|3298->1551|3405->1630|3434->1631|3468->1638|3523->1666|3671->1792|3711->1805|3853->1925|3915->1960|3943->1961|3982->1980|3997->1987|4078->1991|4108->1994|4155->2015|4263->2102|4295->2107|4333->2125|4348->2132|4429->2136|4459->2139|5708->3361|5723->3367|5766->3389|5879->731|5907->1977|5936->2122|5965->3463|5994->3466|6061->3524|6078->3532|6096->3541
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|25->9|26->10|27->11|28->12|33->14|37->16|37->16|39->16|40->17|40->17|40->17|40->17|41->18|41->18|41->18|42->19|42->19|42->19|44->21|44->21|44->21|45->22|45->22|45->22|46->23|46->23|46->23|49->26|49->26|49->26|49->26|49->26|49->26|49->26|49->26|49->26|50->27|50->27|50->27|50->27|50->27|50->27|50->27|50->27|50->27|54->31|54->31|55->32|56->33|56->33|57->34|57->34|60->37|60->37|62->41|62->41|64->41|65->42|67->44|67->44|68->45|70->49|70->49|72->49|73->50|102->79|102->79|102->79|110->15|111->39|113->47|115->86|117->88|117->88|117->88|117->88
                  -- GENERATED --
              */
          