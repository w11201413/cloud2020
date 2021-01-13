package com.wangdong.provider.service.impl;

import cn.hutool.core.util.IdUtil;
import com.wangdong.provider.service.IMessageProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@RequiredArgsConstructor
@EnableBinding(Source.class) // 定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    // 消息发送管道
    private final MessageChannel output;

    @Override
    public String send() {
        output.send(MessageBuilder.withPayload(IdUtil.fastSimpleUUID()).build());
        return null;
    }
}
