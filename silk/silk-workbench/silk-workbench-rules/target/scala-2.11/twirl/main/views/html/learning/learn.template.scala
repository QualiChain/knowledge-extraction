
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
/*1.2*/import org.silkframework.learning.LearningActivity
/*2.2*/import controllers.core.routes.{Assets => CoreAssets}
/*3.2*/import controllers.rules.routes.Assets
/*4.2*/import org.silkframework.rule.LinkSpec
/*5.2*/import org.silkframework.workbench.Context
/*6.2*/import views.html.workspace.activity.taskActivityControl
/*7.2*/import views.html.workspace.activity.autoReload
/*8.2*/import controllers.linking.routes.Learning
/*9.2*/import org.silkframework.learning.active.LearningFactory

object learn extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Context[LinkSpec],play.api.mvc.Session,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*11.2*/(context: Context[LinkSpec])(implicit session: play.api.mvc.Session, request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*13.2*/header/*13.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*13.12*/("""
  """),format.raw/*14.3*/("""<link type="text/css" href=""""),_display_(/*14.32*/Assets/*14.38*/.at("stylesheets/table.css")),format.raw/*14.66*/("""" rel="stylesheet" />
  <link type="text/css" href=""""),_display_(/*15.32*/Assets/*15.38*/.at("stylesheets/links.css")),format.raw/*15.66*/("""" rel="stylesheet" />
  <link rel="stylesheet" href=""""),_display_(/*16.33*/CoreAssets/*16.43*/.at("libs/jquery.treeview/jquery.treeview.css")),format.raw/*16.90*/("""" type="text/css" />
  <link type="text/css" href=""""),_display_(/*17.32*/Assets/*17.38*/.at("stylesheets/linkageRuleTree.css")),format.raw/*17.76*/("""" rel="stylesheet" />

  <script src=""""),_display_(/*19.17*/CoreAssets/*19.27*/.at("libs/twbs-pagination/jquery.twbsPagination.js")),format.raw/*19.79*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*20.17*/CoreAssets/*20.27*/.at("libs/jquery.treeview/jquery.treeview.js")),format.raw/*20.73*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*21.17*/Assets/*21.23*/.at("js/links.js")),format.raw/*21.41*/("""" type="text/javascript"></script>

  <script type="text/javascript">
    function back() """),format.raw/*24.21*/("""{"""),format.raw/*24.22*/("""
      """),format.raw/*25.7*/("""//TODO stop current task
      window.location = """"),_display_(/*26.27*/config/*26.33*/.baseUrl),format.raw/*26.41*/("""/linking/"""),_display_(/*26.51*/context/*26.58*/.project.name),format.raw/*26.71*/("""/"""),_display_(/*26.73*/context/*26.80*/.task.id),format.raw/*26.88*/("""/learnStart"
    """),format.raw/*27.5*/("""}"""),format.raw/*27.6*/("""

    """),format.raw/*29.5*/("""function next() """),format.raw/*29.21*/("""{"""),format.raw/*29.22*/("""
      """),format.raw/*30.7*/("""//TODO stop current task
      window.location = """"),_display_(/*31.27*/config/*31.33*/.baseUrl),format.raw/*31.41*/("""/linking/"""),_display_(/*31.51*/context/*31.58*/.project.name),format.raw/*31.71*/("""/"""),_display_(/*31.73*/context/*31.80*/.task.id),format.raw/*31.88*/("""/learn/population"
    """),format.raw/*32.5*/("""}"""),format.raw/*32.6*/("""
  """),format.raw/*33.3*/("""</script>
""")))};def /*36.2*/toolbar/*36.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*36.13*/("""
  """),format.raw/*37.3*/("""<ul>
    <li>
      <button class="mdl-button mdl-js-button mdl-button--raised" onclick="back()">Back</button>
    </li>
    <li>
      <button class="mdl-button mdl-js-button mdl-button--raised" onclick="next()">Next</button>
    </li>
    <li>
      """),_display_(/*45.8*/taskActivityControl(context.task.activity[LearningActivity])),format.raw/*45.68*/("""
    """),format.raw/*46.5*/("""</li>
  </ul>
""")))};def /*50.2*/content/*50.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*50.13*/("""
  """),format.raw/*51.3*/("""<div class="wrapper-header">
    Learned Linkage Rule
  </div>
		
  <div class="wrapper">
    """),_display_(/*56.6*/autoReload(
      context = context,
      contentPath = Learning.rule(context.project.name, context.task.id).url,
      activityId = LearningFactory.pluginId
    )),format.raw/*60.6*/("""
  """),format.raw/*61.3*/("""</div>
""")))};
Seq[Any](format.raw/*12.1*/("""
"""),format.raw/*34.2*/("""

"""),format.raw/*48.2*/("""

"""),format.raw/*62.2*/("""

"""),_display_(/*64.2*/main(Some(context), titleLabel = context.task.taskLabel())/*64.60*/(header)/*64.68*/(toolbar)/*64.77*/(content)))
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
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/learning/learn.scala.html
                  HASH: 02c9b30e9b60c366c2a63088ff350eda87481242
                  MATRIX: 441->1|499->53|560->108|606->148|652->188|702->232|766->290|821->339|871->383|1279->442|1450->537|1464->543|1545->547|1575->550|1631->579|1646->585|1695->613|1775->666|1790->672|1839->700|1920->754|1939->764|2007->811|2086->863|2101->869|2160->907|2226->946|2245->956|2318->1008|2396->1059|2415->1069|2482->1115|2560->1166|2575->1172|2614->1190|2732->1280|2761->1281|2795->1288|2873->1339|2888->1345|2917->1353|2954->1363|2970->1370|3004->1383|3033->1385|3049->1392|3078->1400|3122->1417|3150->1418|3183->1424|3227->1440|3256->1441|3290->1448|3368->1499|3383->1505|3412->1513|3449->1523|3465->1530|3499->1543|3528->1545|3544->1552|3573->1560|3623->1583|3651->1584|3681->1587|3715->1601|3730->1608|3811->1612|3841->1615|4120->1868|4201->1928|4233->1933|4271->1951|4286->1958|4367->1962|4397->1965|4518->2060|4702->2224|4732->2227|4779->535|4807->1598|4836->1948|4865->2235|4894->2238|4961->2296|4978->2304|4996->2313
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|25->9|30->11|34->13|34->13|36->13|37->14|37->14|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|40->17|40->17|40->17|42->19|42->19|42->19|43->20|43->20|43->20|44->21|44->21|44->21|47->24|47->24|48->25|49->26|49->26|49->26|49->26|49->26|49->26|49->26|49->26|49->26|50->27|50->27|52->29|52->29|52->29|53->30|54->31|54->31|54->31|54->31|54->31|54->31|54->31|54->31|54->31|55->32|55->32|56->33|57->36|57->36|59->36|60->37|68->45|68->45|69->46|71->50|71->50|73->50|74->51|79->56|83->60|84->61|86->12|87->34|89->48|91->62|93->64|93->64|93->64|93->64
                  -- GENERATED --
              */
          