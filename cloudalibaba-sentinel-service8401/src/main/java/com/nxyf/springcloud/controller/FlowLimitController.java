package com.nxyf.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nxyf.springcloud.handler.GlobalException;
import com.nxyf.springcloud.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }


    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey",blockHandler = "failMethod")
    public String hotKey(@RequestParam(value = "p1",required = false) String p1,
                         @RequestParam(value = "p2",required = false) String p2) {

        return "hotKey";
    }

    public String failMethod(BlockException exception) {
        return "sentinel热点key降级熔断";
    }

    @GetMapping("/globalException")
    @SentinelResource(value = "globalException",blockHandlerClass = GlobalException.class,blockHandler = "exceptionHandler2")
    public R globalException() {
        return R.ok().put("data", "globalException");
    }
}