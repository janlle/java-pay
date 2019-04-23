package com.leone.pay.common.property;

import lombok.Data;

/**
 * @author leone
 * @since 2018-06-03
 **/
@Data
public class WxProperties {

    /*app id*/
    private String app_id;

    /*商户id*/
    private String mch_id;

    /*app secret*/
    private String app_secret;

    /*app key*/
    private String app_key;

    /*api key*/
    private String api_key;

    /*交易类型*/
    private String trade_type;

    /*合作商key*/
    private String partner_key;

    /*退款url*/
    private String notify_url;

    /*退款通知url*/
    private String refund_notify_url;

    /*创建订单url*/
    private String create_order_url;

    /*退款url*/
    private String refund_url;

    /*授权url*/
    private String auth_url;

    /*获取token的url*/
    private String token_url;

    /*获取openid的url*/
    private String sessionKey_url;

    /*证书路径*/
    private String certificate_path;

}
