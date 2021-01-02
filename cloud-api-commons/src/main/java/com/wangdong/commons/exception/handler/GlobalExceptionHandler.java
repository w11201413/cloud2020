package com.wangdong.commons.exception.handler;

import com.wangdong.commons.exception.BizBaseCode;
import com.wangdong.commons.exception.BizException;
import com.wangdong.commons.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常捕获
 * @author wangdong
 * @date 2021-01-01
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数校验异常拦截
     * @param request 请求
     * @param exception 异常
     * @return 校验结果封装
     */
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public R MethodArgumentNotValidHandler(HttpServletRequest request, MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors().stream().findFirst().map(error ->
                R.error(BizBaseCode.SYSTEM_VALID_FAILED, error.getField(), error.getDefaultMessage())
        ).orElse(R.success(null));
    }

    /**
     * 业务异常拦截
     * @param request 请求
     * @param exception 异常
     * @return 业务异常结果封装
     */
    @ExceptionHandler(value= BizException.class)
    public R exceptionHandler(HttpServletRequest request, BizException exception) {
        log.error("系统发生业务异常", exception.getCause());
        return R.error(exception.getBizBaseCode(), exception.getParams());
    }

    /**
     * Exception异常拦截(最后防线)
     * @param request 请求
     * @param exception 异常
     * @return 未知异常结果封装
     */
    @ExceptionHandler(value= Exception.class)
    public R exceptionHandler(HttpServletRequest request, Exception exception) {
        log.error("系统发生未知异常", exception);
        return R.error(BizBaseCode.SYSTEM_FAILED);
    }

}
