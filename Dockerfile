FROM openjdk:17-oracle
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/megaverse-0.0.1.jar
ADD ${JAR_FILE} megaverse.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/megaverse.jar"]