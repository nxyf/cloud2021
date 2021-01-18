package com.nxyf.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
@DefaultProperties(defaultFallback = "payment_GlobalFallBachMethod")
public class OrderController {

    @Autowired
    private OrderFeignClient orderFeignClient;

    @GetMapping("/consumer/payment/hystrixOk/{id}")
    public String paymentInfo_ok(@PathVariable("id") String id) {
        String infoOk = orderFeignClient.paymentInfo_ok(id);
        return infoOk;
    }

    //    @HystrixCommand(fallbackMethod = "payment_timeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")//3秒以内是正常业务逻辑
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrixTimeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") String id) {
        return orderFeignClient.paymentInfo_timeout(id);
    }

    public String payment_timeOutHandler(@PathVariable("id") String id) {
        return "消费端**************服务降级返回方法";
    }

    public String payment_GlobalFallBachMethod() {
        return "全局服务降级方法";
    }
}
