package com.wangdong.payment.service;

import com.wangdong.payment.entities.Payment;

/**
 * 支付
 * @author wangdong
 * @date 2020-12-29
 */
public interface PaymentService {

    /**
     * 创建支付流水
     * @param payment 支付数据
     * @return int - 创建成功个数
     */
    int create(Payment payment);

    /**
     * 通过ID查找支付流水
     * @param id ID
     * @return Payment - 支付流水
     */
    Payment findById(Integer id);

}
