package com.nxyf.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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



    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }


}
