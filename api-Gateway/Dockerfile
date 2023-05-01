#FROM openjdk:17
#EXPOSE 8084
#WORKDIR /app
#COPY target/api-Gateway_docker.jar api-Gateway_docker.jar
#CMD ["java","-jar","/api-Gateway_docker.jar"]
FROM openjdk:17-alpine

ENV JAR_FILE=target/api-Gateway_docker.jar

RUN apk add --no-cache iputils


ADD  $JAR_FILE app.jar

ENTRYPOINT ["java","-jar","/app.jar"]