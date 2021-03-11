
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("FuhSen")/*1.16*/ {_display_(Seq[Any](format.raw/*1.18*/("""
    """),format.raw/*2.5*/("""<div class="col-md-12">
        Running!!!
    </div>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Sun Aug 04 15:02:30 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/data-acquisition-service/app/views/index.scala.html
                  HASH: 91e703ec270cdbd7503867ffd64dd7f04be62285
                  MATRIX: 609->1|631->15|670->17|701->22
                  LINES: 25->1|25->1|25->1|26->2
                  -- GENERATED --
              */
          