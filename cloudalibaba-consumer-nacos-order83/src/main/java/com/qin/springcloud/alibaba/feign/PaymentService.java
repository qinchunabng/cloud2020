package com.qin.springcloud.alibaba.feign;

import com.qin.springcloud.alibaba.feign.fallback.PaymentFallbackService;
import com.qin.springcloud.entities.CommonResult;
import com.qin.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/19 18:40.
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/paymentInfo/{id}")
    CommonResult<Payment> paymentInfo(@PathVariable("id") Long id);
}
