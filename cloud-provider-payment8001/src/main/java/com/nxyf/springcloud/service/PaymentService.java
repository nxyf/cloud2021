package com.nxyf.springcloud.service;

import com.nxyf.springcloud.entities.Payment;

/**
 * @program: cloud2020
 * @description:
 * @author: myj
 * @create: 2021-01-14 21:09
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById( Long id);
}
