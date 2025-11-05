# Stage 1: Build the application
FROM eclipse-temurin:17-jdk as builder
WORKDIR /app

# Copy everything
COPY . .

# Give permission to run mvnw
RUN chmod +x mvnw

# Build the jar
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy jar from builder
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
