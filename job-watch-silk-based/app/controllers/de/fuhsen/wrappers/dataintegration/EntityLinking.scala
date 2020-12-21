package controllers.de.fuhsen.wrappers.dataintegration

import com.typesafe.config.ConfigFactory

/**
  * Created on 2/29/16.
  */
class EntityLinking(silkConfig: SilkConfig) {

  def linkTemplate(triples: String, tripleFormat: String = "Turtle") = {
    <Link>
      <DataSources>
        <Dataset id="sourceDataset">
          <DatasetPlugin type="file">
            <Param name="file" value="source"/>
            <Param name="format" value= {tripleFormat} />
          </DatasetPlugin>
        </Dataset>
        <Dataset id="targetDataset">
          <DatasetPlugin type="file">
            <Param name="file" value="target"/>
            <Param name="format" value={tripleFormat}/>
          </DatasetPlugin>
        </Dataset>
      </DataSources>
      <resource name="source">
        {triples}
      </resource>
      <resource name="target">
        {triples}
      </resource>
    </Link>
  }

  def sparqlPointTemplate(endpointURI_1: String, graph_1: String,  queryParameters_1: String, endpointURI_2: String, graph_2: String,  queryParameters_2: String) = {
    <Link>
      <DataSources>
        <Dataset id="sourceDataset" type="sparqlEndpoint">
          <Param name="pageSize" value="1000"/>
          <Param name="clearGraphBeforeExecution" value="true"/>
          <Param name="pauseTime" value="0"/>
          <Param name="retryCount" value="3"/>
          <Param name="endpointURI" value={endpointURI_1}/>
          <Param name="strategy" value="parallel"/>
          <Param name="retryPause" value="1000"/>
          <Param name="graph" value={graph_1}/>
          <Param name="queryParameters" value={queryParameters_1}/>
          <Param name="login" value=""/>
          <Param name="useOrderBy" value="true"/>
          <Param name="entityList" value=""/>
          <Param name="password" value=""/>
          <MetaData>
            <Label></Label>
            <Description></Description>
          </MetaData>
        </Dataset>
        <Dataset id="targetDataset" type="sparqlEndpoint">
          <Param name="pageSize" value="1000"/>
          <Param name="clearGraphBeforeExecution" value="false"/>
          <Param name="pauseTime" value="0"/>
          <Param name="retryCount" value="3"/>
          <Param name="endpointURI" value={endpointURI_2}/>
          <Param name="strategy" value="parallel"/>
          <Param name="retryPause" value="1000"/>
          <Param name="graph" value={graph_2}/>
          <Param name="queryParameters" value={queryParameters_2}/>
          <Param name="login" value=""/>
          <Param name="useOrderBy" value="false"/>
          <Param name="entityList" value=""/>
          <Param name="password" value=""/>
          <MetaData>
            <Label></Label>
            <Description></Description>
          </MetaData>
        </Dataset>
      </DataSources>
    </Link>
  }

}


case class SilkConfig(projectId: String,
                      linkingTaskId: String,
                      silkServerUrl: String = ConfigFactory.load.getString("silk.server.url")) {

  def endpoint = s"""$silkServerUrl/linking/tasks/$projectId/$linkingTaskId/postLinkDatasource"""
}