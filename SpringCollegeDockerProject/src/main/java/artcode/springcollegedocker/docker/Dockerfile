FROM openjdk:8-jdk-alpine
ENV SPRING_PROFILES_ACTIVE docker
VOLUME /tmp
ADD spring-college-docker-1.0.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
