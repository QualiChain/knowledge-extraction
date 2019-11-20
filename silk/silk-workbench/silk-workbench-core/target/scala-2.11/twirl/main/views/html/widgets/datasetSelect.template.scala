
package views.html.widgets

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
/*1.2*/import org.silkframework.config.CustomTask
/*2.2*/import org.silkframework.dataset.DatasetSpec.GenericDatasetSpec
/*3.2*/import org.silkframework.rule.TransformSpec
/*4.2*/import org.silkframework.workspace.{ProjectTask, WorkspaceFactory}
/*5.2*/import org.silkframework.runtime.activity.UserContext

object datasetSelect extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,String,Option[String],UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(projectName: String, modifier: String, inputId: Option[String])(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*9.2*/project/*9.9*/ = {{ WorkspaceFactory().workspace.project(projectName.toString) }};def /*10.2*/datasets/*10.10*/ = {{ project.tasks[GenericDatasetSpec] }};def /*11.2*/transformTasks/*11.16*/ = {{ project.tasks[TransformSpec] }};def /*12.2*/customTasksWithOutputSchema/*12.29*/ = {{ project.tasks[CustomTask].filter(_.outputSchemaOpt.isDefined) }};def /*13.2*/generateOptions/*13.17*/ = {{ (tasks: Seq[ProjectTask[_]]) =>
  for(task <- tasks) yield {
    if(inputId.isDefined && task.id.toString == inputId.get) {
        <option value={task.id} selected="selected">{task.taskLabel()}</option>
    } else {
        <option value={task.id}>{task.taskLabel()}</option>
    }
  }
}};
Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.75*/("""
"""),format.raw/*10.51*/("""
"""),format.raw/*11.52*/("""
"""),format.raw/*12.98*/("""
"""),format.raw/*21.2*/("""

"""),format.raw/*23.1*/("""<div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label">
  <select class="mdl-selectfield__select" id=""""),_display_(/*24.48*/{modifier}),format.raw/*24.58*/("""_dataset" name=""""),_display_(/*24.75*/{modifier}),format.raw/*24.85*/("""_dataset">
    <option value=""></option>
    """),_display_(/*26.6*/generateOptions(datasets)),format.raw/*26.31*/("""
    """),_display_(/*27.6*/generateOptions(transformTasks)),format.raw/*27.37*/("""
    """),_display_(/*28.6*/generateOptions(customTasksWithOutputSchema)),format.raw/*28.50*/("""
  """),format.raw/*29.3*/("""</select>
  <label class="mdl-selectfield__label" for=""""),_display_(/*30.47*/{modifier}),format.raw/*30.57*/("""_dataset">"""),_display_(/*30.68*/{modifier.capitalize}),format.raw/*30.89*/(""" """),format.raw/*30.90*/("""Dataset</label>
  <div class="mdl-tooltip mdl-tooltip--right" for=""""),_display_(/*31.53*/{modifier}),format.raw/*31.63*/("""_dataset">
    The """),_display_(/*32.10*/modifier),format.raw/*32.18*/(""" """),format.raw/*32.19*/("""dataset.
  </div>
</div>
"""))
      }
    }
  }

  def render(projectName:String,modifier:String,inputId:Option[String],userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(projectName,modifier,inputId)(userContext)

  def f:((String,String,Option[String]) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (projectName,modifier,inputId) => (userContext) => apply(projectName,modifier,inputId)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/widgets/datasetSelect.scala.html
                  HASH: a04f7781b78bfa255a475003850cbf128fcb8a51
                  MATRIX: 440->1|490->45|561->110|612->155|686->223|1086->279|1263->381|1277->388|1357->456|1374->464|1429->507|1452->521|1502->559|1538->586|1621->657|1645->672|1968->379|1996->454|2025->505|2054->557|2083->655|2111->966|2140->968|2295->1096|2326->1106|2370->1123|2401->1133|2474->1180|2520->1205|2552->1211|2604->1242|2636->1248|2701->1292|2731->1295|2814->1351|2845->1361|2883->1372|2925->1393|2954->1394|3049->1462|3080->1472|3127->1492|3156->1500|3185->1501
                  LINES: 17->1|18->2|19->3|20->4|21->5|26->7|30->9|30->9|30->10|30->10|30->11|30->11|30->12|30->12|30->13|30->13|39->8|40->9|41->10|42->11|43->12|44->21|46->23|47->24|47->24|47->24|47->24|49->26|49->26|50->27|50->27|51->28|51->28|52->29|53->30|53->30|53->30|53->30|53->30|54->31|54->31|55->32|55->32|55->32
                  -- GENERATED --
              */
          