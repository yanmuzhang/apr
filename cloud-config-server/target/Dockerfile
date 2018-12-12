FROM adoptopenjdk/openjdk8:latest
RUN mkdir /opt/app
COPY cloud-config-server-1.0-SNAPSHOT.jar /opt/app
EXPOSE 8888:8888
CMD ["java","-jar","/opt/app/cloud-config-server-1.0-SNAPSHOT.jar"]