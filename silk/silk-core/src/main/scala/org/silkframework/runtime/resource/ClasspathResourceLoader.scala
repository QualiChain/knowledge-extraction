package org.silkframework.runtime.resource

/**
 * A resource loader that loads resources from the classpath.
 *
 * @param basePath A base path of the form '''com/example/library'''. Note the use of '/' instead of '.'
 */
case class ClasspathResourceLoader(basePath: String) extends ResourceLoader {

  override def list = {
    throw new UnsupportedOperationException("ClasspathResourceLoader does not support listing resources")
  }

  /**
   * Retrieves a resource by name.
   *
   * @param name The local name of the resource.
   * @return The resource.
   * @throws ResourceNotFoundException If no resource with the given name has been found.
   */
  override def get(name: String, mustExist: Boolean): Resource = {
    val path = if(basePath.isEmpty) name else basePath + "/" + name
    if(mustExist && getClass.getClassLoader.getResource(path) == null) {
      throw new ResourceNotFoundException(s"Resource $name not found in classpath $basePath")
    }
    ClasspathResource(path)
  }

  override def listChildren: List[String] = {
    throw new UnsupportedOperationException("ClasspathResourceLoader does not support listing resources")
  }

  override def child(name: String): ResourceLoader = {
    ClasspathResourceLoader(basePath + "/" + name)
  }

  override def parent: Option[ResourceLoader] = {
    if(basePath == "")
      None
    else
      Some(ClasspathResourceLoader(basePath.substring(0, basePath.lastIndexOf('/'))))
  }
}


