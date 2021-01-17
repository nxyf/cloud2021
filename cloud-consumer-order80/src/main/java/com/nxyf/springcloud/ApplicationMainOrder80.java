package com.nxyf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: cloud2020
 * @description:
 * @author: myj
 * @create: 2021-01-14 22:26
 */
@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class ApplicationMainOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMainOrder80.class, args);
    }
}
