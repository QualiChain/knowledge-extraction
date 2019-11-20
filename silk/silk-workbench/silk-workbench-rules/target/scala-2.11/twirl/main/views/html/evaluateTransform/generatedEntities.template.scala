
package views.html.evaluateTransform

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
/*1.2*/import org.silkframework.config.Prefixes
/*2.2*/import org.silkframework.rule.evaluation.{DetailedEntity, Value, TransformedValue, InputValue}
/*3.2*/import org.silkframework.entity.UntypedValueType
/*4.2*/import controllers.core.routes.{Assets => CoreAssets}
/*5.2*/import controllers.rules.routes.Assets
/*6.2*/import java.util.UUID

object generatedEntities extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Seq[org.silkframework.rule.evaluation.DetailedEntity],Prefixes,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*8.2*/(entities: Seq[org.silkframework.rule.evaluation.DetailedEntity], prefixes: Prefixes):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*38.2*/renderHeader/*38.14*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*38.18*/("""
  """),format.raw/*39.3*/("""<div class="entity">
    <div class="entity-table-header">
      Transformed Entities
    </div>
  </div>
""")))};def /*46.2*/renderEntity/*46.14*/(entity: DetailedEntity, counter: Int):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*46.56*/("""
  """),format.raw/*47.3*/("""<div class="entity">
    <div class=""""),_display_(/*48.18*/if(counter % 2==0)/*48.36*/ {_display_(Seq[Any](format.raw/*48.38*/("""entity-header grey""")))}/*48.58*/else/*48.63*/{_display_(Seq[Any](format.raw/*48.64*/("""entity-header white""")))}),format.raw/*48.84*/("""" onclick="$(this).next().slideToggle()" >
      """),_display_(/*49.8*/renderUris(entity.uris)),format.raw/*49.31*/("""
    """),format.raw/*50.5*/("""</div>
    <div class="entity-details" style="display: none">
      <ul class="entity-tree">
        """),_display_(/*53.10*/for((value, rule) <- entity.values zip entity.rules) yield /*53.62*/ {_display_(Seq[Any](format.raw/*53.64*/("""
          """),format.raw/*54.11*/("""<li>
            <span class="property">
              """),_display_(/*56.16*/for(target <- rule.target) yield /*56.42*/ {_display_(Seq[Any](format.raw/*56.44*/("""
                """),_display_(/*57.18*/target/*57.24*/.propertyUri.serialize(prefixes)),format.raw/*57.56*/("""
                """),_display_(/*58.18*/if(target.valueType != UntypedValueType)/*58.58*/ {_display_(Seq[Any](format.raw/*58.60*/("""
                  """),format.raw/*59.19*/("""("""),_display_(/*59.21*/target/*59.27*/.valueType.label),format.raw/*59.43*/(""")
                """)))}),format.raw/*60.18*/("""
              """)))}),format.raw/*61.16*/("""
            """),format.raw/*62.13*/("""</span>
            <ul>
              """),_display_(/*64.16*/renderValue(value)),format.raw/*64.34*/("""
            """),format.raw/*65.13*/("""</ul>
          </li>
        """)))}),format.raw/*67.10*/("""
      """),format.raw/*68.7*/("""</ul>
    </div>
  </div>
""")))};def /*73.2*/renderUris/*73.12*/(uris: Seq[String]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*73.35*/("""
  """),_display_(/*74.4*/if(uris.isEmpty)/*74.20*/ {_display_(Seq[Any](format.raw/*74.22*/("""
    """),_display_(/*75.6*/renderError("The URI pattern did not generate any URI for this entity.")),format.raw/*75.78*/("""
  """)))}/*76.5*/else/*76.10*/{_display_(Seq[Any](format.raw/*76.11*/("""
    """),_display_(/*77.6*/uris/*77.10*/.map(uri => prefixes.shorten(uri)).mkString(", ")),format.raw/*77.59*/("""
  """)))}),format.raw/*78.4*/("""
""")))};def /*81.2*/renderValue/*81.13*/(value: Value):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*81.31*/(""" """),_display_(/*81.33*/value/*81.38*/ match/*81.44*/ {/*82.3*/case TransformedValue(transform, values, children, error) =>/*82.63*/ {_display_(Seq[Any](format.raw/*82.65*/("""
    """),format.raw/*83.5*/("""<li>
      <span class="input">
    Transform:"""),_display_(/*85.16*/transform/*85.25*/.transformer.pluginSpec.id),format.raw/*85.51*/(""" """),format.raw/*85.52*/("""("""),_display_(/*85.54*/transform/*85.63*/.id),format.raw/*85.66*/(""")
        """),_display_(/*86.10*/values/*86.16*/.map(v => <span class="transformed-value">{v}</span>)),format.raw/*86.69*/("""
        """),_display_(/*87.10*/renderException(error)),format.raw/*87.32*/("""
      """),format.raw/*88.7*/("""</span>
      """),_display_(/*89.8*/if(children.size > 0)/*89.29*/ {_display_(Seq[Any](format.raw/*89.31*/("""
        """),format.raw/*90.9*/("""<ul>
        """),_display_(/*91.10*/children/*91.18*/.map(v => renderValue(v))),format.raw/*91.43*/("""
        """),format.raw/*92.9*/("""</ul>
      """)))}),format.raw/*93.8*/("""
    """),format.raw/*94.5*/("""</li>
  """)))}/*96.3*/case InputValue(input, values, error) =>/*96.43*/ {_display_(Seq[Any](format.raw/*96.45*/("""
    """),format.raw/*97.5*/("""<li>
      <span class="input">
    Input: """),_display_(/*99.13*/input/*99.18*/.path.serialize()/*99.35*/(prefixes)),format.raw/*99.45*/(""" """),format.raw/*99.46*/("""("""),_display_(/*99.48*/input/*99.53*/.id),format.raw/*99.56*/(""")
        """),_display_(/*100.10*/values/*100.16*/.map(v => <span class="input-value">{v}</span>)),format.raw/*100.63*/("""
        """),_display_(/*101.10*/renderException(error)),format.raw/*101.32*/("""
      """),format.raw/*102.7*/("""</span>
    </li>
  """)))}})))};def /*107.2*/renderException/*107.17*/(error: Option[Throwable]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*107.47*/("""
  """),_display_(/*108.4*/for(ex <- error) yield /*108.20*/ {_display_(Seq[Any](format.raw/*108.22*/("""
    """),_display_(/*109.6*/renderError(ex.getMessage)),format.raw/*109.32*/("""
  """)))}),format.raw/*110.4*/("""
""")))};def /*113.2*/renderError/*113.13*/(error: String, id: String = UUID.randomUUID.toString):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*113.71*/("""
  """),format.raw/*114.3*/("""<span id="error-"""),_display_(/*114.20*/id),format.raw/*114.22*/("""">
    <img src=""""),_display_(/*115.16*/Assets/*115.22*/.at("img/exclamation.png")),format.raw/*115.48*/("""" style="cursor:help;" />
  </span>
  <div class="mdl-tooltip mdl-tooltip--large" for="error-"""),_display_(/*117.59*/id),format.raw/*117.61*/("""">
    """),_display_(/*118.6*/error),format.raw/*118.11*/("""
  """),format.raw/*119.3*/("""</div>
""")))};
Seq[Any](format.raw/*9.1*/("""
"""),_display_(/*10.2*/frame/*10.7*/ {_display_(Seq[Any](format.raw/*10.9*/("""
  """),format.raw/*11.3*/("""<link rel="stylesheet" href=""""),_display_(/*11.33*/CoreAssets/*11.43*/.at("libs/jquery.treeview/jquery.treeview.css")),format.raw/*11.90*/("""" type="text/css" />
  <link type="text/css" href=""""),_display_(/*12.32*/Assets/*12.38*/.at("stylesheets/evaluateTransform/generatedEntities.css")),format.raw/*12.96*/("""" rel="stylesheet" />
  <script src=""""),_display_(/*13.17*/CoreAssets/*13.27*/.at("libs/jquery.treeview/jquery.treeview.js")),format.raw/*13.73*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*14.17*/Assets/*14.23*/.at("js/evaluateTransform/generatedEntities.js")),format.raw/*14.71*/("""" type="text/javascript"></script>
""")))}/*15.2*/ {_display_(Seq[Any](format.raw/*15.4*/("""
    """),format.raw/*16.5*/("""<div id="tree-header">
      <div class="left">
        <div id="expand-all-btn" class="toggle-all" onclick="expand_all()">
          <div class="plus" ></div>
          Expand All
        </div>
        <div class="toggle-all" onclick="hide_all()">
          <div class="minus" ></div>
          Collapse All
        </div>
      </div>
    </div>

    <div id="entity-table">
      """),_display_(/*30.8*/renderHeader),format.raw/*30.20*/("""
      """),_display_(/*31.8*/for((entity, index) <- entities.zipWithIndex) yield /*31.53*/ {_display_(Seq[Any](format.raw/*31.55*/("""
        """),_display_(/*32.10*/renderEntity(entity, index)),format.raw/*32.37*/("""
      """)))}),format.raw/*33.8*/("""
    """),format.raw/*34.5*/("""</div>

""")))}),format.raw/*36.2*/("""

"""),format.raw/*44.2*/("""

"""),format.raw/*71.2*/("""

"""),format.raw/*79.2*/("""

"""),format.raw/*105.3*/("""

"""),format.raw/*111.2*/("""

"""))
      }
    }
  }

  def render(entities:Seq[org.silkframework.rule.evaluation.DetailedEntity],prefixes:Prefixes): play.twirl.api.HtmlFormat.Appendable = apply(entities,prefixes)

  def f:((Seq[org.silkframework.rule.evaluation.DetailedEntity],Prefixes) => play.twirl.api.HtmlFormat.Appendable) = (entities,prefixes) => apply(entities,prefixes)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/evaluateTransform/generatedEntities.scala.html
                  HASH: 3b8c55e5413924f8990723c566417ba6c822ceb0
                  MATRIX: 450->1|498->43|600->139|656->189|717->244|763->284|1157->308|1321->1365|1342->1377|1423->1381|1453->1384|1583->1494|1604->1506|1723->1548|1753->1551|1818->1589|1845->1607|1885->1609|1923->1629|1936->1634|1975->1635|2026->1655|2102->1705|2146->1728|2178->1733|2307->1835|2375->1887|2415->1889|2454->1900|2537->1956|2579->1982|2619->1984|2664->2002|2679->2008|2732->2040|2777->2058|2826->2098|2866->2100|2913->2119|2942->2121|2957->2127|2994->2143|3044->2162|3091->2178|3132->2191|3199->2231|3238->2249|3279->2262|3341->2293|3375->2300|3425->2330|3444->2340|3544->2363|3574->2367|3599->2383|3639->2385|3671->2391|3764->2463|3786->2468|3799->2473|3838->2474|3870->2480|3883->2484|3953->2533|3987->2537|4012->2542|4032->2553|4127->2571|4156->2573|4170->2578|4185->2584|4195->2589|4264->2649|4304->2651|4336->2656|4410->2703|4428->2712|4475->2738|4504->2739|4533->2741|4551->2750|4575->2753|4613->2764|4628->2770|4702->2823|4739->2833|4782->2855|4816->2862|4857->2877|4887->2898|4927->2900|4963->2909|5004->2923|5021->2931|5067->2956|5103->2965|5146->2978|5178->2983|5205->2995|5254->3035|5294->3037|5326->3042|5397->3086|5411->3091|5437->3108|5468->3118|5497->3119|5526->3121|5540->3126|5564->3129|5603->3140|5619->3146|5688->3193|5726->3203|5770->3225|5805->3232|5855->3259|5880->3274|5988->3304|6019->3308|6052->3324|6093->3326|6126->3332|6174->3358|6209->3362|6235->3367|6256->3378|6392->3436|6423->3439|6468->3456|6492->3458|6538->3476|6554->3482|6602->3508|6724->3602|6748->3604|6783->3612|6810->3617|6841->3620|6887->394|6915->396|6928->401|6967->403|6997->406|7054->436|7073->446|7141->493|7220->545|7235->551|7314->609|7379->647|7398->657|7465->703|7543->754|7558->760|7627->808|7681->844|7720->846|7752->851|8163->1236|8196->1248|8230->1256|8291->1301|8331->1303|8368->1313|8416->1340|8454->1348|8486->1353|8525->1362|8554->1491|8583->2327|8612->2539|8642->3256|8672->3364
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|27->8|31->38|31->38|33->38|34->39|39->46|39->46|41->46|42->47|43->48|43->48|43->48|43->48|43->48|43->48|43->48|44->49|44->49|45->50|48->53|48->53|48->53|49->54|51->56|51->56|51->56|52->57|52->57|52->57|53->58|53->58|53->58|54->59|54->59|54->59|54->59|55->60|56->61|57->62|59->64|59->64|60->65|62->67|63->68|66->73|66->73|68->73|69->74|69->74|69->74|70->75|70->75|71->76|71->76|71->76|72->77|72->77|72->77|73->78|74->81|74->81|76->81|76->81|76->81|76->81|76->82|76->82|76->82|77->83|79->85|79->85|79->85|79->85|79->85|79->85|79->85|80->86|80->86|80->86|81->87|81->87|82->88|83->89|83->89|83->89|84->90|85->91|85->91|85->91|86->92|87->93|88->94|89->96|89->96|89->96|90->97|92->99|92->99|92->99|92->99|92->99|92->99|92->99|92->99|93->100|93->100|93->100|94->101|94->101|95->102|97->107|97->107|99->107|100->108|100->108|100->108|101->109|101->109|102->110|103->113|103->113|105->113|106->114|106->114|106->114|107->115|107->115|107->115|109->117|109->117|110->118|110->118|111->119|113->9|114->10|114->10|114->10|115->11|115->11|115->11|115->11|116->12|116->12|116->12|117->13|117->13|117->13|118->14|118->14|118->14|119->15|119->15|120->16|134->30|134->30|135->31|135->31|135->31|136->32|136->32|137->33|138->34|140->36|142->44|144->71|146->79|148->105|150->111
                  -- GENERATED --
              */
          