FROM openjdk:17

ENV JAR_FILE=target/discovery-server_docker.jar

ADD  $JAR_FILE app.jar

ENTRYPOINT ["java","-jar","/app.jar"]