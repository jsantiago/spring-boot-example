package com.example.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationService {

    @Autowired
    private ServiceProperties configuration;

    public String sayHello() {
        return "Hello " + configuration.getName() + "!";
    }

}
