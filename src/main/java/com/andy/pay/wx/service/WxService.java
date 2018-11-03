package com.andy.pay.wx.service;

import com.andy.pay.common.property.AppProperties;
import com.andy.pay.common.utils.JsonUtils;
import com.andy.pay.wx.pojo.WxUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author Leone
 * @since 2018-05-22
 **/
@Slf4j
@Service
public class WxService {


    @Autowired
    private AppProperties appProperties;

    @Autowired
    private RestTemplate restTemplate;

    public WxUser getUserInfo() {
        String code = getCode();
        String token = getToken(code);
        Map<String, String> jsonMap = JsonUtils.fromJson(token, Map.class);

        String error = jsonMap.get("errcode");
        String access_token = jsonMap.get("access_token");
        String openId = jsonMap.get("openid");

        String userInfoUrl = String.format(appProperties.getWx().getAuth_url(), access_token, openId);
        WxUser userInfo = restTemplate.getForObject(userInfoUrl, WxUser.class);
        log.info("微信获取用户信息的url:{}---->获取的user:{}", userInfoUrl, userInfo);
        return userInfo;
    }

    public String getCode() {
        String authUrl = String.format(appProperties.getWx().getAuth_url(),
                appProperties.getWx().getApp_id(), appProperties.getWx().getNotify_url());
        String code = restTemplate.getForObject(authUrl, String.class);
        log.info("微信获取授权码的url:{}---->获取的code:{}", authUrl, code);
        return code;
    }


    public String getToken(String code) {
        String tokenUrl = String.format(appProperties.getWx().getAuth_url(), appProperties.getWx().getAuth_url(), appProperties.getWx().getApp_secret(), code);
        String token = restTemplate.getForObject(tokenUrl, String.class);
        log.info("微信获取token的url:{}---->获取的token:{}", tokenUrl, token);
        return token;
    }
}
