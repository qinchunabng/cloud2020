package com.qin.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qin.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * description
 *
 * @author DELL
 * @date 2021/11/25 22:55.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    @Override
    public String paymentInfoSuccess(Integer id) {
        return "当前线程：" + Thread.currentThread().getName() + ",id=" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @Override
    public String paymentInfoTimeout(Integer id){
//        int i = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentInfoSuccess(id);
    }

    /**
     * 熔断服务
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少后熔断
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0){
            throw new RuntimeException("****** id不能为负数");
        }
        String serialNumber = UUID.randomUUID().toString();
        return Thread.currentThread().getName() + ",调用成成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Integer id){
        return "id不能为负数，请检查！";
    }

    public String paymentInfoTimeoutFallback(Integer id){
        return "当前线程：" + Thread.currentThread().getName() + ",id=" + id + "，请求失败或超时！";
    }


}
