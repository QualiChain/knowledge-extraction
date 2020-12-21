# Dockerfile for JobWatch
# 1) Build an image using this docker file. Run the following docker command
#
#    $ docker build -t jobwatch/jobwatch:v1.1.0 .
#
# 2) Test JobWatch in a container. Run the following docker command for testing
#
#    $ docker run --rm -it -p 9000:9000 --name jobwatch jobwatch/jobwatch:v1.1.0 /bin/bash
#
# 3) The JobWatch Service needs API keys to access Job Posting sites. The keys are stored in conf/application.conf
# For security reason the application.conf file on Github does not contain the keys. The config file
# must be provided in a Docker data volume loaded with the config file. As an example copy the config file in 
# a folder in the server host (e.g. /home/jobwatch/jobwatch-conf) then run a container using an image
# already available or a small one like alpine (a small Linux version) mapping the folder with the config file
# in the host to the folder conf/ in the container.
# 
#    $ docker run -d -v /home/jobwatch/jobwatch-conf/application.conf:/home/jobwatch/conf/application.conf:ro \
#                                         --name jobwatch-conf alpine echo "JobWatch Config File"
#
# 4) Start a container with jobwatch using the config file in the data volume
#
#    $ docker run -it -p 9000:9000 --volumes-from jobwatch-conf --name jobwatch jobwatch/jobwatch:v1.1.0 /bin/bash 
#
# 5) Within the container check that the application.conf is right and start the jobwatch  ./bin/jobwatch
#
# 6) Detach from the container with Ctrl-p Ctrl-q


# Pull base image

FROM ubuntu:18.04
MAINTAINER Isaiah Mulang' Onando <mulangonando@gmail.com>

# Install Java 8.

#RUN apt-get update && \
#    apt-get upgrade -y && \
#    apt-get install -y  software-properties-common && \
#    add-apt-repository ppa:webupd8team/java && \
#    add-apt-repository ppa:linuxuprising/java && \
#    apt-get update && \
#    #echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
#    apt install oracle-java10-set-default && \
#    apt-get clean

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
  WORKDIR="/home/dobie/" \
  # set JAVA OPTIONS
  # provide a random env better suited for headless work such as docker images \
  # http:\/\/www.labouisse.com\/misc\/2014\/06\/19\/tomcat-startup-time-surprises \
  DEFAULT_JAVA_OPTS="-server -Djava.security.egd=file:/dev/./urandom" \
  JAVA_OPTS="-Xms1g -Xmx2g" \
  # configure application port and expose it
  PORT=9000 \
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
RUN curl -O -J -L www.scala-lang.org/files/archive/scala-2.11.8.deb
RUN dpkg -i scala-2.11.8.deb
RUN echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list
RUN curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add
RUN apt-get update
RUN apt-get install -y sbt

WORKDIR /home

#COPY THE FILES TO the docker home DIR
RUN mkdir jobwatch
COPY . jobwatch/ 

WORKDIR ./jobwatch/

EXPOSE ${PORT}

CMD sbt run
