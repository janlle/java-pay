package com.leone.pay.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * @author leone
 * @since 2018-10-23
 **/
@Data
public class OrderItem implements Serializable {

    private static final long serialVersionUID = -7529968762980756395L;

    private String orderItemId;

    private String orderId;

    private String goodsId;

    private String goodsName;

    private Long goodsPrice;

    private Integer goodsCount;

    private String goodsPicture;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;


}