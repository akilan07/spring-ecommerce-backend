# =========================
# 1️⃣ Build stage
# =========================
FROM gradle:8.5-jdk17 AS builder

WORKDIR /app

# Copy build config first (better caching)
COPY build.gradle settings.gradle gradle.properties ./
COPY gradle ./gradle

# Download dependencies
RUN gradle dependencies --no-daemon

# Copy full source
COPY . .

# Build application
# Skip tests (CI runs them separately)
RUN gradle clean build -x test --no-daemon


# =========================
# 2️⃣ Runtime stage (Amazon Corretto)
# =========================
FROM amazoncorretto:17-alpine

WORKDIR /app

# Copy fat JAR
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose Spring Boot port
EXPOSE 8080

# Optional JVM tuning for containers
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75"

# Run app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]