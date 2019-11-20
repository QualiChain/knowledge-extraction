
package views.html

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
/*1.2*/import controllers.core.routes.Assets

object frame extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(header: Html)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""
"""),format.raw/*5.1*/("""<!DOCTYPE html>

<html>
  <head>
    <title>"""),_display_(/*9.13*/config/*9.19*/.workbench.title),format.raw/*9.35*/("""</title>
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*10.55*/Assets/*10.61*/.at("img/favicon.png")),format.raw/*10.83*/("""" />

    <link rel="stylesheet" media="screen" href=""""),_display_(/*12.50*/Assets/*12.56*/.at("main.css")),format.raw/*12.71*/("""" />
    <link rel="stylesheet" href=""""),_display_(/*13.35*/Assets/*13.41*/.at("libs/jquery-ui/base/jquery-ui.css")),format.raw/*13.81*/("""" type="text/css" media="screen, projection"/>
    <link rel="stylesheet" href=""""),_display_(/*14.35*/Assets/*14.41*/.at("libs/jquery-ui/base/jquery-ui.structure.css")),format.raw/*14.91*/("""" type="text/css" media="screen, projection"/>
    <link rel="stylesheet" href=""""),_display_(/*15.35*/Assets/*15.41*/.at("libs/jquery-ui/base/jquery-ui.theme.css")),format.raw/*15.87*/("""" type="text/css" media="screen, projection"/>
    <link rel="stylesheet" href=""""),_display_(/*16.35*/Assets/*16.41*/.at("libs/mdl-vertical-tabs/mdl-vertical-tabs.css")),format.raw/*16.92*/("""" type="text/css" media="screen, projection"/>

    <script src=""""),_display_(/*18.19*/Assets/*18.25*/.at("libs/lodash/lodash.js")),format.raw/*18.53*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*19.19*/Assets/*19.25*/.at("libs/jquery/dist/jquery.js")),format.raw/*19.58*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*20.19*/Assets/*20.25*/.at("libs/jquery-migrate/dist/jquery-migrate.js")),format.raw/*20.74*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*21.19*/Assets/*21.25*/.at("libs/jquery-ui/jquery-ui.js")),format.raw/*21.59*/("""" type="text/javascript"></script>
    <script type="text/javascript">
      var baseUrl = '"""),_display_(/*23.23*/config/*23.29*/.baseUrl),format.raw/*23.37*/("""'; // Base URL of this deployment
    </script>
    <script src=""""),_display_(/*25.19*/Assets/*25.25*/.at("main.js")),format.raw/*25.39*/("""" type="text/javascript"></script>

    """),_display_(/*27.6*/header),format.raw/*27.12*/("""

    """),format.raw/*29.5*/("""<!-- MDL inclusions: -->
    <link type="text/css" href=""""),_display_(/*30.34*/Assets/*30.40*/.at("libs/silk-react-components/style.css")),format.raw/*30.83*/("""" rel="stylesheet" />

    """),_display_(/*32.6*/if(config.workbench.mdlStyle.isDefined)/*32.45*/ {_display_(Seq[Any](format.raw/*32.47*/("""
      """),format.raw/*33.118*/("""
      """),format.raw/*34.7*/("""<link type="text/css" href=""""),_display_(/*34.36*/config/*34.42*/.baseUrl),format.raw/*34.50*/("""/core/mdlStyle" rel="stylesheet" />
    """)))}),format.raw/*35.6*/("""

    """),format.raw/*37.5*/("""<link type="text/css" href=""""),_display_(/*37.34*/Assets/*37.40*/.at("mdl-adjustments.css")),format.raw/*37.66*/("""" rel="stylesheet" />
    <link type="text/css" href=""""),_display_(/*38.34*/Assets/*38.40*/.at("libs/mdl-selectfield/dist/mdl-selectfield.css")),format.raw/*38.92*/("""" rel="stylesheet" />
    <link type="text/css" href=""""),_display_(/*39.34*/Assets/*39.40*/.at("libs/dialog-polyfill/dialog-polyfill.css")),format.raw/*39.87*/("""" rel="stylesheet" />


    <script src=""""),_display_(/*42.19*/Assets/*42.25*/.at("libs/material-design-lite/material.js")),format.raw/*42.69*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*43.19*/Assets/*43.25*/.at("libs/mdl-selectfield/dist/mdl-selectfield.js")),format.raw/*43.76*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*44.19*/Assets/*44.25*/.at("libs/dialog-polyfill/dialog-polyfill.js")),format.raw/*44.71*/("""" type="text/javascript"></script>

  </head>
  <body>
    """),_display_(/*48.6*/content),format.raw/*48.13*/("""
  """),format.raw/*49.3*/("""</body>
</html>
"""))
      }
    }
  }

  def render(header:Html,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(header)(content)

  def f:((Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (header) => (content) => apply(header)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/frame.scala.html
                  HASH: 36aa5dd4352db2c0d1b53898931be9ffe9f7bb49
                  MATRIX: 432->1|777->41|900->71|927->72|998->117|1012->123|1048->139|1138->202|1153->208|1196->230|1278->285|1293->291|1329->306|1395->345|1410->351|1471->391|1579->472|1594->478|1665->528|1773->609|1788->615|1855->661|1963->742|1978->748|2050->799|2143->865|2158->871|2207->899|2287->952|2302->958|2356->991|2436->1044|2451->1050|2521->1099|2601->1152|2616->1158|2671->1192|2791->1285|2806->1291|2835->1299|2928->1365|2943->1371|2978->1385|3045->1426|3072->1432|3105->1438|3190->1496|3205->1502|3269->1545|3323->1573|3371->1612|3411->1614|3447->1732|3481->1739|3537->1768|3552->1774|3581->1782|3652->1823|3685->1829|3741->1858|3756->1864|3803->1890|3885->1945|3900->1951|3973->2003|4055->2058|4070->2064|4138->2111|4207->2153|4222->2159|4287->2203|4367->2256|4382->2262|4454->2313|4534->2366|4549->2372|4616->2418|4702->2478|4730->2485|4760->2488
                  LINES: 17->1|22->3|27->4|28->5|32->9|32->9|32->9|33->10|33->10|33->10|35->12|35->12|35->12|36->13|36->13|36->13|37->14|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|41->18|41->18|41->18|42->19|42->19|42->19|43->20|43->20|43->20|44->21|44->21|44->21|46->23|46->23|46->23|48->25|48->25|48->25|50->27|50->27|52->29|53->30|53->30|53->30|55->32|55->32|55->32|56->33|57->34|57->34|57->34|57->34|58->35|60->37|60->37|60->37|60->37|61->38|61->38|61->38|62->39|62->39|62->39|65->42|65->42|65->42|66->43|66->43|66->43|67->44|67->44|67->44|71->48|71->48|72->49
                  -- GENERATED --
              */
          