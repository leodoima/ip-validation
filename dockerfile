FROM gradle:jdk17 as gradleimage
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN ./gradlew clean build jar

FROM openjdk:17
COPY --from=gradleimage /home/gradle/source/build/libs/ip-validation.jar /app/
WORKDIR /app
ENTRYPOINT ["java", "-jar", "ip-validation.jar"]