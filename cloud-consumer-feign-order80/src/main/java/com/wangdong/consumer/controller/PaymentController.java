package com.wangdong.consumer.controller;

import com.wangdong.commons.result.R;
import com.wangdong.consumer.service.PaymentFeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentFeignService paymentFeignService;

    @GetMapping("/{id}")
    public R findById(@PathVariable Integer id) {
        return paymentFeignService.findById(id);
    }

}
