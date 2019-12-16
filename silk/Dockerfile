
# Dockerfile for Silk Framework [Adapted for Qualichain's Knowledge Extraction Component]
# 1) Build an image using this docker file. Run the following docker command
#
#    $ docker build -t qualichain/silk-qc .
#
# 2) Test DOBIE in a container. Run the following docker command for testing
#
#    $ docker run --rm -it -p 9005:9005 --name silk-qc qualichain/silk-qc /bin/bash
#
# 3) Detach from the container with Ctrl-p Ctrl-q


# Pull base image

FROM ubuntu:18.04

MAINTAINER Isaiah Mulang' Onando <mulang.onando@gmail.com>

# Install Java 8.

# Install OpenJDK-8
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get clean;

# Fix certificate issues
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;

# Define JAVA_HOME and TERM environment variable -- useful for docker commandline
ENV \
  WORKDIR="/home/silk/" \
  # set JAVA OPTIONS
  # provide a random env better suited for headless work such as docker images \
  # http:\/\/www.labouisse.com\/misc\/2014\/06\/19\/tomcat-startup-time-surprises \
  DEFAULT_JAVA_OPTS="-server -Djava.security.egd=file:/dev/./urandom" \
  JAVA_OPTS="-Xms1g -Xmx2g" \
  # configure application port and expose it
  PORT=9006 \
  JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/ \
  TERM=xterm-color

RUN export TERM
RUN export JAVA_HOME

# Install  network tools (ifconfig, netstat, ping, ip)
RUN apt-get update && \
    apt-get install -y net-tools && \
    apt-get install -y iputils-ping && \
    apt-get install -y iproute2

# Install vi for editing
RUN apt-get update && \
    apt-get install -y vim

# Copy OCCRP SSL Certificate
# COPY  certs/data.occrp.org.cer $JAVA_HOME/jre/lib/security/

# Install the OCCRP SSL certificate
#WORKDIR $JAVA_HOME/jre/lib/security/
#RUN keytool -importcert -alias occrp -keystore cacerts -storepass changeit -file data.occrp.org.cer -noprompt

# INSTALL CURL
RUN apt-get update && \
    apt-get install -y curl && \
    apt-get install -y unzip 
    CMD /bin/bash

#INSTALL SBT
RUN apt-get install -y gnupg2
RUN curl -O -J -L www.scala-lang.org/files/archive/scala-2.12.6.deb
RUN dpkg -i scala-2.12.6.deb
RUN echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list
RUN curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add
RUN apt-get update
RUN apt-get install -y sbt=0.13.17

WORKDIR /home

#COPY THE FILES TO the docker home DIR
RUN mkdir silk
COPY . silk/

# set working dir
WORKDIR ${WORKDIR}
VOLUME "${WORKDIR}"


# expose port
EXPOSE ${PORT}

# start application
CMD sbt -Dhttp.port=9005 "project workbench" run
