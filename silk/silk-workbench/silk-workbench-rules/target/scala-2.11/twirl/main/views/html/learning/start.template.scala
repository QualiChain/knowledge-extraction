
package views.html.learning

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
/*1.2*/import org.silkframework.rule.LinkSpec
/*2.2*/import org.silkframework.workbench.Context

object start extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Context[LinkSpec],play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(context: Context[LinkSpec])(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*6.2*/header/*6.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.12*/("""
  """),format.raw/*7.3*/("""<script type="text/javascript">
    var taskUrl = '"""),_display_(/*8.21*/config/*8.27*/.baseUrl),format.raw/*8.35*/("""/linking/tasks/"""),_display_(/*8.51*/context/*8.58*/.project.name),format.raw/*8.71*/("""/"""),_display_(/*8.73*/context/*8.80*/.task.id),format.raw/*8.88*/("""';

    function startLearning() """),format.raw/*10.30*/("""{"""),format.raw/*10.31*/("""
      """),format.raw/*11.7*/("""$.ajax("""),format.raw/*11.14*/("""{"""),format.raw/*11.15*/("""
        """),format.raw/*12.9*/("""type: 'PUT',
        url: taskUrl + '/learningTask',
        data: '',
        success: function(response) """),format.raw/*15.37*/("""{"""),format.raw/*15.38*/("""
          """),format.raw/*16.11*/("""window.location = "learn"
        """),format.raw/*17.9*/("""}"""),format.raw/*17.10*/(""",
        error: function(request) """),format.raw/*18.34*/("""{"""),format.raw/*18.35*/("""
          """),format.raw/*19.11*/("""alert(request.responseText);
        """),format.raw/*20.9*/("""}"""),format.raw/*20.10*/("""
      """),format.raw/*21.7*/("""}"""),format.raw/*21.8*/(""");
    """),format.raw/*22.5*/("""}"""),format.raw/*22.6*/("""
    
    """),format.raw/*24.5*/("""function startActiveLearning() """),format.raw/*24.36*/("""{"""),format.raw/*24.37*/("""
      """),format.raw/*25.7*/("""window.location = "activeLearn"
    """),format.raw/*26.5*/("""}"""),format.raw/*26.6*/("""
  """),format.raw/*27.3*/("""</script>
""")))};def /*30.2*/toolbar/*30.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any]())};def /*32.2*/content/*32.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*32.13*/("""
  """),_display_(/*33.4*/if(false)/*33.13*/ {_display_(Seq[Any](format.raw/*33.15*/(""" """),format.raw/*33.157*/("""
    """),format.raw/*34.5*/("""<span>
      There are already """),_display_(/*35.26*/context/*35.33*/.task.data.referenceLinks.positive.size),format.raw/*35.72*/(""" """),format.raw/*35.73*/("""positive and """),_display_(/*35.87*/context/*35.94*/.task.data.referenceLinks.positive.size),format.raw/*35.133*/(""" """),format.raw/*35.134*/("""negative reference links.
      Start learning a linkage rules from existing reference links: 
      <button class="mdl-button mdl-js-button mdl-button--raised" onClick="startLearning()">Start</button>
      <br/>
      Start with existing reference links but find new reference links:
      <button class="mdl-button mdl-js-button mdl-button--raised" onClick="startActiveLearning()">Start</button>
    </span>
  """)))}/*42.5*/else/*42.10*/{_display_(Seq[Any](format.raw/*42.11*/("""
    """),format.raw/*43.5*/("""<span>
      Start active learning: 
      <button class="mdl-button mdl-js-button mdl-button--raised" onClick="startActiveLearning()">Start</button>
    </span>
  """)))}),format.raw/*47.4*/("""
""")))};
Seq[Any](format.raw/*5.1*/("""
"""),format.raw/*28.2*/("""

"""),format.raw/*30.14*/("""

"""),format.raw/*48.2*/("""

"""),_display_(/*50.2*/main(Some(context), titleLabel = context.task.taskLabel())/*50.60*/(header)/*50.68*/(toolbar)/*50.77*/(content)))
      }
    }
  }

  def render(context:Context[LinkSpec],session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(context)(session)

  def f:((Context[LinkSpec]) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (context) => (session) => apply(context)(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/learning/start.scala.html
                  HASH: 4bb53625b905dbd9274daa447446815ccdc316e4
                  MATRIX: 441->1|487->41|866->86|1012->157|1025->163|1105->167|1134->170|1212->222|1226->228|1254->236|1296->252|1311->259|1344->272|1372->274|1387->281|1415->289|1476->322|1505->323|1539->330|1574->337|1603->338|1639->347|1774->454|1803->455|1842->466|1903->500|1932->501|1995->536|2024->537|2063->548|2127->585|2156->586|2190->593|2218->594|2252->601|2280->602|2317->612|2376->643|2405->644|2439->651|2502->687|2530->688|2560->691|2594->705|2609->712|2687->720|2702->727|2783->731|2813->735|2831->744|2871->746|2901->888|2933->893|2992->925|3008->932|3068->971|3097->972|3138->986|3154->993|3215->1032|3245->1033|3677->1448|3690->1453|3729->1454|3761->1459|3956->1624|3996->155|4024->702|4054->717|4083->1626|4112->1629|4179->1687|4196->1695|4214->1704
                  LINES: 17->1|18->2|23->4|27->6|27->6|29->6|30->7|31->8|31->8|31->8|31->8|31->8|31->8|31->8|31->8|31->8|33->10|33->10|34->11|34->11|34->11|35->12|38->15|38->15|39->16|40->17|40->17|41->18|41->18|42->19|43->20|43->20|44->21|44->21|45->22|45->22|47->24|47->24|47->24|48->25|49->26|49->26|50->27|51->30|51->30|53->32|53->32|55->32|56->33|56->33|56->33|56->33|57->34|58->35|58->35|58->35|58->35|58->35|58->35|58->35|58->35|65->42|65->42|65->42|66->43|70->47|72->5|73->28|75->30|77->48|79->50|79->50|79->50|79->50
                  -- GENERATED --
              */
          