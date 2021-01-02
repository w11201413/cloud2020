package com.wangdong.payment.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.wangdong.payment.dao.PaymentDao;
import com.wangdong.payment.pojo.dto.PaymentDTO;
import com.wangdong.payment.pojo.entities.Payment;
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
    public Payment findById(Integer id) {
        return paymentDao.selectById(id);
    }

    @Override
    public int create(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        BeanUtil.copyProperties(paymentDTO, payment);
        return paymentDao.insert(payment.setId(null));
    }

}
