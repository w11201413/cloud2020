package com.wangdong.payment.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.wangdong.payment.dao.PaymentDao;
import com.wangdong.payment.pojo.dto.PaymentDTO;
import com.wangdong.payment.pojo.entities.Payment;
import com.wangdong.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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

    @Override
    public String infoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "Info_ok, id:" + id;
    }

    @Override
    @SneakyThrows
    /*
    被调用端服务降级配置
    @HystrixCommand(fallbackMethod = "infoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") // Hystrix超时时间
    })*/
    public String infoTimeout(Integer id) {
        /*int timeoutNum = 5;
        TimeUnit.SECONDS.sleep(timeoutNum);*/
        return "线程池：" + Thread.currentThread().getName() + "Info_timeout, id:" + id + ", 耗时：" ;
    }

    public String infoTimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "Info_timeout_handler, id:" + id + ", 兜底的。";
    }
}
