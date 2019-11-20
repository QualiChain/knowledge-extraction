
package views.html.workspace

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

object removeTaskDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,String,String,Seq[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(project: String, task: String, taskLabel: String, dependentTaskLabels: Seq[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/if(dependentTaskLabels.isEmpty)/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""

  """),_display_(/*5.4*/widgets/*5.11*/.dialog(title = "Delete task", submitLabel = "Yes, delete it")/*5.73*/ {_display_(Seq[Any](format.raw/*5.75*/("""
    """),format.raw/*6.5*/("""<p>
      Delete task: <span class="delete-dialog-resource">"""),_display_(/*7.58*/taskLabel),format.raw/*7.67*/("""</span>
    </p>

    <script type="text/javascript">//<![CDATA[
      function submit() """),format.raw/*11.25*/("""{"""),format.raw/*11.26*/("""
        """),format.raw/*12.9*/("""deleteTask('"""),_display_(/*12.22*/project),format.raw/*12.29*/("""', '"""),_display_(/*12.34*/task),format.raw/*12.38*/("""');
        closeDialog();
      """),format.raw/*14.7*/("""}"""),format.raw/*14.8*/("""
    """),format.raw/*15.5*/("""//]]></script>
  """)))}),format.raw/*16.4*/("""

""")))}/*18.3*/else/*18.8*/{_display_(Seq[Any](format.raw/*18.9*/("""

  """),_display_(/*20.4*/widgets/*20.11*/.dialog(title = "Cannot delete task", submitLabel = "Ok")/*20.68*/ {_display_(Seq[Any](format.raw/*20.70*/("""
    """),format.raw/*21.5*/("""<p>
      Cannot delete task <span class="delete-dialog-resource">"""),_display_(/*22.64*/taskLabel),format.raw/*22.73*/("""</span>, because the following tasks depend on it:
      <ul>
      """),_display_(/*24.8*/for(dependentTaskLabel <- dependentTaskLabels) yield /*24.54*/ {_display_(Seq[Any](format.raw/*24.56*/("""
        """),format.raw/*25.9*/("""<li>"""),_display_(/*25.14*/dependentTaskLabel),format.raw/*25.32*/("""</li>
      """)))}),format.raw/*26.8*/("""
      """),format.raw/*27.7*/("""</ul>
    </p>

    <script type="text/javascript">//<![CDATA[
      function submit() """),format.raw/*31.25*/("""{"""),format.raw/*31.26*/("""
        """),format.raw/*32.9*/("""closeDialog();
      """),format.raw/*33.7*/("""}"""),format.raw/*33.8*/("""
    """),format.raw/*34.5*/("""//]]></script>
  """)))}),format.raw/*35.4*/("""

""")))}))
      }
    }
  }

  def render(project:String,task:String,taskLabel:String,dependentTaskLabels:Seq[String]): play.twirl.api.HtmlFormat.Appendable = apply(project,task,taskLabel,dependentTaskLabels)

  def f:((String,String,String,Seq[String]) => play.twirl.api.HtmlFormat.Appendable) = (project,task,taskLabel,dependentTaskLabels) => apply(project,task,taskLabel,dependentTaskLabels)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/removeTaskDialog.scala.html
                  HASH: 7605a21da9467abf4ce1fb5c1063c68b0c8da532
                  MATRIX: 776->1|954->86|981->88|1020->119|1059->121|1089->126|1104->133|1174->195|1213->197|1244->202|1331->263|1360->272|1477->361|1506->362|1542->371|1582->384|1610->391|1642->396|1667->400|1727->433|1755->434|1787->439|1835->457|1856->461|1868->466|1906->467|1937->472|1953->479|2019->536|2059->538|2091->543|2185->610|2215->619|2310->688|2372->734|2412->736|2448->745|2480->750|2519->768|2562->781|2596->788|2711->875|2740->876|2776->885|2824->906|2852->907|2884->912|2932->930
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|29->5|29->5|29->5|30->6|31->7|31->7|35->11|35->11|36->12|36->12|36->12|36->12|36->12|38->14|38->14|39->15|40->16|42->18|42->18|42->18|44->20|44->20|44->20|44->20|45->21|46->22|46->22|48->24|48->24|48->24|49->25|49->25|49->25|50->26|51->27|55->31|55->31|56->32|57->33|57->33|58->34|59->35
                  -- GENERATED --
              */
          