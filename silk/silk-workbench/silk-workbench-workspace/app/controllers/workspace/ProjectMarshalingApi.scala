package controllers.workspace

import java.io._
import java.util.logging.Logger

import akka.stream.scaladsl.Source
import controllers.core.{RequestUserContextAction, UserContextAction}
import controllers.workspace.ProjectMarshalingApi._
import javax.inject.Inject
import org.silkframework.runtime.execution.Execution
import org.silkframework.runtime.validation.BadUserInputException
import org.silkframework.workspace.xml.XmlZipProjectMarshaling
import org.silkframework.workspace.{ProjectMarshallerRegistry, ProjectMarshallingTrait, WorkspaceFactory}
import play.api.libs.iteratee.Enumerator
import play.api.libs.iteratee.streams.IterateeStreams
import play.api.libs.json.JsArray
import play.api.mvc._

import scala.concurrent.ExecutionContext

class ProjectMarshalingApi @Inject() () extends InjectedController{

  private val log: Logger = Logger.getLogger(this.getClass.getName)

  import ProjectMarshallerRegistry._

  def availableMarshallingPlugins(): Action[AnyContent] = Action {
    val marshaller = marshallingPlugins
    Ok(JsArray(marshaller.map(JsonSerializer.marshaller)))
  }

  def importProject(project: String): Action[AnyContent] = importProjectViaPlugin(project, XmlZipProjectMarshaling.marshallerId)

  /**
    * importProject variant with explicit marshaller parameter
    *
    * @param project
    * @param marshallerId This should be one of the ids returned by the availableProjectMarshallingPlugins method.
    * @return
    */
  def importProjectViaPlugin(project: String, marshallerId: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    withMarshaller(marshallerId) { marshaller =>
      val workspace = WorkspaceFactory().workspace
      workspace.importProject(project, bodyAsFile, marshaller)
      Ok
    }
  }

  def exportProject(projectName: String): Action[AnyContent] = exportProjectViaPlugin(projectName, XmlZipProjectMarshaling.marshallerId)

  def exportProjectViaPlugin(projectName: String, marshallerPluginId: String): Action[AnyContent] = UserContextAction { implicit userContext =>
    withMarshaller(marshallerPluginId) { marshaller =>
      val enumerator = enumerateOutputStream { outputStream =>
        WorkspaceFactory().workspace.exportProject(projectName, outputStream, marshaller)
      }

      val fileName = projectName + marshaller.suffix.map("." + _).getOrElse("")

      Ok.chunked(Source.fromPublisher(IterateeStreams.enumeratorToPublisher(enumerator))).withHeaders("Content-Disposition" -> s"attachment; filename=$fileName")
    }
  }



  def importWorkspaceViaPlugin(marshallerId: String): Action[AnyContent] = RequestUserContextAction { implicit request => implicit userContext =>
    WorkspaceFactory().workspace.clear()
    withMarshaller(marshallerId) { marshaller =>
      val workspace = WorkspaceFactory().workspace
      marshaller.unmarshalWorkspace(workspace.provider, workspace.repository, bodyAsFile)
      workspace.reload()
      log.info(s"Imported workspace. " + userContext.logInfo)
      Ok
    }
  }

  def exportWorkspaceViaPlugin(marshallerPluginId: String): Action[AnyContent] = UserContextAction { implicit userContext =>
    withMarshaller(marshallerPluginId) { marshaller =>
      val enumerator = enumerateOutputStream { outputStream =>
        val workspace = WorkspaceFactory().workspace
        marshaller.marshalWorkspace(outputStream, workspace.projects, workspace.repository)
      }

      val fileName = "workspace" + marshaller.suffix.map("." + _).getOrElse("")

      Ok.chunked(Source.fromPublisher(IterateeStreams.enumeratorToPublisher(enumerator))).withHeaders("Content-Disposition" -> s"attachment; filename=$fileName")
    }
  }

  private def withMarshaller(marshallerId: String)(f: ProjectMarshallingTrait => Result): Result = {
    marshallerById(marshallerId) match {
      case Some(marshaller) =>
        f(marshaller)
      case None =>
        throw BadUserInputException("No marshaller plugin '" + marshallerId + "' found. Available marshallers: " + marshallingPlugins.map(_.id).mkString(", "))
    }
  }

  private def enumerateOutputStream(serializeFunc: java.io.OutputStream => Unit): Enumerator[Array[Byte]] = {
    val outputStream = new PipedOutputStream

    exportExecutionContext.execute(new Runnable {
      override def run(): Unit = {
        try {
          serializeFunc(outputStream)
        } finally {
          // We need to make sure to close the output stream to stop the Enumerator
          outputStream.close()
        }
      }
    })

    Enumerator.fromStream(new PipedInputStream(outputStream))(exportExecutionContext)
  }

  private def bodyAsFile(implicit request: Request[AnyContent]): File = {
    request.body match {
      case AnyContentAsMultipartFormData(formData) if formData.files.size == 1 =>
        formData.files.head.ref.path.toFile
      case AnyContentAsMultipartFormData(formData) if formData.files.size != 1 =>
        throw BadUserInputException("Must provide exactly one file in multipart form data body.")
      case AnyContentAsRaw(buffer) =>
        buffer.asFile
      case _ =>
        throw BadUserInputException("Must attach body as multipart form data or as raw bytes.")
    }
  }

}

object ProjectMarshalingApi {

  /**
    * To prevent deadlock, all project exports are executed in a separate thread pool.
    */
  private val exportExecutionContext: ExecutionContext =
    ExecutionContext.fromExecutorService(Execution.createThreadPool("ProjectMarshalingApi"))

}
