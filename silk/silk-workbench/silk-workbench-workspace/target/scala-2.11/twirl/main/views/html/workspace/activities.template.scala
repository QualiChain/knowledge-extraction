
package views.html.workspace

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
/*2.2*/import controllers.workspace.routes.{ActivityApi, Assets, WorkspaceController}
/*3.2*/import org.silkframework.config.TaskSpec
/*4.2*/import org.silkframework.workspace.activity.CachedActivity
/*5.2*/import org.silkframework.runtime.activity.HasValue
/*6.2*/import org.silkframework.workspace.activity.{CachedActivity, ProjectActivity, TaskActivity}
/*7.2*/import org.silkframework.workspace.{Project, ProjectTask, WorkspaceFactory, Workspace}
/*8.2*/import org.silkframework.runtime.activity.UserContext
/*9.2*/import config.WorkbenchConfig

object activities extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[play.api.mvc.Session,UserContext,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**
 * Overview page of all activities and their status
 */
  def apply/*14.2*/()(implicit session: play.api.mvc.Session, userContext: UserContext, request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*16.2*/header/*16.8*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*16.12*/("""
  """),format.raw/*17.3*/("""<link rel="stylesheet" href=""""),_display_(/*17.33*/CoreAssets/*17.43*/.at("libs/jstree/dist/themes/default/style.css")),format.raw/*17.91*/("""" type="text/css" />
  <link rel="stylesheet" href=""""),_display_(/*18.33*/Assets/*18.39*/.at("workspace.css")),format.raw/*18.59*/("""" type="text/css" />
  <script src=""""),_display_(/*19.17*/CoreAssets/*19.27*/.at("libs/jstree/dist/jstree.js")),format.raw/*19.60*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*20.17*/Assets/*20.23*/.at("workspace.js")),format.raw/*20.42*/("""" type="text/javascript"></script>
  <script type="text/javascript">
    $( window ).on("load", function () """),format.raw/*22.40*/("""{"""),format.raw/*22.41*/("""
      """),format.raw/*23.7*/("""$('#workspace_root').jstree();
      // Restore scroll position on reload
      setTimeout(function() """),format.raw/*25.29*/("""{"""),format.raw/*25.30*/("""
        """),format.raw/*26.9*/("""const scrollTop = parseInt(sessionStorage.getItem("activityViewScrollPosition"));
        console.log(scrollTop);
        if(!isNaN(scrollTop) && scrollTop > 50) """),format.raw/*28.49*/("""{"""),format.raw/*28.50*/("""
          """),format.raw/*29.11*/("""document.getElementsByClassName("mdl-layout__content")[0].scrollTop = scrollTop;
        """),format.raw/*30.9*/("""}"""),format.raw/*30.10*/("""
        """),format.raw/*31.9*/("""sessionStorage.removeItem("activityViewScrollPosition");
      """),format.raw/*32.7*/("""}"""),format.raw/*32.8*/(""", 1000);
      // Register to status updates
      connectWebSocket(
      '"""),_display_(/*35.9*/Html(ActivityApi.activityStatusUpdatesWebSocket("", "", "").webSocketURL(WorkbenchConfig().useHttps))),format.raw/*35.110*/("""',
      '"""),_display_(/*36.9*/Html(ActivityApi.getActivityStatusUpdates("", "", "").url)),format.raw/*36.67*/("""',
      updateStatus
    )
    """),format.raw/*39.5*/("""}"""),format.raw/*39.6*/(""");

    function updateStatus(status) """),format.raw/*41.35*/("""{"""),format.raw/*41.36*/("""
      """),format.raw/*42.7*/("""// Get progress bar node
      var node = $(document.getElementById("progress_" + status.project + "_" + status.task + "_" + encodeURIComponent(status.activity).replace(/%20/g,'+')));
      var progressbar = node.find(".activity-progress-small");

      // Initialize progress bar
      if(progressbar.find(".ui-progressbar-value").length == 0) """),format.raw/*47.65*/("""{"""),format.raw/*47.66*/("""
        """),format.raw/*48.9*/("""progressbar.progressbar();
      """),format.raw/*49.7*/("""}"""),format.raw/*49.8*/("""

      """),format.raw/*51.7*/("""// Get child nodes
      var progressbarValue = progressbar.find(".ui-progressbar-value");
      var progressbarText = progressbar.find(".activity-progress-small-text");
      var progressbarHelp = progressbar.find(".activity-progress-small-help");

      // Update values
      progressbar.attr('title', status.message);
      if(status.statusName === "Idle") """),format.raw/*58.40*/("""{"""),format.raw/*58.41*/("""
        """),format.raw/*59.9*/("""progressbar.progressbar("option", """),format.raw/*59.43*/("""{"""),format.raw/*59.44*/("""disabled: true, value: 0"""),format.raw/*59.68*/("""}"""),format.raw/*59.69*/(""");
        progressbarText.text(status.message);
        progressbarHelp.hide();
      """),format.raw/*62.7*/("""}"""),format.raw/*62.8*/(""" """),format.raw/*62.9*/("""else if(status.failed) """),format.raw/*62.32*/("""{"""),format.raw/*62.33*/("""
        """),format.raw/*63.9*/("""progressbar.progressbar("option", """),format.raw/*63.43*/("""{"""),format.raw/*63.44*/("""disabled: false, value: 100"""),format.raw/*63.71*/("""}"""),format.raw/*63.72*/(""");
        progressbarValue.css("""),format.raw/*64.30*/("""{"""),format.raw/*64.31*/("""
          """),format.raw/*65.11*/(""""background": '#FF5050'
        """),format.raw/*66.9*/("""}"""),format.raw/*66.10*/(""");
        progressbarText.text("Failed ");
        progressbarHelp.show();
      """),format.raw/*69.7*/("""}"""),format.raw/*69.8*/(""" """),format.raw/*69.9*/("""else if(status.statusName === "Waiting") """),format.raw/*69.50*/("""{"""),format.raw/*69.51*/("""
        """),format.raw/*70.9*/("""progressbar.progressbar("option", """),format.raw/*70.43*/("""{"""),format.raw/*70.44*/("""disabled: false, value: 100"""),format.raw/*70.71*/("""}"""),format.raw/*70.72*/(""");
        progressbarValue.css("""),format.raw/*71.30*/("""{"""),format.raw/*71.31*/("""
          """),format.raw/*72.11*/(""""background": '#fffb00'
        """),format.raw/*73.9*/("""}"""),format.raw/*73.10*/(""");
        progressbarText.text(status.message);
        progressbarHelp.show();
      """),format.raw/*76.7*/("""}"""),format.raw/*76.8*/(""" """),format.raw/*76.9*/("""else """),format.raw/*76.14*/("""{"""),format.raw/*76.15*/("""
        """),format.raw/*77.9*/("""progressbar.progressbar("option", """),format.raw/*77.43*/("""{"""),format.raw/*77.44*/("""disabled: false, value: parseFloat(status.progress)"""),format.raw/*77.95*/("""}"""),format.raw/*77.96*/(""");
        progressbarValue.css("""),format.raw/*78.30*/("""{"""),format.raw/*78.31*/("""
          """),format.raw/*79.11*/(""""background": 'rgb(100, ' + Math.round(100 + status.progress * 1.55) + ', 100)'
        """),format.raw/*80.9*/("""}"""),format.raw/*80.10*/(""");
        progressbarText.text(status.message);
        progressbarHelp.hide();
      """),format.raw/*83.7*/("""}"""),format.raw/*83.8*/("""

      """),format.raw/*85.7*/("""// Update buttons
      if(status.statusName == "Canceling") """),format.raw/*86.44*/("""{"""),format.raw/*86.45*/("""
        """),format.raw/*87.9*/("""node.find(".activity-button-start").hide();
        node.find(".activity-button-stop").hide();
      """),format.raw/*89.7*/("""}"""),format.raw/*89.8*/(""" """),format.raw/*89.9*/("""else if(status.isRunning) """),format.raw/*89.35*/("""{"""),format.raw/*89.36*/("""
        """),format.raw/*90.9*/("""node.find(".activity-button-start").hide();
        node.find(".activity-button-stop").show();
      """),format.raw/*92.7*/("""}"""),format.raw/*92.8*/(""" """),format.raw/*92.9*/("""else """),format.raw/*92.14*/("""{"""),format.raw/*92.15*/("""
        """),format.raw/*93.9*/("""node.find(".activity-button-stop").hide();
        node.find(".activity-button-start").show();
      """),format.raw/*95.7*/("""}"""),format.raw/*95.8*/("""
    """),format.raw/*96.5*/("""}"""),format.raw/*96.6*/("""

    """),format.raw/*98.5*/("""function post(url) """),format.raw/*98.24*/("""{"""),format.raw/*98.25*/("""
      """),format.raw/*99.7*/("""$.post(url).fail(function(request) """),format.raw/*99.42*/("""{"""),format.raw/*99.43*/(""" """),format.raw/*99.44*/("""alert(request.responseText); """),format.raw/*99.73*/("""}"""),format.raw/*99.74*/(""")
    """),format.raw/*100.5*/("""}"""),format.raw/*100.6*/("""
  """),format.raw/*101.3*/("""</script>
""")))};def /*104.2*/toolbar/*104.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*104.13*/("""
""")))};def /*107.2*/content/*107.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*107.13*/("""
  """),_display_(/*108.4*/workspaceActivities(WorkspaceFactory().workspace)),format.raw/*108.53*/("""

  """),format.raw/*110.3*/("""<div id="statusCometIFrame"></div>
""")))};def /*113.2*/workspaceActivities/*113.21*/(workspace: Workspace):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*113.47*/("""
  """),format.raw/*114.3*/("""<div id="workspace_root">
    <ul class="filetree">
    """),_display_(/*116.6*/for(project <- workspace.projects) yield /*116.40*/ {_display_(Seq[Any](format.raw/*116.42*/("""
      """),_display_(/*117.8*/projectActivities(project)),format.raw/*117.34*/("""
    """)))}),format.raw/*118.6*/("""
    """),format.raw/*119.5*/("""</ul>
  </div>
""")))};def /*123.2*/projectActivities/*123.19*/(project: Project):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*123.41*/("""
  """),format.raw/*124.3*/("""<li id="project_"""),_display_(/*124.20*/project/*124.27*/.name),format.raw/*124.32*/("""" class="jstree-open" >
    """),_display_(/*125.6*/project/*125.13*/.name),format.raw/*125.18*/("""
    """),format.raw/*126.5*/("""<ul>
    Project Activities
    """),_display_(/*128.6*/for(activity <- project.activities) yield /*128.41*/ {_display_(Seq[Any](format.raw/*128.43*/("""
      """),_display_(/*129.8*/projectActivityStatus(project, activity)),format.raw/*129.48*/("""
    """)))}),format.raw/*130.6*/("""
    """),format.raw/*131.5*/("""</ul>
    <ul>
    """),_display_(/*133.6*/for(task <- project.allTasks) yield /*133.35*/ {_display_(Seq[Any](format.raw/*133.37*/("""
      """),_display_(/*134.8*/taskActivities(project, task)),format.raw/*134.37*/("""
    """)))}),format.raw/*135.6*/("""
    """),format.raw/*136.5*/("""</ul>
  </li>
""")))};def /*140.2*/taskActivities/*140.16*/(project: Project, task: ProjectTask[_ <: TaskSpec]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*140.72*/("""
  """),format.raw/*141.3*/("""<li id="task_"""),_display_(/*141.17*/{project.name}),format.raw/*141.31*/("""_"""),_display_(/*141.33*/task/*141.37*/.id),format.raw/*141.40*/("""" class="jstree-open">
    """),_display_(/*142.6*/task/*142.10*/.taskLabel()),format.raw/*142.22*/("""
    """),format.raw/*143.5*/("""<ul>
    """),_display_(/*144.6*/for(activity <- task.activities) yield /*144.38*/ {_display_(Seq[Any](format.raw/*144.40*/("""
      """),_display_(/*145.8*/taskActivityStatus(project, task, activity)),format.raw/*145.51*/("""
    """)))}),format.raw/*146.6*/("""
    """),format.raw/*147.5*/("""</ul>
  </li>
""")))};def /*151.2*/projectActivityStatus/*151.23*/(project: Project, activity: ProjectActivity[_ <: HasValue]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*151.87*/("""
  """),format.raw/*152.3*/("""<li id=""""),_display_(/*152.12*/id(project.name, "", activity.name)),format.raw/*152.47*/("""" data-jstree='"""),format.raw/*152.62*/("""{"""),format.raw/*152.63*/(""""icon":""""),_display_(/*152.72*/Assets/*152.78*/.at("img/file-tag.png")),format.raw/*152.101*/("""""""),format.raw/*152.102*/("""}"""),format.raw/*152.103*/("""' title=""""),_display_(/*152.113*/activity/*152.121*/.description),format.raw/*152.133*/("""">
    """),_display_(/*153.6*/activity/*153.14*/.label),format.raw/*153.20*/("""
    """),format.raw/*154.5*/("""<div class="activity-progress-small">
      <div class="activity-progress-small-text"></div>
      <img class="activity-progress-small-help" src=""""),_display_(/*156.55*/Assets/*156.61*/.at("img/help.png")),format.raw/*156.80*/(""""/>
    </div>
    <div class="activity-button-start">
      <img title="Start activity" width="16" height="16" src=""""),_display_(/*159.64*/Assets/*159.70*/.at("img/control-start.png")),format.raw/*159.98*/("""" onclick="post('"""),_display_(/*159.116*/ActivityApi/*159.127*/.startActivity(project.name, "", activity.name, blocking = false).url),format.raw/*159.196*/("""')" />
    </div>
    <div class="activity-button-stop">
      <img title="Stop activity" width="16" height="16" src=""""),_display_(/*162.63*/Assets/*162.69*/.at("img/control-stop.png")),format.raw/*162.96*/("""" onclick="post('"""),_display_(/*162.114*/ActivityApi/*162.125*/.cancelActivity(project.name, "", activity.name).url),format.raw/*162.177*/("""')" />
    </div>
    """),_display_(/*164.6*/if(activity.defaultConfig.nonEmpty)/*164.41*/ {_display_(Seq[Any](format.raw/*164.43*/("""
      """),format.raw/*165.7*/("""<div class="activity-button-edit">
        <img title="Edit activity configuration" width="16" height="16" src=""""),_display_(/*166.79*/Assets/*166.85*/.at("img/wrench.png")),format.raw/*166.106*/("""" onclick="showDialog('"""),_display_(/*166.130*/WorkspaceController/*166.149*/.projectActivityConfigDialog(project.name, activity.name).url),format.raw/*166.210*/("""')" />
      </div>
    """)))}),format.raw/*168.6*/("""
  """),format.raw/*169.3*/("""</li>
""")))};def /*172.2*/taskActivityStatus/*172.20*/(project: Project, task: ProjectTask[_ <: TaskSpec], activity: TaskActivity[_, _]):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*172.106*/("""
  """),format.raw/*173.3*/("""<li id=""""),_display_(/*173.12*/id(project.name, task.id, activity.name)),format.raw/*173.52*/("""" data-jstree='"""),format.raw/*173.67*/("""{"""),format.raw/*173.68*/(""""icon":""""),_display_(/*173.77*/Assets/*173.83*/.at("img/file-tag.png")),format.raw/*173.106*/("""""""),format.raw/*173.107*/("""}"""),format.raw/*173.108*/("""' title=""""),_display_(/*173.118*/activity/*173.126*/.description),format.raw/*173.138*/("""">
    """),_display_(/*174.6*/activity/*174.14*/.label),format.raw/*174.20*/("""
    """),format.raw/*175.5*/("""<div class="activity-progress-small">
      <div class="activity-progress-small-text"></div>
      <img class="activity-progress-small-help" src=""""),_display_(/*177.55*/Assets/*177.61*/.at("img/help.png")),format.raw/*177.80*/(""""/>
    </div>
    <div class="activity-button-start">
      <img title="Start activity" width="16" height="16" src=""""),_display_(/*180.64*/Assets/*180.70*/.at("img/control-start.png")),format.raw/*180.98*/("""" onclick="post('"""),_display_(/*180.116*/ActivityApi/*180.127*/.startActivity(project.name, task.id, activity.name, blocking = false).url),format.raw/*180.201*/("""')" />
    </div>
    <div class="activity-button-stop">
      <img title="Stop activity" width="16" height="16" src=""""),_display_(/*183.63*/Assets/*183.69*/.at("img/control-stop.png")),format.raw/*183.96*/("""" onclick="post('"""),_display_(/*183.114*/ActivityApi/*183.125*/.cancelActivity(project.name, task.id, activity.name).url),format.raw/*183.182*/("""')" />
    </div>
    <div class="activity-button-edit">
      """),_display_(/*186.8*/if(activity.defaultConfig.nonEmpty)/*186.43*/ {_display_(Seq[Any](format.raw/*186.45*/("""
        """),format.raw/*187.9*/("""<img title="Edit activity configuration" width="16" height="16" src=""""),_display_(/*187.79*/Assets/*187.85*/.at("img/wrench.png")),format.raw/*187.106*/("""" onclick="showDialog('"""),_display_(/*187.130*/WorkspaceController/*187.149*/.taskActivityConfigDialog(project.name, task.id, activity.name).url),format.raw/*187.216*/("""')" />
      """)))}),format.raw/*188.8*/("""
    """),format.raw/*189.5*/("""</div>
    <div class="activity-button-value">
      """),_display_(/*191.8*/if(!activity.isUnitValueType)/*191.37*/ {_display_(Seq[Any](format.raw/*191.39*/("""
        """),format.raw/*192.9*/("""<img title="Show current value" width="16" height="16" src=""""),_display_(/*192.70*/Assets/*192.76*/.at("img/magnifier.png")),format.raw/*192.100*/("""" onclick="window.open('"""),_display_(/*192.125*/ActivityApi/*192.136*/.getActivityValue(project.name, task.id, activity.name).url),format.raw/*192.195*/("""', '_blank')" />
      """)))}),format.raw/*193.8*/("""
    """),format.raw/*194.5*/("""</div>
    <div class="activity-button-reload">
    """),_display_(/*196.6*/if(classOf[CachedActivity[_]].isAssignableFrom(activity.control.underlying.getClass))/*196.91*/ {_display_(Seq[Any](format.raw/*196.93*/("""
      """),format.raw/*197.7*/("""<img title="Reload cache" width="16" height="16" src=""""),_display_(/*197.62*/Assets/*197.68*/.at("img/control-reload.png")),format.raw/*197.97*/("""" onclick="post('"""),_display_(/*197.115*/ActivityApi/*197.126*/.restartActivity(project.name, task.id, activity.name).url),format.raw/*197.184*/("""')" />
    """)))}),format.raw/*198.6*/("""
    """),format.raw/*199.5*/("""</div>
  </li>
""")))};def /*203.2*/id/*203.4*/(project: String, task: String, activity: String) = {{
  "progress_" + project + "_" + task + "_" + helper.urlEncode(activity)
}};
Seq[Any](format.raw/*15.1*/("""
"""),format.raw/*102.2*/("""

"""),format.raw/*105.2*/("""

"""),format.raw/*111.2*/("""

"""),format.raw/*121.2*/("""

"""),format.raw/*138.2*/("""

"""),format.raw/*149.2*/("""

"""),format.raw/*170.2*/("""

"""),format.raw/*201.2*/("""

"""),format.raw/*205.2*/("""

"""),_display_(/*207.2*/main(None, "activities")/*207.26*/(header)/*207.34*/(toolbar)/*207.43*/(content)))
      }
    }
  }

  def render(session:play.api.mvc.Session,userContext:UserContext,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply()(session,userContext,request)

  def f:(() => (play.api.mvc.Session,UserContext,RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = () => (session,userContext,request) => apply()(session,userContext,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/activities.scala.html
                  HASH: f680d3537af881bc357cf5020f9bccf6ba96c694
                  MATRIX: 442->1|503->56|589->136|637->178|703->238|761->290|860->383|954->471|1015->526|1450->618|1621->713|1635->719|1716->723|1746->726|1803->756|1822->766|1891->814|1971->867|1986->873|2027->893|2091->930|2110->940|2164->973|2242->1024|2257->1030|2297->1049|2433->1157|2462->1158|2496->1165|2626->1267|2655->1268|2691->1277|2881->1439|2910->1440|2949->1451|3065->1540|3094->1541|3130->1550|3220->1613|3248->1614|3351->1691|3474->1792|3511->1803|3590->1861|3649->1893|3677->1894|3743->1932|3772->1933|3806->1940|4179->2285|4208->2286|4244->2295|4304->2328|4332->2329|4367->2337|4756->2698|4785->2699|4821->2708|4883->2742|4912->2743|4964->2767|4993->2768|5107->2855|5135->2856|5163->2857|5214->2880|5243->2881|5279->2890|5341->2924|5370->2925|5425->2952|5454->2953|5514->2985|5543->2986|5582->2997|5641->3029|5670->3030|5779->3112|5807->3113|5835->3114|5904->3155|5933->3156|5969->3165|6031->3199|6060->3200|6115->3227|6144->3228|6204->3260|6233->3261|6272->3272|6331->3304|6360->3305|6474->3392|6502->3393|6530->3394|6563->3399|6592->3400|6628->3409|6690->3443|6719->3444|6798->3495|6827->3496|6887->3528|6916->3529|6955->3540|7070->3628|7099->3629|7213->3716|7241->3717|7276->3725|7365->3786|7394->3787|7430->3796|7558->3897|7586->3898|7614->3899|7668->3925|7697->3926|7733->3935|7861->4036|7889->4037|7917->4038|7950->4043|7979->4044|8015->4053|8143->4154|8171->4155|8203->4160|8231->4161|8264->4167|8311->4186|8340->4187|8374->4194|8437->4229|8466->4230|8495->4231|8552->4260|8581->4261|8615->4267|8644->4268|8675->4271|8710->4285|8726->4292|8808->4296|8834->4301|8850->4308|8932->4312|8963->4316|9034->4365|9066->4369|9126->4408|9155->4427|9259->4453|9290->4456|9374->4513|9425->4547|9466->4549|9501->4557|9549->4583|9586->4589|9619->4594|9659->4613|9686->4630|9786->4652|9817->4655|9862->4672|9879->4679|9906->4684|9962->4713|9979->4720|10006->4725|10039->4730|10099->4763|10151->4798|10192->4800|10227->4808|10289->4848|10326->4854|10359->4859|10406->4879|10452->4908|10493->4910|10528->4918|10579->4947|10616->4953|10649->4958|10688->4976|10712->4990|10846->5046|10877->5049|10919->5063|10955->5077|10985->5079|10999->5083|11024->5086|11079->5114|11093->5118|11127->5130|11160->5135|11197->5145|11246->5177|11287->5179|11322->5187|11387->5230|11424->5236|11457->5241|11496->5259|11527->5280|11669->5344|11700->5347|11737->5356|11794->5391|11838->5406|11868->5407|11905->5416|11921->5422|11967->5445|11998->5446|12029->5447|12068->5457|12087->5465|12122->5477|12157->5485|12175->5493|12203->5499|12236->5504|12411->5651|12427->5657|12468->5676|12614->5794|12630->5800|12680->5828|12727->5846|12749->5857|12841->5926|12988->6045|13004->6051|13053->6078|13100->6096|13122->6107|13197->6159|13247->6182|13292->6217|13333->6219|13368->6226|13509->6339|13525->6345|13569->6366|13622->6390|13652->6409|13736->6470|13792->6495|13823->6498|13854->6508|13882->6526|14047->6612|14078->6615|14115->6624|14177->6664|14221->6679|14251->6680|14288->6689|14304->6695|14350->6718|14381->6719|14412->6720|14451->6730|14470->6738|14505->6750|14540->6758|14558->6766|14586->6772|14619->6777|14794->6924|14810->6930|14851->6949|14997->7067|15013->7073|15063->7101|15110->7119|15132->7130|15229->7204|15376->7323|15392->7329|15441->7356|15488->7374|15510->7385|15590->7442|15681->7506|15726->7541|15767->7543|15804->7552|15902->7622|15918->7628|15962->7649|16015->7673|16045->7692|16135->7759|16180->7773|16213->7778|16294->7832|16333->7861|16374->7863|16411->7872|16500->7933|16516->7939|16563->7963|16617->7988|16639->7999|16721->8058|16776->8082|16809->8087|16889->8140|16984->8225|17025->8227|17060->8234|17143->8289|17159->8295|17210->8324|17257->8342|17279->8353|17360->8411|17403->8423|17436->8428|17476->8447|17487->8449|17645->711|17674->4282|17704->4298|17734->4405|17764->4610|17794->4973|17824->5256|17854->6505|17884->8444|17914->8577|17944->8580|17978->8604|17996->8612|18015->8621
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|25->9|32->14|36->16|36->16|38->16|39->17|39->17|39->17|39->17|40->18|40->18|40->18|41->19|41->19|41->19|42->20|42->20|42->20|44->22|44->22|45->23|47->25|47->25|48->26|50->28|50->28|51->29|52->30|52->30|53->31|54->32|54->32|57->35|57->35|58->36|58->36|61->39|61->39|63->41|63->41|64->42|69->47|69->47|70->48|71->49|71->49|73->51|80->58|80->58|81->59|81->59|81->59|81->59|81->59|84->62|84->62|84->62|84->62|84->62|85->63|85->63|85->63|85->63|85->63|86->64|86->64|87->65|88->66|88->66|91->69|91->69|91->69|91->69|91->69|92->70|92->70|92->70|92->70|92->70|93->71|93->71|94->72|95->73|95->73|98->76|98->76|98->76|98->76|98->76|99->77|99->77|99->77|99->77|99->77|100->78|100->78|101->79|102->80|102->80|105->83|105->83|107->85|108->86|108->86|109->87|111->89|111->89|111->89|111->89|111->89|112->90|114->92|114->92|114->92|114->92|114->92|115->93|117->95|117->95|118->96|118->96|120->98|120->98|120->98|121->99|121->99|121->99|121->99|121->99|121->99|122->100|122->100|123->101|124->104|124->104|126->104|127->107|127->107|129->107|130->108|130->108|132->110|133->113|133->113|135->113|136->114|138->116|138->116|138->116|139->117|139->117|140->118|141->119|143->123|143->123|145->123|146->124|146->124|146->124|146->124|147->125|147->125|147->125|148->126|150->128|150->128|150->128|151->129|151->129|152->130|153->131|155->133|155->133|155->133|156->134|156->134|157->135|158->136|160->140|160->140|162->140|163->141|163->141|163->141|163->141|163->141|163->141|164->142|164->142|164->142|165->143|166->144|166->144|166->144|167->145|167->145|168->146|169->147|171->151|171->151|173->151|174->152|174->152|174->152|174->152|174->152|174->152|174->152|174->152|174->152|174->152|174->152|174->152|174->152|175->153|175->153|175->153|176->154|178->156|178->156|178->156|181->159|181->159|181->159|181->159|181->159|181->159|184->162|184->162|184->162|184->162|184->162|184->162|186->164|186->164|186->164|187->165|188->166|188->166|188->166|188->166|188->166|188->166|190->168|191->169|192->172|192->172|194->172|195->173|195->173|195->173|195->173|195->173|195->173|195->173|195->173|195->173|195->173|195->173|195->173|195->173|196->174|196->174|196->174|197->175|199->177|199->177|199->177|202->180|202->180|202->180|202->180|202->180|202->180|205->183|205->183|205->183|205->183|205->183|205->183|208->186|208->186|208->186|209->187|209->187|209->187|209->187|209->187|209->187|209->187|210->188|211->189|213->191|213->191|213->191|214->192|214->192|214->192|214->192|214->192|214->192|214->192|215->193|216->194|218->196|218->196|218->196|219->197|219->197|219->197|219->197|219->197|219->197|219->197|220->198|221->199|223->203|223->203|226->15|227->102|229->105|231->111|233->121|235->138|237->149|239->170|241->201|243->205|245->207|245->207|245->207|245->207
                  -- GENERATED --
              */
          