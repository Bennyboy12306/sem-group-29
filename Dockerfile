FROM openjdk:latest
COPY ./target/sem-group-project-0.1.0.5-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "sem-group-project-0.1.0.5-jar-with-dependencies.jar"]