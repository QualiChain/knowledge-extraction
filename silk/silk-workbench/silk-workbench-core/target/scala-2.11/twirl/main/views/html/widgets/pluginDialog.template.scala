
package views.html.widgets

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
/*1.2*/import org.silkframework.dataset.DatasetPluginAutoConfigurable
/*2.2*/import org.silkframework.runtime.plugin.ParameterType._
/*3.2*/import org.silkframework.runtime.plugin.{AnyPlugin, Parameter, ParameterType, PluginDescription}
/*4.2*/import org.silkframework.workspace.Project
/*5.2*/import org.silkframework.runtime.activity.UserContext
/*7.2*/import org.silkframework.runtime.plugin.PluginCategories

object pluginDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template11[Project,String,Seq[PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
}],Option[AnyPlugin],List[String],String,String,String,Boolean,Html,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*8.2*/(project: Project,
  name: String,
  plugins: Seq[PluginDescription[_]],
  currentObj: Option[AnyPlugin],
  resources: List[String],
  title: String = "Edit Properties",
  submitLabel: String = "OK",
  secondaryLabel: String = "Secondary",
  createDialog: Boolean = false)(contents: Html)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*147.2*/pluginLabel/*147.13*/(plugin: PluginDescription[_]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*147.47*/("""
  """),_display_(/*148.4*/if(plugin.categories == Seq(PluginCategories.uncategorized))/*148.64*/ {_display_(Seq[Any](format.raw/*148.66*/("""
    """),_display_(/*149.6*/plugin/*149.12*/.label),format.raw/*149.18*/("""
  """)))}/*150.5*/else/*150.10*/{_display_(Seq[Any](format.raw/*150.11*/("""
    """),_display_(/*151.6*/plugin/*151.12*/.label),format.raw/*151.18*/(""" """),format.raw/*151.19*/("""("""),_display_(/*151.21*/plugin/*151.27*/.categories.mkString(", ")),format.raw/*151.53*/(""")
  """)))}),format.raw/*152.4*/("""
""")))};def /*155.2*/createTab/*155.11*/(plugin: PluginDescription[_]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*155.45*/("""
  """),format.raw/*156.3*/("""<div id=""""),_display_(/*156.13*/plugin/*156.19*/.id),format.raw/*156.22*/("""" class="resource-tab">
    <p>
      """),_display_(/*158.8*/plugin/*158.14*/.description),format.raw/*158.26*/("""
    """),format.raw/*159.5*/("""</p>

    """),_display_(/*161.6*/if(createDialog)/*161.22*/ {_display_(Seq[Any](format.raw/*161.24*/("""
      """),format.raw/*162.7*/("""<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input" type="text" id=""""),_display_(/*163.62*/(plugin.id)),format.raw/*163.73*/("""_name" name=""""),_display_(/*163.87*/(plugin.id)),format.raw/*163.98*/("""_name" value=""""),_display_(/*163.113*/name),format.raw/*163.117*/("""" />
        <label class="mdl-textfield__label" for=""""),_display_(/*164.51*/(plugin.id)),format.raw/*164.62*/("""_name">Name</label>
      </div>
    """)))}),format.raw/*166.6*/("""

    """),_display_(/*168.6*/for(param <- plugin.parameters) yield /*168.37*/ {_display_(Seq[Any](format.raw/*168.39*/("""
      """),_display_(/*169.8*/if(param.visibleInDialog)/*169.33*/ {_display_(Seq[Any](format.raw/*169.35*/("""
        """),_display_(/*170.10*/createField(plugin.id, param)),format.raw/*170.39*/("""
      """)))}),format.raw/*171.8*/("""
    """)))}),format.raw/*172.6*/("""

  """),format.raw/*174.3*/("""</div>

  <script type="text/javascript">
    function """),_display_(/*177.15*/(plugin.id)),format.raw/*177.26*/("""_submit(onlyAutoConfigure, callbacks) """),format.raw/*177.64*/("""{"""),format.raw/*177.65*/("""
      """),format.raw/*178.7*/("""// Retrieve the name of the plugin
      """),_display_(/*179.8*/if(createDialog)/*179.24*/ {_display_(Seq[Any](format.raw/*179.26*/("""
        """),format.raw/*180.9*/("""var name =  $('[name=\'"""),_display_(/*180.33*/(plugin.id)),format.raw/*180.44*/("""_name\']').val();
      """)))}/*181.9*/else/*181.14*/{_display_(Seq[Any](format.raw/*181.15*/("""
        """),format.raw/*182.9*/("""var name = '"""),_display_(/*182.22*/name),format.raw/*182.26*/("""';
      """)))}),format.raw/*183.8*/("""
      """),format.raw/*184.7*/("""if(name.length === 0) """),format.raw/*184.29*/("""{"""),format.raw/*184.30*/("""
        """),format.raw/*185.9*/("""showError("Name is empty.");
        return false;
      """),format.raw/*187.7*/("""}"""),format.raw/*187.8*/("""

      """),format.raw/*189.7*/("""// Retrieve all plugin parameters
      var parameters = """),format.raw/*190.24*/("""{"""),format.raw/*190.25*/("""}"""),format.raw/*190.26*/(""";
      """),_display_(/*191.8*/for(param <- plugin.parameters) yield /*191.39*/ {_display_(Seq[Any](format.raw/*191.41*/("""
        """),format.raw/*192.9*/("""parameters['"""),_display_(/*192.22*/param/*192.27*/.name),format.raw/*192.32*/("""'] = $('[name=\'"""),_display_(/*192.49*/(plugin.id)),format.raw/*192.60*/("""_"""),_display_(/*192.62*/(param.name)),format.raw/*192.74*/("""\']').val();
      """)))}),format.raw/*193.8*/("""

      """),format.raw/*195.7*/("""// Submit dialog
      if(!onlyAutoConfigure) """),format.raw/*196.30*/("""{"""),format.raw/*196.31*/("""
        """),format.raw/*197.9*/("""savePlugin('"""),_display_(/*197.22*/plugin/*197.28*/.id),format.raw/*197.31*/("""', name, parameters, callbacks);
      """),format.raw/*198.7*/("""}"""),format.raw/*198.8*/(""" """),format.raw/*198.9*/("""else """),format.raw/*198.14*/("""{"""),format.raw/*198.15*/("""
        """),format.raw/*199.9*/("""autoConfigure('"""),_display_(/*199.25*/plugin/*199.31*/.id),format.raw/*199.34*/("""', name, parameters);
      """),format.raw/*200.7*/("""}"""),format.raw/*200.8*/("""

      """),format.raw/*202.7*/("""return true;
    """),format.raw/*203.5*/("""}"""),format.raw/*203.6*/("""

    """),format.raw/*205.5*/("""plugin_dialog_submit_delegates['"""),_display_(/*205.38*/plugin/*205.44*/.id),format.raw/*205.47*/("""'] = """),_display_(/*205.53*/(plugin.id)),format.raw/*205.64*/("""_submit
    """),_display_(/*206.6*/if(classOf[DatasetPluginAutoConfigurable[_]].isAssignableFrom(plugin.pluginClass))/*206.88*/ {_display_(Seq[Any](format.raw/*206.90*/("""
      """),format.raw/*207.7*/("""plugin_autoconfigurable['"""),_display_(/*207.33*/plugin/*207.39*/.id),format.raw/*207.42*/("""'] = true;
    """)))}/*208.7*/else/*208.12*/{_display_(Seq[Any](format.raw/*208.13*/("""
      """),format.raw/*209.7*/("""plugin_autoconfigurable['"""),_display_(/*209.33*/plugin/*209.39*/.id),format.raw/*209.42*/("""'] = false;
    """)))}),format.raw/*210.6*/("""

  """),format.raw/*212.3*/("""</script>
""")))};def /*230.2*/createTextField/*230.17*/(pluginId: String, param: Parameter, inputType: String = "text"):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*230.85*/("""
  """),format.raw/*231.3*/("""<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type=""""),_display_(/*232.48*/inputType),format.raw/*232.57*/("""" id=""""),_display_(/*232.64*/(pluginId)),format.raw/*232.74*/("""_"""),_display_(/*232.76*/(param.name)),format.raw/*232.88*/("""" name=""""),_display_(/*232.97*/(pluginId)),format.raw/*232.107*/("""_"""),_display_(/*232.109*/(param.name)),format.raw/*232.121*/("""" value=""""),_display_(/*232.131*/value(pluginId, param)),format.raw/*232.153*/(""""/>
    <label class="mdl-textfield__label" for=""""),_display_(/*233.47*/(pluginId)),format.raw/*233.57*/("""_"""),_display_(/*233.59*/(param.name)),format.raw/*233.71*/("""">"""),_display_(/*233.74*/param/*233.79*/.label),format.raw/*233.85*/("""</label>
    <div class="mdl-tooltip mdl-tooltip--right" for=""""),_display_(/*234.55*/(pluginId)),format.raw/*234.65*/("""_"""),_display_(/*234.67*/(param.name)),format.raw/*234.79*/("""">
      """),_display_(/*235.8*/param/*235.13*/.description),format.raw/*235.25*/("""
      """),format.raw/*236.7*/("""<br/>
      Expected type: """),_display_(/*237.23*/param/*237.28*/.dataType.description),format.raw/*237.49*/("""
    """),format.raw/*238.5*/("""</div>
 </div>
""")))};def /*242.2*/createMultilineTextField/*242.26*/(pluginId: String, param: Parameter):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*242.66*/("""
  """),_display_(/*243.4*/widgets/*243.11*/.multilineParameter(s"${pluginId}_${param.name}", value(pluginId, param), label = param.label, tooltip = param.description, additionalInputElementsClass = "plugin-dialog-multi-line-textfield")),format.raw/*243.203*/("""
""")))};def /*246.2*/createSparqlEndpointDatasetField/*246.34*/(pluginId: String, param: Parameter)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*246.109*/("""
  """),_display_(/*247.4*/widgets/*247.11*/.sparqlDatasetSelect(project.name, param.label, param.description, pluginId + "_" + param.name, if(value(pluginId, param) == "") None else Some(value(pluginId, param)))),format.raw/*247.179*/("""
""")))};def /*250.2*/createEnumerationField/*250.24*/(pluginId: String, param: Parameter, enumerationValues: Seq[String], displayNames: Seq[String]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*250.123*/("""
  """),format.raw/*251.3*/("""<div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label">
    <select class="mdl-selectfield__select" id=""""),_display_(/*252.50*/(pluginId)),format.raw/*252.60*/("""_"""),_display_(/*252.62*/(param.name)),format.raw/*252.74*/("""" name=""""),_display_(/*252.83*/(pluginId)),format.raw/*252.93*/("""_"""),_display_(/*252.95*/(param.name)),format.raw/*252.107*/("""" >
    """),_display_(/*253.6*/for((enumerationValue, displayName) <- enumerationValues.zip(displayNames)) yield /*253.81*/ {_display_(Seq[Any](format.raw/*253.83*/("""
      """),format.raw/*254.7*/("""<option value=""""),_display_(/*254.23*/(enumerationValue)),format.raw/*254.41*/("""" """),_display_(/*254.44*/if(enumerationValue == value(pluginId, param))/*254.90*/ {_display_(Seq[Any](format.raw/*254.92*/(""" """),format.raw/*254.93*/("""selected="selected" """)))}),format.raw/*254.114*/(""">"""),_display_(/*254.116*/displayName),format.raw/*254.127*/("""</option>
    """)))}),format.raw/*255.6*/("""
    """),format.raw/*256.5*/("""</select>
    <label class="mdl-selectfield__label" for=""""),_display_(/*257.49*/(pluginId)),format.raw/*257.59*/("""_"""),_display_(/*257.61*/(param.name)),format.raw/*257.73*/("""">"""),_display_(/*257.76*/param/*257.81*/.label),format.raw/*257.87*/("""</label>
    <div class="mdl-tooltip mdl-tooltip--right" for=""""),_display_(/*258.55*/(pluginId)),format.raw/*258.65*/("""_"""),_display_(/*258.67*/(param.name)),format.raw/*258.79*/("""">
      """),_display_(/*259.8*/param/*259.13*/.description),format.raw/*259.25*/("""
      """),format.raw/*260.7*/("""<br/>
      Expected type: """),_display_(/*261.23*/param/*261.28*/.dataType.description),format.raw/*261.49*/("""
    """),format.raw/*262.5*/("""</div>
  </div>
""")))};def /*266.2*/createResourceField/*266.21*/(pluginId: String, param: Parameter):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*266.61*/("""
  """),format.raw/*267.3*/("""<div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label">
    <input class="mdl-selectfield__select input-resource" id=""""),_display_(/*268.64*/(pluginId)),format.raw/*268.74*/("""_"""),_display_(/*268.76*/(param.name)),format.raw/*268.88*/("""" name=""""),_display_(/*268.97*/(pluginId)),format.raw/*268.107*/("""_"""),_display_(/*268.109*/(param.name)),format.raw/*268.121*/("""" value=""""),_display_(/*268.131*/value(pluginId, param)),format.raw/*268.153*/("""" />
    <label class="mdl-selectfield__label" for=""""),_display_(/*269.49*/(pluginId)),format.raw/*269.59*/("""_"""),_display_(/*269.61*/(param.name)),format.raw/*269.73*/("""">"""),_display_(/*269.76*/param/*269.81*/.label),format.raw/*269.87*/("""</label>
    <div class="mdl-tooltip mdl-tooltip--right" for=""""),_display_(/*270.55*/(pluginId)),format.raw/*270.65*/("""_"""),_display_(/*270.67*/(param.name)),format.raw/*270.79*/("""">
      """),_display_(/*271.8*/param/*271.13*/.description),format.raw/*271.25*/("""
      """),format.raw/*272.7*/("""<br/>
      Expected type: """),_display_(/*273.23*/param/*273.28*/.dataType.description),format.raw/*273.49*/("""
    """),format.raw/*274.5*/("""</div>
  </div>
""")))};def /*141.2*/sortPlugins/*141.13*/(plugins: Seq[PluginDescription[_]]) = {{
  plugins.filterNot(_.categories.contains(PluginCategories.deprecated))
         .sortBy(_.label)
         .sortBy(_.categories.headOption.getOrElse("").toLowerCase)
}};def /*218.2*/createField/*218.13*/(pluginId: String, param: Parameter) = {{
  param.dataType match {
    case ParameterType.ResourceType | ParameterType.WritableResourceType => createResourceField(pluginId, param)
    case enum @ ParameterType.EnumerationType(_) => createEnumerationField(pluginId, param, enum.enumerationValues, enum.displayNames)
    case BooleanType => createEnumerationField(pluginId, param, Seq("true", "false"), Seq("True", "False"))
    case MultilineStringParameterType => createMultilineTextField(pluginId, param)
    case SparqlEndpointDatasetParameterType => createSparqlEndpointDatasetField(pluginId, param)
    case PasswordParameterType => createTextField(pluginId, param, inputType = "password")
    case _ => createTextField(pluginId, param)
  }
}};def /*281.2*/value/*281.7*/(pluginId: String, param: Parameter) = {{
  // Retrieve parameter value as Object
  val paramObj =
    currentObj match {
      case Some(obj) if obj.pluginSpec.id.toString == pluginId =>
        Option(param(obj))
      case _ =>
        param.defaultValue.flatMap(Option(_))
    }
  // Convert parameter value to string
  implicit val prefixes = project.config.prefixes
  val paramType = param.dataType.asInstanceOf[ParameterType[AnyRef]]
  val paramStr = paramObj.map(paramType.toString).getOrElse("")
  paramStr
}};
Seq[Any](format.raw/*17.1*/("""
"""),_display_(/*18.2*/dialog(title = title, submitLabel = submitLabel, secondaryLabel = secondaryLabel, width = 500, createDialog = createDialog)/*18.125*/ {_display_(Seq[Any](format.raw/*18.127*/("""
  """),format.raw/*19.3*/("""<div id="plugintabs">
    <div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label">
      <select class="mdl-selectfield__select" id="resource_type_select" name="resource_type_select">
        """),_display_(/*22.10*/for(plugin <- sortPlugins(plugins)) yield /*22.45*/ {_display_(Seq[Any](format.raw/*22.47*/("""
          """),format.raw/*23.11*/("""<option value=""""),_display_(/*23.27*/plugin/*23.33*/.id),format.raw/*23.36*/("""">"""),_display_(/*23.39*/pluginLabel(plugin)),format.raw/*23.58*/("""</option>
        """)))}),format.raw/*24.10*/("""
      """),format.raw/*25.7*/("""</select>
      <label class="mdl-selectfield__label" for="resource_type_select">Type</label>
    </div>
    <script type="text/javascript">
      var plugin_dialog_submit_delegates = """),format.raw/*29.44*/("""{"""),format.raw/*29.45*/("""}"""),format.raw/*29.46*/(""";
      // object to hold the different submit functions for each plugin type (e.g., CSV dataset, XML dataset, etc.)
      var plugin_autoconfigurable = """),format.raw/*31.37*/("""{"""),format.raw/*31.38*/("""}"""),format.raw/*31.39*/(""";
    </script>
    """),_display_(/*33.6*/for(plugin <- plugins) yield /*33.28*/ {_display_(Seq[Any](format.raw/*33.30*/("""
      """),_display_(/*34.8*/createTab(plugin)),format.raw/*34.25*/("""
    """)))}),format.raw/*35.6*/("""
  """),format.raw/*36.3*/("""</div>
  <script type="text/javascript">

    $(function() """),format.raw/*39.18*/("""{"""),format.raw/*39.19*/("""
      """),format.raw/*40.7*/("""function switch_resource_tab(type_id) """),format.raw/*40.45*/("""{"""),format.raw/*40.46*/("""
        """),format.raw/*41.9*/("""$(".resource-tab").hide();
        $("#" + type_id).show();
        if (plugin_autoconfigurable[type_id]) """),format.raw/*43.47*/("""{"""),format.raw/*43.48*/("""
          """),format.raw/*44.11*/("""$("#dialog-secondary-button").show();
        """),format.raw/*45.9*/("""}"""),format.raw/*45.10*/(""" """),format.raw/*45.11*/("""else """),format.raw/*45.16*/("""{"""),format.raw/*45.17*/("""
          """),format.raw/*46.11*/("""$("#dialog-secondary-button").hide();
        """),format.raw/*47.9*/("""}"""),format.raw/*47.10*/("""
      """),format.raw/*48.7*/("""}"""),format.raw/*48.8*/("""

      """),format.raw/*50.7*/("""$("#resource_type_select").change(function() """),format.raw/*50.52*/("""{"""),format.raw/*50.53*/("""
        """),format.raw/*51.9*/("""var selected_value = $("#resource_type_select option:selected").val();
        switch_resource_tab(selected_value);
      """),format.raw/*53.7*/("""}"""),format.raw/*53.8*/(""");

      """),_display_(/*55.8*/for(obj <- currentObj) yield /*55.30*/ {_display_(Seq[Any](format.raw/*55.32*/("""
        """),format.raw/*56.9*/("""$("#resource_type_select").val(""""),_display_(/*56.42*/obj/*56.45*/.pluginSpec.id),format.raw/*56.59*/("""").change();
      """)))}),format.raw/*57.8*/("""
      """),_display_(/*58.8*/if(currentObj.isEmpty)/*58.30*/ {_display_(Seq[Any](format.raw/*58.32*/("""
        """),format.raw/*59.9*/("""var first_plugin_id = '"""),_display_(/*59.33*/plugins/*59.40*/.head.id),format.raw/*59.48*/("""';
        $("#resource_type_select").val(first_plugin_id).change();
      """)))}/*61.9*/else/*61.14*/{_display_(Seq[Any](format.raw/*61.15*/("""
        """),format.raw/*62.9*/("""$("#resource_type_select").prop("disabled", "true");
      """)))}),format.raw/*63.8*/("""

      """),format.raw/*65.7*/("""// Add autocompletion for resources
      $(".input-resource").each(addResourceAutocomplete);

    """),format.raw/*68.5*/("""}"""),format.raw/*68.6*/(""");

    function addResourceAutocomplete(index, input) """),format.raw/*70.52*/("""{"""),format.raw/*70.53*/("""
      """),format.raw/*71.7*/("""var originalName = $(input).attr("value");
      $(input).autocomplete("""),format.raw/*72.29*/("""{"""),format.raw/*72.30*/("""
        """),format.raw/*73.9*/("""appendTo: "#plugintabs",
        source: function( request, response ) """),format.raw/*74.47*/("""{"""),format.raw/*74.48*/("""
          """),format.raw/*75.11*/("""const requestSearchTerm = request.term.toLowerCase();
          var searchTerm = requestSearchTerm;
          if(requestSearchTerm === originalName.toLowerCase()) """),format.raw/*77.64*/("""{"""),format.raw/*77.65*/("""
              """),format.raw/*78.15*/("""// If no search term was entered. i.e. the original selection is present show complete list
              searchTerm = "";
          """),format.raw/*80.11*/("""}"""),format.raw/*80.12*/("""
          """),format.raw/*81.11*/("""// Get list of all resources
          $.getJSON('"""),_display_(/*82.23*/config/*82.29*/.baseUrl),format.raw/*82.37*/("""/workspace/projects/"""),_display_(/*82.58*/project/*82.65*/.name),format.raw/*82.70*/("""/resources')
            .done(function(json) """),format.raw/*83.34*/("""{"""),format.raw/*83.35*/("""
              """),format.raw/*84.15*/("""// Convert list of resources to autocompletion values
              var filteredData = json.filter(function(res) """),format.raw/*85.60*/("""{"""),format.raw/*85.61*/(""" """),format.raw/*85.62*/("""return res.name.toLowerCase().includes(searchTerm) """),format.raw/*85.113*/("""}"""),format.raw/*85.114*/(""" """),format.raw/*85.115*/(""");
              var data = filteredData.map(function(resource) """),format.raw/*86.62*/("""{"""),format.raw/*86.63*/("""
                """),format.raw/*87.17*/("""return """),format.raw/*87.24*/("""{"""),format.raw/*87.25*/("""
                  """),format.raw/*88.19*/("""label: resource.name,
                  value: resource.name
                """),format.raw/*90.17*/("""}"""),format.raw/*90.18*/(""";
              """),format.raw/*91.15*/("""}"""),format.raw/*91.16*/(""");
              // Add original resource name to autocompletion
              var included = false
              for (var i = 0; i < data.length; i++) """),format.raw/*94.53*/("""{"""),format.raw/*94.54*/("""
                """),format.raw/*95.17*/("""if(data[i].label === originalName) """),format.raw/*95.52*/("""{"""),format.raw/*95.53*/("""
                    """),format.raw/*96.21*/("""included = true
                """),format.raw/*97.17*/("""}"""),format.raw/*97.18*/("""
              """),format.raw/*98.15*/("""}"""),format.raw/*98.16*/("""
              """),format.raw/*99.15*/("""if(! included) """),format.raw/*99.30*/("""{"""),format.raw/*99.31*/("""
                """),format.raw/*100.17*/("""// Always add original selection
                data.unshift("""),format.raw/*101.30*/("""{"""),format.raw/*101.31*/("""
                  """),format.raw/*102.19*/("""label: originalName,
                  value: originalName
                """),format.raw/*104.17*/("""}"""),format.raw/*104.18*/(""");
              """),format.raw/*105.15*/("""}"""),format.raw/*105.16*/("""

              """),format.raw/*107.15*/("""response(data);
            """),format.raw/*108.13*/("""}"""),format.raw/*108.14*/(""");
        """),format.raw/*109.9*/("""}"""),format.raw/*109.10*/(""",
        minLength: 0
      """),format.raw/*111.7*/("""}"""),format.raw/*111.8*/(""").focus(function() """),format.raw/*111.27*/("""{"""),format.raw/*111.28*/(""" """),format.raw/*111.29*/("""$(this).autocomplete("search"); """),format.raw/*111.61*/("""}"""),format.raw/*111.62*/(""");
    """),format.raw/*112.5*/("""}"""),format.raw/*112.6*/("""

    """),format.raw/*114.5*/("""function submit() """),format.raw/*114.23*/("""{"""),format.raw/*114.24*/("""
      """),format.raw/*115.7*/("""console.log("submit");
      var selected_resource_type = $("#resource_type_select").val();
      plugin_dialog_submit_delegates[selected_resource_type](false, """),format.raw/*117.69*/("""{"""),format.raw/*117.70*/("""
        """),format.raw/*118.9*/("""success: function() """),format.raw/*118.29*/("""{"""),format.raw/*118.30*/("""
          """),format.raw/*119.11*/("""closeDialog();
        """),format.raw/*120.9*/("""}"""),format.raw/*120.10*/(""" """),format.raw/*120.11*/(""",
        error: function(msg) """),format.raw/*121.30*/("""{"""),format.raw/*121.31*/("""
          """),format.raw/*122.11*/("""showError(msg)
        """),format.raw/*123.9*/("""}"""),format.raw/*123.10*/("""
      """),format.raw/*124.7*/("""}"""),format.raw/*124.8*/(""");
    """),format.raw/*125.5*/("""}"""),format.raw/*125.6*/("""

    """),format.raw/*127.5*/("""function showError(msg) """),format.raw/*127.29*/("""{"""),format.raw/*127.30*/("""
      """),format.raw/*128.7*/("""$("#primary_dialog .dialog__error-msg .mdl-alert__content").text(msg);
      $("#primary_dialog .dialog__error-msg").fadeIn();
    """),format.raw/*130.5*/("""}"""),format.raw/*130.6*/("""

    """),format.raw/*132.5*/("""function dialog_secondary() """),format.raw/*132.33*/("""{"""),format.raw/*132.34*/("""
      """),format.raw/*133.7*/("""var selected_resource_type = $("#resource_type_select").val();
      plugin_dialog_submit_delegates[selected_resource_type](true);
    """),format.raw/*135.5*/("""}"""),format.raw/*135.6*/("""

  """),format.raw/*137.3*/("""</script>
  """),_display_(/*138.4*/contents),format.raw/*138.12*/("""
""")))}),format.raw/*139.2*/("""

"""),format.raw/*145.2*/("""

"""),format.raw/*153.2*/("""

"""),format.raw/*213.2*/("""

"""),format.raw/*217.4*/("""
"""),format.raw/*228.2*/("""

"""),format.raw/*240.2*/("""

"""),format.raw/*244.2*/("""

"""),format.raw/*248.2*/("""

"""),format.raw/*264.2*/("""

"""),format.raw/*276.2*/("""

"""),format.raw/*280.4*/("""
"""))
      }
    }
  }

  def render(project:Project,name:String,plugins:Seq[PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
}],currentObj:Option[AnyPlugin],resources:List[String],title:String,submitLabel:String,secondaryLabel:String,createDialog:Boolean,contents:Html,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(project,name,plugins,currentObj,resources,title,submitLabel,secondaryLabel,createDialog)(contents)(userContext)

  def f:((Project,String,Seq[PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
}],Option[AnyPlugin],List[String],String,String,String,Boolean) => (Html) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (project,name,plugins,currentObj,resources,title,submitLabel,secondaryLabel,createDialog) => (contents) => (userContext) => apply(project,name,plugins,currentObj,resources,title,submitLabel,secondaryLabel,createDialog)(contents)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/widgets/pluginDialog.scala.html
                  HASH: 8c100daec80eae2cb65b6db4955468c66fc68c18
                  MATRIX: 440->1|510->65|573->122|677->220|727->264|788->320|1339->378|1742->5258|1763->5269|1875->5303|1906->5307|1976->5367|2017->5369|2050->5375|2066->5381|2094->5387|2117->5392|2131->5397|2171->5398|2204->5404|2220->5410|2248->5416|2278->5417|2308->5419|2324->5425|2372->5451|2408->5456|2434->5461|2453->5470|2565->5504|2596->5507|2634->5517|2650->5523|2675->5526|2741->5565|2757->5571|2791->5583|2824->5588|2862->5599|2888->5615|2929->5617|2964->5624|3128->5760|3161->5771|3203->5785|3236->5796|3280->5811|3307->5815|3390->5870|3423->5881|3492->5919|3526->5926|3574->5957|3615->5959|3650->5967|3685->5992|3726->5994|3764->6004|3815->6033|3854->6041|3891->6047|3923->6051|4007->6107|4040->6118|4107->6156|4137->6157|4172->6164|4241->6206|4267->6222|4308->6224|4345->6233|4397->6257|4430->6268|4474->6294|4488->6299|4528->6300|4565->6309|4606->6322|4632->6326|4673->6336|4708->6343|4759->6365|4789->6366|4826->6375|4911->6432|4940->6433|4976->6441|5062->6498|5092->6499|5122->6500|5158->6509|5206->6540|5247->6542|5284->6551|5325->6564|5340->6569|5367->6574|5412->6591|5445->6602|5475->6604|5509->6616|5560->6636|5596->6644|5671->6690|5701->6691|5738->6700|5779->6713|5795->6719|5820->6722|5887->6761|5916->6762|5945->6763|5979->6768|6009->6769|6046->6778|6090->6794|6106->6800|6131->6803|6187->6831|6216->6832|6252->6840|6297->6857|6326->6858|6360->6864|6421->6897|6437->6903|6462->6906|6496->6912|6529->6923|6569->6936|6661->7018|6702->7020|6737->7027|6791->7053|6807->7059|6832->7062|6867->7079|6881->7084|6921->7085|6956->7092|7010->7118|7026->7124|7051->7127|7099->7144|7131->7148|7166->7976|7191->7991|7337->8059|7368->8062|7518->8184|7549->8193|7584->8200|7616->8210|7646->8212|7680->8224|7717->8233|7750->8243|7781->8245|7816->8257|7855->8267|7900->8289|7978->8339|8010->8349|8040->8351|8074->8363|8105->8366|8120->8371|8148->8377|8239->8440|8271->8450|8301->8452|8335->8464|8372->8474|8387->8479|8421->8491|8456->8498|8512->8526|8527->8531|8570->8552|8603->8557|8643->8576|8677->8600|8795->8640|8826->8644|8843->8651|9058->8843|9084->8848|9126->8880|9280->8955|9311->8959|9328->8966|9519->9134|9545->9139|9577->9161|9755->9260|9786->9263|9944->9393|9976->9403|10006->9405|10040->9417|10077->9426|10109->9436|10139->9438|10174->9450|10210->9459|10302->9534|10343->9536|10378->9543|10422->9559|10462->9577|10493->9580|10549->9626|10590->9628|10620->9629|10674->9650|10705->9652|10739->9663|10785->9678|10818->9683|10904->9741|10936->9751|10966->9753|11000->9765|11031->9768|11046->9773|11074->9779|11165->9842|11197->9852|11227->9854|11261->9866|11298->9876|11313->9881|11347->9893|11382->9900|11438->9928|11453->9933|11496->9954|11529->9959|11570->9979|11599->9998|11717->10038|11748->10041|11920->10185|11952->10195|11982->10197|12016->10209|12053->10218|12086->10228|12117->10230|12152->10242|12191->10252|12236->10274|12317->10327|12349->10337|12379->10339|12413->10351|12444->10354|12459->10359|12487->10365|12578->10428|12610->10438|12640->10440|12674->10452|12711->10462|12726->10467|12760->10479|12795->10486|12851->10514|12866->10519|12909->10540|12942->10545|12983->5035|13004->5046|13228->7216|13249->7227|14010->10620|14024->10625|14571->702|14599->704|14732->827|14773->829|14803->832|15047->1049|15098->1084|15138->1086|15177->1097|15220->1113|15235->1119|15259->1122|15289->1125|15329->1144|15379->1163|15413->1170|15625->1354|15654->1355|15683->1356|15864->1509|15893->1510|15922->1511|15969->1532|16007->1554|16047->1556|16081->1564|16119->1581|16155->1587|16185->1590|16272->1649|16301->1650|16335->1657|16401->1695|16430->1696|16466->1705|16600->1811|16629->1812|16668->1823|16741->1869|16770->1870|16799->1871|16832->1876|16861->1877|16900->1888|16973->1934|17002->1935|17036->1942|17064->1943|17099->1951|17172->1996|17201->1997|17237->2006|17386->2128|17414->2129|17451->2140|17489->2162|17529->2164|17565->2173|17625->2206|17637->2209|17672->2223|17722->2243|17756->2251|17787->2273|17827->2275|17863->2284|17914->2308|17930->2315|17959->2323|18053->2400|18066->2405|18105->2406|18141->2415|18231->2475|18266->2483|18392->2582|18420->2583|18503->2638|18532->2639|18566->2646|18665->2717|18694->2718|18730->2727|18829->2798|18858->2799|18897->2810|19088->2973|19117->2974|19160->2989|19321->3122|19350->3123|19389->3134|19467->3185|19482->3191|19511->3199|19559->3220|19575->3227|19601->3232|19675->3278|19704->3279|19747->3294|19888->3407|19917->3408|19946->3409|20026->3460|20056->3461|20086->3462|20178->3526|20207->3527|20252->3544|20287->3551|20316->3552|20363->3571|20468->3648|20497->3649|20541->3665|20570->3666|20750->3818|20779->3819|20824->3836|20887->3871|20916->3872|20965->3893|21025->3925|21054->3926|21097->3941|21126->3942|21169->3957|21212->3972|21241->3973|21287->3990|21378->4052|21408->4053|21456->4072|21560->4147|21590->4148|21636->4165|21666->4166|21711->4182|21768->4210|21798->4211|21837->4222|21867->4223|21924->4252|21953->4253|22001->4272|22031->4273|22061->4274|22122->4306|22152->4307|22187->4314|22216->4315|22250->4321|22297->4339|22327->4340|22362->4347|22551->4507|22581->4508|22618->4517|22667->4537|22697->4538|22737->4549|22788->4572|22818->4573|22848->4574|22908->4605|22938->4606|22978->4617|23029->4640|23059->4641|23094->4648|23123->4649|23158->4656|23187->4657|23221->4663|23274->4687|23304->4688|23339->4695|23498->4826|23527->4827|23561->4833|23618->4861|23648->4862|23683->4869|23846->5004|23875->5005|23907->5009|23947->5022|23977->5030|24010->5032|24040->5255|24070->5458|24100->7159|24130->7214|24159->7973|24189->8573|24219->8845|24249->9136|24279->9976|24309->10562|24339->10618
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->7|29->8|41->147|41->147|43->147|44->148|44->148|44->148|45->149|45->149|45->149|46->150|46->150|46->150|47->151|47->151|47->151|47->151|47->151|47->151|47->151|48->152|49->155|49->155|51->155|52->156|52->156|52->156|52->156|54->158|54->158|54->158|55->159|57->161|57->161|57->161|58->162|59->163|59->163|59->163|59->163|59->163|59->163|60->164|60->164|62->166|64->168|64->168|64->168|65->169|65->169|65->169|66->170|66->170|67->171|68->172|70->174|73->177|73->177|73->177|73->177|74->178|75->179|75->179|75->179|76->180|76->180|76->180|77->181|77->181|77->181|78->182|78->182|78->182|79->183|80->184|80->184|80->184|81->185|83->187|83->187|85->189|86->190|86->190|86->190|87->191|87->191|87->191|88->192|88->192|88->192|88->192|88->192|88->192|88->192|88->192|89->193|91->195|92->196|92->196|93->197|93->197|93->197|93->197|94->198|94->198|94->198|94->198|94->198|95->199|95->199|95->199|95->199|96->200|96->200|98->202|99->203|99->203|101->205|101->205|101->205|101->205|101->205|101->205|102->206|102->206|102->206|103->207|103->207|103->207|103->207|104->208|104->208|104->208|105->209|105->209|105->209|105->209|106->210|108->212|109->230|109->230|111->230|112->231|113->232|113->232|113->232|113->232|113->232|113->232|113->232|113->232|113->232|113->232|113->232|113->232|114->233|114->233|114->233|114->233|114->233|114->233|114->233|115->234|115->234|115->234|115->234|116->235|116->235|116->235|117->236|118->237|118->237|118->237|119->238|121->242|121->242|123->242|124->243|124->243|124->243|125->246|125->246|127->246|128->247|128->247|128->247|129->250|129->250|131->250|132->251|133->252|133->252|133->252|133->252|133->252|133->252|133->252|133->252|134->253|134->253|134->253|135->254|135->254|135->254|135->254|135->254|135->254|135->254|135->254|135->254|135->254|136->255|137->256|138->257|138->257|138->257|138->257|138->257|138->257|138->257|139->258|139->258|139->258|139->258|140->259|140->259|140->259|141->260|142->261|142->261|142->261|143->262|145->266|145->266|147->266|148->267|149->268|149->268|149->268|149->268|149->268|149->268|149->268|149->268|149->268|149->268|150->269|150->269|150->269|150->269|150->269|150->269|150->269|151->270|151->270|151->270|151->270|152->271|152->271|152->271|153->272|154->273|154->273|154->273|155->274|157->141|157->141|161->218|161->218|171->281|171->281|186->17|187->18|187->18|187->18|188->19|191->22|191->22|191->22|192->23|192->23|192->23|192->23|192->23|192->23|193->24|194->25|198->29|198->29|198->29|200->31|200->31|200->31|202->33|202->33|202->33|203->34|203->34|204->35|205->36|208->39|208->39|209->40|209->40|209->40|210->41|212->43|212->43|213->44|214->45|214->45|214->45|214->45|214->45|215->46|216->47|216->47|217->48|217->48|219->50|219->50|219->50|220->51|222->53|222->53|224->55|224->55|224->55|225->56|225->56|225->56|225->56|226->57|227->58|227->58|227->58|228->59|228->59|228->59|228->59|230->61|230->61|230->61|231->62|232->63|234->65|237->68|237->68|239->70|239->70|240->71|241->72|241->72|242->73|243->74|243->74|244->75|246->77|246->77|247->78|249->80|249->80|250->81|251->82|251->82|251->82|251->82|251->82|251->82|252->83|252->83|253->84|254->85|254->85|254->85|254->85|254->85|254->85|255->86|255->86|256->87|256->87|256->87|257->88|259->90|259->90|260->91|260->91|263->94|263->94|264->95|264->95|264->95|265->96|266->97|266->97|267->98|267->98|268->99|268->99|268->99|269->100|270->101|270->101|271->102|273->104|273->104|274->105|274->105|276->107|277->108|277->108|278->109|278->109|280->111|280->111|280->111|280->111|280->111|280->111|280->111|281->112|281->112|283->114|283->114|283->114|284->115|286->117|286->117|287->118|287->118|287->118|288->119|289->120|289->120|289->120|290->121|290->121|291->122|292->123|292->123|293->124|293->124|294->125|294->125|296->127|296->127|296->127|297->128|299->130|299->130|301->132|301->132|301->132|302->133|304->135|304->135|306->137|307->138|307->138|308->139|310->145|312->153|314->213|316->217|317->228|319->240|321->244|323->248|325->264|327->276|329->280
                  -- GENERATED --
              */
          