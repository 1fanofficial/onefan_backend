FROM openjdk:21
EXPOSE 8080
ADD target/onefan-docker.jar onefan-docker.jar
ENTRYPOINT ["java","-jar","/onefan-docker.jar"]