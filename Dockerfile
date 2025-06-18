# Stage 1: Build and Checkstyle
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /app

# Copy the entire project
COPY . .

# Run Checkstyle - will fail if violations found
RUN mvn checkstyle:check

# If check passes, build the jar
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy built jar
COPY --from=builder /app/target/*.jar app.jar

# Run as non-root user
RUN addgroup -S appuser && adduser -S appuser -G appuser
USER appuser

# Run Spring Boot app
CMD ["java", "-jar", "app.jar"]
