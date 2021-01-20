package com.nxyf.springcloud.controller;

import com.nxyf.springcloud.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud
 * @description:
 * @author: myj
 * @create: 2021-01-20 19:57
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public R getConfigInfo() {
        return R.ok().put("info", configInfo);
    }

    @GetMapping("/info")
    public R info(){
        return R.ok();
    }
}
