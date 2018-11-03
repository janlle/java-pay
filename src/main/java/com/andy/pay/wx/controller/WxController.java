package com.andy.pay.wx.controller;

import com.andy.pay.common.property.AppProperties;
import com.andy.pay.wx.service.WxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信
 *
 * @author Leone
 * @since 2018-05-22
 **/
@Slf4j
@Api(tags = "微信相关接口")
@RestController
@RequestMapping("/wx")
public class WxController {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WxService weChatService;

    @RequestMapping(value = "/notify", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation("微信授权回调地址")
    public String getUserInfo(String state, String code, HttpServletRequest request) {
        log.info("微信授权回调方法,code:{},state:{}", code, state);
        String url = String.format(appProperties.getWx().getToken_url(), appProperties.getWx().getApp_id(), appProperties.getWx().getApp_secret(), code);
        log.info("url:{}", url);
        String result = restTemplate.getForObject(url, String.class);
        log.info("result:{}", result);
        return result;
    }

    @ApiOperation(value = "获取code", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("/code")
    public void code(String state, String code, HttpServletRequest request) {
        log.info("获取code.....");
        String url = String.format(appProperties.getWx().getAuth_url(), appProperties.getWx().getApp_id(), appProperties.getWx().getCreate_order());
        log.info("url:{}", url);
        restTemplate.getForObject(url, String.class);
    }

}
