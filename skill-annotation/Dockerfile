# Dockerfile for DOBIE Domain Ontologie Based Information Extraction
# 1) Build an image using this docker file. Run the following docker command
#
#    $ docker build -t qualichain/dobie:v1.1.0 .
#
# 2) Test DOBIE in a container. Run the following docker command for testing
#
#    $ docker run --rm -it -p 9006:9006 --name dobie qualichain/dobie:v1.1.0 /bin/bash
#
# 3) DOBIE : 
#
#
# 6) Detach from the container with Ctrl-p Ctrl-q


# Pull base image
#FROM ubuntu:18.04
FROM ubuntu
MAINTAINER Isaiah Mulang' Onando <mulangonando@gmail.com>

# Install Java 8.
RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y  software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update && \
    echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java8-installer && \
    apt-get clean

# Define JAVA_HOME environment variable
ENV \
  WORKDIR="/home/dobie/" \
  # set JAVA OPTIONS
  # provide a random env better suited for headless work such as docker images \
  # http:\/\/www.labouisse.com\/misc\/2014\/06\/19\/tomcat-startup-time-surprises \
  DEFAULT_JAVA_OPTS="-server -Djava.security.egd=file:/dev/./urandom" \
  JAVA_OPTS="-Xms1g -Xmx2g" \
  # configure application port and expose it
  PORT=9006 \
  JAVA_HOME /usr/lib/jvm/java-8-oracle \
  TERM=xterm-color

# Install  network tools (ifconfig, netstat, ping, ip)
RUN apt-get update && \
    apt-get install -y net-tools && \
    apt-get install -y iputils-ping && \
    apt-get install -y iproute2

# Install vi for editing
RUN apt-get update && \
    apt-get install -y vim

RUN export ${TERM}

# Copy OCCRP SSL Certificate
COPY  certs/data.occrp.org.cer $JAVA_HOME/jre/lib/security/

# Install the OCCRP SSL certificate
WORKDIR $JAVA_HOME/jre/lib/security/
RUN keytool -importcert -alias occrp -keystore cacerts -storepass changeit -file data.occrp.org.cer -noprompt

#Install Fuhsen package from the project folder (create a package using "sbt universal:package-zip-tarball" command)
#COPY target/universal/fuhsen-1.1.0.tgz /home/lidakra/

RUN curl -O -J -L https://sourceforge.net/projects/gate/files/gate/8.4.1/gate-8.4.1-build5753-BIN.zip/download
RUN mv gate-8.4.1-build5753-BIN.zip /home/gate-8.4.zip
RUN unzip /home/gate-8.4.zip
RUN rm /home/gate-8.4.zip

EXPOSE ${PORT}

CMD  sbt -Dhttp.port=9006 run


