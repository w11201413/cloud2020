package com.wangdong.payment.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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

}
