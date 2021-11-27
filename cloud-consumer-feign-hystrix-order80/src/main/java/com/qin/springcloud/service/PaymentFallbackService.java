package com.qin.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author DELL
 * @date 2021/11/27 21:38.
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfoSuccess(Integer id) {
        return "PaymentInfoSuccess fallbak";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "PaymentInfoTimeout fallback";
    }
}
