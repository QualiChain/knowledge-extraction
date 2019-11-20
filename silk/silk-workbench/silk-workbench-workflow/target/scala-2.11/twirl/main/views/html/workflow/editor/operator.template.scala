
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
/*1.2*/import controllers.workflow.routes.Assets
/*2.2*/import org.silkframework.workbench.WorkbenchPlugin.TaskActions
/*3.2*/import org.silkframework.workspace.ProjectTask
/*4.2*/import org.silkframework.workspace.activity.workflow.Workflow

object operator extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[TaskActions,ProjectTask[Workflow],Option[scala.Tuple2[Int, Int]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(taskActions: TaskActions, workflow: ProjectTask[Workflow], pos: Option[(Int, Int)] = None):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*25.2*/inputCardinality/*25.18*/() = {{
  taskActions.task.data.inputSchemataOpt match {
    case Some(inputs) => {
      inputs.size
    }
    case None => {
      -1
    }
  }
}};
Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*8.1*/("""<div class="operator" title=""""),_display_(/*8.31*/taskActions/*8.42*/.task.taskLabel(maxLength = 1024)),format.raw/*8.75*/("""" style=""""),_display_(/*8.85*/if(pos.isEmpty)/*8.100*/ {_display_(Seq[Any](format.raw/*8.102*/("""display:none;""")))}/*8.117*/else/*8.122*/{_display_(Seq[Any](format.raw/*8.123*/("""left: """),_display_(/*8.130*/pos/*8.133*/.get._1),format.raw/*8.140*/(""", top: """),_display_(/*8.148*/pos/*8.151*/.get._2)))}),format.raw/*8.159*/(""""
     data-input-cardinality=""""),_display_(/*9.31*/inputCardinality()),format.raw/*9.49*/("""">
  <div class="operatorHeader">
    <div class="operatorHeaderText">
      """),_display_(/*12.8*/taskActions/*12.19*/.taskType.typeName),format.raw/*12.37*/("""
    """),format.raw/*13.5*/("""</div>
    <img align="right" src=""""),_display_(/*14.30*/Assets/*14.36*/.at("img/delete.png")),format.raw/*14.57*/("""" style="cursor:pointer;" onclick="editor.removeElement($(this).parent().parent().attr('id'))"/>
  </div>
  <div class="operatorContent">
    """),format.raw/*17.98*/("""
    """),_display_(/*18.6*/taskActions/*18.17*/.task.taskLabel()),format.raw/*18.34*/("""
    """),_display_(/*19.6*/for(path <- taskActions.openPath(Some(workflow.id), Some(taskActions.task.id.toString))) yield /*19.94*/ {_display_(Seq[Any](format.raw/*19.96*/("""
      """),format.raw/*20.7*/("""<img align="right" src=""""),_display_(/*20.32*/Assets/*20.38*/.at("img/wrench-screwdriver.png")),format.raw/*20.71*/("""" style="cursor:pointer;" onclick="window.open('"""),_display_(/*20.120*/config/*20.126*/.baseUrl),format.raw/*20.134*/("""/"""),_display_(/*20.136*/path),format.raw/*20.140*/("""', '_blank')" />
    """)))}),format.raw/*21.6*/("""
  """),format.raw/*22.3*/("""</div>
</div>

"""),format.raw/*34.2*/("""
"""))
      }
    }
  }

  def render(taskActions:TaskActions,workflow:ProjectTask[Workflow],pos:Option[scala.Tuple2[Int, Int]]): play.twirl.api.HtmlFormat.Appendable = apply(taskActions,workflow,pos)

  def f:((TaskActions,ProjectTask[Workflow],Option[scala.Tuple2[Int, Int]]) => play.twirl.api.HtmlFormat.Appendable) = (taskActions,workflow,pos) => apply(taskActions,workflow,pos)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workflow/app/views/workflow/editor/operator.scala.html
                  HASH: 4a8898a19b14971dd986c16c24734b13c4f530d3
                  MATRIX: 448->1|497->44|567->108|621->156|1048->220|1218->1242|1243->1258|1419->312|1446->313|1502->343|1521->354|1574->387|1610->397|1634->412|1674->414|1707->429|1720->434|1759->435|1793->442|1805->445|1833->452|1868->460|1880->463|1912->471|1970->503|2008->521|2112->599|2132->610|2171->628|2203->633|2266->669|2281->675|2323->696|2493->931|2525->937|2545->948|2583->965|2615->971|2719->1059|2759->1061|2793->1068|2845->1093|2860->1099|2914->1132|2991->1181|3007->1187|3037->1195|3067->1197|3093->1201|3145->1223|3175->1226|3217->1405
                  LINES: 17->1|18->2|19->3|20->4|25->6|29->25|29->25|39->7|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|41->9|41->9|44->12|44->12|44->12|45->13|46->14|46->14|46->14|49->17|50->18|50->18|50->18|51->19|51->19|51->19|52->20|52->20|52->20|52->20|52->20|52->20|52->20|52->20|52->20|53->21|54->22|57->34
                  -- GENERATED --
              */
          