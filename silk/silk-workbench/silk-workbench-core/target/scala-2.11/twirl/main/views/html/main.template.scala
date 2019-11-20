
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
/*1.2*/import config.WorkbenchConfig
/*2.2*/import controllers.core.Start
/*3.2*/import org.silkframework.config.TaskSpec
/*4.2*/import org.silkframework.workbench.Context

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[Option[Context[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: TaskSpec
}],String,String,Html,Html,Html,play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(context: Option[Context[_ <: TaskSpec]], selectedTab: String = "", titleLabel: String = "")(header: Html)(toolbar: Html)(content: Html)(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.1*/("""
"""),_display_(/*8.2*/frame(header)/*8.15*/ {_display_(Seq[Any](format.raw/*8.17*/("""
    """),format.raw/*9.5*/("""<dialog id="primary_dialog" class="mdl-dialog__container">
      """),format.raw/*10.51*/("""
    """),format.raw/*11.5*/("""</dialog>
    <dialog id="secondary_dialog" class="mdl-dialog__container">
      """),format.raw/*13.51*/("""
    """),format.raw/*14.5*/("""</dialog>

    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
      <div class="mdl-layout__inner-container">

      """),_display_(/*19.8*/if(config.workbench.showHeader)/*19.39*/ {_display_(Seq[Any](format.raw/*19.41*/("""
      """),format.raw/*20.7*/("""<header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
          <span class="mdl-layout-title">"""),_display_(/*22.43*/config/*22.49*/.workbench.title),format.raw/*22.65*/("""</span>
          <div class="mdl-layout-spacer"></div>
            <button id="app-actions"
                    class="mdl-button mdl-js-button mdl-button--icon">
              <i class="material-icons">more_vert</i>
            </button>
            <script type="text/javascript">
               function app_logout() """),format.raw/*29.38*/("""{"""),format.raw/*29.39*/("""
                  """),format.raw/*30.19*/("""f=document.getElementById('logout_form');
                  if(f) """),format.raw/*31.25*/("""{"""),format.raw/*31.26*/("""
                    """),format.raw/*32.21*/("""f.submit();
                  """),format.raw/*33.19*/("""}"""),format.raw/*33.20*/("""
               """),format.raw/*34.16*/("""}"""),format.raw/*34.17*/("""
            """),format.raw/*35.13*/("""</script>
            <form id="logout_form" action=""""),_display_(/*36.45*/{Start.deployPath + "logout"}),format.raw/*36.74*/("""" method="post">
              <input type="hidden" value="Logout" />
            </form>
            <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
                for="app-actions">
              <li class="mdl-menu__item" onclick="showDialog('"""),_display_(/*41.64*/config/*41.70*/.baseUrl),format.raw/*41.78*/("""/core/aboutDialog');">About</li>
              <li class="mdl-menu__item" onclick="window.location='"""),_display_(/*42.69*/config/*42.75*/.baseUrl),format.raw/*42.83*/("""/core/config'">Configuration</li>
              """),_display_(/*43.16*/if(WorkbenchConfig.get.showLogoutButton && session.get("loggedIn")==Some("true"))/*43.97*/ {_display_(Seq[Any](format.raw/*43.99*/("""
                """),format.raw/*44.17*/("""<li class="mdl-menu__item" onclick="app_logout();">Logout</li>
              """)))}),format.raw/*45.16*/("""
            """),format.raw/*46.13*/("""</ul>
        </div>
      </header>
      """)))}),format.raw/*49.8*/("""
      """),_display_(/*50.8*/tabbar(context, selectedTab, titleLabel)),format.raw/*50.48*/("""
      """),_display_(/*51.8*/if(toolbar != null)/*51.27*/ {_display_(Seq[Any](format.raw/*51.29*/("""
        """),format.raw/*52.9*/("""<div id="toolbar" class="clearfix">
        """),_display_(/*53.10*/toolbar),format.raw/*53.17*/("""
        """),format.raw/*54.9*/("""</div>
      """)))}),format.raw/*55.8*/("""
      """),format.raw/*56.7*/("""<main class="mdl-layout__content">
        <div id="content" class="mdl-tabs__panel is-active">
          """),_display_(/*58.12*/content),format.raw/*58.19*/("""
        """),format.raw/*59.9*/("""</div>
        <div id="dialogContainer">
          <div class="dialog">
          </div>
        </div>
      </main>
    </div>
    </div>
""")))}))
      }
    }
  }

  def render(context:Option[Context[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: TaskSpec
}],selectedTab:String,titleLabel:String,header:Html,toolbar:Html,content:Html,session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(context,selectedTab,titleLabel)(header)(toolbar)(content)(session)

  def f:((Option[Context[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: TaskSpec
}],String,String) => (Html) => (Html) => (Html) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (context,selectedTab,titleLabel) => (header) => (toolbar) => (content) => (session) => apply(context,selectedTab,titleLabel)(header)(toolbar)(content)(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/main.scala.html
                  HASH: 041e4a1ada415bbfeb213ab37db59b36db3267ed
                  MATRIX: 432->1|469->32|506->63|554->105|1025->150|1295->327|1322->329|1343->342|1382->344|1413->349|1506->458|1538->463|1647->588|1679->593|1840->728|1880->759|1920->761|1954->768|2104->891|2119->897|2156->913|2505->1234|2534->1235|2581->1254|2675->1320|2704->1321|2753->1342|2811->1372|2840->1373|2884->1389|2913->1390|2954->1403|3035->1457|3085->1486|3389->1763|3404->1769|3433->1777|3561->1878|3576->1884|3605->1892|3681->1941|3771->2022|3811->2024|3856->2041|3965->2119|4006->2132|4080->2176|4114->2184|4175->2224|4209->2232|4237->2251|4277->2253|4313->2262|4385->2307|4413->2314|4449->2323|4493->2337|4527->2344|4661->2451|4689->2458|4725->2467
                  LINES: 17->1|18->2|19->3|20->4|27->6|32->7|33->8|33->8|33->8|34->9|35->10|36->11|38->13|39->14|44->19|44->19|44->19|45->20|47->22|47->22|47->22|54->29|54->29|55->30|56->31|56->31|57->32|58->33|58->33|59->34|59->34|60->35|61->36|61->36|66->41|66->41|66->41|67->42|67->42|67->42|68->43|68->43|68->43|69->44|70->45|71->46|74->49|75->50|75->50|76->51|76->51|76->51|77->52|78->53|78->53|79->54|80->55|81->56|83->58|83->58|84->59
                  -- GENERATED --
              */
          