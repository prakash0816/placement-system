FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/placement-system-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-jar", "-Dspring.profiles.active=prod", "target/placement-system-0.0.1-SNAPSHOT.jar"]
