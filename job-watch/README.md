# JobWatch Service

## Description
A scala version of the data acquisition service for job portals: **JobWatch**.
JobWatch is an adaptation of earlier data acquisition tools geared towards extracting semi-structured data from online job posts advertised in Job Portals. 
The earlier service was a core component in the **H2020 European Data Science Academy (EDSA)** and **QualiChain projects.**
It was also incorporated in one of the showcases of the **MINTE+ framework**.
### References
* Sibarani E.M., Scerri S. (2020) SCODIS: Job Advert-derived Time Series for high-demand Skillset Discovery and Prediction. In DEXA 2020.

* Sibarani E.M., Scerri S. (2019) Generating an Evolving Skills Network from Job Adverts for High-Demand Skillset Discovery. In Web Information Systems Engineering – WISE 2019. WISE 2020. Lecture Notes in Computer Science, vol 11881. 

* Dadzie, Aba-Sah and Sibarani, Elisa and Novalija, Inna and Scerri, Simon, Structuring Visual Exploratory Analysis of Skill Demand (March 2018). Journal of Web Semantics First Look. 

* Elisa Margareth Sibarani, Simon Scerri, Camilo Morales, Sören Auer, and Diego Collarana. 2017. Ontology-guided Job Market Demand Analysis: A Cross-Sectional Study for the Data Science field. In Proceedings of the 13th International Conference on Semantic Systems (Semantics2017). 

## Dependencies
The reactive project depends on the following software

* JDK 1.8
* Play Web Framework 2.4.6 "Damiya" and Activator 1.3.7

Download Play: https://www.playframework.com/download

Installation steps: https://www.playframework.com/documentation/2.4.x/Installing

This service depends on the Silk Workbench to transform the data collected from the data sources into RDF.
An instance of the workbench must be available with the configuration files containing the transformation rules.
The configuration files for the RDF transformation and all the resources needed to set up an instance of the Silk Workbench are provided in the project [Data Integration Workspace](https://github.com/LiDaKrA/data-integration-workspace).
JobWatch collects data from job portals and other job and recruitment sources. Some of these require a key to use their API that is stored in conf/application.conf. The key must be provided before starting JobWatch. 

#### IDE support 
The quick and easy way to start compiling, running and coding FuhSen is to use "activator ui".
However, you can also set up your favorits Java IDE (Eclipse or IntellJ Idea). https://www.playframework.com/documentation/2.4.x/IDE

## Install and Build
The service can be installed from the source code on Github or from the Docker image in the [repository](https://hub.docker.com/r/lidakra/)

### Install and build from the source code  
To obtain the latest version of the project please clone the github repository

    $ git clone https://github.com/dob-ie/data-acquisition-service.git

The build system for JobWatch is sbt. The project can be compiled and run using sbt or the Typesafe Activator. In order to compile the project with sbt from the project root folder run the command

    $ sbt compile

The project can be packaged in a tar file in /target/universal/ with the command

    $ sbt package universal:packageZipTarball 

Before making a build, update the version of the project in the following files:
.travis.yml, build.sbt, Dockerfile, start_jobwatch.sh

### Install from the Docker image
A Docker image containing this service can be built from the Docker file.
Once the image has been downloaded or created the configuration file in conf/application.conf must be changed in order to provide the keys for the data sources used by the services and also to update the url of the Silk Workbench.

### Run
JobWatch can be started using Sbt or the Typesafe activator.

#### Run with Sbt
From the project root folder run the command

    $ sbt start

The service server will listen on port 9000.

## License

* Copyright (C) 2019 EIS Fraunhofer-IAIS
* Licensed under the Apache 2.0 License


## Dockerization
1) Build an image using this docker file. Run the following docker command

    $ docker build -t jobwatch/jobwatch:v1.1.0 .

2) Test JobWatch in a container. Run the following docker command for testing

    $ docker run --rm -it -p 9000:9000 --name jobwatch jobwatch/jobwatch:v1.1.0 /bin/bash
