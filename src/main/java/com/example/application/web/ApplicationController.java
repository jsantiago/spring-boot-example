package com.example.application.web;

import com.example.application.domain.Message;
import com.example.application.service.ApplicationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String home() {
        return applicationService.sayHello();
    }

    @RequestMapping(value = "/reverse", method = RequestMethod.POST)
    @ResponseBody
    public Message reverse(@Validated @RequestBody Message message) {
        Message response = new Message();

        if (message != null) {
            if (StringUtils.isNotEmpty(message.getTitle())) {
                response.setTitle(message.getTitle());
            }

            if (StringUtils.isNotEmpty(message.getValue())) {
                String reversedString = StringUtils.reverse(message.getValue());
                response.setValue(reversedString);
            }
        }

        return response;
    }

    @RequestMapping("/foo")
    @ResponseBody
    public String foo() {
        throw new IllegalArgumentException("Server error");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationController.class, args);
    }
}
