# Use uma imagem base do Java 8
FROM openjdk:8-jdk-alpine

# Crie um diretório para armazenar os arquivos temporários da aplicação
VOLUME /tmp

# Copie o arquivo .jar da sua aplicação para a imagem Docker
COPY target/review-api-0.0.1-SNAPSHOT.jar app.jar

# Defina o comando de entrada para iniciar a sua aplicação
ENTRYPOINT ["java","-jar","/app.jar"]
