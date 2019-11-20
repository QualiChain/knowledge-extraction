
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
/*1.2*/import org.silkframework.workbench.Context

object sparql extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Context[org.silkframework.dataset.DatasetSpec.GenericDatasetSpec],org.silkframework.dataset.rdf.SparqlEndpoint,String,Option[org.silkframework.dataset.rdf.SparqlResults],play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(context: Context[org.silkframework.dataset.DatasetSpec.GenericDatasetSpec],
  endpoint: org.silkframework.dataset.rdf.SparqlEndpoint,
  query: String,
  queryResults: Option[org.silkframework.dataset.rdf.SparqlResults])(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*8.2*/header/*8.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.12*/("""

""")))};def /*12.2*/toolbar/*12.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*12.13*/("""

""")))};def /*16.2*/content/*16.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*16.13*/("""
"""),format.raw/*17.1*/("""<form action="sparql">
  <textarea name="query" cols="70" rows="25">
"""),_display_(/*19.2*/if(query.isEmpty)/*19.19*/ {_display_(Seq[Any](_display_(/*19.22*/for((prefix, namespace) <- context.project.config.prefixes.prefixMap) yield /*19.91*/ {_display_(Seq[Any](format.raw/*19.93*/("""PREFIX """),_display_(/*19.101*/prefix),format.raw/*19.107*/(""": &lt;"""),_display_(/*19.114*/namespace),format.raw/*19.123*/("""&gt;
""")))}),format.raw/*20.2*/("""
"""),format.raw/*21.1*/("""SELECT * WHERE """),format.raw/*21.16*/("""{"""),format.raw/*21.17*/("""
  """),format.raw/*22.3*/("""?s ?p ?o
"""),format.raw/*23.1*/("""}"""),format.raw/*23.2*/("""
"""),format.raw/*24.1*/("""LIMIT 20""")))}/*24.11*/else/*24.16*/{_display_(_display_(/*24.18*/query))}),format.raw/*24.24*/("""
  """),format.raw/*25.3*/("""</textarea>
  <br/>
  <input type="submit" value="Submit">
</form>

<table>
  <tr>
    """),_display_(/*32.6*/for(results <- queryResults.toList;
         variable <- results.variables) yield /*33.40*/ {_display_(Seq[Any](format.raw/*33.42*/("""
      """),format.raw/*34.7*/("""<th>"""),_display_(/*34.12*/variable),format.raw/*34.20*/("""<th>
    """)))}),format.raw/*35.6*/("""
  """),format.raw/*36.3*/("""</tr>

  """),_display_(/*38.4*/for(results <- queryResults.toList; bindings <- results.bindings) yield /*38.69*/ {_display_(Seq[Any](format.raw/*38.71*/("""
    """),format.raw/*39.5*/("""<tr>
      """),_display_(/*40.8*/for((variable, node) <- bindings) yield /*40.41*/ {_display_(Seq[Any](format.raw/*40.43*/("""
        """),format.raw/*41.9*/("""<td>"""),_display_(/*41.14*/node/*41.18*/.value),format.raw/*41.24*/("""<td>
      """)))}),format.raw/*42.8*/("""
    """),format.raw/*43.5*/("""</tr>
  """)))}),format.raw/*44.4*/("""
"""),format.raw/*45.1*/("""</table>
""")))};
Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*10.2*/("""

"""),format.raw/*14.2*/("""

"""),format.raw/*46.2*/("""

"""),_display_(/*48.2*/main(Some(context), titleLabel = context.task.taskLabel())/*48.60*/(header)/*48.68*/(toolbar)/*48.77*/(content)))
      }
    }
  }

  def render(context:Context[org.silkframework.dataset.DatasetSpec.GenericDatasetSpec],endpoint:org.silkframework.dataset.rdf.SparqlEndpoint,query:String,queryResults:Option[org.silkframework.dataset.rdf.SparqlResults],session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(context,endpoint,query,queryResults)(session)

  def f:((Context[org.silkframework.dataset.DatasetSpec.GenericDatasetSpec],org.silkframework.dataset.rdf.SparqlEndpoint,String,Option[org.silkframework.dataset.rdf.SparqlResults]) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (context,endpoint,query,queryResults) => (session) => apply(context,endpoint,query,queryResults)(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/dataset/sparql.scala.html
                  HASH: 6237b3b33c889bbc7301616b9e9f813fa4e4e1fd
                  MATRIX: 450->1|982->46|1320->309|1333->315|1413->319|1439->325|1454->332|1535->336|1561->342|1576->349|1657->353|1685->354|1781->424|1807->441|1847->444|1932->513|1972->515|2008->523|2036->529|2071->536|2102->545|2138->551|2166->552|2209->567|2238->568|2268->571|2304->580|2332->581|2360->582|2388->592|2401->597|2431->599|2460->605|2490->608|2604->696|2695->771|2735->773|2769->780|2801->785|2830->793|2870->803|2900->806|2936->816|3017->881|3057->883|3089->888|3127->900|3176->933|3216->935|3252->944|3284->949|3297->953|3324->959|3366->971|3398->976|3437->985|3465->986|3513->307|3541->322|3570->339|3599->996|3628->999|3695->1057|3712->1065|3730->1074
                  LINES: 17->1|22->3|29->8|29->8|31->8|33->12|33->12|35->12|37->16|37->16|39->16|40->17|42->19|42->19|42->19|42->19|42->19|42->19|42->19|42->19|42->19|43->20|44->21|44->21|44->21|45->22|46->23|46->23|47->24|47->24|47->24|47->24|47->24|48->25|55->32|56->33|56->33|57->34|57->34|57->34|58->35|59->36|61->38|61->38|61->38|62->39|63->40|63->40|63->40|64->41|64->41|64->41|64->41|65->42|66->43|67->44|68->45|70->7|71->10|73->14|75->46|77->48|77->48|77->48|77->48
                  -- GENERATED --
              */
          