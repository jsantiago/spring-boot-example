To install Gradle:

    brew install gradle

To create Gradle wrapper:

    gradle createWrapper

To run:

    ./gradlew bootRun
    open http://localhost:8080

To run in Tomcat 8:

    ./environment up
    ./environment clean build run
    open http://localhost:9000/spring-boot-example

