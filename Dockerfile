FROM openjdk:17

EXPOSE 8080

ADD target/medicalservices-0.0.1-SNAPSHOT.jar medicalservices-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "medicalservices-0.0.1-SNAPSHOT.jar"]
