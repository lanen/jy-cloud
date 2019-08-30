#FROM adoptopenjdk/openjdk8:jre8u222-b10
FROM openjdk:8u222-jre

WORKDIR /opt/cas

COPY etc /etc

COPY target/cas.war /cas.war

ENTRYPOINT  java -jar -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap \
  -XX:MaxRAMFraction=2 -XshowSettings:vm \
  /cas.war
  #-Djavax.net.debug=ssl \
  #-Djavax.net.ssl.trustStoreType=PKCS12 \

