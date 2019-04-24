package com.leone.pay.common.enums.type;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-23
 **/
public enum WxPayType {

    CREATE(0, "APP"), PAY(1, "NATIVE"), DELIVER(2, "JS_API");

    private int status;

    private String payType;


    WxPayType(int status, String payType) {
        this.status = status;
        this.payType = payType;
    }

    WxPayType() {
    }

    public int getStatus() {
        return status;
    }

    public String getPayType() {
        return payType;
    }

}
