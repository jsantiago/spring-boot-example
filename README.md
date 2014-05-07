[![Build Status](https://travis-ci.org/jsantiago/spring-boot-example.svg?branch=master)](https://travis-ci.org/jsantiago/spring-boot-example)


To install Gradle:

    brew install gradle

To create Gradle wrapper:

    gradle createWrapper

To run:

    ./gradlew bootRun
    ./ping.sh --spring-boot

To run in Tomcat:

    ./environment up
    ./environment clean build run
    ./ping.sh --war

To create an executable jar:

    ./gradlew clean build
    java -jar build/libs/spring-boot-example.jar

To view test results:

    ./gradlew test
    open build/reports/tests/index.html

