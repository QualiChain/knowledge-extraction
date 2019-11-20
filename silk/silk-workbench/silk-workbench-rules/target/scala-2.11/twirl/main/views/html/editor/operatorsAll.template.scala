
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

object operatorsAll extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,String,org.silkframework.runtime.plugin.PluginFactory[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Project,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(name: String,
opType: String,
pluginGroup: org.silkframework.runtime.plugin.PluginFactory[_],
project: Project)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*26.2*/operatorExpanded/*26.18*/(plugin: PluginDescription[_]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*26.52*/("""
  """),_display_(/*27.4*/opType/*27.10*/ match/*27.16*/ {/*28.5*/case "transform" =>/*28.24*/ {_display_(Seq[Any](format.raw/*28.26*/(""" """),_display_(/*28.28*/transformationBox(plugin.id, plugin, parameterValues(plugin), 0, 0, false, project)),format.raw/*28.111*/(""" """)))}/*29.5*/case "compare" =>/*29.22*/ {_display_(Seq[Any](format.raw/*29.24*/(""" """),_display_(/*29.26*/comparisonBox(plugin.id, false, 1, 0.0, plugin, parameterValues(plugin), 0, 0, false, project)),format.raw/*29.120*/(""" """)))}/*30.5*/case "aggregate" =>/*30.24*/ {_display_(Seq[Any](format.raw/*30.26*/(""" """),_display_(/*30.28*/aggregationBox(plugin.id, false, 1, plugin, parameterValues(plugin), 0, 0, false, project)),format.raw/*30.118*/(""" """)))}}),format.raw/*31.4*/("""
""")))};def /*34.2*/parameterValues/*34.17*/(plugin: PluginDescription[_]) = {{
  for(p <- plugin.parameters) yield p.defaultValue.getOrElse("").toString
}};
Seq[Any](format.raw/*9.1*/("""
"""),_display_(/*10.2*/for(plugin <- pluginGroup.availablePlugins) yield /*10.45*/ {_display_(Seq[Any](format.raw/*10.47*/("""
  """),format.raw/*11.3*/("""<div id="search_"""),_display_(/*11.20*/{opType}),format.raw/*11.28*/("""_"""),_display_(/*11.30*/{plugin.id}),format.raw/*11.41*/("""" class="operator plugin search-invisible">
    <div class="operator-index">
      """),_display_(/*13.8*/plugin/*13.14*/.label),format.raw/*13.20*/("""
    """),format.raw/*14.5*/("""</div>
    <div id=""""),_display_(/*15.15*/{opType}),format.raw/*15.23*/("""_"""),_display_(/*15.25*/{plugin.categories.head}),format.raw/*15.49*/("""_"""),_display_(/*15.51*/{plugin.id}),format.raw/*15.62*/("""" class="draggable """),_display_(/*15.82*/name/*15.86*/.toLowerCase),format.raw/*15.98*/("""">
      <small>"""),_display_(/*16.15*/plugin/*16.21*/.label),format.raw/*16.27*/("""</small>
      <p class="non-breaking-label">"""),_display_(/*17.38*/plugin/*17.44*/.label),format.raw/*17.50*/("""</p>
      """),_display_(/*18.8*/operatorExpanded(plugin)),format.raw/*18.32*/("""
    """),format.raw/*19.5*/("""</div>
    <div class="mdl-defer mdl-tooltip--right" data-mdl-defer="tooltip" for=""""),_display_(/*20.78*/{opType}),format.raw/*20.86*/("""_"""),_display_(/*20.88*/{plugin.categories.head}),format.raw/*20.112*/("""_"""),_display_(/*20.114*/{plugin.id}),format.raw/*20.125*/("""">
      """),_display_(/*21.8*/plugin/*21.14*/.description),format.raw/*21.26*/("""
    """),format.raw/*22.5*/("""</div>
  </div>
""")))}),format.raw/*24.2*/("""

"""),format.raw/*32.2*/("""

"""))
      }
    }
  }

  def render(name:String,opType:String,pluginGroup:org.silkframework.runtime.plugin.PluginFactory[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},project:Project,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(name,opType,pluginGroup,project)(userContext)

  def f:((String,String,org.silkframework.runtime.plugin.PluginFactory[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Project) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (name,opType,pluginGroup,project) => (userContext) => apply(name,opType,pluginGroup,project)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/operatorsAll.scala.html
                  HASH: 5a554e5ae204bb95d9f558abd69e87de5a174890
                  MATRIX: 439->1|504->60|554->105|1067->160|1293->913|1318->929|1429->963|1459->967|1474->973|1489->979|1499->986|1527->1005|1567->1007|1596->1009|1701->1092|1721->1099|1747->1116|1787->1118|1816->1120|1932->1214|1952->1221|1980->1240|2020->1242|2049->1244|2161->1334|2194->1340|2219->1345|2243->1360|2383->308|2411->310|2470->353|2510->355|2540->358|2584->375|2613->383|2642->385|2674->396|2784->480|2799->486|2826->492|2858->497|2906->518|2935->526|2964->528|3009->552|3038->554|3070->565|3117->585|3130->589|3163->601|3207->618|3222->624|3249->630|3322->676|3337->682|3364->688|3402->700|3447->724|3479->729|3590->813|3619->821|3648->823|3694->847|3724->849|3757->860|3793->870|3808->876|3841->888|3873->893|3920->910|3949->1342
                  LINES: 17->1|18->2|19->4|26->5|33->26|33->26|35->26|36->27|36->27|36->27|36->28|36->28|36->28|36->28|36->28|36->29|36->29|36->29|36->29|36->29|36->30|36->30|36->30|36->30|36->30|36->31|37->34|37->34|40->9|41->10|41->10|41->10|42->11|42->11|42->11|42->11|42->11|44->13|44->13|44->13|45->14|46->15|46->15|46->15|46->15|46->15|46->15|46->15|46->15|46->15|47->16|47->16|47->16|48->17|48->17|48->17|49->18|49->18|50->19|51->20|51->20|51->20|51->20|51->20|51->20|52->21|52->21|52->21|53->22|55->24|57->32
                  -- GENERATED --
              */
          