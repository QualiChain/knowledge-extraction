
package views.html.referenceLinks

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
/*1.2*/import org.silkframework.workspace.activity.linking.ReferenceEntitiesCache
/*2.2*/import views.html.workspace.activity.taskActivityControl
/*3.2*/import controllers.core.routes.{Assets => CoreAssets}
/*4.2*/import controllers.rules.routes.Assets
/*5.2*/import controllers.linking.routes
/*6.2*/import org.silkframework.rule.LinkSpec
/*7.2*/import org.silkframework.workbench.Context

object referenceLinks extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Context[LinkSpec],play.api.mvc.Session,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(context: Context[LinkSpec])(implicit session: play.api.mvc.Session, request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*11.2*/header/*11.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*11.12*/("""
  """),format.raw/*12.3*/("""<link type="text/css" href=""""),_display_(/*12.32*/Assets/*12.38*/.at("stylesheets/table.css")),format.raw/*12.66*/("""" rel="stylesheet" />
  <link type="text/css" href=""""),_display_(/*13.32*/Assets/*13.38*/.at("stylesheets/links.css")),format.raw/*13.66*/("""" rel="stylesheet" />
  <link rel="stylesheet" href=""""),_display_(/*14.33*/CoreAssets/*14.43*/.at("libs/jquery.treeview/jquery.treeview.css")),format.raw/*14.90*/("""" type="text/css" />

  <script src=""""),_display_(/*16.17*/CoreAssets/*16.27*/.at("libs/twbs-pagination/jquery.twbsPagination.js")),format.raw/*16.79*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*17.17*/CoreAssets/*17.27*/.at("libs/jquery.treeview/jquery.treeview.js")),format.raw/*17.73*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*18.17*/Assets/*18.23*/.at("js/links.js")),format.raw/*18.41*/("""" type="text/javascript"></script>
  
  <script type="text/javascript">
    var apiUrl = '"""),_display_(/*21.20*/config/*21.26*/.baseUrl),format.raw/*21.34*/("""/linking/tasks/"""),_display_(/*21.50*/context/*21.57*/.project.name),format.raw/*21.70*/("""/"""),_display_(/*21.72*/context/*21.79*/.task.id),format.raw/*21.87*/("""/referenceLink';
    initLinks('referenceLinks', 'positive');
  </script>
""")))};def /*26.2*/toolbar/*26.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*26.13*/("""
  """),format.raw/*27.3*/("""<ul>
    <li>
      <div id="selectLinks">
        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="showPositiveLinks">
          <input type="radio" id="showPositiveLinks" class="mdl-radio__button" name="selectLinks" onchange="updateLinkType('positive')" checked>
          <span class="mdl-radio__label">Positive</span>
        </label>
        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="showNegativeLinks">
          <input type="radio" id="showNegativeLinks" class="mdl-radio__button" name="selectLinks" onchange="updateLinkType('negative')">
          <span class="mdl-radio__label">Negative</span>
        </label>
        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="showUnlabeledLinks">
          <input type="radio" id="showUnlabeledLinks" class="mdl-radio__button" name="selectLinks" onchange="updateLinkType('unlabeled')">
          <span class="mdl-radio__label">Unlabeled</span>
        </label>
      </div>
    </li>
    <li>
      <div class="spacer"/>
    </li>
    <li>
      <button class="mdl-button mdl-js-button mdl-button--raised" onclick="showDialog('referenceLinks/addLinkDialog')">Add</button>
    </li>
    <li>
      <button class="mdl-button mdl-js-button mdl-button--raised" onclick="showDialog('referenceLinks/importDialog')">Import</button>
    </li>
    <li>
      <button class="mdl-button mdl-js-button mdl-button--raised" onclick="showDialog('referenceLinks/removeLinksDialog')">Remove</button>
    </li>
    <li>
      <button class="mdl-button mdl-js-button mdl-button--raised" onclick="window.location = '"""),_display_(/*57.96*/routes/*57.102*/.LinkingTaskApi.getReferenceLinks(context.project.name, context.task.id).url),format.raw/*57.178*/("""'">Download</button>
    </li>
    <li>
      <a class="mdl-button mdl-js-button mdl-button--icon" href="http://www.assembla.com/spaces/silk/wiki/Managing_Reference_Links" target="_help">
        <i class="material-icons">help_outline</i>
      </a>
    </li>
    <li>
      <div class="spacer"/>
    </li>
    <li>
      """),_display_(/*68.8*/taskActivityControl(context.task.activity[ReferenceEntitiesCache], showButtons = true)),format.raw/*68.94*/("""
    """),format.raw/*69.5*/("""</li>
  </ul>
""")))};def /*73.2*/content/*73.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*73.13*/("""
  """),format.raw/*74.3*/("""<div class="mdl-shadow--2dp">
    <div class="wrapper">

      <div id="tree-header">
        <div class="left">
          <div class="toggle-all"><div class="plus"></div><a href="#" onclick="expand_all();">Expand All</a></div>
          <div class="toggle-all"><div class="minus"></div><a href="#" onclick="hide_all();">Collapse All</a></div>
        </div>
        <div class="middle">
          <ul class="navigation"></ul>
        </div>
        <div class="right">
          Filter:
          <input onkeyup="updateFilter(this.value)"/>
        </div>
        <div id="pending"><img src=""""),_display_(/*89.38*/Assets/*89.44*/.at("img/pending.gif")),format.raw/*89.66*/(""""></div>
      </div>

      <div id="links">
      </div>

    </div>
  </div>
""")))};
Seq[Any](format.raw/*10.1*/("""
"""),format.raw/*24.2*/("""

"""),format.raw/*71.2*/("""

"""),format.raw/*97.2*/("""

"""),_display_(/*99.2*/main(Some(context), titleLabel = context.task.taskLabel())/*99.60*/(header)/*99.68*/(toolbar)/*99.77*/(content)))
      }
    }
  }

  def render(context:Context[LinkSpec],session:play.api.mvc.Session,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(context)(session,request)

  def f:((Context[LinkSpec]) => (play.api.mvc.Session,RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (context) => (session,request) => apply(context)(session,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/referenceLinks/referenceLinks.scala.html
                  HASH: bfa57043776b70f1bf4bd026ff47037d768dca52
                  MATRIX: 447->1|529->77|593->135|654->190|700->230|741->265|787->305|1189->350|1360->445|1374->451|1455->455|1485->458|1541->487|1556->493|1605->521|1685->574|1700->580|1749->608|1830->662|1849->672|1917->719|1982->757|2001->767|2074->819|2152->870|2171->880|2238->926|2316->977|2331->983|2370->1001|2488->1092|2503->1098|2532->1106|2575->1122|2591->1129|2625->1142|2654->1144|2670->1151|2699->1159|2797->1237|2812->1244|2893->1248|2923->1251|4550->2851|4566->2857|4664->2933|5013->3256|5120->3342|5152->3347|5190->3365|5205->3372|5286->3376|5316->3379|5937->3973|5952->3979|5995->4001|6115->443|6143->1234|6172->3362|6201->4082|6230->4085|6297->4143|6314->4151|6332->4160
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|28->9|32->11|32->11|34->11|35->12|35->12|35->12|35->12|36->13|36->13|36->13|37->14|37->14|37->14|39->16|39->16|39->16|40->17|40->17|40->17|41->18|41->18|41->18|44->21|44->21|44->21|44->21|44->21|44->21|44->21|44->21|44->21|47->26|47->26|49->26|50->27|80->57|80->57|80->57|91->68|91->68|92->69|94->73|94->73|96->73|97->74|112->89|112->89|112->89|121->10|122->24|124->71|126->97|128->99|128->99|128->99|128->99
                  -- GENERATED --
              */
          