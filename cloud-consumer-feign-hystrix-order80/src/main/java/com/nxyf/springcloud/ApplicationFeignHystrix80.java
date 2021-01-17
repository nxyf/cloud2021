package com.nxyf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: cloud2021
 * @description:
 * @author: myj
 * @create: 2021-01-17 21:47
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ApplicationFeignHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationFeignHystrix80.class, args);
    }
}
