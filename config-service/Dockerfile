FROM openjdk:17
COPY build/libs/configserver-0.0.1-SNAPSHOT.jar server.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "server.jar"]