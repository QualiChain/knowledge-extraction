
package views.html.workspace.dataset

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
/*1.2*/import org.silkframework.dataset.rdf.RdfDataset
/*2.2*/import org.silkframework.dataset.DatasetSpec.GenericDatasetSpec
/*3.2*/import org.silkframework.workbench.Context

object dataset extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Context[GenericDatasetSpec],play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(context: Context[GenericDatasetSpec])(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*7.2*/header/*7.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.12*/("""

""")))};def /*11.2*/toolbar/*11.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*11.13*/("""

""")))};def /*15.2*/content/*15.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*15.13*/("""

"""),_display_(/*17.2*/if(context.task.data.plugin.isInstanceOf[RdfDataset])/*17.55*/ {_display_(Seq[Any](format.raw/*17.57*/("""
  """),format.raw/*18.3*/("""This is an RDF-Dataset that can be queried using the SPARQL query language.
""")))}/*19.3*/else/*19.8*/{_display_(Seq[Any](format.raw/*19.9*/("""
  """),format.raw/*20.3*/("""This is not an RDF-Dataset and thus cannot be queried using SPARQL.
""")))}),format.raw/*21.2*/("""

""")))};
Seq[Any](format.raw/*6.1*/("""
"""),format.raw/*9.2*/("""

"""),format.raw/*13.2*/("""

"""),format.raw/*23.2*/("""

"""),_display_(/*25.2*/main(Some(context), titleLabel = context.task.taskLabel())/*25.60*/(header)/*25.68*/(toolbar)/*25.77*/(content)),format.raw/*25.86*/("""
"""))
      }
    }
  }

  def render(context:Context[GenericDatasetSpec],session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(context)(session)

  def f:((Context[GenericDatasetSpec]) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (context) => (session) => apply(context)(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/dataset/dataset.scala.html
                  HASH: 1124dc009b97b58c495e29db69b02bf5cba3bcbe
                  MATRIX: 450->1|505->50|576->115|967->160|1123->241|1136->247|1216->251|1242->257|1257->264|1338->268|1364->274|1379->281|1460->285|1489->288|1551->341|1591->343|1621->346|1716->424|1728->429|1766->430|1796->433|1895->502|1936->239|1963->254|1992->271|2021->505|2050->508|2117->566|2134->574|2152->583|2182->592
                  LINES: 17->1|18->2|19->3|24->5|28->7|28->7|30->7|32->11|32->11|34->11|36->15|36->15|38->15|40->17|40->17|40->17|41->18|42->19|42->19|42->19|43->20|44->21|47->6|48->9|50->13|52->23|54->25|54->25|54->25|54->25|54->25
                  -- GENERATED --
              */
          