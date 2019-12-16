[![Build Status](https://travis-ci.org/silk-framework/silk.svg?branch=develop)](https://travis-ci.org/silk-framework/silk)
[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy?template=https://github.com/silk-framework/silk)

# Silk Link Discovery Framework

Silk is an open source framework for integrating heterogeneous data sources. The primary uses cases of Silk include:

- Generating links between related data items within different Linked Data sources.
- Linked Data publishers can use Silk to set RDF links from their data sources to other data sources on the Web.
- Applying data transformations to structured data sources.

General information about Silk can be found on the official [website](http://silkframework.org).

## Documentation

Community documentation is maintained in the [doc](doc/) folder.

## Requirements

This Folder contains a Version of Silk customised for DOBIE pipline -- Fo the general Silk framework please visit the Silk [website](http://silkframework.org)

### docker based build

- docker (version >=17.05-xx)

## Running the Silk Workbench Without Docker

- Execute: export TERM=xterm-color
- Execute; sbt -Dhttp.port=9005 "project workbench" [-Dapplication.context=/silk/] run
- In your browser, navigate to 'http://localhost:9000'

## Running the Silk Workbench as docker container

- Use the dockerfile to create the docker image:
  - Build the docker image with: `docker build -t qualichain/silk-qc .` (This maybe take some minutes)
- Run the docker container with: `docker run --rm -it -p 9005:9005 --name silk-qc qualichain/silk-qc /bin/bash`
- In your browser, navigate to 'http://DOCKER_HOST:9005'
- To make the userdata available from outside the docker container you can add a volume mount, therefore add `-v $PWD:/opt/silk/workspace` to the docker run command.
