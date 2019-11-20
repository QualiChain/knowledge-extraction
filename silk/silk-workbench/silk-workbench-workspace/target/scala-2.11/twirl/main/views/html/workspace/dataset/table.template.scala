
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
/*1.2*/import org.silkframework.entity.Entity
/*2.2*/import org.silkframework.dataset.DatasetSpec.GenericDatasetSpec
/*3.2*/import org.silkframework.entity.paths.UntypedPath
/*4.2*/import org.silkframework.workbench.Context

object table extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Context[GenericDatasetSpec],IndexedSeq[UntypedPath],Seq[Entity],play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(context: Context[GenericDatasetSpec], paths: IndexedSeq[UntypedPath], entities: Seq[Entity])(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*8.2*/header/*8.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.12*/("""
""")))};def /*11.2*/toolbar/*11.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*11.13*/("""
""")))};def /*14.2*/content/*14.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*14.13*/("""
"""),format.raw/*15.1*/("""<table>
  <tr>
    """),_display_(/*17.6*/for(path <- paths) yield /*17.24*/ {_display_(Seq[Any](format.raw/*17.26*/("""
      """),format.raw/*18.7*/("""<th>"""),_display_(/*18.12*/path/*18.16*/.toString),format.raw/*18.25*/("""<th>
    """)))}),format.raw/*19.6*/("""
  """),format.raw/*20.3*/("""</tr>

  """),_display_(/*22.4*/for(entity <- entities) yield /*22.27*/ {_display_(Seq[Any](format.raw/*22.29*/("""
    """),format.raw/*23.5*/("""<tr>
      """),_display_(/*24.8*/for(path <- paths) yield /*24.26*/ {_display_(Seq[Any](format.raw/*24.28*/("""
        """),format.raw/*25.9*/("""<td>"""),_display_(/*25.14*/entity/*25.20*/.evaluate(path)),format.raw/*25.35*/("""<td>
      """)))}),format.raw/*26.8*/("""
    """),format.raw/*27.5*/("""</tr>
  """)))}),format.raw/*28.4*/("""
"""),format.raw/*29.1*/("""</table>
""")))};
Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*9.2*/("""

"""),format.raw/*12.2*/("""

"""),format.raw/*30.2*/("""

"""),_display_(/*32.2*/main(Some(context), titleLabel = context.task.taskLabel())/*32.60*/(header)/*32.68*/(toolbar)/*32.77*/(content)))
      }
    }
  }

  def render(context:Context[GenericDatasetSpec],paths:IndexedSeq[UntypedPath],entities:Seq[Entity],session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(context,paths,entities)(session)

  def f:((Context[GenericDatasetSpec],IndexedSeq[UntypedPath],Seq[Entity]) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (context,paths,entities) => (session) => apply(context,paths,entities)(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/dataset/table.scala.html
                  HASH: 97cf7a6dcd3da45ed08f356ef581ea8a63ec4891
                  MATRIX: 450->1|496->41|567->106|624->157|1049->202|1260->338|1273->344|1353->348|1378->353|1393->360|1474->364|1499->369|1514->376|1595->380|1623->381|1669->401|1703->419|1743->421|1777->428|1809->433|1822->437|1852->446|1892->456|1922->459|1958->469|1997->492|2037->494|2069->499|2107->511|2141->529|2181->531|2217->540|2249->545|2264->551|2300->566|2342->578|2374->583|2413->592|2441->593|2489->336|2516->350|2545->366|2574->603|2603->606|2670->664|2687->672|2705->681
                  LINES: 17->1|18->2|19->3|20->4|25->6|29->8|29->8|31->8|32->11|32->11|34->11|35->14|35->14|37->14|38->15|40->17|40->17|40->17|41->18|41->18|41->18|41->18|42->19|43->20|45->22|45->22|45->22|46->23|47->24|47->24|47->24|48->25|48->25|48->25|48->25|49->26|50->27|51->28|52->29|54->7|55->9|57->12|59->30|61->32|61->32|61->32|61->32
                  -- GENERATED --
              */
          