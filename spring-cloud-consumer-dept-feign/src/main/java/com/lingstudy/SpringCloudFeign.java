package com.lingstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author SirLi
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.lingstudy.springcloud")
public class SpringCloudFeign {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeign.class,args);
    }
}