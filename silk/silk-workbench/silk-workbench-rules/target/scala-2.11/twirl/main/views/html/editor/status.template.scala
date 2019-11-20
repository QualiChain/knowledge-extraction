
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

object status extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /*
 * A small toolbar icon that displays the current status of the editor.
 * Displays messages and errors in the current rule.
 *
 * Messages are added using the following function:
 * updateStatus(errorMessages, warningMessages, infoMessages)
 *
 */
  def apply/*9.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*10.1*/("""
"""),format.raw/*11.1*/("""<div id="validation-icons">
  <div id="tick" class="material-icons">done</div>
  <div class="mdl-tooltip mdl-tooltip--large" for="tick">Validated successfully.</div>
  <div id="error-icons">
    <div id="exclamation" class="material-icons mdl-badge mdl-badge--overlap" data-badge="0" style="display: none;">error</div>
    <div id="warning" class="material-icons mdl-badge mdl-badge--overlap" data-badge="0" style="display: none;">warning</div>
  </div>
  <div id="error-tooltip" class="mdl-tooltip mdl-tooltip--large mdl-tooltip--left" for="error-icons">Errors.</div>
</div>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/status.scala.html
                  HASH: 78c5eb025fbb413a99e988dd7d4c529ada5e2c70
                  MATRIX: 977->253|1074->256|1102->257
                  LINES: 28->9|33->10|34->11
                  -- GENERATED --
              */
          