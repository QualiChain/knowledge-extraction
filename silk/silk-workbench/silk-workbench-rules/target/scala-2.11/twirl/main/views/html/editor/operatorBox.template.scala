
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
/*1.2*/import controllers.rules.routes.Assets
/*2.2*/import views.editor.GenerateId
/*3.2*/import org.silkframework.workspace.Project
/*4.2*/import org.silkframework.runtime.plugin.Parameter
/*5.2*/import org.silkframework.runtime.plugin.ParameterType._
/*6.2*/import org.silkframework.workspace.WorkspaceFactory
/*7.2*/import org.silkframework.runtime.activity.UserContext

object operatorBox extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template10[String,String,org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Seq[String],Int,Int,Boolean,Project,Html,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*9.2*/(opType: String,
  id: String,
  plugin: org.silkframework.runtime.plugin.PluginDescription[_],
  parameterValues: Seq[String],
  x: Int, y: Int,
  display: Boolean,
  project: Project)(additionalContent: Html)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*72.2*/multilineParameter/*72.20*/(param: Parameter, value: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*72.57*/("""
  """),_display_(/*73.4*/widgets/*73.11*/.multilineParameter(GenerateId(id, display), value, label = param.label, tooltip = param.description, additionalInputElementsClass = "param_value")),format.raw/*73.158*/("""
""")))};def /*76.2*/stringParameter/*76.17*/(param: Parameter, value: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*76.54*/("""
"""),format.raw/*77.1*/("""<div class="mdl-textfield mdl-textfield--floating-label mdl-defer" data-mdl-defer="js-textfield">
    <input class="mdl-textfield__input param_value" type="text" id=""""),_display_(/*78.70*/{GenerateId(id, display)}),format.raw/*78.95*/("""_param_input_"""),_display_(/*78.109*/{param.name}),format.raw/*78.121*/("""" name=""""),_display_(/*78.130*/{param.name}),format.raw/*78.142*/("""" value=""""),_display_(/*78.152*/value),format.raw/*78.157*/(""""/>
    <label class="mdl-textfield__label" for=""""),_display_(/*79.47*/{GenerateId(id, display)}),format.raw/*79.72*/("""_param_input_"""),_display_(/*79.86*/{param.name}),format.raw/*79.98*/("""">"""),_display_(/*79.101*/param/*79.106*/.label),format.raw/*79.112*/("""</label>
    <div class="mdl-defer mdl-tooltip--right" for=""""),_display_(/*80.53*/{GenerateId(id, display)}),format.raw/*80.78*/("""_param_input_"""),_display_(/*80.92*/{param.name}),format.raw/*80.104*/("""" data-mdl-defer="tooltip">
        """),_display_(/*81.10*/param/*81.15*/.description),format.raw/*81.27*/("""
        """),format.raw/*82.9*/("""<br/>
        Expected type: """),_display_(/*83.25*/param/*83.30*/.dataType.description),format.raw/*83.51*/("""
    """),format.raw/*84.5*/("""</div>
</div>
""")))};def /*88.2*/enumParameter/*88.15*/(param: Parameter, enumerationValues: Seq[String], displayNames: Seq[String], value: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*88.111*/("""
"""),format.raw/*89.1*/("""<div class="mdl-selectfield mdl-selectfield--floating-label mdl-defer"  data-mdl-defer="js-selectfield">
    <select class="mdl-selectfield__select param_value" id=""""),_display_(/*90.62*/{GenerateId(id, display)}),format.raw/*90.87*/("""_param_input_"""),_display_(/*90.101*/{param.name}),format.raw/*90.113*/("""" name=""""),_display_(/*90.122*/{param.name}),format.raw/*90.134*/("""" >
        """),_display_(/*91.10*/for((enumerationValue, displayName) <- enumerationValues.zip(displayNames)) yield /*91.85*/ {_display_(Seq[Any](format.raw/*91.87*/("""
        """),format.raw/*92.9*/("""<option value=""""),_display_(/*92.25*/(enumerationValue)),format.raw/*92.43*/("""" """),_display_(/*92.46*/if(enumerationValue == value)/*92.75*/ {_display_(Seq[Any](format.raw/*92.77*/(""" """),format.raw/*92.78*/("""selected="selected" """)))}),format.raw/*92.99*/(""">"""),_display_(/*92.101*/displayName),format.raw/*92.112*/("""</option>
        """)))}),format.raw/*93.10*/("""
    """),format.raw/*94.5*/("""</select>
    <label class="mdl-selectfield__label" for=""""),_display_(/*95.49*/{GenerateId(id, display)}),format.raw/*95.74*/("""_param_input_"""),_display_(/*95.88*/{param.name}),format.raw/*95.100*/("""">"""),_display_(/*95.103*/param/*95.108*/.label),format.raw/*95.114*/("""</label>
    <div class="mdl-defer mdl-tooltip--right" for=""""),_display_(/*96.53*/{GenerateId(id, display)}),format.raw/*96.78*/("""_param_input_"""),_display_(/*96.92*/{param.name}),format.raw/*96.104*/("""" data-mdl-defer="tooltip">
        """),_display_(/*97.10*/param/*97.15*/.description),format.raw/*97.27*/("""
        """),format.raw/*98.9*/("""<br/>
        Expected type: """),_display_(/*99.25*/param/*99.30*/.dataType.description),format.raw/*99.51*/("""
    """),format.raw/*100.5*/("""</div>
</div>
""")))};def /*48.2*/parameter/*48.11*/(param: Parameter, value: String) = {{
  param.dataType match {
    case UriType =>
      stringParameter(param, project.config.prefixes.shorten(value))
    case enum: EnumerationType =>
      enumParameter(param, enum.enumerationValues, enum.displayNames, value)
    case BooleanType =>
      enumParameter(param, Seq("true", "false"), Seq("True", "False"), value)
    case ResourceType | WritableResourceType =>
      val resources = project.resources.listRecursive
      enumParameter(param, resources, resources, value)
    case ProjectReferenceType =>
      val projectNames = WorkspaceFactory().workspace.projects.map(_.name.toString)
      enumParameter(param, projectNames, projectNames, value)
    case TaskReferenceType =>
      val taskNames = project.allTasks.map(_.id.toString)
      enumParameter(param, taskNames, taskNames, value)
//    case MultilineStringParameterType =>
//      multilineParameter(param, value)
    case _ =>
      stringParameter(param, value)
  }
}};
Seq[Any](format.raw/*16.1*/("""
"""),format.raw/*17.1*/("""<div id=""""),_display_(/*17.11*/GenerateId(id, display)),format.raw/*17.34*/("""" class="dragDiv """),_display_(/*17.52*/{opType.toLowerCase}),format.raw/*17.72*/("""Div"
     style="left: """),_display_(/*18.20*/{x}),format.raw/*18.23*/("""px; top: """),_display_(/*18.33*/{y}),format.raw/*18.36*/("""px; position: absolute; """),_display_(/*18.61*/if(!display)/*18.73*/ {_display_(Seq[Any](format.raw/*18.75*/(""" """),format.raw/*18.76*/("""display:none; """)))}),format.raw/*18.91*/("""">
    <div id=""""),_display_(/*19.15*/GenerateId(id, display)),format.raw/*19.38*/("""_tooltip" for=""""),_display_(/*19.54*/GenerateId(id, display)),format.raw/*19.77*/("""" class="mdl-defer operator-tooltip"
        data-mdl-defer="tooltip"
         style="display: none;">tooltip
    </div>
    <small class="name">"""),_display_(/*23.26*/plugin/*23.32*/.id),format.raw/*23.35*/("""</small>
    <small class="type">"""),_display_(/*24.26*/opType),format.raw/*24.32*/("""</small>
    <h5 class="handler">
        <label class="edit_label">"""),_display_(/*26.36*/id),format.raw/*26.38*/("""</label>
        <input class="edit_label" type="text" value=""""),_display_(/*27.55*/id),format.raw/*27.57*/("""" name="name" id=""""),_display_(/*27.76*/id),format.raw/*27.78*/("""-name"/>
        <img align="right" src=""""),_display_(/*28.34*/Assets/*28.40*/.at("img/delete.png")),format.raw/*28.61*/("""" style="cursor:pointer;"
        onclick="removeElement($(this).parent().parent().attr('id'))"/>
        <img align="right" src=""""),_display_(/*30.34*/Assets/*30.40*/.at("img/undecided.png")),format.raw/*30.64*/("""" style="cursor:help;" title=""""),_display_(/*30.95*/plugin/*30.101*/.description),format.raw/*30.113*/(""""/>
    </h5>
    <div class="content">
        """),_display_(/*33.10*/additionalContent),format.raw/*33.27*/("""
        """),_display_(/*34.10*/for((param, value) <- plugin.parameters zip parameterValues) yield /*34.70*/ {_display_(Seq[Any](format.raw/*34.72*/("""
        """),format.raw/*35.9*/("""<div class="param_element plugin_param">
            """),_display_(/*36.14*/parameter(param, value)),format.raw/*36.37*/("""
        """),format.raw/*37.9*/("""</div>
        """)))}),format.raw/*38.10*/("""
    """),format.raw/*39.5*/("""</div>
    <div class="operator_footer """),_display_(/*40.34*/{opType.toLowerCase}),format.raw/*40.54*/("""Div">
        """),_display_(/*41.10*/plugin/*41.16*/.label),format.raw/*41.22*/(""" """),format.raw/*41.23*/("""("""),_display_(/*41.25*/opType),format.raw/*41.31*/(""")
    </div>
</div>

"""),format.raw/*47.3*/("""
"""),format.raw/*70.2*/("""

"""),format.raw/*74.2*/("""

"""),format.raw/*86.2*/("""

"""),format.raw/*102.2*/("""


"""))
      }
    }
  }

  def render(opType:String,id:String,plugin:org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},parameterValues:Seq[String],x:Int,y:Int,display:Boolean,project:Project,additionalContent:Html,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(opType,id,plugin,parameterValues,x,y,display,project)(additionalContent)(userContext)

  def f:((String,String,org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Seq[String],Int,Int,Boolean,Project) => (Html) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (opType,id,plugin,parameterValues,x,y,display,project) => (additionalContent) => (userContext) => apply(opType,id,plugin,parameterValues,x,y,display,project)(additionalContent)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/operatorBox.scala.html
                  HASH: 7e5575f52ab28a77dcc9c650c1a5273cc9165c78
                  MATRIX: 439->1|485->41|523->73|573->117|630->168|693->225|752->278|1302->334|1626->2879|1653->2897|1767->2934|1797->2938|1813->2945|1982->3092|2007->3097|2031->3112|2145->3149|2173->3150|2367->3317|2413->3342|2455->3356|2489->3368|2526->3377|2560->3389|2598->3399|2625->3404|2702->3454|2748->3479|2789->3493|2822->3505|2853->3508|2868->3513|2896->3519|2984->3580|3030->3605|3071->3619|3105->3631|3169->3668|3183->3673|3216->3685|3252->3694|3309->3724|3323->3729|3365->3750|3397->3755|3435->3773|3457->3786|3631->3882|3659->3883|3852->4049|3898->4074|3940->4088|3974->4100|4011->4109|4045->4121|4085->4134|4176->4209|4216->4211|4252->4220|4295->4236|4334->4254|4364->4257|4402->4286|4442->4288|4471->4289|4523->4310|4553->4312|4586->4323|4636->4342|4668->4347|4753->4405|4799->4430|4840->4444|4874->4456|4905->4459|4920->4464|4948->4470|5036->4531|5082->4556|5123->4570|5157->4582|5221->4619|5235->4624|5268->4636|5304->4645|5361->4675|5375->4680|5417->4701|5450->4706|5488->1881|5506->1890|6522->580|6550->581|6587->591|6631->614|6676->632|6717->652|6768->676|6792->679|6829->689|6853->692|6905->717|6926->729|6966->731|6995->732|7041->747|7085->764|7129->787|7172->803|7216->826|7389->972|7404->978|7428->981|7489->1015|7516->1021|7612->1090|7635->1092|7725->1155|7748->1157|7794->1176|7817->1178|7886->1220|7901->1226|7943->1247|8101->1378|8116->1384|8161->1408|8219->1439|8235->1445|8269->1457|8345->1506|8383->1523|8420->1533|8496->1593|8536->1595|8572->1604|8653->1658|8697->1681|8733->1690|8780->1706|8812->1711|8879->1751|8920->1771|8962->1786|8977->1792|9004->1798|9033->1799|9062->1801|9089->1807|9137->1879|9165->2876|9194->3094|9223->3770|9253->4721
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|30->9|40->72|40->72|42->72|43->73|43->73|43->73|44->76|44->76|46->76|47->77|48->78|48->78|48->78|48->78|48->78|48->78|48->78|48->78|49->79|49->79|49->79|49->79|49->79|49->79|49->79|50->80|50->80|50->80|50->80|51->81|51->81|51->81|52->82|53->83|53->83|53->83|54->84|56->88|56->88|58->88|59->89|60->90|60->90|60->90|60->90|60->90|60->90|61->91|61->91|61->91|62->92|62->92|62->92|62->92|62->92|62->92|62->92|62->92|62->92|62->92|63->93|64->94|65->95|65->95|65->95|65->95|65->95|65->95|65->95|66->96|66->96|66->96|66->96|67->97|67->97|67->97|68->98|69->99|69->99|69->99|70->100|72->48|72->48|95->16|96->17|96->17|96->17|96->17|96->17|97->18|97->18|97->18|97->18|97->18|97->18|97->18|97->18|97->18|98->19|98->19|98->19|98->19|102->23|102->23|102->23|103->24|103->24|105->26|105->26|106->27|106->27|106->27|106->27|107->28|107->28|107->28|109->30|109->30|109->30|109->30|109->30|109->30|112->33|112->33|113->34|113->34|113->34|114->35|115->36|115->36|116->37|117->38|118->39|119->40|119->40|120->41|120->41|120->41|120->41|120->41|120->41|124->47|125->70|127->74|129->86|131->102
                  -- GENERATED --
              */
          