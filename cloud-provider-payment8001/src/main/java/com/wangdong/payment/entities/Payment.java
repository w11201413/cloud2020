package com.wangdong.payment.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 支付信息实体
 * @author wangdong
 * @date 2020-12-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("payment")
public class Payment {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("serial")
    private String serial;

}
