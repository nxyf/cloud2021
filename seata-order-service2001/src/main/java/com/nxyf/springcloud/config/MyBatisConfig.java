package com.nxyf.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.nxyf.springcloud.mapper"})
public class MyBatisConfig {
 
}