
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html lang="en">
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
    </head>
    <body>
        """),_display_(/*10.10*/content),format.raw/*10.17*/("""
    """),format.raw/*11.5*/("""</body>
</html>"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Sun Aug 04 15:02:30 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/data-acquisition-service/app/views/main.scala.html
                  HASH: 441202c50c8fedc2eb57a5cefe73770ad15f9868
                  MATRIX: 530->1|655->31|683->33|770->94|795->99|863->140|891->147|923->152
                  LINES: 20->1|25->1|27->3|31->7|31->7|34->10|34->10|35->11
                  -- GENERATED --
              */
          