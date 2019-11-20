
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
/*1.2*/import org.silkframework.runtime.plugin.PluginDescription
/*2.2*/import org.silkframework.workspace.Project
/*4.2*/import org.silkframework.runtime.activity.UserContext
/*5.2*/import org.silkframework.runtime.plugin.PluginCategories

object operators extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,String,Map[String, Seq[org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
}]],Project,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(name: String,
  opType: String,
  pluginsByCategory: Map[String, Seq[org.silkframework.runtime.plugin.PluginDescription[_]]],
  project: Project)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*89.2*/operatorIcon/*89.14*/(plugin: PluginDescription[_], category: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*89.66*/("""
  """),format.raw/*90.3*/("""<div id=""""),_display_(/*90.13*/{opType}),format.raw/*90.21*/("""_"""),_display_(/*90.23*/{category}),format.raw/*90.33*/("""_"""),_display_(/*90.35*/plugin/*90.41*/.id),format.raw/*90.44*/("""" class="draggable """),_display_(/*90.64*/name/*90.68*/.toLowerCase),format.raw/*90.80*/("""">
    <span></span>
    <small>"""),_display_(/*92.13*/plugin/*92.19*/.label),format.raw/*92.25*/("""</small>
    <p class="non-breaking-label">"""),_display_(/*93.36*/plugin/*93.42*/.label),format.raw/*93.48*/("""</p>
    """),_display_(/*94.6*/operatorExpanded(plugin)),format.raw/*94.30*/("""
  """),format.raw/*95.3*/("""</div>
  <div class="mdl-defer mdl-tooltip--right" data-mdl-defer="tooltip" for=""""),_display_(/*96.76*/{opType}),format.raw/*96.84*/("""_"""),_display_(/*96.86*/{category}),format.raw/*96.96*/("""_"""),_display_(/*96.98*/plugin/*96.104*/.id),format.raw/*96.107*/("""">
    """),_display_(/*97.6*/plugin/*97.12*/.description),format.raw/*97.24*/("""
  """),format.raw/*98.3*/("""</div>
""")))};def /*101.2*/operatorExpanded/*101.18*/(plugin: PluginDescription[_]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*101.52*/("""
  """),_display_(/*102.4*/opType/*102.10*/ match/*102.16*/ {/*103.5*/case "transform" =>/*103.24*/ {_display_(Seq[Any](format.raw/*103.26*/(""" """),_display_(/*103.28*/transformationBox(plugin.id, plugin, parameterValues(plugin), 0, 0, false, project)),format.raw/*103.111*/(""" """)))}/*104.5*/case "compare" =>/*104.22*/ {_display_(Seq[Any](format.raw/*104.24*/(""" """),_display_(/*104.26*/comparisonBox(plugin.id, false, 1, 0.0, plugin, parameterValues(plugin), 0, 0, false, project)),format.raw/*104.120*/(""" """)))}/*105.5*/case "aggregate" =>/*105.24*/ {_display_(Seq[Any](format.raw/*105.26*/(""" """),_display_(/*105.28*/aggregationBox(plugin.id, false, 1, plugin, parameterValues(plugin), 0, 0, false, project)),format.raw/*105.118*/(""" """)))}}),format.raw/*106.4*/("""
""")))};def /*109.2*/parameterValues/*109.17*/(plugin: PluginDescription[_]) = {{
  for(p <- plugin.parameters) yield p.defaultValue.getOrElse("").toString
}};
Seq[Any](format.raw/*11.1*/("""
"""),format.raw/*12.1*/("""<script type="text/javascript">
// Initialization
$(initOperators);

function initOperators() """),format.raw/*16.26*/("""{"""),format.raw/*16.27*/("""

  """),format.raw/*18.3*/("""var $selectedCategory = null;

  function initDraggableOperators($element)"""),format.raw/*20.44*/("""{"""),format.raw/*20.45*/("""
    """),format.raw/*21.5*/("""var $draggables = $element.find('.draggable');

    $draggables.each(initDraggableOperator);

  """),format.raw/*25.3*/("""}"""),format.raw/*25.4*/("""

  """),format.raw/*27.3*/("""function initDraggableOperator() """),format.raw/*27.36*/("""{"""),format.raw/*27.37*/("""
    """),format.raw/*28.5*/("""var $draggable = $(this);

    $draggable.draggable("""),format.raw/*30.26*/("""{"""),format.raw/*30.27*/("""
      """),format.raw/*31.7*/("""helper: function () """),format.raw/*31.27*/("""{"""),format.raw/*31.28*/("""
        """),format.raw/*32.9*/("""var box = $(this).children('.dragDiv');
        box.show();
        return box;
      """),format.raw/*35.7*/("""}"""),format.raw/*35.8*/(""",
      stop: function (event, ui) """),format.raw/*36.34*/("""{"""),format.raw/*36.35*/("""
        """),format.raw/*37.9*/("""ui.helper.hide();
        $.ui.ddmanager.current.cancelHelperRemoval = true;
      """),format.raw/*39.7*/("""}"""),format.raw/*39.8*/("""
    """),format.raw/*40.5*/("""}"""),format.raw/*40.6*/(""");

  """),format.raw/*42.3*/("""}"""),format.raw/*42.4*/("""

  """),format.raw/*44.3*/("""$("#"""),_display_(/*44.8*/{opType}),format.raw/*44.16*/("""_category_selector").change(function () """),format.raw/*44.56*/("""{"""),format.raw/*44.57*/("""
    """),format.raw/*45.5*/("""// Hide all categories
    if($selectedCategory)"""),format.raw/*46.26*/("""{"""),format.raw/*46.27*/("""
      """),format.raw/*47.7*/("""$selectedCategory.hide();
    """),format.raw/*48.5*/("""}"""),format.raw/*48.6*/("""
    """),format.raw/*49.5*/("""// Show selected Category
    $selectedCategory = $('#"""),_display_(/*50.30*/{opType}),format.raw/*50.38*/("""_category_' + $(this).val()) ;
    $selectedCategory.show();
    activateDeferredMDL($selectedCategory);
    initDraggableOperators($selectedCategory);
  """),format.raw/*54.3*/("""}"""),format.raw/*54.4*/(""");

  $("#"""),_display_(/*56.8*/{opType}),format.raw/*56.16*/("""_category_selector").change();

"""),format.raw/*58.1*/("""}"""),format.raw/*58.2*/("""
"""),format.raw/*59.1*/("""</script>

<div class="palette-block">
  <div class="block-header """),_display_(/*62.29*/{opType}),format.raw/*62.37*/("""Header clearfix">
    <span class="operator-type">"""),_display_(/*63.34*/name),format.raw/*63.38*/("""</span>
    <div class="mdl-selectfield mdl-js-selectfield">
      <select id=""""),_display_(/*65.20*/{opType}),format.raw/*65.28*/("""_category_selector" class="mdl-selectfield__select" name="category" style="font-size:0.9em;">
       """),_display_(/*66.9*/for(category <- pluginsByCategory.keys.toSeq.sorted) yield /*66.61*/ {_display_(Seq[Any](format.raw/*66.63*/("""
          """),format.raw/*67.11*/("""<option value=""""),_display_(/*67.27*/category),format.raw/*67.35*/("""" """),_display_(/*67.38*/if(category == PluginCategories.recommended)/*67.82*/{_display_(Seq[Any](format.raw/*67.83*/(""" """),format.raw/*67.84*/("""selected="selected" """)))}),format.raw/*67.105*/(""" """),format.raw/*67.106*/(""">
            """),_display_(/*68.14*/category),format.raw/*68.22*/("""
          """),format.raw/*69.11*/("""</option>
        """)))}),format.raw/*70.10*/("""
      """),format.raw/*71.7*/("""</select>
    </div>
  </div>

  <div id=""""),_display_(/*75.13*/{opType}),format.raw/*75.21*/("""box" class="scrollboxes" style="height: 67.9px;">
    """),_display_(/*76.6*/for((category, plugins) <- pluginsByCategory) yield /*76.51*/ {_display_(Seq[Any](format.raw/*76.53*/("""
      """),format.raw/*77.7*/("""<div id=""""),_display_(/*77.17*/{opType}),format.raw/*77.25*/("""_category_"""),_display_(/*77.36*/category),format.raw/*77.44*/("""" class=""""),_display_(/*77.54*/{opType}),format.raw/*77.62*/("""_category" style="display: none;">
      """),_display_(/*78.8*/for(plugin <- plugins.sortBy(_.label)) yield /*78.46*/ {_display_(Seq[Any](format.raw/*78.48*/("""
        """),_display_(/*79.10*/operatorIcon(plugin, category)),format.raw/*79.40*/("""
      """)))}),format.raw/*80.8*/("""
      """),format.raw/*81.7*/("""</div>
    """)))}),format.raw/*82.6*/("""
  """),format.raw/*83.3*/("""</div>
</div>

"""),format.raw/*88.4*/("""
"""),format.raw/*99.2*/("""

"""),format.raw/*107.2*/("""

"""))
      }
    }
  }

  def render(name:String,opType:String,pluginsByCategory:Map[String, Seq[org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
}]],project:Project,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(name,opType,pluginsByCategory,project)(userContext)

  def f:((String,String,Map[String, Seq[org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
}]],Project) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (name,opType,pluginsByCategory,project) => (userContext) => apply(name,opType,pluginsByCategory,project)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/operators.scala.html
                  HASH: 3d40b6535fa2c9ce7889d8dc08c32c693246ff0a
                  MATRIX: 439->1|504->60|554->105|615->160|1150->219|1410->2434|1431->2446|1560->2498|1590->2501|1627->2511|1656->2519|1685->2521|1716->2531|1745->2533|1760->2539|1784->2542|1831->2562|1844->2566|1877->2578|1937->2611|1952->2617|1979->2623|2050->2667|2065->2673|2092->2679|2128->2689|2173->2713|2203->2716|2312->2798|2341->2806|2370->2808|2401->2818|2430->2820|2446->2826|2471->2829|2505->2837|2520->2843|2553->2855|2583->2858|2615->2869|2641->2885|2753->2919|2784->2923|2800->2929|2816->2935|2827->2942|2856->2961|2897->2963|2927->2965|3033->3048|3054->3055|3081->3072|3122->3074|3152->3076|3269->3170|3290->3177|3319->3196|3360->3198|3390->3200|3503->3290|3537->3296|3563->3301|3588->3316|3729->401|3757->402|3879->496|3908->497|3939->501|4041->575|4070->576|4102->581|4225->677|4253->678|4284->682|4345->715|4374->716|4406->721|4486->773|4515->774|4549->781|4597->801|4626->802|4662->811|4775->897|4803->898|4866->933|4895->934|4931->943|5041->1026|5069->1027|5101->1032|5129->1033|5162->1039|5190->1040|5221->1044|5252->1049|5281->1057|5349->1097|5378->1098|5410->1103|5486->1151|5515->1152|5549->1159|5606->1189|5634->1190|5666->1195|5748->1250|5777->1258|5958->1412|5986->1413|6023->1424|6052->1432|6111->1464|6139->1465|6167->1466|6261->1533|6290->1541|6368->1592|6393->1596|6500->1676|6529->1684|6657->1786|6725->1838|6765->1840|6804->1851|6847->1867|6876->1875|6906->1878|6959->1922|6998->1923|7027->1924|7080->1945|7110->1946|7152->1961|7181->1969|7220->1980|7270->1999|7304->2006|7374->2049|7403->2057|7484->2112|7545->2157|7585->2159|7619->2166|7656->2176|7685->2184|7723->2195|7752->2203|7789->2213|7818->2221|7886->2263|7940->2301|7980->2303|8017->2313|8068->2343|8106->2351|8140->2358|8182->2370|8212->2373|8254->2432|8282->2866|8312->3298
                  LINES: 17->1|18->2|19->4|20->5|27->7|34->89|34->89|36->89|37->90|37->90|37->90|37->90|37->90|37->90|37->90|37->90|37->90|37->90|37->90|39->92|39->92|39->92|40->93|40->93|40->93|41->94|41->94|42->95|43->96|43->96|43->96|43->96|43->96|43->96|43->96|44->97|44->97|44->97|45->98|46->101|46->101|48->101|49->102|49->102|49->102|49->103|49->103|49->103|49->103|49->103|49->104|49->104|49->104|49->104|49->104|49->105|49->105|49->105|49->105|49->105|49->106|50->109|50->109|53->11|54->12|58->16|58->16|60->18|62->20|62->20|63->21|67->25|67->25|69->27|69->27|69->27|70->28|72->30|72->30|73->31|73->31|73->31|74->32|77->35|77->35|78->36|78->36|79->37|81->39|81->39|82->40|82->40|84->42|84->42|86->44|86->44|86->44|86->44|86->44|87->45|88->46|88->46|89->47|90->48|90->48|91->49|92->50|92->50|96->54|96->54|98->56|98->56|100->58|100->58|101->59|104->62|104->62|105->63|105->63|107->65|107->65|108->66|108->66|108->66|109->67|109->67|109->67|109->67|109->67|109->67|109->67|109->67|109->67|110->68|110->68|111->69|112->70|113->71|117->75|117->75|118->76|118->76|118->76|119->77|119->77|119->77|119->77|119->77|119->77|119->77|120->78|120->78|120->78|121->79|121->79|122->80|123->81|124->82|125->83|128->88|129->99|131->107
                  -- GENERATED --
              */
          