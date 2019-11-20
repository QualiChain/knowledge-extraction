
package views.html

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
/*1.2*/import com.typesafe.config.{Config, ConfigObject, ConfigRenderOptions, ConfigValue}
/*2.2*/import controllers.core.routes.Assets
/*4.2*/import scala.collection.JavaConversions._

object configView extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Config,play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(config: Config)(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*8.2*/header/*8.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.12*/("""
  """),format.raw/*9.3*/("""<link rel="stylesheet" href=""""),_display_(/*9.33*/Assets/*9.39*/.at("libs/jstree/dist/themes/default/style.css")),format.raw/*9.87*/("""" type="text/css" />
  <script src=""""),_display_(/*10.17*/Assets/*10.23*/.at("libs/jstree/dist/jstree.js")),format.raw/*10.56*/("""" type="text/javascript"></script>
  <script type="text/javascript" >
    $(function () """),format.raw/*12.19*/("""{"""),format.raw/*12.20*/("""
      """),format.raw/*13.7*/("""$('#configRoot').jstree("""),format.raw/*13.31*/("""{"""),format.raw/*13.32*/("""
        """),format.raw/*14.9*/(""""core" : """),format.raw/*14.18*/("""{"""),format.raw/*14.19*/("""
          """),format.raw/*15.11*/(""""themes": """),format.raw/*15.21*/("""{"""),format.raw/*15.22*/(""""stripes": true"""),format.raw/*15.37*/("""}"""),format.raw/*15.38*/("""
        """),format.raw/*16.9*/("""}"""),format.raw/*16.10*/(""",
        "plugins" : [
          "search", "state", "wholerow"
        ]
      """),format.raw/*20.7*/("""}"""),format.raw/*20.8*/(""");

      var to = false;
      $('#configRootSearch').keyup(function () """),format.raw/*23.48*/("""{"""),format.raw/*23.49*/("""
        """),format.raw/*24.9*/("""if(to) """),format.raw/*24.16*/("""{"""),format.raw/*24.17*/(""" """),format.raw/*24.18*/("""clearTimeout(to); """),format.raw/*24.36*/("""}"""),format.raw/*24.37*/("""
        """),format.raw/*25.9*/("""to = setTimeout(function () """),format.raw/*25.37*/("""{"""),format.raw/*25.38*/("""
          """),format.raw/*26.11*/("""var v = $('#configRootSearch').val();
          $('#configRoot').jstree(true).search(v);
        """),format.raw/*28.9*/("""}"""),format.raw/*28.10*/(""", 250);
      """),format.raw/*29.7*/("""}"""),format.raw/*29.8*/(""");
    """),format.raw/*30.5*/("""}"""),format.raw/*30.6*/(""");
  </script>
""")))};def /*34.2*/toolbar/*34.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*34.13*/("""
""")))};def /*37.2*/content/*37.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*37.13*/("""
  """),format.raw/*38.3*/("""<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="configRootSearch">
    <label class="mdl-textfield__label" for="configRootSearch">Search</label>
  </div>

  <div id="configRoot">
    """),_display_(/*44.6*/render(config.root())),format.raw/*44.27*/("""
  """),format.raw/*45.3*/("""</div>
""")))};def /*48.2*/render/*48.8*/(obj: ConfigObject):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*48.31*/("""
  """),format.raw/*49.3*/("""<ul>
  """),_display_(/*50.4*/for(entry <- obj.entrySet().toSeq.sortBy(_.getKey)) yield /*50.55*/ {_display_(Seq[Any](format.raw/*50.57*/("""
    """),format.raw/*51.5*/("""<li>
      """),_display_(/*52.8*/entry/*52.13*/.getKey),format.raw/*52.20*/("""
      """),_display_(/*53.8*/entry/*53.13*/.getValue/*53.22*/ match/*53.28*/ {/*54.9*/case childObj: ConfigObject =>/*54.39*/ {_display_(Seq[Any](format.raw/*54.41*/("""
          """),_display_(/*55.12*/render(childObj)),format.raw/*55.28*/("""
        """)))}/*57.9*/case value =>/*57.22*/ {_display_(Seq[Any](format.raw/*57.24*/("""
          """),_display_(/*58.12*/renderValue(value)),format.raw/*58.30*/("""
        """)))}}),format.raw/*60.8*/("""
    """),format.raw/*61.5*/("""</li>
  """)))}),format.raw/*62.4*/("""
  """),format.raw/*63.3*/("""</ul>
""")))};def /*66.2*/renderValue/*66.13*/(value: ConfigValue):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*66.37*/("""
  """),format.raw/*67.3*/("""<ul>
    <li data-jstree='"""),format.raw/*68.22*/("""{"""),format.raw/*68.23*/(""""disabled":true"""),format.raw/*68.38*/("""}"""),format.raw/*68.39*/("""' >Value: """),_display_(/*68.50*/value/*68.55*/.render(ConfigRenderOptions.defaults())),format.raw/*68.94*/("""</li>
    <li data-jstree='"""),format.raw/*69.22*/("""{"""),format.raw/*69.23*/(""""disabled":true"""),format.raw/*69.38*/("""}"""),format.raw/*69.39*/("""' >Comments: """),_display_(/*69.53*/value/*69.58*/.origin().comments().mkString(", ")),format.raw/*69.93*/("""</li>
    <li data-jstree='"""),format.raw/*70.22*/("""{"""),format.raw/*70.23*/(""""disabled":true"""),format.raw/*70.38*/("""}"""),format.raw/*70.39*/("""' >Origin: """),_display_(/*70.51*/value/*70.56*/.origin().description()),format.raw/*70.79*/("""</li>
  </ul>
""")))};
Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*32.2*/("""

"""),format.raw/*35.2*/("""

"""),format.raw/*46.2*/("""

"""),format.raw/*64.2*/("""

"""),format.raw/*72.2*/("""

"""),_display_(/*74.2*/main(None, "config")/*74.22*/(header)/*74.30*/(toolbar)/*74.39*/(content)),format.raw/*74.48*/("""

"""))
      }
    }
  }

  def render(config:Config,session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(config)(session)

  def f:((Config) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (config) => (session) => apply(config)(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/configView.scala.html
                  HASH: 33053f5e8280803362967e107f9ce90b70c84255
                  MATRIX: 432->1|523->86|568->126|940->170|1074->229|1087->235|1167->239|1196->242|1252->272|1266->278|1334->326|1398->363|1413->369|1467->402|1583->490|1612->491|1646->498|1698->522|1727->523|1763->532|1800->541|1829->542|1868->553|1906->563|1935->564|1978->579|2007->580|2043->589|2072->590|2179->670|2207->671|2308->744|2337->745|2373->754|2408->761|2437->762|2466->763|2512->781|2541->782|2577->791|2633->819|2662->820|2701->831|2825->928|2854->929|2895->943|2923->944|2957->951|2985->952|3024->971|3039->978|3120->982|3145->987|3160->994|3241->998|3271->1001|3564->1268|3606->1289|3636->1292|3667->1303|3681->1309|3781->1332|3811->1335|3845->1343|3912->1394|3952->1396|3984->1401|4022->1413|4036->1418|4064->1425|4098->1433|4112->1438|4130->1447|4145->1453|4155->1464|4194->1494|4234->1496|4273->1508|4310->1524|4338->1543|4360->1556|4400->1558|4439->1570|4478->1588|4519->1606|4551->1611|4590->1620|4620->1623|4650->1633|4670->1644|4771->1668|4801->1671|4855->1697|4884->1698|4927->1713|4956->1714|4994->1725|5008->1730|5068->1769|5123->1796|5152->1797|5195->1812|5224->1813|5265->1827|5279->1832|5335->1867|5390->1894|5419->1895|5462->1910|5491->1911|5530->1923|5544->1928|5588->1951|5641->227|5669->968|5698->984|5727->1300|5756->1630|5785->1966|5814->1969|5843->1989|5860->1997|5878->2006|5908->2015
                  LINES: 17->1|18->2|19->4|24->6|28->8|28->8|30->8|31->9|31->9|31->9|31->9|32->10|32->10|32->10|34->12|34->12|35->13|35->13|35->13|36->14|36->14|36->14|37->15|37->15|37->15|37->15|37->15|38->16|38->16|42->20|42->20|45->23|45->23|46->24|46->24|46->24|46->24|46->24|46->24|47->25|47->25|47->25|48->26|50->28|50->28|51->29|51->29|52->30|52->30|54->34|54->34|56->34|57->37|57->37|59->37|60->38|66->44|66->44|67->45|68->48|68->48|70->48|71->49|72->50|72->50|72->50|73->51|74->52|74->52|74->52|75->53|75->53|75->53|75->53|75->54|75->54|75->54|76->55|76->55|77->57|77->57|77->57|78->58|78->58|79->60|80->61|81->62|82->63|83->66|83->66|85->66|86->67|87->68|87->68|87->68|87->68|87->68|87->68|87->68|88->69|88->69|88->69|88->69|88->69|88->69|88->69|89->70|89->70|89->70|89->70|89->70|89->70|89->70|92->7|93->32|95->35|97->46|99->64|101->72|103->74|103->74|103->74|103->74|103->74
                  -- GENERATED --
              */
          