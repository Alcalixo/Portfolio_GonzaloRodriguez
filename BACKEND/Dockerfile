FROM amazoncorretto:17-alpine-jdk // imagen de partida
MAINTAINER GNR // dueño
COPY target/gnr-0.0.1-SNAPSHOT.jar portfolio-gnr.jar // copia el empaquetado del proyecto a github
ENTRYPOINT["java","-jar","/portfolio-gnr.jar"]  // instrucción que se ejecuta primero