#Multistage build
#För att tillfälliga filer som vi inte vill skicka med till imagen ska följa med
#Den här kallar vi för Build
FROM maven:3-eclipse-temurin-25-alpine AS build
WORKDIR /build
COPY src/ src/
COPY pom.xml pom.xml
RUN mvn compile

#För att köra java-applikationen
FROM eclipse-temurin:25-jre-alpine
#Copy SimpleServer from host to image
#IStället för att kopiera från lokala filsystemet
COPY --from=build build/target/classes/org/example/socket/SimpleServer.class /app/org/example/socket/SimpleServer.class
ENTRYPOINT ["java", "-classpath", "/app", "org.example.socket.SimpleServer"]