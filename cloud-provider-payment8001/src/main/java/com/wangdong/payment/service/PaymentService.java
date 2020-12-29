package com.wangdong.payment.service;

import com.wangdong.payment.entities.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment findById(Integer id);

}
