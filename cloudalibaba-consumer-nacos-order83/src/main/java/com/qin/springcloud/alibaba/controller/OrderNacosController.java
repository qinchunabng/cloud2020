package com.qin.springcloud.alibaba.controller;

import com.qin.springcloud.alibaba.feign.PaymentService;
import com.qin.springcloud.entities.CommonResult;
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

    @Autowired
    private PaymentService paymentService;

    private final String paymentServiceUrl = "nacos-payment-provider";

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") String id){
        return restTemplate.getForObject("http://"+ paymentServiceUrl +"/payment/nacos/" + id, String.class);
    }

    @GetMapping("/consumer/paymentInfo/{id}")
    public CommonResult paymentInfo(@PathVariable("id") Long id){
        return paymentService.paymentInfo(id);
    }
}
