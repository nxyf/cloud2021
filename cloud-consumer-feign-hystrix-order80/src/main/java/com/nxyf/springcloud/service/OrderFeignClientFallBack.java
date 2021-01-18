package com.nxyf.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: cloud2021
 * @description:
 * @author: myj
 * @create: 2021-01-18 21:21
 */
@Component
public class OrderFeignClientFallBack implements OrderFeignClient{
    @Override
    public String paymentInfo_ok(String id) {
        return "OrderFeignClientFallBack";
    }

    @Override
    public String paymentInfo_timeout(String id) {
        return "OrderFeignClientFallBack";
    }
}
