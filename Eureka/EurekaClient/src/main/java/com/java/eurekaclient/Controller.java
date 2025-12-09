package com.java.eurekaclient;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value = "/")
    public String compile() {
        return "Welcome to Eureka Client";

    }

    @GetMapping(value = "/test")
    public String test() {
        return "Test Eureka Client";
    }

}
