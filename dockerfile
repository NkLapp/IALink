FROM node:18-alpine AS frontend-builder
WORKDIR /app
COPY src/main/webapp/. .
RUN npm install
RUN npm run build

FROM eclipse-temurin:17-jdk-alpine AS backend-builder
WORKDIR /app
COPY . .
COPY --from=frontend-builder /app/build/. /app/src/main/webapp/build/.
RUN ./mvnw package

FROM eclipse-temurin:17-jre-alpine AS runtime
WORKDIR /app
COPY --from=backend-builder /app/target/ialink-0.0.1-SNAPSHOT.jar /app/ialink.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/ialink.jar"]
