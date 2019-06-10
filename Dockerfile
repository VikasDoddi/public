FROM openjdk:8-jre-alpine

WORKDIR /app

COPY /target/audit-service-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java"]

CMD ["-jar", "audit-service-0.0.1-SNAPSHOT.jar"]

