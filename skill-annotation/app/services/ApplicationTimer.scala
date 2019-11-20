package services

import java.time.{Clock, Instant}
import javax.inject._

import play.api.Logger
import play.api.inject.ApplicationLifecycle

import scala.concurrent.Future
import gate.Gate
import java.io.File

import com.typesafe.config.ConfigFactory

/**
 * This class demonstrates how to run code when the
 * application starts and stops. It starts a timer when the
 * application starts. When the application stops it prints out how
 * long the application was running for.
 *
 * This class is registered for Guice dependency injection in the
 * Module class. We want the class to start when the application
 * starts, so it is registered as an "eager singleton". See the code
 * in the Module class to see how this happens.
 *
 * This class needs to run code when the server stops. It uses the
 * application's [[ApplicationLifecycle]] to register a stop hook.
 */
@Singleton
class ApplicationTimer @Inject() (clock: Clock, appLifecycle: ApplicationLifecycle) {

  // This code is called when the application starts.
  private val start: Instant = clock.instant
  Logger.info(s"ApplicationTimer demo: Starting application at $start.")

  if (!Gate.isInitialised) {
    Logger.info(s"Initializing GATE...")

    val gate_home = ConfigFactory.load.getString("gate.home")

    //step 0:
    val gateHome = new File(gate_home)
    Gate.setGateHome(gateHome)

    //step 1:
    val gatePluginsHome = new File(gate_home+"/plugins")
    Gate.setPluginsHome(gatePluginsHome)

    val gateSiteConfig = new File(gate_home+"/gate.xml")
    Gate.setSiteConfigFile(gateSiteConfig)

    //step 2: initialize the GATE library
    Gate.init()
    Logger.info(s"Gate Initialized Successfully")
  }
  else
    Logger.info(s"GATE already initialized")

  // When the application starts, register a stop hook with the
  // ApplicationLifecycle object. The code inside the stop hook will
  // be run when the application stops.
  appLifecycle.addStopHook { () =>
    val stop: Instant = clock.instant
    val runningTime: Long = stop.getEpochSecond - start.getEpochSecond
    Logger.info(s"ApplicationTimer demo: Stopping application at ${clock.instant} after ${runningTime}s.")
    Future.successful(())
  }
}
