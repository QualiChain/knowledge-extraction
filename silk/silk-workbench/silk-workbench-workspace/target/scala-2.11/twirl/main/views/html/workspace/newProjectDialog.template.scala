
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

object newProjectDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/widgets/*3.9*/.dialog(title = "New Project", submitLabel = "Create")/*3.63*/ {_display_(Seq[Any](format.raw/*3.65*/("""
  """),format.raw/*4.3*/("""<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="project_name" name="project_name"/>
    <label class="mdl-textfield__label" for="project_name">Name</label>
  </div>

  <script type="text/javascript">//<![CDATA[
    function submit() """),format.raw/*10.23*/("""{"""),format.raw/*10.24*/("""
      """),format.raw/*11.7*/("""console.log("submit()");
      var name = $("input[name='project_name']").val();

      $.ajax("""),format.raw/*14.14*/("""{"""),format.raw/*14.15*/("""
        """),format.raw/*15.9*/("""type: 'PUT',
        url: '"""),_display_(/*16.16*/config/*16.22*/.baseUrl),format.raw/*16.30*/("""/workspace/projects/' + name,
        data: "",
        success: function(data) """),format.raw/*18.33*/("""{"""),format.raw/*18.34*/("""
          """),format.raw/*19.11*/("""closeDialog();
          reloadWorkspace();
        """),format.raw/*21.9*/("""}"""),format.raw/*21.10*/(""",
        error: function(request) """),format.raw/*22.34*/("""{"""),format.raw/*22.35*/("""
          """),format.raw/*23.11*/("""alert(request.responseText);
        """),format.raw/*24.9*/("""}"""),format.raw/*24.10*/("""
      """),format.raw/*25.7*/("""}"""),format.raw/*25.8*/(""");
    """),format.raw/*26.5*/("""}"""),format.raw/*26.6*/("""
  """),format.raw/*27.3*/("""//]]>
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
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/newProjectDialog.scala.html
                  HASH: a53594c70b76b61d5e601413ee9348dcc17feb93
                  MATRIX: 743->1|839->4|866->6|880->13|942->67|981->69|1010->72|1354->388|1383->389|1417->396|1540->491|1569->492|1605->501|1660->529|1675->535|1704->543|1812->623|1841->624|1880->635|1959->687|1988->688|2051->723|2080->724|2119->735|2183->772|2212->773|2246->780|2274->781|2308->788|2336->789|2366->792
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|28->4|34->10|34->10|35->11|38->14|38->14|39->15|40->16|40->16|40->16|42->18|42->18|43->19|45->21|45->21|46->22|46->22|47->23|48->24|48->24|49->25|49->25|50->26|50->26|51->27
                  -- GENERATED --
              */
          