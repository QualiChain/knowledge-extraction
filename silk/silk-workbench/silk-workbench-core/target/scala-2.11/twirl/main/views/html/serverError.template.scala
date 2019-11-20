
package views.html

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
/*1.2*/import play.api.UsefulException

object serverError extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[UsefulException,play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(exception: UsefulException)(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*64.2*/stacktrace/*64.12*/(ex: Throwable):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*64.31*/("""
  """),format.raw/*65.3*/("""<p class="error-details-stacktrace">
  """),_display_(/*66.4*/for(el <- ex.getStackTrace) yield /*66.31*/ {_display_(Seq[Any](format.raw/*66.33*/("""
    """),_display_(/*67.6*/el/*67.8*/.toString),format.raw/*67.17*/("""
    """),format.raw/*68.5*/("""<br/>
  """)))}),format.raw/*69.4*/("""
  """),format.raw/*70.3*/("""</p>
  """),_display_(/*71.4*/if(ex.getCause != null)/*71.27*/ {_display_(Seq[Any](format.raw/*71.29*/("""
    """),format.raw/*72.5*/("""<strong>Cause:</strong>
    """),_display_(/*73.6*/ex/*73.8*/.getCause.getMessage),format.raw/*73.28*/("""
    """),_display_(/*74.6*/stacktrace(ex.getCause)),format.raw/*74.29*/("""
  """)))}),format.raw/*75.4*/("""
""")))};
Seq[Any](format.raw/*4.1*/("""
"""),_display_(/*5.2*/frame/*5.7*/ {_display_(Seq[Any](format.raw/*5.9*/("""

""")))}/*7.2*/ {_display_(Seq[Any](format.raw/*7.4*/("""

  """),format.raw/*9.3*/("""<div class="mdl-grid mdl-grid--centered">
    <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
      <div class="mdl-card mdl-shadow--2dp mdl-card--stretch">
        <div class="mdl-card__title mdl-card--border">
          <h3 class="mdl-card__title-text">
            """),_display_(/*14.14*/exception/*14.23*/.title),format.raw/*14.29*/("""
          """),format.raw/*15.11*/("""</h3>
        </div>
        <div class="mdl-card__content">
          <div class="mdl-alert mdl-alert--danger mdl-alert--border mdl-alert--spacing">
            <div class="mdl-alert__content">
              <p>"""),_display_(/*20.19*/exception/*20.28*/.description),format.raw/*20.40*/("""</p>
            </div>
          </div>
          <div>
            This exception has been logged with id <strong>"""),_display_(/*24.61*/exception/*24.70*/.id),format.raw/*24.73*/("""</strong>.
          </div>
          <div class="error-details-buttons">
            <button class="mdl-button mdl-js-button mdl-button--raised">
              Show Details
            </button>
            <button class="mdl-button mdl-js-button mdl-button--raised" style="display: none;">
              Hide Details
            </button>
          </div>

        </div>
        <div class="error-details" style="display: none;">
          <h4>Details:</h4>

          <div class="error-details-scrollbox">
            """),_display_(/*40.14*/for(cause <- Option(exception.cause)) yield /*40.51*/ {_display_(Seq[Any](format.raw/*40.53*/("""
            """),_display_(/*41.14*/stacktrace(exception.cause)),format.raw/*41.41*/("""
            """)))}),format.raw/*42.14*/("""
          """),format.raw/*43.11*/("""</div>
        </div>


      </div>
    </div>

  </div>
  <script type="text/javascript">
    $(function () """),format.raw/*52.19*/("""{"""),format.raw/*52.20*/("""
      """),format.raw/*53.7*/("""console.log("done!");
      $(".error-details-buttons button").click(function() """),format.raw/*54.59*/("""{"""),format.raw/*54.60*/("""
        """),format.raw/*55.9*/("""$(".error-details").slideToggle(300, function() """),format.raw/*55.57*/("""{"""),format.raw/*55.58*/("""
          """),format.raw/*56.11*/("""$(".error-details-buttons button").toggle();
        """),format.raw/*57.9*/("""}"""),format.raw/*57.10*/(""");
      """),format.raw/*58.7*/("""}"""),format.raw/*58.8*/(""");
    """),format.raw/*59.5*/("""}"""),format.raw/*59.6*/(""");
  </script>

""")))}),format.raw/*62.2*/("""

"""),format.raw/*76.2*/("""
"""))
      }
    }
  }

  def render(exception:UsefulException,session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(exception)(session)

  def f:((UsefulException) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (exception) => (session) => apply(exception)(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/serverError.scala.html
                  HASH: e1bd8b21dd6f7a15b4afc044a8cd919c8606f590
                  MATRIX: 432->1|804->35|951->1782|970->1792|1066->1811|1096->1814|1162->1854|1205->1881|1245->1883|1277->1889|1287->1891|1317->1900|1349->1905|1388->1914|1418->1917|1452->1925|1484->1948|1524->1950|1556->1955|1611->1984|1621->1986|1662->2006|1694->2012|1738->2035|1772->2039|1812->104|1839->106|1851->111|1889->113|1909->116|1947->118|1977->122|2287->405|2305->414|2332->420|2371->431|2611->644|2629->653|2662->665|2806->782|2824->791|2848->794|3398->1317|3451->1354|3491->1356|3532->1370|3580->1397|3625->1411|3664->1422|3802->1532|3831->1533|3865->1540|3973->1620|4002->1621|4038->1630|4114->1678|4143->1679|4182->1690|4262->1743|4291->1744|4327->1753|4355->1754|4389->1761|4417->1762|4464->1779|4493->2041
                  LINES: 17->1|22->3|26->64|26->64|28->64|29->65|30->66|30->66|30->66|31->67|31->67|31->67|32->68|33->69|34->70|35->71|35->71|35->71|36->72|37->73|37->73|37->73|38->74|38->74|39->75|41->4|42->5|42->5|42->5|44->7|44->7|46->9|51->14|51->14|51->14|52->15|57->20|57->20|57->20|61->24|61->24|61->24|77->40|77->40|77->40|78->41|78->41|79->42|80->43|89->52|89->52|90->53|91->54|91->54|92->55|92->55|92->55|93->56|94->57|94->57|95->58|95->58|96->59|96->59|99->62|101->76
                  -- GENERATED --
              */
          