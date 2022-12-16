FROM gcr.io/distroless/java17-debian11
EXPOSE 8080
WORKDIR /opt/todoApp
COPY target/*.jar .
CMD ["springboot-webFlux-TodoApp-0.0.1-SNAPSHOT.jar"]
