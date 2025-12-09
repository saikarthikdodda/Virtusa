package com.java.eurekaserverv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerVApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerVApplication.class, args);
    }

}
