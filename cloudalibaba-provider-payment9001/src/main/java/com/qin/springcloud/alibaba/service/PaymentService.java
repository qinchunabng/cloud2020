package com.qin.springcloud.alibaba.service;

import com.qin.springcloud.entities.Payment;

/**
 * description
 *
 * @author qcb
 * @date 2021/11/12 16:53.
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getById(Long id);
}
