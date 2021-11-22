package com.qin.springcloud.controller;

import com.qin.springcloud.entities.CommonResult;
import com.qin.springcloud.entities.Payment;
import com.qin.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
}
