package com.wangxj.springcloud.service.impl;

import com.wangxj.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wangxj
 * @date 2020/5/4 17:43
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
    //消息发送管道
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        System.out.println("serial : " + s);
        return null;
    }
}
