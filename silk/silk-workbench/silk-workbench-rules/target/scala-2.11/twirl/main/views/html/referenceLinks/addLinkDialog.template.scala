
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

object addLinkDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(project: String, task: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/widgets/*3.9*/.dialog(title = "Add Reference Links", width = 500)/*3.60*/ {_display_(Seq[Any](format.raw/*3.62*/("""
  """),format.raw/*4.3*/("""<table border="0">
    <tr>
      <td>Source</td>
      <td>
        <input name="source" title="Source" size="40"/>
      </td>
    </tr>
    <tr>
      <td>Target</td>
      <td>
        <input name="target" title="Target" size="40"/>
      </td>
    </tr>
    <tr>
      <td>Type</td>
      <td>
        <select name="linktype" title="Reference link type">
          <option value="positive">Positive</option>
          <option value="negative">Negative</option>
          <option value="unlabeled">Unlabeled</option>
        </select>
      </td>
    </tr>
  </table>

  <script type="text/javascript">
  function submit() """),format.raw/*30.21*/("""{"""),format.raw/*30.22*/("""
    """),format.raw/*31.5*/("""var values = """),format.raw/*31.18*/("""{"""),format.raw/*31.19*/("""
      """),format.raw/*32.7*/("""source: $("input[name='source']").val(),
      target: $("input[name='target']").val(),
      type: $("select[name='linktype']").val()
    """),format.raw/*35.5*/("""}"""),format.raw/*35.6*/(""";

    $.ajax("""),format.raw/*37.12*/("""{"""),format.raw/*37.13*/("""
      """),format.raw/*38.7*/("""type: 'PUT',
      url: '"""),_display_(/*39.14*/config/*39.20*/.baseUrl),format.raw/*39.28*/("""/linking/tasks/"""),_display_(/*39.44*/project),format.raw/*39.51*/("""/"""),_display_(/*39.53*/task),format.raw/*39.57*/("""/referenceLink?linkType=' + values.type + '&source=' + encodeURIComponent(values.source) + '&target=' + encodeURIComponent(values.target),
      data: values,
      success: function(data) """),format.raw/*41.31*/("""{"""),format.raw/*41.32*/("""
        """),format.raw/*42.9*/("""window.location.reload();
      """),format.raw/*43.7*/("""}"""),format.raw/*43.8*/(""",
      error: function(request) """),format.raw/*44.32*/("""{"""),format.raw/*44.33*/("""
        """),format.raw/*45.9*/("""alert(request.responseText);
      """),format.raw/*46.7*/("""}"""),format.raw/*46.8*/("""
    """),format.raw/*47.5*/("""}"""),format.raw/*47.6*/(""");
  """),format.raw/*48.3*/("""}"""),format.raw/*48.4*/("""
  """),format.raw/*49.3*/("""</script>
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
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/referenceLinks/addLinkDialog.scala.html
                  HASH: 66c1b382b185bdec5a57c12b5ca4ade99ddbc7b7
                  MATRIX: 759->1|884->33|911->35|925->42|984->93|1023->95|1052->98|1707->725|1736->726|1768->731|1809->744|1838->745|1872->752|2038->891|2066->892|2108->906|2137->907|2171->914|2224->940|2239->946|2268->954|2311->970|2339->977|2368->979|2393->983|2610->1172|2639->1173|2675->1182|2734->1214|2762->1215|2823->1248|2852->1249|2888->1258|2950->1293|2978->1294|3010->1299|3038->1300|3070->1305|3098->1306|3128->1309
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|28->4|54->30|54->30|55->31|55->31|55->31|56->32|59->35|59->35|61->37|61->37|62->38|63->39|63->39|63->39|63->39|63->39|63->39|63->39|65->41|65->41|66->42|67->43|67->43|68->44|68->44|69->45|70->46|70->46|71->47|71->47|72->48|72->48|73->49
                  -- GENERATED --
              */
          