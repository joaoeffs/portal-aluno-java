FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/portal-aluno-java-1.0.0.jar portal-aluno-java-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "portal-aluno-java-1.0.0.jar"]
