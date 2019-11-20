
package views.html.workflow.editor

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
/*1.2*/import org.silkframework.workspace.ProjectTask
/*2.2*/import org.silkframework.workbench.WorkbenchPlugins
/*3.2*/import org.silkframework.workbench.WorkbenchPlugin.TaskActions
/*4.2*/import org.silkframework.workspace.activity.workflow.Workflow
/*5.2*/import org.silkframework.runtime.activity.UserContext

object toolbox extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[org.silkframework.workspace.Project,ProjectTask[Workflow],UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(project: org.silkframework.workspace.Project, workflow: ProjectTask[Workflow])(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*34.2*/toolboxOperator/*34.17*/(taskActions: TaskActions):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*34.47*/("""
  """),format.raw/*35.3*/("""<div id="toolbox_"""),_display_(/*35.21*/taskActions/*35.32*/.task.id),format.raw/*35.40*/("""" class="toolboxOperator" title=""""),_display_(/*35.74*/taskActions/*35.85*/.task.taskLabel(maxLength = 1024)),format.raw/*35.118*/("""">
    """),format.raw/*36.26*/("""
    """),_display_(/*37.6*/taskActions/*37.17*/.task.taskLabel()),format.raw/*37.34*/("""
    """),_display_(/*38.6*/if(taskActions.taskType.typeName != "Dataset")/*38.52*/ {_display_(Seq[Any](format.raw/*38.54*/("""
      """),_display_(/*39.8*/operator(taskActions, workflow)),format.raw/*39.39*/("""
    """)))}/*40.7*/else/*40.12*/{_display_(Seq[Any](format.raw/*40.13*/("""
      """),_display_(/*41.8*/dataset(taskActions, workflow)),format.raw/*41.38*/("""
    """)))}),format.raw/*42.6*/("""
  """),format.raw/*43.3*/("""</div>
""")))};
Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<div id="toolbox" style="height: 67.9px;">
  <div id="operatorToolbox">
    <div id="operatorToolboxHeader">
      Operators
    </div>
    """),_display_(/*14.6*/for(task <- project.allTasks;
         taskActions = WorkbenchPlugins.forTask(task) if taskActions.taskType.typeName != "Dataset" &&
                                                          taskActions.taskType.typeName != "Workflow") yield /*16.103*/ {_display_(Seq[Any](format.raw/*16.105*/("""
      """),_display_(/*17.8*/toolboxOperator(taskActions)),format.raw/*17.36*/("""
    """)))}),format.raw/*18.6*/("""
  """),format.raw/*19.3*/("""</div>
  <div id="datasetToolbox">
    <div id="datasetToolboxHeader">
      Datasets
    </div>
      """),_display_(/*24.8*/for(task <- project.allTasks;
           taskActions = WorkbenchPlugins.forTask(task) if taskActions.taskType.typeName == "Dataset") yield /*25.103*/ {_display_(Seq[Any](format.raw/*25.105*/("""
        """),_display_(/*26.10*/toolboxOperator(taskActions)),format.raw/*26.38*/("""
      """)))}),format.raw/*27.8*/("""
  """),format.raw/*28.3*/("""</div>
</div>

"""),format.raw/*33.4*/("""
"""))
      }
    }
  }

  def render(project:org.silkframework.workspace.Project,workflow:ProjectTask[Workflow],userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(project,workflow)(userContext)

  def f:((org.silkframework.workspace.Project,ProjectTask[Workflow]) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (project,workflow) => (userContext) => apply(project,workflow)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workflow/app/views/workflow/editor/toolbox.scala.html
                  HASH: eb026f408cccf5d795dcdf055391900b874758d0
                  MATRIX: 448->1|502->49|561->102|631->166|700->229|1123->285|1316->1172|1340->1187|1447->1217|1477->1220|1522->1238|1542->1249|1571->1257|1632->1291|1652->1302|1707->1335|1742->1363|1774->1369|1794->1380|1832->1397|1864->1403|1919->1449|1959->1451|1993->1459|2045->1490|2069->1497|2082->1502|2121->1503|2155->1511|2206->1541|2242->1547|2272->1550|2318->400|2345->401|2512->542|2764->777|2805->779|2839->787|2888->815|2924->821|2954->824|3084->928|3233->1060|3274->1062|3311->1072|3360->1100|3398->1108|3428->1111|3470->1170
                  LINES: 17->1|18->2|19->3|20->4|21->5|26->7|30->34|30->34|32->34|33->35|33->35|33->35|33->35|33->35|33->35|33->35|34->36|35->37|35->37|35->37|36->38|36->38|36->38|37->39|37->39|38->40|38->40|38->40|39->41|39->41|40->42|41->43|43->8|44->9|49->14|51->16|51->16|52->17|52->17|53->18|54->19|59->24|60->25|60->25|61->26|61->26|62->27|63->28|66->33
                  -- GENERATED --
              */
          