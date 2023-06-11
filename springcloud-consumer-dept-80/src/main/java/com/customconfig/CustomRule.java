package com.customconfig;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author SirLi
 */
@Configuration
public class CustomRule {


    @Bean
    public IRule myRule(){
      return  new CustomRandomRule();
    }
}
