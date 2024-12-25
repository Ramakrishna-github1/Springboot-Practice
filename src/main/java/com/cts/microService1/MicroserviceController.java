package com.cts.microService1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/microservice1")
public class MicroserviceController {

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return "Welcome to Micro service 1. Today is ::" + LocalDateTime.now();
    }
}
