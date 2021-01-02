package com.wangdong.payment.controller;

import com.wangdong.commons.result.R;
import com.wangdong.payment.pojo.dto.PaymentDTO;
import com.wangdong.payment.pojo.entities.Payment;
import com.wangdong.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public R create(@RequestBody @Validated PaymentDTO paymentDTO) {
        return R.success(paymentService.create(paymentDTO));
    }

}
