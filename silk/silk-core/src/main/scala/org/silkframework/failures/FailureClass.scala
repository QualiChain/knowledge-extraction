package org.silkframework.failures

import org.silkframework.entity.metadata.GenericExecutionFailure
import org.silkframework.entity.paths.UntypedPath
import org.silkframework.util.{Identifier, Uri}

/**
  * Denotes an equivalence class of exceptions dependent on Exception, the task it occurred in, the occurrence class and line number
  *
  * @param rootCause       the first failure of its kind (causing the creation of this class)
  * @param originalMessage the original exception message from the outer most exception
  * @param taskId          the task identifier associated with this kind of failure
  * @param property        the property which is associated/caused with the current failure
  */
//noinspection ScalaStyle
class FailureClass private[failures](val rootCause: GenericExecutionFailure,
                                     val originalMessage: String,
                                     val taskId: Identifier,
                                     val property: Option[UntypedPath]) //FIXME TypedPath needs JsValue serializer - CMEM-1368
    extends Serializable {

  assert(rootCause.cause.isEmpty, "Initializing FailureClass with an Exception which has a cause is not allowed. Use a different apply method for this purpose.")

  private lazy val rootStackElement = Option(rootCause.getStackTrace).flatMap(s => s.headOption)

  def getRootLine: Int = rootStackElement.getOrElse(return 0).getLineNumber

  // The root class inside which the exception occurred. If no stack trace is available it will return the class name of the exception as fallback.
  lazy val getRootClass: String = {
    val baseName = rootStackElement.map(_.getClassName).getOrElse(rootCause.className)
    if(baseName.contains('$')) {
      baseName.substring(0, baseName.indexOf('$'))
    }
    else {
      baseName
    }
  }

  /**
    * Indicates whether the current instance was has been forwarded to an accumulator
    */
  def accumulated(): Boolean = false

  override def hashCode(): Int = {
    val prime = 31
    var hashCode = taskId.hashCode()
    hashCode = hashCode * prime + this.getRootClass.hashCode()
    hashCode = hashCode * prime + this.getRootLine.hashCode()
    hashCode = property.map(_.hashCode + hashCode * prime).getOrElse(hashCode)
    hashCode
  }

  override def equals(o: scala.Any): Boolean = {
    def equalProperty(fc: FailureClass): Boolean = this.property match{
      case Some(p) if fc.property.isDefined => p == fc.property.get
      case None if fc.property.isEmpty => true
      case _ => false
    }

    o match{
      case fc: FailureClass =>
        this.taskId == fc.taskId &&
          this.getRootClass == fc.getRootClass &&
          this.getRootLine == fc.getRootLine &&
          equalProperty(fc)
      case _ => false
    }
  }
}

/**
  * Extension of [[FailureClass]] denoting the current instance as already collected by an FailureClassAccumulator
  * @param rootCause - the first exception of its kind (causing the creation of this class)
  * @param originalMessage - the original exception message from the outer most exception
  * @param taskId - the task identifier associated with this kind of of exception
  * @param property - the property which is associated/caused with the current failure
  */
class AccumulatedFailureClass private(
                                       rootCause: GenericExecutionFailure,
                                       originalMessage: String,
                                       taskId: Identifier,
                                       property: Option[UntypedPath] //FIXME TypedPath needs JsValue serializer CMEM-1368
) extends FailureClass (rootCause, originalMessage, taskId, property){

  def this(fc: FailureClass) = this(fc.rootCause, fc.originalMessage, fc.taskId, fc.property)

  /**
    * Indicates whether the current instance was has been forwarded to an accumulator
    */
  override def accumulated(): Boolean = true
}

object FailureClass{

  private[failures] val DEFAULT_TASK_ID = Identifier("default_task_id")

  /**
    * Extracts the root exception from a StackTrace
    * @param ex - the initial exception containing the root exception
    * @return - the exception in the exception stack which has no causing exception itself
    */
  private[failures] def getRootCause(ex: GenericExecutionFailure): GenericExecutionFailure = {
    var thr: GenericExecutionFailure = ex
    while(thr.cause.isDefined){
      thr = thr.cause.get
    }
    thr
  }

  /**
    * Instantiate a new instance of FailureClass using the forwarded exception by the system, an id of the current task and an optional property pointer
    * @param failure - the initial failure
    * @param taskId - the task id of the currently running task
    * @return
    */
  def apply(failure: GenericExecutionFailure, taskId: Identifier, property: Option[UntypedPath] = None): FailureClass = {
    new FailureClass(FailureClass.getRootCause(failure), failure.getMessage, taskId, property)
  }

  def apply(failure: GenericExecutionFailure, originalMessage: String, taskId: Identifier, property: Option[UntypedPath]): FailureClass = {
    failure.cause match {
      case Some(_) =>
        apply(failure, taskId, property) // Not the root cause failure, get root cause
      case None =>
        new FailureClass(failure, originalMessage, taskId, property)
    }
  }

  val TASK_ID_TAG = "TaskId"
  val MESSAGE_TAG = "Message"
  val ROOT_CAUSE_TAG = "RootCause"
  val PROPERTY_TAG = "Property"
  val ACCUMULATED_TAG = "Accumulated"

}

/**
  * Collection object mapping [[FailureClass]] to a set of Entity URIs, for which an instance of this FailureClass occurred
  * @param failure - the [[FailureClass]]
  * @param collection - collection of Entity URIs
  */
case class FailureCollection(failure: FailureClass, collection: Set[Uri])
