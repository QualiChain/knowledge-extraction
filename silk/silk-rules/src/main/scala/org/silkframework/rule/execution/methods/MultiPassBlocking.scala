package org.silkframework.rule.execution.methods

import org.silkframework.entity.paths.UntypedPath
import org.silkframework.entity.{Entity, Index}
import org.silkframework.rule.execution.ExecutionMethod
import org.silkframework.rule.LinkageRule

/**
  * Multi-pass blocking.
  *
  * @param blockingKeys The blocking keys.
  */
class MultiPassBlocking(blockingKeys: Set[UntypedPath]) extends ExecutionMethod {

   override def indexEntity(entity: Entity, rule: LinkageRule, sourceOrTarget: Boolean): Index = {
     val values = blockingKeys.flatMap(key => entity.evaluate(key))
     Index.oneDim(values.map(_.hashCode))
   }

 }
