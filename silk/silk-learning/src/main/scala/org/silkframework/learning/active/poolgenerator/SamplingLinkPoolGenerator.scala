package org.silkframework.learning.active.poolgenerator

import org.silkframework.rule.RuntimeLinkingConfig

/**
 * A link pool generator similar to [[SimpleLinkPoolGenerator]], but which samples the entities before doing an initial
 * matching for the link pool. This link pool can be made to work also with larger datasets.
 */
class SamplingLinkPoolGenerator(sampleSize: Int) extends SimpleLinkPoolGenerator {
  override def runtimeConfig = RuntimeLinkingConfig(
    partitionSize = 1000,
    useFileCache = false,
    generateLinksWithEntities = true,
    sampleSizeOpt = Some(sampleSize)
  )

  override def toString(): String = {
    s"SamplingLinkPoolGenerator(sampleSize = $sampleSize)"
  }
}
