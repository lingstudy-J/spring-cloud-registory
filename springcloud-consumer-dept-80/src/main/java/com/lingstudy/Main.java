package com.lingstudy;


import com.customconfig.CustomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author SirLi
 */
@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就能去加载我们自定义Ribbon类，name为eureka注册的application name
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = CustomRule.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}