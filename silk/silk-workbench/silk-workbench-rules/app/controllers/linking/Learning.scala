package controllers.linking

import java.util.logging.Logger

import akka.stream.Materializer
import controllers.core.{RequestUserContextAction, UserContextAction}
import javax.inject.Inject
import models.learning.{PathValue, PathValues}
import models.linking.EvalLink.{Correct, Generated, Incorrect, Unknown}
import models.linking._
import org.silkframework.entity.Link
import org.silkframework.entity.paths.{Path, TypedPath, UntypedPath}
import org.silkframework.learning.LearningActivity
import org.silkframework.learning.active.ActiveLearning
import org.silkframework.learning.individual.Population
import org.silkframework.rule.evaluation.ReferenceLinks
import org.silkframework.rule.input.PathInput
import org.silkframework.rule.similarity.Comparison
import org.silkframework.rule.{LinkSpec, LinkageRule, RuleTraverser}
import org.silkframework.runtime.activity.UserContext
import org.silkframework.runtime.validation.BadUserInputException
import org.silkframework.util.Identifier._
import org.silkframework.workbench.Context
import org.silkframework.workbench.utils.ErrorResult
import org.silkframework.workspace.activity.linking.ReferenceEntitiesCache
import org.silkframework.workspace.{ProjectTask, WorkspaceFactory}
import play.api.mvc.{Action, AnyContent, InjectedController}

class Learning @Inject() (implicit mat: Materializer) extends InjectedController {

  private val log = Logger.getLogger(getClass.getName)

  def start(project: String, task: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    val context = Context.get[LinkSpec](project, task, request.path)
    Ok(views.html.learning.start(context))
  }

  def learn(project: String, task: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    val context = Context.get[LinkSpec](project, task, request.path)
    Ok(views.html.learning.learn(context))
  }

  def activeLearn(project: String, task: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    val context = Context.get[LinkSpec](project, task, request.path)
    Ok(views.html.learning.activeLearn(context))
  }

  def activeLearnDetails(project: String, task: String): Action[AnyContent] = RequestUserContextAction { request => implicit userContext =>
    val context = Context.get[LinkSpec](project, task, request.path)
    val activeLearnState = context.task.activity[ActiveLearning].value()
    Ok(views.html.learning.activeLearnDetails(activeLearnState, context.project.config.prefixes))
  }

  def activeLearnCandidate(project: String, task: String): Action[AnyContent] = RequestUserContextAction { request => implicit userContext =>
    val context = Context.get[LinkSpec](project, task, request.path)
    val prefixes = context.project.config.prefixes
    val activeLearn = context.task.activity[ActiveLearning].control

    /**
      * Collects all paths of a single linkage rule.
      */
    def collectPaths(rule: LinkageRule, sourceOrTarget: Boolean): Iterator[Path] = {
      val comparisons = RuleTraverser(rule.operator.get).iterateAllChildren.filter(_.operator.isInstanceOf[Comparison])
      val inputs = comparisons.map(c => if (sourceOrTarget) c.iterateChildren.next() else c.iterateChildren.drop(1).next())
      val paths = inputs.flatMap(_.iterateAllChildren.map(_.operator)).collect { case PathInput(_, path) => path }
      paths
    }

    /**
      * Collects paths of all linkage rules in the population, sorted by frequency
      */
    def sortedPaths(sourceOrTarget: Boolean): Seq[TypedPath] = {
      val rules = activeLearn.value().population.individuals.map(_.node.build)
      val allSourcePaths = rules.map(rule => collectPaths(rule, sourceOrTarget))
      val schemaPaths = activeLearn.value().pool.entityDescs.select(sourceOrTarget).typedPaths
      val sortedSchemaPaths = schemaPaths.sortBy(p => allSourcePaths.count(_ == p))
      sortedSchemaPaths
    }

    def values(link: Link)(sourceOrTarget: Boolean) = {
      val paths = sortedPaths(sourceOrTarget)
      for(path <- paths) yield (path.toUntypedPath.serialize()(prefixes), link.entities.get.select(sourceOrTarget).evaluate(path))
    }

    request.body.asFormUrlEncoded match {
      case Some(p) =>
        val params = p.mapValues(_.head)
        val nextLinkCandidate = nextActiveLearnCandidate(params("decision"), params("source"), params("target"), context)
        nextLinkCandidate match {
          case Some(link) =>
            // Generate all source values for this link
            val sourceValues =
              for((sourcePath, sourceValues) <- values(link)(sourceOrTarget = true)) yield {
                PathValues(sourcePath, sourceValues.map(PathValue(_)))
              }
            // Generate all target values for this link
            val targetValues =
              for((targetPath, targetValues) <- values(link)(sourceOrTarget = false)) yield {
                PathValues(targetPath, targetValues.map(PathValue(_)))
              }
            // Find matching values for highlighting
            var currentIndex = 1
            for(sourcePath <- sourceValues;
                sourceValue <- sourcePath.values;
                targetPath <- targetValues;
                targetValue <- targetPath.values) {
              if(sourceValue.value == targetValue.value && currentIndex <= 5) {
                // Check if this value already got an index
                sourceValues.flatMap(_.values).find(_.value == sourceValue.value).flatMap(_.similarityClass) match {
                  case Some(index) =>
                    sourceValue.similarityClass = Some(index)
                    targetValue.similarityClass = Some(index)
                  case None if currentIndex <= 5 =>
                    sourceValue.similarityClass = Some(currentIndex)
                    targetValue.similarityClass = Some(currentIndex)
                    currentIndex += 1
                  case None =>
                }
              }
            }

            Ok(views.html.learning.linkCandidate(link, sourceValues, targetValues, context))
          case None =>
            Ok("No link candidate generated, please wait for completion or restart...")
        }
      case None =>
        ErrorResult(BadUserInputException("query parameters missing"))
    }
  }

  /**
    * Iterates the active learning and selects the next link candidate
    *
    * @param decision The decision for the link candidate. One of [[LinkCandidateDecision]].
    * @param linkSource source URI of the current link candidate
    * @param linkTarget target URI of the current link candidate
    */
  private def nextActiveLearnCandidate(decision: String, linkSource: String, linkTarget: String, context: Context[LinkSpec])
                                      (implicit userContext: UserContext): Option[Link] = {
    val activeLearn = context.task.activity[ActiveLearning].control
    // Try to find the chosen link candidate in the pool, because the pool links have entities attached
    val linkCandidate = activeLearn.value().pool.links.find(l => l.source == linkSource && l.target == linkTarget) match {
      case Some(l) => l
      case None => new Link(linkSource, linkTarget)
    }

    // Commit link candidate
    decision match {
      case LinkCandidateDecision.positive =>
        context.task.update(context.task.data.copy(referenceLinks = context.task.data.referenceLinks.withPositive(linkCandidate)))
      case LinkCandidateDecision.negative =>
        context.task.update(context.task.data.copy(referenceLinks = context.task.data.referenceLinks.withNegative(linkCandidate)))
      case LinkCandidateDecision.pass =>
    }

    // Assert that a learning task is running
    val finished = !activeLearn.status().isRunning
    if(finished)
      activeLearn.start()

    // Pick the next link candidate
    val links = activeLearn.value().links

    // Update unlabeled reference links
    if(context.task.data.referenceLinks.unlabeled.isEmpty) {
      val updatedReferenceLinks = context.task.data.referenceLinks.copy(unlabeled = activeLearn.value().pool.links.toSet)
      context.task.update(context.task.data.copy(referenceLinks = updatedReferenceLinks))
    }

    if(links.isEmpty) {
      log.info("Selecting link candidate: No previous candidates available, waiting until learning task is finished.")
      activeLearn.waitUntilFinished()
      activeLearn.value().links.headOption
    } else if(finished) {
      log.info("Selecting link candidate: A learning task finished, thus selecting its top link candidate (if it hasn't been selected just before).")
      links.find(_ != linkCandidate)
    } else if(links.last == linkCandidate) {
      log.info("Selecting link candidate: No remaining link candidates in current learning task, waiting for the next task to finish.")
      activeLearn.waitUntilFinished()
      activeLearn.value().links.headOption
    } else {
      val currentIndex = links.indexOf(linkCandidate)
      log.info(s"Selecting link candidate: Learning task still running, thus selecting next candidate with index ${currentIndex + 1} from list.")
      Some(links(currentIndex + 1))
    }
  }

  /**
    * Renders the top linkage rule in the current population.
    */
  def rule(projectName: String, taskName: String): Action[AnyContent] = RequestUserContextAction { request => implicit userContext =>
    val context = Context.get[LinkSpec](projectName, taskName, request.path)
    val project = WorkspaceFactory().workspace.project(projectName)
    val task = project.task[LinkSpec](taskName)
    val referenceLinks = task.data.referenceLinks
    val population = getPopulation(task)


    Ok(views.html.learning.rule(population, referenceLinks, context))
  }

  /**
    * Shows the dialog for resetting the active learning activity.
    */
  def resetActiveLearningDialog(projectName: String, taskName: String): Action[AnyContent] = Action {
    Ok(views.html.learning.resetDialog(projectName, taskName))
  }

  /**
    * Resets the active learning activity.
    */
  def resetActiveLearning(projectName: String, taskName: String): Action[AnyContent] = UserContextAction { implicit userContext =>
    val project = WorkspaceFactory().workspace.project(projectName)
    val task = project.task[LinkSpec](taskName)

    // Reset reference links
    task.activity[ReferenceEntitiesCache].control.reset()
    task.update(task.data.copy(referenceLinks = ReferenceLinks.empty))

    // Reset active learning activity
    task.activity[ActiveLearning].reset()

    Ok
  }

  def links(projectName: String, taskName: String, sorting: String, filter: String, page: Int): Action[AnyContent] = UserContextAction { implicit userContext =>
    val project = WorkspaceFactory().workspace.project(projectName)
    val task = project.task[LinkSpec](taskName)
    val validLinks = task.activity[ActiveLearning].value().links
    def refLinks = task.data.referenceLinks
    val linkSorter = LinkSorter.fromId(sorting)

    val valLinks = {
      for (link <- validLinks.view) yield {
        if (refLinks.positive.contains(link))
          new EvalLink(link, Correct, Generated)
        else if (refLinks.negative.contains(link))
          new EvalLink(link, Incorrect, Generated)
        else
          new EvalLink(link, Unknown, Generated)
      }
    }

    Ok(views.html.widgets.linksTable(project, task, valLinks, None, linkSorter, filter, page, showStatus = true, showDetails = false, showEntities = true, rateButtons = true))
  }

  def population(project: String, task: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    val context = Context.get[LinkSpec](project, task, request.path)
    Ok(views.html.learning.population(context))
  }

  def populationView(projectName: String, taskName: String, page: Int): Action[AnyContent] = UserContextAction { implicit userContext =>
    val project = WorkspaceFactory().workspace.project(projectName)
    val task = project.task[LinkSpec](taskName)
    val population = getPopulation(task)

    val pageSize = 20
    val individuals = population.individuals.toSeq
    val sortedIndividuals = individuals.sortBy(-_.fitness)
    val pageIndividuals = sortedIndividuals.view(page * pageSize, (page + 1) * pageSize)

    Ok(views.html.learning.populationTable(projectName, taskName, pageIndividuals, task.activity[ReferenceEntitiesCache].value()))
  }

  private def getPopulation(task: ProjectTask[LinkSpec]): Population = {
    val population1 = task.activity[ActiveLearning].value().population
    val population2 = task.activity[LearningActivity].value().population
    if(population1.isEmpty)
      population2
    else if(population2.isEmpty)
      population1
    else if(population1.bestIndividual.fitness >= population2.bestIndividual.fitness)
      population1
    else
      population2
  }
}