#FROM frolvlad/alpine-oraclejdk8:slim
FROM frolvlad/alpine-oraclejre8:latest
VOLUME /tmp
COPY target/cloud-dy-user-0.0.1-SNAPSHOT.jar app.jar
#RUN bash -c 'touch /app.jar'
EXPOSE 8782
ENTRYPOINT ["java","-jar","app.jar"]
