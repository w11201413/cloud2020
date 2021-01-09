package com.wangdong.consumer.exception;

import com.wangdong.commons.exception.BizCodeInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BizCode implements BizCodeInterface {

    PAYMENT_TIME_OUT(2001, "响应超时，请稍后重试");

    /**
     * 异常码
     */
    private final Integer code;

    /**
     * 异常描述, 可以使用{}作为占位符, 参数通过BizException补入
     */
    private final String msg;

}
