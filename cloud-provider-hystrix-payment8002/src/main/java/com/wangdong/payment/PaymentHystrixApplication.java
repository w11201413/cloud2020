package com.wangdong.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 支付服务
 * @author wangdong
 * @date 2020-12-15
 */
@EnableEurekaClient
@EnableCircuitBreaker
@MapperScan(value = "com.wangdong.payment.dao")
@SpringBootApplication
public class PaymentHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixApplication.class, args);
    }

}
