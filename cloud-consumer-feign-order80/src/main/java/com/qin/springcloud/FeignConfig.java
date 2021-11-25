package com.qin.springcloud;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author DELL
 * @date 2021/11/24 23:02.
 */
@Configuration
public class FeignConfig {

    /**
     * 配置feign的日志输入级别
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
