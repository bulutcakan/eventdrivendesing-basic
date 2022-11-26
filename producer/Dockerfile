FROM openjdk:8-jdk-alpine
MAINTAINER bulutcakan
COPY target/docker-producer-1.0.0.jar docker-producer.jar
ENTRYPOINT ["java","-jar","/docker-producer.jar"]