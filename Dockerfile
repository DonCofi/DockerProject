FROM maven:3.6.3-jdk-11 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install -DskipTests


FROM openjdk:8u131-jre

WORKDIR /usr/local/bin

COPY --from=build /app/target/Project3_Basic_SpringBoot_JAR-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java", "-jar", "myapp.jar"]