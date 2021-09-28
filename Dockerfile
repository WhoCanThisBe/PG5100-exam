FROM maven:3.6-jdk-11 as builder
WORKDIR /app
COPY ../../../OneDrive/Skole/3.året/5.semester/DevOps%20i%20skyen/05-cd-apprunner-with-docker-main/05-cd-apprunner-with-docker-main/pom.xml .
COPY ../../../OneDrive/Skole/3.året/5.semester/DevOps%20i%20skyen/05-cd-apprunner-with-docker-main/05-cd-apprunner-with-docker-main/src ./src
RUN mvn -B  package

FROM adoptopenjdk/openjdk11:alpine-slim
COPY --from=builder /app/target/*.jar /app/application.jar
ENTRYPOINT ["java","-jar","/app/application.jar"]