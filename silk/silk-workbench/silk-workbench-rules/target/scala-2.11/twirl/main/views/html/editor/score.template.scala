
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

object score extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(info: String = "", error: String = ""):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import controllers.rules.routes.Assets


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/if(!info.isEmpty)/*5.19*/ {_display_(Seq[Any](format.raw/*5.21*/(""" """),_display_(/*5.23*/info),format.raw/*5.27*/(""" """)))}),format.raw/*5.29*/("""
"""),_display_(/*6.2*/if(!error.isEmpty)/*6.20*/ {_display_(Seq[Any](format.raw/*6.22*/(""" """),format.raw/*6.23*/("""<img src=""""),_display_(/*6.34*/Assets/*6.40*/.at("img/help.png")),format.raw/*6.59*/("""" style="cursor:help;" title=""""),_display_(/*6.90*/error),format.raw/*6.95*/(""""/> """)))}),format.raw/*6.100*/("""

"""))
      }
    }
  }

  def render(info:String,error:String): play.twirl.api.HtmlFormat.Appendable = apply(info,error)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (info,error) => apply(info,error)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/score.scala.html
                  HASH: b59dd0abcb38ed5aa5e7e72b244a866fd14875ba
                  MATRIX: 743->1|855->43|922->41|949->82|976->84|1001->101|1040->103|1068->105|1092->109|1124->111|1151->113|1177->131|1216->133|1244->134|1281->145|1295->151|1334->170|1391->201|1416->206|1452->211
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|29->5|29->5|29->5|30->6|30->6|30->6|30->6|30->6|30->6|30->6|30->6|30->6|30->6
                  -- GENERATED --
              */
          