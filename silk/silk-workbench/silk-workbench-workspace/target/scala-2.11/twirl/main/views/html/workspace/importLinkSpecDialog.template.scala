
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

object importLinkSpecDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(project: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/widgets/*3.9*/.dialog(title = "Import Link Specification", submitLabel = "Import", width = 500)/*3.90*/ {_display_(Seq[Any](format.raw/*3.92*/("""
"""),format.raw/*4.1*/("""<div>
  <input name="file" type="file" id="link_spec_file_import" style="outline:none;"/>
</div>


<script type="text/javascript">//<![CDATA[
function submit() """),format.raw/*10.19*/("""{"""),format.raw/*10.20*/("""
  """),format.raw/*11.3*/("""var name = $("select[name='name']").val();
  var file = $("input[name='file']").val();
  var formData = new FormData($('form')[0]);

  console.log(formData);

  $.ajax("""),format.raw/*17.10*/("""{"""),format.raw/*17.11*/("""
    """),format.raw/*18.5*/("""type: 'POST',
    url: '"""),_display_(/*19.12*/config/*19.18*/.baseUrl),format.raw/*19.26*/("""/workspace/projects/"""),_display_(/*19.47*/project),format.raw/*19.54*/("""/importLinkSpec',
    xhr: function() """),format.raw/*20.21*/("""{"""),format.raw/*20.22*/("""
      """),format.raw/*21.7*/("""myXhr = $.ajaxSettings.xhr();
      return myXhr;
    """),format.raw/*23.5*/("""}"""),format.raw/*23.6*/(""",
    data: formData,
    cache: false,
    contentType: false,
    processData: false,
    success: function(data) """),format.raw/*28.29*/("""{"""),format.raw/*28.30*/("""
      """),format.raw/*29.7*/("""closeDialog();
      reloadWorkspace();
    """),format.raw/*31.5*/("""}"""),format.raw/*31.6*/(""",
    error: function(request) """),format.raw/*32.30*/("""{"""),format.raw/*32.31*/("""
      """),format.raw/*33.7*/("""alert(request.responseText);
    """),format.raw/*34.5*/("""}"""),format.raw/*34.6*/("""
  """),format.raw/*35.3*/("""}"""),format.raw/*35.4*/(""");
"""),format.raw/*36.1*/("""}"""),format.raw/*36.2*/("""
"""),format.raw/*37.1*/("""//]]>
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
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/importLinkSpecDialog.scala.html
                  HASH: 9369dc24b6a43e3e55e70812c278d3c135fb0359
                  MATRIX: 754->1|865->19|892->21|906->28|995->109|1034->111|1061->112|1249->272|1278->273|1308->276|1504->444|1533->445|1565->450|1617->475|1632->481|1661->489|1709->510|1737->517|1803->555|1832->556|1866->563|1947->617|1975->618|2119->734|2148->735|2182->742|2253->786|2281->787|2340->818|2369->819|2403->826|2463->859|2491->860|2521->863|2549->864|2579->867|2607->868|2635->869
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|28->4|34->10|34->10|35->11|41->17|41->17|42->18|43->19|43->19|43->19|43->19|43->19|44->20|44->20|45->21|47->23|47->23|52->28|52->28|53->29|55->31|55->31|56->32|56->32|57->33|58->34|58->34|59->35|59->35|60->36|60->36|61->37
                  -- GENERATED --
              */
          