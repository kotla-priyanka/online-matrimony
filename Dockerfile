FROM openjdk:8
ADD target/matrimony-cg-0.0.1-SNAPSHOT.jar matrimony-cg-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","matrimony-cg-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080