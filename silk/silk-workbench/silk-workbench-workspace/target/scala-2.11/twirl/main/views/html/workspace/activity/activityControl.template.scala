
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
/*1.2*/import controllers.core.routes.Assets
/*2.2*/import controllers.workspace.routes.ActivityApi
/*3.2*/import controllers.workspace.routes.WorkspaceController
/*4.2*/import org.silkframework.workspace.activity.WorkspaceActivity
/*5.2*/import config.WorkbenchConfig

object activityControl extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[String,Option[String],WorkspaceActivity[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Boolean,Boolean,Boolean,Boolean,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(project: String,
  task: Option[String],
  activity: WorkspaceActivity[_],
  showProgressBar: Boolean,
  showStartButton: Boolean,
  showRestartButton: Boolean,
  showConfigButton: Boolean)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*182.2*/id/*182.4*/(prefix: String) = {{
  prefix + project + "_" + task.getOrElse("") + "_" + helper.urlEncode(activity.name)
}};
Seq[Any](format.raw/*14.1*/("""
"""),format.raw/*15.1*/("""<div id=""""),_display_(/*15.11*/id("progress_")),format.raw/*15.26*/("""" class="activity-control">

  """),_display_(/*17.4*/if(showProgressBar)/*17.23*/ {_display_(Seq[Any](format.raw/*17.25*/("""
    """),format.raw/*18.5*/("""<div id=""""),_display_(/*18.15*/id("progressbar_")),format.raw/*18.33*/("""" class="activity-progress">
      <div class="activity-progress-text"></div>
      <img class="activity-progress-help" src=""""),_display_(/*20.49*/Assets/*20.55*/.at("img/help.png")),format.raw/*20.74*/(""""/>
    </div>
    <div class="mdl-tooltip" for=""""),_display_(/*22.36*/id("progressbar_")),format.raw/*22.54*/("""">
    </div>
  """)))}),format.raw/*24.4*/("""

  """),_display_(/*26.4*/if(showStartButton)/*26.23*/ {_display_(Seq[Any](format.raw/*26.25*/("""
    """),format.raw/*27.5*/("""<button id=""""),_display_(/*27.18*/id("startButton")),format.raw/*27.35*/(""""
            name="start" class="activity-button mdl-button mdl-js-button mdl-button--icon"
            onclick="startActivity()" >
      <i class="material-icons">play_arrow</i>
    </button>
    <div class="mdl-tooltip" for=""""),_display_(/*32.36*/id("startButton")),format.raw/*32.53*/("""">
      Start """),_display_(/*33.14*/activity/*33.22*/.label),format.raw/*33.28*/("""
    """),format.raw/*34.5*/("""</div>
    <button id=""""),_display_(/*35.18*/id("stopButton")),format.raw/*35.34*/(""""
            name="stop"
            class="activity-button mdl-button mdl-js-button mdl-button--icon"
            onclick="stopActivity()" >
      <i class="material-icons">stop</i>
    </button>
    <div class="mdl-tooltip" for=""""),_display_(/*41.36*/id("stopButton")),format.raw/*41.52*/("""">
      Stop """),_display_(/*42.13*/activity/*42.21*/.label),format.raw/*42.27*/("""
    """),format.raw/*43.5*/("""</div>
  """)))}),format.raw/*44.4*/("""

  """),_display_(/*46.4*/if(showRestartButton)/*46.25*/ {_display_(Seq[Any](format.raw/*46.27*/("""
    """),format.raw/*47.5*/("""<button id=""""),_display_(/*47.18*/id("restartButton")),format.raw/*47.37*/(""""
            name="reset"
            class="activity-button mdl-button mdl-js-button mdl-button--icon"
            onclick="restartActivity()" >
      <i class="material-icons">replay</i>
    </button>
    <div class="mdl-tooltip" for=""""),_display_(/*53.36*/id("restartButton")),format.raw/*53.55*/("""">
      Reset """),_display_(/*54.14*/activity/*54.22*/.label),format.raw/*54.28*/(""" """),format.raw/*54.29*/("""to its initial value and restart.
    </div>
  """)))}),format.raw/*56.4*/("""

  """),_display_(/*58.4*/if(showConfigButton && task.isDefined)/*58.42*/ {_display_(Seq[Any](format.raw/*58.44*/("""
    """),format.raw/*59.5*/("""<button id=""""),_display_(/*59.18*/id("configButton")),format.raw/*59.36*/(""""
            name="config"
            class="activity-button mdl-button mdl-js-button mdl-button--icon"
            onclick="showDialog('"""),_display_(/*62.35*/WorkspaceController/*62.54*/.taskActivityConfigDialog(project, task.get, activity.name)),format.raw/*62.113*/("""')" >
      <i class="material-icons">settings</i>
    </button>
    <div class="mdl-tooltip" for=""""),_display_(/*65.36*/id("configButton")),format.raw/*65.54*/("""">
      Start """),_display_(/*66.14*/activity/*66.22*/.label),format.raw/*66.28*/(""" """),format.raw/*66.29*/("""after configuring parameters.
    </div>
  """)))}),format.raw/*68.4*/("""

  """),_display_(/*70.4*/if(showConfigButton && task.isEmpty)/*70.40*/ {_display_(Seq[Any](format.raw/*70.42*/("""
    """),format.raw/*71.5*/("""<button id=""""),_display_(/*71.18*/id("configButton")),format.raw/*71.36*/(""""
            name="config" class="activity-button mdl-button mdl-js-button mdl-button--icon"
            onclick="showDialog('"""),_display_(/*73.35*/WorkspaceController/*73.54*/.projectActivityConfigDialog(project, activity.name)),format.raw/*73.106*/("""')" >
      <i class="material-icons">settings</i>
    </button>
    <div class="mdl-tooltip" for=""""),_display_(/*76.36*/id("configButton")),format.raw/*76.54*/("""">
      Start """),_display_(/*77.14*/activity/*77.22*/.label),format.raw/*77.28*/(""" """),format.raw/*77.29*/("""after configuring parameters.
    </div>
  """)))}),format.raw/*79.4*/("""

"""),format.raw/*81.1*/("""</div>

<script type="text/javascript">
  function updateStatus(status) """),format.raw/*84.33*/("""{"""),format.raw/*84.34*/("""
    """),format.raw/*85.5*/("""// Get control node
    let control = $(document.getElementById("progress_" + status.project + "_" + status.task + "_" + encodeURIComponent(status.activity).replace(/%20/g,'+')));
    let progressbar = control.children(".activity-progress");
    let tooltip = control.children(".mdl-tooltip").first();

    // Initialize progress bar
    if(progressbar.find(".ui-progressbar-value").length == 0) """),format.raw/*91.63*/("""{"""),format.raw/*91.64*/("""
      """),format.raw/*92.7*/("""progressbar.progressbar();
    """),format.raw/*93.5*/("""}"""),format.raw/*93.6*/("""

    """),format.raw/*95.5*/("""// Get progress bar child nodes
    let progressbarValue = progressbar.find(".ui-progressbar-value");
    let progressbarText = progressbar.find(".activity-progress-text");
    let progressbarHelp = progressbar.find(".activity-progress-help");

    // Update values
    tooltip.text(status.message);
    if(status.failed) """),format.raw/*102.23*/("""{"""),format.raw/*102.24*/("""
      """),format.raw/*103.7*/("""progressbar.progressbar("option", """),format.raw/*103.41*/("""{"""),format.raw/*103.42*/("""value: 100"""),format.raw/*103.52*/("""}"""),format.raw/*103.53*/(""");
      progressbarValue.addClass('status_red');
      progressbarValue.css("""),format.raw/*105.28*/("""{"""),format.raw/*105.29*/("""
        """),format.raw/*106.9*/(""""background": '#FF5050'
      """),format.raw/*107.7*/("""}"""),format.raw/*107.8*/(""");
      progressbarText.text("Failed ");
      progressbarHelp.show();
    """),format.raw/*110.5*/("""}"""),format.raw/*110.6*/(""" """),format.raw/*110.7*/("""else if(status.statusName === "Waiting") """),format.raw/*110.48*/("""{"""),format.raw/*110.49*/("""
      """),format.raw/*111.7*/("""progressbar.progressbar("option", """),format.raw/*111.41*/("""{"""),format.raw/*111.42*/("""value: 100"""),format.raw/*111.52*/("""}"""),format.raw/*111.53*/(""");
      progressbarValue.addClass('status_waiting');
      progressbarValue.css("""),format.raw/*113.28*/("""{"""),format.raw/*113.29*/("""
        """),format.raw/*114.9*/(""""background": '#fffb00'
      """),format.raw/*115.7*/("""}"""),format.raw/*115.8*/(""");
      progressbarText.text(status.message);
      progressbarHelp.show();
    """),format.raw/*118.5*/("""}"""),format.raw/*118.6*/(""" """),format.raw/*118.7*/("""else """),format.raw/*118.12*/("""{"""),format.raw/*118.13*/("""
      """),format.raw/*119.7*/("""progressbar.progressbar("option", """),format.raw/*119.41*/("""{"""),format.raw/*119.42*/("""value: parseFloat(status.progress)"""),format.raw/*119.76*/("""}"""),format.raw/*119.77*/(""");
      progressbarValue.css("""),format.raw/*120.28*/("""{"""),format.raw/*120.29*/("""
        """),format.raw/*121.9*/(""""background": 'rgb(100, ' + Math.round(100 + status.progress * 1.55) + ', 100)'
      """),format.raw/*122.7*/("""}"""),format.raw/*122.8*/(""");
      progressbarValue.addClass('status_green');
      progressbarText.text(status.message);
      progressbarHelp.hide();
    """),format.raw/*126.5*/("""}"""),format.raw/*126.6*/("""

    """),format.raw/*128.5*/("""// Enable/Disable start/stop buttons
    let startButton = control.children("button[name='start']");
    let resetButton = control.children("button[name='reset']");
    let stopButton = control.children("button[name='stop']");
    startButton.attr("disabled", status.isRunning);
    resetButton.attr("disabled", status.isRunning);
    stopButton.attr("disabled", !status.isRunning);
  """),format.raw/*135.3*/("""}"""),format.raw/*135.4*/("""

  """),format.raw/*137.3*/("""function startActivity() """),format.raw/*137.28*/("""{"""),format.raw/*137.29*/("""
    """),format.raw/*138.5*/("""$.ajax("""),format.raw/*138.12*/("""{"""),format.raw/*138.13*/("""
      """),format.raw/*139.7*/("""type: 'POST',
      url: '"""),_display_(/*140.14*/Html(ActivityApi.startActivity(project, task.getOrElse(""), activity.name, blocking = false).url)),format.raw/*140.111*/("""',
      success: function(response) """),format.raw/*141.35*/("""{"""),format.raw/*141.36*/("""
      """),format.raw/*142.7*/("""}"""),format.raw/*142.8*/(""",
      error: function(request) """),format.raw/*143.32*/("""{"""),format.raw/*143.33*/("""
        """),format.raw/*144.9*/("""alert("Could not start activity: Error (" + request.status + ") " + request.responseText);
      """),format.raw/*145.7*/("""}"""),format.raw/*145.8*/("""
    """),format.raw/*146.5*/("""}"""),format.raw/*146.6*/(""");
  """),format.raw/*147.3*/("""}"""),format.raw/*147.4*/("""

  """),format.raw/*149.3*/("""function stopActivity() """),format.raw/*149.27*/("""{"""),format.raw/*149.28*/("""
    """),format.raw/*150.5*/("""$.ajax("""),format.raw/*150.12*/("""{"""),format.raw/*150.13*/("""
      """),format.raw/*151.7*/("""type: 'POST',
      url: '"""),_display_(/*152.14*/Html(ActivityApi.cancelActivity(project, task.getOrElse(""), activity.name).url)),format.raw/*152.94*/("""',
      success: function(response) """),format.raw/*153.35*/("""{"""),format.raw/*153.36*/("""
      """),format.raw/*154.7*/("""}"""),format.raw/*154.8*/(""",
      error: function(request) """),format.raw/*155.32*/("""{"""),format.raw/*155.33*/("""
        """),format.raw/*156.9*/("""alert("Could not stop activity: Error (" + request.status + ") " + request.responseText);
      """),format.raw/*157.7*/("""}"""),format.raw/*157.8*/("""
    """),format.raw/*158.5*/("""}"""),format.raw/*158.6*/(""");
  """),format.raw/*159.3*/("""}"""),format.raw/*159.4*/("""

  """),format.raw/*161.3*/("""function restartActivity() """),format.raw/*161.30*/("""{"""),format.raw/*161.31*/("""
    """),format.raw/*162.5*/("""$.ajax("""),format.raw/*162.12*/("""{"""),format.raw/*162.13*/("""
      """),format.raw/*163.7*/("""type: 'POST',
      url: '"""),_display_(/*164.14*/Html(ActivityApi.restartActivity(project, task.getOrElse(""), activity.name).url)),format.raw/*164.95*/("""',
      success: function(response) """),format.raw/*165.35*/("""{"""),format.raw/*165.36*/("""
      """),format.raw/*166.7*/("""}"""),format.raw/*166.8*/(""",
      error: function(request) """),format.raw/*167.32*/("""{"""),format.raw/*167.33*/("""
        """),format.raw/*168.9*/("""alert("Could not restart activity: Error (" + request.status + ") " + request.responseText);
      """),format.raw/*169.7*/("""}"""),format.raw/*169.8*/("""
    """),format.raw/*170.5*/("""}"""),format.raw/*170.6*/(""");
  """),format.raw/*171.3*/("""}"""),format.raw/*171.4*/("""

  """),format.raw/*173.3*/("""$( window ).on("load", function() """),format.raw/*173.37*/("""{"""),format.raw/*173.38*/("""
    """),format.raw/*174.5*/("""connectWebSocket(
      '"""),_display_(/*175.9*/Html(ActivityApi.activityStatusUpdatesWebSocket(project, task.getOrElse(""), activity.name).webSocketURL(WorkbenchConfig().useHttps))),format.raw/*175.142*/("""',
      '"""),_display_(/*176.9*/Html(ActivityApi.getActivityStatusUpdates(project, task.getOrElse(""), activity.name).url)),format.raw/*176.99*/("""',
      updateStatus
    )
  """),format.raw/*179.3*/("""}"""),format.raw/*179.4*/(""");
</script>

"""),format.raw/*184.2*/("""
"""))
      }
    }
  }

  def render(project:String,task:Option[String],activity:WorkspaceActivity[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},showProgressBar:Boolean,showStartButton:Boolean,showRestartButton:Boolean,showConfigButton:Boolean,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(project,task,activity,showProgressBar,showStartButton,showRestartButton,showConfigButton)(request)

  def f:((String,Option[String],WorkspaceActivity[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},Boolean,Boolean,Boolean,Boolean) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (project,task,activity,showProgressBar,showStartButton,showRestartButton,showConfigButton) => (request) => apply(project,task,activity,showProgressBar,showStartButton,showRestartButton,showConfigButton)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/activity/activityControl.scala.html
                  HASH: f7a48ba3945804f884d0140177d10cd0980df1ed
                  MATRIX: 451->1|496->40|551->89|614->146|683->209|1180->241|1483->6418|1494->6420|1633->465|1661->466|1698->476|1734->491|1792->523|1820->542|1860->544|1892->549|1929->559|1968->577|2121->703|2136->709|2176->728|2253->778|2292->796|2339->813|2370->818|2398->837|2438->839|2470->844|2510->857|2548->874|2804->1103|2842->1120|2885->1136|2902->1144|2929->1150|2961->1155|3012->1179|3049->1195|3309->1428|3346->1444|3388->1459|3405->1467|3432->1473|3464->1478|3504->1488|3535->1493|3565->1514|3605->1516|3637->1521|3677->1534|3717->1553|3983->1792|4023->1811|4066->1827|4083->1835|4110->1841|4139->1842|4217->1890|4248->1895|4295->1933|4335->1935|4367->1940|4407->1953|4446->1971|4613->2111|4641->2130|4722->2189|4849->2289|4888->2307|4931->2323|4948->2331|4975->2337|5004->2338|5078->2382|5109->2387|5154->2423|5194->2425|5226->2430|5266->2443|5305->2461|5460->2589|5488->2608|5562->2660|5689->2760|5728->2778|5771->2794|5788->2802|5815->2808|5844->2809|5918->2853|5947->2855|6047->2927|6076->2928|6108->2933|6532->3329|6561->3330|6595->3337|6653->3368|6681->3369|6714->3375|7065->3697|7095->3698|7130->3705|7193->3739|7223->3740|7262->3750|7292->3751|7398->3828|7428->3829|7465->3838|7523->3868|7552->3869|7656->3945|7685->3946|7714->3947|7784->3988|7814->3989|7849->3996|7912->4030|7942->4031|7981->4041|8011->4042|8121->4123|8151->4124|8188->4133|8246->4163|8275->4164|8384->4245|8413->4246|8442->4247|8476->4252|8506->4253|8541->4260|8604->4294|8634->4295|8697->4329|8727->4330|8786->4360|8816->4361|8853->4370|8967->4456|8996->4457|9154->4587|9183->4588|9217->4594|9630->4979|9659->4980|9691->4984|9745->5009|9775->5010|9808->5015|9844->5022|9874->5023|9909->5030|9964->5057|10084->5154|10150->5191|10180->5192|10215->5199|10244->5200|10306->5233|10336->5234|10373->5243|10498->5340|10527->5341|10560->5346|10589->5347|10622->5352|10651->5353|10683->5357|10736->5381|10766->5382|10799->5387|10835->5394|10865->5395|10900->5402|10955->5429|11057->5509|11123->5546|11153->5547|11188->5554|11217->5555|11279->5588|11309->5589|11346->5598|11470->5694|11499->5695|11532->5700|11561->5701|11594->5706|11623->5707|11655->5711|11711->5738|11741->5739|11774->5744|11810->5751|11840->5752|11875->5759|11930->5786|12033->5867|12099->5904|12129->5905|12164->5912|12193->5913|12255->5946|12285->5947|12322->5956|12449->6055|12478->6056|12511->6061|12540->6062|12573->6067|12602->6068|12634->6072|12697->6106|12727->6107|12760->6112|12813->6138|12969->6271|13007->6282|13119->6372|13177->6402|13206->6403|13248->6529
                  LINES: 17->1|18->2|19->3|20->4|21->5|28->7|38->182|38->182|41->14|42->15|42->15|42->15|44->17|44->17|44->17|45->18|45->18|45->18|47->20|47->20|47->20|49->22|49->22|51->24|53->26|53->26|53->26|54->27|54->27|54->27|59->32|59->32|60->33|60->33|60->33|61->34|62->35|62->35|68->41|68->41|69->42|69->42|69->42|70->43|71->44|73->46|73->46|73->46|74->47|74->47|74->47|80->53|80->53|81->54|81->54|81->54|81->54|83->56|85->58|85->58|85->58|86->59|86->59|86->59|89->62|89->62|89->62|92->65|92->65|93->66|93->66|93->66|93->66|95->68|97->70|97->70|97->70|98->71|98->71|98->71|100->73|100->73|100->73|103->76|103->76|104->77|104->77|104->77|104->77|106->79|108->81|111->84|111->84|112->85|118->91|118->91|119->92|120->93|120->93|122->95|129->102|129->102|130->103|130->103|130->103|130->103|130->103|132->105|132->105|133->106|134->107|134->107|137->110|137->110|137->110|137->110|137->110|138->111|138->111|138->111|138->111|138->111|140->113|140->113|141->114|142->115|142->115|145->118|145->118|145->118|145->118|145->118|146->119|146->119|146->119|146->119|146->119|147->120|147->120|148->121|149->122|149->122|153->126|153->126|155->128|162->135|162->135|164->137|164->137|164->137|165->138|165->138|165->138|166->139|167->140|167->140|168->141|168->141|169->142|169->142|170->143|170->143|171->144|172->145|172->145|173->146|173->146|174->147|174->147|176->149|176->149|176->149|177->150|177->150|177->150|178->151|179->152|179->152|180->153|180->153|181->154|181->154|182->155|182->155|183->156|184->157|184->157|185->158|185->158|186->159|186->159|188->161|188->161|188->161|189->162|189->162|189->162|190->163|191->164|191->164|192->165|192->165|193->166|193->166|194->167|194->167|195->168|196->169|196->169|197->170|197->170|198->171|198->171|200->173|200->173|200->173|201->174|202->175|202->175|203->176|203->176|206->179|206->179|209->184
                  -- GENERATED --
              */
          