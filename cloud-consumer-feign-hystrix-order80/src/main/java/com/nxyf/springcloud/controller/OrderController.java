package com.nxyf.springcloud.controller;

import com.nxyf.springcloud.service.OrderFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2021
 * @description:
 * @author: myj
 * @create: 2021-01-17 21:59
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderFeignClient orderFeignClient;

    @GetMapping("/consumer/payment/hystrixOk/{id}")
    public String paymentInfo_ok(@PathVariable("id") String id) {
        String infoOk = orderFeignClient.paymentInfo_ok(id);
        return infoOk;
    }

    @GetMapping("/consumer/payment/hystrixTimeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") String id) {
        return orderFeignClient.paymentInfo_timeout(id);
    }
}
