
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
/*1.2*/import org.silkframework.dataset.DatasetSpec.GenericDatasetSpec
/*2.2*/import org.silkframework.dataset.rdf.RdfDataset
/*3.2*/import org.silkframework.workspace.WorkspaceFactory
/*5.2*/import org.silkframework.runtime.activity.UserContext

object sparqlDatasetSelect extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[String,String,String,String,Option[String],UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(projectName: String, label: String, description: String, mainId: String, inputId: Option[String])(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*8.2*/project/*8.9*/ = {{ WorkspaceFactory().workspace.project(projectName.toString) }};def /*9.2*/rdfDatasets/*9.13*/ = {{ project.tasks[GenericDatasetSpec].filter(_.data.plugin.isInstanceOf[RdfDataset]) }};
Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*8.75*/("""
"""),format.raw/*9.101*/("""

"""),format.raw/*11.1*/("""<div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label">
  <select class="mdl-selectfield__select" id=""""),_display_(/*12.48*/{mainId}),format.raw/*12.56*/("""" name=""""),_display_(/*12.65*/{mainId}),format.raw/*12.73*/("""">
    <option value=""></option>
    """),_display_(/*14.6*/{
      for(task <- rdfDatasets) yield {
        if(inputId.isDefined && task.id.toString == inputId.get) {
            <option value={task.id} selected="selected">{task.id}</option>
        } else {
            <option value={task.id}>{task.id}</option>
        }
      }
    }),format.raw/*22.6*/("""
  """),format.raw/*23.3*/("""</select>
  <label class="mdl-selectfield__label" for=""""),_display_(/*24.47*/{mainId}),format.raw/*24.55*/("""">"""),_display_(/*24.58*/label),format.raw/*24.63*/("""</label>
  <div class="mdl-tooltip mdl-tooltip--right" for=""""),_display_(/*25.53*/{mainId}),format.raw/*25.61*/("""">
    """),_display_(/*26.6*/description),format.raw/*26.17*/("""
  """),format.raw/*27.3*/("""</div>
</div>
"""))
      }
    }
  }

  def render(projectName:String,label:String,description:String,mainId:String,inputId:Option[String],userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(projectName,label,description,mainId,inputId)(userContext)

  def f:((String,String,String,String,Option[String]) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (projectName,label,description,mainId,inputId) => (userContext) => apply(projectName,label,description,mainId,inputId)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/widgets/sparqlDatasetSelect.scala.html
                  HASH: dc5b8b9f8f04c9d67cbc543cca5449d24338e2df
                  MATRIX: 440->1|511->66|566->115|625->169|1045->224|1256->360|1270->367|1349->435|1368->446|1485->358|1513->433|1542->534|1571->536|1726->664|1755->672|1791->681|1820->689|1885->728|2183->1006|2213->1009|2296->1065|2325->1073|2355->1076|2381->1081|2469->1142|2498->1150|2532->1158|2564->1169|2594->1172
                  LINES: 17->1|18->2|19->3|20->5|25->6|29->8|29->8|29->9|29->9|30->7|31->8|32->9|34->11|35->12|35->12|35->12|35->12|37->14|45->22|46->23|47->24|47->24|47->24|47->24|48->25|48->25|49->26|49->26|50->27
                  -- GENERATED --
              */
          