# Use OpenJDK as base image
FROM openjdk:17-jdk-alpine

# Set environment variables
ENV APP_HOME=/app

# Create and set working directory
WORKDIR $APP_HOME

# Copy the jar file (adjust target if needed)
COPY target/clinic-management-system.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
