package com.nxyf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: cloud2021
 * @description:
 * @author: myj
 * @create: 2021-01-17 20:58
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ApplicationHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationHystrix8001.class, args);
    }
}
