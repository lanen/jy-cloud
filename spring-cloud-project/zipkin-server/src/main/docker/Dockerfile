FROM adoptopenjdk/openjdk8:jre8u222-b10

COPY target/zipkin-server-0.0.1-SNAPSHOT.jar /opt/app.jar

ENTRYPOINT ["java", "-jar", "/opt/app.jar"]

