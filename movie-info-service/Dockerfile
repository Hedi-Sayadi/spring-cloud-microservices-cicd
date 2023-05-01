## Use the official OpenJDK 17 image as a parent image
#FROM openjdk:17
## Expose port 8081
#EXPOSE 8082
##ADD target/movie-catalog-service_docker.jar movie-catalog-service_docker.jar
## Set the working directory to /app
#WORKDIR /app
## Copy the  JAR file into the container
#COPY target/movie-info-service_docker.jar movie-info-service_docker.jar
## Define the command to run the application when the container starts
#CMD ["java","-jar","/movie-info-service_docker.jar"]
##ADD support remote source but COPY dont do this ( just from local )
FROM openjdk:17

ENV JAR_FILE=target/movie-info-service_docker.jar

ADD  $JAR_FILE app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
