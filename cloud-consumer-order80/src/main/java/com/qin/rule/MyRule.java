package com.qin.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author DELL
 * @date 2021/11/23 23:12.
 */
@Configuration
public class MyRule {

    @Bean
    public IRule myselfRule(){
        return new RandomRule();
    }
}
