[![Build Status](https://travis-ci.org/jsantiago/spring-boot-example.svg?branch=master)](https://travis-ci.org/jsantiago/spring-boot-example)


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

To view test results:

    ./gradlew test
    open build/reports/tests/index.html

