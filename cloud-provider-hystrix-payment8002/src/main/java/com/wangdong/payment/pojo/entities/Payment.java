package com.wangdong.payment.pojo.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 支付信息实体
 * @author wangdong
 * @date 2020-12-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@TableName("com/wangdong/payment")
public class Payment {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("serial")
    private String serial;

}
