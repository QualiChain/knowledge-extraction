
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
/*1.2*/import controllers.workspace.routes.ActivityApi
/*2.2*/import org.silkframework.workbench.Context
/*3.2*/import config.WorkbenchConfig

object autoReload extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Context[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},String,String,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(context: Context[_], contentPath: String, activityId: String)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*7.2*/id/*7.4*/() = {{
  "autoreload-" + activityId
}};
Seq[Any](format.raw/*6.1*/("""
"""),format.raw/*9.2*/("""

"""),format.raw/*11.1*/("""<script type="text/javascript">
  function statusUpdated(status) """),format.raw/*12.34*/("""{"""),format.raw/*12.35*/("""
    """),format.raw/*13.5*/("""if(!status.isRunning) """),format.raw/*13.27*/("""{"""),format.raw/*13.28*/("""
      """),format.raw/*14.7*/("""$.get('"""),_display_(/*14.15*/contentPath),format.raw/*14.26*/("""', function(data) """),format.raw/*14.44*/("""{"""),format.raw/*14.45*/("""
        """),format.raw/*15.9*/("""$('#"""),_display_(/*15.14*/id()),format.raw/*15.18*/("""').html(data);
      """),format.raw/*16.7*/("""}"""),format.raw/*16.8*/(""").fail(function(request) """),format.raw/*16.33*/("""{"""),format.raw/*16.34*/(""" """),format.raw/*16.35*/("""alert(request.responseText);  """),format.raw/*16.65*/("""}"""),format.raw/*16.66*/(""")
    """),format.raw/*17.5*/("""}"""),format.raw/*17.6*/("""
  """),format.raw/*18.3*/("""}"""),format.raw/*18.4*/("""

  """),format.raw/*20.3*/("""$( window ).on("load", function () """),format.raw/*20.38*/("""{"""),format.raw/*20.39*/("""
    """),format.raw/*21.5*/("""connectWebSocket(
      '"""),_display_(/*22.9*/Html(ActivityApi.activityStatusUpdatesWebSocket(context.project.name, context.task.id, activityId).webSocketURL(WorkbenchConfig().useHttps))),format.raw/*22.149*/("""',
      '"""),_display_(/*23.9*/Html(ActivityApi.getActivityStatusUpdates(context.project.name, context.task.id, activityId).url)),format.raw/*23.106*/("""',
      statusUpdated
    );
  """),format.raw/*26.3*/("""}"""),format.raw/*26.4*/(""");
</script>

<div id=""""),_display_(/*29.11*/id()),format.raw/*29.15*/(""""></div>
"""))
      }
    }
  }

  def render(context:Context[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},contentPath:String,activityId:String,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(context,contentPath,activityId)(request)

  def f:((Context[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},String,String) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (context,contentPath,activityId) => (request) => apply(context,contentPath,activityId)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-workspace/app/views/workspace/activity/autoReload.scala.html
                  HASH: 38df414038813b5384e1149fc48f0b6c2ac101aa
                  MATRIX: 451->1|506->50|556->94|998->126|1171->224|1180->226|1247->222|1274->264|1303->266|1396->331|1425->332|1457->337|1507->359|1536->360|1570->367|1605->375|1637->386|1683->404|1712->405|1748->414|1780->419|1805->423|1853->444|1881->445|1934->470|1963->471|1992->472|2050->502|2079->503|2112->509|2140->510|2170->513|2198->514|2229->518|2292->553|2321->554|2353->559|2405->585|2567->725|2604->736|2723->833|2782->865|2810->866|2861->890|2886->894
                  LINES: 17->1|18->2|19->3|26->5|30->7|30->7|33->6|34->9|36->11|37->12|37->12|38->13|38->13|38->13|39->14|39->14|39->14|39->14|39->14|40->15|40->15|40->15|41->16|41->16|41->16|41->16|41->16|41->16|41->16|42->17|42->17|43->18|43->18|45->20|45->20|45->20|46->21|47->22|47->22|48->23|48->23|51->26|51->26|54->29|54->29
                  -- GENERATED --
              */
          