# Use a base image with Java installed
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

LABEL authors="abouelkhir"

# Copy the JAR file built from your project to the container
COPY target/Eureka_Server-0.0.1-SNAPSHOT.jar /app/Eureka_Server-0.0.1-SNAPSHOT.jar

# Expose the port the service runs on
EXPOSE 8761

# Define the command to run your application
CMD ["java", "-jar", "Eureka_Server-0.0.1-SNAPSHOT.jar"]

