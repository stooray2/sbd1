FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim

EXPOSE 8081

COPY --from=target /target/SpringAPIDemo1-0.0.1 api1.jar

ENTRYPOINT ["java", "-jar", "api1.jar"]