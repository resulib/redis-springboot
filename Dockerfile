FROM gradle:8.0-jdk17 AS build

WORKDIR /app

COPY build.gradle settings.gradle ./
COPY gradle ./gradle

COPY src ./src

RUN gradle build --no-daemon

FROM openjdk:17-jdk

WORKDIR /app

COPY --from=build /app/build/libs/springboot-redis-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
