package com.leone.pay.common.enums.type;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-23
 **/
public enum OrderType {

    CREATE(0, "微信支付"), PAY(1, "支付宝支付"), DELIVER(2, "银联支付");

    private int status;

    private String payType;

    OrderType() {
    }

    OrderType(int status, String payType) {
        this.status = status;
        this.payType = payType;
    }

    public int getStatus() {
        return status;
    }

    public String getPayType() {
        return payType;
    }
}
