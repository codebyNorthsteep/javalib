#För att köra java-applikationen
FROM eclipse-temurin:25-jre-alpine


ENTRYPOINT ["java", "-classpath", "org.example.socket.SimpleServer"]