package com.nxyf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description:
 * @author: myj
 * @create: 2021-01-14 22:29
 */
@RestController
@Slf4j
public class OrderController {

    private static final String INVOKE_URL = "http://consul-provider-payment/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul")
    public String getPaymentZk() {
        String result = restTemplate.getForObject(INVOKE_URL + "payment/consul", String.class);
        return result;
    }
}
