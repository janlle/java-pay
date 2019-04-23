package com.leone.pay.entity;

import lombok.Data;

import java.util.Date;

/**
 * <p> 
 *
 * @author leone
 * @since 2018-10-23
 **/
@Data
public class OrderDetail {

    private String id;

    private Long detailId;

    private String orderId;

    private String productId;

    private String name;

    private Long price;

    private Integer count;

    private String imageUrl;

    private Date createTime;

    private Date updateTime;


}