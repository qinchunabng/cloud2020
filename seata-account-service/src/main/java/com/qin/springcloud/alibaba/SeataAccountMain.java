package com.qin.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 15:35.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeataAccountMain {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMain.class, args);
    }
}
