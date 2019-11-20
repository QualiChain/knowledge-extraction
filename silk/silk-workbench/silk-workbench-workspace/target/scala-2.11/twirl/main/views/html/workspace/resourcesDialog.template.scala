
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

object resourcesDialog extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,org.silkframework.runtime.resource.ResourceLoader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(project: String, resourceLoader: org.silkframework.runtime.resource.ResourceLoader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import controllers.workspace.routes.Assets


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/widgets/*5.9*/.dialog(title = "Manage Resources", width = 500)/*5.57*/ {_display_(Seq[Any](format.raw/*5.59*/("""
"""),format.raw/*6.1*/("""<div class="mdl-grid" style="width: 500px">

  <div id="resource-resources-box" class="mdl-cell mdl-cell--12-col">
    """),_display_(/*9.6*/for((resource, index) <- resourceLoader.listRecursive.zipWithIndex) yield /*9.73*/ {_display_(Seq[Any](format.raw/*9.75*/("""
    """),format.raw/*10.5*/("""<div id="resource"""),_display_(/*10.23*/index),format.raw/*10.28*/("""" class="resource-chip mdl-shadow--2dp">
      <span class="resource-chip-label">"""),_display_(/*11.42*/resource),format.raw/*11.50*/("""</span>
      <!--
      <img class="button-delete" title="Delete" onclick="deleteResourceDialog("""),_display_(/*13.80*/index),format.raw/*13.85*/(""", '"""),_display_(/*13.89*/resource),format.raw/*13.97*/("""')" src=""""),_display_(/*13.107*/Assets/*13.113*/.at("img/cross.png")),format.raw/*13.133*/("""" />
      <img class="button-export" title="Download" onclick="getResource('"""),_display_(/*14.74*/resource),format.raw/*14.82*/("""')" src=""""),_display_(/*14.92*/Assets/*14.98*/.at("img/document-export.png")),format.raw/*14.128*/("""" />
      -->
      <i class="material-icons resource-chip-icon" onclick="getResource('"""),_display_(/*16.75*/resource),format.raw/*16.83*/("""');">file_download</i>
      <i class="material-icons resource-chip-icon" onclick="deleteResource('"""),_display_(/*17.78*/resource),format.raw/*17.86*/("""');">clear</i>
    </div>
    """)))}),format.raw/*19.6*/("""
  """),format.raw/*20.3*/("""</div>

  <div id="resource-tab-panels" class="mdl-cell mdl-cell--12-col">
    <div class="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
      <div class="mdl-tabs__tab-bar">
        <a id="resources-upload-panel-tag" href="#resources-upload-panel" class="mdl-tabs__tab is-active">Upload Local</a>
        <div class="mdl-tooltip mdl-tooltip--large" for="resources-upload-panel-tag">
          Upload an input resource from a local file.
        </div>
        <a id="resources-import-panel-tag" href="#resources-import-panel" class="mdl-tabs__tab">Import from URL</a>
        <div class="mdl-tooltip mdl-tooltip--large" for="resources-import-panel-tag">
          Import an input resource from an external URL.
        </div>
        <a id="resources-output-panel-tag" href="#resources-output-panel" class="mdl-tabs__tab">Define Output</a>
        <div class="mdl-tooltip mdl-tooltip--large" for="resources-output-panel-tag">
          Create a new output resource.
        </div>
      </div>

      <div class="mdl-tabs__panel is-active" id="resources-upload-panel">
        <div class="mdl-file-upload">
          <input id="upload_file" name="upload_file" type="file"/>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
          <input class="mdl-textfield__input" type="text" id="upload_resource_name" name="upload_resource_name" value="unnamed"/>
          <label class="mdl-textfield__label" for="upload_resource_name">Name</label>
        </div>
      </div>
      <div class="mdl-tabs__panel" id="resources-import-panel">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
          <input class="mdl-textfield__input" type="text" id="import_url" name="import_url"/>
          <label class="mdl-textfield__label" for="import_url">URL</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
          <input class="mdl-textfield__input" type="text" id="import_resource_name" name="import_resource_name" value="unnamed"/>
          <label class="mdl-textfield__label" for="import_resource_name">Name</label>
        </div>
      </div>
      <div class="mdl-tabs__panel" id="resources-output-panel">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
          <input class="mdl-textfield__input" type="text" id="output_resource_name" name="output_resource_name" value="unnamed"/>
          <label class="mdl-textfield__label" for="output_resource_name">Name</label>
        </div>
      </div>
    </div>
  </div>

</div>

  <div id="delete-dialog" >
    <p>
      <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
      Delete resource?
    </p>
  </div>

  <script type="text/javascript">
    // Initialization

    var buttonNames = """),format.raw/*79.23*/("""{"""),format.raw/*79.24*/("""
      """),format.raw/*80.7*/(""""resources-upload-panel-tag": "Upload" ,
      "resources-import-panel-tag": "Import" ,
      "resources-output-panel-tag": "Create"
    """),format.raw/*83.5*/("""}"""),format.raw/*83.6*/("""

    """),format.raw/*85.5*/("""$("#dialog-submit-button").text(buttonNames["resources-upload-panel-tag"]);

    $(function() """),format.raw/*87.18*/("""{"""),format.raw/*87.19*/("""
      """),format.raw/*88.7*/("""$("#primary_dialog .mdl-tabs__tab").click(function() """),format.raw/*88.60*/("""{"""),format.raw/*88.61*/("""
        """),format.raw/*89.9*/("""var currentPanel = $(this).attr("id");
        $("#dialog-submit-button").text(buttonNames[currentPanel]);
      """),format.raw/*91.7*/("""}"""),format.raw/*91.8*/(""");


      // automatically set the resource name based on the file chosen
      $("#upload_file").change(function() """),format.raw/*95.43*/("""{"""),format.raw/*95.44*/("""
        """),format.raw/*96.9*/("""var name=$("#upload_file").val().split(/(\\|\/)/g).pop();
        $("#upload_resource_name").val(name);
      """),format.raw/*98.7*/("""}"""),format.raw/*98.8*/(""");

      // automatically set the resource name based in the URI entered
      $("#import_url").change(function() """),format.raw/*101.42*/("""{"""),format.raw/*101.43*/("""
        """),format.raw/*102.9*/("""var parser = document.createElement('a');
        parser.href = $(this).val();
        var name = parser.pathname.split(/(\/)/g).pop();
        $("#import_resource_name").val(name);
      """),format.raw/*106.7*/("""}"""),format.raw/*106.8*/(""");

      // Initialize the delete dialog
      $("#delete-dialog").dialog("""),format.raw/*109.34*/("""{"""),format.raw/*109.35*/("""
        """),format.raw/*110.9*/("""autoOpen: false,
        modal: true,
        buttons: """),format.raw/*112.18*/("""{"""),format.raw/*112.19*/("""
          """),format.raw/*113.11*/("""Cancel: function() """),format.raw/*113.30*/("""{"""),format.raw/*113.31*/("""
            """),format.raw/*114.13*/("""$(this).dialog("close");
          """),format.raw/*115.11*/("""}"""),format.raw/*115.12*/(""",
          Yes: function() """),format.raw/*116.27*/("""{"""),format.raw/*116.28*/("""
            """),format.raw/*117.13*/("""deleteResource($(this).data('resourceIndex'), $(this).data('resourceName'));
            $(this).dialog("close");
          """),format.raw/*119.11*/("""}"""),format.raw/*119.12*/(""",
        """),format.raw/*120.9*/("""}"""),format.raw/*120.10*/("""
      """),format.raw/*121.7*/("""}"""),format.raw/*121.8*/(""");

    """),format.raw/*123.5*/("""}"""),format.raw/*123.6*/(""");

    // Opens the delete dialog
    function deleteResourceDialog(index, name) """),format.raw/*126.48*/("""{"""),format.raw/*126.49*/("""
      """),format.raw/*127.7*/("""$('#delete-dialog').data('resourceName', name);
      $('#delete-dialog').data('resourceIndex', index);
      $("#delete-dialog").dialog("open");
    """),format.raw/*130.5*/("""}"""),format.raw/*130.6*/("""

    """),format.raw/*132.5*/("""// Downloads a resource
    function getResource(name) """),format.raw/*133.32*/("""{"""),format.raw/*133.33*/("""
      """),format.raw/*134.7*/("""window.location = '"""),_display_(/*134.27*/config/*134.33*/.baseUrl),format.raw/*134.41*/("""/workspace/projects/"""),_display_(/*134.62*/project),format.raw/*134.69*/("""/resources/' + name.replace(/\//g,"%2F")
    """),format.raw/*135.5*/("""}"""),format.raw/*135.6*/("""

    """),format.raw/*137.5*/("""function deleteResource(name) """),format.raw/*137.35*/("""{"""),format.raw/*137.36*/("""
      """),format.raw/*138.7*/("""var path = '"""),_display_(/*138.20*/config/*138.26*/.baseUrl),format.raw/*138.34*/("""/workspace/projects/"""),_display_(/*138.55*/project),format.raw/*138.62*/("""/resources/' + name;
      deleteResourceConfirm(name, path);
    """),format.raw/*140.5*/("""}"""),format.raw/*140.6*/("""

    """),format.raw/*142.5*/("""// Deletes a resource
    function _deleteResource(name) """),format.raw/*143.36*/("""{"""),format.raw/*143.37*/("""


      """),format.raw/*146.7*/("""$.ajax("""),format.raw/*146.14*/("""{"""),format.raw/*146.15*/("""
        """),format.raw/*147.9*/("""type: 'DELETE',
        url: '"""),_display_(/*148.16*/config/*148.22*/.baseUrl),format.raw/*148.30*/("""/workspace/projects/"""),_display_(/*148.51*/project),format.raw/*148.58*/("""/resources/' + name.replace(/\//g,"%2F"),
        success: function(data) """),format.raw/*149.33*/("""{"""),format.raw/*149.34*/("""
          """),format.raw/*150.11*/("""reloadDialog();
        """),format.raw/*151.9*/("""}"""),format.raw/*151.10*/(""",
        error: function(request) """),format.raw/*152.34*/("""{"""),format.raw/*152.35*/("""
          """),format.raw/*153.11*/("""alert(request.responseText);
        """),format.raw/*154.9*/("""}"""),format.raw/*154.10*/("""
      """),format.raw/*155.7*/("""}"""),format.raw/*155.8*/(""");
    """),format.raw/*156.5*/("""}"""),format.raw/*156.6*/("""

    """),format.raw/*158.5*/("""// Uploads a resource
    function uploadResource() """),format.raw/*159.31*/("""{"""),format.raw/*159.32*/("""
      """),format.raw/*160.7*/("""var name = $("#upload_resource_name").val();
      var file = $('#upload_file')[0].files[0];
      var formData = new FormData();
      formData.append('file', file);

      $('#dialog-progress-spinner').show();
      $.ajax("""),format.raw/*166.14*/("""{"""),format.raw/*166.15*/("""
        """),format.raw/*167.9*/("""type: 'PUT',
        url: '"""),_display_(/*168.16*/config/*168.22*/.baseUrl),format.raw/*168.30*/("""/workspace/projects/"""),_display_(/*168.51*/project),format.raw/*168.58*/("""/resources/' + name.replace(/\//g,"%2F"),
        xhr: function() """),format.raw/*169.25*/("""{"""),format.raw/*169.26*/("""
          """),format.raw/*170.11*/("""myXhr = $.ajaxSettings.xhr();
          return myXhr;
        """),format.raw/*172.9*/("""}"""),format.raw/*172.10*/(""",
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        success: function() """),format.raw/*177.29*/("""{"""),format.raw/*177.30*/("""
          """),format.raw/*178.11*/("""$('#dialog-progress-spinner').hide();
          reloadDialog();
        """),format.raw/*180.9*/("""}"""),format.raw/*180.10*/(""",
        error: function(request) """),format.raw/*181.34*/("""{"""),format.raw/*181.35*/("""
          """),format.raw/*182.11*/("""$('#dialog-progress-spinner').hide();
          alert(request.responseText);
        """),format.raw/*184.9*/("""}"""),format.raw/*184.10*/("""
      """),format.raw/*185.7*/("""}"""),format.raw/*185.8*/(""");
    """),format.raw/*186.5*/("""}"""),format.raw/*186.6*/("""

    """),format.raw/*188.5*/("""// Adds a new URL resource
    function addUrlResource() """),format.raw/*189.31*/("""{"""),format.raw/*189.32*/("""
      """),format.raw/*190.7*/("""var name = $("#import_resource_name").val();
      var url = $("#import_url").val();
      var formData = new FormData();
      formData.append('resource-url', url);

      $('#dialog-progress-spinner').show();
      $.ajax("""),format.raw/*196.14*/("""{"""),format.raw/*196.15*/("""
        """),format.raw/*197.9*/("""type: 'PUT',
        url: '"""),_display_(/*198.16*/config/*198.22*/.baseUrl),format.raw/*198.30*/("""/workspace/projects/"""),_display_(/*198.51*/project),format.raw/*198.58*/("""/resources/' + name,
        xhr: function() """),format.raw/*199.25*/("""{"""),format.raw/*199.26*/("""
          """),format.raw/*200.11*/("""myXhr = $.ajaxSettings.xhr();
          return myXhr;
        """),format.raw/*202.9*/("""}"""),format.raw/*202.10*/(""",
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        success: function() """),format.raw/*207.29*/("""{"""),format.raw/*207.30*/("""
          """),format.raw/*208.11*/("""$('#dialog-progress-spinner').hide();
          reloadDialog();
        """),format.raw/*210.9*/("""}"""),format.raw/*210.10*/(""",
        error: function(request) """),format.raw/*211.34*/("""{"""),format.raw/*211.35*/("""
          """),format.raw/*212.11*/("""$('#dialog-progress-spinner').hide();
          alert(request.responseText);
        """),format.raw/*214.9*/("""}"""),format.raw/*214.10*/("""
      """),format.raw/*215.7*/("""}"""),format.raw/*215.8*/(""");
    """),format.raw/*216.5*/("""}"""),format.raw/*216.6*/("""

    """),format.raw/*218.5*/("""// Creates a new resource
    function newResource() """),format.raw/*219.28*/("""{"""),format.raw/*219.29*/("""
      """),format.raw/*220.7*/("""var name = $("#output_resource_name").val();
      $.ajax("""),format.raw/*221.14*/("""{"""),format.raw/*221.15*/("""
        """),format.raw/*222.9*/("""type: 'PUT',
        url: '"""),_display_(/*223.16*/config/*223.22*/.baseUrl),format.raw/*223.30*/("""/workspace/projects/"""),_display_(/*223.51*/project),format.raw/*223.58*/("""/resources/' + name.replace(/\//g,"%2F"),
        success: function() """),format.raw/*224.29*/("""{"""),format.raw/*224.30*/("""
          """),format.raw/*225.11*/("""reloadDialog();
        """),format.raw/*226.9*/("""}"""),format.raw/*226.10*/(""",
        error: function(request) """),format.raw/*227.34*/("""{"""),format.raw/*227.35*/("""
          """),format.raw/*228.11*/("""alert(request.responseText);
        """),format.raw/*229.9*/("""}"""),format.raw/*229.10*/("""
      """),format.raw/*230.7*/("""}"""),format.raw/*230.8*/(""");
    """),format.raw/*231.5*/("""}"""),format.raw/*231.6*/("""

    """),format.raw/*233.5*/("""function submit() """),format.raw/*233.23*/("""{"""),format.raw/*233.24*/("""
      """),format.raw/*234.7*/("""var currentPanel = $("#primary_dialog .mdl-tabs__panel.is-active").attr("id");
      switch(currentPanel) """),format.raw/*235.28*/("""{"""),format.raw/*235.29*/("""
        case "resources-upload-panel":
          uploadResource();
          break;
        case "resources-import-panel":
          addUrlResource();
          break;
        case "resources-output-panel":
          newResource();
          break;
      """),format.raw/*245.7*/("""}"""),format.raw/*245.8*/("""
    """),format.raw/*246.5*/("""}"""),format.raw/*246.6*/("""
  """),format.raw/*247.3*/("""</script>
""")))}))
      }
    }
  }

  def render(project:String,resourceLoader:org.silkframework.runtime.resource.ResourceLoader): play.twirl.api.HtmlFormat.Appendable = apply(project,resourceLoader)

  def f:((String,org.silkframework.runtime.resource.ResourceLoader) => play.twirl.api.HtmlFormat.Appendable) = (project,resourceLoader) => apply(project,resourceLoader)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/resourcesDialog.scala.html
                  HASH: 114f03275a91815a288c28a6740393188070c40e
                  MATRIX: 799->1|956->88|1027->86|1054->131|1081->133|1095->140|1151->188|1190->190|1217->191|1362->311|1444->378|1483->380|1515->385|1560->403|1586->408|1695->490|1724->498|1849->596|1875->601|1906->605|1935->613|1973->623|1989->629|2031->649|2136->727|2165->735|2202->745|2217->751|2269->781|2385->870|2414->878|2541->978|2570->986|2631->1017|2661->1020|5530->3861|5559->3862|5593->3869|5757->4006|5785->4007|5818->4013|5940->4107|5969->4108|6003->4115|6084->4168|6113->4169|6149->4178|6289->4291|6317->4292|6462->4409|6491->4410|6527->4419|6664->4529|6692->4530|6836->4645|6866->4646|6903->4655|7119->4843|7148->4844|7252->4919|7282->4920|7319->4929|7403->4984|7433->4985|7473->4996|7521->5015|7551->5016|7593->5029|7657->5064|7687->5065|7744->5093|7774->5094|7816->5107|7969->5231|7999->5232|8037->5242|8067->5243|8102->5250|8131->5251|8167->5259|8196->5260|8307->5342|8337->5343|8372->5350|8550->5500|8579->5501|8613->5507|8697->5562|8727->5563|8762->5570|8810->5590|8826->5596|8856->5604|8905->5625|8934->5632|9007->5677|9036->5678|9070->5684|9129->5714|9159->5715|9194->5722|9235->5735|9251->5741|9281->5749|9330->5770|9359->5777|9453->5843|9482->5844|9516->5850|9602->5907|9632->5908|9669->5917|9705->5924|9735->5925|9772->5934|9831->5965|9847->5971|9877->5979|9926->6000|9955->6007|10058->6081|10088->6082|10128->6093|10180->6117|10210->6118|10274->6153|10304->6154|10344->6165|10409->6202|10439->6203|10474->6210|10503->6211|10538->6218|10567->6219|10601->6225|10682->6277|10712->6278|10747->6285|11001->6510|11031->6511|11068->6520|11124->6548|11140->6554|11170->6562|11219->6583|11248->6590|11343->6656|11373->6657|11413->6668|11503->6730|11533->6731|11694->6863|11724->6864|11764->6875|11864->6947|11894->6948|11958->6983|11988->6984|12028->6995|12141->7080|12171->7081|12206->7088|12235->7089|12270->7096|12299->7097|12333->7103|12419->7160|12449->7161|12484->7168|12737->7392|12767->7393|12804->7402|12860->7430|12876->7436|12906->7444|12955->7465|12984->7472|13058->7517|13088->7518|13128->7529|13218->7591|13248->7592|13409->7724|13439->7725|13479->7736|13579->7808|13609->7809|13673->7844|13703->7845|13743->7856|13856->7941|13886->7942|13921->7949|13950->7950|13985->7957|14014->7958|14048->7964|14130->8017|14160->8018|14195->8025|14282->8083|14312->8084|14349->8093|14405->8121|14421->8127|14451->8135|14500->8156|14529->8163|14628->8233|14658->8234|14698->8245|14750->8269|14780->8270|14844->8305|14874->8306|14914->8317|14979->8354|15009->8355|15044->8362|15073->8363|15108->8370|15137->8371|15171->8377|15218->8395|15248->8396|15283->8403|15418->8509|15448->8510|15732->8766|15761->8767|15794->8772|15823->8773|15854->8776
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|29->5|30->6|33->9|33->9|33->9|34->10|34->10|34->10|35->11|35->11|37->13|37->13|37->13|37->13|37->13|37->13|37->13|38->14|38->14|38->14|38->14|38->14|40->16|40->16|41->17|41->17|43->19|44->20|103->79|103->79|104->80|107->83|107->83|109->85|111->87|111->87|112->88|112->88|112->88|113->89|115->91|115->91|119->95|119->95|120->96|122->98|122->98|125->101|125->101|126->102|130->106|130->106|133->109|133->109|134->110|136->112|136->112|137->113|137->113|137->113|138->114|139->115|139->115|140->116|140->116|141->117|143->119|143->119|144->120|144->120|145->121|145->121|147->123|147->123|150->126|150->126|151->127|154->130|154->130|156->132|157->133|157->133|158->134|158->134|158->134|158->134|158->134|158->134|159->135|159->135|161->137|161->137|161->137|162->138|162->138|162->138|162->138|162->138|162->138|164->140|164->140|166->142|167->143|167->143|170->146|170->146|170->146|171->147|172->148|172->148|172->148|172->148|172->148|173->149|173->149|174->150|175->151|175->151|176->152|176->152|177->153|178->154|178->154|179->155|179->155|180->156|180->156|182->158|183->159|183->159|184->160|190->166|190->166|191->167|192->168|192->168|192->168|192->168|192->168|193->169|193->169|194->170|196->172|196->172|201->177|201->177|202->178|204->180|204->180|205->181|205->181|206->182|208->184|208->184|209->185|209->185|210->186|210->186|212->188|213->189|213->189|214->190|220->196|220->196|221->197|222->198|222->198|222->198|222->198|222->198|223->199|223->199|224->200|226->202|226->202|231->207|231->207|232->208|234->210|234->210|235->211|235->211|236->212|238->214|238->214|239->215|239->215|240->216|240->216|242->218|243->219|243->219|244->220|245->221|245->221|246->222|247->223|247->223|247->223|247->223|247->223|248->224|248->224|249->225|250->226|250->226|251->227|251->227|252->228|253->229|253->229|254->230|254->230|255->231|255->231|257->233|257->233|257->233|258->234|259->235|259->235|269->245|269->245|270->246|270->246|271->247
                  -- GENERATED --
              */
          