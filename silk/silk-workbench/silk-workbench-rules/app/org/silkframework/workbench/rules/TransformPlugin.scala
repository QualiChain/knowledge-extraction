package org.silkframework.workbench.rules

import controllers.rules.routes.Assets
import org.silkframework.config.TaskSpec
import org.silkframework.rule.{LinkSpec, TransformSpec}
import org.silkframework.util.Identifier
import org.silkframework.workbench.WorkbenchPlugin
import org.silkframework.workbench.WorkbenchPlugin.{Tab, TaskActions, TaskType}
import org.silkframework.workbench.rules.TransformPlugin.{TransformTaskActions, TransformTaskType}
import org.silkframework.workspace.ProjectTask

import scala.language.existentials

/**
  * The linking Workbench plugin.
  */
case class TransformPlugin() extends WorkbenchPlugin[TransformSpec] {

  /**
    * The task type that is covered by this plugin.
    */
  override def taskType: TaskType = TransformTaskType

  /**
    * The task actions that are provided for a specific task.
    */
  override def taskActions(task: ProjectTask[_ <: TaskSpec]): TaskActions = {
    TransformTaskActions(task)
  }

}

object TransformPlugin {

  object TransformTaskType extends TaskType {

    /** The name of the task type */
    override def typeName: String = "Transform Task"

    /** Path to the task icon */
    override def icon: String = Assets.at("img/arrow-skip.png").url

    override def folderIcon: String = Assets.at("img/transform-folder.png").url

    /** The path to the dialog for creating a new task. */
    override def createDialog(project: String): Option[String] =
      Some(s"transform/dialogs/newTransformTask/$project")

    override def index: Int = 1

  }

  case class TransformTaskActions(task: ProjectTask[_ <: TaskSpec]) extends TaskActions {

    private val project = task.project.name

    private val taskId = task.id

    /** The name of the task type */
    override def taskType: TaskType = TransformTaskType

    /** The path to the dialog for editing an existing task. */
    override def propertiesDialog: Option[String] =
      Some(s"transform/dialogs/editTransformTask/$project/$taskId")

    /** The path to redirect to when the task is opened. */
    override def openPath(inWorkflow: Option[Identifier], workflowOperatorId: Option[String]): Option[String] =
      Some(s"transform/$project/$taskId/editor")

    /**
      * Lists the shown tabs.
      */
    override def tabs = {
      var tabs = List[Tab]()
      if(task.data.isInstanceOf[TransformSpec]) {
        tabs ::= Tab("Editor", s"transform/$project/$taskId/editor")
        tabs ::= Tab("Evaluate", s"transform/$project/$taskId/evaluate")
        tabs ::= Tab("Execute", s"transform/$project/$taskId/execute")
      }
      tabs.reverse
    }
  }
}

