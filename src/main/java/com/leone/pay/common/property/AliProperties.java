package com.leone.pay.common.property;

import lombok.Data;

/**
 * @author leone
 * @since 2018-06-03
 **/
@Data
public class AliProperties {

    /*应用id*/
    public String app_id;

    /*商家id*/
    private String mch_id;

    /*调用接口的url*/
    private String server_url;

    /*应用私钥*/
    public String alipay_private_key;

    /*支付宝公钥*/
    public String alipay_public_key;

    /*字符编码*/
    public String charset;

    /*签名方式*/
    public String sign_type ;

    /*数据格式*/
    public String format;

    /*支付回调url*/
    private String notify_url;

    /*pc支付前台通知*/
    private String return_url;

    /*退款url*/
    private String refund_url;


}
