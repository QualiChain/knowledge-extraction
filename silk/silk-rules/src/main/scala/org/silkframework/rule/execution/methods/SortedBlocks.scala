package org.silkframework.rule.execution.methods

import org.silkframework.entity.paths.UntypedPath
import org.silkframework.entity.{Entity, Index}
import org.silkframework.rule.execution.ExecutionMethod
import org.silkframework.rule.LinkageRule

import scala.math.{max, min, pow}

case class SortedBlocks(sourceKey: UntypedPath, targetKey: UntypedPath, overlap: Double = 0.5) extends ExecutionMethod {

  private val minChar = 'a'
  private val maxChar = 'z'
  private val numChars = 3 //Maximum number of chars that will be indexed

  private val blockCount = pow(maxChar - minChar + 1, 2).toInt

  override def indexEntity(entity: Entity, rule: LinkageRule, sourceOrTarget: Boolean): Index = {
    val key = if(sourceOrTarget) sourceKey else targetKey
    val values = entity.evaluate(key)

    values.map(indexValue).reduce(_ merge _)
  }

  private def indexValue(value: String): Index = {
    //Given a string, generate a value in the interval [0,1[
    var index = 0.0
    for(i <- 0 until min(numChars, value.length)) {
      //Make sure the character is inside the interval [minChar,maxChar]
      val croppedChar = min(max(value(i).toLower, minChar), maxChar)
      //Update index
      index += (croppedChar - minChar) / pow(maxChar - minChar + 1, i + 1)
    }

    //Generate index
    Index.continuous(
      value = index,
      minValue = 0.0,
      maxValue = 1.0,
      blockCount = blockCount,
      overlap = overlap
    )
  }
}