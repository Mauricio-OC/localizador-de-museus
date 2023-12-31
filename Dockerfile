FROM maven:3-openjdk as build-image
WORKDIR /to-build-app
COPY . .
RUN mvn dependency:go-offline clean package -DskipTests
FROM  eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build-image /to-build-app/target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
