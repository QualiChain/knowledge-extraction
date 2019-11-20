
package views.html.referenceLinks

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

object removeLinksDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(project: String, task: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""
"""),_display_(/*5.2*/widgets/*5.9*/.dialog(title = "Remove Reference Links", submitLabel = "Delete")/*5.74*/ {_display_(Seq[Any](format.raw/*5.76*/("""
  """),format.raw/*6.3*/("""<table border="0">
    <tr>
      <td>
        <input type="checkbox" id="removePositive"><label for="removePositive">Positive</label>
        <input type="checkbox" id="removeNegative"><label for="removeNegative">Negative</label>
        <input type="checkbox" id="removeUnlabeled"><label for="removeUnlabeled">Unlabeled</label>
      </td>
      <td></td>
    </tr>
  </table>

  <script type="text/javascript">
  function submit() """),format.raw/*18.21*/("""{"""),format.raw/*18.22*/("""
    """),format.raw/*19.5*/("""var clearPositive = $("input[id='removePositive']").prop('checked');
    var clearNegative = $("input[id='removeNegative']").prop('checked');
    var clearUnlabeled = $("input[id='removeUnlabeled']").prop('checked');

    $.ajax("""),format.raw/*23.12*/("""{"""),format.raw/*23.13*/("""
      """),format.raw/*24.7*/("""type: 'DELETE',
      url: '"""),_display_(/*25.14*/config/*25.20*/.baseUrl),format.raw/*25.28*/("""/linking/tasks/"""),_display_(/*25.44*/project),format.raw/*25.51*/("""/"""),_display_(/*25.53*/task),format.raw/*25.57*/("""/referenceLinks?positive=' + clearPositive + '&negative=' + clearNegative + '&unlabeled=' + clearUnlabeled,
      success: function(data) """),format.raw/*26.31*/("""{"""),format.raw/*26.32*/("""
        """),format.raw/*27.9*/("""window.location.reload();
      """),format.raw/*28.7*/("""}"""),format.raw/*28.8*/(""",
      error: function(request) """),format.raw/*29.32*/("""{"""),format.raw/*29.33*/("""
        """),format.raw/*30.9*/("""alert(request.responseText);
      """),format.raw/*31.7*/("""}"""),format.raw/*31.8*/("""
    """),format.raw/*32.5*/("""}"""),format.raw/*32.6*/(""");
  """),format.raw/*33.3*/("""}"""),format.raw/*33.4*/("""
  """),format.raw/*34.3*/("""</script>
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
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/referenceLinks/removeLinksDialog.scala.html
                  HASH: c57f0839f10473aeb89687d55962506846e277d0
                  MATRIX: 447->1|804->37|929->69|956->71|970->78|1043->143|1082->145|1111->148|1573->582|1602->583|1634->588|1891->817|1920->818|1954->825|2010->854|2025->860|2054->868|2097->884|2125->891|2154->893|2179->897|2345->1035|2374->1036|2410->1045|2469->1077|2497->1078|2558->1111|2587->1112|2623->1121|2685->1156|2713->1157|2745->1162|2773->1163|2805->1168|2833->1169|2863->1172
                  LINES: 17->1|22->3|27->4|28->5|28->5|28->5|28->5|29->6|41->18|41->18|42->19|46->23|46->23|47->24|48->25|48->25|48->25|48->25|48->25|48->25|48->25|49->26|49->26|50->27|51->28|51->28|52->29|52->29|53->30|54->31|54->31|55->32|55->32|56->33|56->33|57->34
                  -- GENERATED --
              */
          