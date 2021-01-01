package com.wangdong.payment.service.impl;

import com.wangdong.payment.dao.PaymentDao;
import com.wangdong.payment.entities.Payment;
import com.wangdong.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment findById(Integer id) {
        return paymentDao.selectById(id);
    }
}
