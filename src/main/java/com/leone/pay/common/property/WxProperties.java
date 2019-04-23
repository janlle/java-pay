package com.leone.pay.common.property;

import lombok.Data;

/**
 * @author Leone
 * @since 2018-06-03
 **/
@Data
public class WxProperties {

    private String app_id;

    private String mch_id;

    private String app_secret;

    private String app_key;

    private String api_key;

    private String trade_type;

    private String partner_key;

    private String notify_url;

    private String refund_notify_url;

    private String create_order;

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
