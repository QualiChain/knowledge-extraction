
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

object multilineParameter extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(mainId: String, value: String, label: String, tooltip: String, additionalInputElementsClass: String = ""):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<div id=""""),_display_(/*3.11*/{mainId}),format.raw/*3.19*/("""_multiline_textfield_container" class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label """),_display_(/*3.120*/{mainId}),format.raw/*3.128*/("""-multiline-container">
  <input id=""""),_display_(/*4.15*/{mainId}),format.raw/*4.23*/("""_multiline_textfield" class="mdl-textfield__input" type="text"
         name=""""),_display_(/*5.17*/{mainId}),format.raw/*5.25*/("""_multiline_textfield" title="Restrict """),_display_(/*5.64*/{mainId}),format.raw/*5.72*/(""" """),format.raw/*5.73*/("""dataset using SPARQL clauses"
         value=""""),_display_(/*6.18*/value),format.raw/*6.23*/("""">
  <label class="mdl-textfield__label" for=""""),_display_(/*7.45*/{mainId}),format.raw/*7.53*/("""_multiline_textfield">"""),_display_(/*7.76*/{label}),format.raw/*7.83*/("""</label>
  <div class="mdl-tooltip mdl-tooltip--right" for=""""),_display_(/*8.53*/{mainId}),format.raw/*8.61*/("""_multiline_textfield">
    """),_display_(/*9.6*/tooltip),format.raw/*9.13*/("""
  """),format.raw/*10.3*/("""</div>
</div>
<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label """),_display_(/*12.75*/{mainId}),format.raw/*12.83*/("""-multiline-container" style="display: none;">
  <textarea id=""""),_display_(/*13.18*/{mainId}),format.raw/*13.26*/("""" name=""""),_display_(/*13.35*/{mainId}),format.raw/*13.43*/("""" class="mdl-textfield__input """),_display_(/*13.74*/{additionalInputElementsClass}),format.raw/*13.104*/("""" type="text" rows="5">"""),_display_(/*13.128*/value),format.raw/*13.133*/("""</textarea>
  <label class="mdl-textfield__label" for=""""),_display_(/*14.45*/{mainId}),format.raw/*14.53*/("""">"""),_display_(/*14.56*/{label}),format.raw/*14.63*/("""</label>
  <div class="mdl-tooltip mdl-tooltip--right" for=""""),_display_(/*15.53*/{mainId}),format.raw/*15.61*/("""">
    """),_display_(/*16.6*/tooltip),format.raw/*16.13*/("""
  """),format.raw/*17.3*/("""</div>
</div>
<script type="text/javascript">
  $("#"""),_display_(/*20.8*/{mainId}),format.raw/*20.16*/("""_multiline_textfield").focus(function() """),format.raw/*20.56*/("""{"""),format.raw/*20.57*/("""
    """),format.raw/*21.5*/("""$("."""),_display_(/*21.10*/{mainId}),format.raw/*21.18*/("""-multiline-container").toggle(200, "linear");
    $("#"""),_display_(/*22.10*/{mainId}),format.raw/*22.18*/("""").focus();
  """),format.raw/*23.3*/("""}"""),format.raw/*23.4*/(""");
  $("#"""),_display_(/*24.8*/{mainId}),format.raw/*24.16*/("""").focusout(function() """),format.raw/*24.39*/("""{"""),format.raw/*24.40*/("""
    """),format.raw/*25.5*/("""$("."""),_display_(/*25.10*/{mainId}),format.raw/*25.18*/("""-multiline-container").toggle(200, "linear");
    var multilineValue = $("#"""),_display_(/*26.31*/{mainId}),format.raw/*26.39*/("""").val().replace(/[\n\r]+/g, ' ');
    document.querySelector('#"""),_display_(/*27.31*/{mainId}),format.raw/*27.39*/("""_multiline_textfield_container').MaterialTextfield.change(multilineValue);
  """),format.raw/*28.3*/("""}"""),format.raw/*28.4*/(""");
</script>
"""))
      }
    }
  }

  def render(mainId:String,value:String,label:String,tooltip:String,additionalInputElementsClass:String): play.twirl.api.HtmlFormat.Appendable = apply(mainId,value,label,tooltip,additionalInputElementsClass)

  def f:((String,String,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (mainId,value,label,tooltip,additionalInputElementsClass) => apply(mainId,value,label,tooltip,additionalInputElementsClass)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/app/views/widgets/multilineParameter.scala.html
                  HASH: a817ea7801323bd3177353bd669089f427fe3f6c
                  MATRIX: 778->1|978->108|1005->109|1041->119|1069->127|1197->228|1226->236|1289->273|1317->281|1422->360|1450->368|1515->407|1543->415|1571->416|1644->463|1669->468|1742->515|1770->523|1819->546|1846->553|1933->614|1961->622|2014->650|2041->657|2071->660|2186->748|2215->756|2305->819|2334->827|2370->836|2399->844|2457->875|2509->905|2561->929|2588->934|2671->990|2700->998|2730->1001|2758->1008|2846->1069|2875->1077|2909->1085|2937->1092|2967->1095|3046->1148|3075->1156|3143->1196|3172->1197|3204->1202|3236->1207|3265->1215|3347->1270|3376->1278|3417->1292|3445->1293|3481->1303|3510->1311|3561->1334|3590->1335|3622->1340|3654->1345|3683->1353|3786->1429|3815->1437|3907->1502|3936->1510|4040->1587|4068->1588
                  LINES: 21->1|26->2|27->3|27->3|27->3|27->3|27->3|28->4|28->4|29->5|29->5|29->5|29->5|29->5|30->6|30->6|31->7|31->7|31->7|31->7|32->8|32->8|33->9|33->9|34->10|36->12|36->12|37->13|37->13|37->13|37->13|37->13|37->13|37->13|37->13|38->14|38->14|38->14|38->14|39->15|39->15|40->16|40->16|41->17|44->20|44->20|44->20|44->20|45->21|45->21|45->21|46->22|46->22|47->23|47->23|48->24|48->24|48->24|48->24|49->25|49->25|49->25|50->26|50->26|51->27|51->27|52->28|52->28
                  -- GENERATED --
              */
          