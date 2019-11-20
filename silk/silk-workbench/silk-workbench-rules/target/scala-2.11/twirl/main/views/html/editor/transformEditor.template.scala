
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
/*1.2*/import controllers.core.routes.{Assets => CoreAssets}
/*2.2*/import controllers.rules.routes.Assets
/*3.2*/import org.silkframework.entity.ValueType
/*4.2*/import org.silkframework.rule.{TransformRule, TransformSpec, MappingTarget}
/*5.2*/import org.silkframework.runtime.serialization.XmlSerialization.toXml
/*6.2*/import org.silkframework.workbench.Context
/*7.2*/import org.silkframework.runtime.activity.UserContext
/*8.2*/import org.silkframework.rule.input.Transformer

object transformEditor extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Context[TransformSpec],TransformRule,play.api.mvc.Session,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*10.2*/(context: Context[TransformSpec], rule: TransformRule)(implicit session: play.api.mvc.Session, userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*12.2*/header/*12.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*12.12*/("""
  """),format.raw/*13.3*/("""<link type="text/css" href=""""),_display_(/*13.32*/Assets/*13.38*/.at("stylesheets/editor/editor-reset.css")),format.raw/*13.80*/("""" rel="stylesheet" />
  <link type="text/css" href=""""),_display_(/*14.32*/Assets/*14.38*/.at("stylesheets/editor/editor.css")),format.raw/*14.74*/("""" rel="stylesheet" />
  <link type="text/css" href=""""),_display_(/*15.32*/Assets/*15.38*/.at("stylesheets/editor/status.css")),format.raw/*15.74*/("""" rel="stylesheet" />

  <script src=""""),_display_(/*17.17*/CoreAssets/*17.27*/.at("libs/jsplumb/dist/js/jsplumb.js")),format.raw/*17.65*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*18.17*/Assets/*18.23*/.at("js/editor/editor.js")),format.raw/*18.49*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*19.17*/Assets/*19.23*/.at("js/editor/status.js")),format.raw/*19.49*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*20.17*/Assets/*20.23*/.at("js/editor/serializeRule.js")),format.raw/*20.56*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*21.17*/Assets/*21.23*/.at("js/editor/editableLabel.js")),format.raw/*21.56*/("""" type="text/javascript"></script>

  <script type="text/javascript">
    var inEditorEnv = true;
    var projectName = '"""),_display_(/*25.25*/context/*25.32*/.project.name),format.raw/*25.45*/("""';
    var taskName = '"""),_display_(/*26.22*/context/*26.29*/.task.id),format.raw/*26.37*/("""';
    var ruleIndex = '/"""),_display_(/*27.24*/rule/*27.28*/.id.toString),format.raw/*27.40*/("""';
    var editorUrl = baseUrl + '/transform/' + projectName + '/' + taskName + '/editor';
    var apiUrl = '"""),_display_(/*29.20*/config/*29.26*/.baseUrl),format.raw/*29.34*/("""/transform/tasks/"""),_display_(/*29.52*/context/*29.59*/.project.name),format.raw/*29.72*/("""/"""),_display_(/*29.74*/context/*29.81*/.task.id),format.raw/*29.89*/("""';
    var serializationFunction = serializeTransformRule;
  </script>

  """),format.raw/*33.122*/("""
  """),format.raw/*34.3*/("""<script id="rule-metadata" type="text/xml">
    """),_display_(/*35.6*/toXml(rule.metaData)),format.raw/*35.26*/("""
  """),format.raw/*36.3*/("""</script>

  <script id="rule-mappingtarget" type="text/xml">
    """),_display_(/*39.6*/rule/*39.10*/.target.map((r: MappingTarget) => toXml(r))),format.raw/*39.53*/("""
  """),format.raw/*40.3*/("""</script>
""")))};def /*43.2*/toolbar/*43.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*43.13*/("""
  """),format.raw/*44.3*/("""<ul>
    <li>
      <a class="mdl-button mdl-js-button mdl-button--icon" href="../editor/rule/"""),_display_(/*46.82*/rule/*46.86*/.id),format.raw/*46.89*/("""">
        <i class="material-icons">arrow_back</i>
      </a>
    </li>
    <li>
      <div class="spacer"/>
    </li>
    <li>
      <button id="undo" class="mdl-button mdl-js-button mdl-button--icon" onclick="undo();">
        <i class="material-icons">undo</i>
      </button>
    </li>
    <li>
      <button id="redo" class="mdl-button mdl-js-button mdl-button--icon" onclick="redo();">
        <i class="material-icons">redo</i>
      </button>
    </li>
    <li>
      <div class="spacer"/>
    </li>
      <li>
      <button id="button_reload_paths" class="mdl-button mdl-js-button mdl-button--icon" onclick="reloadRelativePropertyPaths();">
        <i class="material-icons">cached</i>
      </button>
      <div class="mdl-tooltip mdl-tooltip--large" for="button_reload_paths">
        Reload Property Paths
      </div>
    </li>
    <li>
      <div class="spacer"/>
    </li>
    <li style="display: none">
      <label>Name:</label>
      <div id="input_rulename" class="mdl-textfield mdl-js-textfield">
        <input id="rulename" class="mdl-textfield__input" type="text" onchange="modifyLinkSpec()" value=""""),_display_(/*80.107*/rule/*80.111*/.id),format.raw/*80.114*/("""" disabled/>
      </div>
      <div class="mdl-tooltip mdl-tooltip--large" for="input_rulename">
        The name of this transformation rule.
      </div>
    </li>
    <li style="display: none">
      <div class="spacer"/>
    </li>
    <li style="display: none">
      <label>Target Property:</label>
      <div id="input_targetproperty" class="mdl-textfield mdl-js-textfield">
        <input id="targetproperty" class="mdl-textfield__input" type="text" onchange="modifyLinkSpec()" value=""""),_display_(/*92.113*/rule/*92.117*/.target.map(_.propertyUri.uri).getOrElse("")),format.raw/*92.161*/("""" disabled/>
      </div>
      <div class="mdl-tooltip mdl-tooltip--large" for="input_targetproperty">
        The target property.
      </div>
    </li>
    <li style="display: none">
      <label>Target Type:</label>
      <div id="input_type" class="mdl-textfield mdl-js-textfield">
        <input id="targettype" class="mdl-textfield__input" type="text" onchange="modifyLinkSpec()" value=""""),_display_(/*101.109*/rule/*101.113*/.target.map(t => ValueType.valueTypeId(t.valueType)).getOrElse("AutoDetectValueType")),format.raw/*101.198*/("""" disabled/>
      </div>
      <div class="mdl-tooltip mdl-tooltip--large" for="input_type">
        The target type.
      </div>
    </li>
    <li style="display: none">
      <label>As Attribute:</label>
      <div id="input_isAttribute" class="mdl-textfield mdl-js-textfield">
        <input id="targetattribute" class="mdl-textfield__input" type="text" onchange="modifyLinkSpec()" value=""""),_display_(/*110.114*/rule/*110.118*/.target.exists(_.isAttribute)),format.raw/*110.147*/("""" disabled/>
      </div>
      <div class="mdl-tooltip mdl-tooltip--large" for="input_isAttribute">
        Write as attribute.
      </div>
    </li>
  </ul>

  """),_display_(/*118.4*/status()),format.raw/*118.12*/("""

  """),format.raw/*120.3*/("""<div id="score-widget">"""),format.raw/*120.55*/("""</div>
""")))};def /*123.2*/content/*123.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*123.13*/("""
  """),format.raw/*124.3*/("""<div class="draggables mdl-shadow--2dp">
    <div id="palette-header">
    </div>

    <div id="operators-grouped">
      <div id="paths">
        <div id="loading" style="width:230px;">loading ...</div>
        <script type="text/javascript">
            getRelativePropertyPathsForRule(ruleIndex, '#paths');
        </script>
      </div>

      <div id="operators">
        """),_display_(/*137.10*/operators("Transformations", "transform", Transformer.pluginsByCategory, context.project)),format.raw/*137.99*/("""
      """),format.raw/*138.7*/("""</div>
    </div>
  </div>

  <div class="wrapperEditor">

    <div class="droppable_outer">

      <div id="droppable" class="droppable-canvas mdl-shadow--2dp">
        """),_display_(/*147.10*/renderRule(
          rule = rule.operator,
          project = context.project
        )),format.raw/*150.10*/("""
      """),format.raw/*151.7*/("""</div>

    </div>

  </div>
""")))};
Seq[Any](format.raw/*11.1*/("""
"""),format.raw/*41.2*/("""

"""),format.raw/*121.2*/("""

"""),format.raw/*156.2*/("""

"""),_display_(/*158.2*/main(Some(context), titleLabel = context.task.taskLabel())/*158.60*/(header)/*158.68*/(toolbar)/*158.77*/(content)))
      }
    }
  }

  def render(context:Context[TransformSpec],rule:TransformRule,session:play.api.mvc.Session,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(context,rule)(session,userContext)

  def f:((Context[TransformSpec],TransformRule) => (play.api.mvc.Session,UserContext) => play.twirl.api.HtmlFormat.Appendable) = (context,rule) => (session,userContext) => apply(context,rule)(session,userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/transformEditor.scala.html
                  HASH: abdbca4b286581ce0710114c3ea0edde3c5966fe
                  MATRIX: 439->1|500->56|546->96|595->139|678->216|755->287|805->331|866->386|1292->436|1491->559|1505->565|1586->569|1616->572|1672->601|1687->607|1750->649|1830->702|1845->708|1902->744|1982->797|1997->803|2054->839|2120->878|2139->888|2198->926|2276->977|2291->983|2338->1009|2416->1060|2431->1066|2478->1092|2556->1143|2571->1149|2625->1182|2703->1233|2718->1239|2772->1272|2921->1394|2937->1401|2971->1414|3022->1438|3038->1445|3067->1453|3120->1479|3133->1483|3166->1495|3303->1605|3318->1611|3347->1619|3392->1637|3408->1644|3442->1657|3471->1659|3487->1666|3516->1674|3619->1867|3649->1870|3724->1919|3765->1939|3795->1942|3888->2009|3901->2013|3965->2056|3995->2059|4029->2073|4044->2080|4125->2084|4155->2087|4277->2182|4290->2186|4314->2189|5466->3313|5480->3317|5505->3320|6027->3814|6041->3818|6107->3862|6532->4258|6547->4262|6655->4347|7079->4742|7094->4746|7146->4775|7337->4939|7367->4947|7399->4951|7451->5003|7483->5014|7499->5021|7581->5025|7612->5028|8018->5406|8129->5495|8164->5502|8363->5673|8474->5762|8509->5769|8578->557|8606->2070|8636->5011|8666->5799|8696->5802|8764->5860|8782->5868|8801->5877
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|29->10|33->12|33->12|35->12|36->13|36->13|36->13|36->13|37->14|37->14|37->14|38->15|38->15|38->15|40->17|40->17|40->17|41->18|41->18|41->18|42->19|42->19|42->19|43->20|43->20|43->20|44->21|44->21|44->21|48->25|48->25|48->25|49->26|49->26|49->26|50->27|50->27|50->27|52->29|52->29|52->29|52->29|52->29|52->29|52->29|52->29|52->29|56->33|57->34|58->35|58->35|59->36|62->39|62->39|62->39|63->40|64->43|64->43|66->43|67->44|69->46|69->46|69->46|103->80|103->80|103->80|115->92|115->92|115->92|124->101|124->101|124->101|133->110|133->110|133->110|141->118|141->118|143->120|143->120|144->123|144->123|146->123|147->124|160->137|160->137|161->138|170->147|173->150|174->151|180->11|181->41|183->121|185->156|187->158|187->158|187->158|187->158
                  -- GENERATED --
              */
          