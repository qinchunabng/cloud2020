package com.qin.springcloud.alibaba.feign.fallback;

import com.qin.springcloud.alibaba.feign.PaymentService;
import com.qin.springcloud.entities.CommonResult;
import com.qin.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/19 18:44.
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentInfo(Long id) {
        return new CommonResult<>(445, "id:" + id, new Payment());
    }
}
