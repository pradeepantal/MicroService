FROM java:8
VOLUME /tmp
RUN mkdir /app
ADD configuration-service-1.0.0.BUILD-SNAPSHOT.jar /app/app.jar
ADD runboot.sh /app/
RUN bash -c 'touch /app/app.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
EXPOSE 8888
CMD /app/runboot.sh