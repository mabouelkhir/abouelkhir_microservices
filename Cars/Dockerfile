# Use a base image with Java installed
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

LABEL authors="abouelkhir"

# Copy the JAR file built from your project to the container
COPY target/Cars-0.0.1-SNAPSHOT.jar /app/Cars-0.0.1-SNAPSHOT.jar

# Expose the port the service runs on
EXPOSE 8082

# Define the command to run your application
CMD ["java", "-jar", "Cars-0.0.1-SNAPSHOT.jar"]

