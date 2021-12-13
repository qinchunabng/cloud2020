package com.qin.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/10 22:21.
 */
@RestController
public class OrderNacosController {

    @Autowired
    private RestTemplate restTemplate;

    private final String paymentServiceUrl = "nacos-payment-provider";

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") String id){
        return restTemplate.getForObject("http://"+ paymentServiceUrl +"/payment/nacos/" + id, String.class);
    }
}
