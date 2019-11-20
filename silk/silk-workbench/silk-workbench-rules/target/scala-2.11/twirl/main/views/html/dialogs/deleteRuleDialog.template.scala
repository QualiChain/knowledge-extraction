
package views.html.dialogs

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

object deleteRuleDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ruleName: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/widgets/*3.9*/.dialog(title = "Delete", submitLabel = "Yes, delete it")/*3.66*/ {_display_(Seq[Any](format.raw/*3.68*/("""

"""),format.raw/*5.1*/("""<p>
  Delete rule: <span class="delete-dialog-resource">"""),_display_(/*6.54*/ruleName),format.raw/*6.62*/("""</span>
</p>
<p>This action cannot be undone!</p>

  <script type="text/javascript">//<![CDATA[

    function submit() """),format.raw/*12.23*/("""{"""),format.raw/*12.24*/("""
      """),format.raw/*13.7*/("""var ruleElement = $('#"""),_display_(/*13.30*/ruleName),format.raw/*13.38*/("""');
      if (!ruleElement.hasClass("typeMapping")) """),format.raw/*14.49*/("""{"""),format.raw/*14.50*/("""
        """),format.raw/*15.9*/("""ruleElement = ruleElement.parent();
      """),format.raw/*16.7*/("""}"""),format.raw/*16.8*/("""
      """),format.raw/*17.7*/("""ruleElement.remove();
      if ('"""),_display_(/*18.13*/ruleName),format.raw/*18.21*/("""' == 'uri') """),format.raw/*18.33*/("""{"""),format.raw/*18.34*/("""
        """),format.raw/*19.9*/("""showURIMapping(false);
      """),format.raw/*20.7*/("""}"""),format.raw/*20.8*/("""
      """),format.raw/*21.7*/("""modified();
      closeDialog();
    """),format.raw/*23.5*/("""}"""),format.raw/*23.6*/("""

  """),format.raw/*25.3*/("""//]]>
  </script>
""")))}))
      }
    }
  }

  def render(ruleName:String): play.twirl.api.HtmlFormat.Appendable = apply(ruleName)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (ruleName) => apply(ruleName)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/dialogs/deleteRuleDialog.scala.html
                  HASH: 337db0f67cfdcefeffef2c13b19e6e66e219df74
                  MATRIX: 748->1|860->20|887->22|901->29|966->86|1005->88|1033->90|1116->147|1144->155|1291->274|1320->275|1354->282|1404->305|1433->313|1513->365|1542->366|1578->375|1647->417|1675->418|1709->425|1770->459|1799->467|1839->479|1868->480|1904->489|1960->518|1988->519|2022->526|2086->563|2114->564|2145->568
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|29->5|30->6|30->6|36->12|36->12|37->13|37->13|37->13|38->14|38->14|39->15|40->16|40->16|41->17|42->18|42->18|42->18|42->18|43->19|44->20|44->20|45->21|47->23|47->23|49->25
                  -- GENERATED --
              */
          