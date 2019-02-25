FROM openjdk:8
EXPOSE 8080
ADD build/libs/desafioacidlabs-0.0.1.jar desafioacidlabs-0.0.1.jar
ENTRYPOINT ["java","-jar","/desafioacidlabs-0.0.1.jar"]