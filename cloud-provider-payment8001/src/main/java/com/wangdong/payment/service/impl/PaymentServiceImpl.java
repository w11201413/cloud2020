package com.wangdong.payment.service.impl;

import com.wangdong.payment.entities.Payment;
import com.wangdong.payment.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public int create(Payment payment) {
        return 0;
    }

    @Override
    public Payment findById(Integer id) {
        return null;
    }
}
