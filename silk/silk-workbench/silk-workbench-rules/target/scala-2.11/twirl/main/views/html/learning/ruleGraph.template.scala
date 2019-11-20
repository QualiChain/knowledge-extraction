
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
/*4.2*/import org.silkframework.rule.LinkSpec
/*5.2*/import org.silkframework.workbench.Context
/*6.2*/import views.html.editor.renderRule
/*7.2*/import play.api.Logger
/*9.2*/import org.silkframework.runtime.activity.UserContext

object ruleGraph extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[org.silkframework.rule.LinkageRule,Context[LinkSpec],UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*10.2*/(rule: org.silkframework.rule.LinkageRule,
  context: Context[LinkSpec])(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*12.1*/("""
"""),_display_(/*13.2*/defining("droppable-" + java.util.UUID.randomUUID.toString())/*13.63*/ { uniqueId =>_display_(Seq[Any](format.raw/*13.77*/("""

"""),format.raw/*15.1*/("""<div class="droppable_outer">

  <div id=""""),_display_(/*17.13*/uniqueId),format.raw/*17.21*/("""" class="droppable-canvas">
      """),_display_(/*18.8*/for(op <- rule.operator) yield /*18.32*/ {_display_(Seq[Any](format.raw/*18.34*/("""
      """),_display_(/*19.8*/renderRule(
      rule = op,
      project = context.project
      )),format.raw/*22.8*/("""
      """)))}),format.raw/*23.8*/("""
  """),format.raw/*24.3*/("""</div>

  <script type="text/javascript">
    'use strict';

    jsPlumb.bind("ready", function() """),format.raw/*29.38*/("""{"""),format.raw/*29.39*/("""


      """),format.raw/*32.7*/("""jsPlumb.setSuspendEvents(true);
      jsPlumb.setSuspendDrawing(true);

      jsPlumb.reset();
      jsPlumb.setContainer(""""),_display_(/*36.30*/uniqueId),format.raw/*36.38*/("""");

      connectOperators();

      $("#"""),_display_(/*40.12*/uniqueId),format.raw/*40.20*/("""").find("input").prop("disabled", true);

      var horizontal_spacing = 60;
      var padding_top = 10;

      var connections = jsPlumb.getAllConnections();
      var graph = connections.reduce(
        function(map, obj) """),format.raw/*47.28*/("""{"""),format.raw/*47.29*/("""
          """),format.raw/*48.11*/("""var parents = map[obj.targetId] || [];
          parents.push(obj.sourceId);
          map[obj.targetId] = parents;
          return map;
        """),format.raw/*52.9*/("""}"""),format.raw/*52.10*/(""",
        """),format.raw/*53.9*/("""{"""),format.raw/*53.10*/("""}"""),format.raw/*53.11*/("""
      """),format.raw/*54.7*/(""");
      var sources = $.unique($.map(graph, function(target, source) """),format.raw/*55.68*/("""{"""),format.raw/*55.69*/("""
        """),format.raw/*56.9*/("""return source;
      """),format.raw/*57.7*/("""}"""),format.raw/*57.8*/("""));
      var targets = $.unique($.map(graph, function(target, source) """),format.raw/*58.68*/("""{"""),format.raw/*58.69*/("""
        """),format.raw/*59.9*/("""return target;
      """),format.raw/*60.7*/("""}"""),format.raw/*60.8*/("""));

      var root_nodes = [];
      $.each(sources, function(index, element) """),format.raw/*63.48*/("""{"""),format.raw/*63.49*/("""
        """),format.raw/*64.9*/("""if ($.inArray(element, targets) === -1) root_nodes.push(element);
      """),format.raw/*65.7*/("""}"""),format.raw/*65.8*/(""");

      var columns = [];
      $.each(root_nodes, function(index, node) """),format.raw/*68.48*/("""{"""),format.raw/*68.49*/("""
        """),format.raw/*69.9*/("""index = 0;
        fillColumns(columns, index, node);
      """),format.raw/*71.7*/("""}"""),format.raw/*71.8*/(""");

      columns = columns.reverse();

      var max_column_height = maxHeight(columns);

      $.each(columns, function(i, column) """),format.raw/*77.43*/("""{"""),format.raw/*77.44*/("""
        """),format.raw/*78.9*/("""var total_height = get_total_height(column);
        var spacing_top = (max_column_height - total_height) / 2 + padding_top;
        $.each(column, function(i, element_id) """),format.raw/*80.48*/("""{"""),format.raw/*80.49*/("""
          """),format.raw/*81.11*/("""var element = $('#' + element_id);
          element.css('top', spacing_top);
          spacing_top = spacing_top + element.height() + horizontal_spacing;
        """),format.raw/*84.9*/("""}"""),format.raw/*84.10*/(""");
      """),format.raw/*85.7*/("""}"""),format.raw/*85.8*/(""");


      make_uneditable();

      jsPlumb.setSuspendDrawing(false, true);
      jsPlumb.setSuspendEvents(false);


      function fillColumns(columns, column_index, element) """),format.raw/*94.60*/("""{"""),format.raw/*94.61*/("""
        """),format.raw/*95.9*/("""if (columns.length <= column_index) """),format.raw/*95.45*/("""{"""),format.raw/*95.46*/("""
          """),format.raw/*96.11*/("""columns.push([]);
        """),format.raw/*97.9*/("""}"""),format.raw/*97.10*/("""
        """),format.raw/*98.9*/("""columns[column_index].push(element);
        if (typeof graph[element] !== 'undefined') """),format.raw/*99.52*/("""{"""),format.raw/*99.53*/("""
          """),format.raw/*100.11*/("""$.each(graph[element], function(i, parent) """),format.raw/*100.54*/("""{"""),format.raw/*100.55*/("""
            """),format.raw/*101.13*/("""fillColumns(columns, column_index + 1, parent);
          """),format.raw/*102.11*/("""}"""),format.raw/*102.12*/(""");
        """),format.raw/*103.9*/("""}"""),format.raw/*103.10*/("""
      """),format.raw/*104.7*/("""}"""),format.raw/*104.8*/("""

      """),format.raw/*106.7*/("""function maxHeight(columns) """),format.raw/*106.35*/("""{"""),format.raw/*106.36*/("""
        """),format.raw/*107.9*/("""var max = 0;
        $.each(columns, function(i, column) """),format.raw/*108.45*/("""{"""),format.raw/*108.46*/("""
          """),format.raw/*109.11*/("""var total_height = get_total_height(column);
          if (total_height > max) max = total_height;
        """),format.raw/*111.9*/("""}"""),format.raw/*111.10*/(""");
        return max;
      """),format.raw/*113.7*/("""}"""),format.raw/*113.8*/("""

      """),format.raw/*115.7*/("""function get_total_height(column) """),format.raw/*115.41*/("""{"""),format.raw/*115.42*/("""
        """),format.raw/*116.9*/("""var spacing_total = (column.length - 1) * horizontal_spacing;
        var heights = get_heights(column);
        var total_heights = array_sum(heights);
        return total_heights + spacing_total;
      """),format.raw/*120.7*/("""}"""),format.raw/*120.8*/("""

      """),format.raw/*122.7*/("""function get_heights(column) """),format.raw/*122.36*/("""{"""),format.raw/*122.37*/("""
        """),format.raw/*123.9*/("""return $.map(column, function(element_id, i) """),format.raw/*123.54*/("""{"""),format.raw/*123.55*/("""
          """),format.raw/*124.11*/("""return $('#' + element_id).height();
        """),format.raw/*125.9*/("""}"""),format.raw/*125.10*/(""");
      """),format.raw/*126.7*/("""}"""),format.raw/*126.8*/("""

      """),format.raw/*128.7*/("""function array_sum(array) """),format.raw/*128.33*/("""{"""),format.raw/*128.34*/("""
        """),format.raw/*129.9*/("""return array.reduce(function(a, b) """),format.raw/*129.44*/("""{"""),format.raw/*129.45*/("""
          """),format.raw/*130.11*/("""return a + b;
        """),format.raw/*131.9*/("""}"""),format.raw/*131.10*/(""");
      """),format.raw/*132.7*/("""}"""),format.raw/*132.8*/("""

      """),format.raw/*134.7*/("""function make_uneditable() """),format.raw/*134.34*/("""{"""),format.raw/*134.35*/("""
        """),format.raw/*135.9*/("""// select all operators
        var operators = $('.dragDiv');

        // no highlighting on hover over operators
        operators.addClass("no-pointer");

        // disable draggable operators
        $.each(operators, function(i, operator) """),format.raw/*142.49*/("""{"""),format.raw/*142.50*/("""
          """),format.raw/*143.11*/("""jsPlumb.setDraggable(operator, false);
        """),format.raw/*144.9*/("""}"""),format.raw/*144.10*/(""");

        // disable delete connection on click
        jsPlumb.unbind("click");

        // disable endpoints
        jsPlumb.selectEndpoints().setEnabled(false);

        // disable highlighting on hover over connections
        jsPlumb.select().setHoverPaintStyle(null);

        // Don't ask the user to confirm when leaving the view
        confirmOnExit = false;
      """),format.raw/*157.7*/("""}"""),format.raw/*157.8*/("""

    """),format.raw/*159.5*/("""}"""),format.raw/*159.6*/(""");
  </script>

</div>
""")))}))
      }
    }
  }

  def render(rule:org.silkframework.rule.LinkageRule,context:Context[LinkSpec],userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(rule,context)(userContext)

  def f:((org.silkframework.rule.LinkageRule,Context[LinkSpec]) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (rule,context) => (userContext) => apply(rule,context)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/learning/ruleGraph.scala.html
                  HASH: 3cd0e8160135c05e8510810e9e109afe258a7033
                  MATRIX: 441->66|487->106|537->150|580->187|610->212|1031->267|1233->375|1261->377|1331->438|1383->452|1412->454|1482->497|1511->505|1572->540|1612->564|1652->566|1686->574|1774->642|1812->650|1842->653|1968->751|1997->752|2033->761|2184->885|2213->893|2283->936|2312->944|2564->1168|2593->1169|2632->1180|2805->1326|2834->1327|2871->1337|2900->1338|2929->1339|2963->1346|3061->1416|3090->1417|3126->1426|3174->1447|3202->1448|3301->1519|3330->1520|3366->1529|3414->1550|3442->1551|3549->1630|3578->1631|3614->1640|3713->1712|3741->1713|3844->1788|3873->1789|3909->1798|3996->1858|4024->1859|4185->1992|4214->1993|4250->2002|4450->2174|4479->2175|4518->2186|4708->2349|4737->2350|4773->2359|4801->2360|5006->2537|5035->2538|5071->2547|5135->2583|5164->2584|5203->2595|5256->2621|5285->2622|5321->2631|5437->2719|5466->2720|5506->2731|5578->2774|5608->2775|5650->2788|5737->2846|5767->2847|5806->2858|5836->2859|5871->2866|5900->2867|5936->2875|5993->2903|6023->2904|6060->2913|6146->2970|6176->2971|6216->2982|6351->3089|6381->3090|6438->3119|6467->3120|6503->3128|6566->3162|6596->3163|6633->3172|6866->3377|6895->3378|6931->3386|6989->3415|7019->3416|7056->3425|7130->3470|7160->3471|7200->3482|7273->3527|7303->3528|7340->3537|7369->3538|7405->3546|7460->3572|7490->3573|7527->3582|7591->3617|7621->3618|7661->3629|7711->3651|7741->3652|7778->3661|7807->3662|7843->3670|7899->3697|7929->3698|7966->3707|8240->3952|8270->3953|8310->3964|8385->4011|8415->4012|8820->4389|8849->4390|8883->4396|8912->4397
                  LINES: 17->4|18->5|19->6|20->7|21->9|26->10|32->12|33->13|33->13|33->13|35->15|37->17|37->17|38->18|38->18|38->18|39->19|42->22|43->23|44->24|49->29|49->29|52->32|56->36|56->36|60->40|60->40|67->47|67->47|68->48|72->52|72->52|73->53|73->53|73->53|74->54|75->55|75->55|76->56|77->57|77->57|78->58|78->58|79->59|80->60|80->60|83->63|83->63|84->64|85->65|85->65|88->68|88->68|89->69|91->71|91->71|97->77|97->77|98->78|100->80|100->80|101->81|104->84|104->84|105->85|105->85|114->94|114->94|115->95|115->95|115->95|116->96|117->97|117->97|118->98|119->99|119->99|120->100|120->100|120->100|121->101|122->102|122->102|123->103|123->103|124->104|124->104|126->106|126->106|126->106|127->107|128->108|128->108|129->109|131->111|131->111|133->113|133->113|135->115|135->115|135->115|136->116|140->120|140->120|142->122|142->122|142->122|143->123|143->123|143->123|144->124|145->125|145->125|146->126|146->126|148->128|148->128|148->128|149->129|149->129|149->129|150->130|151->131|151->131|152->132|152->132|154->134|154->134|154->134|155->135|162->142|162->142|163->143|164->144|164->144|177->157|177->157|179->159|179->159
                  -- GENERATED --
              */
          