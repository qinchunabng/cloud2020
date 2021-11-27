package com.qin.springcloud.service;

/**
 * description
 *
 * @author DELL
 * @date 2021/11/25 22:54.
 */
public interface PaymentService {

    String paymentInfoSuccess(Integer id);

    String paymentInfoTimeout(Integer id);
}
