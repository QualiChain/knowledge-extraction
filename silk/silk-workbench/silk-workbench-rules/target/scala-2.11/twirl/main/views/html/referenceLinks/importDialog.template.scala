
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

object importDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(project: String, task: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/widgets/*3.9*/.dialog(title = "Import Reference Links", width = 500)/*3.63*/ {_display_(Seq[Any](format.raw/*3.65*/("""
  """),format.raw/*4.3*/("""<table border="0">
    <tr>
      <td>File</td>
      <td>
        <form enctype="multipart/form-data">
          <input name="file" type="file" size="10"/>
        </form>
      </td>
    </tr>
    <tr>
      <td></td>
      <td><input id="generateNegative" type="checkbox" ><label for="generateNegative">Generate Negative Links</label></td>
    </tr>
  </table>

  <script type="text/javascript">
    function submit() """),format.raw/*20.23*/("""{"""),format.raw/*20.24*/("""
      """),format.raw/*21.7*/("""var file = $("input[name='file']").val();
      var generateNegative = $("#generateNegative").is(':checked');
      var formData = new FormData($('form')[0]);

      $.ajax("""),format.raw/*25.14*/("""{"""),format.raw/*25.15*/("""
        """),format.raw/*26.9*/("""type: 'PUT',
        url: '"""),_display_(/*27.16*/config/*27.22*/.baseUrl),format.raw/*27.30*/("""/linking/tasks/"""),_display_(/*27.46*/project),format.raw/*27.53*/("""/"""),_display_(/*27.55*/task),format.raw/*27.59*/("""/referenceLinks?generateNegative=' + generateNegative,
        xhr: function() """),format.raw/*28.25*/("""{"""),format.raw/*28.26*/("""
          """),format.raw/*29.11*/("""myXhr = $.ajaxSettings.xhr();
          return myXhr;
        """),format.raw/*31.9*/("""}"""),format.raw/*31.10*/(""",
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        success: function(data) """),format.raw/*36.33*/("""{"""),format.raw/*36.34*/("""
          """),format.raw/*37.11*/("""$('.dialog').dialog('close');
          window.location.reload();
        """),format.raw/*39.9*/("""}"""),format.raw/*39.10*/(""",
        error: function(request) """),format.raw/*40.34*/("""{"""),format.raw/*40.35*/("""
          """),format.raw/*41.11*/("""alert(request.responseText);
        """),format.raw/*42.9*/("""}"""),format.raw/*42.10*/("""
      """),format.raw/*43.7*/("""}"""),format.raw/*43.8*/(""");
    """),format.raw/*44.5*/("""}"""),format.raw/*44.6*/("""
  """),format.raw/*45.3*/("""</script>
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
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/referenceLinks/importDialog.scala.html
                  HASH: 9c5a1e6ca379812d92adb729ebaa73387fb8317e
                  MATRIX: 758->1|883->33|910->35|924->42|986->96|1025->98|1054->101|1503->522|1532->523|1566->530|1767->703|1796->704|1832->713|1887->741|1902->747|1931->755|1974->771|2002->778|2031->780|2056->784|2163->863|2192->864|2231->875|2320->937|2349->938|2513->1074|2542->1075|2581->1086|2682->1160|2711->1161|2774->1196|2803->1197|2842->1208|2906->1245|2935->1246|2969->1253|2997->1254|3031->1261|3059->1262|3089->1265
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|28->4|44->20|44->20|45->21|49->25|49->25|50->26|51->27|51->27|51->27|51->27|51->27|51->27|51->27|52->28|52->28|53->29|55->31|55->31|60->36|60->36|61->37|63->39|63->39|64->40|64->40|65->41|66->42|66->42|67->43|67->43|68->44|68->44|69->45
                  -- GENERATED --
              */
          