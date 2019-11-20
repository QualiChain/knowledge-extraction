
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

object dialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[String,Int,String,String,Boolean,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(title: String,
    width: Int = 700,
    submitLabel: String = "OK",
    secondaryLabel: String = "Secondary Button",
    createDialog: Boolean = true)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*8.1*/("""<div class="mdl-dialog__modalbackground"></div>
<div class="mdl-card mdl-card--stretch mdl-shadow--16dp mdl-dialog mdl-dialog--modal mdl-dialog--large is-activated">
  <div class="mdl-card__title mdl-card--border mdl-dialog__title">
    <h1 class="mdl-card__title-text">"""),_display_(/*11.39*/title),format.raw/*11.44*/("""</h1>
    <div id="dialog-progress-spinner" class="mdl-spinner mdl-spinner--single-color mdl-js-spinner is-active"></div>
  </div>
  <div class="dialog__error-msg">
    <div class="mdl-alert mdl-alert--danger mdl-alert--border mdl-alert--spacing">
      <div class="mdl-alert__content">
        Error message.
      </div>
    </div>
  </div>
  <form id="dialog-form" action="javascript:submit();" enctype="multipart/form-data">
    <div class="mdl-card__content mdl-dialog__content">
    """),_display_(/*23.6*/content),format.raw/*23.13*/("""
    """),format.raw/*24.5*/("""</div>
    <div class="mdl-card__actions mdl-card--border mdl-dialog__actions">
      <button id="dialog-submit-button" type="submit" class="mdl-button mdl-js-button mdl-button--accent">"""),_display_(/*26.108*/submitLabel),format.raw/*26.119*/("""</button>
      <button id="dialog-secondary-button" type="button" class="mdl-button mdl-js-button mdl-button--accent" style="display: none;">"""),_display_(/*27.134*/secondaryLabel),format.raw/*27.148*/("""</button>
      """),_display_(/*28.8*/if(createDialog)/*28.24*/ {_display_(Seq[Any](format.raw/*28.26*/("""
        """),format.raw/*29.9*/("""<button id="dialog-cancel-button" type="button" class="mdl-button mdl-js-button mdl-button--accent close">Cancel</button>
      """)))}/*30.9*/else/*30.14*/{_display_(Seq[Any](format.raw/*30.15*/("""
        """),format.raw/*31.9*/("""<button id="dialog-cancel-button" type="button" class="mdl-button mdl-js-button mdl-button--accent close" autofocus>Cancel</button>
      """)))}),format.raw/*32.8*/("""
    """),format.raw/*33.5*/("""</div>
  </form>
  <script type="text/javascript">
    if (primary_dialog) """),format.raw/*36.25*/("""{"""),format.raw/*36.26*/("""
      """),format.raw/*37.7*/("""var closeButton = primary_dialog.querySelector('.close');
      if(closeButton) """),format.raw/*38.23*/("""{"""),format.raw/*38.24*/("""
        """),format.raw/*39.9*/("""closeButton.addEventListener('click', function () """),format.raw/*39.59*/("""{"""),format.raw/*39.60*/("""
          """),format.raw/*40.11*/("""primary_dialog.close();
        """),format.raw/*41.9*/("""}"""),format.raw/*41.10*/(""");
      """),format.raw/*42.7*/("""}"""),format.raw/*42.8*/("""
      """),format.raw/*43.7*/("""var secondaryButton = primary_dialog.querySelector('#dialog-secondary-button');
      if(secondaryButton) """),format.raw/*44.27*/("""{"""),format.raw/*44.28*/("""
        """),format.raw/*45.9*/("""secondaryButton.addEventListener('click', function () """),format.raw/*45.63*/("""{"""),format.raw/*45.64*/("""
          """),format.raw/*46.11*/("""dialog_secondary();
        """),format.raw/*47.9*/("""}"""),format.raw/*47.10*/(""");
      """),format.raw/*48.7*/("""}"""),format.raw/*48.8*/("""
    """),format.raw/*49.5*/("""}"""),format.raw/*49.6*/("""
    """),format.raw/*50.5*/("""if (secondary_dialog) """),format.raw/*50.27*/("""{"""),format.raw/*50.28*/("""
      """),format.raw/*51.7*/("""var closeButton = secondary_dialog.querySelector('.close');
      if(closeButton) """),format.raw/*52.23*/("""{"""),format.raw/*52.24*/("""
        """),format.raw/*53.9*/("""closeButton.addEventListener('click', function () """),format.raw/*53.59*/("""{"""),format.raw/*53.60*/("""
          """),format.raw/*54.11*/("""secondary_dialog.close();
        """),format.raw/*55.9*/("""}"""),format.raw/*55.10*/(""");
      """),format.raw/*56.7*/("""}"""),format.raw/*56.8*/("""
      """),format.raw/*57.7*/("""var secondaryButton = secondary_dialog.querySelector('#dialog-secondary-button');
      if(secondaryButton) """),format.raw/*58.27*/("""{"""),format.raw/*58.28*/("""
        """),format.raw/*59.9*/("""secondaryButton.addEventListener('click', function () """),format.raw/*59.63*/("""{"""),format.raw/*59.64*/("""
          """),format.raw/*60.11*/("""dialog_secondary();
        """),format.raw/*61.9*/("""}"""),format.raw/*61.10*/(""");
      """),format.raw/*62.7*/("""}"""),format.raw/*62.8*/("""
    """),format.raw/*63.5*/("""}"""),format.raw/*63.6*/("""
    """),format.raw/*64.5*/("""$(".dialog__error-msg").on('click', function() """),format.raw/*64.52*/("""{"""),format.raw/*64.53*/(""" """),format.raw/*64.54*/("""$(this).fadeToggle(); """),format.raw/*64.76*/("""}"""),format.raw/*64.77*/(""");
  </script>
</div>
"""))
      }
    }
  }

  def render(title:String,width:Int,submitLabel:String,secondaryLabel:String,createDialog:Boolean,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,width,submitLabel,secondaryLabel,createDialog)(content)

  def f:((String,Int,String,String,Boolean) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title,width,submitLabel,secondaryLabel,createDialog) => (content) => apply(title,width,submitLabel,secondaryLabel,createDialog)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/widgets/dialog.scala.html
                  HASH: 1c138c02fabde7dbc6a14a185532410415f87be6
                  MATRIX: 769->2|1030->170|1057->171|1355->442|1381->447|1897->937|1925->944|1957->949|2172->1136|2205->1147|2376->1290|2412->1304|2455->1321|2480->1337|2520->1339|2556->1348|2703->1478|2716->1483|2755->1484|2791->1493|2960->1632|2992->1637|3095->1712|3124->1713|3158->1720|3266->1800|3295->1801|3331->1810|3409->1860|3438->1861|3477->1872|3536->1904|3565->1905|3601->1914|3629->1915|3663->1922|3797->2028|3826->2029|3862->2038|3944->2092|3973->2093|4012->2104|4067->2132|4096->2133|4132->2142|4160->2143|4192->2148|4220->2149|4252->2154|4302->2176|4331->2177|4365->2184|4475->2266|4504->2267|4540->2276|4618->2326|4647->2327|4686->2338|4747->2372|4776->2373|4812->2382|4840->2383|4874->2390|5010->2498|5039->2499|5075->2508|5157->2562|5186->2563|5225->2574|5280->2602|5309->2603|5345->2612|5373->2613|5405->2618|5433->2619|5465->2624|5540->2671|5569->2672|5598->2673|5648->2695|5677->2696
                  LINES: 21->2|30->7|31->8|34->11|34->11|46->23|46->23|47->24|49->26|49->26|50->27|50->27|51->28|51->28|51->28|52->29|53->30|53->30|53->30|54->31|55->32|56->33|59->36|59->36|60->37|61->38|61->38|62->39|62->39|62->39|63->40|64->41|64->41|65->42|65->42|66->43|67->44|67->44|68->45|68->45|68->45|69->46|70->47|70->47|71->48|71->48|72->49|72->49|73->50|73->50|73->50|74->51|75->52|75->52|76->53|76->53|76->53|77->54|78->55|78->55|79->56|79->56|80->57|81->58|81->58|82->59|82->59|82->59|83->60|84->61|84->61|85->62|85->62|86->63|86->63|87->64|87->64|87->64|87->64|87->64|87->64
                  -- GENERATED --
              */
          