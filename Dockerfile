# 1️⃣ Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 2️⃣ Run stage
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Environment variable for port
ENV PORT=8080
EXPOSE 8080

# Run your Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
