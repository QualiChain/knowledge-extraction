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

package org.silkframework.cache

import java.io._
import java.util.logging.{Level, Logger}

import org.silkframework.config.RuntimeConfig
import org.silkframework.entity.{Entity, EntitySchema, Index}
import org.silkframework.util.FileUtils._

import scala.util.control.NonFatal

/**
 * An entity cache, which caches the entities on the local file system.
 */
class FileEntityCache(val entitySchema: EntitySchema,
                      val indexFunction: (Entity => Index),
                      dir: File,
                      runtimeConfig: RuntimeConfig) extends EntityCache {

  private val logger = Logger.getLogger(getClass.getName)

  private val blocks = (for (i <- 0 until blockCount) yield new Block(i)).toArray

  @volatile
  private var entityCount = 0

  override def write(entity: Entity) {
    val indices = if (runtimeConfig.blocking.isEnabled) indexFunction(entity).flatten else Set(0)

    for ((block, index) <- indices.groupBy(i => math.abs(i % blockCount))) {
      blocks(block).write(entity, BitsetIndex.build(index))
    }

    if (indices.nonEmpty) entityCount += 1
  }

  override def read(block: Int, partition: Int) = {
    require(block >= 0 && block < blockCount, "0 <= block < " + blockCount + " (block = " + block + ")")
    require(partition >= 0 && partition < blocks(block).partitionCount, "0 <= partition < " + blocks(block).partitionCount + " (partition = " + partition + ")")

    blocks(block).read(partition)
  }

  override def blockCount: Int = runtimeConfig.blocking.enabledBlocks

  override def partitionCount(block: Int) = {
    require(block >= 0 && block < blockCount, "0 <= block < " + blockCount + " (block = " + block + ")")

    blocks(block).partitionCount
  }

  override def size = entityCount

  override def clear() {
    logger.log(Level.FINE, s"Clearing the file cache [ path :: ${dir.getAbsolutePath} ].")

    try {
      dir.deleteRecursive()
    } catch {
      case NonFatal(ex) =>
        logger.log(Level.WARNING, s"Could not delete cache directory ${dir.getAbsolutePath}. Error message: ${Option(ex.getMessage).getOrElse("-")}")
        throw ex
    }
    for (block <- blocks) {
      block.clear()
    }
    entityCount = 0

    logger.log(Level.FINE, "Cache cleared.")
  }

  override def close() {
    logger.log(Level.FINER, s"Closing file cache [ size :: ${blocks.length} ].")

    for (block <- blocks) {
      block.close()
    }
  }

  private class Block(block: Int) {
    @volatile var partitionCount = 0

    private val blockDir = dir + "/block" + block.toString + "/"

    private val currentEntities = new Array[Entity](runtimeConfig.partitionSize)
    private val currentIndices = new Array[BitsetIndex](runtimeConfig.partitionSize)
    @volatile private var count = 0

    if (runtimeConfig.reloadCache)
      clear()
    else
      load()

    private def load() {
      //Retrieve the number of existing partitions
      partitionCount = {
        if (blockDir.exists) {
          val partitionFiles = blockDir.list.filter(_.startsWith("partition")).map(name => name.dropWhile(!_.isDigit)).filter(!_.isEmpty)

          if (partitionFiles.isEmpty) 0
          else partitionFiles.map(_.toInt).max + 1
        }
        else {
          0
        }
      }

      //Load the last partition in memory
      if (partitionCount > 0) {
        val readPartition = readPartitionFromFile(partitionCount - 1)
        Array.copy(readPartition.entities, 0, currentEntities, 0, readPartition.size)
        Array.copy(readPartition.indices, 0, currentIndices, 0, readPartition.size)
        count = readPartition.size
      }
    }

    def read(partitionIndex: Int): Partition = {
      if (partitionIndex == partitionCount - 1) {
        Partition(currentEntities, currentIndices, count)
      }
      else {
        readPartitionFromFile(partitionIndex)
      }
    }

    def write(entity: Entity, index: BitsetIndex) {
      if (partitionCount == 0) partitionCount = 1

      currentEntities(count) = entity
      currentIndices(count) = index
      count += 1

      if (count == runtimeConfig.partitionSize) {
        writePartitionToFile()
        count = 0
        partitionCount += 1
      }
    }

    def clear() {
      partitionCount = 0
      count = 0
    }

    def close() {
      if (count > 0) {
        writePartitionToFile()
      }
    }

    private def readPartitionFromFile(partition: Int) = {
      val stream = new DataInputStream(new BufferedInputStream(new FileInputStream(blockDir + "/partition" + partition.toString)))

      try {
        Partition.deserialize(stream, entitySchema)
      }
      finally {
        stream.close()
      }
    }

    private def writePartitionToFile() {
      if (partitionCount == 1) blockDir.mkdirs()

      val stream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(blockDir + "/partition" + (partitionCount - 1).toString)))

      try {
        Partition(currentEntities, currentIndices, count).serialize(stream)
      }
      finally {
        stream.close()
      }

      logger.log(Level.FINE, "Written partition " + (partitionCount - 1) + " of block " + block)
    }
  }

}
