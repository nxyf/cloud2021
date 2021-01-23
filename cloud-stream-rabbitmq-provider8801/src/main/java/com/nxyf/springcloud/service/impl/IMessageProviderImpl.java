package com.nxyf.springcloud.service.impl;

import com.nxyf.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @program: springcloud
 * @description:
 * @author: myj
 * @create: 2021-01-23 08:08
 */
@EnableBinding(Source.class)//定义消息推送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//消息发送通道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("发送消息成功");
        return "发送消息成功";
    }
}
