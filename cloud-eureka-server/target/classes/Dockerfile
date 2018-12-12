FROM adoptopenjdk/openjdk8:latest
RUN mkdir /opt/app
COPY cloud-eureka-server-1.0-SNAPSHOT.jar /opt/app/app.jar
#EXPOSE 8888:8888
CMD ["java","-jar","/opt/app/app.jar"]