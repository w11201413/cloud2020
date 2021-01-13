package com.wangdong.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RabbitMqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqConsumerApplication.class, args);
    }

}
