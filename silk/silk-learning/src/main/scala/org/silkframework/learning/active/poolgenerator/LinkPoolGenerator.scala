package org.silkframework.learning.active.poolgenerator

import org.silkframework.dataset.DataSource
import org.silkframework.entity.paths.TypedPath
import org.silkframework.learning.active.UnlabeledLinkPool
import org.silkframework.rule.LinkSpec
import org.silkframework.runtime.activity.Activity
import org.silkframework.util.DPair

trait LinkPoolGenerator {

  def generator(inputs: DPair[DataSource],
                linkSpec: LinkSpec,
                paths: Seq[DPair[TypedPath]]): Activity[UnlabeledLinkPool]

}
