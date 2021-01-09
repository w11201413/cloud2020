package com.wangdong.consumer.service;

import com.wangdong.commons.result.R;
import com.wangdong.consumer.service.fallback.PaymentFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-hystrix-service", path = "/payment", fallback = PaymentFeignFallback.class)
public interface PaymentFeignService {

    @GetMapping("/{id}")
    R findById(@PathVariable("id") Integer id);

    @GetMapping("/{id}/ok")
    R infoOk(@PathVariable("id") Integer id);

    @GetMapping("/{id}/timeout")
    R infoTimeout(@PathVariable("id") Integer id);

    @GetMapping("/{id}/circuitBreaker")
    R circuitBreaker(@PathVariable("id") Integer id);

}
