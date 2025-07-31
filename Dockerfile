FROM eclipse-temurin:17
COPY target/jenkins.jar jenkin.jar
CMD ["java","-jar","jenkin.jar"]