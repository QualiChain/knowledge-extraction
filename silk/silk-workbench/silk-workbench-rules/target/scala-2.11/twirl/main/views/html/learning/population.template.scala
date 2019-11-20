
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
/*3.2*/import org.silkframework.rule.LinkSpec
/*4.2*/import org.silkframework.workbench.Context

object population extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Context[LinkSpec],play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(context: Context[LinkSpec])(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*8.2*/header/*8.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.12*/("""
  """),format.raw/*9.3*/("""<link type="text/css" href=""""),_display_(/*9.32*/Assets/*9.38*/.at("stylesheets/table.css")),format.raw/*9.66*/("""" rel="stylesheet" />
  <link rel="stylesheet" href=""""),_display_(/*10.33*/CoreAssets/*10.43*/.at("libs/jquery.treeview/jquery.treeview.css")),format.raw/*10.90*/("""" type="text/css" />
  <link type="text/css" href=""""),_display_(/*11.32*/Assets/*11.38*/.at("stylesheets/linkageRuleTree.css")),format.raw/*11.76*/("""" rel="stylesheet" />

  <script src=""""),_display_(/*13.17*/CoreAssets/*13.27*/.at("libs/twbs-pagination/jquery.twbsPagination.js")),format.raw/*13.79*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*14.17*/CoreAssets/*14.27*/.at("libs/jquery.treeview/jquery.treeview.js")),format.raw/*14.73*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*15.17*/Assets/*15.23*/.at("js/population.js")),format.raw/*15.46*/("""" type="text/javascript"></script>

  <script type="text/javascript">
    initPopulation('populationView');
  </script>
""")))};def /*22.2*/toolbar/*22.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*22.13*/("""
  """),format.raw/*23.3*/("""<ul>
    <li>
      <button onclick="window.location = '"""),_display_(/*25.44*/config/*25.50*/.baseUrl),format.raw/*25.58*/("""/linking/"""),_display_(/*25.68*/context/*25.75*/.project.name),format.raw/*25.88*/("""/"""),_display_(/*25.90*/context/*25.97*/.task.id),format.raw/*25.105*/("""/activeLearn'" >Back</button>
    </li>
  </ul>
""")))};def /*30.2*/content/*30.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*30.13*/("""
  """),format.raw/*31.3*/("""<div class="wrapper">
    <div id="tree-header">
      <div class="left">
        <div class="toggle-all"><div class="plus"></div><a href="#" onclick="expand_all();">Expand All</a></div>
        <div class="toggle-all"><div class="minus"></div><a href="#" onclick="hide_all();">Collapse All</a></div>
      </div>
      <div class="middle">
        <ul class="navigation"></ul>
      </div>
    </div>

    <div style="clear: both"></div>

    <p>
      <div id="populationView">
      </div>
    </p>

    <div style="clear:both;"></div>

    <div id="tree-footer">
      <ul class="navigation"></ul>
    </div>

    <div style="clear: both"></div>

  </div>
""")))};
Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*20.2*/("""

"""),format.raw/*28.2*/("""

"""),format.raw/*58.2*/("""

"""),_display_(/*60.2*/main(Some(context), titleLabel = context.task.taskLabel())/*60.60*/(header)/*60.68*/(toolbar)/*60.77*/(content)))
      }
    }
  }

  def render(context:Context[LinkSpec],session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(context)(session)

  def f:((Context[LinkSpec]) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (context) => (session) => apply(context)(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/learning/population.scala.html
                  HASH: 268bddc83ab2d7e1c94b2dd4a3e512a64585672f
                  MATRIX: 441->1|502->56|548->96|594->136|978->181|1124->252|1137->258|1217->262|1246->265|1301->294|1315->300|1363->328|1444->382|1463->392|1531->439|1610->491|1625->497|1684->535|1750->574|1769->584|1842->636|1920->687|1939->697|2006->743|2084->794|2099->800|2143->823|2287->947|2302->954|2383->958|2413->961|2497->1018|2512->1024|2541->1032|2578->1042|2594->1049|2628->1062|2657->1064|2673->1071|2703->1079|2775->1131|2790->1138|2871->1142|2901->1145|3600->250|3628->944|3657->1128|3686->1806|3715->1809|3782->1867|3799->1875|3817->1884
                  LINES: 17->1|18->2|19->3|20->4|25->6|29->8|29->8|31->8|32->9|32->9|32->9|32->9|33->10|33->10|33->10|34->11|34->11|34->11|36->13|36->13|36->13|37->14|37->14|37->14|38->15|38->15|38->15|43->22|43->22|45->22|46->23|48->25|48->25|48->25|48->25|48->25|48->25|48->25|48->25|48->25|51->30|51->30|53->30|54->31|82->7|83->20|85->28|87->58|89->60|89->60|89->60|89->60
                  -- GENERATED --
              */
          