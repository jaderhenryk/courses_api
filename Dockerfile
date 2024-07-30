FROM amazoncorretto:17.0.12-al2023

WORKDIR /usr/app

COPY target/courses_api-0.0.1-SNAPSHOT.jar ./courses_api.jar

EXPOSE 8080

CMD ["java", "-jar", "courses_api.jar"]
