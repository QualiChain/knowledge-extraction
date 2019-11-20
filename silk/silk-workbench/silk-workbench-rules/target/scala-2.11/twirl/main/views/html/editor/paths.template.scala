
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
/*1.2*/import org.silkframework.util.DPair
/*2.2*/import org.silkframework.workspace.Project
/*3.2*/import controllers.rules.routes.Assets
/*5.2*/import org.silkframework.runtime.activity.UserContext

object paths extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[DPair[String],DPair[Seq[String]],Boolean,String,String,Project,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(sources: DPair[String], paths: DPair[Seq[String]], onlySource: Boolean, loadingMsg: String = "",
    warning: String = "", project: Project)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*60.2*/pathOperators/*60.15*/(source: String, paths: Seq[String], pathType: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*60.73*/("""

  """),format.raw/*62.55*/("""
  """),_display_(/*63.4*/defining(20)/*63.16*/ { maximumPaths =>_display_(Seq[Any](format.raw/*63.34*/("""

    """),format.raw/*65.5*/("""<div class="palette-block" id=""""),_display_(/*65.37*/{pathType.toLowerCase}),format.raw/*65.59*/("""_container">
      <div class="block-header clearfix">
        <span style='font-weight: bold; color: #582271;' class="path_type">"""),_display_(/*67.77*/pathType),format.raw/*67.85*/(""" """),format.raw/*67.86*/("""Paths:</span>
        <span id='"""),_display_(/*68.20*/{pathType.toLowerCase}),format.raw/*68.42*/("""_id' class="path_id">"""),_display_(/*68.64*/source),format.raw/*68.70*/("""</span>
      </div>

      <div class="scrollboxes">
        <div class="draggable """),_display_(/*72.32*/{pathType.toLowerCase}),format.raw/*72.54*/("""Paths visible">
          <span></span>
          <small></small>
          <p>(custom path)</p>
          """),_display_(/*76.12*/pathExpanded("", pathType)),format.raw/*76.38*/("""
        """),format.raw/*77.9*/("""</div>

        """),_display_(/*79.10*/loadingMsg),format.raw/*79.20*/("""
        """),_display_(/*80.10*/if(!warning.isEmpty)/*80.30*/ {_display_(Seq[Any](format.raw/*80.32*/(""" """),format.raw/*80.33*/("""<img src=""""),_display_(/*80.44*/Assets/*80.50*/.at("img/exclamation.png")),format.raw/*80.76*/("""" style="cursor:help;" title=""""),_display_(/*80.107*/warning),format.raw/*80.114*/(""""/> """)))}),format.raw/*80.119*/("""

        """),_display_(/*82.10*/for((path, index) <- paths.zipWithIndex) yield /*82.50*/ {_display_(Seq[Any](format.raw/*82.52*/("""
          """),format.raw/*83.11*/("""<div
            id="path_"""),_display_(/*84.23*/{pathType.toLowerCase}),format.raw/*84.45*/("""_"""),_display_(/*84.47*/{java.net.URLEncoder.encode(path, "utf-8")}),format.raw/*84.90*/(""""
            title="""),_display_(/*85.20*/path),format.raw/*85.24*/("""
            """),format.raw/*86.13*/("""class="draggable """),_display_(/*86.31*/{pathType.toLowerCase}),format.raw/*86.53*/("""Paths """),_display_(/*86.60*/if(index < maximumPaths)/*86.84*/ {_display_(Seq[Any](format.raw/*86.86*/("""visible""")))}/*86.95*/else/*86.100*/{_display_(Seq[Any](format.raw/*86.101*/("""hidden""")))}),format.raw/*86.108*/(""""
            style="display: none;"
            >
            <p class="non-breaking-label">"""),_display_(/*89.44*/path),format.raw/*89.48*/("""</p>
            """),_display_(/*90.14*/pathExpanded(path, pathType)),format.raw/*90.42*/("""
          """),format.raw/*91.11*/("""</div>
        """)))}),format.raw/*92.10*/("""
        """),_display_(/*93.10*/if(paths.length > maximumPaths)/*93.41*/ {_display_(Seq[Any](format.raw/*93.43*/("""
          """),format.raw/*94.11*/("""<div id=""""),_display_(/*94.21*/{pathType.toLowerCase}),format.raw/*94.43*/("""_show_all" onclick="showAllPaths('#"""),_display_(/*94.79*/{pathType.toLowerCase}),format.raw/*94.101*/("""')">
            Show all """),_display_(/*95.23*/{pathType}),format.raw/*95.33*/(""" """),format.raw/*95.34*/("""Paths
          </div>
        """)))}),format.raw/*97.10*/("""
      """),format.raw/*98.7*/("""</div>
    </div>
  """)))}),format.raw/*100.4*/("""

""")))};def /*104.2*/pathExpanded/*104.14*/(path: String, pathType: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*104.50*/("""
  """),_display_(/*105.4*/pathBox(pathType.toLowerCase + "Path", pathType == "Source", path, 0, 0, false, project)),format.raw/*105.92*/("""
""")))};
Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<script type="text/javascript">

  // Initialization
  $(initPaths);

  function initPaths() """),format.raw/*14.24*/("""{"""),format.raw/*14.25*/("""
    """),format.raw/*15.5*/("""initDraggablePaths($('#source_container'));
    initDraggablePaths($('#target_container'));
  """),format.raw/*17.3*/("""}"""),format.raw/*17.4*/("""

  """),format.raw/*19.3*/("""function showAllPaths(id) """),format.raw/*19.29*/("""{"""),format.raw/*19.30*/("""
    """),format.raw/*20.5*/("""$(id + '_show_all').remove();
    var $element = $(id + '_container');
    var $draggables = $element.find('.draggable.hidden');

    $draggables.each(initDraggablePath);
  """),format.raw/*25.3*/("""}"""),format.raw/*25.4*/("""

  """),format.raw/*27.3*/("""function initDraggablePaths($element) """),format.raw/*27.41*/("""{"""),format.raw/*27.42*/("""
    """),format.raw/*28.5*/("""var $draggables = $element.find('.draggable.visible');

    $draggables.each(initDraggablePath);
  """),format.raw/*31.3*/("""}"""),format.raw/*31.4*/("""

  """),format.raw/*33.3*/("""function initDraggablePath() """),format.raw/*33.32*/("""{"""),format.raw/*33.33*/("""
    """),format.raw/*34.5*/("""var $draggable = $(this);
    $draggable.css('display', '');
    $draggable.removeClass('visible');
    $draggable.removeClass('hidden');
    // TODO: paths currently have no deferred mdl, so we do no not need to activate it here
    // activateDeferredMDL($draggable);
    $draggable.draggable("""),format.raw/*40.26*/("""{"""),format.raw/*40.27*/("""
      """),format.raw/*41.7*/("""helper: function() """),format.raw/*41.26*/("""{"""),format.raw/*41.27*/("""
        """),format.raw/*42.9*/("""var box = $(this).children('.dragDiv');
        box.show();
        return box;
      """),format.raw/*45.7*/("""}"""),format.raw/*45.8*/(""",
      stop: function(event, ui) """),format.raw/*46.33*/("""{"""),format.raw/*46.34*/("""
        """),format.raw/*47.9*/("""ui.helper.hide();
        $.ui.ddmanager.current.cancelHelperRemoval = true;
      """),format.raw/*49.7*/("""}"""),format.raw/*49.8*/("""
    """),format.raw/*50.5*/("""}"""),format.raw/*50.6*/(""");
  """),format.raw/*51.3*/("""}"""),format.raw/*51.4*/("""

"""),format.raw/*53.1*/("""</script>

"""),_display_(/*55.2*/pathOperators(sources.source, paths.source, "Source")),format.raw/*55.55*/("""
"""),_display_(/*56.2*/if(!onlySource)/*56.17*/ {_display_(Seq[Any](format.raw/*56.19*/("""
  """),_display_(/*57.4*/pathOperators(sources.target, paths.target, "Target")),format.raw/*57.57*/("""
""")))}),format.raw/*58.2*/("""

"""),format.raw/*102.2*/("""

"""),format.raw/*106.2*/("""

"""))
      }
    }
  }

  def render(sources:DPair[String],paths:DPair[Seq[String]],onlySource:Boolean,loadingMsg:String,warning:String,project:Project,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(sources,paths,onlySource,loadingMsg,warning,project)(userContext)

  def f:((DPair[String],DPair[Seq[String]],Boolean,String,String,Project) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (sources,paths,onlySource,loadingMsg,warning,project) => (userContext) => apply(sources,paths,onlySource,loadingMsg,warning,project)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/paths.scala.html
                  HASH: d9a176a3d92191653d9720882e7deb3ae0610196
                  MATRIX: 439->1|482->38|532->82|578->123|1004->178|1259->1654|1281->1667|1416->1725|1448->1781|1478->1785|1499->1797|1555->1815|1588->1821|1647->1853|1690->1875|1848->2006|1877->2014|1906->2015|1966->2048|2009->2070|2058->2092|2085->2098|2197->2183|2240->2205|2375->2313|2422->2339|2458->2348|2502->2365|2533->2375|2570->2385|2599->2405|2639->2407|2668->2408|2706->2419|2721->2425|2768->2451|2827->2482|2856->2489|2893->2494|2931->2505|2987->2545|3027->2547|3066->2558|3120->2585|3163->2607|3192->2609|3256->2652|3304->2673|3329->2677|3370->2690|3415->2708|3458->2730|3492->2737|3525->2761|3565->2763|3592->2772|3606->2777|3646->2778|3685->2785|3806->2879|3831->2883|3876->2901|3925->2929|3964->2940|4011->2956|4048->2966|4088->2997|4128->2999|4167->3010|4204->3020|4247->3042|4310->3078|4354->3100|4408->3127|4439->3137|4468->3138|4531->3170|4565->3177|4617->3198|4644->3204|4666->3216|4780->3252|4811->3256|4921->3344|4961->355|4988->356|5109->449|5138->450|5170->455|5291->549|5319->550|5350->554|5404->580|5433->581|5465->586|5665->759|5693->760|5724->764|5790->802|5819->803|5851->808|5977->907|6005->908|6036->912|6093->941|6122->942|6154->947|6477->1242|6506->1243|6540->1250|6587->1269|6616->1270|6652->1279|6765->1365|6793->1366|6855->1400|6884->1401|6920->1410|7030->1493|7058->1494|7090->1499|7118->1500|7150->1505|7178->1506|7207->1508|7245->1520|7319->1573|7347->1575|7371->1590|7411->1592|7441->1596|7515->1649|7547->1651|7577->3201|7607->3346
                  LINES: 17->1|18->2|19->3|20->5|25->6|30->60|30->60|32->60|34->62|35->63|35->63|35->63|37->65|37->65|37->65|39->67|39->67|39->67|40->68|40->68|40->68|40->68|44->72|44->72|48->76|48->76|49->77|51->79|51->79|52->80|52->80|52->80|52->80|52->80|52->80|52->80|52->80|52->80|52->80|54->82|54->82|54->82|55->83|56->84|56->84|56->84|56->84|57->85|57->85|58->86|58->86|58->86|58->86|58->86|58->86|58->86|58->86|58->86|58->86|61->89|61->89|62->90|62->90|63->91|64->92|65->93|65->93|65->93|66->94|66->94|66->94|66->94|66->94|67->95|67->95|67->95|69->97|70->98|72->100|74->104|74->104|76->104|77->105|77->105|79->8|80->9|85->14|85->14|86->15|88->17|88->17|90->19|90->19|90->19|91->20|96->25|96->25|98->27|98->27|98->27|99->28|102->31|102->31|104->33|104->33|104->33|105->34|111->40|111->40|112->41|112->41|112->41|113->42|116->45|116->45|117->46|117->46|118->47|120->49|120->49|121->50|121->50|122->51|122->51|124->53|126->55|126->55|127->56|127->56|127->56|128->57|128->57|129->58|131->102|133->106
                  -- GENERATED --
              */
          