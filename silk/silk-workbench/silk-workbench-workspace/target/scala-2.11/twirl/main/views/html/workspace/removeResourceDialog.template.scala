
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

object removeResourceDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(name: String, path: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/widgets/*3.9*/.dialog(title = "Delete", submitLabel = "Yes, delete it")/*3.66*/ {_display_(Seq[Any](format.raw/*3.68*/("""

"""),format.raw/*5.1*/("""<p>
  Delete resource: <span class="delete-dialog-resource">"""),_display_(/*6.58*/name),format.raw/*6.62*/("""</span>
</p>

  <script type="text/javascript">//<![CDATA[

    function submit() """),format.raw/*11.23*/("""{"""),format.raw/*11.24*/("""
      """),format.raw/*12.7*/("""var path = decodeURIComponent(""""),_display_(/*12.39*/path),format.raw/*12.43*/("""");
      $.ajax("""),format.raw/*13.14*/("""{"""),format.raw/*13.15*/("""
        """),format.raw/*14.9*/("""type: 'DELETE',
        url: path,
        success: function(data) """),format.raw/*16.33*/("""{"""),format.raw/*16.34*/("""
          """),format.raw/*17.11*/("""closeDialog("secondary");
          reloadDialog("primary");
        """),format.raw/*19.9*/("""}"""),format.raw/*19.10*/(""",
        error: function(request) """),format.raw/*20.34*/("""{"""),format.raw/*20.35*/("""
          """),format.raw/*21.11*/("""alert(request.responseText);
        """),format.raw/*22.9*/("""}"""),format.raw/*22.10*/("""
      """),format.raw/*23.7*/("""}"""),format.raw/*23.8*/(""");
    """),format.raw/*24.5*/("""}"""),format.raw/*24.6*/("""

  """),format.raw/*26.3*/("""//]]>
  </script>
""")))}))
      }
    }
  }

  def render(name:String,path:String): play.twirl.api.HtmlFormat.Appendable = apply(name,path)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (name,path) => apply(name,path)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/removeResourceDialog.scala.html
                  HASH: b5a335af1ebd55626c6a8458de5b367936ca94a7
                  MATRIX: 761->1|883->30|910->32|924->39|989->96|1028->98|1056->100|1143->161|1167->165|1277->247|1306->248|1340->255|1399->287|1424->291|1469->308|1498->309|1534->318|1629->385|1658->386|1697->397|1793->466|1822->467|1885->502|1914->503|1953->514|2017->551|2046->552|2080->559|2108->560|2142->567|2170->568|2201->572
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|29->5|30->6|30->6|35->11|35->11|36->12|36->12|36->12|37->13|37->13|38->14|40->16|40->16|41->17|43->19|43->19|44->20|44->20|45->21|46->22|46->22|47->23|47->23|48->24|48->24|50->26
                  -- GENERATED --
              */
          