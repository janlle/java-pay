package com.leone.pay.common.property;

import lombok.Data;

import java.nio.charset.StandardCharsets;

/**
 * @author leone
 * @since 2018-06-03
 **/
@Data
public class AliProperties {

    /*应用id*/
    public String app_id = "";

    /*应用私钥*/
    //
    public String alipay_private_key = "";

    /*支付宝公钥*/
    public String alipay_public_key = "";

    /*字符编码*/
    public String charset = StandardCharsets.UTF_8.displayName();

    /*签名方式*/
    public String sign_type = "RSA2";

    /*数据格式*/
    public String format = "JSON";

    /*支付回调url*/
    private String notify_url;

    /*pc支付前台通知*/
    private String return_url;

    /*商家id*/
    private String mch_id;

    /*退款url*/
    private String refund_url;


}
