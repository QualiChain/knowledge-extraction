package org.silkframework.runtime.activity

/**
 * Created by andreas on 1/26/16.
 */
case class CombinedActivity(override val name: String,
                            activities: Activity[Unit]*) extends Activity[Unit] {
  /**
   * Executes this activity.
   *
   * @param context Holds the context in which the activity is executed.
   */
  override def run(context: ActivityContext[Unit])
                  (implicit userContext: UserContext): Unit = {
    activities foreach(_.run(context))
  }

  override def cancelExecution()(implicit userContext: UserContext): Unit = {
    activities foreach(_.cancelExecution())
    super.cancelExecution()
  }

  override def resetCancelFlag()(implicit userContext: UserContext): Unit = {
    activities foreach(_.resetCancelFlag())
    super.resetCancelFlag()
  }
}
