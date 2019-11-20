# knowledge-extraction
Knowledge Extraction

The Repository consists of the three aspects of the Knowledge Extarction component

1. Silk Framework - Configured for DOBIE

2. skill-annotation - Contains the DOBIE pipeline

3. data acquisition - Fetches and process data from job posting portals

To run the varius services. Follows these Instructions
-----------------------------------------------------------------------

So far, the run_all.sh script should run all the three services.
Take a look inside for what is what and which interface to call on which port.


OTHERWISE, YOU CAN RUN THE DIFFERENT SERVICES SEPARATELY;

TO RUN SILK :

Run steps:
1. Place the Workspace in the default silk home directory ($home/.silk/workspace/) -- place the folder "edsa" in this directory so that silk can pick the workspace configs
2. Run the sbt command. If you did 1 above --- Take Option A below (You don't need to set the options [-Dworkspace.repository.projectFile.dir | -Dworkspace.provider.file.dir])
3. Run the Skill Annotations
4. Run the Data Acquisition as shown below in section 4


*Option A -- REDUCED RUN VERSION ---*
export TERM=xterm-color
sbt -Dhttp.port=9005 "project workbench" [-Dapplication.context=/silk/] run

*Option B*
Windows
sbt -Dworkspace.repository.plugin=projectFile -Dworkspace.repository.projectFile.dir=C:\path-to-workspace\Workspace -Dworkspace.provider.file.dir=C:\path-to-workspace\Workspace  -Dhttp.port=9005 -Dapplication.context=/silk/ -Dparsers.text.maxLength=1024K "project workbench" run

Linux
sbt -Dworkspace.repository.plugin=projectFile -Dworkspace.repository.projectFile.dir=/path-to-workspace/edsa/silk-workspace/workspace -Dworkspace.provider.file.dir=/path-to-workspace/edsa/silk-workspace/workspace  -Dhttp.port=9005 -Dapplication.context=/silk/ -Dparsers.text.maxLength=1024K "project workbench" run



Browser Link
------------------------------------

http://localhost:9005/workspace  OR http://localhost:9005/silk/workspace --- if you specified -Dapplication.context=/silk/




Possible Error
---------------------------------

Silk compiles and runs without errors but when you go to --> localhost:9005
You get the error:

RuntimeException: No application loader is configured. Please configure an application loader either using the play.application.loader configuration property, or by depending on a module that configures one. You can add the Guice support module by adding "libraryDependencies += guice" to your build.sbt.

Solution:
-----------------------------------
Should you face the error message, just do what it tells you :  -- add "libraryDependencies += guice" to your build.sbt






STEP 3: Skill Annotation
----------------------------------
You need the GATE embedded installed
And configure the path in application.config

export TERM=xterm-color
sbt -Dhttp.port=9006 run



STEP 4: Data Acquisitions
-----------------------------------------------
Depends on the other || runs on port 9000 by default 



*---DOCKERIZATION---*
Each Sub component has a Dockerfile at its root directory

Use this file to create a docker file of the subcomponent
Run the dockerized file
