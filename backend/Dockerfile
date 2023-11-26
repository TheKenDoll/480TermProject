FROM eclipse-temurin:17-jdk-focal as build
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src

FROM build as test
RUN ./mvnw test

EXPOSE 8080