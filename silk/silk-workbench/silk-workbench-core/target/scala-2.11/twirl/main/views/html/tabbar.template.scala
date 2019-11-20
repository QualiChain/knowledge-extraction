
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
/*1.2*/import org.silkframework.workbench.WorkbenchPlugins
/*2.2*/import org.silkframework.config.TaskSpec
/*4.2*/import org.silkframework.workbench.Context

object tabbar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Option[Context[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: TaskSpec
}],String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(context: Option[Context[_ <: TaskSpec]], selectedTab: String, titleLabel: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*7.2*/pluginTabs/*7.12*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.16*/("""
  """),_display_(/*8.4*/for(cont <- context.toSeq;
       plugin = WorkbenchPlugins.forTask(cont.task);
       tab <- plugin.tabs) yield /*10.27*/ {_display_(Seq[Any](format.raw/*10.29*/("""
    """),format.raw/*11.5*/("""<a id="""),_display_(/*11.12*/{"tab-link-" + tab.title.replaceAll(" ", "-")}),format.raw/*11.58*/(""" """),format.raw/*11.59*/("""href=""""),_display_(/*11.66*/config/*11.72*/.baseUrl),format.raw/*11.80*/("""/"""),_display_(/*11.82*/tab/*11.85*/.path),format.raw/*11.90*/("""" onclick="window.location='"""),_display_(/*11.119*/config/*11.125*/.baseUrl),format.raw/*11.133*/("""/"""),_display_(/*11.135*/tab/*11.138*/.path),format.raw/*11.143*/("""'" class="mdl-tabs__tab """),_display_(/*11.168*/if(cont.path.contains(tab.path))/*11.200*/ {_display_(Seq[Any](format.raw/*11.202*/("""is-active""")))}),format.raw/*11.212*/("""">"""),_display_(/*11.215*/tab/*11.218*/.title),format.raw/*11.224*/("""</a>
  """)))}),format.raw/*12.4*/("""
""")))};
Seq[Any](format.raw/*6.1*/("""
"""),format.raw/*13.2*/("""

"""),format.raw/*15.1*/("""<div id="tab-bar" class="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
  <div class="mdl-tabs__tab-bar">
    <span class="di_tab_task_title">"""),_display_(/*17.38*/titleLabel),format.raw/*17.48*/("""</span>
    <a id="start-screen-link" href=""""),_display_(/*18.38*/config/*18.44*/.baseUrl),format.raw/*18.52*/("""/" onclick="window.location='"""),_display_(/*18.82*/config/*18.88*/.baseUrl),format.raw/*18.96*/("""/'" class="mdl-tabs__tab """),_display_(/*18.122*/if(selectedTab == "start")/*18.148*/ {_display_(Seq[Any](format.raw/*18.150*/("""is-active""")))}),format.raw/*18.160*/("""">Start</a>
    <a id="workspace-link" href=""""),_display_(/*19.35*/config/*19.41*/.baseUrl),format.raw/*19.49*/("""/workspace" onclick="window.location='"""),_display_(/*19.88*/config/*19.94*/.baseUrl),format.raw/*19.102*/("""/workspace'" class="mdl-tabs__tab """),_display_(/*19.137*/if(selectedTab == "workspace")/*19.167*/ {_display_(Seq[Any](format.raw/*19.169*/("""is-active""")))}),format.raw/*19.179*/("""">Workspace</a>
    <a id="allActivities-view-link" href=""""),_display_(/*20.44*/config/*20.50*/.baseUrl),format.raw/*20.58*/("""/workspace/allActivities" onclick="window.location='"""),_display_(/*20.111*/config/*20.117*/.baseUrl),format.raw/*20.125*/("""/workspace/allActivities'" class="mdl-tabs__tab """),_display_(/*20.174*/if(selectedTab == "activities")/*20.205*/ {_display_(Seq[Any](format.raw/*20.207*/("""is-active""")))}),format.raw/*20.217*/("""">Activities</a>
    """),_display_(/*21.6*/pluginTabs),format.raw/*21.16*/("""
  """),format.raw/*22.3*/("""</div>

</div>"""))
      }
    }
  }

  def render(context:Option[Context[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: TaskSpec
}],selectedTab:String,titleLabel:String): play.twirl.api.HtmlFormat.Appendable = apply(context,selectedTab,titleLabel)

  def f:((Option[Context[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: TaskSpec
}],String,String) => play.twirl.api.HtmlFormat.Appendable) = (context,selectedTab,titleLabel) => apply(context,selectedTab,titleLabel)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/tabbar.scala.html
                  HASH: f69e58c78616160d0b3e89bd6f8186ac626735a6
                  MATRIX: 432->1|491->54|539->97|976->141|1136->226|1154->236|1234->240|1263->244|1385->350|1425->352|1457->357|1491->364|1558->410|1587->411|1621->418|1636->424|1665->432|1694->434|1706->437|1732->442|1789->471|1805->477|1835->485|1865->487|1878->490|1905->495|1958->520|2000->552|2041->554|2083->564|2114->567|2127->570|2155->576|2193->584|2233->224|2261->586|2290->588|2457->728|2488->738|2560->783|2575->789|2604->797|2661->827|2676->833|2705->841|2759->867|2795->893|2836->895|2878->905|2951->951|2966->957|2995->965|3061->1004|3076->1010|3106->1018|3169->1053|3209->1083|3250->1085|3292->1095|3378->1154|3393->1160|3422->1168|3503->1221|3519->1227|3549->1235|3626->1284|3667->1315|3708->1317|3750->1327|3798->1349|3829->1359|3859->1362
                  LINES: 17->1|18->2|19->4|26->5|30->7|30->7|32->7|33->8|35->10|35->10|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|36->11|37->12|39->6|40->13|42->15|44->17|44->17|45->18|45->18|45->18|45->18|45->18|45->18|45->18|45->18|45->18|45->18|46->19|46->19|46->19|46->19|46->19|46->19|46->19|46->19|46->19|46->19|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|48->21|48->21|49->22
                  -- GENERATED --
              */
          