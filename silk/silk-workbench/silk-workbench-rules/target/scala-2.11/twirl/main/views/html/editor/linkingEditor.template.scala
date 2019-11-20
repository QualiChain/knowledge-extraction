
package views.html.editor

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
/*1.2*/import org.silkframework.rule.input.Transformer
/*2.2*/import org.silkframework.rule.similarity.Aggregator
/*3.2*/import org.silkframework.rule.similarity.DistanceMeasure
/*4.2*/import controllers.workspace.routes
/*5.2*/import controllers.rules.routes.Assets
/*6.2*/import controllers.core.routes.{Assets => CoreAssets}
/*7.2*/import org.silkframework.rule.LinkSpec
/*8.2*/import org.silkframework.workbench.Context
/*9.2*/import org.silkframework.runtime.activity.UserContext

object linkingEditor extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Context[LinkSpec],play.api.mvc.Session,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*11.2*/(context: Context[LinkSpec])(implicit session: play.api.mvc.Session, userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*13.2*/header/*13.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*13.12*/("""
  """),format.raw/*14.3*/("""<link type="text/css" href=""""),_display_(/*14.32*/Assets/*14.38*/.at("stylesheets/editor/editor-reset.css")),format.raw/*14.80*/("""" rel="stylesheet" />
  <link type="text/css" href=""""),_display_(/*15.32*/Assets/*15.38*/.at("stylesheets/editor/editor.css")),format.raw/*15.74*/("""" rel="stylesheet" />
  <link type="text/css" href=""""),_display_(/*16.32*/Assets/*16.38*/.at("stylesheets/editor/status.css")),format.raw/*16.74*/("""" rel="stylesheet" />

  <script src=""""),_display_(/*18.17*/CoreAssets/*18.27*/.at("libs/jsplumb/dist/js/jsplumb.js")),format.raw/*18.65*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*19.17*/Assets/*19.23*/.at("js/editor/editor.js")),format.raw/*19.49*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*20.17*/Assets/*20.23*/.at("js/editor/status.js")),format.raw/*20.49*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*21.17*/Assets/*21.23*/.at("js/editor/serializeRule.js")),format.raw/*21.56*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*22.17*/Assets/*22.23*/.at("js/editor/editableLabel.js")),format.raw/*22.56*/("""" type="text/javascript"></script>

  <script type="text/javascript">
    var inEditorEnv = true;
    var projectName = '"""),_display_(/*26.25*/context/*26.32*/.project.name),format.raw/*26.45*/("""';
    var taskName = '"""),_display_(/*27.22*/context/*27.29*/.task.id),format.raw/*27.37*/("""';
    var ruleIndex = '';
    var editorUrl = baseUrl + '/linking/' + projectName + '/' + taskName + '/editor';
    var apiUrl = '"""),_display_(/*30.20*/config/*30.26*/.baseUrl),format.raw/*30.34*/("""/linking/tasks/"""),_display_(/*30.50*/context/*30.57*/.project.name),format.raw/*30.70*/("""/"""),_display_(/*30.72*/context/*30.79*/.task.id),format.raw/*30.87*/("""';
    var serializationFunction = serializeLinkageRule;
  </script>
""")))};def /*35.2*/toolbar/*35.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*35.13*/("""
  """),format.raw/*36.3*/("""<ul>
    <li>
      <button id="undo" class="mdl-button mdl-js-button mdl-button--icon" onclick="undo()">
        <i class="material-icons">undo</i>
      </button>
    </li>
    <li>
      <button id="redo" class="mdl-button mdl-js-button mdl-button--icon" onclick="redo()">
        <i class="material-icons">redo</i>
      </button>
    </li>
    <li>
      <div class="spacer"/>
    </li>
    <li>
      <button id="button_reload_paths" class="mdl-button mdl-js-button mdl-button--icon" onclick="reloadPropertyPaths();">
        <i class="material-icons">cached</i>
      </button>
      <div class="mdl-tooltip mdl-tooltip--large" for="button_reload_paths">
        Reload Property Paths
      </div>
    </li>
    <li>
      <a id="button_get_linkspec" class="mdl-button mdl-js-button mdl-button--icon" href=""""),_display_(/*59.92*/routes/*59.98*/.WorkspaceApi.exportLinkSpec(context.project.name, context.task.id).url),format.raw/*59.169*/("""" target="_blank">
        <i class="material-icons">file_download</i>
      </a>
      <div class="mdl-tooltip mdl-tooltip--large" for="button_get_linkspec">
        Get Link Specification to be executed from the command line
      </div>
    </li>
    <li>
      <a id="button_editor_help" class="mdl-button mdl-js-button mdl-button--icon" href="http://www.assembla.com/spaces/silk/wiki/Linkage_Rule_Editor" target="_help">
        <i class="material-icons">help_outline</i>
      </a>
      <div class="mdl-tooltip mdl-tooltip--large" for="button_editor_help">
        Show linkage rule editor documentation
      </div>
    </li>
    <li>
      <div class="spacer"/>
    </li>
    <li>
      <label>Link Limit:</label>
      <div id="select_link_limit" class="mdl-selectfield mdl-js-selectfield" style="width: 90px;">
        <select id="linklimit" class="mdl-selectfield__select" onchange="modifyLinkSpec()">
          <option value="unlimited">unlimited</option>
          """),_display_(/*82.12*/for(i <- 1 to 10) yield /*82.29*/ {_display_(Seq[Any](format.raw/*82.31*/("""
            """),format.raw/*83.13*/("""<option value=""""),_display_(/*83.29*/i),format.raw/*83.30*/("""" """),_display_(/*83.33*/if(context.task.data.rule.filter.limit == Some(i))/*83.83*/ {_display_(Seq[Any](format.raw/*83.85*/("""selected="selected"""")))}),format.raw/*83.105*/(""">"""),_display_(/*83.107*/i),format.raw/*83.108*/("""</option>
          """)))}),format.raw/*84.12*/("""
        """),format.raw/*85.9*/("""</select>
      </div>
      <div class="mdl-tooltip mdl-tooltip--large" for="select_link_limit">
        Defines the number of links (n) originating from a single data item. Only the n highest-rated links per source data item will remain after the filtering.
      </div>
    </li>
    <li>
      <div class="spacer"/>
    </li>
    <li>
      <label>Link Type:</label>
      <div id="input_link_type" class="mdl-textfield mdl-js-textfield">
        <input id="linktype" class="mdl-textfield__input" type="text" onchange="modifyLinkSpec()" value=""""),_display_(/*97.107*/context/*97.114*/.project.config.prefixes.shorten(context.task.data.rule.linkType.uri)),format.raw/*97.183*/("""" />
      </div>
    </li>
  </ul>

  """),_display_(/*102.4*/status()),format.raw/*102.12*/("""

  """),format.raw/*104.3*/("""<div id="score-widget">"""),format.raw/*104.55*/("""</div>
""")))};def /*107.2*/content/*107.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*107.13*/("""
  """),format.raw/*108.3*/("""<div class="draggables mdl-shadow--2dp">
    <div id="palette-header">
      <div id="operatorSearchField" class="mdl-textfield mdl-js-textfield">
        <input class="mdl-textfield__input" type="text" id="operator_search_term">
        <label class="mdl-textfield__label" for="operator_search_term">Search term...</label>
      </div>
    </div>

    <div id="operators-grouped">
      <div id="paths">
        <div id="loading" style="width:230px;">loading ...</div>
        <script type="text/javascript">
          getPropertyPaths("#paths");
        </script>
      </div>

      <div id="operators">
        """),_display_(/*125.10*/operators("Transformations", "transform", Transformer.pluginsByCategory, context.project)),format.raw/*125.99*/("""
        """),_display_(/*126.10*/operators("Comparators", "compare", DistanceMeasure.pluginsByCategory, context.project)),format.raw/*126.97*/("""
        """),_display_(/*127.10*/operators("Aggregators", "aggregate", Aggregator.pluginsByCategory, context.project)),format.raw/*127.94*/("""
      """),format.raw/*128.7*/("""</div>
    </div>

    <div id="operators-search-result" style="display: none;">
      <div id="no_match_alert" class="alert alert-info">
        <strong>No matching operators</strong>
      </div>
      <div id="operatorList" class="scrollboxes" style="height: 100%;">
        <div id="paths_search">
          loading paths ...
          <script type="text/javascript">
            getPropertyPaths("#paths_search", false);
          </script>
        </div>
        """),_display_(/*142.10*/operatorsAll("Transformations", "transform", Transformer, context.project)),format.raw/*142.84*/("""
        """),_display_(/*143.10*/operatorsAll("Comparators", "compare", DistanceMeasure, context.project)),format.raw/*143.82*/("""
        """),_display_(/*144.10*/operatorsAll("Aggregators", "aggregate", Aggregator, context.project)),format.raw/*144.79*/("""
        """),format.raw/*145.9*/("""<div id="max_results_alert" class="alert alert-info" style="display: none">
          <strong>More than 50 matches, please refine your search.</strong>
        </div>
      </div>
    </div>
  </div>
  <script src=""""),_display_(/*151.17*/CoreAssets/*151.27*/.at("libs/mark.js/dist/jquery.mark.js")),format.raw/*151.66*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*152.17*/Assets/*152.23*/.at("js/editor/operatorSearch.js")),format.raw/*152.57*/("""" type="text/javascript"></script>

  <div class="wrapperEditor">

    <div class="droppable_outer">

      <div id="droppable" class="droppable-canvas mdl-shadow--2dp">
        """),_display_(/*159.10*/context/*159.17*/.task.data.rule.operator/*159.41*/ match/*159.47*/ {/*160.11*/case Some(op) =>/*160.27*/ {_display_(Seq[Any](format.raw/*160.29*/("""
            """),_display_(/*161.14*/renderRule(
              rule = op,
              project = context.project
            )),format.raw/*164.14*/("""
          """)))}/*166.11*/case None =>/*166.23*/ {_display_(Seq[Any](format.raw/*166.25*/("""
            """),format.raw/*167.13*/("""<script type="text/javascript">
              jsPlumb.bind("ready", function() """),format.raw/*168.48*/("""{"""),format.raw/*168.49*/("""
                """),format.raw/*169.17*/("""initEditor();
              """),format.raw/*170.15*/("""}"""),format.raw/*170.16*/(""");
            </script>
          """)))}}),format.raw/*173.10*/("""
      """),format.raw/*174.7*/("""</div>

    </div>

  </div>
""")))};
Seq[Any](format.raw/*12.1*/("""
"""),format.raw/*33.2*/("""

"""),format.raw/*105.2*/("""

"""),format.raw/*179.2*/("""

"""),_display_(/*181.2*/main(Some(context), titleLabel = context.task.taskLabel())/*181.60*/(header)/*181.68*/(toolbar)/*181.77*/(content)))
      }
    }
  }

  def render(context:Context[LinkSpec],session:play.api.mvc.Session,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(context)(session,userContext)

  def f:((Context[LinkSpec]) => (play.api.mvc.Session,UserContext) => play.twirl.api.HtmlFormat.Appendable) = (context) => (session,userContext) => apply(context)(session,userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/linkingEditor.scala.html
                  HASH: 159eb914096287e0b80488b590fde71f5f97b48f
                  MATRIX: 439->1|494->50|553->103|617->161|660->198|706->238|767->293|813->333|863->377|1274->433|1447->530|1461->536|1542->540|1572->543|1628->572|1643->578|1706->620|1786->673|1801->679|1858->715|1938->768|1953->774|2010->810|2076->849|2095->859|2154->897|2232->948|2247->954|2294->980|2372->1031|2387->1037|2434->1063|2512->1114|2527->1120|2581->1153|2659->1204|2674->1210|2728->1243|2877->1365|2893->1372|2927->1385|2978->1409|2994->1416|3023->1424|3182->1556|3197->1562|3226->1570|3269->1586|3285->1593|3319->1606|3348->1608|3364->1615|3393->1623|3486->1696|3501->1703|3582->1707|3612->1710|4454->2525|4469->2531|4562->2602|5569->3582|5602->3599|5642->3601|5683->3614|5726->3630|5748->3631|5778->3634|5837->3684|5877->3686|5929->3706|5959->3708|5982->3709|6034->3730|6070->3739|6647->4288|6664->4295|6755->4364|6822->4404|6852->4412|6884->4416|6936->4468|6968->4479|6984->4486|7066->4490|7097->4493|7741->5109|7852->5198|7890->5208|7999->5295|8037->5305|8143->5389|8178->5396|8676->5866|8772->5940|8810->5950|8904->6022|8942->6032|9033->6101|9070->6110|9314->6326|9334->6336|9395->6375|9474->6426|9490->6432|9546->6466|9753->6645|9770->6652|9804->6676|9820->6682|9832->6695|9858->6711|9899->6713|9941->6727|10053->6817|10085->6840|10107->6852|10148->6854|10190->6867|10298->6946|10328->6947|10374->6964|10431->6992|10461->6993|10530->7039|10565->7046|10634->528|10662->1693|10692->4476|10722->7076|10752->7079|10820->7137|10838->7145|10857->7154
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|25->9|30->11|34->13|34->13|36->13|37->14|37->14|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|41->18|41->18|41->18|42->19|42->19|42->19|43->20|43->20|43->20|44->21|44->21|44->21|45->22|45->22|45->22|49->26|49->26|49->26|50->27|50->27|50->27|53->30|53->30|53->30|53->30|53->30|53->30|53->30|53->30|53->30|56->35|56->35|58->35|59->36|82->59|82->59|82->59|105->82|105->82|105->82|106->83|106->83|106->83|106->83|106->83|106->83|106->83|106->83|106->83|107->84|108->85|120->97|120->97|120->97|125->102|125->102|127->104|127->104|128->107|128->107|130->107|131->108|148->125|148->125|149->126|149->126|150->127|150->127|151->128|165->142|165->142|166->143|166->143|167->144|167->144|168->145|174->151|174->151|174->151|175->152|175->152|175->152|182->159|182->159|182->159|182->159|182->160|182->160|182->160|183->161|186->164|187->166|187->166|187->166|188->167|189->168|189->168|190->169|191->170|191->170|193->173|194->174|200->12|201->33|203->105|205->179|207->181|207->181|207->181|207->181
                  -- GENERATED --
              */
          