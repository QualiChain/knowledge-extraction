package controllers.transform

import java.util.logging.{Level, Logger}

import controllers.core.{RequestUserContextAction, UserContextAction}
import controllers.util.ProjectUtils._
import controllers.util.SerializationUtils._
import javax.inject.Inject
import org.silkframework.config.{MetaData, Prefixes, Task}
import org.silkframework.dataset._
import org.silkframework.entity._
import org.silkframework.rule._
import org.silkframework.rule.execution.ExecuteTransform
import org.silkframework.runtime.activity.{Activity, UserContext}
import org.silkframework.runtime.resource.ResourceManager
import org.silkframework.runtime.serialization.ReadContext
import org.silkframework.runtime.validation.{BadUserInputException, NotFoundException, ValidationError, ValidationException}
import org.silkframework.serialization.json.JsonParseException
import org.silkframework.serialization.json.JsonSerializers._
import org.silkframework.util.{Identifier, IdentifierGenerator, Uri}
import org.silkframework.workbench.utils.{ErrorResult, UnsupportedMediaTypeException}
import org.silkframework.workspace.activity.transform.TransformPathsCache
import org.silkframework.workspace.{Project, ProjectTask, WorkspaceFactory}
import play.api.libs.json._
import play.api.mvc._
import TransformTaskApi._
import org.silkframework.entity.paths.{TypedPath, UntypedPath}

class TransformTaskApi @Inject() () extends InjectedController {

  private val log = Logger.getLogger(getClass.getName)

  def getTransformTask(projectName: String, taskName: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    implicit val (project, task) = getProjectAndTask[TransformSpec](projectName, taskName)
    implicit val prefixes: Prefixes = project.config.prefixes

    serializeCompileTime[TransformTask](task, Some(project))
  }

  def putTransformTask(projectName: String, taskName: String, createOnly: Boolean): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    val project = getProject(projectName)
    implicit val prefixes: Prefixes = project.config.prefixes
    implicit val readContext: ReadContext = ReadContext()

    request.body match {
      case AnyContentAsFormUrlEncoded(v) =>
        val values = request.body.asFormUrlEncoded.getOrElse(Map.empty).mapValues(_.mkString)
        val input = DatasetSelection(values("source"), Uri.parse(values.getOrElse("sourceType", ""), prefixes),
          Restriction.custom(values.getOrElse("restriction", "")))
        val outputs = values.get("output").filter(_.nonEmpty).map(Identifier(_)).toSeq
        val targetVocabularies = values.get("targetVocabularies").toSeq.flatMap(_.split(",")).map(_.trim).filter(_.nonEmpty)

        project.tasks[TransformSpec].find(_.id.toString == taskName) match {
          //Update existing task
          case Some(oldTask) if !createOnly =>
            val updatedTransformSpec = oldTask.data.copy(selection = input, outputs = outputs, targetVocabularies = targetVocabularies)
            project.updateTask(taskName, updatedTransformSpec)
          //Create new task with no rule
          case _ =>
            val rule = RootMappingRule(rules = MappingRules.empty)
            val transformSpec = TransformSpec(input, rule, outputs, Seq.empty, targetVocabularies)
            project.addTask(taskName, transformSpec, MetaData(MetaData.labelFromId(taskName)))
        }

        Ok
      case _ =>
        catchExceptions {
          deserializeCompileTime[TransformTask]() { task =>
            project.updateTask(task.id, task.data, Some(task.metaData))
            Ok
          }
        }
    }
  }

  def deleteTransformTask(projectName: String, taskName: String, removeDependentTasks: Boolean): Action[AnyContent] = UserContextAction { implicit userContext =>
    val project = getProject(projectName)
    project.removeAnyTask(taskName, removeDependentTasks)

    Ok
  }

  def getRules(projectName: String, taskName: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    implicit val (project, task) = getProjectAndTask[TransformSpec](projectName, taskName)
    implicit val prefixes: Prefixes = project.config.prefixes

    serializeCompileTime(task.data.mappingRule, Some(project))
  }

  def putRules(projectName: String, taskName: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    implicit val (project, task) = getProjectAndTask[TransformSpec](projectName, taskName)
    implicit val prefixes: Prefixes = project.config.prefixes
    implicit val resources: ResourceManager = project.resources
    implicit val readContext: ReadContext = ReadContext(resources, prefixes)

    catchExceptions {
      task.synchronized {
        deserializeCompileTime[RootMappingRule]() { updatedRules =>
          //Update transformation task
          val updatedTask = task.data.copy(mappingRule = updatedRules)
          project.updateTask(taskName, updatedTask)
          Ok
        }
      }
    }
  }

  def getRule(projectName: String, taskName: String, ruleId: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    implicit val (project, task) = getProjectAndTask[TransformSpec](projectName, taskName)
    implicit val prefixes: Prefixes = project.config.prefixes

    processRule(task, ruleId) { rule =>
      serializeCompileTime(rule.operator.asInstanceOf[TransformRule], Some(project))
    }
  }

  def putRule(projectName: String, taskName: String, ruleId: String): Action[AnyContent] = RequestUserContextAction { request => implicit userContext =>
    implicit val (project, task) = getProjectAndTask[TransformSpec](projectName, taskName)
    implicit val prefixes: Prefixes = project.config.prefixes
    implicit val resources: ResourceManager = project.resources
    implicit val readContext: ReadContext = ReadContext(resources, prefixes, identifierGenerator(task))

    task.synchronized {
      processRule(task, ruleId) { currentRule =>
        implicit val updatedRequest: Request[AnyContent] = updateJsonRequest(request, currentRule)
        deserializeCompileTime[TransformRule]() { updatedRule =>
          updateRule(currentRule.update(updatedRule))
          serializeCompileTime[TransformRule](updatedRule, Some(project))
        }
      }
    }
  }

  def deleteRule(projectName: String, taskName: String, rule: String): Action[AnyContent] = UserContextAction { implicit userContext =>
    implicit val (project, task) = getProjectAndTask[TransformSpec](projectName, taskName)
    implicit val prefixes: Prefixes = project.config.prefixes

    try {
      task.synchronized {
        val updatedTree = RuleTraverser(task.data.mappingRule).remove(rule)
        task.update(task.data.copy(mappingRule = updatedTree.operator.asInstanceOf[RootMappingRule]))
        Ok
      }
    } catch {
      case ex: NoSuchElementException =>
        ErrorResult(NotFoundException(ex))
    }
  }

  /**
    * Adds the rule provided in the request to the children of the specified transform task mapping rule.
    *
    * @param taskName    Transform task where the mapping rule should be added.
    * @param ruleName    The parent rule ID that the new rule should be added to as a child.
    * @param afterRuleId If specified then the new rule is added right after this rule. If not specified the new rule
    *                    is appended to the end of the list.
    * @return The newly created rule.
    */
  def appendRule(projectName: String,
                 taskName: String,
                 ruleName: String,
                 afterRuleId: Option[String] = None): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    implicit val (project, task) = getProjectAndTask[TransformSpec](projectName, taskName)
    implicit val prefixes: Prefixes = project.config.prefixes
    task.synchronized {
      implicit val readContext: ReadContext = ReadContext(project.resources, project.config.prefixes, identifierGenerator(task))
      processRule(task, ruleName) { parentRule =>
        deserializeCompileTime[TransformRule]() { newChildRule =>
          addRuleToTransformTask(parentRule, newChildRule, afterRuleId)
        }
      }
    }
  }

  private def addRuleToTransformTask(parentRule: RuleTraverser,
                                     newChildRule: TransformRule,
                                     afterRuleId: Option[String])
                                    (implicit request: Request[AnyContent],
                                     task: ProjectTask[TransformSpec],
                                     userContext: UserContext,
                                     project: Project): Result = {
    if (task.data.nestedRuleAndSourcePath(newChildRule.id).isDefined) {
      throw new ValidationException(s"Rule with ID ${newChildRule.id} already exists!")
    }
    val children = parentRule.operator.children
    val newChildren = children.indexWhere(rule => afterRuleId.contains(rule.id.toString)) match {
      case afterRuleIdx: Int if afterRuleIdx >= 0 =>
        val (before, after) = children.splitAt(afterRuleIdx + 1)
        (before :+ newChildRule) ++ after // insert after specified rule
      case -1 => // append
        children :+ newChildRule
    }
    val updatedRule = parentRule.operator.withChildren(newChildren)
    updateRule(parentRule.update(updatedRule))
    serializeCompileTime(newChildRule, Some(project))
  }

  private def assignNewIdsAndLabelToRule(task: ProjectTask[TransformSpec],
                                 ruleToCopy: RuleTraverser): TransformRule = {
    implicit val idGenerator: IdentifierGenerator = identifierGenerator(task)
    ruleToCopy.operator match {
      case t: TransformRule =>
        val originalLabel = if(t.metaData.label.trim != "") t.metaData.label else t.target.map(_.propertyUri.toString).getOrElse("unlabeled")
        val newLabel = "Copy of " + originalLabel
        val transformRuleCopy = assignNewIdsToRule(t)
        transformRuleCopy.withMetaData(t.metaData.copy(label = newLabel))
      case other: Operator => throw new RuntimeException("Selected operator was not transform rule. Operator ID: " + other.id)
    }
  }

  private def assignNewIdsToRule(t: TransformRule)
                                (implicit idGenerator: IdentifierGenerator): TransformRule = {
    t match {
      case r: RootMappingRule =>
        val updatedMappingRules = assignNewIdsToMappingRules(r.rules)
        r.copy(id = idGenerator.generate(r.id), rules = updatedMappingRules)
      case c: ComplexMapping => c.copy(id = idGenerator.generate(c.id))
      case c: ComplexUriMapping => c.copy(id = idGenerator.generate(c.id))
      case d: DirectMapping => d.copy(id = idGenerator.generate(d.id))
      case o: ObjectMapping =>
        val updatedMappingRules = assignNewIdsToMappingRules(o.rules)
        o.copy(id = idGenerator.generate(o.id), rules = updatedMappingRules)
      case typeMapping: TypeMapping => assignNewIdsToRule(typeMapping)
      case uriMapping: UriMapping => assignNewIdsToRule(uriMapping)
    }
  }

  private def assignNewIdsToMappingRules(mappingRules: MappingRules)
                                        (implicit identifierGenerator: IdentifierGenerator): MappingRules = {
    mappingRules.copy(
      uriRule = mappingRules.uriRule.map(assignNewIdsToRule),
      typeRules = mappingRules.typeRules.map(assignNewIdsToRule),
      propertyRules = mappingRules.propertyRules.map(assignNewIdsToRule)
    )
  }

  private def assignNewIdsToRule(typeMapping: TypeMapping)
                                (implicit idGenerator: IdentifierGenerator): TypeMapping = {
    typeMapping.copy(id = idGenerator.generate(typeMapping.id))
  }

  private def assignNewIdsToRule(uriMapping: UriMapping)
                                (implicit idGenerator: IdentifierGenerator): UriMapping = {
    uriMapping match {
      case c: ComplexUriMapping =>
        c.copy(id = idGenerator.generate(c.id))
      case p: PatternUriMapping =>
        p.copy(id = idGenerator.generate(p.id))
    }
  }

  /** Converts a root mapping rule to an object mapping rule. */
  private def convertRootMappingRule(rule: TransformRule): TransformRule = {
    rule match {
      case RootMappingRule(rules, id, metaData) =>
        ObjectMapping(id, rules = rules, metaData = metaData, target = Some(MappingTarget(ROOT_COPY_TARGET_PROPERTY, UriValueType)))
      case other: TransformRule =>
        other
    }
  }

  /**
    * Copies a mapping rule from a source transform task to a target transform task.
    *
    * @param projectName   The target project where the rule is copied to.
    * @param taskName      The target transform task the rule is copied to.
    * @param ruleName      The target rule where the copied rule should be added as child.
    * @param sourceProject The project the source rule is copied from.
    * @param sourceTask    The source task the source rule is copied from.
    * @param sourceRule    The ID of the source rule that should be copied.
    * @param afterRuleId   An optional rule ID of one of the children of the parent rule after which the new rule should be
    *                      added.
    * @return The newly added rule.
    */
  def copyRule(projectName: String,
               taskName: String,
               ruleName: String,
               sourceProject: String,
               sourceTask: String,
               sourceRule: String,
               afterRuleId: Option[String] = None): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    implicit val (project, task) = getProjectAndTask[TransformSpec](projectName, taskName)
    val (_, fromTask) = getProjectAndTask[TransformSpec](sourceProject, sourceTask)
    implicit val prefixes: Prefixes = project.config.prefixes
    task.synchronized {
      implicit val readContext: ReadContext = ReadContext(project.resources, project.config.prefixes, identifierGenerator(task))
      processRule(fromTask, sourceRule) { ruleToCopy =>
        processRule(task, ruleName) { parentRule =>
          val newChildRule = convertRootMappingRule(assignNewIdsAndLabelToRule(task, ruleToCopy))
          addRuleToTransformTask(parentRule, newChildRule, afterRuleId)
        }
      }
    }
  }

  def reorderRules(projectName: String, taskName: String, ruleName: String): Action[AnyContent] = RequestUserContextAction { request => implicit userContext =>
    implicit val (project, task) = getProjectAndTask[TransformSpec](projectName, taskName)
    implicit val prefixes: Prefixes = project.config.prefixes

    task.synchronized {
      processRule(task, ruleName) { parentRule =>
        request.body.asJson match {
          case Some(json) =>
            val currentRules = parentRule.operator.asInstanceOf[TransformRule].rules
            val currentOrder = currentRules.propertyRules.map(_.id.toString).toList
            val newOrder = json.as[JsArray].value.map(_.as[JsString].value).toList
            if (newOrder.toSet == currentOrder.toSet) {
              val newPropertyRules =
                for (id <- newOrder) yield {
                  parentRule.operator.children.find(_.id == id).get
                }
              val newRules = currentRules.uriRule.toSeq ++ currentRules.typeRules ++ newPropertyRules
              updateRule(parentRule.update(parentRule.operator.withChildren(newRules)))
              Ok(JsArray(newPropertyRules.map(r => JsString(r.id))))
            } else {
              ErrorResult(BadUserInputException(s"Provided list $newOrder does not contain the same elements as current list $currentOrder."))
            }
          case None =>
            ErrorResult(UnsupportedMediaTypeException.supportedFormats("application/json."))
        }
      }
    }
  }

  /**
    * Processes a rule a catches relevant exceptions
    */
  private def processRule(task: Task[TransformSpec], ruleId: String)(processFunc: RuleTraverser => Result): Result = {
    RuleTraverser(task.data.mappingRule).find(ruleId) match {
      case Some(rule) =>
        catchExceptions(processFunc(rule))
      case None =>
        ErrorResult(NotFoundException(s"No rule with id '$ruleId' found!"))
    }
  }

  /**
    * Catches relevant exceptions and returns appropriate error codes.
    */
  private def catchExceptions(func: => Result): Result = {
    try {
      func
    } catch {
      case ex: BadUserInputException =>
        log.log(Level.FINE, "Invalid transformation rule", ex)
        ErrorResult.validation(BAD_REQUEST, ex.getMessage, ValidationError(ex.getMessage) :: Nil)
      case ex: ValidationException =>
        log.log(Level.INFO, "Invalid transformation rule", ex)
        ErrorResult.validation(BAD_REQUEST, "Invalid transformation rule", ex.errors)
      case ex: JsonParseException =>
        log.log(Level.INFO, "Invalid transformation rule JSON", ex)
        ErrorResult(BadUserInputException(ex))
      case ex: Exception =>
        log.log(Level.WARNING, "Failed process mapping rule", ex)
        ErrorResult.validation(INTERNAL_SERVER_ERROR, "Failed to process mapping rule", ValidationError("Error in back end: " + ex.getMessage) :: Nil)
    }
  }

  private def identifierGenerator(transformTask: Task[TransformSpec]): IdentifierGenerator = {
    TransformSpec.identifierGenerator(transformTask.data)
  }

  private def updateJsonRequest(request: Request[AnyContent], rule: RuleTraverser): Request[AnyContent] = {
    request.body.asJson match {
      case Some(requestJson) =>
        val ruleJson = toJson(rule.operator.asInstanceOf[TransformRule]).as[JsObject]
        val updatedJson = ruleJson.deepMerge(requestJson.as[JsObject])
        request.map(_ => AnyContentAsJson(updatedJson))
      case None => request
    }
  }

  private def updateRule(ruleTraverser: RuleTraverser)
                        (implicit task: ProjectTask[TransformSpec],
                         userContext: UserContext): Unit = {
    val updatedRoot = ruleTraverser.root.operator.asInstanceOf[RootMappingRule]
    val updatedTask = task.data.copy(mappingRule = updatedRoot)
    task.project.updateTask(task.id, updatedTask)
  }

  def reloadTransformCache(projectName: String, taskName: String): Action[AnyContent] = UserContextAction { implicit userContext =>
    val project = WorkspaceFactory().workspace.project(projectName)
    val task = project.task[TransformSpec](taskName)
    task.activity[TransformPathsCache].control.reset()
    task.activity[TransformPathsCache].control.start()
    Ok
  }

  def executeTransformTask(projectName: String, taskName: String): Action[AnyContent] = UserContextAction { implicit userContext =>
    val project = WorkspaceFactory().workspace.project(projectName)
    val task = project.task[TransformSpec](taskName)
    val activity = task.activity[ExecuteTransform].control
    activity.start()
    Ok
  }

  /**
    * Transform entities bundled with the request according to the transformation task.
    *
    * @return If no sink is specified in the request then return results in N-Triples format with the response,
    *         else write triples to defined data sink.
    */
  def postTransformInput(projectName: String, taskName: String): Action[AnyContent] = RequestUserContextAction { request => implicit userContext =>
    val (_, task) = projectAndTask(projectName, taskName)
    request.body match {
      case AnyContentAsXml(xmlRoot) =>
        implicit val (resourceManager, _) = createInMemoryResourceManagerForResources(xmlRoot, projectName, withProjectResources = true)
        val dataSource = createDataSource(xmlRoot, None)
        val (model, entitySink) = createEntitySink(xmlRoot)
        executeTransform(task, entitySink, dataSource, errorEntitySinkOpt = None)
        val acceptedContentType = request.acceptedTypes.headOption.map(_.toString()).getOrElse("application/n-triples")
        result(model, acceptedContentType, "Data transformed successfully!")
      case _ =>
        throw UnsupportedMediaTypeException.supportedFormats("application/xml")
    }
  }

  private def executeTransform(task: ProjectTask[TransformSpec],
                               entitySink: EntitySink,
                               dataSource: DataSource,
                               errorEntitySinkOpt: Option[EntitySink])
                              (implicit userContext: UserContext): Unit = {
    val transform = new ExecuteTransform(task.taskLabel(), (_) => dataSource, task.data, (_) => entitySink)
    Activity(transform).startBlocking()
  }

  private def projectAndTask(projectName: String, taskName: String)
                            (implicit userContext: UserContext): (Project, ProjectTask[TransformSpec]) = {
    getProjectAndTask[TransformSpec](projectName, taskName)
  }

  def valueSourcePaths(projectName: String,
                       taskName: String,
                       ruleId: String,
                       maxDepth: Int,
                       unusedOnly: Boolean): Action[AnyContent] = UserContextAction { implicit userContext =>
    implicit val (project, task) = getProjectAndTask[TransformSpec](projectName, taskName)
    implicit val prefixes: Prefixes = project.config.prefixes

    task.nestedRuleAndSourcePath(ruleId) match {
      case Some((_, sourcePath)) =>
        val pathCache = task.activity[TransformPathsCache]
        pathCache.control.waitUntilFinished()
        val cachedPaths = pathCache.value().fetchCachedPaths(task, sourcePath)
        val isRdfInput = pathCache.value().isRdfInput(task)
        val matchingPaths = cachedPaths filter { p =>
          val pathSize = p.operators.size
          isRdfInput ||
              p.operators.startsWith(sourcePath) &&
                  pathSize > sourcePath.size &&
                  pathSize - sourcePath.size <= maxDepth
        } map { p =>
            if(isRdfInput) {
              p
            } else {
              TypedPath.removePathPrefix(p, UntypedPath(sourcePath))
            }
        }
        val filteredPaths = if(unusedOnly) {
          val sourcePaths = task.data.valueSourcePaths(ruleId, maxDepth)
          matchingPaths.filterNot { path =>
            sourcePaths.contains(path.asUntypedPath)
          }
        } else {
          matchingPaths
        }
        Ok(Json.toJson(filteredPaths.map(_.toUntypedPath.serialize())))
      case None =>
        NotFound("No rule found with ID " + ruleId)
    }
  }
}

object TransformTaskApi {

  // The property that is set when copying a root mapping rule that will be converted into an object mapping rule
  final val ROOT_COPY_TARGET_PROPERTY = "urn:temp:child"
}

// Peak API
case class PeakResults(sourcePaths: Option[Seq[Seq[String]]], results: Option[Seq[PeakResult]], status: PeakStatus)

case class PeakStatus(id: String, msg: String)

case class PeakResult(sourceValues: Seq[Seq[String]], transformedValues: Seq[String])