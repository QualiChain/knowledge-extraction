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

package org.silkframework.hadoop.impl

import org.apache.hadoop.io.NullWritable
import org.apache.hadoop.mapreduce._
import org.silkframework.cache.Partition

import scala.collection.immutable.HashSet
import org.silkframework.hadoop.SilkConfiguration

class SilkInputFormat extends InputFormat[NullWritable, EntityPair]
{
  override def getSplits(jobContext : JobContext) : java.util.List[InputSplit] =
  {
    val config = SilkConfiguration.get(jobContext.getConfiguration)

    val inputSplits = new java.util.ArrayList[InputSplit]()

    for(blockIndex <- 0 until config.sourceCache.blockCount;
        is <- 0 until config.sourceCache.partitionCount(blockIndex);
        it <- 0 until config.targetCache.partitionCount(blockIndex))
    {

      //Get the list of nodes where both partitions of this split would be local if any.
      //If no host holds both partitions, returns the list of hosts which hold at least one partition.
      val sourceHosts = config.sourceCache.hostLocations(blockIndex, is)
      val targetHosts = config.targetCache.hostLocations(blockIndex, it)

      val unionHosts = sourceHosts union targetHosts
      val hosts =
        if(!unionHosts.isEmpty)
        {
          unionHosts
        }
        else
        {
          sourceHosts ++ targetHosts
        }

      //Compute the size of the split, so that the input splits can be sorted by size.
      val size = config.sourceCache.partitionSize(blockIndex, is) + config.targetCache.partitionSize(blockIndex, it)

      inputSplits.add(new SilkInputSplit(blockIndex, is, it, size, hosts))
    }

    inputSplits
  }

  override def createRecordReader(inputSplit : InputSplit, context : TaskAttemptContext) : RecordReader[NullWritable, EntityPair] =
  {
    new SilkRecordReader()
  }

  private class SilkRecordReader() extends RecordReader[NullWritable, EntityPair]
  {
    private var sourcePartition : Partition = null
    private var targetPartition : Partition = null

    private var sourceIndices : Array[Set[Int]] = null
    private var targetIndices : Array[Set[Int]] = null

    private var sourceIndex = 0
    private var targetIndex = -1

    override def getProgress = (sourceIndex * targetPartition.size + targetIndex + 1).toFloat / (sourcePartition.size * targetPartition.size).toFloat

    override def initialize(inputSplit : InputSplit, context : TaskAttemptContext) : Unit =
    {
      val config = SilkConfiguration.get(context.getConfiguration)
      val linkSpec = config.linkSpec

      val silkInputSplit = inputSplit.asInstanceOf[SilkInputSplit]

      sourcePartition = config.sourceCache.read(silkInputSplit.blockIndex, silkInputSplit.sourcePartition)
      targetPartition = config.targetCache.read(silkInputSplit.blockIndex, silkInputSplit.targetPartition)

      sourceIndices = sourcePartition.entities.map(entity => HashSet(linkSpec.rule.index(entity, true, 0.0).flatten.toSeq : _*))
      targetIndices = targetPartition.entities.map(entity => HashSet(linkSpec.rule.index(entity, false, 0.0).flatten.toSeq : _*))

      context.setStatus("Comparing partition " + silkInputSplit.sourcePartition + " and " + silkInputSplit.targetPartition)
    }

    override def close : Unit =
    {
      sourcePartition = null
      targetPartition = null

      sourceIndices = null
      targetIndices = null
    }

    override def nextKeyValue : Boolean =
    {
      var result : Option[Boolean] = None
      while(!result.isDefined)
      {
        val hasNext =
          if(sourceIndex == sourcePartition.size - 1 && targetIndex == targetPartition.size - 1)
          {
            false
          }
          else if(targetIndex == targetPartition.size - 1)
          {
            sourceIndex += 1
            targetIndex = 0

            true
          }
          else
          {
            targetIndex += 1

            true
          }

        if(hasNext && sourceIndices(sourceIndex).exists(targetIndices(targetIndex).contains))
        {
          result = Some(true)
        }
        else if(!hasNext)
        {
          result = Some(false)
        }
      }
      result.get
    }

    override def getCurrentKey = NullWritable.get

    override def getCurrentValue = new EntityPair(sourcePartition.entities(sourceIndex), targetPartition.entities(targetIndex))
  }
}
