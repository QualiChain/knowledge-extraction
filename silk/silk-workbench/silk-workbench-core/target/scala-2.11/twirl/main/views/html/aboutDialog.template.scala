
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
/*1.2*/import config.WorkbenchConfig

object aboutDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""
"""),_display_(/*5.2*/widgets/*5.9*/.dialog(title = "About", width = 500)/*5.46*/ {_display_(Seq[Any](format.raw/*5.48*/("""
  """),format.raw/*6.3*/("""<div id="about_dialog" style="background:url('"""),_display_(/*6.50*/controllers/*6.61*/.core.routes.Branding.logo),format.raw/*6.87*/("""') no-repeat right 30px">
    <p>"""),_display_(/*7.9*/WorkbenchConfig/*7.24*/.get.title),format.raw/*7.34*/(""", """),_display_(/*7.37*/WorkbenchConfig/*7.52*/.version),format.raw/*7.60*/("""</p>
    """),_display_(/*8.6*/content),format.raw/*8.13*/("""
  """),format.raw/*9.3*/("""</div>
  <script type="text/javascript">
    $(function() """),format.raw/*11.18*/("""{"""),format.raw/*11.19*/("""
      """),format.raw/*12.7*/("""$("#dialog-cancel-button").hide();
    """),format.raw/*13.5*/("""}"""),format.raw/*13.6*/(""");

    function submit() """),format.raw/*15.23*/("""{"""),format.raw/*15.24*/("""
      """),format.raw/*16.7*/("""closeDialog();
    """),format.raw/*17.5*/("""}"""),format.raw/*17.6*/("""
  """),format.raw/*18.3*/("""</script>
""")))}))
      }
    }
  }

  def render(content:Html): play.twirl.api.HtmlFormat.Appendable = apply(content)

  def f:((Html) => play.twirl.api.HtmlFormat.Appendable) = (content) => apply(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/aboutDialog.scala.html
                  HASH: 69096567bcfb2a03d12449cc37f0a764ca319291
                  MATRIX: 432->1|770->33|879->49|906->51|920->58|965->95|1004->97|1033->100|1106->147|1125->158|1171->184|1230->218|1253->233|1283->243|1312->246|1335->261|1363->269|1398->279|1425->286|1454->289|1540->347|1569->348|1603->355|1669->394|1697->395|1751->421|1780->422|1814->429|1860->448|1888->449|1918->452
                  LINES: 17->1|22->3|27->4|28->5|28->5|28->5|28->5|29->6|29->6|29->6|29->6|30->7|30->7|30->7|30->7|30->7|30->7|31->8|31->8|32->9|34->11|34->11|35->12|36->13|36->13|38->15|38->15|39->16|40->17|40->17|41->18
                  -- GENERATED --
              */
          