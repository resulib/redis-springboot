FROM openjdk:17-jdk-alpine
COPY build/libs/springboot-redis-0.0.1-SNAPSHOT.jar springboot-redis-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "springboot-redis-0.0.1-SNAPSHOT.jar"]