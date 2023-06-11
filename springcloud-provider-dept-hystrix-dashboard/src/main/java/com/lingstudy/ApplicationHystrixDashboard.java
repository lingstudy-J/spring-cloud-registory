package com.lingstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author SirLi
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableHystrixDashboard
public class ApplicationHystrixDashboard {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationHystrixDashboard.class, args);
    }
}
