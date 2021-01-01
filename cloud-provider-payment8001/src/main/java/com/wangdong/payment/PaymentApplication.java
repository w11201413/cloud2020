package com.wangdong.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 支付服务
 * @author wangdong
 * @date 2020-12-15
 */
@SpringBootApplication
@MapperScan(value = "com.wangdong.payment.dao")
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

}
