/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.silkframework.rule

import java.util.logging.Level

import org.silkframework.config.{Blocking, RuntimeConfig}
import org.silkframework.rule.execution.ExecutionMethod

/**
  * The linking runtime configuration.
  *
  * @param executionMethod           The method used to execute the linkage rule.
  * @param blocking                  The blocking parameters.
  * @param includeReferenceLinks     If true, links for which there is a negative reference link are not generated,
  *                                  while links for which there is a positive reference link are always generated.
  * @param useFileCache              If true, the entities are cached on the file system. If false, an in-memory cache is used.
  * @param reloadCache               Specifies if the entity cache is to be reloaded before executing the matching.
  * @param partitionSize             The maximum size of the entity partitions in the cache.
  * @param numThreads                The number of concurrent threads used for matching.
  * @param generateLinksWithEntities Generate links with the entities they connect.
  * @param homeDir                   The directory used by Silk to store persistent information such as caches.
  * @param sampleSizeOpt             Load all entities if set to None, else only load a random sample of max. the configured size
  *                                  from each data source to be linked.
  * @param linkLimit                 If defined, the execution will stop after the configured number of links is reached and will return
  *                                  at most the specified number of links.
  * @param executionTimeout          The timeout in milliseconds that the execution should run. This does not completely abort
  *                                  the execution, i.e. resulting links at the timeout are still returned.
  */
case class RuntimeLinkingConfig(executionMethod: ExecutionMethod = ExecutionMethod(),
                                blocking: Blocking = Blocking(),
                                includeReferenceLinks: Boolean = false,
                                indexingOnly: Boolean = false,
                                useFileCache: Boolean = true,
                                reloadCache: Boolean = true,
                                partitionSize: Int = 1000,
                                numThreads: Int = Runtime.getRuntime.availableProcessors(),
                                generateLinksWithEntities: Boolean = false,
                                homeDir: String = System.getProperty("user.home") + "/.silk/",
                                logLevel: Level = Level.INFO,
                                sampleSizeOpt: Option[Int] = None,
                                linkLimit: Option[Int] = None,
                                executionTimeout: Option[Long] = None,
                                executionBackend: LinkingExecutionBackend = LinkingExecutionBackend.nativeExecution) extends RuntimeConfig {

  require(partitionSize > 1, "partitionSize must be greater than 0 (partitionSize=" + partitionSize + ")")
}