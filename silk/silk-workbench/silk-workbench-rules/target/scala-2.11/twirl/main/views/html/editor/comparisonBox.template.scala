
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

object comparisonBox extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template11[String,Boolean,Int,Double,org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Seq[String],Int,Int,Boolean,Project,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(id: String,
required: Boolean, weight: Int, threshold: Double,
plugin: org.silkframework.runtime.plugin.PluginDescription[_],
parameterValues: Seq[String],
x: Int, y: Int, display: Boolean,
project: Project)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*11.1*/("""
"""),_display_(/*12.2*/operatorBox("Compare", id, plugin, parameterValues, x, y, display, project)/*12.77*/ {_display_(Seq[Any](format.raw/*12.79*/("""
"""),format.raw/*13.1*/("""<div class="param_element">
  <label id=""""),_display_(/*14.15*/{GenerateId(id, display)}),format.raw/*14.40*/("""_param_required" class="param_label" tabindex="-1">Required</label>
  <div class="mdl-defer" data-mdl-defer="tooltip" for=""""),_display_(/*15.57*/{GenerateId(id, display)}),format.raw/*15.82*/("""_param_required">
    If required is set, the parent aggregation should only generate a result if this
    operator yields a value.
    A comparison will only yield a value if in turn both input operators yield values.
  </div>
  <input type="checkbox" class="param_value" name="required" """),_display_(/*20.63*/if(required)/*20.75*/ {_display_(Seq[Any](format.raw/*20.77*/("""checked="checked"""")))}),format.raw/*20.95*/("""/>
</div>
<div class="param_element">
  <label id=""""),_display_(/*23.15*/{GenerateId(id, display)}),format.raw/*23.40*/("""_param_threshold" class="param_label" tabindex="-1">Threshold</label>
  <div class="mdl-defer" data-mdl-defer="tooltip" for=""""),_display_(/*24.57*/{GenerateId(id, display)}),format.raw/*24.82*/("""_param_threshold">
    The maximum distance. For normalized distance measures, the threshold should be between 0.0 and 1.0.
  </div>
  <input class="param_value" type="text" name="threshold" value=""""),_display_(/*27.67*/threshold),format.raw/*27.76*/(""""/>
</div>
<div class="param_element">
  <label id=""""),_display_(/*30.15*/{GenerateId(id, display)}),format.raw/*30.40*/("""_param_weight" class="param_label" tabindex="-1">Weight</label>
  <div class="mdl-defer" data-mdl-defer="tooltip" for=""""),_display_(/*31.57*/{GenerateId(id, display)}),format.raw/*31.82*/("""_param_weight">
    The weight parameter can be used by the parent aggregation when combining
    its input values. Only certain aggregations will consider weighted inputs. Examples are the weighted average
    aggregation, quadraticMean and geometricMean.
  </div>
  <input class="param_value" type="text" name="weight" value=""""),_display_(/*36.64*/weight),format.raw/*36.70*/(""""/>
</div>
""")))}))
      }
    }
  }

  def render(id:String,required:Boolean,weight:Int,threshold:Double,plugin:org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},parameterValues:Seq[String],x:Int,y:Int,display:Boolean,project:Project,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(id,required,weight,threshold,plugin,parameterValues,x,y,display,project)(userContext)

  def f:((String,Boolean,Int,Double,org.silkframework.runtime.plugin.PluginDescription[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Seq[String],Int,Int,Boolean,Project) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (id,required,weight,threshold,plugin,parameterValues,x,y,display,project) => (userContext) => apply(id,required,weight,threshold,plugin,parameterValues,x,y,display,project)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/comparisonBox.scala.html
                  HASH: 6a1177e5d03c0ed9c68e4f8d6606c8c5962c83d2
                  MATRIX: 439->1|477->33|527->78|1086->133|1424->377|1452->379|1536->454|1576->456|1604->457|1673->499|1719->524|1870->648|1916->673|2233->963|2254->975|2294->977|2343->995|2422->1047|2468->1072|2621->1198|2667->1223|2893->1422|2923->1431|3003->1484|3049->1509|3196->1629|3242->1654|3598->1983|3625->1989
                  LINES: 17->1|18->2|19->4|26->5|36->11|37->12|37->12|37->12|38->13|39->14|39->14|40->15|40->15|45->20|45->20|45->20|45->20|48->23|48->23|49->24|49->24|52->27|52->27|55->30|55->30|56->31|56->31|61->36|61->36
                  -- GENERATED --
              */
          