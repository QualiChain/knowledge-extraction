package controllers.core

import controllers.util.SerializationUtils
import javax.inject.Inject
import org.silkframework.runtime.plugin._
import play.api.mvc.{InjectedController, ControllerComponents}

class PluginApi @Inject() () extends InjectedController {

  def plugins() = Action { implicit request => {
    val pluginTypes = Seq(
      "org.silkframework.workspace.WorkspaceProvider",
      "org.silkframework.workspace.resources.ResourceRepository",
      "org.silkframework.config.CustomTask",
      "org.silkframework.dataset.Dataset",
      "org.silkframework.rule.similarity.DistanceMeasure",
      "org.silkframework.rule.input.Transformer",
      "org.silkframework.rule.similarity.Aggregator"
    )
    val pluginList = PluginList.load(pluginTypes)

    SerializationUtils.serializeCompileTime(pluginList, None)
  }}

  def pluginsForTypes(pluginType: String) = Action { implicit request => {
    val pluginTypes = pluginType.split("\\s*,\\s*")
    val pluginList = PluginList.load(pluginTypes)

    SerializationUtils.serializeCompileTime(pluginList, None)
  }}
}
