FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springbackendnew.jar
ENTRYPOINT ["java","-jar","/springbackendnew.jar"]
