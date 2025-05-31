FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar ./data-service.jar

ENTRYPOINT ["java", "-jar", "/app/data-service.jar"]