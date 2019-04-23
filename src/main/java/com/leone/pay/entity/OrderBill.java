package com.leone.pay.entity;

import com.leone.pay.common.enums.type.OrderType;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-23
 **/
@Data
public class OrderBill {

    private Long orderBillId;

    private Long userId;

    private OrderType orderType;

    private Long payAmount;

    private String outTradeNo;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

}
