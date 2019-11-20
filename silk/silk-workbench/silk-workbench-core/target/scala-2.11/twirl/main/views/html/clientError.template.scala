
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

object clientError extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(errorMessage: String)(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*3.2*/header/*3.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.12*/(""" """)))};def /*5.2*/toolbar/*5.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.13*/(""" """)))};def /*7.2*/content/*7.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.13*/("""
  """),format.raw/*8.3*/("""<div class="mdl-grid mdl-grid--centered">
    <div class="mdl-cell mdl-cell--6-col mdl-cell--8-col-tablet">
      <div class="mdl-card mdl-shadow--2dp mdl-card--stretch">
        <div class="mdl-card__title mdl-card--border">
          <h3 class="mdl-card__title-text">
            Error
          </h3>
        </div>
        <div class="mdl-card__content">
          <div class="mdl-alert mdl-alert--danger mdl-alert--border mdl-alert--spacing">
            <div class="mdl-alert__content">
              <p>"""),_display_(/*19.19*/errorMessage),format.raw/*19.31*/("""</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
""")))};
Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.14*/("""

"""),format.raw/*5.15*/("""

"""),format.raw/*26.2*/("""

"""),_display_(/*28.2*/main(None, "")/*28.16*/(header)/*28.24*/(toolbar)/*28.33*/(content)/*28.42*/(session)),format.raw/*28.51*/("""
"""))
      }
    }
  }

  def render(errorMessage:String,session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(errorMessage)(session)

  def f:((String) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (errorMessage) => (session) => apply(errorMessage)(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/clientError.scala.html
                  HASH: 74ac2128a9f3a269c0963af3ec77672e81d5e9f5
                  MATRIX: 756->1|896->66|909->72|989->76|1013->81|1027->88|1107->92|1131->97|1145->104|1225->108|1254->111|1792->622|1825->634|1953->64|1981->78|2010->94|2039->724|2068->727|2091->741|2108->749|2126->758|2144->767|2174->776
                  LINES: 21->1|25->3|25->3|27->3|27->5|27->5|29->5|29->7|29->7|31->7|32->8|43->19|43->19|51->2|52->3|54->5|56->26|58->28|58->28|58->28|58->28|58->28|58->28
                  -- GENERATED --
              */
          