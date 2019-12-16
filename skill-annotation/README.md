Skill Annotation Tool
=================================
This service is able to annotate the skills from a job posting description using a Ontology approach.

## Docker
1) Build an image using this docker file. Run the following docker command
	
	$ docker build -t qualichain/dobie:v1.1.0 .

2) Test DOBIE in a container. Run the following docker command for testing

	$ docker run --rm -it -p 9006:9006 --name dobie qualichain/dobie:v1.1.0 /bin/bash

3) Detach from the container with Ctrl-p Ctrl-q



## Dependencies
This project depends on the following software

* JDK 1.8
* Play Web Framework 2.5.x: https://www.playframework.com/download
* Gate Embedded: https://gate.ac.uk/download/ 

## IDE support 
The quick and easy way to start compiling, running and coding is to use "activator ui".
However, you can also set up your favorits Java IDE (Eclipse or IntellJ Idea). https://www.playframework.com/documentation/2.5.x/IDE
