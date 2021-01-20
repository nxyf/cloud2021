package com.nxyf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: springcloud
 * @description:
 * @author: myj
 * @create: 2021-01-16 08:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainZK80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainZK80.class, args);
    }
}
