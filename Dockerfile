########################################################
# Dockerfile to build lana-webapp
########################################################
FROM paintface07/minimal-java

RUN java -version
#RUN apk add nodejs nodejs-npm curl && node -v && npm -v
#RUN npm install -g @angular/cli@1.2.6

RUN git clone https://github.com/Paintface07/proprietary-hello-world.git

ENV PROJECT_ROOT /proprietary-hello-world
#ENV FRONTEND_ROOT ${PROJECT_ROOT}/src/main/webapp/

#RUN cd ${FRONTEND_ROOT} && npm install && ng build --base-href /lana/
RUN cd ${PROJECT_ROOT}/ && mvn install

EXPOSE 8080

ENTRYPOINT java -jar ${PROJECT_ROOT}/target/proprietary-hello-world.jar
