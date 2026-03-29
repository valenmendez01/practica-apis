# Etapa 1: Construcción (Build)
# Usamos una imagen de Maven que ya incluye Eclipse Temurin 17
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar el archivo de configuración y el código fuente
COPY pom.xml .
COPY src ./src

# Compilar el proyecto omitiendo los tests
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Runtime)
# Usamos el JRE de Eclipse Temurin 17, que es más ligero y seguro para producción
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copiar el JAR generado desde la etapa anterior
COPY --from=build /app/target/tpo-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de Spring Boot
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]