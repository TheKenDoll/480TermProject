FROM eclipse-temurin:17-jdk-jammy as build
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar /app/*.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/*.jar" ]
