
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

object prefixDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,org.silkframework.config.Prefixes,org.silkframework.config.Prefixes,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(project: String,
  prefixes: org.silkframework.config.Prefixes,
  knownPrefixes: org.silkframework.config.Prefixes):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""
"""),_display_(/*5.2*/widgets/*5.9*/.dialog(title = "Edit Prefixes", submitLabel = "Save Prefixes")/*5.72*/ {_display_(Seq[Any](format.raw/*5.74*/("""
  """),format.raw/*6.3*/("""<div class="ecc-table__wrapper">
    <table id="prefixTable" class="mdl-data-table mdl-data-table--full-width">
      <thead>
        <tr>
          <th>Prefix</th>
          <th style="width: 16px;" ></th>
        </tr>
      </thead>
      <tbody>
      """),_display_(/*15.8*/for(prefix <- prefixes) yield /*15.31*/ {_display_(Seq[Any](format.raw/*15.33*/("""
        """),format.raw/*16.9*/("""<tr class="prefix_dialog-row">
          <td>
            <div class="mdl-textfield mdl-js-textfield prefix_dialog-prefix mdl-textfield--reduced mdl-textfield--full-width" style="padding-top: 0;">
              <input class="mdl-textfield__input" type="text" value=""""),_display_(/*19.71*/prefix/*19.77*/._1),format.raw/*19.80*/(""": """),_display_(/*19.83*/prefix/*19.89*/._2),format.raw/*19.92*/(""""/>
            </div>
          </td>
          <td>
            <button type="button" class="mdl-button mdl-js-button mdl-button--icon" onclick="$(this).parent().parent().remove()">
              <i class="material-icons">delete</i>
            </button>
          </td>
        </tr>
      """)))}),format.raw/*28.8*/("""
        """),format.raw/*29.9*/("""<tr>
          <td></td>
          <td>
            <button type="button" class="mdl-button mdl-js-button mdl-button--icon" onclick="addRow()">
              <i class="material-icons">add</i>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  <script type="text/javascript">
    // Array which contains all known prefixes
    var availablePrefixes = [
      """),_display_(/*43.8*/for(prefix <- knownPrefixes) yield /*43.36*/ {_display_(Seq[Any](format.raw/*43.38*/("""
        """),format.raw/*44.9*/("""""""),_display_(/*44.11*/prefix/*44.17*/._1),format.raw/*44.20*/(""": """),_display_(/*44.23*/prefix/*44.29*/._2),format.raw/*44.32*/("""",
      """)))}),format.raw/*45.8*/("""
    """),format.raw/*46.5*/("""];

    $("#prefixTable input").autocomplete("""),format.raw/*48.42*/("""{"""),format.raw/*48.43*/(""" """),format.raw/*48.44*/("""appendTo: '#dialog-form', source: availablePrefixes """),format.raw/*48.96*/("""}"""),format.raw/*48.97*/(""");

    //Adds a new prefix row
    function addRow() """),format.raw/*51.23*/("""{"""),format.raw/*51.24*/("""
      """),format.raw/*52.7*/("""var row = '<tr class="prefix_dialog-row is-selected"> \
        <td> \
          <div class="mdl-textfield mdl-js-textfield prefix_dialog-prefix mdl-textfield--reduced mdl-textfield--full-width" style="padding-top: 0;"> \
            <input class="mdl-textfield__input" type="text" value=""/> \
          </div> \
        </td> \
        <td> \
            <button type="button" class="mdl-button mdl-js-button mdl-button--icon" onclick="$(this).parent().parent().remove()"> \
              <i class="material-icons">delete</i> \
            </button> \
        </td> \
      </tr>';
      $('#prefixTable tbody tr').last().before(row);
      $("#prefixTable input").autocomplete("""),format.raw/*65.44*/("""{"""),format.raw/*65.45*/(""" """),format.raw/*65.46*/("""appendTo: '#dialog-form', source: availablePrefixes """),format.raw/*65.98*/("""}"""),format.raw/*65.99*/(""");
    """),format.raw/*66.5*/("""}"""),format.raw/*66.6*/("""

    """),format.raw/*68.5*/("""function submit() """),format.raw/*68.23*/("""{"""),format.raw/*68.24*/("""
      """),format.raw/*69.7*/("""var data = $('#prefixTable .prefix_dialog-row input').map(function() """),format.raw/*69.76*/("""{"""),format.raw/*69.77*/("""
        """),format.raw/*70.9*/("""var value = this.value;
        var i = value.indexOf(':');
        return """),format.raw/*72.16*/("""{"""),format.raw/*72.17*/(""" """),format.raw/*72.18*/("""name: value.substr(0, i).trim(), value: value.substr(i + 1).trim() """),format.raw/*72.85*/("""}"""),format.raw/*72.86*/(""";
      """),format.raw/*73.7*/("""}"""),format.raw/*73.8*/(""");

      $.ajax("""),format.raw/*75.14*/("""{"""),format.raw/*75.15*/("""
        """),format.raw/*76.9*/("""type: 'PUT',
        url: '"""),_display_(/*77.16*/config/*77.22*/.baseUrl),format.raw/*77.30*/("""/workspace/projects/"""),_display_(/*77.51*/project),format.raw/*77.58*/("""/prefixes',
        data: data,
        success: function(data) """),format.raw/*79.33*/("""{"""),format.raw/*79.34*/("""
          """),format.raw/*80.11*/("""closeDialog();
        """),format.raw/*81.9*/("""}"""),format.raw/*81.10*/(""",
        error: function(request) """),format.raw/*82.34*/("""{"""),format.raw/*82.35*/("""
          """),format.raw/*83.11*/("""alert(request.responseText);
        """),format.raw/*84.9*/("""}"""),format.raw/*84.10*/("""
      """),format.raw/*85.7*/("""}"""),format.raw/*85.8*/(""");
    """),format.raw/*86.5*/("""}"""),format.raw/*86.6*/("""
  """),format.raw/*87.3*/("""</script>
""")))}))
      }
    }
  }

  def render(project:String,prefixes:org.silkframework.config.Prefixes,knownPrefixes:org.silkframework.config.Prefixes): play.twirl.api.HtmlFormat.Appendable = apply(project,prefixes,knownPrefixes)

  def f:((String,org.silkframework.config.Prefixes,org.silkframework.config.Prefixes) => play.twirl.api.HtmlFormat.Appendable) = (project,prefixes,knownPrefixes) => apply(project,prefixes,knownPrefixes)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/prefixDialog.scala.html
                  HASH: 86327542cf461a681a7d9d1d34b32534680212e9
                  MATRIX: 814->1|1024->118|1051->120|1065->127|1136->190|1175->192|1204->195|1487->452|1526->475|1566->477|1602->486|1896->753|1911->759|1935->762|1965->765|1980->771|2004->774|2328->1068|2364->1077|2789->1476|2833->1504|2873->1506|2909->1515|2938->1517|2953->1523|2977->1526|3007->1529|3022->1535|3046->1538|3086->1548|3118->1553|3191->1598|3220->1599|3249->1600|3329->1652|3358->1653|3440->1707|3469->1708|3503->1715|4211->2395|4240->2396|4269->2397|4349->2449|4378->2450|4412->2457|4440->2458|4473->2464|4519->2482|4548->2483|4582->2490|4679->2559|4708->2560|4744->2569|4847->2644|4876->2645|4905->2646|5000->2713|5029->2714|5064->2722|5092->2723|5137->2740|5166->2741|5202->2750|5257->2778|5272->2784|5301->2792|5349->2813|5377->2820|5469->2884|5498->2885|5537->2896|5587->2919|5616->2920|5679->2955|5708->2956|5747->2967|5811->3004|5840->3005|5874->3012|5902->3013|5936->3020|5964->3021|5994->3024
                  LINES: 21->1|28->4|29->5|29->5|29->5|29->5|30->6|39->15|39->15|39->15|40->16|43->19|43->19|43->19|43->19|43->19|43->19|52->28|53->29|67->43|67->43|67->43|68->44|68->44|68->44|68->44|68->44|68->44|68->44|69->45|70->46|72->48|72->48|72->48|72->48|72->48|75->51|75->51|76->52|89->65|89->65|89->65|89->65|89->65|90->66|90->66|92->68|92->68|92->68|93->69|93->69|93->69|94->70|96->72|96->72|96->72|96->72|96->72|97->73|97->73|99->75|99->75|100->76|101->77|101->77|101->77|101->77|101->77|103->79|103->79|104->80|105->81|105->81|106->82|106->82|107->83|108->84|108->84|109->85|109->85|110->86|110->86|111->87
                  -- GENERATED --
              */
          