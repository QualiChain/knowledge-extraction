
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
/*1.2*/import org.silkframework.util.DPair
/*2.2*/import org.silkframework.workspace.Project
/*4.2*/import org.silkframework.runtime.activity.UserContext

object pathsList extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[DPair[String],DPair[Seq[String]],Boolean,String,String,Project,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(sources: DPair[String], paths: DPair[Seq[String]], onlySource: Boolean, loadingMsg: String = "", warning: String = "",
    project: Project)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*11.2*/pathOperators/*11.15*/(source: String, paths: Seq[String], pathType: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*11.73*/("""
  """),_display_(/*12.4*/for(path <- paths) yield /*12.22*/ {_display_(Seq[Any](format.raw/*12.24*/("""
  """),format.raw/*13.3*/("""<div class="operator path search-invisible">
    <div class="operator-index">
      """),_display_(/*15.8*/path),format.raw/*15.12*/("""
    """),format.raw/*16.5*/("""</div>
    <div id="path_"""),_display_(/*17.20*/{pathType.toLowerCase}),format.raw/*17.42*/("""_"""),_display_(/*17.44*/{java.net.URLEncoder.encode(path, "utf-8")}),format.raw/*17.87*/("""" class="draggable """),_display_(/*17.107*/{pathType.toLowerCase}),format.raw/*17.129*/("""Paths">
      <p class="non-breaking-label">"""),_display_(/*18.38*/path),format.raw/*18.42*/("""</p>
      """),_display_(/*19.8*/pathExpanded(path, pathType)),format.raw/*19.36*/("""
    """),format.raw/*20.5*/("""</div>
  </div>
  """)))}),format.raw/*22.4*/("""
""")))};def /*25.2*/pathExpanded/*25.14*/(path: String, pathType: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*25.50*/("""
  """),_display_(/*26.4*/pathBox(pathType.toLowerCase + "Path", pathType == "Source", path, 0, 0, false, project)),format.raw/*26.92*/("""
""")))};
Seq[Any](format.raw/*7.1*/("""
"""),_display_(/*8.2*/pathOperators(sources.source, paths.source, "Source")),format.raw/*8.55*/("""
"""),_display_(/*9.2*/pathOperators(sources.target, paths.target, "Target")),format.raw/*9.55*/("""

"""),format.raw/*23.2*/("""

"""))
      }
    }
  }

  def render(sources:DPair[String],paths:DPair[Seq[String]],onlySource:Boolean,loadingMsg:String,warning:String,project:Project,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(sources,paths,onlySource,loadingMsg,warning,project)(userContext)

  def f:((DPair[String],DPair[Seq[String]],Boolean,String,String,Project) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (sources,paths,onlySource,loadingMsg,warning,project) => (userContext) => apply(sources,paths,onlySource,loadingMsg,warning,project)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/pathsList.scala.html
                  HASH: f022952bf93b4b3f667f28a08c3ed20f19f8eee9
                  MATRIX: 439->1|482->38|532->83|962->138|1217->428|1239->441|1374->499|1404->503|1438->521|1478->523|1508->526|1619->611|1644->615|1676->620|1729->646|1772->668|1801->670|1865->713|1913->733|1957->755|2029->800|2054->804|2092->816|2141->844|2173->849|2222->868|2247->873|2268->885|2381->921|2411->925|2520->1013|2560->315|2587->317|2660->370|2687->372|2760->425|2789->870
                  LINES: 17->1|18->2|19->4|24->5|29->11|29->11|31->11|32->12|32->12|32->12|33->13|35->15|35->15|36->16|37->17|37->17|37->17|37->17|37->17|37->17|38->18|38->18|39->19|39->19|40->20|42->22|43->25|43->25|45->25|46->26|46->26|48->7|49->8|49->8|50->9|50->9|52->23
                  -- GENERATED --
              */
          