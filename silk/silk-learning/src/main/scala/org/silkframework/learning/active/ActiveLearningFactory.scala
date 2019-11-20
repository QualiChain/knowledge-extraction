package org.silkframework.learning.active

import org.silkframework.learning.LearningConfiguration
import org.silkframework.rule.LinkSpec
import org.silkframework.runtime.activity.Activity
import org.silkframework.runtime.plugin.Plugin
import org.silkframework.workspace.ProjectTask
import org.silkframework.workspace.activity.TaskActivityFactory

@Plugin(
  id = ActiveLearningFactory.pluginId,
  label = "Active Learning",
  categories = Array("LinkSpecification"),
  description = "Executes an active learning iteration."
)
case class ActiveLearningFactory() extends TaskActivityFactory[LinkSpec, ActiveLearning] {

  override def apply(task: ProjectTask[LinkSpec]): Activity[ActiveLearningState] = {

    new ActiveLearning(
      task,
      config = LearningConfiguration.default
    )
  }

}

object ActiveLearningFactory {

  final val pluginId = "ActiveLearning"

}
