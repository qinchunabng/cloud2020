package com.qin.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 15:17.
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.qin.springcloud.alibaba",exclude = DataSourceAutoConfiguration.class)
public class SeataStorageMain {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain.class, args);
    }
}
