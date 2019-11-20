
package views.html.workspace.activity

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
/*1.2*/import org.silkframework.workspace.activity.ProjectActivity
/*2.2*/import org.silkframework.workspace.activity.CachedActivity
/*3.2*/import org.silkframework.runtime.activity.HasValue
/*4.2*/import scala.language.existentials

object projectActivityControl extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[ProjectActivity[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: HasValue
},Boolean,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(activity: ProjectActivity[_ <: HasValue], showButtons: Boolean = false)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.1*/("""
"""),_display_(/*8.2*/activityControl(
  project = activity.project.name,
  task = None,
  activity = activity,
  showProgressBar = true,
  showStartButton = showButtons,
  showRestartButton = showButtons && classOf[CachedActivity[_]].isAssignableFrom(activity.control.underlying.getClass),
  showConfigButton = showButtons && activity.defaultConfig.nonEmpty
)),format.raw/*16.2*/("""
"""))
      }
    }
  }

  def render(activity:ProjectActivity[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: HasValue
},showButtons:Boolean,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(activity,showButtons)(request)

  def f:((ProjectActivity[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: HasValue
},Boolean) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (activity,showButtons) => (request) => apply(activity,showButtons)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/activity/projectActivityControl.scala.html
                  HASH: cd4c9b7d4e8a0c8a75a44bd5437bf7ae08aedbea
                  MATRIX: 451->1|518->62|584->122|642->174|1095->211|1294->317|1321->319|1679->657
                  LINES: 17->1|18->2|19->3|20->4|27->6|32->7|33->8|41->16
                  -- GENERATED --
              */
          