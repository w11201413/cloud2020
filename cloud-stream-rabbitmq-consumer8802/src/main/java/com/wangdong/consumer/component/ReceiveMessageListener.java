package com.wangdong.consumer.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListener {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者, {}", message);
    }

}
