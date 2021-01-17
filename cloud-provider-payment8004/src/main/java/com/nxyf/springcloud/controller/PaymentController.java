package com.nxyf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: cloud2020
 * @description:
 * @author: myj
 * @create: 2021-01-16 08:27
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/paymentZk")
    public String paymentZk() {
        return "springcloud with zookeeper serverPort:"+serverPort+ UUID.randomUUID().toString();
    }
}
