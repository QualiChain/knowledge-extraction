package org.silkframework.runtime.resource

import java.io.{InputStream, OutputStream}
import java.time.Instant

/**
  * A ResourceManager that consists of a primary resource manager and a fallback resource loader.
  * If a requested resource is not available in the primary resource manager it is retrieved from the fallback resource loader.
  * Write operations are always executed on the primary resource manager, which creates a resource if necessary.
  * Navigation operations (child, parent) are only applied on the primary resource manager, the fallback resource loader always stays at the same path.
  * The FallbackResourceManager can be used for adding default resources which are always available.
  */
case class FallbackResourceManager(resourceMgr: ResourceManager, fallbackLoader: ResourceManager, writeIntoFallbackLoader: Boolean) extends ResourceManager {

  override def get(name: String, mustExist: Boolean): WritableResource = {
    if(mustExist) {
      try {
        resourceMgr.get(name, mustExist = true)
      } catch {
        case _: ResourceNotFoundException =>
          ReadOnlyResource(fallbackLoader.get(name, mustExist = true))
      }
    } else {
      FallBackResource(resourceMgr.get(name, mustExist = false), fallbackLoader.get(name, mustExist = false))
    }
  }

  override def child(name: String): ResourceManager = FallbackResourceManager(
    resourceMgr.child(name), fallbackLoader, writeIntoFallbackLoader) // fallback loader also needs to return the child

  override def parent: Option[ResourceManager] = {
    for(parent <- resourceMgr.parent) yield
      FallbackResourceManager(parent, fallbackLoader, writeIntoFallbackLoader) // TODO: fallback loader also needs to return the parent
  }

  override def delete(name: String): Unit = resourceMgr.delete(name)

  override def basePath: String = resourceMgr.basePath

  override def list: List[String] = resourceMgr.list ++ fallbackLoader.list

  override def listChildren: List[String] = resourceMgr.listChildren

  case class FallBackResource(primaryResource: WritableResource, fallbackResource: WritableResource) extends WritableResource {
    /**
      * The local name of this resource.
      */
    override def name: String = primaryResource.name

    /**
      * The path of this resource.
      */
    override def path: String = primaryResource.path

    /**
      * Checks if this resource exists.
      */
    override def exists: Boolean = primaryResource.exists || fallbackResource.exists

    override def size: Option[Long] = {
      if (primaryResource.exists) {
        primaryResource.size
      } else if (fallbackResource.exists) {
        fallbackResource.size
      } else {
        None
      }
    }

    override def modificationTime: Option[Instant] = {
      if (primaryResource.exists) {
        primaryResource.modificationTime
      } else if (fallbackResource.exists) {
        fallbackResource.modificationTime
      } else {
        None
      }
    }

    /**
      * Preferred method for writing to a resource.
      *
      * @param write A function that accepts an output stream and writes to it.
      */
    override def write(append: Boolean = false)(write: (OutputStream) => Unit): Unit = {
      if(writeIntoFallbackLoader && !primaryResource.exists && fallbackResource.exists) {
        fallbackResource.write(append)(write)
      } else {
        primaryResource.write(append)(write)
      }
    }

    /**
      * Loads the resource.
      *
      * @return An input stream for reading the resource.
      *         The caller is responsible for closing the stream after reading.
      */
    override def inputStream: InputStream = {
      if(primaryResource.exists) {
        primaryResource.inputStream
      } else {
        fallbackResource.inputStream
      }
    }

    /**
      * Deletes this resource.
      */
    override def delete(): Unit = primaryResource.delete()
  }

}

