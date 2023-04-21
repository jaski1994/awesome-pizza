FROM maven:3.9.0-eclipse-temurin-17-alpine
WORKDIR /workspace/app

COPY . .
EXPOSE 8080

CMD mvn spring-boot:run
