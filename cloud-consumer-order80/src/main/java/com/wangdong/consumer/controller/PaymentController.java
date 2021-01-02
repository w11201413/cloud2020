package com.wangdong.consumer.controller;

import com.wangdong.commons.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 支付信息
 * @author wangdong
 * @date 2021-01-02
 */
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    private final RestTemplate restTemplate;

    @GetMapping("/{id}")
    public R payment(@PathVariable Integer id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id, R.class);
    }

}
