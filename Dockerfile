FROM openjdk:8-jre-alpine

WORKDIR /app

COPY var/lib/jenkins/workspace/vikas-cicd/target/audit-service-0.0.1-SNAPSHOT.jar  /app 

EXPOSE 8080

ENTRYPOINT ["java"]

CMD ["-jar", "/usr/local/bin/audit-service-0.0.1-SNAPSHOT.jar"]

