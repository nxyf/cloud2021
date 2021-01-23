package com.nxyf.springcloud.controller;

import com.nxyf.springcloud.service.IMessageProvider;
import com.nxyf.springcloud.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description:
 * @author: myj
 * @create: 2021-01-23 08:22
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public R sendMessage() {
        String result=iMessageProvider.send();
        return R.ok().put("data",result);
    }
}
