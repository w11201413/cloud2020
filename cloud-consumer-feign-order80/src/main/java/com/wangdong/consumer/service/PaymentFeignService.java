package com.wangdong.consumer.service;

import com.wangdong.commons.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping("/payment/{id}")
    R findById(@PathVariable("id") Integer id);
}
