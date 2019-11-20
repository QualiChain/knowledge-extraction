
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

object prefixDialog_improved extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,org.silkframework.config.Prefixes,org.silkframework.config.Prefixes,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(project: String,
  prefixes: org.silkframework.config.Prefixes,
  knownPrefixes: org.silkframework.config.Prefixes):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""
"""),_display_(/*5.2*/widgets/*5.9*/.dialog(title = "Edit Prefixes", submitLabel = "Save Prefixes")/*5.72*/ {_display_(Seq[Any](format.raw/*5.74*/("""
  """),format.raw/*6.3*/("""<table id="prefixTable" class="mdl-data-table mdl-js-data-table">
    <thead>
      <tr>
        <th class="mdl-data-table__cell--non-numeric">Prefix</th>
        <th class="mdl-data-table__cell--non-numeric">URI</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    """),_display_(/*15.6*/for(prefix <- prefixes) yield /*15.29*/ {_display_(Seq[Any](format.raw/*15.31*/("""
      """),format.raw/*16.7*/("""<tr class="prefix_dialog-row">
        <td class="mdl-data-table__cell--non-numeric">
          <div class="mdl-textfield mdl-js-textfield prefix_dialog-prefix">
            <input class="mdl-textfield__input" type="text" value=""""),_display_(/*19.69*/prefix/*19.75*/._1),format.raw/*19.78*/(""""/>
          </div>
        <td class="mdl-data-table__cell--non-numeric">
          <div class="mdl-textfield mdl-js-textfield prefix_dialog-uri">
            <input class="mdl-textfield__input" type="text" value=""""),_display_(/*23.69*/prefix/*23.75*/._2),format.raw/*23.78*/(""""/>
          </div>
        <td>
          <button type="button" class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab" onclick="$(this).parent().parent().remove()">
            <i class="material-icons">remove</i>
          </button>
        </td>
      </tr>
    """)))}),format.raw/*31.6*/("""
      """),format.raw/*32.7*/("""<tr>
        <td></td>
        <td></td>
        <td>
          <button type="button" class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab" onclick="addRow()">
            <i class="material-icons">add</i>
          </button>
        </td>
      </tr>
    </tbody>
  </table>

  <script type="text/javascript">
    // Array which contains all known prefixes
    // var availablePrefixes = [
    //  """),_display_(/*47.10*/for(prefix <- knownPrefixes) yield /*47.38*/ {_display_(Seq[Any](format.raw/*47.40*/("""
    """),format.raw/*48.5*/("""//    """"),_display_(/*48.13*/prefix/*48.19*/._2),format.raw/*48.22*/("""",
    //  """)))}),format.raw/*49.10*/("""
    """),format.raw/*50.5*/("""//];

    // $(".prefix_dialog-uri input").autocomplete("""),format.raw/*52.51*/("""{"""),format.raw/*52.52*/(""" """),format.raw/*52.53*/("""source: availablePrefixes """),format.raw/*52.79*/("""}"""),format.raw/*52.80*/(""");

    //Adds a new prefix row
    function addRow() """),format.raw/*55.23*/("""{"""),format.raw/*55.24*/("""
      """),format.raw/*56.7*/("""var row = '<tr class="prefix_dialog-row"> \
        <td class="mdl-data-table__cell--non-numeric"> \
          <div class="mdl-textfield mdl-js-textfield prefix_dialog-prefix"> \
            <input class="mdl-textfield__input" type="text" value=""/> \
          </div> \
        </td> \
        <td class="mdl-data-table__cell--non-numeric"> \
          <div class="mdl-textfield mdl-js-textfield prefix_dialog-uri"> \
            <input class="mdl-textfield__input" type="text" value=""/> \
          </div> \
        </td> \
        <td> \
          <button type="button" class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab" onclick="$(this).parent().parent().remove()"> \
            <i class="material-icons">remove</i> \
          </button> \
        </td> \
      </tr>';
      $('#prefixTable tbody tr').last().before(row);
      // $(".prefix_dialog-uri input").autocomplete("""),format.raw/*74.53*/("""{"""),format.raw/*74.54*/(""" """),format.raw/*74.55*/("""source: availablePrefixes """),format.raw/*74.81*/("""}"""),format.raw/*74.82*/(""");
    """),format.raw/*75.5*/("""}"""),format.raw/*75.6*/("""

    """),format.raw/*77.5*/("""function submit() """),format.raw/*77.23*/("""{"""),format.raw/*77.24*/("""
      """),format.raw/*78.7*/("""var data = $('#prefixTable .prefix_dialog-row').map(function() """),format.raw/*78.70*/("""{"""),format.raw/*78.71*/("""
        """),format.raw/*79.9*/("""var prefix = $(this).find(".prefix_dialog-prefix input").val();
        var uri = $(this).find(".prefix_dialog-uri input").val();
        return """),format.raw/*81.16*/("""{"""),format.raw/*81.17*/(""" """),format.raw/*81.18*/("""name: prefix.trim(), value: uri.trim() """),format.raw/*81.57*/("""}"""),format.raw/*81.58*/(""";
      """),format.raw/*82.7*/("""}"""),format.raw/*82.8*/(""");

      $.ajax("""),format.raw/*84.14*/("""{"""),format.raw/*84.15*/("""
        """),format.raw/*85.9*/("""type: 'PUT',
        url: '"""),_display_(/*86.16*/config/*86.22*/.baseUrl),format.raw/*86.30*/("""/workspace/projects/"""),_display_(/*86.51*/project),format.raw/*86.58*/("""/prefixes',
        data: data,
        success: function(data) """),format.raw/*88.33*/("""{"""),format.raw/*88.34*/("""
          """),format.raw/*89.11*/("""closeDialog();
        """),format.raw/*90.9*/("""}"""),format.raw/*90.10*/(""",
        error: function(request) """),format.raw/*91.34*/("""{"""),format.raw/*91.35*/("""
          """),format.raw/*92.11*/("""alert(request.responseText);
        """),format.raw/*93.9*/("""}"""),format.raw/*93.10*/("""
      """),format.raw/*94.7*/("""}"""),format.raw/*94.8*/(""");
    """),format.raw/*95.5*/("""}"""),format.raw/*95.6*/("""
  """),format.raw/*96.3*/("""</script>
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
                  DATE: Tue Jul 30 22:35:14 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/prefixDialog_improved.scala.html
                  HASH: 95965699ae68040aab1ca1e8c10a851ef56461d6
                  MATRIX: 823->1|1033->118|1060->120|1074->127|1145->190|1184->192|1213->195|1517->473|1556->496|1596->498|1630->505|1887->735|1902->741|1926->744|2170->961|2185->967|2209->970|2521->1252|2555->1259|2998->1675|3042->1703|3082->1705|3114->1710|3149->1718|3164->1724|3188->1727|3231->1739|3263->1744|3347->1800|3376->1801|3405->1802|3459->1828|3488->1829|3570->1883|3599->1884|3633->1891|4561->2791|4590->2792|4619->2793|4673->2819|4702->2820|4736->2827|4764->2828|4797->2834|4843->2852|4872->2853|4906->2860|4997->2923|5026->2924|5062->2933|5235->3078|5264->3079|5293->3080|5360->3119|5389->3120|5424->3128|5452->3129|5497->3146|5526->3147|5562->3156|5617->3184|5632->3190|5661->3198|5709->3219|5737->3226|5829->3290|5858->3291|5897->3302|5947->3325|5976->3326|6039->3361|6068->3362|6107->3373|6171->3410|6200->3411|6234->3418|6262->3419|6296->3426|6324->3427|6354->3430
                  LINES: 21->1|28->4|29->5|29->5|29->5|29->5|30->6|39->15|39->15|39->15|40->16|43->19|43->19|43->19|47->23|47->23|47->23|55->31|56->32|71->47|71->47|71->47|72->48|72->48|72->48|72->48|73->49|74->50|76->52|76->52|76->52|76->52|76->52|79->55|79->55|80->56|98->74|98->74|98->74|98->74|98->74|99->75|99->75|101->77|101->77|101->77|102->78|102->78|102->78|103->79|105->81|105->81|105->81|105->81|105->81|106->82|106->82|108->84|108->84|109->85|110->86|110->86|110->86|110->86|110->86|112->88|112->88|113->89|114->90|114->90|115->91|115->91|116->92|117->93|117->93|118->94|118->94|119->95|119->95|120->96
                  -- GENERATED --
              */
          