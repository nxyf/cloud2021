package com.nxyf.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud2021
 * @description:
 * @author: myj
 * @create: 2021-01-17 20:59
 */
@Service
public class PaymentService {

    public String paymentInfo_ok(String id) {
        return "paymentInfo_ok===========线程池："+Thread.currentThread().getName();
    }

    public String paymentInfo_timeout(String id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "paymentInfo_timeout=============线程池："+Thread.currentThread().getName();
    }
}
