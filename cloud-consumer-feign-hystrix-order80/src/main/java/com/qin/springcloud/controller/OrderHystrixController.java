package com.qin.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qin.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author DELL
 * @date 2021/11/27 18:38.
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoSuccess(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfoSuccess(id);
    }

//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallback",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfoTimeout(id);
    }

    public String paymentInfoTimeoutFallback(Integer id){
        return "服务运行出错或者超时，请检查！";
    }

    public String defaultFallback(){
        return "全局fallback方法";
    }
}
