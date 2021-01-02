package com.wangdong.commons.result;

import cn.hutool.core.util.StrUtil;
import com.wangdong.commons.exception.BizBaseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 结果封装
 * @author wangdong
 * @date 2021-01-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class R<T> {

    private Integer code;

    private String msg;

    private T data;

    public R(Integer code, String msg) {
        this(code, msg, null);
    }

    public static<T> R<T> success(T data) {
        return new R<>(0, "success", data);
    }

    public static<T> R<T> error(BizBaseCode bizBaseCode, Object ... params) {
        return new R<>(bizBaseCode.getCode(), StrUtil.format(bizBaseCode.getMsg(), params));
    }
}
