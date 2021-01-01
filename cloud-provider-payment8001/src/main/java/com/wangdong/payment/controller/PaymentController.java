package com.wangdong.payment.controller;

import com.wangdong.payment.entities.Payment;
import com.wangdong.payment.result.R;
import com.wangdong.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付
 * @author wangdong
 * @date 2020-12-29
 */
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/{id}")
    public R findById(@PathVariable Integer id) {
        Payment payment = paymentService.findById(id);
        return R.success(payment);
    }

}
