
package views.html.editor

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
/*1.2*/import org.silkframework.rule.vocab.VocabularyProperty
/*2.2*/import org.silkframework.config.Prefixes

object propertyDetails extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Option[VocabularyProperty],Prefixes,play.twirl.api.HtmlFormat.Appendable] {

  /*
* Shows details information for a vocabulary property.
*/
  def apply/*7.2*/(name: String, property: Option[VocabularyProperty], prefixes: Prefixes = Prefixes.default):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*14.2*/renderProperty/*14.16*/(prop: VocabularyProperty):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*14.46*/("""
"""),format.raw/*15.1*/("""<div class="di-rule-grey-box">
  <div class="di-rule-property-header"><span class="di-rule-property-name">"""),_display_(/*16.77*/renderPropertyName(prop)),format.raw/*16.101*/("""</span> (<span class="di-rule-property-domain">"""),_display_(/*16.149*/renderPropertyDomain(prop)),format.raw/*16.175*/("""</span>, <span class="di-rule-property-range">"""),_display_(/*16.222*/renderPropertyRange(prop)),format.raw/*16.247*/("""</span>)</div>
  <div class="di-rule-property-description">
    """),_display_(/*18.6*/renderPropertyDescription(prop)),format.raw/*18.37*/("""
  """),format.raw/*19.3*/("""</div>
</div>
""")))};def /*23.2*/renderPropertyName/*23.20*/(prop: VocabularyProperty):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*23.50*/("""
  """),_display_(/*24.4*/prop/*24.8*/.info.label/*24.19*/ match/*24.25*/ {/*25.5*/case Some(label) =>/*25.24*/ {_display_(Seq[Any](format.raw/*25.26*/(""" """),_display_(/*25.28*/label),format.raw/*25.33*/(""" """)))}/*26.5*/case None =>/*26.17*/ {_display_(Seq[Any](format.raw/*26.19*/(""" """),format.raw/*26.20*/("""no label """)))}}),format.raw/*27.4*/("""
""")))};def /*30.2*/renderPropertyDescription/*30.27*/(prop: VocabularyProperty):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*30.57*/("""
  """),_display_(/*31.4*/prop/*31.8*/.info.description/*31.25*/ match/*31.31*/ {/*32.5*/case Some(desc) =>/*32.23*/ {_display_(Seq[Any](format.raw/*32.25*/(""" """),_display_(/*32.27*/desc),format.raw/*32.31*/(""" """)))}/*33.5*/case None =>/*33.17*/ {_display_(Seq[Any](format.raw/*33.19*/(""" """),format.raw/*33.20*/("""no description """)))}}),format.raw/*34.4*/("""
""")))};def /*37.2*/renderPropertyDomain/*37.22*/(prop: VocabularyProperty):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*37.52*/("""
  """),_display_(/*38.4*/prop/*38.8*/.domain/*38.15*/ match/*38.21*/ {/*39.5*/case Some(domain) =>/*39.25*/ {_display_(Seq[Any](format.raw/*39.27*/(""" """),_display_(/*39.29*/prefixes/*39.37*/.shorten(domain.info.uri)),format.raw/*39.62*/(""" """)))}/*40.5*/case None =>/*40.17*/ {_display_(Seq[Any](format.raw/*40.19*/(""" """),format.raw/*40.20*/("""(unspecified) """)))}}),format.raw/*41.4*/("""
""")))};def /*44.2*/renderPropertyRange/*44.21*/(prop: VocabularyProperty):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*44.51*/("""
  """),_display_(/*45.4*/prop/*45.8*/.range/*45.14*/ match/*45.20*/ {/*46.5*/case Some(range) =>/*46.24*/ {_display_(Seq[Any](format.raw/*46.26*/(""" """),_display_(/*46.28*/prefixes/*46.36*/.shorten(range.info.uri)),format.raw/*46.60*/(""" """)))}/*47.5*/case None =>/*47.17*/ {_display_(Seq[Any](format.raw/*47.19*/(""" """),format.raw/*47.20*/("""(unspecified) """)))}}),format.raw/*48.4*/("""
""")))};
Seq[Any](format.raw/*8.1*/("""
"""),_display_(/*9.2*/property/*9.10*/ match/*9.16*/ {/*10.3*/case Some(prop) =>/*10.21*/ {_display_(Seq[Any](format.raw/*10.23*/(""" """),_display_(/*10.25*/renderProperty(prop)),format.raw/*10.45*/(""" """)))}/*11.3*/case None =>/*11.15*/ {_display_(Seq[Any](format.raw/*11.17*/(""" """),format.raw/*11.18*/("""Property """),_display_(/*11.28*/name),format.raw/*11.32*/(""" """),format.raw/*11.33*/("""not found in target vocabularies. """)))}}),format.raw/*12.2*/("""

"""),format.raw/*21.2*/("""

"""),format.raw/*28.2*/("""

"""),format.raw/*35.2*/("""

"""),format.raw/*42.2*/("""

"""))
      }
    }
  }

  def render(name:String,property:Option[VocabularyProperty],prefixes:Prefixes): play.twirl.api.HtmlFormat.Appendable = apply(name,property,prefixes)

  def f:((String,Option[VocabularyProperty],Prefixes) => play.twirl.api.HtmlFormat.Appendable) = (name,property,prefixes) => apply(name,property,prefixes)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/propertyDetails.scala.html
                  HASH: 1677d64d5c92b6690dcb0c4eea5845c6fd19cb08
                  MATRIX: 439->1|501->57|948->161|1118->391|1141->405|1248->435|1276->436|1410->543|1456->567|1532->615|1580->641|1655->688|1702->713|1793->778|1845->809|1875->812|1913->830|1940->848|2047->878|2077->882|2089->886|2109->897|2124->903|2134->910|2162->929|2202->931|2231->933|2257->938|2277->945|2298->957|2338->959|2367->960|2408->974|2433->979|2467->1004|2574->1034|2604->1038|2616->1042|2642->1059|2657->1065|2667->1072|2694->1090|2734->1092|2763->1094|2788->1098|2808->1105|2829->1117|2869->1119|2898->1120|2945->1140|2970->1145|2999->1165|3106->1195|3136->1199|3148->1203|3164->1210|3179->1216|3189->1223|3218->1243|3258->1245|3287->1247|3304->1255|3350->1280|3370->1287|3391->1299|3431->1301|3460->1302|3506->1321|3531->1326|3559->1345|3666->1375|3696->1379|3708->1383|3723->1389|3738->1395|3748->1402|3776->1421|3816->1423|3845->1425|3862->1433|3907->1457|3927->1464|3948->1476|3988->1478|4017->1479|4063->1498|4103->253|4130->255|4146->263|4160->269|4170->274|4197->292|4237->294|4266->296|4307->316|4327->321|4348->333|4388->335|4417->336|4454->346|4479->350|4508->351|4574->388|4603->827|4632->976|4661->1142|4690->1323
                  LINES: 17->1|18->2|25->7|29->14|29->14|31->14|32->15|33->16|33->16|33->16|33->16|33->16|33->16|35->18|35->18|36->19|38->23|38->23|40->23|41->24|41->24|41->24|41->24|41->25|41->25|41->25|41->25|41->25|41->26|41->26|41->26|41->26|41->27|42->30|42->30|44->30|45->31|45->31|45->31|45->31|45->32|45->32|45->32|45->32|45->32|45->33|45->33|45->33|45->33|45->34|46->37|46->37|48->37|49->38|49->38|49->38|49->38|49->39|49->39|49->39|49->39|49->39|49->39|49->40|49->40|49->40|49->40|49->41|50->44|50->44|52->44|53->45|53->45|53->45|53->45|53->46|53->46|53->46|53->46|53->46|53->46|53->47|53->47|53->47|53->47|53->48|55->8|56->9|56->9|56->9|56->10|56->10|56->10|56->10|56->10|56->11|56->11|56->11|56->11|56->11|56->11|56->11|56->12|58->21|60->28|62->35|64->42
                  -- GENERATED --
              */
          