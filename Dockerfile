FROM adoptopenjdk/openjdk11

LABEL creator=coding404

ARG jarfile=build/libs/k8s-quiz-demo-0.0.1-SNAPSHOT.jar

COPY ${jarfile} /app.jar

CMD ["java", "-jar", "/app.jar"]