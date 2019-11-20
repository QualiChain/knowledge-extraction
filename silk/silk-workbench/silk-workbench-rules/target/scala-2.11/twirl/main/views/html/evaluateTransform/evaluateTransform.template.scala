
package views.html.evaluateTransform

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
/*1.2*/import org.silkframework.rule.TransformSpec
/*2.2*/import controllers.rules.routes.Assets
/*3.2*/import org.silkframework.workbench.Context

object evaluateTransform extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Context[TransformSpec],Int,Int,play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(context: Context[TransformSpec], offset: Int, limit: Int)(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*7.2*/header/*7.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.12*/("""
  """),format.raw/*8.3*/("""<link type="text/css" href=""""),_display_(/*8.32*/Assets/*8.38*/.at("stylesheets/evaluateTransform/evaluateTransform.css")),format.raw/*8.96*/("""" rel="stylesheet" />
""")))};def /*11.2*/toolbar/*11.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*11.13*/("""
""")))};def /*14.2*/content/*14.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*14.13*/("""
  """),format.raw/*15.3*/("""<iframe id="generatedEntitiesIFrame" src="evaluate/generatedEntities?offset="""),_display_(/*15.80*/offset),format.raw/*15.86*/("""&limit="""),_display_(/*15.94*/limit),format.raw/*15.99*/("""" frameborder="0"></iframe>
""")))};
Seq[Any](format.raw/*6.1*/("""
"""),format.raw/*9.2*/("""

"""),format.raw/*12.2*/("""

"""),format.raw/*16.2*/("""

"""),_display_(/*18.2*/main(Some(context), titleLabel = context.task.taskLabel())/*18.60*/(header)/*18.68*/(toolbar)/*18.77*/(content)))
      }
    }
  }

  def render(context:Context[TransformSpec],offset:Int,limit:Int,session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(context,offset,limit)(session)

  def f:((Context[TransformSpec],Int,Int) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (context,offset,limit) => (session) => apply(context,offset,limit)(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/evaluateTransform/evaluateTransform.scala.html
                  HASH: 6d29ef0fe75ee9e4b99a9b8273efdba47824234f
                  MATRIX: 450->1|501->46|547->86|951->131|1127->232|1140->238|1220->242|1249->245|1304->274|1318->280|1396->338|1442->364|1457->371|1538->375|1563->380|1578->387|1659->391|1689->394|1793->471|1820->477|1855->485|1881->490|1948->230|1975->361|2004->377|2033->519|2062->522|2129->580|2146->588|2164->597
                  LINES: 17->1|18->2|19->3|24->5|28->7|28->7|30->7|31->8|31->8|31->8|31->8|32->11|32->11|34->11|35->14|35->14|37->14|38->15|38->15|38->15|38->15|38->15|40->6|41->9|43->12|45->16|47->18|47->18|47->18|47->18
                  -- GENERATED --
              */
          