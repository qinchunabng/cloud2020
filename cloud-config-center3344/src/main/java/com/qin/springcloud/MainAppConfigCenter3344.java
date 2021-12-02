package com.qin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * description
 *
 * @author DELL
 * @date 2021/11/30 23:00.
 */
@SpringBootApplication
@EnableConfigServer
public class MainAppConfigCenter3344 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppConfigCenter3344.class, args);
    }
}
