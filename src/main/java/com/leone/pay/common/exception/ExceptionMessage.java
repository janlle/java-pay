package com.leone.pay.common.exception;

/**
 * @author leone
 **/
public enum ExceptionMessage {

    ERROR(50000, "异常"),
    SUCCESS(20000, "成功"),
    PERMISSION_DENIED(40001, "权限不足"),
    PHONE_LAYOUT_FAIL(40002, "手机号码格式不正确"),
    AUTH_TOKEN(40010, "auth.token.wrong"),
    AUTH_TOKEN_EMPTY(40011, "auth.token.empty"),
    AUTH_ACCOUNT_PASSWORD_WRONG(40012, "账号或密码错误"),
    ACCOUNT_HAS_DISABLED(40013, "账号已被禁用"),
    AUTH_PERMISSION(40014, "权限不足"),
    REQUEST_ARGUMENT(40015, "request.argument"),
    INTERNAL_SERVER_ERROR(40016, "server.internal"),
    AUTH_CAPTCHA_WRONG(40017, "验证码错误"),
    AUTH_CAPTCHA_LOST(40018, "验证码已失效"),
    DELETE_IDS_FAIL(40020, "删除的id列表有误"),
    DELETE_FAIL(40021, "批量删除失败"),
    COLLECT_TYPE_FAIL(40022, "收藏类型错误"),
    USER_NOT_EXIST(40019, "user.not.exist"),
    CAPTCHA_FAIL(40023, "验证码有误"),
    ACTIVITY_ORDER_STATUS_FAIL(40024, "活动订单状态不正确"),
    REFUNDS_CANNOT_BE_GREATER_THAN_ORDERS(40025, "退款商品不能大于订单商品数量"),
    ORDER_STATUS_FAIL(40027, "订单状态不正确"),
    AFTER_SALES_ORDER_ALREADY_EXISTS(40028, "售后订单已存在"),
    AVAILABLE_INTEGRAL_DEFICIENCY(40029, "可用积分不足"),
    USER_ID_AND_SHOPPING_CART_ID_DO_NOT_MATCH(40030, "用户id和购物车id不匹配"),
    THE_SHIPPING_ADDRESS_ALREADY_EXISTS(40031, "用户收货地址已存在"),
    WRONG_VALUE_OF_DISCOUNT_COUPONS(40032, "折扣券数值有误"),
    INCORRECT_COUPON_STATUS(40033, "优惠券状态有误"),
    INVENTORY_SHORTAGE(40034, "商品库存不足"),
    ORDER_NOT_EXIST(40035, "订单不存在"),
    PAYMENT_FAILURE(40036, "支付失败"),
    SIGNATURE_VERIFICATION_FAILED(40037, "签名校验失败"),
    WEI_XIN_PAY_FAIL(40038, "微信发起支付失败"),
    ACTIVITY_CLOSED(40039, "活动已结束"),
    THE_CAMPAIGN_HAS_ALREADY_STARTED(40041, "活动已经开始"),
    THE_START_TIME_CANNOT_BE_GREATER_THAN_THE_END_TIME(40041, "开始时间不能大于结束时间"),
    THE_START_TIME_CANNOT_BE_LESS_THAN_THE_CURRENT_TIME(40042, "开始时间不能小于当前时间"),
    CURRENT_ORDER_IS_NOT_SHIPPED(40043, "当前订单未发货"),
    XML_DATA_INCORRECTNESS(40044, "xml数据格式不正确"),
    ORDER_STATUS_INCORRECTNESS(40090, "订单状态不正确")

    ;


    private Integer code;

    private String message;

    ExceptionMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ExceptionMessage() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
