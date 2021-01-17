package com.nxyf.springcloud.controller;

import com.nxyf.springcloud.entities.CommonResult;
import com.nxyf.springcloud.service.PaymentFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2021
 * @description:
 * @author: myj
 * @create: 2021-01-17 11:03
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignClient paymentFeignClient;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        CommonResult commonResult = paymentFeignClient.getPaymentById(id);
        return commonResult;
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        //openfeign底层ribbon+resttemplate 客户端默认等待1秒
        return paymentFeignClient.paymentFeignTimeOut();
    }
}
