package com.qin.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qin.springcloud.alibaba.service.PaymentService;
import com.qin.springcloud.entities.CommonResult;
import com.qin.springcloud.entities.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/10 21:59.
 */
@RestController
public class PaymentController {

    private final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") String id){
        return "nacos registry, server port: " + serverPort + ", id : " + id;
    }

    @GetMapping("/paymentInfo/{id}")
    @SentinelResource(value = "paymentInfo", blockHandler = "paymentInfoBlockHandler")
    public CommonResult<Payment> paymentInfo(@PathVariable("id") Long id){
        Payment payment = paymentService.getById(id);
        if(payment == null){
            throw new RuntimeException("无id为" + id + "的记录");
        }
        return new CommonResult(200, "server port:" + serverPort, payment);
    }

    public CommonResult paymentInfoBlockHandler(Long id, BlockException e){
        logger.error(e.getMessage(), e);
        return new CommonResult(444, "id:" + id, new Payment());
    }
}
