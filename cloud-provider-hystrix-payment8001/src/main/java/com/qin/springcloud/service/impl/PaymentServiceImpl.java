package com.qin.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qin.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

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

    public String paymentInfoTimeoutFallback(Integer id){
        return "当前线程：" + Thread.currentThread().getName() + ",id=" + id + "，请求失败或超时！";
    }
}
