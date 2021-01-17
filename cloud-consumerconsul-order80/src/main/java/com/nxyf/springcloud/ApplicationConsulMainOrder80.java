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
public class ApplicationConsulMainOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsulMainOrder80.class, args);
    }
}
