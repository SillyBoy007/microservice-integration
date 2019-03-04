package com.wxy.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.wxy.micro")
@EnableFeignClients(basePackages = {"com.wxy.micro"})
public class AdminSystem8001 {
    public static void main(String[] args) {
        SpringApplication.run(AdminSystem8001.class,args);
    }
}
