package com.nxyf.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud2021
 * @description:
 * @author: myj
 * @create: 2021-01-17 21:49
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OrderFeignClientFallBack.class)
public interface OrderFeignClient {

    @GetMapping("/payment/hystrixOk/{id}")
    public String paymentInfo_ok(@PathVariable("id") String id);

    @GetMapping("/payment/hystrixTimeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") String id);
}
