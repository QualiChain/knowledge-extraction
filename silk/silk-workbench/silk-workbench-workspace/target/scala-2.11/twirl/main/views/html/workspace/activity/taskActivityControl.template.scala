
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
/*1.2*/import org.silkframework.workspace.activity.TaskActivity
/*2.2*/import org.silkframework.workspace.activity.CachedActivity

object taskActivityControl extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[TaskActivity[_$1, _$2] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any;
   type _$2 >: _root_.scala.Nothing <: _root_.scala.Any
},Boolean,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(activity: TaskActivity[_, _], showButtons: Boolean = false)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.1*/("""
"""),_display_(/*6.2*/activityControl(
  project = activity.task.project.name,
  task = Some(activity.task.id),
  activity = activity,
  showProgressBar = true,
  showStartButton = showButtons,
  showRestartButton = showButtons && classOf[CachedActivity[_]].isAssignableFrom(activity.control.underlying.getClass),
  showConfigButton = showButtons && activity.defaultConfig.nonEmpty
)))
      }
    }
  }

  def render(activity:TaskActivity[_$1, _$2] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any;
   type _$2 >: _root_.scala.Nothing <: _root_.scala.Any
},showButtons:Boolean,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(activity,showButtons)(request)

  def f:((TaskActivity[_$1, _$2] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any;
   type _$2 >: _root_.scala.Nothing <: _root_.scala.Any
},Boolean) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (activity,showButtons) => (request) => apply(activity,showButtons)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/activity/taskActivityControl.scala.html
                  HASH: 17c1f06aef80d4f4ba7365ba765e0285659766dc
                  MATRIX: 451->1|515->59|1056->120|1243->214|1270->216
                  LINES: 17->1|18->2|26->4|31->5|32->6
                  -- GENERATED --
              */
          