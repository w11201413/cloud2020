package com.wangdong.order.controller;

import com.wangdong.commons.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    @Value("${biz.value}")
    private String value;

    private final RestTemplate restTemplate;

    @GetMapping
    public R order() {
        return R.success(value);
        //return restTemplate.getForObject("http://provider-payment/payment", R.class);
    }

}
