package com.qin.springcloud.service.impl;

import com.qin.springcloud.dao.PaymentDao;
import com.qin.springcloud.entities.Payment;
import com.qin.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author qcb
 * @date 2021/11/12 16:54.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getById(Long id){
        return paymentDao.getById(id);
    }
}
