package com.wxy.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroRegister7001 {
    public static void main(String[] args) {
        SpringApplication.run(MicroRegister7001.class,args);
    }
}
