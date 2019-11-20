
package views.html.learning

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
/*1.2*/import controllers.linking.routes

object resetDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(project: String, task: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""
"""),_display_(/*5.2*/widgets/*5.9*/.dialog(title = "Reset active learning", submitLabel = "Reset")/*5.72*/ {_display_(Seq[Any](format.raw/*5.74*/("""
"""),format.raw/*6.1*/("""<div>
  This will remove all reference links from this task and restart active learning!
</div>

  <script type="text/javascript">
  function submit() """),format.raw/*11.21*/("""{"""),format.raw/*11.22*/("""
    """),format.raw/*12.5*/("""$.ajax("""),format.raw/*12.12*/("""{"""),format.raw/*12.13*/("""
      """),format.raw/*13.7*/("""type: 'POST',
      url: '"""),_display_(/*14.14*/routes/*14.20*/.Learning.resetActiveLearning(project, task)),format.raw/*14.64*/("""',
      success: function(data) """),format.raw/*15.31*/("""{"""),format.raw/*15.32*/("""
        """),format.raw/*16.9*/("""closeDialog();
        showLinkCandidate();
      """),format.raw/*18.7*/("""}"""),format.raw/*18.8*/(""",
      error: function(request) """),format.raw/*19.32*/("""{"""),format.raw/*19.33*/("""
        """),format.raw/*20.9*/("""alert(request.responseText);
      """),format.raw/*21.7*/("""}"""),format.raw/*21.8*/("""
    """),format.raw/*22.5*/("""}"""),format.raw/*22.6*/(""");
  """),format.raw/*23.3*/("""}"""),format.raw/*23.4*/("""
  """),format.raw/*24.3*/("""</script>
""")))}))
      }
    }
  }

  def render(project:String,task:String): play.twirl.api.HtmlFormat.Appendable = apply(project,task)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (project,task) => apply(project,task)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/learning/resetDialog.scala.html
                  HASH: 3a65304e65d21759e6e852b463ad8d483a3b0a10
                  MATRIX: 441->1|792->37|917->69|944->71|958->78|1029->141|1068->143|1095->144|1274->295|1303->296|1335->301|1370->308|1399->309|1433->316|1487->343|1502->349|1567->393|1628->426|1657->427|1693->436|1770->486|1798->487|1859->520|1888->521|1924->530|1986->565|2014->566|2046->571|2074->572|2106->577|2134->578|2164->581
                  LINES: 17->1|22->3|27->4|28->5|28->5|28->5|28->5|29->6|34->11|34->11|35->12|35->12|35->12|36->13|37->14|37->14|37->14|38->15|38->15|39->16|41->18|41->18|42->19|42->19|43->20|44->21|44->21|45->22|45->22|46->23|46->23|47->24
                  -- GENERATED --
              */
          