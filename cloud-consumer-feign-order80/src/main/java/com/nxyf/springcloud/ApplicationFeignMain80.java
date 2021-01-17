package com.nxyf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: cloud2021
 * @description:
 * @author: myj
 * @create: 2021-01-17 10:55
 */
@SpringBootApplication
@EnableFeignClients
public class ApplicationFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationFeignMain80.class, args);
    }
}
