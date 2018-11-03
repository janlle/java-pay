package com.andy.pay.common.enums;

/**
 * @author Leone
 * @since 2018-06-03
 **/
public enum ResultEnum {

    SUCCESS(20000, "success"),
    ERROR(50000, "error"),
    USER_NOT_FOUND(40001, "用户不存在"),
    USER_NAME_EXIST(40002, "用户名存在"),
    USERNAME_PASSWORD_FAIL(40003, "用户名或密码错误"),
    USER_TOKEN_VALIDATE_FAIL(40004, "用户token校验失败"),
    USER_ID_TOKEN_NOT_MATCHING(40005, "用户id和token不匹配"),
    USER_ACCOUNT_STYLE_FAIL(40006, "账号格式有误"),
    USER_PASSWORD_IS_EMPTY(40007, "用户密码为空"),
    USER_PASSWORD_LENGTH_FAIL(40008, "用户密码长度必须为6-16位"),
    CODE_MISMATCHING(40009, "验证码不匹配"),
    VALIDATE_CODE_EXPIRED(40010, "验证已码过期"),
    GET_VALIDATE_CODE_ERROR(50010, "获取短信验证码失败"),
    PRODUCT_NOT_EXIST(41001, "商品不存在"),
    PRODUCT_STOCK_ERROR(41002, "商品库存不正确"),
    ORDER_NOT_EXIST(41003, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(41004, "订单详情不存在"),
    ORDER_STATUS_ERROR(41005, "订单状态不正确"),
    ORDER_UPDATE_FAIL(41006, "订单更新失败"),
    ORDER_DETAIL_EMPTY(41007, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(41008, "订单支付状态不正确"),
    CART_EMPTY(41009, "购物车为空"),
    ORDER_OWNER_ERROR(41010, "该订单不属于该用户"),
    PARAM_ERROR(41011, "参数不正确"),
    ORDER_CANCEL_SUCCESS(41012, "订单取消成功"),
    ORDER_FINISH_SUCCESS(41013, "订单完结成功"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
