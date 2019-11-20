
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
/*1.2*/import org.silkframework.rule.TransformSpec
/*2.2*/import controllers.core.routes.{Assets => CoreAssets}
/*3.2*/import org.silkframework.rule.vocab.Vocabularies
/*4.2*/import org.silkframework.workbench.Context

object transformRules extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Context[TransformSpec],Vocabularies,String,play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(context: Context[TransformSpec], vocabularies: Vocabularies, rule: String)(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*8.2*/header/*8.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.12*/("""
  """),format.raw/*9.3*/("""<script src=""""),_display_(/*9.17*/CoreAssets/*9.27*/.at("libs/silk-react-components/main.js")),format.raw/*9.68*/("""" type="text/javascript"></script>
""")))};def /*12.2*/content/*12.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*12.13*/("""
  """),format.raw/*13.3*/("""<div id="react-hierarchicalMapping"></div>

  <script type="text/javascript">

      silkReactComponents.hierarchicalMapping(
        'react-hierarchicalMapping',
        """),format.raw/*19.9*/("""{"""),format.raw/*19.10*/("""
            """),format.raw/*20.13*/("""baseUrl: '"""),_display_(/*20.24*/config/*20.30*/.baseUrl),format.raw/*20.38*/("""',
            project: '"""),_display_(/*21.24*/context/*21.31*/.project.name),format.raw/*21.44*/("""',
            transformTask: '"""),_display_(/*22.30*/context/*22.37*/.task.id),format.raw/*22.45*/("""',
            initialRule: '"""),_display_(/*23.28*/rule),format.raw/*23.32*/("""'
        """),format.raw/*24.9*/("""}"""),format.raw/*24.10*/("""
    """),format.raw/*25.5*/(""");

  </script>

""")))};
Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*10.2*/("""

"""),format.raw/*29.2*/("""

"""),_display_(/*31.2*/main(Some(context), titleLabel = context.task.taskLabel())/*31.60*/(header)/*31.68*/(null)/*31.74*/(content)),format.raw/*31.83*/("""
"""))
      }
    }
  }

  def render(context:Context[TransformSpec],vocabularies:Vocabularies,rule:String,session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(context,vocabularies,rule)(session)

  def f:((Context[TransformSpec],Vocabularies,String) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (context,vocabularies,rule) => (session) => apply(context,vocabularies,rule)(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/transformRules.scala.html
                  HASH: a247c9f444de1dfe5f683a8ba8b669d6f3d2e464
                  MATRIX: 439->1|490->46|551->101|607->151|1020->196|1213->314|1226->320|1306->324|1335->327|1375->341|1393->351|1454->392|1513->431|1528->438|1609->442|1639->445|1837->616|1866->617|1907->630|1945->641|1960->647|1989->655|2042->681|2058->688|2092->701|2151->733|2167->740|2196->748|2253->778|2278->782|2315->792|2344->793|2376->798|2432->312|2460->428|2489->816|2518->819|2585->877|2602->885|2617->891|2647->900
                  LINES: 17->1|18->2|19->3|20->4|25->6|29->8|29->8|31->8|32->9|32->9|32->9|32->9|33->12|33->12|35->12|36->13|42->19|42->19|43->20|43->20|43->20|43->20|44->21|44->21|44->21|45->22|45->22|45->22|46->23|46->23|47->24|47->24|48->25|53->7|54->10|56->29|58->31|58->31|58->31|58->31|58->31
                  -- GENERATED --
              */
          