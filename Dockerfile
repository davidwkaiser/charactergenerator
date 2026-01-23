FROM openjdk:23
# RUN ./gradlew clean build -Pvaadin.productionMode
COPY build/libs/charactergenerator-0.0.1-SNAPSHOT.jar app.jar   
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]