package com.wangdong.payment.controller;

import com.wangdong.commons.result.R;
import com.wangdong.payment.pojo.dto.PaymentDTO;
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
        return R.success(paymentService.findById(id));
    }

    @PostMapping
    public R create(@RequestBody @Validated PaymentDTO paymentDTO) {
        return R.success(paymentService.create(paymentDTO));
    }

    @GetMapping("/{id}/ok")
    public R infoOk(@PathVariable Integer id) {
        return R.success(paymentService.infoOk(id));
    }

    @GetMapping("/{id}/timeout")
    public R infoTimeout(@PathVariable Integer id) {
        return R.success(paymentService.infoTimeout(id));
    }

}
