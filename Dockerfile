FROM openjdk:11
LABEL maintainer="Alberto-Sanchez"
USER root
ENV spring.application.name ms-reto-bcp
COPY target/retobcp-0.0.1-SNAPSHOT.jar /opt/retobcp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Djava.file.encoding=UTF-8","-jar","/opt/retobcp-0.0.1-SNAPSHOT.jar"]
