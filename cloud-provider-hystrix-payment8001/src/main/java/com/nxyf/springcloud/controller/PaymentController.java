package com.nxyf.springcloud.controller;

import com.nxyf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2021
 * @description:
 * @author: myj
 * @create: 2021-01-17 21:03
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrixOk/{id}")
    public String paymentInfo_ok(@PathVariable("id") String id) {
        String infoOk = paymentService.paymentInfo_ok(id);
        log.info(infoOk);
        return infoOk;
    }
    @GetMapping("/payment/hystrixTimeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") String id) {
        String infoOk = paymentService.paymentInfo_timeout(id);
        log.info(infoOk);
        return infoOk;
    }

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }


}
