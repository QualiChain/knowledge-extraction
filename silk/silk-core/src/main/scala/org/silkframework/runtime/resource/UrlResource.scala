package org.silkframework.runtime.resource

import java.io.{FileNotFoundException, InputStream}
import java.net.{URL, URLConnection, UnknownHostException}


/**
 * Created by andreas on 1/21/16.
 */
case class UrlResource(url: URL, connectTimeout: Option[Int] = Some(5000), readTimeout: Option[Int] = None) extends Resource {

  /**
   * The local name of this resource.
   */
  override def name: String = {
    path.split("/").last
  }

  /**
   * Loads the resource.
   *
   * @return An input stream for reading the resource.
   *         The caller is responsible for closing the stream after reading.
   */
  override def inputStream: InputStream = {
    getConnection().getInputStream
  }

  /**
   * Checks if this resource exists.
   */
  override def exists: Boolean = {
    handleStream(
      is => true,
      failValue = false
    )
  }

  override def size = None

  override def modificationTime = None

  private def handleStream[T](handleStreamFN: InputStream => T, failValue: T): T = {
    var is: InputStream = null
    try {
      val conn = getConnection()
      is = conn.getInputStream
      return handleStreamFN(is)
    } catch {
      case _: FileNotFoundException | _: UnknownHostException =>
        // Ignore and return fail value
        failValue
    } finally {
      if(is != null) {
        is.close()
      }
    }
  }

  private def getConnection(): URLConnection = {
    val conn = url.openConnection()
    connectTimeout foreach(conn.setConnectTimeout(_))
    readTimeout foreach (conn.setConnectTimeout(_))
    conn
  }

  /**
   * The path of this resource.
   */
  override def path: String = url.getPath

  override def toString = url.toString
}