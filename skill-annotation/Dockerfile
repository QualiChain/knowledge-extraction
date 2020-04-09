# Dockerfile for DOBIE Domain Ontologie Based Information Extraction
# 1) Build an image using this docker file. Run the following docker command
#
#    $ docker build . -f Dockerfile -t qualichain/dobie:v1.1.0.
#
# 2) Test DOBIE in a container. Run the following docker command for testing
#
#    $ docker run --rm -it -p 5000:5000 --name dobie qualichain/dobie:v1.1.0
#
# 3) Detach from the container with Ctrl-p Ctrl-q

FROM openjdk:8-jdk as builder

COPY . /build
WORKDIR /build
RUN \
  echo "Install Maven 3.3.x" \
  && curl -sL https://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz | tar -xz -C /opt \
  && echo "Link current Maven" \
  && ln -s /opt/apache-maven-3.3.9 /opt/maven \
  && echo "\ncurrent maven version:" \
  && /opt/maven/bin/mvn --version \
  && echo "install yarn" \
  && apt-get update -y \
  && apt-get install -y apt-transport-https curl \
  && curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add - \
  && echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list \
  && apt-get update -y \
  && curl -sL https://deb.nodesource.com/setup_9.x | bash - \
  && apt-get install -y nodejs yarn \
  && curl -L https://www.npmjs.com/install.sh | sh \
  && echo "\ncurrent yarn version:" \
  && npm install -g npm \
  && yarn --version \
  && echo "fetch jai-core to fix bug with missing maven artifacts" \
  && /opt/maven/bin/mvn dependency:get -DremoteRepositories=http://maven.geotoolkit.org -Dartifact=javax.media:jai_core:1.1.3 -Ddest=/tmp
#RUN \
#  ./sbt "project workbench" universal:package-zip-tarball || echo "" \
#  && ./sbt "project workbench" universal:package-zip-tarball || echo ""

FROM openjdk:8u151-jre

RUN mkdir /opt/dobie

RUN apt-get update && \
    apt-get install -y --no-install-recommends p7zip-full && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* && \
    7z -h

ENV \
  DOBIE_HOME="/opt/dobie" \
  # WORKDIR=${DOBIE_HOME} \
  # set JAVA OPTIONS
  # provide a random env better suited for headless work such as docker images \
  # http:\/\/www.labouisse.com\/misc\/2014\/06\/19\/tomcat-startup-time-surprises \
  DEFAULT_JAVA_OPTS="-server -Djava.security.egd=file:/dev/./urandom" \
  JAVA_OPTS="-Xms1g -Xmx2g" \
  # configure application port and expose it
  PORT=5000 \
  SERVER_CONTEXTPATH="/"

#CMD ["COPY","Executable\ JAR/skill-annotation-1.0-SNAPSHOT-jar-with-dependencies.jar", ${DOBIE_HOME}]
#CMD ["COPY","Executable\ JAR/gate", ${DOBIE_HOME}]
#CMD ["COPY","Executable\ JAR/Course_Description", ${DOBIE_HOME}]
#CMD ["COPY","Executable\ JAR/readme.txt", ${DOBIE_HOME}]

COPY ./Executable_JAR/ /opt/dobie/

#RUN ls /opt/dobie/

WORKDIR ./opt/dobie/

RUN ls -lh

RUN pwd

RUN 7z e ./skill-annotation-1.0-SNAPSHOT-jar-with-dependencies.jar.7z
RUN rm ./skill-annotation-1.0-SNAPSHOT-jar-with-dependencies.jar.7z
#RUN rm -rf Executable_JAR

EXPOSE 5000

CMD java -jar skill-annotation-1.0-SNAPSHOT-jar-with-dependencies.jar "gate"
