
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
/*1.2*/import controllers.core.routes.Assets
/*2.2*/import controllers.core.routes.Branding
/*4.2*/import org.silkframework.runtime.activity.UserContext

object start extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Html,play.api.mvc.Session,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(welcome: Html)(implicit session: play.api.mvc.Session, userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*11.2*/header/*11.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*11.12*/("""
  """),format.raw/*12.3*/("""<link rel="stylesheet" href=""""),_display_(/*12.33*/Assets/*12.39*/.at("start.css")),format.raw/*12.55*/("""" type="text/css" />
""")))};def /*15.2*/toolbar/*15.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*15.13*/("""
""")))};def /*18.2*/content/*18.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*18.13*/("""
  """),format.raw/*19.3*/("""<div id="welcome">
    <img class="logo" src=""""),_display_(/*20.29*/Branding/*20.37*/.logo.url),format.raw/*20.46*/(""""/>
    """),_display_(/*21.6*/welcome),format.raw/*21.13*/("""
  """),format.raw/*22.3*/("""</div>

  <p>
    Your current workspace contains """),_display_(/*25.38*/projects/*25.46*/.size),format.raw/*25.51*/(""" """),format.raw/*25.52*/("""project(s).
  </p>

  <button id="open-workspace-btn" class="mdl-button mdl-js-button mdl-button--raised" onclick="window.location = '"""),_display_(/*28.116*/config/*28.122*/.baseUrl),format.raw/*28.130*/("""/workspace'">Open Workspace</button>
  """),_display_(/*29.4*/if(!projects.exists(_.name == exampleName))/*29.47*/ {_display_(Seq[Any](format.raw/*29.49*/("""
    """),format.raw/*30.5*/("""<button id="start-load-example" class="mdl-button mdl-js-button mdl-button--raised" onclick="loadExample()" style="margin-left: 5px;">Load Example</button>
  """)))}),format.raw/*31.4*/("""

  """),format.raw/*33.3*/("""<script type="text/javascript">
    function loadExample() """),format.raw/*34.28*/("""{"""),format.raw/*34.29*/("""
      """),format.raw/*35.7*/("""$.post('"""),_display_(/*35.16*/config/*35.22*/.baseUrl),format.raw/*35.30*/("""/workspace/"""),_display_(/*35.42*/exampleName),format.raw/*35.53*/("""/importExample')
      .success(function(request) """),format.raw/*36.34*/("""{"""),format.raw/*36.35*/(""" """),format.raw/*36.36*/("""window.location = '"""),_display_(/*36.56*/config/*36.62*/.baseUrl),format.raw/*36.70*/("""/workspace' """),format.raw/*36.82*/("""}"""),format.raw/*36.83*/(""")
      .fail(function(request) """),format.raw/*37.31*/("""{"""),format.raw/*37.32*/(""" """),format.raw/*37.33*/("""alert(request.responseText); """),format.raw/*37.62*/("""}"""),format.raw/*37.63*/(""")
    """),format.raw/*38.5*/("""}"""),format.raw/*38.6*/("""
  """),format.raw/*39.3*/("""</script>
""")))};def /*7.2*/exampleName/*7.13*/ = {{ "movies" }};def /*9.2*/projects/*9.10*/ = {{ org.silkframework.workspace.WorkspaceFactory().workspace.projects }};
Seq[Any](format.raw/*6.1*/("""
"""),format.raw/*7.29*/("""

"""),format.raw/*9.83*/("""

"""),format.raw/*13.2*/("""

"""),format.raw/*16.2*/("""

"""),format.raw/*40.2*/("""

"""),_display_(/*42.2*/main(None, "start")/*42.21*/(header)/*42.29*/(toolbar)/*42.38*/(content)))
      }
    }
  }

  def render(welcome:Html,session:play.api.mvc.Session,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(welcome)(session,userContext)

  def f:((Html) => (play.api.mvc.Session,UserContext) => play.twirl.api.HtmlFormat.Appendable) = (welcome) => (session,userContext) => apply(welcome)(session,userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/start.scala.html
                  HASH: 2ede373985b2fe2b6ed3e018939226e2c41c808e
                  MATRIX: 432->1|477->40|524->82|913->137|1073->335|1087->341|1168->345|1198->348|1255->378|1270->384|1307->400|1352->425|1367->432|1448->436|1473->441|1488->448|1569->452|1599->455|1673->502|1690->510|1720->519|1755->528|1783->535|1813->538|1891->589|1908->597|1934->602|1963->603|2126->738|2142->744|2172->752|2238->792|2290->835|2330->837|2362->842|2551->1001|2582->1005|2669->1064|2698->1065|2732->1072|2768->1081|2783->1087|2812->1095|2851->1107|2883->1118|2961->1168|2990->1169|3019->1170|3066->1190|3081->1196|3110->1204|3150->1216|3179->1217|3239->1249|3268->1250|3297->1251|3354->1280|3383->1281|3416->1287|3444->1288|3474->1291|3507->221|3526->232|3555->251|3571->259|3673->219|3701->248|3730->332|3759->422|3788->438|3817->1302|3846->1305|3874->1324|3891->1332|3909->1341
                  LINES: 17->1|18->2|19->4|24->5|28->11|28->11|30->11|31->12|31->12|31->12|31->12|32->15|32->15|34->15|35->18|35->18|37->18|38->19|39->20|39->20|39->20|40->21|40->21|41->22|44->25|44->25|44->25|44->25|47->28|47->28|47->28|48->29|48->29|48->29|49->30|50->31|52->33|53->34|53->34|54->35|54->35|54->35|54->35|54->35|54->35|55->36|55->36|55->36|55->36|55->36|55->36|55->36|55->36|56->37|56->37|56->37|56->37|56->37|57->38|57->38|58->39|59->7|59->7|59->9|59->9|60->6|61->7|63->9|65->13|67->16|69->40|71->42|71->42|71->42|71->42
                  -- GENERATED --
              */
          