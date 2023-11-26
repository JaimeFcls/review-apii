FROM openjdk:17-jdk-alpine

# Cria um diretório 'app' no contêiner
WORKDIR /app

# Copia o JAR para o diretório 'app' no contêiner
COPY target/review-api-0.0.1-SNAPSHOT.jar app.jar

# Define o comando de entrada para a execução do JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
