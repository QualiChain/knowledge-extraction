
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
/*1.2*/import org.silkframework.rule.Operator
/*2.2*/import org.silkframework.rule.input.TransformInput
/*3.2*/import org.silkframework.rule.input.PathInput
/*4.2*/import org.silkframework.rule.similarity.Aggregation
/*5.2*/import org.silkframework.rule.similarity.Comparison
/*6.2*/import org.silkframework.rule.RuleTraverser
/*7.2*/import org.silkframework.runtime.plugin.PluginDescription
/*8.2*/import views.editor.GenerateId
/*9.2*/import org.silkframework.workspace.Project
/*11.2*/import org.silkframework.runtime.activity.UserContext

object renderRule extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[org.silkframework.rule.Operator,Project,UserContext,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*12.2*/(rule: org.silkframework.rule.Operator,
  project: Project)(implicit userContext: UserContext):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*19.2*/drawLevel/*19.11*/(ops: Seq[Operator], x: Int, height: Int):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*19.56*/("""
  """),_display_(/*20.4*/if(!ops.isEmpty)/*20.20*/ {_display_(Seq[Any](format.raw/*20.22*/("""
    """),_display_(/*21.6*/for((op, index) <- ops.zipWithIndex) yield /*21.42*/ {_display_(Seq[Any](format.raw/*21.44*/("""
      """),_display_(/*22.8*/drawOperator(op, x + 20, height * (index + 1) / (ops.size + 1) - 80)),format.raw/*22.76*/("""
    """)))}),format.raw/*23.6*/("""
    """),_display_(/*24.6*/drawLevel(ops.flatMap(getChildren), x - 250, height)),format.raw/*24.58*/("""
  """)))}),format.raw/*25.4*/("""
""")))};def /*59.2*/drawOperator/*59.14*/(op: Operator, x: Int, y: Int):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*59.48*/("""
  """),_display_(/*60.4*/op/*60.6*/ match/*60.12*/ {/*61.5*/case Aggregation(id, required, weight, aggregator, operators) =>/*61.69*/ {_display_(Seq[Any](format.raw/*61.71*/("""
      """),_display_(/*62.8*/aggregationBox(id, required, weight, aggregator.pluginSpec, parameterValues(aggregator, aggregator.pluginSpec), x, y, true, project)),format.raw/*62.140*/("""
    """)))}/*64.5*/case Comparison(id, required, weight, threshold, indexing, metric, inputs) =>/*64.82*/ {_display_(Seq[Any](format.raw/*64.84*/("""
      """),_display_(/*65.8*/comparisonBox(id, required, weight, threshold, metric.pluginSpec, parameterValues(metric, metric.pluginSpec), x, y, true, project)),format.raw/*65.138*/("""
    """)))}/*67.5*/case TransformInput(id, transformer, inputs) =>/*67.52*/ {_display_(Seq[Any](format.raw/*67.54*/("""
      """),_display_(/*68.8*/transformationBox(id, transformer.pluginSpec, parameterValues(transformer, transformer.pluginSpec), x, y, true, project)),format.raw/*68.128*/("""
    """)))}/*70.5*/case PathInput(id, path) =>/*70.32*/ {_display_(Seq[Any](format.raw/*70.34*/("""
      """),_display_(/*71.8*/pathBox(id, isSourceInput(op), path.serialize()(project.config.prefixes), x, y, true, project)),format.raw/*71.102*/("""
    """)))}}),format.raw/*73.4*/("""
""")))};def /*99.2*/connectOperators/*99.18*/(op: Operator):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*99.36*/("""
"""),format.raw/*100.1*/("""<script type="text/javascript">

  function connectOperators()"""),format.raw/*102.30*/("""{"""),format.raw/*102.31*/("""

  """),_display_(/*104.4*/connectOperator(op)),format.raw/*104.23*/("""


  """),format.raw/*107.3*/("""}"""),format.raw/*107.4*/("""

  """),format.raw/*109.3*/("""// Initialization
  jsPlumb.bind("ready", function() """),format.raw/*110.36*/("""{"""),format.raw/*110.37*/("""
    """),format.raw/*111.5*/("""if(inEditorEnv)"""),format.raw/*111.20*/("""{"""),format.raw/*111.21*/("""

      """),format.raw/*113.7*/("""jsPlumb.setSuspendEvents(true);
      jsPlumb.setSuspendDrawing(true);


      var dropArea = $('#droppable');
      jsPlumb.draggable(dropArea.find('.dragDiv'));
      initEditor();
      connectOperators();
      jsPlumb.setSuspendDrawing(false, true);
      jsPlumb.setSuspendEvents(false);

      saveInstance();

    """),format.raw/*126.5*/("""}"""),format.raw/*126.6*/(""" """),format.raw/*126.7*/("""else """),format.raw/*126.12*/("""{"""),format.raw/*126.13*/("""
      """),format.raw/*127.7*/("""console.log('Not in editorEnv, will not initialize')
    """),format.raw/*128.5*/("""}"""),format.raw/*128.6*/("""
  """),format.raw/*129.3*/("""}"""),format.raw/*129.4*/(""");

</script>
""")))};def /*134.2*/connectOperator/*134.17*/(op: Operator):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*134.35*/("""
  """),_display_(/*135.4*/op/*135.6*/ match/*135.12*/ {/*136.5*/case Aggregation(id, required, weight, aggregator, operators) =>/*136.69*/ {_display_(Seq[Any](format.raw/*136.71*/("""
      """),format.raw/*137.28*/("""
      """),_display_(/*138.8*/for(op <- operators) yield /*138.28*/ {_display_(Seq[Any](format.raw/*138.30*/("""
        """),_display_(/*139.10*/connectOperator(op)),format.raw/*139.29*/("""
      """)))}),format.raw/*140.8*/("""

      """),format.raw/*142.29*/("""
      """),format.raw/*143.7*/("""var """),_display_(/*143.12*/targetEndpoint(id)),format.raw/*143.30*/(""" """),format.raw/*143.31*/("""= jsPlumb.addEndpoint('"""),_display_(/*143.55*/GenerateId(id,true)),format.raw/*143.74*/("""', endpointSimilarityTarget);
      var """),_display_(/*144.12*/sourceEndpoint(id)),format.raw/*144.30*/(""" """),format.raw/*144.31*/("""= jsPlumb.addEndpoint('"""),_display_(/*144.55*/GenerateId(id,true)),format.raw/*144.74*/("""', endpointSimilaritySource);

      """),format.raw/*146.29*/("""
      """),_display_(/*147.8*/for(op <- operators) yield /*147.28*/ {_display_(Seq[Any](format.raw/*147.30*/("""
        """),format.raw/*148.9*/("""jsPlumb.connect("""),format.raw/*148.25*/("""{"""),format.raw/*148.26*/("""
        """),format.raw/*149.9*/("""source: """),_display_(/*149.18*/sourceEndpoint(op.id)),format.raw/*149.39*/(""",
        target: """),_display_(/*150.18*/targetEndpoint(id)),format.raw/*150.36*/("""
        """),format.raw/*151.9*/("""}"""),format.raw/*151.10*/(""");
      """)))}),format.raw/*152.8*/("""
    """)))}/*154.5*/case Comparison(id, required, weight, threshold, indexing, metric, inputs) =>/*154.82*/ {_display_(Seq[Any](format.raw/*154.84*/("""
      """),format.raw/*155.28*/("""
      """),_display_(/*156.8*/connectOperator(inputs.source)),format.raw/*156.38*/("""
      """),_display_(/*157.8*/connectOperator(inputs.target)),format.raw/*157.38*/("""

      """),format.raw/*159.29*/("""
      """),format.raw/*160.7*/("""var """),_display_(/*160.12*/targetEndpoint(id)),format.raw/*160.30*/(""" """),format.raw/*160.31*/("""= jsPlumb.addEndpoint('"""),_display_(/*160.55*/GenerateId(id,true)),format.raw/*160.74*/("""', endpointValueTarget);
      var """),_display_(/*161.12*/sourceEndpoint(id)),format.raw/*161.30*/(""" """),format.raw/*161.31*/("""= jsPlumb.addEndpoint('"""),_display_(/*161.55*/GenerateId(id,true)),format.raw/*161.74*/("""', endpointSimilaritySource);

      """),format.raw/*163.29*/("""
      """),format.raw/*164.7*/("""jsPlumb.connect("""),format.raw/*164.23*/("""{"""),format.raw/*164.24*/("""
      """),format.raw/*165.7*/("""source: """),_display_(/*165.16*/sourceEndpoint(inputs.source.id)),format.raw/*165.48*/(""",
      target: """),_display_(/*166.16*/targetEndpoint(id)),format.raw/*166.34*/("""
      """),format.raw/*167.7*/("""}"""),format.raw/*167.8*/(""");
      jsPlumb.connect("""),format.raw/*168.23*/("""{"""),format.raw/*168.24*/("""
      """),format.raw/*169.7*/("""source: """),_display_(/*169.16*/sourceEndpoint(inputs.target.id)),format.raw/*169.48*/(""",
      target: """),_display_(/*170.16*/targetEndpoint(id)),format.raw/*170.34*/("""
      """),format.raw/*171.7*/("""}"""),format.raw/*171.8*/(""");
    """)))}/*173.5*/case TransformInput(id, transformer, inputs) =>/*173.52*/ {_display_(Seq[Any](format.raw/*173.54*/("""
      """),format.raw/*174.28*/("""
      """),_display_(/*175.8*/for(input <- inputs) yield /*175.28*/ {_display_(Seq[Any](format.raw/*175.30*/("""
        """),_display_(/*176.10*/connectOperator(input)),format.raw/*176.32*/("""
      """)))}),format.raw/*177.8*/("""

      """),format.raw/*179.7*/("""var """),_display_(/*179.12*/targetEndpoint(id)),format.raw/*179.30*/(""" """),format.raw/*179.31*/("""= jsPlumb.addEndpoint('"""),_display_(/*179.55*/GenerateId(id,true)),format.raw/*179.74*/("""', endpointValueTarget);
      var """),_display_(/*180.12*/sourceEndpoint(id)),format.raw/*180.30*/(""" """),format.raw/*180.31*/("""= jsPlumb.addEndpoint('"""),_display_(/*180.55*/GenerateId(id,true)),format.raw/*180.74*/("""', endpointValueSource);

      """),format.raw/*182.29*/("""
      """),_display_(/*183.8*/for(input <- inputs) yield /*183.28*/ {_display_(Seq[Any](format.raw/*183.30*/("""
        """),format.raw/*184.9*/("""jsPlumb.connect("""),format.raw/*184.25*/("""{"""),format.raw/*184.26*/("""
        """),format.raw/*185.9*/("""source: """),_display_(/*185.18*/sourceEndpoint(input.id)),format.raw/*185.42*/(""",
        target: """),_display_(/*186.18*/targetEndpoint(id)),format.raw/*186.36*/("""
        """),format.raw/*187.9*/("""}"""),format.raw/*187.10*/(""");
      """)))}),format.raw/*188.8*/("""
    """)))}/*190.5*/case PathInput(id, path) =>/*190.32*/ {_display_(Seq[Any](format.raw/*190.34*/("""
      """),format.raw/*191.7*/("""var """),_display_(/*191.12*/sourceEndpoint(id)),format.raw/*191.30*/(""" """),format.raw/*191.31*/("""= jsPlumb.addEndpoint('"""),_display_(/*191.55*/GenerateId(id,true)),format.raw/*191.74*/("""', endpointValueSource);
    """)))}}),format.raw/*193.4*/("""
""")))};def /*28.2*/countLevels/*28.13*/(op: Operator) = {{
  def count(op: Operator): Int = {
    val children = getChildren(op)
    if(children.isEmpty)
      1
    else
      1 + children.map(count).max
  }
  count(op)
}};def /*39.2*/maxWidth/*39.10*/(op: Operator) = {{
  def findMax(ops: Seq[Operator]): Int = {
    val children = ops.flatMap(getChildren)
    if(children.isEmpty)
      ops.size
    else
      Seq(ops.size, findMax(children)).max
  }
  findMax(Seq(op))
}};def /*50.2*/getChildren/*50.13*/(op: Operator) = {{
  op match {
    case agg: Aggregation => agg.operators
    case cmp: Comparison => cmp.inputs.toSeq
    case transform: TransformInput => transform.inputs
    case path: PathInput => Seq.empty
  }
}};def /*76.2*/parameterValues/*76.17*/(plugin: AnyRef, pluginType: PluginDescription[_]) = {{
  for(p <- pluginType.parameters) yield p.stringValue(plugin)(project.config.prefixes)
}};def /*83.2*/isSourceInput/*83.15*/(op: Operator) = {{
  var isSource = true
  for {
    // Get a traversable node for the given operator
    inputNode <- RuleTraverser(rule).iterateAllChildren.find(_.operator.id == op.id)
    // Find the root input, i.e., the one directly below a comparison
    rootInputNode <- inputNode.iterateParents.find(_.moveUp.exists(_.operator.isInstanceOf[Comparison]))
    // Get the comparison node
    comparisonNode <- rootInputNode.moveUp
  } {
    // The operator is a source input if it is the first child of the comparison
    isSource = comparisonNode.iterateChildren.next.operator.id == rootInputNode.operator.id
  }
  isSource
}};def /*196.2*/sourceEndpoint/*196.16*/(id: String) = {{
  "endpoint_" + id.replace('-', '$') + "_source"
}};def /*200.2*/targetEndpoint/*200.16*/(id: String) = {{
  "endpoint_" + id.replace('-', '$') + "_target"
}};
Seq[Any](format.raw/*14.1*/("""
"""),_display_(/*15.2*/drawLevel(Seq(rule), (countLevels(rule) - 1) * 250, maxWidth(rule) * 200)),format.raw/*15.75*/("""

"""),_display_(/*17.2*/connectOperators(rule)),format.raw/*17.24*/("""

"""),format.raw/*26.2*/("""

"""),format.raw/*37.2*/("""

"""),format.raw/*48.2*/("""

"""),format.raw/*57.2*/("""

"""),format.raw/*74.2*/("""

"""),format.raw/*78.2*/("""

"""),format.raw/*82.4*/("""
"""),format.raw/*97.2*/("""

"""),format.raw/*132.2*/("""

"""),format.raw/*194.2*/("""

"""),format.raw/*198.2*/("""

"""))
      }
    }
  }

  def render(rule:org.silkframework.rule.Operator,project:Project,userContext:UserContext): play.twirl.api.HtmlFormat.Appendable = apply(rule,project)(userContext)

  def f:((org.silkframework.rule.Operator,Project) => (UserContext) => play.twirl.api.HtmlFormat.Appendable) = (rule,project) => (userContext) => apply(rule,project)(userContext)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 30 22:35:15 CEST 2019
                  SOURCE: /home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/app/views/editor/renderRule.scala.html
                  HASH: 454825c5b98589fb73b1d9861fda47ed1f235012
                  MATRIX: 439->1|485->41|543->93|596->140|656->194|715->247|766->292|831->351|869->383|920->428|1329->483|1502->681|1520->690|1642->735|1672->739|1697->755|1737->757|1769->763|1821->799|1861->801|1895->809|1984->877|2020->883|2052->889|2125->941|2159->945|2184->1614|2205->1626|2316->1660|2346->1664|2356->1666|2371->1672|2381->1679|2454->1743|2494->1745|2528->1753|2682->1885|2706->1896|2792->1973|2832->1975|2866->1983|3018->2113|3042->2124|3098->2171|3138->2173|3172->2181|3314->2301|3338->2312|3374->2339|3414->2341|3448->2349|3564->2443|3601->2453|3626->3334|3651->3350|3746->3368|3775->3369|3866->3431|3896->3432|3928->3437|3969->3456|4002->3461|4031->3462|4063->3466|4145->3519|4175->3520|4208->3525|4252->3540|4282->3541|4318->3549|4668->3871|4697->3872|4726->3873|4760->3878|4790->3879|4825->3886|4910->3943|4939->3944|4970->3947|4999->3948|5038->3966|5063->3981|5159->3999|5190->4003|5201->4005|5217->4011|5228->4018|5302->4082|5343->4084|5379->4112|5414->4120|5451->4140|5492->4142|5530->4152|5571->4171|5610->4179|5647->4209|5682->4216|5715->4221|5755->4239|5785->4240|5837->4264|5878->4283|5947->4324|5987->4342|6017->4343|6069->4367|6110->4386|6176->4445|6211->4453|6248->4473|6289->4475|6326->4484|6371->4500|6401->4501|6438->4510|6475->4519|6518->4540|6565->4559|6605->4577|6642->4586|6672->4587|6713->4597|6738->4608|6825->4685|6866->4687|6902->4715|6937->4723|6989->4753|7024->4761|7076->4791|7113->4821|7148->4828|7181->4833|7221->4851|7251->4852|7303->4876|7344->4895|7408->4931|7448->4949|7478->4950|7530->4974|7571->4993|7637->5052|7672->5059|7717->5075|7747->5076|7782->5083|7819->5092|7873->5124|7918->5141|7958->5159|7993->5166|8022->5167|8076->5192|8106->5193|8141->5200|8178->5209|8232->5241|8277->5258|8317->5276|8352->5283|8381->5284|8408->5297|8465->5344|8506->5346|8542->5374|8577->5382|8614->5402|8655->5404|8693->5414|8737->5436|8776->5444|8812->5452|8845->5457|8885->5475|8915->5476|8967->5500|9008->5519|9072->5555|9112->5573|9142->5574|9194->5598|9235->5617|9296->5671|9331->5679|9368->5699|9409->5701|9446->5710|9491->5726|9521->5727|9558->5736|9595->5745|9641->5769|9688->5788|9728->5806|9765->5815|9795->5816|9836->5826|9861->5837|9898->5864|9939->5866|9974->5873|10007->5878|10047->5896|10077->5897|10129->5921|10170->5940|10232->5974|10257->950|10277->961|10474->1147|10491->1155|10728->1381|10748->1392|10981->2458|11005->2473|11163->2686|11185->2699|11832->5979|11856->5993|11939->6064|11963->6078|12061->578|12089->580|12183->653|12212->656|12255->678|12284->947|12313->1144|12342->1378|12371->1611|12400->2455|12429->2617|12458->2684|12486->3331|12516->3963|12546->5976|12576->6061
                  LINES: 17->1|18->2|19->3|20->4|21->5|22->6|23->7|24->8|25->9|26->11|31->12|36->19|36->19|38->19|39->20|39->20|39->20|40->21|40->21|40->21|41->22|41->22|42->23|43->24|43->24|44->25|45->59|45->59|47->59|48->60|48->60|48->60|48->61|48->61|48->61|49->62|49->62|50->64|50->64|50->64|51->65|51->65|52->67|52->67|52->67|53->68|53->68|54->70|54->70|54->70|55->71|55->71|56->73|57->99|57->99|59->99|60->100|62->102|62->102|64->104|64->104|67->107|67->107|69->109|70->110|70->110|71->111|71->111|71->111|73->113|86->126|86->126|86->126|86->126|86->126|87->127|88->128|88->128|89->129|89->129|92->134|92->134|94->134|95->135|95->135|95->135|95->136|95->136|95->136|96->137|97->138|97->138|97->138|98->139|98->139|99->140|101->142|102->143|102->143|102->143|102->143|102->143|102->143|103->144|103->144|103->144|103->144|103->144|105->146|106->147|106->147|106->147|107->148|107->148|107->148|108->149|108->149|108->149|109->150|109->150|110->151|110->151|111->152|112->154|112->154|112->154|113->155|114->156|114->156|115->157|115->157|117->159|118->160|118->160|118->160|118->160|118->160|118->160|119->161|119->161|119->161|119->161|119->161|121->163|122->164|122->164|122->164|123->165|123->165|123->165|124->166|124->166|125->167|125->167|126->168|126->168|127->169|127->169|127->169|128->170|128->170|129->171|129->171|130->173|130->173|130->173|131->174|132->175|132->175|132->175|133->176|133->176|134->177|136->179|136->179|136->179|136->179|136->179|136->179|137->180|137->180|137->180|137->180|137->180|139->182|140->183|140->183|140->183|141->184|141->184|141->184|142->185|142->185|142->185|143->186|143->186|144->187|144->187|145->188|146->190|146->190|146->190|147->191|147->191|147->191|147->191|147->191|147->191|148->193|149->28|149->28|158->39|158->39|167->50|167->50|174->76|174->76|176->83|176->83|190->196|190->196|192->200|192->200|195->14|196->15|196->15|198->17|198->17|200->26|202->37|204->48|206->57|208->74|210->78|212->82|213->97|215->132|217->194|219->198
                  -- GENERATED --
              */
          