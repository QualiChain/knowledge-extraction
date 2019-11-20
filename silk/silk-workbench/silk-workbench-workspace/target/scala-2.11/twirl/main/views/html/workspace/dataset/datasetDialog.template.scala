
package views.html.workspace.dataset

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
/*1.2*/import org.silkframework.dataset.Dataset
/*2.2*/import org.silkframework.workspace.Project
/*3.2*/import org.silkframework.dataset.DatasetSpec.GenericDatasetSpec
/*4.2*/import org.silkframework.runtime.activity.UserContext

object datasetDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[Project,String,Option[GenericDatasetSpec],String,Boolean,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(project: Project, datasetName: String, dataset: Option[GenericDatasetSpec], title: String = "Edit Dataset", createDialog: Boolean = false)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.1*/("""
"""),_display_(/*8.2*/widgets/*8.9*/.pluginDialog(
  project,
  name = datasetName,
  plugins = Dataset.availablePlugins,
  currentObj = dataset.map(_.plugin),
  resources = project.resources.listRecursive,
  title = title,
  submitLabel = "Save",
  secondaryLabel = "Autoconfigure",
  createDialog = createDialog)/*17.31*/ {_display_(Seq[Any](format.raw/*17.33*/("""

    """),format.raw/*19.5*/("""<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
      <input class="mdl-textfield__input" type="text" id="dataset_uriProperty" name="dataset_uriProperty" value=""""),_display_(/*20.115*/dataset/*20.122*/.flatMap(_.uriProperty.map(_.uri)).getOrElse("")),format.raw/*20.170*/(""""/>
      <label class="mdl-textfield__label" for="dataset_uriProperty">URI attribute</label>
      <div class="mdl-tooltip mdl-tooltip--right" for="dataset_uriProperty">
        When reading data from the dataset, the specified attribute will be used to get the URIs of the entities. When writing to a dataset, the specified attribute will be automatically added to the schema as well as the generated entity URIs will be added as values for each entity."
      </div>
    </div>

    <script type="text/javascript">
      function savePlugin(pluginId, name, parameters, callbacks) """),format.raw/*28.66*/("""{"""),format.raw/*28.67*/("""
        """),format.raw/*29.9*/("""// Build dataset json
        var json = """),format.raw/*30.20*/("""{"""),format.raw/*30.21*/("""
          """),format.raw/*31.11*/("""id: name,
          data: """),format.raw/*32.17*/("""{"""),format.raw/*32.18*/("""
            """),format.raw/*33.13*/("""taskType: "Dataset",
            type: pluginId,
            uriProperty: $('#dataset_uriProperty').val(),
            parameters: parameters
          """),format.raw/*37.11*/("""}"""),format.raw/*37.12*/("""
        """),format.raw/*38.9*/("""}"""),format.raw/*38.10*/(""";

        // Submit data source
        """),_display_(/*41.10*/if(createDialog)/*41.26*/ {_display_(Seq[Any](format.raw/*41.28*/("""
          """),format.raw/*42.11*/("""postTask('"""),_display_(/*42.22*/project/*42.29*/.name),format.raw/*42.34*/("""', json, callbacks);
        """)))}/*43.11*/else/*43.16*/{_display_(Seq[Any](format.raw/*43.17*/("""
          """),format.raw/*44.11*/("""putTask('"""),_display_(/*44.21*/project/*44.28*/.name),format.raw/*44.33*/("""', name, json, callbacks);
        """)))}),format.raw/*45.10*/("""
      """),format.raw/*46.7*/("""}"""),format.raw/*46.8*/("""

      """),format.raw/*48.7*/("""function autoConfigure(pluginId, name, parameters) """),format.raw/*48.58*/("""{"""),format.raw/*48.59*/("""
        """),format.raw/*49.9*/("""var queryString = $.param(parameters);
        var path = '"""),_display_(/*50.22*/config/*50.28*/.baseUrl),format.raw/*50.36*/("""/workspace/dialogs/editDatasetAutoConfigured/"""),_display_(/*50.82*/project/*50.89*/.name),format.raw/*50.94*/("""/' + name + '/' + pluginId + '?' + queryString;
        closeDialog();
        showDialog(path);
      """),format.raw/*53.7*/("""}"""),format.raw/*53.8*/("""
    """),format.raw/*54.5*/("""</script>
  """)))}))
      }
    }
  }

  def render(project:Project,datasetName:String,dataset:Option[GenericDatasetSpec],title:String,createDialog:Boolean,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(project,datasetName,dataset,title,createDialog)(userContext)

  def f:((Project,String,Option[GenericDatasetSpec],String,Boolean) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (project,datasetName,dataset,title,createDialog) => (userContext) => apply(project,datasetName,dataset,title,createDialog)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/dataset/datasetDialog.scala.html
                  HASH: cb66b603d097f88ff2d9ab8efac9e49cd7958a73
                  MATRIX: 450->1|498->43|548->87|619->152|1047->208|1315->383|1342->385|1356->392|1643->670|1683->672|1716->678|1933->867|1950->874|2020->922|2631->1505|2660->1506|2696->1515|2765->1556|2794->1557|2833->1568|2887->1594|2916->1595|2957->1608|3137->1760|3166->1761|3202->1770|3231->1771|3300->1813|3325->1829|3365->1831|3404->1842|3442->1853|3458->1860|3484->1865|3533->1896|3546->1901|3585->1902|3624->1913|3661->1923|3677->1930|3703->1935|3770->1971|3804->1978|3832->1979|3867->1987|3946->2038|3975->2039|4011->2048|4098->2108|4113->2114|4142->2122|4215->2168|4231->2175|4257->2180|4387->2283|4415->2284|4447->2289
                  LINES: 17->1|18->2|19->3|20->4|25->6|30->7|31->8|31->8|40->17|40->17|42->19|43->20|43->20|43->20|51->28|51->28|52->29|53->30|53->30|54->31|55->32|55->32|56->33|60->37|60->37|61->38|61->38|64->41|64->41|64->41|65->42|65->42|65->42|65->42|66->43|66->43|66->43|67->44|67->44|67->44|67->44|68->45|69->46|69->46|71->48|71->48|71->48|72->49|73->50|73->50|73->50|73->50|73->50|73->50|76->53|76->53|77->54
                  -- GENERATED --
              */
          