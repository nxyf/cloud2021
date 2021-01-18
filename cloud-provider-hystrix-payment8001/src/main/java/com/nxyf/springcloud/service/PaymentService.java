package com.nxyf.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "payment_timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")//3秒以内是正常业务逻辑
    })
    public String paymentInfo_timeout(String id) {
        try {
            TimeUnit.SECONDS.sleep(3);
            //int i=10/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "paymentInfo_timeout=============线程池："+Thread.currentThread().getName();
    }

    public String payment_timeOutHandler(String id){
        return "服务端***************服务降级返回方法";
    }
}
