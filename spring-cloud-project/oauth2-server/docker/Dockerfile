FROM openjdk:8-jre-alpine

RUN mkdir -p /opt/cas

COPY etc/cas /etc/cas
COPY etc/cas/config /etc/cas/config

COPY cas.war /opt/cas/cas.war

COPY setup-jre-cacert.sh /opt/cas/setup-jre-cacert.sh

#RUN ls /usr/lib/jvm/java-1.8-openjdk/jre/lib/security
RUN chmod +x /opt/cas/setup-jre-cacert.sh && sh /opt/cas/setup-jre-cacert.sh /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/cacerts

WORKDIR /opt/cas

EXPOSE 8443

ENTRYPOINT ["java","-jar", "/opt/cas/cas.war"]



