
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

object cloneProjectDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(project: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/widgets/*3.9*/.dialog(title = "Clone Project " + project, submitLabel = "Clone")/*3.75*/ {_display_(Seq[Any](format.raw/*3.77*/("""
  """),format.raw/*4.3*/("""<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="project_name" name="project_name"/>
    <label class="mdl-textfield__label" for="project_name">New Name</label>
  </div>

  <script type="text/javascript">//<![CDATA[
    function submit() """),format.raw/*10.23*/("""{"""),format.raw/*10.24*/("""
      """),format.raw/*11.7*/("""console.log("submit()");
      var setButtonDisabled = function(disabled) """),format.raw/*12.50*/("""{"""),format.raw/*12.51*/("""
        """),format.raw/*13.9*/("""document.getElementById('dialog-submit-button').disabled = disabled;
        document.getElementById('dialog-cancel-button').disabled = disabled;
      """),format.raw/*15.7*/("""}"""),format.raw/*15.8*/(""";
      var name = $("input[name='project_name']").val();
      setButtonDisabled(true);
      $.ajax("""),format.raw/*18.14*/("""{"""),format.raw/*18.15*/("""
        """),format.raw/*19.9*/("""type: 'POST',
        url: '"""),_display_(/*20.16*/config/*20.22*/.baseUrl),format.raw/*20.30*/("""/workspace/projects/"""),_display_(/*20.51*/project),format.raw/*20.58*/("""/clone?newProject=' + name,
        data: "",
        success: function(data) """),format.raw/*22.33*/("""{"""),format.raw/*22.34*/("""
          """),format.raw/*23.11*/("""closeDialog();
          reloadWorkspace();
        """),format.raw/*25.9*/("""}"""),format.raw/*25.10*/(""",
        error: function(request) """),format.raw/*26.34*/("""{"""),format.raw/*26.35*/("""
          """),format.raw/*27.11*/("""setButtonDisabled(false);
          alert(request.responseText);
        """),format.raw/*29.9*/("""}"""),format.raw/*29.10*/("""
      """),format.raw/*30.7*/("""}"""),format.raw/*30.8*/(""");
    """),format.raw/*31.5*/("""}"""),format.raw/*31.6*/("""
  """),format.raw/*32.3*/("""//]]>
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
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/cloneProjectDialog.scala.html
                  HASH: f9994ccad35de9e724edc941fa6e88afdab2f95a
                  MATRIX: 752->1|863->19|890->21|904->28|978->94|1017->96|1046->99|1394->419|1423->420|1457->427|1559->501|1588->502|1624->511|1803->663|1831->664|1961->766|1990->767|2026->776|2082->805|2097->811|2126->819|2174->840|2202->847|2308->925|2337->926|2376->937|2455->989|2484->990|2547->1025|2576->1026|2615->1037|2715->1110|2744->1111|2778->1118|2806->1119|2840->1126|2868->1127|2898->1130
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|28->4|34->10|34->10|35->11|36->12|36->12|37->13|39->15|39->15|42->18|42->18|43->19|44->20|44->20|44->20|44->20|44->20|46->22|46->22|47->23|49->25|49->25|50->26|50->26|51->27|53->29|53->29|54->30|54->30|55->31|55->31|56->32
                  -- GENERATED --
              */
          