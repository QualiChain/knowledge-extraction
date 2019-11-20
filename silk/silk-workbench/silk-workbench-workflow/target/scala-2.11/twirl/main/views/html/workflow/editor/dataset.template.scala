
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

object dataset extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[TaskActions,ProjectTask[Workflow],Option[scala.Tuple2[Int, Int]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(taskActions: TaskActions, workflow: ProjectTask[Workflow], pos: Option[(Int, Int)] = None):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*23.2*/inputCardinality/*23.18*/() = {{
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
"""),format.raw/*8.1*/("""<div class="dataset" title=""""),_display_(/*8.30*/taskActions/*8.41*/.task.taskLabel(maxLength = 1024)),format.raw/*8.74*/("""" style=""""),_display_(/*8.84*/if(pos.isEmpty)/*8.99*/ {_display_(Seq[Any](format.raw/*8.101*/("""display:none;""")))}/*8.116*/else/*8.121*/{_display_(Seq[Any](format.raw/*8.122*/("""left: """),_display_(/*8.129*/pos/*8.132*/.get._1),format.raw/*8.139*/(""", top: """),_display_(/*8.147*/pos/*8.150*/.get._2)))}),format.raw/*8.158*/(""""
     data-input-cardinality=""""),_display_(/*9.31*/inputCardinality()),format.raw/*9.49*/("""">
<div class="dataset-bottom"></div>
  <div class="dataset-contents">
    <div class="dataset-buttons">
      <img src=""""),_display_(/*13.18*/Assets/*13.24*/.at("img/delete.png")),format.raw/*13.45*/("""" style="float:right" onclick="editor.removeElement($(this).parent().parent().parent().attr('id'))"/>
      """),_display_(/*14.8*/for(path <- taskActions.openPath(Some(workflow.id), None)) yield /*14.66*/ {_display_(Seq[Any](format.raw/*14.68*/("""
        """),format.raw/*15.9*/("""<img align="right" src=""""),_display_(/*15.34*/Assets/*15.40*/.at("img/wrench-screwdriver.png")),format.raw/*15.73*/("""" style="float:right" onclick="window.open('"""),_display_(/*15.118*/config/*15.124*/.baseUrl),format.raw/*15.132*/("""/"""),_display_(/*15.134*/path),format.raw/*15.138*/("""', '_blank')" />
      """)))}),format.raw/*16.8*/("""
    """),format.raw/*17.5*/("""</div>
    <div class="dataset-name">"""),_display_(/*18.32*/taskActions/*18.43*/.task.taskLabel(maxLength = 24)),format.raw/*18.74*/("""</div>
  </div>
  <div class="dataset-top"></div>
</div>

"""),format.raw/*32.2*/("""
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
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workflow/app/views/workflow/editor/dataset.scala.html
                  HASH: ed7107285c4fada7457ccd9d783cfbf3644d24f1
                  MATRIX: 448->1|497->44|567->108|621->156|1047->220|1217->1144|1242->1160|1418->312|1445->313|1500->342|1519->353|1572->386|1608->396|1631->411|1671->413|1704->428|1717->433|1756->434|1790->441|1802->444|1830->451|1865->459|1877->462|1909->470|1967->502|2005->520|2154->642|2169->648|2211->669|2346->778|2420->836|2460->838|2496->847|2548->872|2563->878|2617->911|2690->956|2706->962|2736->970|2766->972|2792->976|2846->1000|2878->1005|2943->1043|2963->1054|3015->1085|3100->1307
                  LINES: 17->1|18->2|19->3|20->4|25->6|29->23|29->23|39->7|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|40->8|41->9|41->9|45->13|45->13|45->13|46->14|46->14|46->14|47->15|47->15|47->15|47->15|47->15|47->15|47->15|47->15|47->15|48->16|49->17|50->18|50->18|50->18|55->32
                  -- GENERATED --
              */
          