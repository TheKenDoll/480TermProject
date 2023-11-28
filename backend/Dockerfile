FROM eclipse-temurin:17-jdk-focal as package
WORKDIR /app
COPY . .
RUN mvn package

FROM eclipse-temurin:17-jdk-focal as production
WORKDIR /app
COPY --from=package /app/target/*.jar .
CMD ["java", "-jar", "app.jar"]


EXPOSE 8080