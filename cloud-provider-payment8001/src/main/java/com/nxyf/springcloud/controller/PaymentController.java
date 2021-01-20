package com.nxyf.springcloud.controller;

import com.nxyf.springcloud.entities.CommonResult;
import com.nxyf.springcloud.entities.Payment;
import com.nxyf.springcloud.exception.GlobleException;
import com.nxyf.springcloud.service.PaymentService;
import com.nxyf.springcloud.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: springcloud
 * @description:
 * @author: myj
 * @create: 2021-01-14 21:16
 */
@RestController
@Slf4j
@Api(value = "支付接口value",tags = "支付接口tags")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @ApiOperation(value = "新增接口")
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("******插入数据库结果" + i);
        if (i > 0) {
            return new CommonResult(200, "成功,serverPort"+serverPort, i);
        } else {
            return new CommonResult(444, "失败,serverPort"+serverPort, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询数据库结果" + payment);
        if (!ObjectUtils.isEmpty(payment)) {
            return new CommonResult(200, "成功,serverPort"+serverPort, payment);
        } else {
            return new CommonResult(444, "失败,serverPort"+serverPort, null);
        }
    }

    @GetMapping("/discoveryClient")
    public CommonResult discoveryClient() {
        List<String> services = discoveryClient.getServices();
        services.stream().forEach(service->System.out.println(service));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.stream().forEach(instance->System.out.println(instance.getInstanceId()));
        return new CommonResult(200,"成功",services);
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/lb/r")
    public R r() {
        if (!StringUtils.isEmpty(serverPort)) {
            throw new GlobleException("服务异常",500);
        }
        return R.ok().put("serverPort",serverPort);
    }
}
