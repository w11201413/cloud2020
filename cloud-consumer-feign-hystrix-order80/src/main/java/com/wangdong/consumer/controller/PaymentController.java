package com.wangdong.consumer.controller;

import com.wangdong.commons.result.R;
import com.wangdong.consumer.service.PaymentFeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
//@DefaultProperties(defaultFallback = "defaultFallback")  降级方案二
public class PaymentController {

    private final PaymentFeignService paymentFeignService;

    @GetMapping("/{id}")
    public R findById(@PathVariable Integer id) {
        return paymentFeignService.findById(id);
    }

    @GetMapping("/{id}/ok")
    public R infoOk(@PathVariable Integer id) {
        return paymentFeignService.infoOk(id);
    }

    /*
    降级方案一
    为单一业务特殊化定制Hystrix Fallback措施
    @HystrixCommand(fallbackMethod = "infoTimeoutHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") // Hystrix超时时间
    })
    @GetMapping("/{id}/timeout")
    public R infoTimeout(@PathVariable Integer id) {
        return paymentFeignService.infoTimeout(id);
    }

    public R infoTimeoutHandler(@PathVariable Integer id) {
        return R.error(BizCode.PAYMENT_TIME_OUT);
    }
     */

    /*
    降级方案二
    @HystrixCommand
    @GetMapping("/{id}/timeout")
    public R infoTimeout(@PathVariable Integer id) {
        int i = 10/0;
        return paymentFeignService.infoTimeout(id);
    }

    public R defaultFallback() {
        return R.error(BizCode.PAYMENT_TIME_OUT);
    }
    */

    @GetMapping("/{id}/timeout")
    public R infoTimeout(@PathVariable Integer id) {
        return paymentFeignService.infoTimeout(id);
    }

    @GetMapping("/{id}/circuitBreaker")
    R circuitBreaker(@PathVariable Integer id) {
        return paymentFeignService.circuitBreaker(id);
    }

}
