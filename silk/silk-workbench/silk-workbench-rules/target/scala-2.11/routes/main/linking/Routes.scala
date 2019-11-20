// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/conf/linking.routes
// @DATE:Tue Jul 30 22:35:14 CEST 2019

package linking

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  LinkingDialogs_4: controllers.linking.LinkingDialogs,
  // @LINE:6
  LinkingEditor_3: controllers.linking.LinkingEditor,
  // @LINE:11
  EvaluateLinkingController_1: controllers.linking.EvaluateLinkingController,
  // @LINE:16
  ExecuteLinkingController_0: controllers.linking.ExecuteLinkingController,
  // @LINE:19
  ReferenceLinksManager_2: controllers.linking.ReferenceLinksManager,
  // @LINE:26
  Learning_6: controllers.linking.Learning,
  // @LINE:39
  LinkingTaskApi_5: controllers.linking.LinkingTaskApi,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    LinkingDialogs_4: controllers.linking.LinkingDialogs,
    // @LINE:6
    LinkingEditor_3: controllers.linking.LinkingEditor,
    // @LINE:11
    EvaluateLinkingController_1: controllers.linking.EvaluateLinkingController,
    // @LINE:16
    ExecuteLinkingController_0: controllers.linking.ExecuteLinkingController,
    // @LINE:19
    ReferenceLinksManager_2: controllers.linking.ReferenceLinksManager,
    // @LINE:26
    Learning_6: controllers.linking.Learning,
    // @LINE:39
    LinkingTaskApi_5: controllers.linking.LinkingTaskApi
  ) = this(errorHandler, LinkingDialogs_4, LinkingEditor_3, EvaluateLinkingController_1, ExecuteLinkingController_0, ReferenceLinksManager_2, Learning_6, LinkingTaskApi_5, "/")

  def withPrefix(prefix: String): Routes = {
    linking.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, LinkingDialogs_4, LinkingEditor_3, EvaluateLinkingController_1, ExecuteLinkingController_0, ReferenceLinksManager_2, Learning_6, LinkingTaskApi_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/newLinkingTask/""" + "$" + """project<[^/]+>""", """controllers.linking.LinkingDialogs.linkingTaskDialog(project:String, task:String = "", createDialog:Boolean = true)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dialogs/editLinkingTask/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.linking.LinkingDialogs.linkingTaskDialog(project:String, task:String, createDialog:Boolean = false)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor""", """controllers.linking.LinkingEditor.editor(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/widgets/paths""", """controllers.linking.LinkingEditor.paths(project:String, task:String, groupPaths:Boolean ?= true)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/widgets/score""", """controllers.linking.LinkingEditor.score(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/evaluate""", """controllers.linking.EvaluateLinkingController.generateLinks(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/evaluate/links/""" + "$" + """sorting<[^/]+>/""" + "$" + """filter<[^/]+>/""" + "$" + """page<[^/]+>""", """controllers.linking.EvaluateLinkingController.links(project:String, task:String, sorting:String, filter:String, page:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/evaluate/linksStream""", """controllers.linking.EvaluateLinkingController.linksWebsocket(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/execute""", """controllers.linking.ExecuteLinkingController.execute(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks""", """controllers.linking.ReferenceLinksManager.referenceLinksView(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks/addLinkDialog""", """controllers.linking.ReferenceLinksManager.addLinkDialog(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks/importDialog""", """controllers.linking.ReferenceLinksManager.importDialog(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks/removeLinksDialog""", """controllers.linking.ReferenceLinksManager.removeLinksDialog(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks/""" + "$" + """linkType<[^/]+>/""" + "$" + """sorting<[^/]+>/""" + "$" + """filter<[^/]+>/""" + "$" + """page<[^/]+>""", """controllers.linking.ReferenceLinksManager.referenceLinks(project:String, task:String, linkType:String, sorting:String, filter:String, page:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learnStart""", """controllers.linking.Learning.start(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learn""", """controllers.linking.Learning.learn(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearn""", """controllers.linking.Learning.activeLearn(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learn/rule""", """controllers.linking.Learning.rule(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learn/links/""" + "$" + """sorting<[^/]+>/""" + "$" + """filter<[^/]+>/""" + "$" + """page<[^/]+>""", """controllers.linking.Learning.links(project:String, task:String, sorting:String, filter:String, page:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learn/population""", """controllers.linking.Learning.population(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learn/populationView/""" + "$" + """page<[^/]+>""", """controllers.linking.Learning.populationView(project:String, task:String, page:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearnDetails""", """controllers.linking.Learning.activeLearnDetails(project:String, task:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearn/nextCandidate""", """controllers.linking.Learning.activeLearnCandidate(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearn/resetDialog""", """controllers.linking.Learning.resetActiveLearningDialog(project:String, task:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearn/reset""", """controllers.linking.Learning.resetActiveLearning(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.linking.LinkingTaskApi.getLinkingTask(project:String, task:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.linking.LinkingTaskApi.pushLinkingTask(project:String, task:String, createOnly:Boolean = true)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.linking.LinkingTaskApi.pushLinkingTask(project:String, task:String, createOnly:Boolean = false)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""", """controllers.linking.LinkingTaskApi.deleteLinkingTask(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule""", """controllers.linking.LinkingTaskApi.getRule(project:String, task:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule""", """controllers.linking.LinkingTaskApi.putRule(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/linkSpec""", """controllers.linking.LinkingTaskApi.getLinkSpec(project:String, task:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/linkSpec""", """controllers.linking.LinkingTaskApi.putLinkSpec(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks""", """controllers.linking.LinkingTaskApi.getReferenceLinks(project:String, task:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks""", """controllers.linking.LinkingTaskApi.putReferenceLinks(project:String, task:String, generateNegative:Boolean)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks""", """controllers.linking.LinkingTaskApi.deleteReferenceLinks(project:String, task:String, positive:Boolean, negative:Boolean, unlabeled:Boolean)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLink""", """controllers.linking.LinkingTaskApi.putReferenceLink(project:String, task:String, linkType:String, source:String, target:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLink""", """controllers.linking.LinkingTaskApi.deleteReferenceLink(project:String, task:String, source:String, target:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/reloadCache""", """controllers.linking.LinkingTaskApi.reloadLinkingCache(project:String, task:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/writeReferenceLinks""", """controllers.linking.LinkingTaskApi.writeReferenceLinks(project:String, task:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learningTask""", """controllers.linking.LinkingTaskApi.learningActivity(project:String, task:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearningTask""", """controllers.linking.LinkingTaskApi.activeLearningActivity(project:String, task:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinksEvaluated""", """controllers.linking.LinkingTaskApi.referenceLinksEvaluated(project:String, task:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/postLinkDatasource""", """controllers.linking.LinkingTaskApi.postLinkDatasource(project:String, task:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_linking_LinkingDialogs_linkingTaskDialog0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/newLinkingTask/"), DynamicPart("project", """[^/]+""",true)))
  )
  private[this] lazy val controllers_linking_LinkingDialogs_linkingTaskDialog0_invoker = createInvoker(
    LinkingDialogs_4.linkingTaskDialog(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingDialogs",
      "linkingTaskDialog",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """dialogs/newLinkingTask/""" + "$" + """project<[^/]+>""",
      """ Dialogs""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_linking_LinkingDialogs_linkingTaskDialog1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dialogs/editLinkingTask/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_linking_LinkingDialogs_linkingTaskDialog1_invoker = createInvoker(
    LinkingDialogs_4.linkingTaskDialog(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingDialogs",
      "linkingTaskDialog",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """dialogs/editLinkingTask/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_linking_LinkingEditor_editor2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/editor")))
  )
  private[this] lazy val controllers_linking_LinkingEditor_editor2_invoker = createInvoker(
    LinkingEditor_3.editor(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingEditor",
      "editor",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor""",
      """ Linkage Rule Editor""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_linking_LinkingEditor_paths3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/editor/widgets/paths")))
  )
  private[this] lazy val controllers_linking_LinkingEditor_paths3_invoker = createInvoker(
    LinkingEditor_3.paths(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingEditor",
      "paths",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/widgets/paths""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_linking_LinkingEditor_score4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/editor/widgets/score")))
  )
  private[this] lazy val controllers_linking_LinkingEditor_score4_invoker = createInvoker(
    LinkingEditor_3.score(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingEditor",
      "score",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/editor/widgets/score""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_linking_EvaluateLinkingController_generateLinks5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/evaluate")))
  )
  private[this] lazy val controllers_linking_EvaluateLinkingController_generateLinks5_invoker = createInvoker(
    EvaluateLinkingController_1.generateLinks(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.EvaluateLinkingController",
      "generateLinks",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/evaluate""",
      """ Evaluate""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_linking_EvaluateLinkingController_links6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/evaluate/links/"), DynamicPart("sorting", """[^/]+""",true), StaticPart("/"), DynamicPart("filter", """[^/]+""",true), StaticPart("/"), DynamicPart("page", """[^/]+""",true)))
  )
  private[this] lazy val controllers_linking_EvaluateLinkingController_links6_invoker = createInvoker(
    EvaluateLinkingController_1.links(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.EvaluateLinkingController",
      "links",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[Int]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/evaluate/links/""" + "$" + """sorting<[^/]+>/""" + "$" + """filter<[^/]+>/""" + "$" + """page<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_linking_EvaluateLinkingController_linksWebsocket7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/evaluate/linksStream")))
  )
  private[this] lazy val controllers_linking_EvaluateLinkingController_linksWebsocket7_invoker = createInvoker(
    EvaluateLinkingController_1.linksWebsocket(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.EvaluateLinkingController",
      "linksWebsocket",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/evaluate/linksStream""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_linking_ExecuteLinkingController_execute8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/execute")))
  )
  private[this] lazy val controllers_linking_ExecuteLinkingController_execute8_invoker = createInvoker(
    ExecuteLinkingController_0.execute(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.ExecuteLinkingController",
      "execute",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/execute""",
      """ Execute""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_linking_ReferenceLinksManager_referenceLinksView9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/referenceLinks")))
  )
  private[this] lazy val controllers_linking_ReferenceLinksManager_referenceLinksView9_invoker = createInvoker(
    ReferenceLinksManager_2.referenceLinksView(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.ReferenceLinksManager",
      "referenceLinksView",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks""",
      """ Reference Links""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_linking_ReferenceLinksManager_addLinkDialog10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/referenceLinks/addLinkDialog")))
  )
  private[this] lazy val controllers_linking_ReferenceLinksManager_addLinkDialog10_invoker = createInvoker(
    ReferenceLinksManager_2.addLinkDialog(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.ReferenceLinksManager",
      "addLinkDialog",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks/addLinkDialog""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_linking_ReferenceLinksManager_importDialog11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/referenceLinks/importDialog")))
  )
  private[this] lazy val controllers_linking_ReferenceLinksManager_importDialog11_invoker = createInvoker(
    ReferenceLinksManager_2.importDialog(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.ReferenceLinksManager",
      "importDialog",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks/importDialog""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_linking_ReferenceLinksManager_removeLinksDialog12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/referenceLinks/removeLinksDialog")))
  )
  private[this] lazy val controllers_linking_ReferenceLinksManager_removeLinksDialog12_invoker = createInvoker(
    ReferenceLinksManager_2.removeLinksDialog(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.ReferenceLinksManager",
      "removeLinksDialog",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks/removeLinksDialog""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_linking_ReferenceLinksManager_referenceLinks13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/referenceLinks/"), DynamicPart("linkType", """[^/]+""",true), StaticPart("/"), DynamicPart("sorting", """[^/]+""",true), StaticPart("/"), DynamicPart("filter", """[^/]+""",true), StaticPart("/"), DynamicPart("page", """[^/]+""",true)))
  )
  private[this] lazy val controllers_linking_ReferenceLinksManager_referenceLinks13_invoker = createInvoker(
    ReferenceLinksManager_2.referenceLinks(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.ReferenceLinksManager",
      "referenceLinks",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[Int]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks/""" + "$" + """linkType<[^/]+>/""" + "$" + """sorting<[^/]+>/""" + "$" + """filter<[^/]+>/""" + "$" + """page<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_linking_Learning_start14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/learnStart")))
  )
  private[this] lazy val controllers_linking_Learning_start14_invoker = createInvoker(
    Learning_6.start(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.Learning",
      "start",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learnStart""",
      """ Learn""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_linking_Learning_learn15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/learn")))
  )
  private[this] lazy val controllers_linking_Learning_learn15_invoker = createInvoker(
    Learning_6.learn(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.Learning",
      "learn",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learn""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_linking_Learning_activeLearn16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activeLearn")))
  )
  private[this] lazy val controllers_linking_Learning_activeLearn16_invoker = createInvoker(
    Learning_6.activeLearn(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.Learning",
      "activeLearn",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearn""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_linking_Learning_rule17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/learn/rule")))
  )
  private[this] lazy val controllers_linking_Learning_rule17_invoker = createInvoker(
    Learning_6.rule(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.Learning",
      "rule",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learn/rule""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_linking_Learning_links18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/learn/links/"), DynamicPart("sorting", """[^/]+""",true), StaticPart("/"), DynamicPart("filter", """[^/]+""",true), StaticPart("/"), DynamicPart("page", """[^/]+""",true)))
  )
  private[this] lazy val controllers_linking_Learning_links18_invoker = createInvoker(
    Learning_6.links(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.Learning",
      "links",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[Int]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learn/links/""" + "$" + """sorting<[^/]+>/""" + "$" + """filter<[^/]+>/""" + "$" + """page<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_linking_Learning_population19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/learn/population")))
  )
  private[this] lazy val controllers_linking_Learning_population19_invoker = createInvoker(
    Learning_6.population(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.Learning",
      "population",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learn/population""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_linking_Learning_populationView20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/learn/populationView/"), DynamicPart("page", """[^/]+""",true)))
  )
  private[this] lazy val controllers_linking_Learning_populationView20_invoker = createInvoker(
    Learning_6.populationView(fakeValue[String], fakeValue[String], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.Learning",
      "populationView",
      Seq(classOf[String], classOf[String], classOf[Int]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learn/populationView/""" + "$" + """page<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_linking_Learning_activeLearnDetails21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activeLearnDetails")))
  )
  private[this] lazy val controllers_linking_Learning_activeLearnDetails21_invoker = createInvoker(
    Learning_6.activeLearnDetails(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.Learning",
      "activeLearnDetails",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearnDetails""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_linking_Learning_activeLearnCandidate22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activeLearn/nextCandidate")))
  )
  private[this] lazy val controllers_linking_Learning_activeLearnCandidate22_invoker = createInvoker(
    Learning_6.activeLearnCandidate(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.Learning",
      "activeLearnCandidate",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearn/nextCandidate""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_linking_Learning_resetActiveLearningDialog23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activeLearn/resetDialog")))
  )
  private[this] lazy val controllers_linking_Learning_resetActiveLearningDialog23_invoker = createInvoker(
    Learning_6.resetActiveLearningDialog(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.Learning",
      "resetActiveLearningDialog",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearn/resetDialog""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_linking_Learning_resetActiveLearning24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activeLearn/reset")))
  )
  private[this] lazy val controllers_linking_Learning_resetActiveLearning24_invoker = createInvoker(
    Learning_6.resetActiveLearning(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.Learning",
      "resetActiveLearning",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearn/reset""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_linking_LinkingTaskApi_getLinkingTask25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_getLinkingTask25_invoker = createInvoker(
    LinkingTaskApi_5.getLinkingTask(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "getLinkingTask",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """ API""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_linking_LinkingTaskApi_pushLinkingTask26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_pushLinkingTask26_invoker = createInvoker(
    LinkingTaskApi_5.pushLinkingTask(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "pushLinkingTask",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "POST",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_linking_LinkingTaskApi_pushLinkingTask27_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_pushLinkingTask27_invoker = createInvoker(
    LinkingTaskApi_5.pushLinkingTask(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "pushLinkingTask",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_linking_LinkingTaskApi_deleteLinkingTask28_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true)))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_deleteLinkingTask28_invoker = createInvoker(
    LinkingTaskApi_5.deleteLinkingTask(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "deleteLinkingTask",
      Seq(classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_linking_LinkingTaskApi_getRule29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_getRule29_invoker = createInvoker(
    LinkingTaskApi_5.getRule(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "getRule",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule""",
      """""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val controllers_linking_LinkingTaskApi_putRule30_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/rule")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_putRule30_invoker = createInvoker(
    LinkingTaskApi_5.putRule(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "putRule",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/rule""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_linking_LinkingTaskApi_getLinkSpec31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/linkSpec")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_getLinkSpec31_invoker = createInvoker(
    LinkingTaskApi_5.getLinkSpec(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "getLinkSpec",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/linkSpec""",
      """""",
      Seq()
    )
  )

  // @LINE:46
  private[this] lazy val controllers_linking_LinkingTaskApi_putLinkSpec32_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/linkSpec")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_putLinkSpec32_invoker = createInvoker(
    LinkingTaskApi_5.putLinkSpec(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "putLinkSpec",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/linkSpec""",
      """""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_linking_LinkingTaskApi_getReferenceLinks33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/referenceLinks")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_getReferenceLinks33_invoker = createInvoker(
    LinkingTaskApi_5.getReferenceLinks(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "getReferenceLinks",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks""",
      """""",
      Seq()
    )
  )

  // @LINE:48
  private[this] lazy val controllers_linking_LinkingTaskApi_putReferenceLinks34_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/referenceLinks")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_putReferenceLinks34_invoker = createInvoker(
    LinkingTaskApi_5.putReferenceLinks(fakeValue[String], fakeValue[String], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "putReferenceLinks",
      Seq(classOf[String], classOf[String], classOf[Boolean]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks""",
      """""",
      Seq()
    )
  )

  // @LINE:49
  private[this] lazy val controllers_linking_LinkingTaskApi_deleteReferenceLinks35_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/referenceLinks")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_deleteReferenceLinks35_invoker = createInvoker(
    LinkingTaskApi_5.deleteReferenceLinks(fakeValue[String], fakeValue[String], fakeValue[Boolean], fakeValue[Boolean], fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "deleteReferenceLinks",
      Seq(classOf[String], classOf[String], classOf[Boolean], classOf[Boolean], classOf[Boolean]),
      "DELETE",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinks""",
      """""",
      Seq()
    )
  )

  // @LINE:50
  private[this] lazy val controllers_linking_LinkingTaskApi_putReferenceLink36_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/referenceLink")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_putReferenceLink36_invoker = createInvoker(
    LinkingTaskApi_5.putReferenceLink(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "putReferenceLink",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLink""",
      """""",
      Seq()
    )
  )

  // @LINE:51
  private[this] lazy val controllers_linking_LinkingTaskApi_deleteReferenceLink37_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/referenceLink")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_deleteReferenceLink37_invoker = createInvoker(
    LinkingTaskApi_5.deleteReferenceLink(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "deleteReferenceLink",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLink""",
      """""",
      Seq()
    )
  )

  // @LINE:53
  private[this] lazy val controllers_linking_LinkingTaskApi_reloadLinkingCache38_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/reloadCache")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_reloadLinkingCache38_invoker = createInvoker(
    LinkingTaskApi_5.reloadLinkingCache(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "reloadLinkingCache",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/reloadCache""",
      """""",
      Seq()
    )
  )

  // @LINE:54
  private[this] lazy val controllers_linking_LinkingTaskApi_writeReferenceLinks39_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/writeReferenceLinks")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_writeReferenceLinks39_invoker = createInvoker(
    LinkingTaskApi_5.writeReferenceLinks(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "writeReferenceLinks",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/writeReferenceLinks""",
      """""",
      Seq()
    )
  )

  // @LINE:55
  private[this] lazy val controllers_linking_LinkingTaskApi_learningActivity40_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/learningTask")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_learningActivity40_invoker = createInvoker(
    LinkingTaskApi_5.learningActivity(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "learningActivity",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/learningTask""",
      """""",
      Seq()
    )
  )

  // @LINE:56
  private[this] lazy val controllers_linking_LinkingTaskApi_activeLearningActivity41_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/activeLearningTask")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_activeLearningActivity41_invoker = createInvoker(
    LinkingTaskApi_5.activeLearningActivity(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "activeLearningActivity",
      Seq(classOf[String], classOf[String]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/activeLearningTask""",
      """""",
      Seq()
    )
  )

  // @LINE:58
  private[this] lazy val controllers_linking_LinkingTaskApi_referenceLinksEvaluated42_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/referenceLinksEvaluated")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_referenceLinksEvaluated42_invoker = createInvoker(
    LinkingTaskApi_5.referenceLinksEvaluated(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "referenceLinksEvaluated",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/referenceLinksEvaluated""",
      """""",
      Seq()
    )
  )

  // @LINE:60
  private[this] lazy val controllers_linking_LinkingTaskApi_postLinkDatasource43_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("task", """[^/]+""",true), StaticPart("/postLinkDatasource")))
  )
  private[this] lazy val controllers_linking_LinkingTaskApi_postLinkDatasource43_invoker = createInvoker(
    LinkingTaskApi_5.postLinkDatasource(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "linking",
      "controllers.linking.LinkingTaskApi",
      "postLinkDatasource",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """tasks/""" + "$" + """project<[^/]+>/""" + "$" + """task<[^/]+>/postLinkDatasource""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_linking_LinkingDialogs_linkingTaskDialog0_route(params@_) =>
      call(params.fromPath[String]("project", None), Param[String]("task", Right("")), Param[Boolean]("createDialog", Right(true))) { (project, task, createDialog) =>
        controllers_linking_LinkingDialogs_linkingTaskDialog0_invoker.call(LinkingDialogs_4.linkingTaskDialog(project, task, createDialog))
      }
  
    // @LINE:3
    case controllers_linking_LinkingDialogs_linkingTaskDialog1_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), Param[Boolean]("createDialog", Right(false))) { (project, task, createDialog) =>
        controllers_linking_LinkingDialogs_linkingTaskDialog1_invoker.call(LinkingDialogs_4.linkingTaskDialog(project, task, createDialog))
      }
  
    // @LINE:6
    case controllers_linking_LinkingEditor_editor2_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingEditor_editor2_invoker.call(LinkingEditor_3.editor(project, task))
      }
  
    // @LINE:7
    case controllers_linking_LinkingEditor_paths3_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[Boolean]("groupPaths", Some(true))) { (project, task, groupPaths) =>
        controllers_linking_LinkingEditor_paths3_invoker.call(LinkingEditor_3.paths(project, task, groupPaths))
      }
  
    // @LINE:8
    case controllers_linking_LinkingEditor_score4_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingEditor_score4_invoker.call(LinkingEditor_3.score(project, task))
      }
  
    // @LINE:11
    case controllers_linking_EvaluateLinkingController_generateLinks5_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_EvaluateLinkingController_generateLinks5_invoker.call(EvaluateLinkingController_1.generateLinks(project, task))
      }
  
    // @LINE:12
    case controllers_linking_EvaluateLinkingController_links6_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("sorting", None), params.fromPath[String]("filter", None), params.fromPath[Int]("page", None)) { (project, task, sorting, filter, page) =>
        controllers_linking_EvaluateLinkingController_links6_invoker.call(EvaluateLinkingController_1.links(project, task, sorting, filter, page))
      }
  
    // @LINE:13
    case controllers_linking_EvaluateLinkingController_linksWebsocket7_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_EvaluateLinkingController_linksWebsocket7_invoker.call(EvaluateLinkingController_1.linksWebsocket(project, task))
      }
  
    // @LINE:16
    case controllers_linking_ExecuteLinkingController_execute8_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_ExecuteLinkingController_execute8_invoker.call(ExecuteLinkingController_0.execute(project, task))
      }
  
    // @LINE:19
    case controllers_linking_ReferenceLinksManager_referenceLinksView9_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_ReferenceLinksManager_referenceLinksView9_invoker.call(ReferenceLinksManager_2.referenceLinksView(project, task))
      }
  
    // @LINE:20
    case controllers_linking_ReferenceLinksManager_addLinkDialog10_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_ReferenceLinksManager_addLinkDialog10_invoker.call(ReferenceLinksManager_2.addLinkDialog(project, task))
      }
  
    // @LINE:21
    case controllers_linking_ReferenceLinksManager_importDialog11_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_ReferenceLinksManager_importDialog11_invoker.call(ReferenceLinksManager_2.importDialog(project, task))
      }
  
    // @LINE:22
    case controllers_linking_ReferenceLinksManager_removeLinksDialog12_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_ReferenceLinksManager_removeLinksDialog12_invoker.call(ReferenceLinksManager_2.removeLinksDialog(project, task))
      }
  
    // @LINE:23
    case controllers_linking_ReferenceLinksManager_referenceLinks13_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("linkType", None), params.fromPath[String]("sorting", None), params.fromPath[String]("filter", None), params.fromPath[Int]("page", None)) { (project, task, linkType, sorting, filter, page) =>
        controllers_linking_ReferenceLinksManager_referenceLinks13_invoker.call(ReferenceLinksManager_2.referenceLinks(project, task, linkType, sorting, filter, page))
      }
  
    // @LINE:26
    case controllers_linking_Learning_start14_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_Learning_start14_invoker.call(Learning_6.start(project, task))
      }
  
    // @LINE:27
    case controllers_linking_Learning_learn15_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_Learning_learn15_invoker.call(Learning_6.learn(project, task))
      }
  
    // @LINE:28
    case controllers_linking_Learning_activeLearn16_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_Learning_activeLearn16_invoker.call(Learning_6.activeLearn(project, task))
      }
  
    // @LINE:29
    case controllers_linking_Learning_rule17_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_Learning_rule17_invoker.call(Learning_6.rule(project, task))
      }
  
    // @LINE:30
    case controllers_linking_Learning_links18_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[String]("sorting", None), params.fromPath[String]("filter", None), params.fromPath[Int]("page", None)) { (project, task, sorting, filter, page) =>
        controllers_linking_Learning_links18_invoker.call(Learning_6.links(project, task, sorting, filter, page))
      }
  
    // @LINE:31
    case controllers_linking_Learning_population19_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_Learning_population19_invoker.call(Learning_6.population(project, task))
      }
  
    // @LINE:32
    case controllers_linking_Learning_populationView20_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromPath[Int]("page", None)) { (project, task, page) =>
        controllers_linking_Learning_populationView20_invoker.call(Learning_6.populationView(project, task, page))
      }
  
    // @LINE:33
    case controllers_linking_Learning_activeLearnDetails21_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_Learning_activeLearnDetails21_invoker.call(Learning_6.activeLearnDetails(project, task))
      }
  
    // @LINE:34
    case controllers_linking_Learning_activeLearnCandidate22_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_Learning_activeLearnCandidate22_invoker.call(Learning_6.activeLearnCandidate(project, task))
      }
  
    // @LINE:35
    case controllers_linking_Learning_resetActiveLearningDialog23_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_Learning_resetActiveLearningDialog23_invoker.call(Learning_6.resetActiveLearningDialog(project, task))
      }
  
    // @LINE:36
    case controllers_linking_Learning_resetActiveLearning24_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_Learning_resetActiveLearning24_invoker.call(Learning_6.resetActiveLearning(project, task))
      }
  
    // @LINE:39
    case controllers_linking_LinkingTaskApi_getLinkingTask25_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_getLinkingTask25_invoker.call(LinkingTaskApi_5.getLinkingTask(project, task))
      }
  
    // @LINE:40
    case controllers_linking_LinkingTaskApi_pushLinkingTask26_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), Param[Boolean]("createOnly", Right(true))) { (project, task, createOnly) =>
        controllers_linking_LinkingTaskApi_pushLinkingTask26_invoker.call(LinkingTaskApi_5.pushLinkingTask(project, task, createOnly))
      }
  
    // @LINE:41
    case controllers_linking_LinkingTaskApi_pushLinkingTask27_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), Param[Boolean]("createOnly", Right(false))) { (project, task, createOnly) =>
        controllers_linking_LinkingTaskApi_pushLinkingTask27_invoker.call(LinkingTaskApi_5.pushLinkingTask(project, task, createOnly))
      }
  
    // @LINE:42
    case controllers_linking_LinkingTaskApi_deleteLinkingTask28_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_deleteLinkingTask28_invoker.call(LinkingTaskApi_5.deleteLinkingTask(project, task))
      }
  
    // @LINE:43
    case controllers_linking_LinkingTaskApi_getRule29_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_getRule29_invoker.call(LinkingTaskApi_5.getRule(project, task))
      }
  
    // @LINE:44
    case controllers_linking_LinkingTaskApi_putRule30_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_putRule30_invoker.call(LinkingTaskApi_5.putRule(project, task))
      }
  
    // @LINE:45
    case controllers_linking_LinkingTaskApi_getLinkSpec31_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_getLinkSpec31_invoker.call(LinkingTaskApi_5.getLinkSpec(project, task))
      }
  
    // @LINE:46
    case controllers_linking_LinkingTaskApi_putLinkSpec32_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_putLinkSpec32_invoker.call(LinkingTaskApi_5.putLinkSpec(project, task))
      }
  
    // @LINE:47
    case controllers_linking_LinkingTaskApi_getReferenceLinks33_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_getReferenceLinks33_invoker.call(LinkingTaskApi_5.getReferenceLinks(project, task))
      }
  
    // @LINE:48
    case controllers_linking_LinkingTaskApi_putReferenceLinks34_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[Boolean]("generateNegative", None)) { (project, task, generateNegative) =>
        controllers_linking_LinkingTaskApi_putReferenceLinks34_invoker.call(LinkingTaskApi_5.putReferenceLinks(project, task, generateNegative))
      }
  
    // @LINE:49
    case controllers_linking_LinkingTaskApi_deleteReferenceLinks35_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[Boolean]("positive", None), params.fromQuery[Boolean]("negative", None), params.fromQuery[Boolean]("unlabeled", None)) { (project, task, positive, negative, unlabeled) =>
        controllers_linking_LinkingTaskApi_deleteReferenceLinks35_invoker.call(LinkingTaskApi_5.deleteReferenceLinks(project, task, positive, negative, unlabeled))
      }
  
    // @LINE:50
    case controllers_linking_LinkingTaskApi_putReferenceLink36_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[String]("linkType", None), params.fromQuery[String]("source", None), params.fromQuery[String]("target", None)) { (project, task, linkType, source, target) =>
        controllers_linking_LinkingTaskApi_putReferenceLink36_invoker.call(LinkingTaskApi_5.putReferenceLink(project, task, linkType, source, target))
      }
  
    // @LINE:51
    case controllers_linking_LinkingTaskApi_deleteReferenceLink37_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None), params.fromQuery[String]("source", None), params.fromQuery[String]("target", None)) { (project, task, source, target) =>
        controllers_linking_LinkingTaskApi_deleteReferenceLink37_invoker.call(LinkingTaskApi_5.deleteReferenceLink(project, task, source, target))
      }
  
    // @LINE:53
    case controllers_linking_LinkingTaskApi_reloadLinkingCache38_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_reloadLinkingCache38_invoker.call(LinkingTaskApi_5.reloadLinkingCache(project, task))
      }
  
    // @LINE:54
    case controllers_linking_LinkingTaskApi_writeReferenceLinks39_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_writeReferenceLinks39_invoker.call(LinkingTaskApi_5.writeReferenceLinks(project, task))
      }
  
    // @LINE:55
    case controllers_linking_LinkingTaskApi_learningActivity40_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_learningActivity40_invoker.call(LinkingTaskApi_5.learningActivity(project, task))
      }
  
    // @LINE:56
    case controllers_linking_LinkingTaskApi_activeLearningActivity41_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_activeLearningActivity41_invoker.call(LinkingTaskApi_5.activeLearningActivity(project, task))
      }
  
    // @LINE:58
    case controllers_linking_LinkingTaskApi_referenceLinksEvaluated42_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_referenceLinksEvaluated42_invoker.call(LinkingTaskApi_5.referenceLinksEvaluated(project, task))
      }
  
    // @LINE:60
    case controllers_linking_LinkingTaskApi_postLinkDatasource43_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("task", None)) { (project, task) =>
        controllers_linking_LinkingTaskApi_postLinkDatasource43_invoker.call(LinkingTaskApi_5.postLinkDatasource(project, task))
      }
  }
}
