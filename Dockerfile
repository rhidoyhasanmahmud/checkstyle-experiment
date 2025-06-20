# Stage 1: Build and Checkstyle
FROM gradle:8.7-jdk21-alpine AS builder
WORKDIR /app

# Copy project files
COPY --chown=gradle:gradle . .

# Run Checkstyle - will fail if violations are found
RUN gradle checkstyleMain checkstyleTest

# If Checkstyle passes, build the jar
RUN gradle bootJar --no-daemon

# Stage 2: Run the application
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built jar
COPY --from=builder /app/build/libs/*.jar app.jar

# Create non-root user
RUN addgroup -S appuser && adduser -S appuser -G appuser
USER appuser

# Run Spring Boot app
CMD ["java", "-jar", "app.jar"]
