
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

object importProjectDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/widgets/*3.9*/.dialog(title = "Import Project", submitLabel = "Import")/*3.66*/ {_display_(Seq[Any](format.raw/*3.68*/("""

  """),format.raw/*5.3*/("""<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="project_name" name="project_name"/>
    <label class="mdl-textfield__label" for="project_name">Name</label>
  </div>
  <div>
    <input name="file" type="file"/>
  </div>

  <script type="text/javascript">//<![CDATA[

    function submit() """),format.raw/*15.23*/("""{"""),format.raw/*15.24*/("""
      """),format.raw/*16.7*/("""var name = $("input[name='project_name']").val();
      var file = $("input[name='file']").val();
      var formData = new FormData($('form')[0]);

      $("#dialog-progress-spinner").show();
      $("#dialog-submit-button").prop("disabled", true);

      $.ajax("""),format.raw/*23.14*/("""{"""),format.raw/*23.15*/("""
        """),format.raw/*24.9*/("""type: 'POST',
        url: '"""),_display_(/*25.16*/config/*25.22*/.baseUrl),format.raw/*25.30*/("""/workspace/projects/' + name + '/import',
        xhr: function() """),format.raw/*26.25*/("""{"""),format.raw/*26.26*/("""  """),format.raw/*26.28*/("""// custom xhr
            myXhr = $.ajaxSettings.xhr();
            return myXhr;
        """),format.raw/*29.9*/("""}"""),format.raw/*29.10*/(""",
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        success: function(data) """),format.raw/*34.33*/("""{"""),format.raw/*34.34*/("""
          """),format.raw/*35.11*/("""$("#dialog-progress-spinner").hide();
          $("#dialog-submit-button").prop("disabled", false);
          closeDialog();
          reloadWorkspace();
        """),format.raw/*39.9*/("""}"""),format.raw/*39.10*/(""",
        error: function(request) """),format.raw/*40.34*/("""{"""),format.raw/*40.35*/("""
          """),format.raw/*41.11*/("""$("#dialog-progress-spinner").hide();
          $("#dialog-submit-button").prop("disabled", false);
          alert(request.responseText);
        """),format.raw/*44.9*/("""}"""),format.raw/*44.10*/("""
      """),format.raw/*45.7*/("""}"""),format.raw/*45.8*/(""");
    """),format.raw/*46.5*/("""}"""),format.raw/*46.6*/("""
  """),format.raw/*47.3*/("""//]]>
  </script>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/importProjectDialog.scala.html
                  HASH: f35ae09c8b6d983ab9776576c03e18115057aed1
                  MATRIX: 746->1|842->4|869->6|883->13|948->70|987->72|1017->76|1416->447|1445->448|1479->455|1770->718|1799->719|1835->728|1891->757|1906->763|1935->771|2029->837|2058->838|2088->840|2205->930|2234->931|2398->1067|2427->1068|2466->1079|2655->1241|2684->1242|2747->1277|2776->1278|2815->1289|2989->1436|3018->1437|3052->1444|3080->1445|3114->1452|3142->1453|3172->1456
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|29->5|39->15|39->15|40->16|47->23|47->23|48->24|49->25|49->25|49->25|50->26|50->26|50->26|53->29|53->29|58->34|58->34|59->35|63->39|63->39|64->40|64->40|65->41|68->44|68->44|69->45|69->45|70->46|70->46|71->47
                  -- GENERATED --
              */
          