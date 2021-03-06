# knowledge-extraction

The Repository consists of the four sub components (services) of the Knowledge Extraction component in the QualiChain project https://qualichain-project.eu/

1. Silk Framework - Contains the latest version of Silk Configured for dobie

2. dobie - Contains the dobie pipeline configured for the Skills domain (SARO Ontology - see note below)

3. JobWatch - Fetches and process data from job posting portals 

4. SEAS-Extractor - SEmi Automatic Skills (SEAS) Extraction tool

**Note**: This dobie distribution is customised for the Job Market Monitoring use-case, as one of the QualiChain areas for which knowledge extraction is required (in addition to job posts, dobie will also process course descriptions and anonimised personal CVs). It therefore includes the domain ontology - QualiChain Ontology https://vocol.iais.fraunhofer.de/QualiChain/visualization)  as a domain ontology, and the data acquisition service is also customised (JobWatch) to extract the relevant data (Job postings from online portals).

The dobie pipeline runs as shown in the following figure:

![DOBIE](images/dobie-generic-pipeline.png?raw=true "Domain Ontology Based Information Extraction Pipeline")

## RUNNING AND DEPLOYMENT
### --- Dockerization ---
-----------------------------------------------
Each Sub component has a Dockerfile at its root directory, this docker file contains instructions to run

a ReadMe file is also contained with it that would provide more instructions.


Use this file to create a docker file of the subcomponent

Run the dockerized file


### None Docker Versions : To run the variuos services. Follow these Instructions
-----------------------------------------------------------------------

So far, the run_all.sh script should run all the three services.
Take a look inside for what is what and which interface to call on which port.


### RUNNING THE SERVICES SEPARATELY;

#### To run Silk :

Run steps:
1. Place the Workspace in the default silk home directory ($home/.silk/workspace/) -- place the folder "edsa" in this directory so that silk can pick the workspace configs
   [This repository already has this step done]
2. Run the sbt command. If you did 1 above --- Take Option A below (You don't need to set the options [-Dworkspace.repository.projectFile.dir | -Dworkspace.provider.file.dir])
3. Run the Skill Annotations
4. Run the Data Acquisition as shown below in section 4


#### Option A -- REDUCED RUN VERSION

export TERM=xterm-color

sbt -Dhttp.port=9005 "project workbench" [-Dapplication.context=/silk/] run

#### Option B

Windows

sbt -Dworkspace.repository.plugin=projectFile -Dworkspace.repository.projectFile.dir=C:\path-to-workspace\Workspace -Dworkspace.provider.file.dir=C:\path-to-workspace\Workspace  -Dhttp.port=9005 -Dapplication.context=/silk/ -Dparsers.text.maxLength=1024K "project workbench" run

Linux

sbt -Dworkspace.repository.plugin=projectFile -Dworkspace.repository.projectFile.dir=/path-to-workspace/edsa/silk-workspace/workspace -Dworkspace.provider.file.dir=/path-to-workspace/edsa/silk-workspace/workspace  -Dhttp.port=9005 -Dapplication.context=/silk/ -Dparsers.text.maxLength=1024K "project workbench" run


Browser Link: http://localhost:9005/workspace  OR http://localhost:9005/silk/workspace --- if you specified -Dapplication.context=/silk/


Possible Error

Silk compiles and runs without errors but when you go to --> localhost:9005, You get the error:

RuntimeException: No application loader is configured. Please configure an application loader either using the play.application.loader configuration property, or by depending on a module that configures one. You can add the Guice support module by adding "libraryDependencies += guice" to your build.sbt.

Solution:
Should you face the error message, just do what it tells you :  -- add "libraryDependencies += guice" to your build.sbt



#### STEP 3: domain ontologie based information extraction (dobie)
----------------------------------
You need the GATE embedded installed

And configure the path in application.config

export TERM=xterm-color

sbt -Dhttp.port=9006 run

DOCKERISED VERSION: there is a dockerfile in the dobie folder, use this file to create docker image and execute, at the beggining of docker file, there are commands for creating
the image as well for running it.

There is also a read me in the folder containing instructions specific for dobie.

Examples: For an example on how to call the dobie: Take a look into the "dobie example" under the examples folder


#### STEP 4: JobWatch
-----------------------------------------------
Depends on the other modules || runs on port 9000 by default
 
sbt run

