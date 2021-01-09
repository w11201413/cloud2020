package com.wangdong.consumer.service.fallback;

import com.wangdong.commons.result.R;
import com.wangdong.consumer.exception.BizCode;
import com.wangdong.consumer.service.PaymentFeignService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignFallback implements PaymentFeignService {

    @Override
    public R findById(Integer id) {
        return null;
    }

    @Override
    public R infoOk(Integer id) {
        return null;
    }

    @Override
    public R infoTimeout(Integer id) {
        return R.error(BizCode.PAYMENT_TIME_OUT);
    }

    @Override
    public R circuitBreaker(Integer id) {
        return R.error(BizCode.PAYMENT_TIME_OUT);
    }
}
