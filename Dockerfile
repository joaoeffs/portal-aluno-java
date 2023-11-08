# Usar uma imagem base do OpenJDK
FROM openjdk:11-jdk-slim

# Argumentos que podem ser passados durante a construção, como a versão do JAR
ARG JAR_FILE=target/*.jar

# Copiar o arquivo JAR construído para o contêiner
COPY ${JAR_FILE} app.jar

# Expõe a porta que a aplicação usará
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java","-jar","/app.jar"]
