FROM adoptopenjdk/openjdk8:jre8u222-b10

WORKDIR /opt/cas

COPY setup-jre-cacert.sh /setup-jre-cacert.sh

COPY etc /etc

COPY cas.war /cas.war

#COPY /cacerts /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/cacerts

RUN chmod +x /setup-jre-cacert.sh && sh /setup-jre-cacert.sh /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/cacerts

ENTRYPOINT  java -jar -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=2 -XshowSettings:vm /cas.war
