
package views.html.widgets

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
/*1.2*/import org.silkframework.workspace.{PrefixRegistry, Project}
/*2.2*/import models.linking.EvalLink._
/*3.2*/import models.linking._
/*4.2*/import org.silkframework.entity.Entity
/*5.2*/import org.silkframework.util.DPair
/*6.2*/import org.silkframework.rule.evaluation._
/*7.2*/import controllers.rules.routes.Assets
/*8.2*/import org.silkframework.entity.paths.UntypedPath
/*9.2*/import org.silkframework.workspace.ProjectTask
/*10.2*/import org.silkframework.rule.execution.LinkingStatistics
/*11.2*/import org.silkframework.rule.LinkSpec

object linksTable extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template11[Project,ProjectTask[LinkSpec],Seq[EvalLink],Option[LinkingStatistics],LinkSorter,String,Int,Boolean,Boolean,Boolean,Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*13.2*/(project: Project,
  task: ProjectTask[LinkSpec],
  links: Seq[EvalLink],
  linkingStatistics: Option[LinkingStatistics],
  sorting: LinkSorter,
  filter: String,
  page: Int,
  showStatus: Boolean, showDetails: Boolean, showEntities: Boolean, rateButtons: Boolean):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*35.2*/render/*35.8*/(pageLinks: Seq[EvalLink]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*35.38*/("""
  """),format.raw/*36.3*/("""<script type="text/javascript">
    $(document).ready(function() """),format.raw/*37.34*/("""{"""),format.raw/*37.35*/("""
      """),format.raw/*38.7*/("""initPagination("""),_display_(/*38.23*/links/*38.28*/.size),format.raw/*38.33*/(""")
    """),format.raw/*39.5*/("""}"""),format.raw/*39.6*/(""")
  </script>

  <div style="clear: both"></div>

  <p>
  <div id="results">
    <div class="link">
      <div class="link-header heading">

        <div class="link-source">
          """),_display_(/*50.12*/sortableHeader(SourceUriSorterAscending, SourceUriSorterDescending)/*50.79*/ {_display_(Seq[Any](format.raw/*50.81*/("""
            """),format.raw/*51.13*/("""Source:
            <span class="source-value">
              """),_display_(/*53.16*/task/*53.20*/.data.dataSelections.source.inputId),format.raw/*53.55*/("""
            """),format.raw/*54.13*/("""</span>
          """)))}),format.raw/*55.12*/("""
        """),format.raw/*56.9*/("""</div>

        <div class="link-target">
          """),_display_(/*59.12*/sortableHeader(TargetUriSorterAscending, TargetUriSorterDescending)/*59.79*/ {_display_(Seq[Any](format.raw/*59.81*/("""
          """),format.raw/*60.11*/("""Target:
              <span class="source-value">
                """),_display_(/*62.18*/task/*62.22*/.data.dataSelections.target.inputId),format.raw/*62.57*/("""
              """),format.raw/*63.15*/("""</span>
          """)))}),format.raw/*64.12*/("""
        """),format.raw/*65.9*/("""</div>

        <div class="link-confidence">
          """),_display_(/*68.12*/sortableHeader(ConfidenceSorterAscending, ConfidenceSorterDescending)/*68.81*/ {_display_(Seq[Any](format.raw/*68.83*/("""
          """),format.raw/*69.11*/("""Score
          """)))}),format.raw/*70.12*/("""
        """),format.raw/*71.9*/("""</div>

        """),_display_(/*73.10*/if(showStatus)/*73.24*/ {_display_(Seq[Any](format.raw/*73.26*/("""
          """),format.raw/*74.11*/("""<div class="link-status">
            <span>Status</span>
          </div>
        """)))}),format.raw/*77.10*/("""

        """),format.raw/*79.9*/("""<div class="link-buttons">
          """),_display_(/*80.12*/sortableHeader(CorrectnessSorterAscending, CorrectnessSorterDescending)/*80.83*/ {_display_(Seq[Any](format.raw/*80.85*/("""
          """),format.raw/*81.11*/("""<span>Correct</span>
          """)))}),format.raw/*82.12*/("""
        """),format.raw/*83.9*/("""</div>

      </div>
    </div>

    """),_display_(/*88.6*/for((link, index) <- pageLinks.zipWithIndex) yield /*88.50*/ {_display_(Seq[Any](format.raw/*88.52*/("""
      """),_display_(/*89.8*/renderLink(link, index)),format.raw/*89.31*/("""
    """)))}),format.raw/*90.6*/("""
  """),format.raw/*91.3*/("""</div>
  </p>

  <div style="clear:both;"></div>

  <div id="tree-footer">
    <ul class="navigation"></ul>
  </div>

  <div style="clear: both"></div>
""")))};def /*103.2*/sortableHeader/*103.16*/(ascendingSorter: LinkSorter, descendingSorter: LinkSorter)(content: Html):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*103.94*/("""
  """),format.raw/*104.3*/("""<a onclick="updateSorting('"""),_display_(/*104.31*/if(sorting == ascendingSorter)/*104.61*/ {_display_(_display_(/*104.64*/descendingSorter/*104.80*/.id))}/*104.85*/else/*104.90*/{_display_(_display_(/*104.92*/ascendingSorter/*104.107*/.id))}),format.raw/*104.111*/("""')">
    """),_display_(/*105.6*/content),format.raw/*105.13*/("""
    """),format.raw/*106.5*/("""<img src=""""),_display_(/*106.16*/sorting/*106.23*/ match/*106.29*/ {/*107.17*/case `ascendingSorter`  =>/*107.43*/ {_display_(_display_(/*107.46*/Assets/*107.52*/.at("img/sort-ascending.png")))}/*108.17*/case `descendingSorter` =>/*108.43*/ {_display_(_display_(/*108.46*/Assets/*108.52*/.at("img/sort-descending.png")))}/*109.17*/case _                  =>/*109.43*/ {_display_(_display_(/*109.46*/Assets/*109.52*/.at("img/sort.png")))}}),format.raw/*110.16*/(""""/>
  </a>
""")))};def /*114.2*/renderLink/*114.12*/(link: EvalLink, counter: Int):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*114.46*/("""
  """),format.raw/*115.3*/("""<div class="link """),_display_(/*115.21*/{link.linkType.name}),format.raw/*115.41*/("""" id=""""),_display_(/*115.48*/id(link)),format.raw/*115.56*/("""">
    <div class=""""),_display_(/*116.18*/if(counter % 2 == 0)/*116.38*/ {_display_(Seq[Any](format.raw/*116.40*/("""link-header grey""")))}/*116.58*/else/*116.63*/{_display_(Seq[Any](format.raw/*116.64*/("""link-header""")))}),format.raw/*116.76*/("""" onmouseover="$(this).addClass('link-over');" onmouseout="$(this).removeClass('link-over');">
      <div id=""""),_display_(/*117.17*/id(link, "toggle")),format.raw/*117.35*/("""">
        <span class="ui-icon ui-icon ui-icon-triangle-1-e"></span>
      </div>
      <div class="link-source">
        <a href=""""),_display_(/*121.19*/link/*121.23*/.source),format.raw/*121.30*/("""" target="_blank">
          """),_display_(/*122.12*/project/*122.19*/.config.prefixes.shorten(link.source)),format.raw/*122.56*/("""
        """),format.raw/*123.9*/("""</a>
      </div>
      <div class="link-target">
        <a href=""""),_display_(/*126.19*/link/*126.23*/.target),format.raw/*126.30*/("""" target="_blank">
          """),_display_(/*127.12*/project/*127.19*/.config.prefixes.shorten(link.target)),format.raw/*127.56*/("""
        """),format.raw/*128.9*/("""</a>
      </div>
      <div class="link-confidence">
        """),_display_(/*131.10*/link/*131.14*/.details.map/*131.26*/ { sim =>_display_(Seq[Any](format.raw/*131.35*/("""
          """),_display_(/*132.12*/renderConfidence(sim.score)),format.raw/*132.39*/("""
        """)))}/*133.10*/.getOrElse/*133.20*/ {_display_(Seq[Any](format.raw/*133.22*/("""
          """),format.raw/*134.11*/("""<div id=""""),_display_(/*134.21*/id(link, "missing")),format.raw/*134.40*/("""" class="confidencebar">Missing</div>
          <div class="mdl-tooltip" for=""""),_display_(/*135.42*/id(link, "missing")),format.raw/*135.61*/("""">
            The cache does not provide all values for the linked entities. Try reloading the cache and this page.
          </div>
        """)))}),format.raw/*138.10*/("""
      """),format.raw/*139.7*/("""</div>

      """),_display_(/*141.8*/if(showStatus)/*141.22*/ {_display_(Seq[Any](format.raw/*141.24*/("""
        """),format.raw/*142.9*/("""<div class="link-status">
          """),_display_(/*143.12*/renderStatus(link.linkType, link.correct)),format.raw/*143.53*/("""
        """),format.raw/*144.9*/("""</div>
      """)))}),format.raw/*145.8*/("""

      """),format.raw/*147.7*/("""<div class="link-buttons">
        """),_display_(/*148.10*/renderButtons(link)),format.raw/*148.29*/("""
      """),format.raw/*149.7*/("""</div>

    </div>

    <div class="link-details" id=""""),_display_(/*153.36*/id(link, "details")),format.raw/*153.55*/("""">
      """),_display_(/*154.8*/if(showDetails)/*154.23*/ {_display_(_display_(/*154.26*/renderDetails(link.details)))}/*154.55*/else/*154.60*/{}),format.raw/*154.62*/("""
      """),_display_(/*155.8*/if(showEntities)/*155.24*/ {_display_(_display_(/*155.27*/renderEntities(link.entities.get)))}/*155.62*/else/*155.67*/{}),format.raw/*155.69*/("""
    """),format.raw/*156.5*/("""</div>
    <div style="clear:both"></div>
  </div>
""")))};def /*161.2*/renderStatus/*161.14*/(linkType: EvalLink.LinkType, correct: EvalLink.Correctness):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*161.78*/("""
  """),_display_(/*162.4*/linkType/*162.12*/ match/*162.18*/ {/*163.5*/case Positive if correct == Correct =>/*163.43*/ {_display_(Seq[Any](format.raw/*163.45*/("""<div>correct</div>""")))}/*164.5*/case Positive if correct == Incorrect =>/*164.45*/ {_display_(Seq[Any](format.raw/*164.47*/("""<div>incorrect</div>""")))}/*165.5*/case Negative if correct == Correct =>/*165.43*/ {_display_(Seq[Any](format.raw/*165.45*/("""<div>correct</div>""")))}/*166.5*/case Negative if correct == Incorrect =>/*166.45*/ {_display_(Seq[Any](format.raw/*166.47*/("""<div>incorrect</div>""")))}/*167.5*/case Generated if correct == Correct =>/*167.44*/ {_display_(Seq[Any](format.raw/*167.46*/("""<div>correct</div>""")))}/*168.5*/case Generated if correct == Incorrect =>/*168.46*/ {_display_(Seq[Any](format.raw/*168.48*/("""<div>wrong</div>""")))}/*169.5*/case _ =>/*169.14*/ {_display_(Seq[Any](format.raw/*169.16*/("""<div>unknown</div>""")))}}),format.raw/*170.4*/("""
""")))};def /*173.2*/renderButtons/*173.15*/(link: EvalLink):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*173.35*/("""
  """),_display_(/*174.4*/widgets/*174.11*/.linkButtons(link, rateButtons)),format.raw/*174.42*/("""
""")))};def /*177.2*/renderEntities/*177.16*/(entities: DPair[Entity]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*177.45*/("""
  """),format.raw/*178.3*/("""<ul class="details-tree">
    """),_display_(/*179.6*/renderEntity(entities.source, "source")),format.raw/*179.45*/("""
    """),_display_(/*180.6*/renderEntity(entities.target, "target")),format.raw/*180.45*/("""
  """),format.raw/*181.3*/("""</ul>
""")))};def /*184.2*/renderEntity/*184.14*/(entity: Entity, divClassPrefix: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*184.58*/("""
  """),format.raw/*185.3*/("""<li>
    <span class=""""),_display_(/*186.19*/{divClassPrefix}),format.raw/*186.35*/("""-value">
      """),_display_(/*187.8*/project/*187.15*/.config.prefixes.shorten(entity.uri)),format.raw/*187.51*/("""
    """),format.raw/*188.5*/("""</span>
    <ul>
      """),_display_(/*190.8*/for(typedPath <- entity.schema.typedPaths;
           path = typedPath.toUntypedPath) yield /*191.43*/ {_display_(Seq[Any](format.raw/*191.45*/("""
        """),_display_(/*192.10*/renderValues(path, entity.evaluate(path), divClassPrefix)),format.raw/*192.67*/("""
      """)))}),format.raw/*193.8*/("""
    """),format.raw/*194.5*/("""</ul>
  </li>
""")))};def /*198.2*/renderValues/*198.14*/(path: UntypedPath, values: Seq[String], divClassPrefix: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*198.82*/("""
  """),format.raw/*199.3*/("""<li>
    """),_display_(/*200.6*/path/*200.10*/.serialize()/*200.22*/(project.config.prefixes)),format.raw/*200.47*/("""
    """),_display_(/*201.6*/values/*201.12*/.take(10).map(v => <span class={divClassPrefix + "-value"}>{project.config.prefixes.shorten(v)}</span>)),format.raw/*201.115*/("""
    """),_display_(/*202.6*/if(values.size > 10)/*202.26*/ {_display_(Seq[Any](format.raw/*202.28*/("""...""")))}/*202.33*/else/*202.38*/{}),format.raw/*202.40*/("""
  """),format.raw/*203.3*/("""</li>
""")))};def /*206.2*/renderDetails/*206.15*/(details: Option[Confidence]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*206.48*/(""" """),_display_(/*206.50*/details/*206.57*/ match/*206.63*/ {/*207.3*/case Some(similarity) =>/*207.27*/ {_display_(Seq[Any](format.raw/*207.29*/("""
    """),format.raw/*208.5*/("""<ul class="details-tree">
      """),_display_(/*209.8*/renderSimilarity(similarity)),format.raw/*209.36*/("""
    """),format.raw/*210.5*/("""</ul>
  """)))}/*212.3*/case None =>/*212.15*/ {_display_(Seq[Any](format.raw/*212.17*/("""No details""")))}})))};def /*215.2*/renderSimilarity/*215.18*/(similarity: Confidence):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*215.46*/(""" """),_display_(/*215.48*/similarity/*215.58*/ match/*215.64*/ {/*216.3*/case AggregatorConfidence(value, aggregation, children) =>/*216.61*/ {_display_(Seq[Any](format.raw/*216.63*/("""
    """),format.raw/*217.5*/("""<li>
      <span class="aggregation">Aggregation:"""),_display_(/*218.46*/aggregation/*218.57*/.aggregator.pluginSpec.id),format.raw/*218.82*/(""" """),format.raw/*218.83*/("""("""),_display_(/*218.85*/aggregation/*218.96*/.id),format.raw/*218.99*/(""")</span>
      """),_display_(/*219.8*/renderConfidence(value)),format.raw/*219.31*/("""
      """),format.raw/*220.7*/("""<ul>
        """),_display_(/*221.10*/children/*221.18*/.map(renderSimilarity)),format.raw/*221.40*/("""
      """),format.raw/*222.7*/("""</ul>
    </li>
  """)))}/*225.3*/case ComparisonConfidence(value, comparison, input1, input2) =>/*225.66*/ {_display_(Seq[Any](format.raw/*225.68*/("""
    """),format.raw/*226.5*/("""<li>
      <span class="comparison">Comparison:"""),_display_(/*227.44*/comparison/*227.54*/.metric.pluginSpec.id),format.raw/*227.75*/(""" """),format.raw/*227.76*/("""("""),_display_(/*227.78*/comparison/*227.88*/.id),format.raw/*227.91*/(""")</span>
      """),_display_(/*228.8*/renderConfidence(value)),format.raw/*228.31*/("""
      """),format.raw/*229.7*/("""<ul>
        """),_display_(/*230.10*/renderValue(input1, "source")),format.raw/*230.39*/("""
        """),_display_(/*231.10*/renderValue(input2, "target")),format.raw/*231.39*/("""
      """),format.raw/*232.7*/("""</ul>
    </li>
  """)))}/*235.3*/case SimpleConfidence(value) =>/*235.34*/ {_display_(Seq[Any](format.raw/*235.36*/("""
    """),format.raw/*236.5*/("""<li>Link Specification is empty</li>
  """)))}})))};def /*240.2*/renderValue/*240.13*/(value: Value, divClassPrefix: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*240.55*/(""" """),_display_(/*240.57*/value/*240.62*/ match/*240.68*/ {/*241.3*/case TransformedValue(transform, values, children, error) =>/*241.63*/ {_display_(Seq[Any](format.raw/*241.65*/("""
    """),format.raw/*242.5*/("""<li>
      <span class="input">
        Transform: """),_display_(/*244.21*/transform/*244.30*/.transformer.pluginSpec.id),format.raw/*244.56*/(""" """),format.raw/*244.57*/("""("""),_display_(/*244.59*/transform/*244.68*/.id),format.raw/*244.71*/(""")
        """),_display_(/*245.10*/values/*245.16*/.map(v => <span class={divClassPrefix + "-value"}>{v}</span>)),format.raw/*245.77*/("""
      """),format.raw/*246.7*/("""</span>
      <ul>
        """),_display_(/*248.10*/children/*248.18*/.map(v => renderValue(v, divClassPrefix))),format.raw/*248.59*/("""
      """),format.raw/*249.7*/("""</ul>
    </li>
  """)))}/*252.3*/case InputValue(input, values, error) =>/*252.43*/ {_display_(Seq[Any](format.raw/*252.45*/("""
    """),format.raw/*253.5*/("""<li>
      <span class="input">
        Input: """),_display_(/*255.17*/input/*255.22*/.path.serialize()/*255.39*/(project.config.prefixes)),format.raw/*255.64*/(""" """),format.raw/*255.65*/("""("""),_display_(/*255.67*/input/*255.72*/.id),format.raw/*255.75*/(""")
        """),_display_(/*256.10*/for(v <- values) yield /*256.26*/ {_display_(Seq[Any](format.raw/*256.28*/("""
          """),format.raw/*257.11*/("""<span class=""""),_display_(/*257.25*/(divClassPrefix)),format.raw/*257.41*/("""-value">"""),_display_(/*257.50*/convertToLinkIfDetected(v)),format.raw/*257.76*/("""</span>
        """)))}),format.raw/*258.10*/("""
      """),format.raw/*259.7*/("""</span>
    </li>
  """)))}})))};def /*264.2*/convertToLinkIfDetected/*264.25*/(valueString: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*264.50*/("""
  """),_display_(/*265.4*/if(valueString.startsWith("http://") || valueString.startsWith("https://"))/*265.79*/ {_display_(Seq[Any](format.raw/*265.81*/("""
    """),format.raw/*266.5*/("""<a target="_blank" href=""""),_display_(/*266.31*/valueString),format.raw/*266.42*/("""">"""),_display_(/*266.45*/valueString),format.raw/*266.56*/("""</a>
  """)))}/*267.5*/else/*267.10*/{_display_(Seq[Any](format.raw/*267.11*/("""
    """),_display_(/*268.6*/valueString),format.raw/*268.17*/("""
  """)))}),format.raw/*269.4*/("""
""")))};def /*272.2*/renderConfidence/*272.18*/(value: Option[Double]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*272.45*/(""" """),_display_(/*272.47*/value/*272.52*/ match/*272.58*/ {/*273.3*/case Some(v) =>/*273.18*/ {_display_(Seq[Any](format.raw/*273.20*/("""
    """),format.raw/*274.5*/("""<div class="confidencebar">
      <div class="confidence">"""),_display_(/*275.32*/{"%.1f".format((v) * 100)}),format.raw/*275.58*/("""%</div>
    </div>
  """)))}/*278.3*/case None =>/*278.15*/ {}})))};def /*22.2*/getPageLinks/*22.14*/() = {{
  val pageSize = 100
  val filteredLinks = LinkFilter(links, filter.stripPrefix("filter:"))
  val sortedLinks = sorting(filteredLinks)
  val pageLinks = sortedLinks.view(page * pageSize, (page + 1) * pageSize)
  pageLinks
}};def /*281.2*/id/*281.4*/(link: EvalLink, prefix: String = "") = {{
  prefix + link.hashCode
}};
Seq[Any](format.raw/*21.1*/("""
"""),format.raw/*28.2*/("""

"""),_display_(/*30.2*/render(getPageLinks())),format.raw/*30.24*/("""
"""),_display_(/*31.2*/for(statistics <- linkingStatistics) yield /*31.38*/ {_display_(Seq[Any](format.raw/*31.40*/("""
  """),_display_(/*32.4*/linkingReport(statistics, links.size)),format.raw/*32.41*/("""
""")))}),format.raw/*33.2*/("""

"""),format.raw/*101.2*/("""

"""),format.raw/*112.2*/("""

"""),format.raw/*159.2*/("""

"""),format.raw/*171.2*/("""

"""),format.raw/*175.2*/("""

"""),format.raw/*182.2*/("""

"""),format.raw/*196.2*/("""

"""),format.raw/*204.2*/("""

"""),format.raw/*213.3*/("""

"""),format.raw/*238.3*/("""

"""),format.raw/*262.3*/("""

"""),format.raw/*270.2*/("""

"""),format.raw/*279.3*/("""

"""),format.raw/*283.2*/("""
"""))
      }
    }
  }

  def render(project:Project,task:ProjectTask[LinkSpec],links:Seq[EvalLink],linkingStatistics:Option[LinkingStatistics],sorting:LinkSorter,filter:String,page:Int,showStatus:Boolean,showDetails:Boolean,showEntities:Boolean,rateButtons:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(project,task,links,linkingStatistics,sorting,filter,page,showStatus,showDetails,showEntities,rateButtons)

  def f:((Project,ProjectTask[LinkSpec],Seq[EvalLink],Option[LinkingStatistics],LinkSorter,String,Int,Boolean,Boolean,Boolean,Boolean) => play.twirl.api.HtmlFormat.Appendable) = (project,task,links,linkingStatistics,sorting,filter,page,showStatus,showDetails,showEntities,rateButtons) => apply(project,task,links,linkingStatistics,sorting,filter,page,showStatus,showDetails,showEntities,rateButtons)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/widgets/linksTable.scala.html
                  HASH: 76a7e2ac4f99f4a6a56accf2df522dc67c5720be
                  MATRIX: 440->1|508->63|548->97|579->122|625->162|668->199|718->243|764->283|821->334|876->382|942->441|1409->482|1753->1104|1767->1110|1874->1140|1904->1143|1997->1208|2026->1209|2060->1216|2103->1232|2117->1237|2143->1242|2176->1248|2204->1249|2417->1435|2493->1502|2533->1504|2574->1517|2664->1580|2677->1584|2733->1619|2774->1632|2824->1651|2860->1660|2940->1713|3016->1780|3056->1782|3095->1793|3189->1860|3202->1864|3258->1899|3301->1914|3351->1933|3387->1942|3471->1999|3549->2068|3589->2070|3628->2081|3676->2098|3712->2107|3756->2124|3779->2138|3819->2140|3858->2151|3973->2235|4010->2245|4075->2283|4155->2354|4195->2356|4234->2367|4297->2399|4333->2408|4397->2446|4457->2490|4497->2492|4531->2500|4575->2523|4611->2529|4641->2532|4818->2688|4842->2702|4998->2780|5029->2783|5085->2811|5125->2841|5157->2844|5183->2860|5199->2865|5213->2870|5244->2872|5270->2887|5299->2891|5336->2901|5365->2908|5398->2913|5437->2924|5454->2931|5470->2937|5482->2956|5518->2982|5550->2985|5566->2991|5608->3038|5644->3064|5676->3067|5692->3073|5735->3121|5771->3147|5803->3150|5819->3156|5864->3192|5900->3207|5920->3217|6032->3251|6063->3254|6109->3272|6151->3292|6186->3299|6216->3307|6264->3327|6294->3347|6335->3349|6372->3367|6386->3372|6426->3373|6470->3385|6609->3496|6649->3514|6810->3647|6824->3651|6853->3658|6911->3688|6928->3695|6987->3732|7024->3741|7120->3809|7134->3813|7163->3820|7221->3850|7238->3857|7297->3894|7334->3903|7425->3966|7439->3970|7461->3982|7509->3991|7549->4003|7598->4030|7628->4040|7648->4050|7689->4052|7729->4063|7767->4073|7808->4092|7915->4171|7956->4190|8131->4333|8166->4340|8208->4355|8232->4369|8273->4371|8310->4380|8375->4417|8438->4458|8475->4467|8520->4481|8556->4489|8620->4525|8661->4544|8696->4551|8779->4606|8820->4625|8857->4635|8882->4650|8914->4653|8954->4682|8968->4687|8992->4689|9027->4697|9053->4713|9085->4716|9131->4751|9145->4756|9169->4758|9202->4763|9278->4818|9300->4830|9442->4894|9473->4898|9491->4906|9507->4912|9518->4919|9566->4957|9607->4959|9645->4983|9695->5023|9736->5025|9776->5051|9824->5089|9865->5091|9903->5115|9953->5155|9994->5157|10034->5183|10083->5222|10124->5224|10162->5248|10213->5289|10254->5291|10290->5313|10309->5322|10350->5324|10401->5347|10427->5352|10450->5365|10548->5385|10579->5389|10596->5396|10649->5427|10675->5432|10699->5446|10806->5475|10837->5478|10895->5509|10956->5548|10989->5554|11050->5593|11081->5596|11112->5606|11134->5618|11256->5662|11287->5665|11338->5688|11376->5704|11419->5720|11436->5727|11494->5763|11527->5768|11578->5792|11680->5877|11721->5879|11759->5889|11838->5946|11877->5954|11910->5959|11949->5977|11971->5989|12117->6057|12148->6060|12185->6070|12199->6074|12221->6086|12268->6111|12301->6117|12317->6123|12443->6226|12476->6232|12506->6252|12547->6254|12571->6259|12585->6264|12609->6266|12640->6269|12671->6279|12694->6292|12805->6325|12835->6327|12852->6334|12868->6340|12879->6345|12913->6369|12954->6371|12987->6376|13047->6409|13097->6437|13130->6442|13158->6454|13180->6466|13221->6468|13261->6485|13287->6501|13393->6529|13423->6531|13443->6541|13459->6547|13470->6552|13538->6610|13579->6612|13612->6617|13690->6667|13711->6678|13758->6703|13788->6704|13818->6706|13839->6717|13864->6720|13907->6736|13952->6759|13987->6766|14029->6780|14047->6788|14091->6810|14126->6817|14164->6839|14237->6902|14278->6904|14311->6909|14387->6957|14407->6967|14450->6988|14480->6989|14510->6991|14530->7001|14555->7004|14598->7020|14643->7043|14678->7050|14720->7064|14771->7093|14809->7103|14860->7132|14895->7139|14933->7161|14974->7192|15015->7194|15048->7199|15117->7245|15138->7256|15258->7298|15288->7300|15303->7305|15319->7311|15330->7316|15400->7376|15441->7378|15474->7383|15554->7435|15573->7444|15621->7470|15651->7471|15681->7473|15700->7482|15725->7485|15764->7496|15780->7502|15863->7563|15898->7570|15954->7598|15972->7606|16035->7647|16070->7654|16108->7676|16158->7716|16199->7718|16232->7723|16308->7771|16323->7776|16350->7793|16397->7818|16427->7819|16457->7821|16472->7826|16497->7829|16536->7840|16569->7856|16610->7858|16650->7869|16692->7883|16730->7899|16767->7908|16815->7934|16864->7951|16899->7958|16949->7985|16982->8008|17085->8033|17116->8037|17201->8112|17242->8114|17275->8119|17329->8145|17362->8156|17393->8159|17426->8170|17453->8179|17467->8184|17507->8185|17540->8191|17573->8202|17608->8206|17634->8211|17660->8227|17765->8254|17795->8256|17810->8261|17826->8267|17837->8272|17862->8287|17903->8289|17936->8294|18023->8353|18071->8379|18112->8404|18134->8416|18155->750|18176->762|18422->8425|18433->8427|18532->748|18560->993|18589->996|18632->1018|18660->1020|18712->1056|18752->1058|18782->1062|18840->1099|18872->1101|18902->2685|18932->3204|18962->4815|18992->5349|19022->5429|19052->5603|19082->5974|19112->6276|19142->6482|19172->7242|19202->7982|19232->8208|19262->8422|19292->8496
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|25->9|26->10|27->11|32->13|43->35|43->35|45->35|46->36|47->37|47->37|48->38|48->38|48->38|48->38|49->39|49->39|60->50|60->50|60->50|61->51|63->53|63->53|63->53|64->54|65->55|66->56|69->59|69->59|69->59|70->60|72->62|72->62|72->62|73->63|74->64|75->65|78->68|78->68|78->68|79->69|80->70|81->71|83->73|83->73|83->73|84->74|87->77|89->79|90->80|90->80|90->80|91->81|92->82|93->83|98->88|98->88|98->88|99->89|99->89|100->90|101->91|111->103|111->103|113->103|114->104|114->104|114->104|114->104|114->104|114->104|114->104|114->104|114->104|114->104|115->105|115->105|116->106|116->106|116->106|116->106|116->107|116->107|116->107|116->107|116->108|116->108|116->108|116->108|116->109|116->109|116->109|116->109|116->110|118->114|118->114|120->114|121->115|121->115|121->115|121->115|121->115|122->116|122->116|122->116|122->116|122->116|122->116|122->116|123->117|123->117|127->121|127->121|127->121|128->122|128->122|128->122|129->123|132->126|132->126|132->126|133->127|133->127|133->127|134->128|137->131|137->131|137->131|137->131|138->132|138->132|139->133|139->133|139->133|140->134|140->134|140->134|141->135|141->135|144->138|145->139|147->141|147->141|147->141|148->142|149->143|149->143|150->144|151->145|153->147|154->148|154->148|155->149|159->153|159->153|160->154|160->154|160->154|160->154|160->154|160->154|161->155|161->155|161->155|161->155|161->155|161->155|162->156|165->161|165->161|167->161|168->162|168->162|168->162|168->163|168->163|168->163|168->164|168->164|168->164|168->165|168->165|168->165|168->166|168->166|168->166|168->167|168->167|168->167|168->168|168->168|168->168|168->169|168->169|168->169|168->170|169->173|169->173|171->173|172->174|172->174|172->174|173->177|173->177|175->177|176->178|177->179|177->179|178->180|178->180|179->181|180->184|180->184|182->184|183->185|184->186|184->186|185->187|185->187|185->187|186->188|188->190|189->191|189->191|190->192|190->192|191->193|192->194|194->198|194->198|196->198|197->199|198->200|198->200|198->200|198->200|199->201|199->201|199->201|200->202|200->202|200->202|200->202|200->202|200->202|201->203|202->206|202->206|204->206|204->206|204->206|204->206|204->207|204->207|204->207|205->208|206->209|206->209|207->210|208->212|208->212|208->212|208->215|208->215|210->215|210->215|210->215|210->215|210->216|210->216|210->216|211->217|212->218|212->218|212->218|212->218|212->218|212->218|212->218|213->219|213->219|214->220|215->221|215->221|215->221|216->222|218->225|218->225|218->225|219->226|220->227|220->227|220->227|220->227|220->227|220->227|220->227|221->228|221->228|222->229|223->230|223->230|224->231|224->231|225->232|227->235|227->235|227->235|228->236|229->240|229->240|231->240|231->240|231->240|231->240|231->241|231->241|231->241|232->242|234->244|234->244|234->244|234->244|234->244|234->244|234->244|235->245|235->245|235->245|236->246|238->248|238->248|238->248|239->249|241->252|241->252|241->252|242->253|244->255|244->255|244->255|244->255|244->255|244->255|244->255|244->255|245->256|245->256|245->256|246->257|246->257|246->257|246->257|246->257|247->258|248->259|250->264|250->264|252->264|253->265|253->265|253->265|254->266|254->266|254->266|254->266|254->266|255->267|255->267|255->267|256->268|256->268|257->269|258->272|258->272|260->272|260->272|260->272|260->272|260->273|260->273|260->273|261->274|262->275|262->275|264->278|264->278|264->22|264->22|270->281|270->281|273->21|274->28|276->30|276->30|277->31|277->31|277->31|278->32|278->32|279->33|281->101|283->112|285->159|287->171|289->175|291->182|293->196|295->204|297->213|299->238|301->262|303->270|305->279|307->283
                  -- GENERATED --
              */
          