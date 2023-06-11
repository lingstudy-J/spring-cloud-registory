package com.lingstudy.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author SirLi
 */

@Configuration
public class ConfigBean {

    //配置负责均衡实现RestTemplate
    //IRule
    //RoundRobinRule : 轮询算法
    //RandomRule : 随机
    //AvailabilityFilteringRule : 会先过滤掉崩溃的服务，然后再轮询
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
