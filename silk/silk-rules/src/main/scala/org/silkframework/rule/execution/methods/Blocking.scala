package org.silkframework.rule.execution.methods

import org.silkframework.entity.paths.UntypedPath
import org.silkframework.entity.{Entity, Index}
import org.silkframework.rule.execution.ExecutionMethod
import org.silkframework.rule.plugins.transformer.linguistic.SoundexTransformer
import org.silkframework.rule.LinkageRule
import org.silkframework.rule.input.SimpleTransformer

/**
  * Traditional blocking.
  * Per-default, all values are soundex encoded before blocking.
  *
  * @param sourceKey The source blocking key, e.g., rdfs:label
  * @param targetKey The target blocking key, e.g., rdfs:label
  * @param q The maximum number of characters that are used for the indexing
 *  @param transformers A list of transformers that are applied to each value prior to blocking
  */
case class Blocking(sourceKey: UntypedPath, targetKey: UntypedPath, q: Int = 100, transformers: List[SimpleTransformer] = SoundexTransformer() :: Nil) extends ExecutionMethod {
   override def indexEntity(entity: Entity, rule: LinkageRule, sourceOrTarget: Boolean): Index = {
     val key = if(sourceOrTarget) sourceKey else targetKey
     val values = entity.evaluate(key)

     Index.blocks(values.map(getBlock).toSet)
   }

   private def getBlock(value: String) = {
     val transformedValue = transformers.foldLeft(value)((value,transformer) => transformer.evaluate(value))
     transformedValue.take(q).hashCode
   }
}