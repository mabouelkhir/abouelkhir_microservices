# Use a base image with Java installed
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

LABEL authors="abouelkhir"

# Copy the JAR file built from your project to the container
COPY target/Client-0.0.1-SNAPSHOT.jar /app/Client-0.0.1-SNAPSHOT.jar

# Expose the port the service runs on
EXPOSE 8081

# Define the command to run your application
CMD ["java", "-jar", "Client-0.0.1-SNAPSHOT.jar"]

