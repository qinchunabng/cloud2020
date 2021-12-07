package com.qin.springcloud.controller;

import com.qin.springcloud.entities.CommonResult;
import com.qin.springcloud.entities.Payment;
import com.qin.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * description
 *
 * @author qcb
 * @date 2021/11/12 16:56.
 */
@RestController
public class PaymentController {

    private final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        logger.info("****** 插入结果:{}", result);
        if(result > 0){
            return new CommonResult(200, "插入成功", result);
        }else{
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id){
        Payment payment = paymentService.getById(id);
        if(payment != null){
            return new CommonResult<>(200, "查询成功,port:" + port, payment);
        }else{
            return new CommonResult<>(444,"没有对应记录,port:" + port);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            logger.info("****** service:{}", service);
        }

        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : instanceList){
            logger.info(instance.getServiceId() + "\t" + instance.getHost() + "\t"  + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return discoveryClient;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }


    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi, I am zipkin server fallback.";
    }
}
