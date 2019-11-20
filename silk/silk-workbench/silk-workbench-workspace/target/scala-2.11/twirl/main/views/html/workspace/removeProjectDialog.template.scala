
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

object removeProjectDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(project: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/widgets/*3.9*/.dialog(title = "Delete Project", submitLabel = "Yes, delete it")/*3.74*/ {_display_(Seq[Any](format.raw/*3.76*/("""

"""),format.raw/*5.1*/("""<p>
  Delete project: <span class="delete-dialog-resource">"""),_display_(/*6.57*/project),format.raw/*6.64*/("""</span>
</p>

  <script type="text/javascript">//<![CDATA[

    function submit() """),format.raw/*11.23*/("""{"""),format.raw/*11.24*/("""
      """),format.raw/*12.7*/("""deleteProject('"""),_display_(/*12.23*/project),format.raw/*12.30*/("""');
      closeDialog();
    """),format.raw/*14.5*/("""}"""),format.raw/*14.6*/("""

  """),format.raw/*16.3*/("""//]]>
  </script>
""")))}))
      }
    }
  }

  def render(project:String): play.twirl.api.HtmlFormat.Appendable = apply(project)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (project) => apply(project)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/removeProjectDialog.scala.html
                  HASH: 63f2bd74a38cf762446892b82522d107c1582812
                  MATRIX: 753->1|864->19|891->21|905->28|978->93|1017->95|1045->97|1131->157|1158->164|1268->246|1297->247|1331->254|1374->270|1402->277|1458->306|1486->307|1517->311
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|29->5|30->6|30->6|35->11|35->11|36->12|36->12|36->12|38->14|38->14|40->16
                  -- GENERATED --
              */
          