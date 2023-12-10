# Use a base image with Java installed
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

LABEL authors="abouelkhir"

# Copy the JAR file built from your project to the container
COPY target/API_Gateway-0.0.1-SNAPSHOT.jar /app/API_Gateway-0.0.1-SNAPSHOT.jar

# Expose the port the service runs on
EXPOSE 8086

# Define the command to run your application
CMD ["java", "-jar", "API_Gateway-0.0.1-SNAPSHOT.jar"]

LABEL authors="abouelkhir"
