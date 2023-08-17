FROM amazoncorretto:11-alpine-jdk
COPY target/*.jar test.jar
ENTRYPOINT ["java","-jar","/test.jar"]