package com.leone.pay.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * @author leone
 * @since 2018-08-23
 **/
@Data
public class Goods {

    @ApiModelProperty("商品id")
    private Long goodsId;

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品价格 单位分")
    private Long goodsPrice;

    @ApiModelProperty("商品条码")
    private String goodsBarcode;

    @ApiModelProperty("商品库存")
    private Integer goodsInventory;

    @ApiModelProperty("商品描述")
    private String description;

    @ApiModelProperty("图片url")
    private String goodsPicture;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("是否删除")
    private boolean deleted;

}