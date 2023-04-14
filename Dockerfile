FROM openjdk:8
EXPOSE 8081
ADD target/project-database-docker.jar project-database-docker.jar
ENTRYPOINT ["java", "-jar", "/project-database-docker.jar"]