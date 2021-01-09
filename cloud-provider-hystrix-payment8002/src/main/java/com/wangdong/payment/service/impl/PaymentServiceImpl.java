package com.wangdong.payment.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wangdong.payment.dao.PaymentDao;
import com.wangdong.payment.pojo.dto.PaymentDTO;
import com.wangdong.payment.pojo.entities.Payment;
import com.wangdong.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

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
    @HystrixCommand(fallbackMethod = "infoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") // Hystrix超时时间
    })
    public String infoTimeout(Integer id) {
        int timeoutNum = 5;
        TimeUnit.SECONDS.sleep(timeoutNum);
        return "线程池：" + Thread.currentThread().getName() + "Info_timeout, id:" + id + ", 耗时：" + timeoutNum;
    }

    public String infoTimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "Info_timeout_handler, id:" + id + ", 兜底的。";
    }

    @Override
    @HystrixCommand(fallbackMethod = "circuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期(时间范围), 这个窗口期是指在熔断后多长时间之后进行尝试恢复重试
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String circuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }
        return Thread.currentThread().getName() + "调用成功， 流水号: " + IdUtil.fastSimpleUUID();
    }

    public String circuitBreakerFallback(Integer id) {
        return "id 不能为负数, 请稍后再试, id: " +  id;
    }
}
