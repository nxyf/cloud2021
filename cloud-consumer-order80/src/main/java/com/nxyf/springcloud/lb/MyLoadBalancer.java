package com.nxyf.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program: cloud2020
 * @description:
 * @author: myj
 * @create: 2021-01-17 09:20
 */
public interface MyLoadBalancer {

    public ServiceInstance instance(List<ServiceInstance> instances);
}
