FROM amazoncorretto:11-alpine-jdk  
MAINTAINER Facundo
COPY target/Portfolio-0.0.1-SNAPSHOT.jar  Portfolio-app.jar
ENTRYPOINT ["java","-jar","/Portfolio-app.jar"]