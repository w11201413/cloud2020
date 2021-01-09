package com.wangdong.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 自定义业务异常码
 * @author wangdong
 * @date 2021-01-01
 */
@Getter
@AllArgsConstructor
public enum BizBaseCode implements BizCodeInterface{

    /** 系统级异常: -1 未知异常; 1XXX 其他系统异常; */
    SYSTEM_FAILED(-1, "未知异常"),
    SYSTEM_VALID_FAILED(1001, "校验：参数{}设置异常, {}");

    /**
     * 异常码
     */
    private final Integer code;

    /**
     * 异常描述, 可以使用{}作为占位符, 参数通过BizException补入
     */
    private final String msg;

}
