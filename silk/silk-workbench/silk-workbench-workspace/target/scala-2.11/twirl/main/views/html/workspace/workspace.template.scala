
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

object workspace extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import controllers.core.routes.{Assets => CoreAssets}
/*4.2*/import controllers.workspace.routes.Assets

def /*6.2*/header/*6.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.12*/("""
  """),format.raw/*7.3*/("""<link rel="stylesheet" href=""""),_display_(/*7.33*/CoreAssets/*7.43*/.at("libs/jstree/dist/themes/default/style.css")),format.raw/*7.91*/("""" type="text/css" />
  <link rel="stylesheet" href=""""),_display_(/*8.33*/Assets/*8.39*/.at("workspace.css")),format.raw/*8.59*/("""" type="text/css" />
  <script src=""""),_display_(/*9.17*/CoreAssets/*9.27*/.at("libs/jstree/dist/jstree.js")),format.raw/*9.60*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*10.17*/Assets/*10.23*/.at("workspace.js")),format.raw/*10.42*/("""" type="text/javascript"></script>
""")))};def /*13.2*/toolbar/*13.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*13.13*/("""
  """),format.raw/*14.3*/("""<ul>
    <li>
      <button id="workspace-button-new-project" class="mdl-button mdl-js-button mdl-button--raised" onclick="newProject()" >New Project</button>
    </li>
    <li>
      <button class="mdl-button mdl-js-button mdl-button--raised" onclick="importProject()" >Import Project</button>
    </li>
    <li>
      <button class="mdl-button mdl-js-button mdl-button--raised" onclick="reloadWorkspaceInBackend()" >Reload</button>
    </li>
  </ul>
""")))};def /*27.2*/content/*27.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*27.13*/("""
  """),format.raw/*28.3*/("""<div id="workspace_tree" >
    <div class="mdl-spinner mdl-spinner--single-color mdl-js-spinner is-active"></div>
    <!--<img src=""""),_display_(/*30.20*/Assets/*30.26*/.at("img/pending.gif")),format.raw/*30.48*/("""">-->
  </div>
""")))};
Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*11.2*/("""

"""),format.raw/*25.2*/("""

"""),format.raw/*32.2*/("""

"""),_display_(/*34.2*/main(None, "workspace")/*34.25*/(header)/*34.33*/(toolbar)/*34.42*/(content)))
      }
    }
  }

  def render(session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply()(session)

  def f:(() => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = () => (session) => apply()(session)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/workspace.scala.html
                  HASH: 8129fcd7c1391a550bd087eaf9ddd82de437e40a
                  MATRIX: 757->1|872->46|933->101|988->146|1001->152|1081->156|1110->159|1166->189|1184->199|1252->247|1331->300|1345->306|1385->326|1448->363|1466->373|1519->406|1597->457|1612->463|1652->482|1711->521|1726->528|1807->532|1837->535|2313->991|2328->998|2409->1002|2439->1005|2599->1138|2614->1144|2657->1166|2711->44|2738->144|2766->518|2795->988|2824->1182|2853->1185|2885->1208|2902->1216|2920->1225
                  LINES: 21->1|24->3|25->4|27->6|27->6|29->6|30->7|30->7|30->7|30->7|31->8|31->8|31->8|32->9|32->9|32->9|33->10|33->10|33->10|34->13|34->13|36->13|37->14|48->27|48->27|50->27|51->28|53->30|53->30|53->30|56->2|57->5|58->11|60->25|62->32|64->34|64->34|64->34|64->34
                  -- GENERATED --
              */
          