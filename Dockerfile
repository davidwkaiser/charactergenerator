FROM --platform=linux/amd64 davidwkaiser/charactergenerator
# RUN ./gradlew clean build -Pvaadin.productionMode
#RUN ls -al /build/libs
# RUN addgroup -S spring && adduser -S spring -G spring
# USER spring:spring
# COPY build/libs/charactergenerator-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]