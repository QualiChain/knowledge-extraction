
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

object cloneTaskDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(project: String, task: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/widgets/*3.9*/.dialog(title = "Clone " + task, submitLabel = "Clone")/*3.64*/ {_display_(Seq[Any](format.raw/*3.66*/("""
  """),format.raw/*4.3*/("""<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="task_name" name="task_name"/>
    <label class="mdl-textfield__label" for="task_name">New Name</label>
  </div>

  <script type="text/javascript">//<![CDATA[
    function submit() """),format.raw/*10.23*/("""{"""),format.raw/*10.24*/("""
      """),format.raw/*11.7*/("""console.log("submit()");
      var name = $("input[name='task_name']").val();

      $.ajax("""),format.raw/*14.14*/("""{"""),format.raw/*14.15*/("""
        """),format.raw/*15.9*/("""type: 'POST',
        url: '"""),_display_(/*16.16*/config/*16.22*/.baseUrl),format.raw/*16.30*/("""/workspace/projects/"""),_display_(/*16.51*/project),format.raw/*16.58*/("""/tasks/"""),_display_(/*16.66*/task),format.raw/*16.70*/("""/clone?newTask=' + name,
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

  def render(project:String,task:String): play.twirl.api.HtmlFormat.Appendable = apply(project,task)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (project,task) => apply(project,task)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/cloneTaskDialog.scala.html
                  HASH: 4fc21a5906b095337a71e89f7e45fa55655743cc
                  MATRIX: 756->1|881->33|908->35|922->42|985->97|1024->99|1053->102|1392->413|1421->414|1455->421|1575->513|1604->514|1640->523|1696->552|1711->558|1740->566|1788->587|1816->594|1851->602|1876->606|1979->681|2008->682|2047->693|2126->745|2155->746|2218->781|2247->782|2286->793|2350->830|2379->831|2413->838|2441->839|2475->846|2503->847|2533->850
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|28->4|34->10|34->10|35->11|38->14|38->14|39->15|40->16|40->16|40->16|40->16|40->16|40->16|40->16|42->18|42->18|43->19|45->21|45->21|46->22|46->22|47->23|48->24|48->24|49->25|49->25|50->26|50->26|51->27
                  -- GENERATED --
              */
          