package com.lingstudy;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author SirLi
 */

@SpringBootApplication
@EnableEurekaClient
public class DeptProvider_8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001.class,args);
    }

    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> hystrixMetricsStreamServlet(){
        ServletRegistrationBean<HystrixMetricsStreamServlet> bean = new ServletRegistrationBean<>(new HystrixMetricsStreamServlet());
        bean.addUrlMappings("/actuator/hystrix.stream");
        return bean;
    }

}
