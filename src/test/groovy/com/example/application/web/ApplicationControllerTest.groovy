package com.example.application.web;

import com.example.application.Application;
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

class ApplicationControllerTest extends Specification {

    @Shared
    @AutoCleanup
    ConfigurableApplicationContext context

    void setupSpec() {
        Future future = Executors.newSingleThreadExecutor().submit(new Callable() {
            @Override
            public ConfigurableApplicationContext call() throws Exception {
                return (ConfigurableApplicationContext) SpringApplication.run(Application.class)
            }
        })
        context = future.get(60, TimeUnit.SECONDS)
    }

    void "should return 'Hello World!'"() {
        when:
        ResponseEntity entity = new RestTemplate().getForEntity("http://localhost:8080", String.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body == 'Hello World!'
    }

}
