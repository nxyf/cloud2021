package com.nxyf.springcloud.service.impl;

import com.nxyf.springcloud.dao.PaymentDao;
import com.nxyf.springcloud.entities.Payment;
import com.nxyf.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: cloud2020
 * @description:
 * @author: myj
 * @create: 2021-01-14 21:09
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
