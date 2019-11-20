package org.silkframework.plugins.dataset.csv

import org.silkframework.dataset.{LinkSink, TypedProperty}
import org.silkframework.entity.{Link, StringValueType}
import org.silkframework.runtime.activity.UserContext
import org.silkframework.runtime.resource.WritableResource

/**
 * Created by andreas on 12/11/15.
 */
class CsvLinkSink(file: WritableResource, settings: CsvSettings) extends CsvSink(file, settings) with LinkSink {

  /**
    * Initialize the link sink
    */
  override def init()(implicit userContext: UserContext): Unit = {
    openTable("",
      Seq(TypedProperty("link_source", StringValueType, isBackwardProperty = false),
        TypedProperty("link_target", StringValueType, isBackwardProperty = false)))
  }

  override def writeLink(link: Link, predicateUri: String)
                        (implicit userContext: UserContext){
    write(Seq(link.source, link.target))
  }

  override def close()(implicit userContext: UserContext): Unit = {
    closeTable()
    super.close()
  }
}
