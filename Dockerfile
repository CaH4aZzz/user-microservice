FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=target/user-microservice-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} microservice.jar

EXPOSE 8123

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/microservice.jar"]