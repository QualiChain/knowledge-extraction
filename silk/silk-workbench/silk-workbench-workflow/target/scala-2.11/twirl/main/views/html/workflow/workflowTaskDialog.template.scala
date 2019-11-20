
package views.html.workflow

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
/*1.2*/import org.silkframework.runtime.activity.UserContext

object workflowTaskDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(project: String, task: String)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import org.silkframework.workspace.WorkspaceFactory
/*5.2*/import org.silkframework.workspace.activity.workflow.Workflow

def /*7.2*/workflowTask/*7.14*/ = {{ WorkspaceFactory().workspace.project(project).tasks[Workflow].find(_.id == task) }};
Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*6.1*/("""
"""),format.raw/*7.102*/("""

"""),_display_(/*9.2*/widgets/*9.9*/.dialog(title = "Workflow Task")/*9.41*/ {_display_(Seq[Any](format.raw/*9.43*/("""
  """),_display_(/*10.4*/if(task.isEmpty)/*10.20*/ {_display_(Seq[Any](format.raw/*10.22*/("""
    """),format.raw/*11.5*/("""<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
      <input class="mdl-textfield__input" type="text" id="workflow_name" name="workflow_name"/>
      <label class="mdl-textfield__label" for="workflow_name">Name</label>
    </div>
  """)))}),format.raw/*15.4*/("""
""")))}),format.raw/*16.2*/("""

"""),format.raw/*18.1*/("""<script type="text/javascript">
  function submit() """),format.raw/*19.21*/("""{"""),format.raw/*19.22*/("""
    """),format.raw/*20.5*/("""var values = """),format.raw/*20.18*/("""{"""),format.raw/*20.19*/("""
      """),format.raw/*21.7*/("""name: """),_display_(/*21.14*/if(!task.isEmpty)/*21.31*/ {_display_(Seq[Any](format.raw/*21.33*/("""'"""),_display_(/*21.35*/task),format.raw/*21.39*/("""'""")))}/*21.42*/else/*21.47*/{_display_(Seq[Any](format.raw/*21.48*/("""$("input[name='workflow_name']").val()""")))}),format.raw/*21.87*/(""",
    """),format.raw/*22.5*/("""}"""),format.raw/*22.6*/(""";

    if(values.name.length === 0) """),format.raw/*24.34*/("""{"""),format.raw/*24.35*/("""
      """),format.raw/*25.7*/("""alert("Task name is empty.");
      return;
    """),format.raw/*27.5*/("""}"""),format.raw/*27.6*/("""

    """),format.raw/*29.5*/("""var url = '"""),_display_(/*29.17*/config/*29.23*/.baseUrl),format.raw/*29.31*/("""/workflow/workflows/"""),_display_(/*29.52*/project),format.raw/*29.59*/("""';
    """),_display_(/*30.6*/if(!task.isEmpty)/*30.23*/ {_display_(Seq[Any](format.raw/*30.25*/("""
      """),format.raw/*31.7*/("""url = url + '/' + values.name;
    """)))}),format.raw/*32.6*/("""

    """),format.raw/*34.5*/("""$.ajax("""),format.raw/*34.12*/("""{"""),format.raw/*34.13*/("""
      """),format.raw/*35.7*/("""type: """),_display_(/*35.14*/if(task.isEmpty)/*35.30*/ {_display_(Seq[Any](format.raw/*35.32*/("""'POST'""")))}/*35.40*/else/*35.45*/{_display_(Seq[Any](format.raw/*35.46*/("""'PUT'""")))}),format.raw/*35.52*/(""",
      url: url,
      contentType: 'text/xml;charset=UTF-8',
      processData: false,
      data: '<Workflow id="' + values.name + '"></Workflow>',
      success: function(data) """),format.raw/*40.31*/("""{"""),format.raw/*40.32*/("""
        """),format.raw/*41.9*/("""closeDialog();
        reloadWorkspace();
      """),format.raw/*43.7*/("""}"""),format.raw/*43.8*/(""",
      error: function(request) """),format.raw/*44.32*/("""{"""),format.raw/*44.33*/("""
        """),format.raw/*45.9*/("""alert(request.responseText);
      """),format.raw/*46.7*/("""}"""),format.raw/*46.8*/("""
    """),format.raw/*47.5*/("""}"""),format.raw/*47.6*/(""");
  """),format.raw/*48.3*/("""}"""),format.raw/*48.4*/("""
"""),format.raw/*49.1*/("""</script>"""))
      }
    }
  }

  def render(project:String,task:String,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(project,task)(userContext)

  def f:((String,String) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (project,task) => (userContext) => apply(project,task)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workflow/app/views/workflow/workflowTaskDialog.scala.html
                  HASH: f537fc036088a6cd617521af7359fea2f7ff267f
                  MATRIX: 441->1|831->56|970->125|1029->178|1103->242|1123->254|1240->123|1267->240|1296->342|1324->345|1338->352|1378->384|1417->386|1447->390|1472->406|1512->408|1544->413|1834->673|1866->675|1895->677|1975->729|2004->730|2036->735|2077->748|2106->749|2140->756|2174->763|2200->780|2240->782|2269->784|2294->788|2315->791|2328->796|2367->797|2437->836|2470->842|2498->843|2562->879|2591->880|2625->887|2700->935|2728->936|2761->942|2800->954|2815->960|2844->968|2892->989|2920->996|2954->1004|2980->1021|3020->1023|3054->1030|3120->1066|3153->1072|3188->1079|3217->1080|3251->1087|3285->1094|3310->1110|3350->1112|3376->1120|3389->1125|3428->1126|3465->1132|3674->1313|3703->1314|3739->1323|3814->1371|3842->1372|3903->1405|3932->1406|3968->1415|4030->1450|4058->1451|4090->1456|4118->1457|4150->1462|4178->1463|4206->1464
                  LINES: 17->1|22->2|25->4|26->5|28->7|28->7|29->3|30->6|31->7|33->9|33->9|33->9|33->9|34->10|34->10|34->10|35->11|39->15|40->16|42->18|43->19|43->19|44->20|44->20|44->20|45->21|45->21|45->21|45->21|45->21|45->21|45->21|45->21|45->21|45->21|46->22|46->22|48->24|48->24|49->25|51->27|51->27|53->29|53->29|53->29|53->29|53->29|53->29|54->30|54->30|54->30|55->31|56->32|58->34|58->34|58->34|59->35|59->35|59->35|59->35|59->35|59->35|59->35|59->35|64->40|64->40|65->41|67->43|67->43|68->44|68->44|69->45|70->46|70->46|71->47|71->47|72->48|72->48|73->49
                  -- GENERATED --
              */
          