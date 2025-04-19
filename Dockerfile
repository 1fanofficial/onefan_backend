FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
EXPOSE 8080
COPY --from=build /app/target/onefan-docker.jar onefan-docker.jar
ENTRYPOINT ["java","-jar","/onefan-docker.jar"]