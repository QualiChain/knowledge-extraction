package controllers.workspace

import controllers.core.util.ControllerUtilsTrait
import controllers.core.{RequestUserContextAction, UserContextAction}
import controllers.util.SerializationUtils._
import javax.inject.Inject
import org.silkframework.config.{PlainTask, Prefixes}
import org.silkframework.dataset.DatasetSpec.GenericDatasetSpec
import org.silkframework.dataset._
import org.silkframework.dataset.rdf.{RdfDataset, SparqlResults}
import org.silkframework.entity.EntitySchema
import org.silkframework.entity.paths.UntypedPath
import org.silkframework.rule.TransformSpec
import org.silkframework.runtime.activity.UserContext
import org.silkframework.runtime.resource.ResourceManager
import org.silkframework.runtime.serialization.ReadContext
import org.silkframework.runtime.validation.BadUserInputException
import org.silkframework.util.Uri
import org.silkframework.workbench.Context
import org.silkframework.workbench.utils.ErrorResult
import org.silkframework.workspace.activity.dataset.TypesCache
import org.silkframework.workspace.{Project, WorkspaceFactory}
import play.api.libs.json._
import play.api.mvc._

class DatasetApi @Inject() () extends InjectedController with ControllerUtilsTrait {

  private implicit val partialPath = Json.format[PathCoverage]
  private implicit val valueCoverageMissFormat = Json.format[ValueCoverageMiss]
  private implicit val valueCoverageResultFormat = Json.format[ValueCoverageResult]

  def getDataset(projectName: String, sourceName: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    val project = WorkspaceFactory().workspace.project(projectName)
    val task = project.task[GenericDatasetSpec](sourceName)
    serializeCompileTime[DatasetTask](task, Some(project))
  }

  def getDatasetAutoConfigured(projectName: String, sourceName: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    implicit val project: Project = WorkspaceFactory().workspace.project(projectName)
    val task = project.task[GenericDatasetSpec](sourceName)
    val datasetPlugin = task.data.plugin
    datasetPlugin match {
      case autoConfigurable: DatasetPluginAutoConfigurable[_] =>
        val autoConfDataset = autoConfigurable.autoConfigured
        serializeCompileTime[DatasetTask](PlainTask(task.id, DatasetSpec(autoConfDataset)), Some(project))
      case _ =>
        ErrorResult(BadUserInputException("This dataset type does not support auto-configuration."))
    }
  }

  def putDataset(projectName: String, datasetName: String, autoConfigure: Boolean): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    val project = WorkspaceFactory().workspace.project(projectName)
    implicit val readContext: ReadContext = ReadContext(project.resources, project.config.prefixes)

    try {
      deserializeCompileTime() { dataset: DatasetTask =>
        if (autoConfigure) {
          dataset.plugin match {
            case autoConfigurable: DatasetPluginAutoConfigurable[_] =>
              project.updateTask(dataset.id, dataset.data.copy(plugin = autoConfigurable.autoConfigured))
              NoContent
            case _ =>
              ErrorResult(BadUserInputException("This dataset type does not support auto-configuration."))
          }
        } else {
          project.updateTask(dataset.id, dataset.data, Some(dataset.metaData))
          NoContent
        }
      }
    } catch {
      case ex: Exception =>
        ErrorResult(BadUserInputException(ex))
    }
  }

  def deleteDataset(project: String, source: String): Action[AnyContent] = UserContextAction { implicit userContext =>
    WorkspaceFactory().workspace.project(project).removeTask[GenericDatasetSpec](source)
    NoContent
  }

  def datasetDialog(projectName: String,
                    datasetName: String,
                    title: String = "Edit Dataset",
                    createDialog: Boolean): Action[AnyContent] = UserContextAction { implicit userContext =>
    val project = WorkspaceFactory().workspace.project(projectName)
    val datasetPlugin = if (datasetName.isEmpty) None else project.taskOption[GenericDatasetSpec](datasetName).map(_.data)
    Ok(views.html.workspace.dataset.datasetDialog(project, datasetName, datasetPlugin, title, createDialog))
  }

  def datasetDialogAutoConfigured(projectName: String, datasetName: String, pluginId: String): Action[AnyContent] = RequestUserContextAction { request => implicit userContext =>
    val project = WorkspaceFactory().workspace.project(projectName)
    val createDialog = project.taskOption[DatasetSpec[Dataset]](datasetName).isEmpty
    val dialogTitle = if(createDialog) "Create Dataset" else "Edit Dataset"
    implicit val prefixes: Prefixes = project.config.prefixes
    implicit val resources: ResourceManager = project.resources
    val datasetParams = request.queryString.mapValues(_.head)
    val datasetPlugin = Dataset.apply(pluginId, datasetParams)
    datasetPlugin match {
      case ds: DatasetPluginAutoConfigurable[_] =>
        Ok(views.html.workspace.dataset.datasetDialog(project, datasetName, Some(DatasetSpec(ds.autoConfigured)), title = dialogTitle, createDialog = createDialog))
      case _ =>
        ErrorResult(BadUserInputException("This dataset type does not support auto-configuration."))
    }
  }

  def dataset(project: String, task: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    val context = Context.get[GenericDatasetSpec](project, task, request.path)
    Ok(views.html.workspace.dataset.dataset(context))
  }

  def table(project: String, task: String, maxEntities: Int): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    val context = Context.get[GenericDatasetSpec](project, task, request.path)
    val source = context.task.data.source

    val firstTypes = source.retrieveTypes().head._1
    val paths = source.retrievePaths(firstTypes).toIndexedSeq
    val entityDesc = EntitySchema(firstTypes, paths)
    val entities = source.retrieve(entityDesc).take(maxEntities).toList

    Ok(views.html.workspace.dataset.table(context, paths.map(_.toUntypedPath), entities))
  }

  def sparql(project: String, task: String, query: String = ""): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    val context = Context.get[GenericDatasetSpec](project, task, request.path)

    context.task.data.plugin match {
      case rdf: RdfDataset =>
        val sparqlEndpoint = rdf.sparqlEndpoint
        var queryResults: Option[SparqlResults] = None
        if (!query.isEmpty) {
          queryResults = Some(sparqlEndpoint.select(query))
        }
        Ok(views.html.workspace.dataset.sparql(context, sparqlEndpoint, query, queryResults))
      case _ =>
        ErrorResult(BadUserInputException("This is not an RDF-Dataset."))
    }
  }

  /** Get types of a dataset including the search string */
  def types(project: String, task: String, search: String = ""): Action[AnyContent] = RequestUserContextAction { request => implicit userContext =>
    val context = Context.get[GenericDatasetSpec](project, task, request.path)
    implicit val prefixes: Prefixes = context.project.config.prefixes

    val typesFull = context.task.activity[TypesCache].value().types
    val typesResolved = typesFull.map(t => new Uri(t).serialize)
    val filteredTypes = typesResolved.filter(_.contains(search))

    Ok(JsArray(filteredTypes.map(JsString)))
  }

  /** Get all types of the dataset */
  def getDatasetTypes(project: String, task: String): Action[AnyContent] = RequestUserContextAction { request => implicit userContext =>
    val context = Context.get[GenericDatasetSpec](project, task, request.path)
    val types = context.task.activity[TypesCache].value().types

    Ok(JsArray(types.map(JsString)))
  }

  def getMappingValueCoverage(projectName: String,
                              datasetId: String): Action[JsValue] = RequestUserContextAction(parse.json) { implicit request => implicit userContext =>
    validateJson[MappingValueCoverageRequest] { mappingCoverageRequest =>
      val project = WorkspaceFactory().workspace.project(projectName)
      val datasetTask = project.task[GenericDatasetSpec](datasetId)
      val inputPaths = transformationInputPaths(project)
      val dataSourcePath = UntypedPath.parse(mappingCoverageRequest.dataSourcePath)
      datasetTask.plugin.source match {
        case vd: PathCoverageDataSource with ValueCoverageDataSource =>
          val matchingInputPaths = for (coveragePathInput <- inputPaths;
               inputPath <- coveragePathInput.paths
               if vd.matchPath(coveragePathInput.typeUri, inputPath, dataSourcePath)) yield {
            vd.combinedPath(coveragePathInput.typeUri, inputPath)
          }
          val result = vd.valueCoverage(dataSourcePath, matchingInputPaths)
          Ok(Json.toJson(result))
        case _ =>
          ErrorResult(
            status = INTERNAL_SERVER_ERROR,
            title = "Mapping coverage not supported",
            detail = "The type of data source '" + datasetTask.id.toString + "' does not support mapping value coverage."
          )
      }
    }
  }

  private val FULLY_MAPPED = "fullyMapped"
  private val PARTIALLY_MAPPED = "partiallyMapped"
  private val UNMAPPED = "unmapped"

  private val coverageTypeValues = Seq(FULLY_MAPPED, PARTIALLY_MAPPED, UNMAPPED)

  def getMappingCoverage(projectName: String, datasetId: String): Action[AnyContent] = RequestUserContextAction { request => implicit userContext =>
    val filterPaths = coveragePathFilterFn(request)

    try {
      val project = WorkspaceFactory().workspace.project(projectName)
      implicit val prefixes: Prefixes = project.config.prefixes
      val datasetTask = project.task[GenericDatasetSpec](datasetId)
      datasetTask.plugin.source match {
        case cd: PathCoverageDataSource =>
          getCoverageFromCoverageSource(filterPaths, project, cd)
        case _ =>
          ErrorResult(
            status = INTERNAL_SERVER_ERROR,
            title = "Mapping coverage not supported",
            detail = "The type of data source '" + datasetTask.id.toString + "' does not support mapping value coverage."
          )
      }
    } catch {
      case e: IllegalArgumentException =>
        BadRequest(e.getMessage)
    }
  }

  private def getCoverageFromCoverageSource(filterPaths: PathCoverageResult => Seq[PathCoverage],
                                            project: Project,
                                            cd: PathCoverageDataSource)
                                           (implicit prefixes: Prefixes,
                                            userContext: UserContext) = {
    val inputPaths = transformationInputPaths(project)
    val result = cd.pathCoverage(inputPaths.toSeq)
    val filteredPaths = filterPaths(result)
    Ok(Json.toJson(filteredPaths))
  }

  private def transformationInputPaths(project: Project)
                                      (implicit userContext: UserContext): Traversable[CoveragePathInput] = {
    val transformationTasks = project.tasks[TransformSpec]
    for (transformation <- transformationTasks) yield {
      val typeUri = transformation.selection.typeUri
      // TODO: Filter by mapping type, e.g. no URI mapping?
      val paths = transformation.rules.flatMap(_.sourcePaths).distinct
      CoveragePathInput(typeUri.uri, paths.map(_.toUntypedPath))
    }
  }

  /** Filters out paths based on the requested filters. */
  private def coveragePathFilterFn(request: Request[AnyContent]): PathCoverageResult => Seq[PathCoverage] = {
    val (mapped, partialMapped, unmapped) = coverageTypes(request)

    val filteredPaths: PathCoverageResult => Seq[PathCoverage] = result => {
      result.paths.filter(p =>
        p.covered && p.fully && mapped // fully mapped
            ||
            !p.covered && unmapped // unmapped
            ||
            p.covered && partialMapped // partial mapped
      )
    }
    filteredPaths
  }

  private def coverageTypes(request: Request[AnyContent]) = {
    request.getQueryString("type") match {
      case Some(typeString) =>
        val types = typeString.split(",")
        if (types.exists(!coverageTypeValues.contains(_))) {
          throw new IllegalArgumentException("Invalid coverage types. Allowed types: " + coverageTypeValues.mkString(", "))
        } else {
          (types.contains(FULLY_MAPPED), types.contains(PARTIALLY_MAPPED), types.contains(UNMAPPED))
        }
      case None =>
        (true, true, true)
    }
  }
}

case class MappingValueCoverageRequest(dataSourcePath: String)

object MappingValueCoverageRequest {
  implicit val mappingValueCoverageRequestReads: Format[MappingValueCoverageRequest] = Json.format[MappingValueCoverageRequest]
}