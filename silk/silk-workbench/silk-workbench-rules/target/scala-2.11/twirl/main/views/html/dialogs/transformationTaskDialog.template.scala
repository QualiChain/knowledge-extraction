
package views.html.dialogs

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
/*1.2*/import org.silkframework.dataset.DatasetSpec.GenericDatasetSpec
/*2.2*/import org.silkframework.rule.TransformSpec
/*3.2*/import org.silkframework.workspace.WorkspaceFactory
/*5.2*/import org.silkframework.runtime.activity.UserContext

object transformationTaskDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,String,Boolean,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(project: String, task: String, createDialog: Boolean)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*8.2*/datasets/*8.10*/ = {{ WorkspaceFactory().workspace.project(project).tasks[GenericDatasetSpec].toSeq }};def /*10.2*/transformationTask/*10.20*/ = {{ WorkspaceFactory().workspace.project(project).tasks[TransformSpec].find(_.id == task) }};def /*12.2*/currentInput/*12.14*/ = {{ transformationTask.map(_.data.selection) }};def /*14.2*/currentOutput/*14.15*/ = {{ transformationTask.flatMap(_.data.outputs.headOption) }};def /*16.2*/prefixes/*16.10*/ = {{ WorkspaceFactory().workspace.project(project).config.prefixes }};def /*18.2*/restrictionTooltip/*18.20*/ = {{
  """Additional restrictions on the enumerated entities.
  |If this is an RDF source, use SPARQL patterns that include the variable ?a to identify the enumerated entities, e.g.,
  |?a foaf:knows <http://example.org/SomePerson>""".stripMargin
}};
Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*8.95*/("""

"""),format.raw/*10.113*/("""

"""),format.raw/*12.62*/("""

"""),format.raw/*14.76*/("""

"""),format.raw/*16.79*/("""

"""),format.raw/*22.2*/("""

"""),_display_(/*24.2*/widgets/*24.9*/.dialog(title = "Transformation Task", createDialog = createDialog)/*24.76*/ {_display_(Seq[Any](format.raw/*24.78*/("""
"""),format.raw/*25.1*/("""<div class="dialog-form" id="transFormationDialogForm">
  """),_display_(/*26.4*/if(task.isEmpty)/*26.20*/ {_display_(Seq[Any](format.raw/*26.22*/("""
    """),format.raw/*27.5*/("""<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
      <input class="mdl-textfield__input" type="text" id="transformation_task_name" name="transformation_task_name"/>
      <label class="mdl-textfield__label" for="transformation_task_name">Name</label>
    </div>
  """)))}),format.raw/*31.4*/("""
  """),_display_(/*32.4*/if(currentInput.isDefined)/*32.30*/ {_display_(Seq[Any](format.raw/*32.32*/("""
    """),_display_(/*33.6*/widgets/*33.13*/.datasetSelect(project, "source", Some(currentInput.get.inputId))),format.raw/*33.78*/("""
  """)))}/*34.5*/else/*34.10*/{_display_(Seq[Any](format.raw/*34.11*/("""
    """),_display_(/*35.6*/widgets/*35.13*/.datasetSelect(project, "source", None)),format.raw/*35.52*/("""
  """)))}),format.raw/*36.4*/("""
  """),format.raw/*37.3*/("""<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="transformation_type" name="transformation_type" """),_display_(/*38.106*/for(t <- transformationTask) yield /*38.134*/ {_display_(Seq[Any](format.raw/*38.136*/(""" """),format.raw/*38.137*/("""value=""""),_display_(/*38.145*/t/*38.146*/.data.selection.typeUri.serialize(prefixes)),format.raw/*38.189*/("""" """)))}),format.raw/*38.192*/(""" """),format.raw/*38.193*/("""/>
    <label class="mdl-textfield__label" for="transformation_type">Source Type</label>
    <div class="mdl-tooltip mdl-tooltip--right" for="transformation_type">
      The type of entities to be retrieved from the source dataset.
    </div>
  </div>
  """),_display_(/*44.4*/widgets/*44.11*/.multilineParameter("source", currentInput.map(_.restriction.serialize).getOrElse(""), label = "Source Restriction", tooltip = restrictionTooltip)),format.raw/*44.157*/("""
  """),_display_(/*45.4*/if(currentOutput.isDefined)/*45.31*/ {_display_(Seq[Any](format.raw/*45.33*/("""
    """),_display_(/*46.6*/widgets/*46.13*/.datasetSelect(project, "output", Some(currentOutput.get))),format.raw/*46.71*/("""
  """)))}/*47.5*/else/*47.10*/{_display_(Seq[Any](format.raw/*47.11*/("""
    """),_display_(/*48.6*/widgets/*48.13*/.datasetSelect(project, "output", None)),format.raw/*48.52*/("""
  """)))}),format.raw/*49.4*/("""
  """),_display_(/*50.4*/widgets/*50.11*/.multilineParameter("target_vocabularies", transformationTask.map(_.targetVocabularies.mkString(", ")).getOrElse(""), label = "Target Vocabularies", tooltip = "Comma-separated list of target vocabularies.")),format.raw/*50.217*/("""
"""),format.raw/*51.1*/("""</div>
""")))}),format.raw/*52.2*/("""

"""),format.raw/*54.1*/("""<script type="text/javascript">
  // The variable name.
  var varName;
  // The name of the currently edited datasource.
  var sourceName;

  $(function() """),format.raw/*60.16*/("""{"""),format.raw/*60.17*/("""
    """),format.raw/*61.5*/("""// Add autocompletion
    $("input[name='transformation_type']").autocomplete("""),format.raw/*62.57*/("""{"""),format.raw/*62.58*/("""
      """),format.raw/*63.7*/("""appendTo: '#transFormationDialogForm',
      source: function( request, response ) """),format.raw/*64.45*/("""{"""),format.raw/*64.46*/("""
        """),format.raw/*65.9*/("""var dataset = $("select[name='source_dataset']").val();
        $.get('"""),_display_(/*66.17*/config/*66.23*/.baseUrl),format.raw/*66.31*/("""/workspace/datasets/"""),_display_(/*66.52*/project),format.raw/*66.59*/("""/' + dataset + '/types', """),format.raw/*66.84*/("""{"""),format.raw/*66.85*/(""" """),format.raw/*66.86*/("""search: request.term """),format.raw/*66.107*/("""}"""),format.raw/*66.108*/(""", function(data) """),format.raw/*66.125*/("""{"""),format.raw/*66.126*/("""
          """),format.raw/*67.11*/("""response(data);
        """),format.raw/*68.9*/("""}"""),format.raw/*68.10*/(""");
      """),format.raw/*69.7*/("""}"""),format.raw/*69.8*/(""",
      minLength: 0,
      close: function(event, ui) """),format.raw/*71.34*/("""{"""),format.raw/*71.35*/("""
        """),format.raw/*72.9*/("""$("#transformation_type").parent().addClass("is-dirty");
      """),format.raw/*73.7*/("""}"""),format.raw/*73.8*/("""
    """),format.raw/*74.5*/("""}"""),format.raw/*74.6*/(""").focus(function() """),format.raw/*74.25*/("""{"""),format.raw/*74.26*/(""" """),format.raw/*74.27*/("""$(this).autocomplete("search"); """),format.raw/*74.59*/("""}"""),format.raw/*74.60*/(""");

  """),format.raw/*76.3*/("""}"""),format.raw/*76.4*/(""");

  function submit() """),format.raw/*78.21*/("""{"""),format.raw/*78.22*/("""
    """),format.raw/*79.5*/("""const values = """),format.raw/*79.20*/("""{"""),format.raw/*79.21*/("""
      """),format.raw/*80.7*/("""id: """),_display_(/*80.12*/if(!task.isEmpty)/*80.29*/ {_display_(Seq[Any](format.raw/*80.31*/("""'"""),_display_(/*80.33*/task),format.raw/*80.37*/("""'""")))}/*80.40*/else/*80.45*/{_display_(Seq[Any](format.raw/*80.46*/("""$("#transformation_task_name").val()""")))}),format.raw/*80.83*/(""",
      data: """),format.raw/*81.13*/("""{"""),format.raw/*81.14*/("""
        """),format.raw/*82.9*/("""taskType: "Transform",
        selection: """),format.raw/*83.20*/("""{"""),format.raw/*83.21*/("""
          """),format.raw/*84.11*/("""inputId: $("#source_dataset").val(),
          typeUri: $("#transformation_type").val(),
          restriction: $("#source").val()
        """),format.raw/*87.9*/("""}"""),format.raw/*87.10*/(""",
        outputs: $("#output_dataset").val().split(/[,\s]+/).filter(String),
        targetVocabularies: $("#target_vocabularies").val().split(/[,\s]+/).filter(String)
      """),format.raw/*90.7*/("""}"""),format.raw/*90.8*/("""
    """),format.raw/*91.5*/("""}"""),format.raw/*91.6*/(""";

    if(values.id.length === 0) """),format.raw/*93.32*/("""{"""),format.raw/*93.33*/("""
      """),format.raw/*94.7*/("""alert("Task name is empty.");
      return;
    """),format.raw/*96.5*/("""}"""),format.raw/*96.6*/("""

    """),format.raw/*98.5*/("""var callbacks = """),format.raw/*98.21*/("""{"""),format.raw/*98.22*/("""
      """),format.raw/*99.7*/("""success: function() """),format.raw/*99.27*/("""{"""),format.raw/*99.28*/("""
        """),format.raw/*100.9*/("""closeDialog();
      """),format.raw/*101.7*/("""}"""),format.raw/*101.8*/(""",
      error: function(msg) """),format.raw/*102.28*/("""{"""),format.raw/*102.29*/("""
        """),format.raw/*103.9*/("""$("#primary_dialog .dialog__error-msg .mdl-alert__content").text(msg);
        $("#primary_dialog .dialog__error-msg").fadeIn();
      """),format.raw/*105.7*/("""}"""),format.raw/*105.8*/("""
    """),format.raw/*106.5*/("""}"""),format.raw/*106.6*/(""";

    """),_display_(/*108.6*/if(createDialog)/*108.22*/ {_display_(Seq[Any](format.raw/*108.24*/("""
      """),format.raw/*109.7*/("""postTask('"""),_display_(/*109.18*/project),format.raw/*109.25*/("""', values, callbacks);
    """)))}/*110.7*/else/*110.12*/{_display_(Seq[Any](format.raw/*110.13*/("""
      """),format.raw/*111.7*/("""putTask('"""),_display_(/*111.17*/project),format.raw/*111.24*/("""', values.id, values, callbacks);
    """)))}),format.raw/*112.6*/("""
  """),format.raw/*113.3*/("""}"""),format.raw/*113.4*/("""
"""),format.raw/*114.1*/("""</script>
"""))
      }
    }
  }

  def render(project:String,task:String,createDialog:Boolean,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(project,task,createDialog)(userContext)

  def f:((String,String,Boolean) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (project,task,createDialog) => (userContext) => apply(project,task,createDialog)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/dialogs/transformationTaskDialog.scala.html
                  HASH: f31154e5d9f381152a2f5ad777179ac14bb00305
                  MATRIX: 440->1|511->66|562->111|621->165|1025->220|1192->312|1208->320|1307->408|1334->426|1441->522|1462->534|1524->585|1546->598|1621->662|1638->670|1721->742|1748->760|2026->310|2054->405|2085->519|2115->582|2145->659|2175->739|2204->1009|2233->1012|2248->1019|2324->1086|2364->1088|2392->1089|2477->1148|2502->1164|2542->1166|2574->1171|2897->1464|2927->1468|2962->1494|3002->1496|3034->1502|3050->1509|3136->1574|3158->1579|3171->1584|3210->1585|3242->1591|3258->1598|3318->1637|3352->1641|3382->1644|3590->1824|3635->1852|3676->1854|3706->1855|3742->1863|3753->1864|3818->1907|3853->1910|3883->1911|4164->2166|4180->2173|4348->2319|4378->2323|4414->2350|4454->2352|4486->2358|4502->2365|4581->2423|4603->2428|4616->2433|4655->2434|4687->2440|4703->2447|4763->2486|4797->2490|4827->2494|4843->2501|5071->2707|5099->2708|5137->2716|5166->2718|5349->2873|5378->2874|5410->2879|5516->2957|5545->2958|5579->2965|5690->3048|5719->3049|5755->3058|5854->3130|5869->3136|5898->3144|5946->3165|5974->3172|6027->3197|6056->3198|6085->3199|6135->3220|6165->3221|6211->3238|6241->3239|6280->3250|6331->3274|6360->3275|6396->3284|6424->3285|6507->3340|6536->3341|6572->3350|6662->3413|6690->3414|6722->3419|6750->3420|6797->3439|6826->3440|6855->3441|6915->3473|6944->3474|6977->3480|7005->3481|7057->3505|7086->3506|7118->3511|7161->3526|7190->3527|7224->3534|7256->3539|7282->3556|7322->3558|7351->3560|7376->3564|7397->3567|7410->3572|7449->3573|7517->3610|7559->3624|7588->3625|7624->3634|7694->3676|7723->3677|7762->3688|7928->3827|7957->3828|8159->4003|8187->4004|8219->4009|8247->4010|8309->4044|8338->4045|8372->4052|8447->4100|8475->4101|8508->4107|8552->4123|8581->4124|8615->4131|8663->4151|8692->4152|8729->4161|8778->4182|8807->4183|8865->4212|8895->4213|8932->4222|9095->4357|9124->4358|9157->4363|9186->4364|9221->4372|9247->4388|9288->4390|9323->4397|9362->4408|9391->4415|9438->4444|9452->4449|9492->4450|9527->4457|9565->4467|9594->4474|9664->4513|9695->4516|9724->4517|9753->4518
                  LINES: 17->1|18->2|19->3|20->5|25->6|29->8|29->8|29->10|29->10|29->12|29->12|29->14|29->14|29->16|29->16|29->18|29->18|34->7|35->8|37->10|39->12|41->14|43->16|45->22|47->24|47->24|47->24|47->24|48->25|49->26|49->26|49->26|50->27|54->31|55->32|55->32|55->32|56->33|56->33|56->33|57->34|57->34|57->34|58->35|58->35|58->35|59->36|60->37|61->38|61->38|61->38|61->38|61->38|61->38|61->38|61->38|61->38|67->44|67->44|67->44|68->45|68->45|68->45|69->46|69->46|69->46|70->47|70->47|70->47|71->48|71->48|71->48|72->49|73->50|73->50|73->50|74->51|75->52|77->54|83->60|83->60|84->61|85->62|85->62|86->63|87->64|87->64|88->65|89->66|89->66|89->66|89->66|89->66|89->66|89->66|89->66|89->66|89->66|89->66|89->66|90->67|91->68|91->68|92->69|92->69|94->71|94->71|95->72|96->73|96->73|97->74|97->74|97->74|97->74|97->74|97->74|97->74|99->76|99->76|101->78|101->78|102->79|102->79|102->79|103->80|103->80|103->80|103->80|103->80|103->80|103->80|103->80|103->80|103->80|104->81|104->81|105->82|106->83|106->83|107->84|110->87|110->87|113->90|113->90|114->91|114->91|116->93|116->93|117->94|119->96|119->96|121->98|121->98|121->98|122->99|122->99|122->99|123->100|124->101|124->101|125->102|125->102|126->103|128->105|128->105|129->106|129->106|131->108|131->108|131->108|132->109|132->109|132->109|133->110|133->110|133->110|134->111|134->111|134->111|135->112|136->113|136->113|137->114
                  -- GENERATED --
              */
          