
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
/*1.2*/import views.editor.GenerateId
/*2.2*/import org.silkframework.workspace.Project
/*4.2*/import org.silkframework.runtime.activity.UserContext

object aggregationBox extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template10[String,Boolean,Int,org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Seq[String],Int,Int,Boolean,Project,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(id: String,
  required: Boolean, weight: Int,
  plugin: org.silkframework.runtime.plugin.PluginDescription[_],
  parameterValues: Seq[String],
  x: Int, y: Int, display: Boolean,
  project: Project)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*11.1*/("""
"""),_display_(/*12.2*/operatorBox("Aggregate", id, plugin, parameterValues, x, y, display, project)/*12.79*/ {_display_(Seq[Any](format.raw/*12.81*/("""
"""),format.raw/*13.1*/("""<div class="param_element">
  <label id=""""),_display_(/*14.15*/{GenerateId(id, display)}),format.raw/*14.40*/("""_param_required" class="param_label" tabindex="-1">Required</label>
  <div class="mdl-defer" data-mdl-defer="tooltip" for=""""),_display_(/*15.57*/{GenerateId(id, display)}),format.raw/*15.82*/("""_param_required">
    If required is set, the parent aggregation should only generate a result if this
    operator yields a value.
  </div>
  <input type="checkbox" class="param_value" name="required" """),_display_(/*19.63*/if(required)/*19.75*/ {_display_(Seq[Any](format.raw/*19.77*/("""checked="checked"""")))}),format.raw/*19.95*/("""/>
</div>
<div class="param_element">
  <label id=""""),_display_(/*22.15*/{GenerateId(id, display)}),format.raw/*22.40*/("""_param_weight" class="param_label" tabindex="-1">Weight</label>
  <div class="mdl-defer" data-mdl-defer="tooltip" for=""""),_display_(/*23.57*/{GenerateId(id, display)}),format.raw/*23.82*/("""_param_weight">
    The weight parameter can be used by the parent aggregation when combining
    its input values. Only certain aggregations will consider weighted inputs. Examples are the weighted average
    aggregation, quadraticMean and geometricMean.
  </div>
  <input class="param_value" type="text" name="weight" value=""""),_display_(/*28.64*/weight),format.raw/*28.70*/(""""/>
</div>
""")))}))
      }
    }
  }

  def render(id:String,required:Boolean,weight:Int,plugin:org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},parameterValues:Seq[String],x:Int,y:Int,display:Boolean,project:Project,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(id,required,weight,plugin,parameterValues,x,y,display,project)(userContext)

  def f:((String,Boolean,Int,org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Seq[String],Int,Int,Boolean,Project) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (id,required,weight,plugin,parameterValues,x,y,display,project) => (userContext) => apply(id,required,weight,plugin,parameterValues,x,y,display,project)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/aggregationBox.scala.html
                  HASH: 248dea7d0467ed2cdb1d7d9958fc202aee1c29c1
                  MATRIX: 439->1|477->33|527->78|1080->133|1409->368|1437->370|1523->447|1563->449|1591->450|1660->492|1706->517|1857->641|1903->666|2133->869|2154->881|2194->883|2243->901|2322->953|2368->978|2515->1098|2561->1123|2917->1452|2944->1458
                  LINES: 17->1|18->2|19->4|26->5|36->11|37->12|37->12|37->12|38->13|39->14|39->14|40->15|40->15|44->19|44->19|44->19|44->19|47->22|47->22|48->23|48->23|53->28|53->28
                  -- GENERATED --
              */
          