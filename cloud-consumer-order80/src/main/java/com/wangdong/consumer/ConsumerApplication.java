package com.wangdong.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费者
 * @author wangdong
 * @date 2021-01-01
 */
@SpringBootApplication
@MapperScan(value = "com.wangdong.consumer.dao")
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
