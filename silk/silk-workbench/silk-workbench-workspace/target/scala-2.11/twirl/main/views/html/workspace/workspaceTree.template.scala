
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
/*1.2*/import controllers.workspace.routes.Assets
/*2.2*/import org.silkframework.runtime.plugin.PluginRegistry
/*3.2*/import org.silkframework.workbench.WorkbenchPlugin.{TaskActions, TaskType}
/*4.2*/import org.silkframework.workbench.WorkbenchPlugins
/*5.2*/import org.silkframework.workspace.activity.ProjectExecutor
/*6.2*/import org.silkframework.workspace.{Project, Workspace}
/*7.2*/import org.silkframework.runtime.activity.UserContext

object workspaceTree extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Workspace,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(workspace: Workspace)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*107.2*/button/*107.8*/(title: String, tooltip: String, icon: String, onClick: String, linkUrl: String = ""):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*107.97*/("""
  """),_display_(/*108.4*/if(linkUrl.trim.isEmpty)/*108.28*/ {_display_(Seq[Any](format.raw/*108.30*/("""
    """),format.raw/*109.5*/("""<div class="workspace_button" title=""""),_display_(/*109.43*/tooltip),format.raw/*109.50*/("""" onclick=""""),_display_(/*109.62*/onClick),format.raw/*109.69*/("""">
      <img width="16" height="16" src=""""),_display_(/*110.41*/Assets/*110.47*/.at("img/" + icon)),format.raw/*110.65*/(""""/>
      <span>"""),_display_(/*111.14*/title),format.raw/*111.19*/("""</span>
    </div>
  """)))}/*113.5*/else/*113.10*/{_display_(Seq[Any](format.raw/*113.11*/("""
    """),format.raw/*114.5*/("""<div class="workspace_button" title=""""),_display_(/*114.43*/tooltip),format.raw/*114.50*/("""" onclick=""""),_display_(/*114.62*/onClick),format.raw/*114.69*/("""">
      <a href=""""),_display_(/*115.17*/linkUrl),format.raw/*115.24*/("""">
          <img width="16" height="16" src=""""),_display_(/*116.45*/Assets/*116.51*/.at("img/" + icon)),format.raw/*116.69*/(""""/>
          <span>
            """),_display_(/*118.14*/title),format.raw/*118.19*/("""
          """),format.raw/*119.11*/("""</span>
      </a>
    </div>
  """)))}),format.raw/*122.4*/("""
""")))};def /*125.2*/project/*125.9*/(project: Project):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*125.31*/("""
  """),format.raw/*126.3*/("""<li id="project:"""),_display_(/*126.20*/project/*126.27*/.name),format.raw/*126.32*/("""" data-jstree='"""),format.raw/*126.47*/("""{"""),format.raw/*126.48*/(""""icon":""""),_display_(/*126.57*/Assets/*126.63*/.at(projectIcon(project))),format.raw/*126.88*/("""""""),format.raw/*126.89*/("""}"""),format.raw/*126.90*/("""' title=""""),_display_(/*126.100*/project/*126.107*/.loadingErrors.mkString(", ")),format.raw/*126.136*/("""" >
    """),_display_(/*127.6*/project/*127.13*/.name),format.raw/*127.18*/("""
    """),_display_(/*128.6*/button("Prefixes", "Edit prefixes", "wrench-screwdriver.png", s"editPrefixes('${project.name}')")),format.raw/*128.103*/("""
    """),_display_(/*129.6*/button("Resources", "Manage resources", "wrench.png", s"editResources('${project.name}')")),format.raw/*129.96*/("""
    """),_display_(/*130.6*/button("Link Spec", "Import link specification", "document--plus.png", s"importLinkSpec('${project.name}')")),format.raw/*130.114*/("""
    """),_display_(/*131.6*/button("Export", "Export project", "document-export.png", s"exportProject('${project.name}')")),format.raw/*131.100*/("""
    """),_display_(/*132.6*/if(PluginRegistry.availablePlugins[ProjectExecutor].nonEmpty)/*132.67*/ {_display_(Seq[Any](format.raw/*132.69*/("""
      """),_display_(/*133.8*/button("Execute", "Execute project", "document-export.png", s"executeProject('${project.name}')")),format.raw/*133.105*/("""
    """)))}),format.raw/*134.6*/("""
    """),_display_(/*135.6*/button("Clone", "Clone project", "clone.png", s"cloneProject('${project.name}')")),format.raw/*135.87*/("""
    """),_display_(/*136.6*/button("Remove", "Remove project", "cross.png", s"deleteProjectConfirm('${project.name}')")),format.raw/*136.97*/("""
    """),format.raw/*137.5*/("""<ul>
      """),_display_(/*138.8*/for((taskType, taskActions) <- WorkbenchPlugins.byType(project)) yield /*138.72*/ {_display_(Seq[Any](format.raw/*138.74*/("""
        """),_display_(/*139.10*/taskTypeNode(project, taskType, taskActions)),format.raw/*139.54*/("""
      """)))}),format.raw/*140.8*/("""
    """),format.raw/*141.5*/("""</ul>
  </li>
""")))};def /*152.2*/taskTypeNode/*152.14*/(project: Project, taskType: TaskType, taskActions: Seq[TaskActions]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*152.87*/("""
  """),format.raw/*153.3*/("""<li id="tasktype:"""),_display_(/*153.21*/{project.name}),format.raw/*153.35*/(""":"""),_display_(/*153.37*/taskType/*153.45*/.typeName.filter(_.isLetter)),format.raw/*153.73*/("""" data-jstree='"""),format.raw/*153.88*/("""{"""),format.raw/*153.89*/(""""icon":""""),_display_(/*153.98*/taskType/*153.106*/.folderIcon),format.raw/*153.117*/("""""""),format.raw/*153.118*/("""}"""),format.raw/*153.119*/("""' >
    """),_display_(/*154.6*/{taskType.typeName}),format.raw/*154.25*/("""s
    """),_display_(/*155.6*/for(path <- taskType.createDialog(project.name)) yield /*155.54*/ {_display_(Seq[Any](format.raw/*155.56*/("""
      """),_display_(/*156.8*/button("Add", "Add " + taskType.typeName, "plus.png", s"workspaceDialog('$path')")),format.raw/*156.90*/("""
    """)))}),format.raw/*157.6*/("""
    """),format.raw/*158.5*/("""<ul>
      """),_display_(/*159.8*/for(actions <- taskActions) yield /*159.35*/ {_display_(Seq[Any](format.raw/*159.37*/("""
        """),_display_(/*160.10*/task(project, taskType, actions)),format.raw/*160.42*/("""
      """)))}),format.raw/*161.8*/("""
    """),format.raw/*162.5*/("""</ul>
  </li>
""")))};def /*166.2*/task/*166.6*/(project: Project, taskType: TaskType, actions: TaskActions):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*166.70*/("""
  """),format.raw/*167.3*/("""<li id="task:"""),_display_(/*167.17*/{project.name}),format.raw/*167.31*/(""":"""),_display_(/*167.33*/actions/*167.40*/.task.id),format.raw/*167.48*/("""" data-jstree='"""),format.raw/*167.63*/("""{"""),format.raw/*167.64*/(""""icon":""""),_display_(/*167.73*/taskType/*167.81*/.icon),format.raw/*167.86*/("""""""),format.raw/*167.87*/("""}"""),format.raw/*167.88*/("""'>
    """),_display_(/*168.6*/{ if(actions.task.metaData.label.trim != "") actions.task.metaData.label else { actions.task.id } }),format.raw/*168.105*/("""
    """),_display_(/*169.6*/for(path <- actions.propertiesDialog) yield /*169.43*/ {_display_(Seq[Any](format.raw/*169.45*/("""
      """),_display_(/*170.8*/button("Properties", "Edit task properties", "wrench.png", s"workspaceDialog('$path')")),format.raw/*170.95*/("""
    """)))}),format.raw/*171.6*/("""
    """),_display_(/*172.6*/for(path <- actions.openPath(None, None)) yield /*172.47*/ {_display_(Seq[Any](format.raw/*172.49*/("""
      """),_display_(/*173.8*/button("Open", "Open task", "document--pencil.png", s"window.location = '${config.baseUrl}/$path'", config.baseUrl + "/" + path)),format.raw/*173.136*/("""
    """)))}),format.raw/*174.6*/("""
    """),_display_(/*175.6*/button("Clone", "Clone task", "clone.png", s"cloneTask('${project.name}', '${actions.task.id}')")),format.raw/*175.103*/("""
    """),_display_(/*176.6*/button("Remove", "Remove task", "cross.png", s"deleteTaskConfirm('${project.name}', '${actions.task.id}')")),format.raw/*176.113*/("""
    """),format.raw/*177.5*/("""<ul>
      """),_display_(/*178.8*/for((key, value) <- actions.task.metaDataFields ++ actions.task.data.properties(project.config.prefixes) if !value.isEmpty) yield /*178.131*/ {_display_(Seq[Any](format.raw/*178.133*/("""
        """),format.raw/*179.9*/("""<li data-jstree='"""),format.raw/*179.26*/("""{"""),format.raw/*179.27*/(""""icon":""""),_display_(/*179.36*/Assets/*179.42*/.at("img/file-tag.png")),format.raw/*179.65*/("""""""),format.raw/*179.66*/("""}"""),format.raw/*179.67*/("""'>
          """),_display_(/*180.12*/key),format.raw/*180.15*/(""": """),_display_(/*180.18*/value),format.raw/*180.23*/("""
        """),format.raw/*181.9*/("""</li>
      """)))}),format.raw/*182.8*/("""
    """),format.raw/*183.5*/("""</ul>
  </li>
""")))};def /*145.2*/projectIcon/*145.13*/(project: Project) = {{
  if(project.loadingErrors.isEmpty)
    "img/project.png"
  else
   "img/project-error.png"
}};
Seq[Any](format.raw/*10.1*/("""
"""),format.raw/*11.1*/("""<script type="text/javascript" >
  $(function () """),format.raw/*12.17*/("""{"""),format.raw/*12.18*/("""
    """),format.raw/*13.5*/("""$('#workspace_root').jstree("""),format.raw/*13.33*/("""{"""),format.raw/*13.34*/("""
      """),format.raw/*14.7*/(""""plugins": [ "search", "state", "dnd" ],
      "core" : """),format.raw/*15.16*/("""{"""),format.raw/*15.17*/("""
        """),format.raw/*16.9*/("""'check_callback': checkCallback
      """),format.raw/*17.7*/("""}"""),format.raw/*17.8*/(""",
      "state": """),format.raw/*18.16*/("""{"""),format.raw/*18.17*/("""
        """),format.raw/*19.9*/(""""key" : "workspace_state"
      """),format.raw/*20.7*/("""}"""),format.raw/*20.8*/(""",
      "search": """),format.raw/*21.17*/("""{"""),format.raw/*21.18*/("""
        """),format.raw/*22.9*/(""""show_only_matches": true
      """),format.raw/*23.7*/("""}"""),format.raw/*23.8*/(""",
      "dnd": """),format.raw/*24.14*/("""{"""),format.raw/*24.15*/("""
        """),format.raw/*25.9*/(""""always_copy": true
      """),format.raw/*26.7*/("""}"""),format.raw/*26.8*/("""
    """),format.raw/*27.5*/("""}"""),format.raw/*27.6*/(""").on('copy_node.jstree', copyNodeCallback);

    var to = false;
    $('#workspaceSearch').on('keyup', function () """),format.raw/*30.51*/("""{"""),format.raw/*30.52*/("""
      """),format.raw/*31.7*/("""if(to) """),format.raw/*31.14*/("""{"""),format.raw/*31.15*/(""" """),format.raw/*31.16*/("""clearTimeout(to); """),format.raw/*31.34*/("""}"""),format.raw/*31.35*/("""
      """),format.raw/*32.7*/("""to = setTimeout(function () """),format.raw/*32.35*/("""{"""),format.raw/*32.36*/("""
        """),format.raw/*33.9*/("""var v = $('#workspaceSearch').val();
        $('#workspace_root').jstree(true).search(v);
      """),format.raw/*35.7*/("""}"""),format.raw/*35.8*/(""", 250);
    """),format.raw/*36.5*/("""}"""),format.raw/*36.6*/(""");
  """),format.raw/*37.3*/("""}"""),format.raw/*37.4*/(""");

  /**
   * Called to check whether a modification to the tree is allowed.
   */
  function checkCallback(operation, node, node_parent, node_position, more) """),format.raw/*42.77*/("""{"""),format.raw/*42.78*/("""
    """),format.raw/*43.5*/("""if (operation === "copy_node") """),format.raw/*43.36*/("""{"""),format.raw/*43.37*/("""
      """),format.raw/*44.7*/("""// Only allow copying of tasks to projects
      return !!(node.id.startsWith("task:") && node_parent.id.startsWith("project:"));
    """),format.raw/*46.5*/("""}"""),format.raw/*46.6*/("""
    """),format.raw/*47.5*/("""return true;  //allow all other operations
  """),format.raw/*48.3*/("""}"""),format.raw/*48.4*/("""

  """),format.raw/*50.3*/("""/**
   * Called when the user copies a node in the tree.
   */
  function copyNodeCallback(e, data) """),format.raw/*53.38*/("""{"""),format.raw/*53.39*/("""
    """),format.raw/*54.5*/("""// Extract project and task ids
    var idParts = data.original.id.split(":");
    var sourceProject = idParts[1];
    var sourceTask = idParts[2];
    var targetProject = data.parent.slice(8);
    console.log("Copying task " + sourceTask + " from project " + sourceProject + " to project " + targetProject);

    // Execute copy on backend
    copyTask(sourceProject, sourceTask, targetProject, true, function (result) """),format.raw/*62.80*/("""{"""),format.raw/*62.81*/("""
      """),format.raw/*63.7*/("""if(result.overwrittenTasks.length === 0 || confirm("The following tasks will be overwritten: " + result.overwrittenTasks)) """),format.raw/*63.130*/("""{"""),format.raw/*63.131*/("""
        """),format.raw/*64.9*/("""copyTask(sourceProject, sourceTask, targetProject, false, function(result) """),format.raw/*64.84*/("""{"""),format.raw/*64.85*/(""" """),format.raw/*64.86*/("""reloadWorkspace() """),format.raw/*64.104*/("""}"""),format.raw/*64.105*/(""")
      """),format.raw/*65.7*/("""}"""),format.raw/*65.8*/(""" """),format.raw/*65.9*/("""else """),format.raw/*65.14*/("""{"""),format.raw/*65.15*/("""
        """),format.raw/*66.9*/("""reloadWorkspace()
      """),format.raw/*67.7*/("""}"""),format.raw/*67.8*/("""
    """),format.raw/*68.5*/("""}"""),format.raw/*68.6*/(""");

    // Don't show node in the tree yet (copying will reload workspace)
    $('#workspace_root').jstree(true).hide_node(data.node);
  """),format.raw/*72.3*/("""}"""),format.raw/*72.4*/("""

  """),format.raw/*74.3*/("""/**
   * Copies the task in the backend.
   */
  function copyTask(sourceProject, sourceTask, targetProject, dryRun, callback) """),format.raw/*77.81*/("""{"""),format.raw/*77.82*/("""
    """),format.raw/*78.5*/("""var json = """),format.raw/*78.16*/("""{"""),format.raw/*78.17*/("""
      """),format.raw/*79.7*/("""dryRun: dryRun,
      targetProject: targetProject
    """),format.raw/*81.5*/("""}"""),format.raw/*81.6*/(""";

    $.ajax("""),format.raw/*83.12*/("""{"""),format.raw/*83.13*/("""
      """),format.raw/*84.7*/("""type: 'POST',
      url: baseUrl + '/workspace/projects/' + sourceProject + '/tasks/' + sourceTask + '/copy',
      contentType: 'application/json;charset=UTF-8',
      processData: false,
      data: JSON.stringify(json),
      mimeType: 'application/json',
      error: function error(request) """),format.raw/*90.38*/("""{"""),format.raw/*90.39*/("""
        """),format.raw/*91.9*/("""alert("Failed to copy task: " + request.responseText);
        reloadWorkspace();
      """),format.raw/*93.7*/("""}"""),format.raw/*93.8*/(""",
      success: function success(response) """),format.raw/*94.43*/("""{"""),format.raw/*94.44*/("""
        """),format.raw/*95.9*/("""callback(response)
      """),format.raw/*96.7*/("""}"""),format.raw/*96.8*/("""
    """),format.raw/*97.5*/("""}"""),format.raw/*97.6*/(""");
  """),format.raw/*98.3*/("""}"""),format.raw/*98.4*/("""
"""),format.raw/*99.1*/("""</script>

<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
  <input onfocus="$(this).parent().addClass('is-focused')" onblur="$(this).parent().removeClass('is-focused')" class="mdl-textfield__input" type="text" id="workspaceSearch">
  <label class="mdl-textfield__label" for="workspaceSearch">Search</label>
</div>

"""),format.raw/*106.101*/("""
"""),format.raw/*123.2*/("""

"""),format.raw/*143.2*/("""

"""),format.raw/*150.2*/("""

"""),format.raw/*164.2*/("""

"""),format.raw/*185.2*/("""

"""),format.raw/*187.1*/("""<div id="workspace_root">
  <ul  class="filetree">
  """),_display_(/*189.4*/for(p <- workspace.projects) yield /*189.32*/ {_display_(Seq[Any](format.raw/*189.34*/("""
    """),_display_(/*190.6*/project(p)),format.raw/*190.16*/("""
  """)))}),format.raw/*191.4*/("""
  """),format.raw/*192.3*/("""</ul>
</div>"""))
      }
    }
  }

  def render(workspace:Workspace,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(workspace)(userContext)

  def f:((Workspace) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (workspace) => (userContext) => apply(workspace)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/workspaceTree.scala.html
                  HASH: ee4bef9b5d55eff48e8c4fa934d2801fdce8b924
                  MATRIX: 442->1|492->45|554->101|636->177|695->230|762->291|825->348|1206->404|1343->3669|1358->3675|1525->3764|1556->3768|1590->3792|1631->3794|1664->3799|1730->3837|1759->3844|1799->3856|1828->3863|1899->3906|1915->3912|1955->3930|2000->3947|2027->3952|2068->3975|2082->3980|2122->3981|2155->3986|2221->4024|2250->4031|2290->4043|2319->4050|2366->4069|2395->4076|2470->4123|2486->4129|2526->4147|2588->4181|2615->4186|2655->4197|2719->4230|2745->4235|2761->4242|2861->4264|2892->4267|2937->4284|2954->4291|2981->4296|3025->4311|3055->4312|3092->4321|3108->4327|3155->4352|3185->4353|3215->4354|3254->4364|3272->4371|3324->4400|3360->4409|3377->4416|3404->4421|3437->4427|3557->4524|3590->4530|3702->4620|3735->4626|3866->4734|3899->4740|4016->4834|4049->4840|4120->4901|4161->4903|4196->4911|4316->5008|4353->5014|4386->5020|4489->5101|4522->5107|4635->5198|4668->5203|4707->5215|4788->5279|4829->5281|4867->5291|4933->5335|4972->5343|5005->5348|5044->5497|5066->5509|5217->5582|5248->5585|5294->5603|5330->5617|5360->5619|5378->5627|5428->5655|5472->5670|5502->5671|5539->5680|5558->5688|5592->5699|5623->5700|5654->5701|5690->5710|5731->5729|5765->5736|5830->5784|5871->5786|5906->5794|6010->5876|6047->5882|6080->5887|6119->5899|6163->5926|6204->5928|6242->5938|6296->5970|6335->5978|6368->5983|6407->6001|6420->6005|6562->6069|6593->6072|6635->6086|6671->6100|6701->6102|6718->6109|6748->6117|6792->6132|6822->6133|6859->6142|6877->6150|6904->6155|6934->6156|6964->6157|6999->6165|7121->6264|7154->6270|7208->6307|7249->6309|7284->6317|7393->6404|7430->6410|7463->6416|7521->6457|7562->6459|7597->6467|7748->6595|7785->6601|7818->6607|7938->6704|7971->6710|8101->6817|8134->6822|8173->6834|8314->6957|8356->6959|8393->6968|8439->6985|8469->6986|8506->6995|8522->7001|8567->7024|8597->7025|8627->7026|8669->7040|8694->7043|8725->7046|8752->7051|8789->7060|8833->7073|8866->7078|8905->5366|8926->5377|9073->462|9101->463|9178->512|9207->513|9239->518|9295->546|9324->547|9358->554|9442->610|9471->611|9507->620|9572->658|9600->659|9645->676|9674->677|9710->686|9769->718|9797->719|9843->737|9872->738|9908->747|9967->779|9995->780|10038->795|10067->796|10103->805|10156->831|10184->832|10216->837|10244->838|10387->953|10416->954|10450->961|10485->968|10514->969|10543->970|10589->988|10618->989|10652->996|10708->1024|10737->1025|10773->1034|10896->1130|10924->1131|10963->1143|10991->1144|11023->1149|11051->1150|11239->1310|11268->1311|11300->1316|11359->1347|11388->1348|11422->1355|11583->1489|11611->1490|11643->1495|11715->1540|11743->1541|11774->1545|11902->1645|11931->1646|11963->1651|12411->2071|12440->2072|12474->2079|12626->2202|12656->2203|12692->2212|12795->2287|12824->2288|12853->2289|12900->2307|12930->2308|12965->2316|12993->2317|13021->2318|13054->2323|13083->2324|13119->2333|13170->2357|13198->2358|13230->2363|13258->2364|13422->2501|13450->2502|13481->2506|13636->2633|13665->2634|13697->2639|13736->2650|13765->2651|13799->2658|13881->2713|13909->2714|13951->2728|13980->2729|14014->2736|14338->3032|14367->3033|14403->3042|14518->3130|14546->3131|14618->3175|14647->3176|14683->3185|14735->3210|14763->3211|14795->3216|14823->3217|14855->3222|14883->3223|14911->3224|15284->3667|15313->4232|15343->5363|15373->5494|15403->5998|15433->7093|15463->7095|15544->7149|15589->7177|15630->7179|15663->7185|15695->7195|15730->7199|15761->7202
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|28->9|32->107|32->107|34->107|35->108|35->108|35->108|36->109|36->109|36->109|36->109|36->109|37->110|37->110|37->110|38->111|38->111|40->113|40->113|40->113|41->114|41->114|41->114|41->114|41->114|42->115|42->115|43->116|43->116|43->116|45->118|45->118|46->119|49->122|50->125|50->125|52->125|53->126|53->126|53->126|53->126|53->126|53->126|53->126|53->126|53->126|53->126|53->126|53->126|53->126|53->126|54->127|54->127|54->127|55->128|55->128|56->129|56->129|57->130|57->130|58->131|58->131|59->132|59->132|59->132|60->133|60->133|61->134|62->135|62->135|63->136|63->136|64->137|65->138|65->138|65->138|66->139|66->139|67->140|68->141|70->152|70->152|72->152|73->153|73->153|73->153|73->153|73->153|73->153|73->153|73->153|73->153|73->153|73->153|73->153|73->153|74->154|74->154|75->155|75->155|75->155|76->156|76->156|77->157|78->158|79->159|79->159|79->159|80->160|80->160|81->161|82->162|84->166|84->166|86->166|87->167|87->167|87->167|87->167|87->167|87->167|87->167|87->167|87->167|87->167|87->167|87->167|87->167|88->168|88->168|89->169|89->169|89->169|90->170|90->170|91->171|92->172|92->172|92->172|93->173|93->173|94->174|95->175|95->175|96->176|96->176|97->177|98->178|98->178|98->178|99->179|99->179|99->179|99->179|99->179|99->179|99->179|99->179|100->180|100->180|100->180|100->180|101->181|102->182|103->183|105->145|105->145|111->10|112->11|113->12|113->12|114->13|114->13|114->13|115->14|116->15|116->15|117->16|118->17|118->17|119->18|119->18|120->19|121->20|121->20|122->21|122->21|123->22|124->23|124->23|125->24|125->24|126->25|127->26|127->26|128->27|128->27|131->30|131->30|132->31|132->31|132->31|132->31|132->31|132->31|133->32|133->32|133->32|134->33|136->35|136->35|137->36|137->36|138->37|138->37|143->42|143->42|144->43|144->43|144->43|145->44|147->46|147->46|148->47|149->48|149->48|151->50|154->53|154->53|155->54|163->62|163->62|164->63|164->63|164->63|165->64|165->64|165->64|165->64|165->64|165->64|166->65|166->65|166->65|166->65|166->65|167->66|168->67|168->67|169->68|169->68|173->72|173->72|175->74|178->77|178->77|179->78|179->78|179->78|180->79|182->81|182->81|184->83|184->83|185->84|191->90|191->90|192->91|194->93|194->93|195->94|195->94|196->95|197->96|197->96|198->97|198->97|199->98|199->98|200->99|207->106|208->123|210->143|212->150|214->164|216->185|218->187|220->189|220->189|220->189|221->190|221->190|222->191|223->192
                  -- GENERATED --
              */
          