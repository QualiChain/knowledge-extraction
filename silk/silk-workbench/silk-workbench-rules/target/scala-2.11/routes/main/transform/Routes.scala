// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/conf/transform.routes
// @DATE:Tue Jul 30 22:35:14 CEST 2019

package transform

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  TransformDialogs_1: controllers.transform.TransformDialogs,
  // @LINE:7
  TransformEditor_7: controllers.transform.TransformEditor,
  // @LINE:16
  EvaluateTransform_4: controllers.transform.EvaluateTransform,
  // @LINE:20
  ExecuteTransformTab_3: controllers.transform.ExecuteTransformTab,
  // @LINE:24
  TransformTaskApi_2: controllers.transform.TransformTaskApi,
  // @LINE:38
  PeakTransformApi_6: controllers.transform.PeakTransformApi,
  // @LINE:41
  AutoCompletionApi_0: controllers.transform.AutoCompletionApi,
  // @LINE:45
  TargetVocabularyApi_5: controllers.transform.TargetVocabularyApi,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    TransformDialogs_1: controllers.transform.TransformDialogs,
    // @LINE:7
    TransformEditor_7: controllers.transform.TransformEditor,
    // @LINE:16
    EvaluateTransform_4: controllers.transform.EvaluateTransform,
    // @LINE:20
    ExecuteTransformTab_3: controllers.transform.ExecuteTransformTab,
    // @LINE:24
    TransformTaskApi_2: controllers.transform.TransformTaskApi,
    // @LINE:38
    PeakTransformApi_6: controllers.transform.PeakTransformApi,
    // @LINE:41
    AutoCompletionApi_0: controllers.transform.AutoCompletionApi,
    // @LINE:45
    TargetVocabularyApi_5: controllers.transform.TargetVocabularyApi
  ) = this(errorHandler, TransformDialogs_1, TransformEditor_7, EvaluateTransform_4, ExecuteTransformTab_3, TransformTaskApi_2, PeakTransformApi_6, AutoCompletionApi_0, TargetVocabularyApi_5, "/")

  def withPrefix(prefix: String): Routes = {
    transform.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, TransformDialogs_1, TransformEditor_7, EvaluateTransform_4, ExecuteTransformTab_3, TransformTaskApi_2, PeakTransformApi_6, AutoCompletionApi_0, TargetVocabularyApi_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/newTransformTask/""" + "$" + """project<[^/]+>""", """controllers.transform.TransformDialogs.transformationTaskDialog(project:String, task:String = "", createDialog:Boolean = true)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/editTransformTask/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.transform.TransformDialogs.transformationTaskDialog(project:String, task:String, createDialog:Boolean = false)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/deleteRule/""" + "$" + """name<[^/]+>""", """controllers.transform.TransformDialogs.deleteRuleDialog(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor""", """controllers.transform.TransformEditor.start(project:String, task:String, rule:String = "")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/rule/""" + "$" + """rule<[^/]+>""", """controllers.transform.TransformEditor.start(project:String, task:String, rule:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/""" + "$" + """rule<[^/]+>""", """controllers.transform.TransformEditor.editor(project:String, task:String, rule:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/widgets/property""", """controllers.transform.TransformEditor.propertyDetails(project:String, task:String, property:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/widgets/paths""", """controllers.transform.TransformEditor.paths(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/rule/""" + "$" + """rule<[^/]+>/widgets/paths""", """controllers.transform.TransformEditor.rulePaths(project:String, task:String, rule:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/widgets/score""", """controllers.transform.TransformEditor.score(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/evaluate""", """controllers.transform.EvaluateTransform.evaluate(project:String, task:String, offset:Int ?= 0, limit:Int ?= 100)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/evaluate/generatedEntities""", """controllers.transform.EvaluateTransform.generatedEntities(project:String, task:String, offset:Int ?= 0, limit:Int ?= 100)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/execute""", """controllers.transform.ExecuteTransformTab.execute(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/execute/report""", """controllers.transform.ExecuteTransformTab.executionReport(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.transform.TransformTaskApi.getTransformTask(project:String, task:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.transform.TransformTaskApi.putTransformTask(project:String, task:String, createOnly:Boolean = false)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.transform.TransformTaskApi.deleteTransformTask(project:String, task:String, removeDependentTasks:Boolean ?= false)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rules""", """controllers.transform.TransformTaskApi.getRules(project:String, task:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rules""", """controllers.transform.TransformTaskApi.putRules(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>""", """controllers.transform.TransformTaskApi.getRule(project:String, task:String, rule:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>""", """controllers.transform.TransformTaskApi.putRule(project:String, task:String, rule:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>""", """controllers.transform.TransformTaskApi.deleteRule(project:String, task:String, rule:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/rules""", """controllers.transform.TransformTaskApi.appendRule(project:String, task:String, rule:String, afterRuleId:Option[String] ?= None)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/rules/copyFrom""", """controllers.transform.TransformTaskApi.copyRule(project:String, task:String, rule:String, sourceProject:String, sourceTask:String, sourceRule:String, afterRuleId:Option[String] ?= None)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/rules/reorder""", """controllers.transform.TransformTaskApi.reorderRules(project:String, task:String, rule:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/reloadCache""", """controllers.transform.TransformTaskApi.reloadTransformCache(project:String, task:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/executeTransform""", """controllers.transform.TransformTaskApi.executeTransformTask(project:String, task:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/peak/""" + "$" + """rule<[^/]+>""", """controllers.transform.PeakTransformApi.peak(project:String, task:String, rule:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/peak/""" + "$" + """rule<[^/]+>/childRule""", """controllers.transform.PeakTransformApi.peakChildRule(project:String, task:String, rule:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/completions/sourcePaths""", """controllers.transform.AutoCompletionApi.sourcePaths(project:String, task:String, rule:String, term:String ?= "", maxResults:Int ?= 30)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/completions/targetTypes""", """controllers.transform.AutoCompletionApi.targetTypes(project:String, task:String, rule:String, term:String ?= "", maxResults:Int ?= 30)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/completions/targetProperties""", """controllers.transform.AutoCompletionApi.targetProperties(project:String, task:String, rule:String, term:String ?= "", maxResults:Int ?= 30)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/targetVocabulary/type""", """controllers.transform.TargetVocabularyApi.getTypeInfo(project:String, task:String, uri:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/targetVocabulary/property""", """controllers.transform.TargetVocabularyApi.getPropertyInfo(project:String, task:String, uri:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/targetVocabulary/typeOrProperty""", """controllers.transform.TargetVocabularyApi.getTypeOrPropertyInfo(project:String, task:String, uri:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/targetVocabulary/propertiesByClass""", """controllers.transform.TargetVocabularyApi.propertiesByType(project:String, task:String, classUri:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/targetVocabulary/relationsOfClass""", """controllers.transform.TargetVocabularyApi.relationsOfType(project:String, task:String, classUri:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/transformInput""", """controllers.transform.TransformTaskApi.postTransformInput(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/valueSourcePaths""", """controllers.transform.TransformTaskApi.valueSourcePaths(project:String, task:String, rule:String, maxDepth:Int ?= Int.MaxValue, unusedOnly:Boolean ?= false)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_transform_TransformDialogs_transformationTaskDialog0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/newTransformTask/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_TransformDialogs_transformationTaskDialog0_invoker = createInvoker(
    TransformDialogs_1.transformationTaskDialog(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformDialogs",
      "transformationTaskDialog",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """dialogs/newTransformTask/""" + "$" + """project<[^/]+>""",
      """ Dialogs""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_transform_TransformDialogs_transformationTaskDialog1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/editTransformTask/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_TransformDialogs_transformationTaskDialog1_invoker = createInvoker(
    TransformDialogs_1.transformationTaskDialog(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformDialogs",
      "transformationTaskDialog",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """dialogs/editTransformTask/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_transform_TransformDialogs_deleteRuleDialog2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/deleteRule/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_TransformDialogs_deleteRuleDialog2_invoker = createInvoker(
    TransformDialogs_1.deleteRuleDialog(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformDialogs",
      "deleteRuleDialog",
      Seq(classOf[String]),
      "GET",
      this.prefix + """dialogs/deleteRule/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_transform_TransformEditor_start3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/editor")))
  )
  private[this] lazy val controllers_transform_TransformEditor_start3_invoker = createInvoker(
    TransformEditor_7.start(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformEditor",
      "start",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor""",
      """ Transformation Editor""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_transform_TransformEditor_start4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/editor/rule/"), DynamicPart("rule", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_TransformEditor_start4_invoker = createInvoker(
    TransformEditor_7.start(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformEditor",
      "start",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/rule/""" + "$" + """rule<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_transform_TransformEditor_editor5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/editor/"), DynamicPart("rule", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_TransformEditor_editor5_invoker = createInvoker(
    TransformEditor_7.editor(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformEditor",
      "editor",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/""" + "$" + """rule<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_transform_TransformEditor_propertyDetails6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/editor/widgets/property")))
  )
  private[this] lazy val controllers_transform_TransformEditor_propertyDetails6_invoker = createInvoker(
    TransformEditor_7.propertyDetails(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformEditor",
      "propertyDetails",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/widgets/property""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_transform_TransformEditor_paths7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/editor/widgets/paths")))
  )
  private[this] lazy val controllers_transform_TransformEditor_paths7_invoker = createInvoker(
    TransformEditor_7.paths(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformEditor",
      "paths",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/widgets/paths""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_transform_TransformEditor_rulePaths8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/editor/rule/"), DynamicPart("rule", """[^/]+""",true), StaticPart("/widgets/paths")))
  )
  private[this] lazy val controllers_transform_TransformEditor_rulePaths8_invoker = createInvoker(
    TransformEditor_7.rulePaths(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformEditor",
      "rulePaths",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/rule/""" + "$" + """rule<[^/]+>/widgets/paths""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_transform_TransformEditor_score9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/editor/widgets/score")))
  )
  private[this] lazy val controllers_transform_TransformEditor_score9_invoker = createInvoker(
    TransformEditor_7.score(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformEditor",
      "score",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/widgets/score""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_transform_EvaluateTransform_evaluate10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/evaluate")))
  )
  private[this] lazy val controllers_transform_EvaluateTransform_evaluate10_invoker = createInvoker(
    EvaluateTransform_4.evaluate(fakeValue[String], fakeValue[String], fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.EvaluateTransform",
      "evaluate",
      Seq(classOf[String], classOf[String], classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/evaluate""",
      """ Evaluate Transformation""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_transform_EvaluateTransform_generatedEntities11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/evaluate/generatedEntities")))
  )
  private[this] lazy val controllers_transform_EvaluateTransform_generatedEntities11_invoker = createInvoker(
    EvaluateTransform_4.generatedEntities(fakeValue[String], fakeValue[String], fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.EvaluateTransform",
      "generatedEntities",
      Seq(classOf[String], classOf[String], classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/evaluate/generatedEntities""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_transform_ExecuteTransformTab_execute12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/execute")))
  )
  private[this] lazy val controllers_transform_ExecuteTransformTab_execute12_invoker = createInvoker(
    ExecuteTransformTab_3.execute(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.ExecuteTransformTab",
      "execute",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/execute""",
      """ Execute Transformation""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_transform_ExecuteTransformTab_executionReport13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/execute/report")))
  )
  private[this] lazy val controllers_transform_ExecuteTransformTab_executionReport13_invoker = createInvoker(
    ExecuteTransformTab_3.executionReport(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.ExecuteTransformTab",
      "executionReport",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/execute/report""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_transform_TransformTaskApi_getTransformTask14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_getTransformTask14_invoker = createInvoker(
    TransformTaskApi_2.getTransformTask(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "getTransformTask",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """ API""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_transform_TransformTaskApi_putTransformTask15_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_putTransformTask15_invoker = createInvoker(
    TransformTaskApi_2.putTransformTask(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "putTransformTask",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_transform_TransformTaskApi_deleteTransformTask16_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_deleteTransformTask16_invoker = createInvoker(
    TransformTaskApi_2.deleteTransformTask(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "deleteTransformTask",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "DELETE",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_transform_TransformTaskApi_getRules17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rules")))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_getRules17_invoker = createInvoker(
    TransformTaskApi_2.getRules(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "getRules",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rules""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_transform_TransformTaskApi_putRules18_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rules")))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_putRules18_invoker = createInvoker(
    TransformTaskApi_2.putRules(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "putRules",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rules""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_transform_TransformTaskApi_getRule19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule/"), DynamicPart("rule", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_getRule19_invoker = createInvoker(
    TransformTaskApi_2.getRule(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "getRule",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_transform_TransformTaskApi_putRule20_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule/"), DynamicPart("rule", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_putRule20_invoker = createInvoker(
    TransformTaskApi_2.putRule(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "putRule",
      Seq(classOf[String], classOf[String], classOf[String]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_transform_TransformTaskApi_deleteRule21_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule/"), DynamicPart("rule", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_deleteRule21_invoker = createInvoker(
    TransformTaskApi_2.deleteRule(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "deleteRule",
      Seq(classOf[String], classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_transform_TransformTaskApi_appendRule22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule/"), DynamicPart("rule", """[^/]+""",true), StaticPart("/rules")))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_appendRule22_invoker = createInvoker(
    TransformTaskApi_2.appendRule(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Option[String]]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "appendRule",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Option[String]]),
      "POST",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/rules""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_transform_TransformTaskApi_copyRule23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule/"), DynamicPart("rule", """[^/]+""",true), StaticPart("/rules/copyFrom")))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_copyRule23_invoker = createInvoker(
    TransformTaskApi_2.copyRule(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Option[String]]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "copyRule",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[Option[String]]),
      "POST",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/rules/copyFrom""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_transform_TransformTaskApi_reorderRules24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule/"), DynamicPart("rule", """[^/]+""",true), StaticPart("/rules/reorder")))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_reorderRules24_invoker = createInvoker(
    TransformTaskApi_2.reorderRules(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "reorderRules",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/rules/reorder""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_transform_TransformTaskApi_reloadTransformCache25_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/reloadCache")))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_reloadTransformCache25_invoker = createInvoker(
    TransformTaskApi_2.reloadTransformCache(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "reloadTransformCache",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/reloadCache""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_transform_TransformTaskApi_executeTransformTask26_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/executeTransform")))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_executeTransformTask26_invoker = createInvoker(
    TransformTaskApi_2.executeTransformTask(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "executeTransformTask",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/executeTransform""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_transform_PeakTransformApi_peak27_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/peak/"), DynamicPart("rule", """[^/]+""",true)))
  )
  private[this] lazy val controllers_transform_PeakTransformApi_peak27_invoker = createInvoker(
    PeakTransformApi_6.peak(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.PeakTransformApi",
      "peak",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/peak/""" + "$" + """rule<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_transform_PeakTransformApi_peakChildRule28_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/peak/"), DynamicPart("rule", """[^/]+""",true), StaticPart("/childRule")))
  )
  private[this] lazy val controllers_transform_PeakTransformApi_peakChildRule28_invoker = createInvoker(
    PeakTransformApi_6.peakChildRule(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.PeakTransformApi",
      "peakChildRule",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/peak/""" + "$" + """rule<[^/]+>/childRule""",
      """""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_transform_AutoCompletionApi_sourcePaths29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule/"), DynamicPart("rule", """[^/]+""",true), StaticPart("/completions/sourcePaths")))
  )
  private[this] lazy val controllers_transform_AutoCompletionApi_sourcePaths29_invoker = createInvoker(
    AutoCompletionApi_0.sourcePaths(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.AutoCompletionApi",
      "sourcePaths",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[Int]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/completions/sourcePaths""",
      """""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_transform_AutoCompletionApi_targetTypes30_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule/"), DynamicPart("rule", """[^/]+""",true), StaticPart("/completions/targetTypes")))
  )
  private[this] lazy val controllers_transform_AutoCompletionApi_targetTypes30_invoker = createInvoker(
    AutoCompletionApi_0.targetTypes(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.AutoCompletionApi",
      "targetTypes",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[Int]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/completions/targetTypes""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_transform_AutoCompletionApi_targetProperties31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule/"), DynamicPart("rule", """[^/]+""",true), StaticPart("/completions/targetProperties")))
  )
  private[this] lazy val controllers_transform_AutoCompletionApi_targetProperties31_invoker = createInvoker(
    AutoCompletionApi_0.targetProperties(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.AutoCompletionApi",
      "targetProperties",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[Int]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/completions/targetProperties""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_transform_TargetVocabularyApi_getTypeInfo32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/targetVocabulary/type")))
  )
  private[this] lazy val controllers_transform_TargetVocabularyApi_getTypeInfo32_invoker = createInvoker(
    TargetVocabularyApi_5.getTypeInfo(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TargetVocabularyApi",
      "getTypeInfo",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/targetVocabulary/type""",
      """""",
      Seq()
    )
  )

  // @LINE:46
  private[this] lazy val controllers_transform_TargetVocabularyApi_getPropertyInfo33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/targetVocabulary/property")))
  )
  private[this] lazy val controllers_transform_TargetVocabularyApi_getPropertyInfo33_invoker = createInvoker(
    TargetVocabularyApi_5.getPropertyInfo(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TargetVocabularyApi",
      "getPropertyInfo",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/targetVocabulary/property""",
      """""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_transform_TargetVocabularyApi_getTypeOrPropertyInfo34_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/targetVocabulary/typeOrProperty")))
  )
  private[this] lazy val controllers_transform_TargetVocabularyApi_getTypeOrPropertyInfo34_invoker = createInvoker(
    TargetVocabularyApi_5.getTypeOrPropertyInfo(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TargetVocabularyApi",
      "getTypeOrPropertyInfo",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/targetVocabulary/typeOrProperty""",
      """""",
      Seq()
    )
  )

  // @LINE:48
  private[this] lazy val controllers_transform_TargetVocabularyApi_propertiesByType35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/targetVocabulary/propertiesByClass")))
  )
  private[this] lazy val controllers_transform_TargetVocabularyApi_propertiesByType35_invoker = createInvoker(
    TargetVocabularyApi_5.propertiesByType(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TargetVocabularyApi",
      "propertiesByType",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/targetVocabulary/propertiesByClass""",
      """""",
      Seq()
    )
  )

  // @LINE:49
  private[this] lazy val controllers_transform_TargetVocabularyApi_relationsOfType36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/targetVocabulary/relationsOfClass")))
  )
  private[this] lazy val controllers_transform_TargetVocabularyApi_relationsOfType36_invoker = createInvoker(
    TargetVocabularyApi_5.relationsOfType(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TargetVocabularyApi",
      "relationsOfType",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/targetVocabulary/relationsOfClass""",
      """""",
      Seq()
    )
  )

  // @LINE:51
  private[this] lazy val controllers_transform_TransformTaskApi_postTransformInput37_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/transformInput")))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_postTransformInput37_invoker = createInvoker(
    TransformTaskApi_2.postTransformInput(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "postTransformInput",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/transformInput""",
      """""",
      Seq()
    )
  )

  // @LINE:52
  private[this] lazy val controllers_transform_TransformTaskApi_valueSourcePaths38_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule/"), DynamicPart("rule", """[^/]+""",true), StaticPart("/valueSourcePaths")))
  )
  private[this] lazy val controllers_transform_TransformTaskApi_valueSourcePaths38_invoker = createInvoker(
    TransformTaskApi_2.valueSourcePaths(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Int], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "transform",
      "controllers.transform.TransformTaskApi",
      "valueSourcePaths",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Int], classOf[Boolean]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule/""" + "$" + """rule<[^/]+>/valueSourcePaths""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_transform_TransformDialogs_transformationTaskDialog0_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), Param[Boolean]("createDialog", Right(true))) { (project, task, createDialog) =>
        controllers_transform_TransformDialogs_transformationTaskDialog0_invoker.call(TransformDialogs_1.transformationTaskDialog(project, task, createDialog))
      }
  
    // @LINE:3
    case controllers_transform_TransformDialogs_transformationTaskDialog1_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), Param[Boolean]("createDialog", Right(false))) { (project, task, createDialog) =>
        controllers_transform_TransformDialogs_transformationTaskDialog1_invoker.call(TransformDialogs_1.transformationTaskDialog(project, task, createDialog))
      }
  
    // @LINE:4
    case controllers_transform_TransformDialogs_deleteRuleDialog2_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_transform_TransformDialogs_deleteRuleDialog2_invoker.call(TransformDialogs_1.deleteRuleDialog(name))
      }
  
    // @LINE:7
    case controllers_transform_TransformEditor_start3_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), Param[String]("rule", Right(""))) { (project, task, rule) =>
        controllers_transform_TransformEditor_start3_invoker.call(TransformEditor_7.start(project, task, rule))
      }
  
    // @LINE:8
    case controllers_transform_TransformEditor_start4_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None)) { (project, task, rule) =>
        controllers_transform_TransformEditor_start4_invoker.call(TransformEditor_7.start(project, task, rule))
      }
  
    // @LINE:9
    case controllers_transform_TransformEditor_editor5_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None)) { (project, task, rule) =>
        controllers_transform_TransformEditor_editor5_invoker.call(TransformEditor_7.editor(project, task, rule))
      }
  
    // @LINE:10
    case controllers_transform_TransformEditor_propertyDetails6_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[String]("property", None)) { (project, task, property) =>
        controllers_transform_TransformEditor_propertyDetails6_invoker.call(TransformEditor_7.propertyDetails(project, task, property))
      }
  
    // @LINE:11
    case controllers_transform_TransformEditor_paths7_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_transform_TransformEditor_paths7_invoker.call(TransformEditor_7.paths(project, task))
      }
  
    // @LINE:12
    case controllers_transform_TransformEditor_rulePaths8_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None)) { (project, task, rule) =>
        controllers_transform_TransformEditor_rulePaths8_invoker.call(TransformEditor_7.rulePaths(project, task, rule))
      }
  
    // @LINE:13
    case controllers_transform_TransformEditor_score9_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_transform_TransformEditor_score9_invoker.call(TransformEditor_7.score(project, task))
      }
  
    // @LINE:16
    case controllers_transform_EvaluateTransform_evaluate10_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[Int]("offset", Some(0)), params.fromQuery[Int]("limit", Some(100))) { (project, task, offset, limit) =>
        controllers_transform_EvaluateTransform_evaluate10_invoker.call(EvaluateTransform_4.evaluate(project, task, offset, limit))
      }
  
    // @LINE:17
    case controllers_transform_EvaluateTransform_generatedEntities11_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[Int]("offset", Some(0)), params.fromQuery[Int]("limit", Some(100))) { (project, task, offset, limit) =>
        controllers_transform_EvaluateTransform_generatedEntities11_invoker.call(EvaluateTransform_4.generatedEntities(project, task, offset, limit))
      }
  
    // @LINE:20
    case controllers_transform_ExecuteTransformTab_execute12_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_transform_ExecuteTransformTab_execute12_invoker.call(ExecuteTransformTab_3.execute(project, task))
      }
  
    // @LINE:21
    case controllers_transform_ExecuteTransformTab_executionReport13_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_transform_ExecuteTransformTab_executionReport13_invoker.call(ExecuteTransformTab_3.executionReport(project, task))
      }
  
    // @LINE:24
    case controllers_transform_TransformTaskApi_getTransformTask14_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_transform_TransformTaskApi_getTransformTask14_invoker.call(TransformTaskApi_2.getTransformTask(project, task))
      }
  
    // @LINE:25
    case controllers_transform_TransformTaskApi_putTransformTask15_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), Param[Boolean]("createOnly", Right(false))) { (project, task, createOnly) =>
        controllers_transform_TransformTaskApi_putTransformTask15_invoker.call(TransformTaskApi_2.putTransformTask(project, task, createOnly))
      }
  
    // @LINE:26
    case controllers_transform_TransformTaskApi_deleteTransformTask16_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[Boolean]("removeDependentTasks", Some(false))) { (project, task, removeDependentTasks) =>
        controllers_transform_TransformTaskApi_deleteTransformTask16_invoker.call(TransformTaskApi_2.deleteTransformTask(project, task, removeDependentTasks))
      }
  
    // @LINE:27
    case controllers_transform_TransformTaskApi_getRules17_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_transform_TransformTaskApi_getRules17_invoker.call(TransformTaskApi_2.getRules(project, task))
      }
  
    // @LINE:28
    case controllers_transform_TransformTaskApi_putRules18_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_transform_TransformTaskApi_putRules18_invoker.call(TransformTaskApi_2.putRules(project, task))
      }
  
    // @LINE:29
    case controllers_transform_TransformTaskApi_getRule19_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None)) { (project, task, rule) =>
        controllers_transform_TransformTaskApi_getRule19_invoker.call(TransformTaskApi_2.getRule(project, task, rule))
      }
  
    // @LINE:30
    case controllers_transform_TransformTaskApi_putRule20_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None)) { (project, task, rule) =>
        controllers_transform_TransformTaskApi_putRule20_invoker.call(TransformTaskApi_2.putRule(project, task, rule))
      }
  
    // @LINE:31
    case controllers_transform_TransformTaskApi_deleteRule21_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None)) { (project, task, rule) =>
        controllers_transform_TransformTaskApi_deleteRule21_invoker.call(TransformTaskApi_2.deleteRule(project, task, rule))
      }
  
    // @LINE:32
    case controllers_transform_TransformTaskApi_appendRule22_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None), params.fromQuery[Option[String]]("afterRuleId", Some(None))) { (project, task, rule, afterRuleId) =>
        controllers_transform_TransformTaskApi_appendRule22_invoker.call(TransformTaskApi_2.appendRule(project, task, rule, afterRuleId))
      }
  
    // @LINE:33
    case controllers_transform_TransformTaskApi_copyRule23_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None), params.fromQuery[String]("sourceProject", None), params.fromQuery[String]("sourceTask", None), params.fromQuery[String]("sourceRule", None), params.fromQuery[Option[String]]("afterRuleId", Some(None))) { (project, task, rule, sourceProject, sourceTask, sourceRule, afterRuleId) =>
        controllers_transform_TransformTaskApi_copyRule23_invoker.call(TransformTaskApi_2.copyRule(project, task, rule, sourceProject, sourceTask, sourceRule, afterRuleId))
      }
  
    // @LINE:34
    case controllers_transform_TransformTaskApi_reorderRules24_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None)) { (project, task, rule) =>
        controllers_transform_TransformTaskApi_reorderRules24_invoker.call(TransformTaskApi_2.reorderRules(project, task, rule))
      }
  
    // @LINE:35
    case controllers_transform_TransformTaskApi_reloadTransformCache25_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_transform_TransformTaskApi_reloadTransformCache25_invoker.call(TransformTaskApi_2.reloadTransformCache(project, task))
      }
  
    // @LINE:36
    case controllers_transform_TransformTaskApi_executeTransformTask26_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_transform_TransformTaskApi_executeTransformTask26_invoker.call(TransformTaskApi_2.executeTransformTask(project, task))
      }
  
    // @LINE:38
    case controllers_transform_PeakTransformApi_peak27_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None)) { (project, task, rule) =>
        controllers_transform_PeakTransformApi_peak27_invoker.call(PeakTransformApi_6.peak(project, task, rule))
      }
  
    // @LINE:39
    case controllers_transform_PeakTransformApi_peakChildRule28_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None)) { (project, task, rule) =>
        controllers_transform_PeakTransformApi_peakChildRule28_invoker.call(PeakTransformApi_6.peakChildRule(project, task, rule))
      }
  
    // @LINE:41
    case controllers_transform_AutoCompletionApi_sourcePaths29_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None), params.fromQuery[String]("term", Some("")), params.fromQuery[Int]("maxResults", Some(30))) { (project, task, rule, term, maxResults) =>
        controllers_transform_AutoCompletionApi_sourcePaths29_invoker.call(AutoCompletionApi_0.sourcePaths(project, task, rule, term, maxResults))
      }
  
    // @LINE:42
    case controllers_transform_AutoCompletionApi_targetTypes30_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None), params.fromQuery[String]("term", Some("")), params.fromQuery[Int]("maxResults", Some(30))) { (project, task, rule, term, maxResults) =>
        controllers_transform_AutoCompletionApi_targetTypes30_invoker.call(AutoCompletionApi_0.targetTypes(project, task, rule, term, maxResults))
      }
  
    // @LINE:43
    case controllers_transform_AutoCompletionApi_targetProperties31_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None), params.fromQuery[String]("term", Some("")), params.fromQuery[Int]("maxResults", Some(30))) { (project, task, rule, term, maxResults) =>
        controllers_transform_AutoCompletionApi_targetProperties31_invoker.call(AutoCompletionApi_0.targetProperties(project, task, rule, term, maxResults))
      }
  
    // @LINE:45
    case controllers_transform_TargetVocabularyApi_getTypeInfo32_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[String]("uri", None)) { (project, task, uri) =>
        controllers_transform_TargetVocabularyApi_getTypeInfo32_invoker.call(TargetVocabularyApi_5.getTypeInfo(project, task, uri))
      }
  
    // @LINE:46
    case controllers_transform_TargetVocabularyApi_getPropertyInfo33_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[String]("uri", None)) { (project, task, uri) =>
        controllers_transform_TargetVocabularyApi_getPropertyInfo33_invoker.call(TargetVocabularyApi_5.getPropertyInfo(project, task, uri))
      }
  
    // @LINE:47
    case controllers_transform_TargetVocabularyApi_getTypeOrPropertyInfo34_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[String]("uri", None)) { (project, task, uri) =>
        controllers_transform_TargetVocabularyApi_getTypeOrPropertyInfo34_invoker.call(TargetVocabularyApi_5.getTypeOrPropertyInfo(project, task, uri))
      }
  
    // @LINE:48
    case controllers_transform_TargetVocabularyApi_propertiesByType35_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[String]("classUri", None)) { (project, task, classUri) =>
        controllers_transform_TargetVocabularyApi_propertiesByType35_invoker.call(TargetVocabularyApi_5.propertiesByType(project, task, classUri))
      }
  
    // @LINE:49
    case controllers_transform_TargetVocabularyApi_relationsOfType36_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[String]("classUri", None)) { (project, task, classUri) =>
        controllers_transform_TargetVocabularyApi_relationsOfType36_invoker.call(TargetVocabularyApi_5.relationsOfType(project, task, classUri))
      }
  
    // @LINE:51
    case controllers_transform_TransformTaskApi_postTransformInput37_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_transform_TransformTaskApi_postTransformInput37_invoker.call(TransformTaskApi_2.postTransformInput(project, task))
      }
  
    // @LINE:52
    case controllers_transform_TransformTaskApi_valueSourcePaths38_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("rule", None), params.fromQuery[Int]("maxDepth", Some(Int.MaxValue)), params.fromQuery[Boolean]("unusedOnly", Some(false))) { (project, task, rule, maxDepth, unusedOnly) =>
        controllers_transform_TransformTaskApi_valueSourcePaths38_invoker.call(TransformTaskApi_2.valueSourcePaths(project, task, rule, maxDepth, unusedOnly))
      }
  }
}
