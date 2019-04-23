package com.leone.pay.wx.controller;

import com.leone.pay.common.Result;
import com.leone.pay.wx.service.WxPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微信支付
 *
 * @author leone
 * @since 2018-05-20
 **/
@Slf4j
@RestController
@Api(tags = "微信支付接口")
@RequestMapping("/wx/pay")
public class WxPayController {

    @Resource
    private WxPayService wxPayService;

    @GetMapping("/app")
    @ApiOperation("微信App支付预下单")
    public Result appPay(Long orderId, HttpServletRequest request, HttpServletResponse response) {
        return Result.success(wxPayService.appPay(request, orderId));
    }

    @ApiOperation("微信App支付回调")
    @RequestMapping(value = "/app/notify", method = {RequestMethod.GET, RequestMethod.POST})
    public void appNotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        wxPayService.appNotify(request, response);
    }

    @ApiOperation("微信App支付退款")
    @GetMapping("/app/refund")
    public void appRefund(Long orderId) {
//        wxPayService.wxRefund(orderId);
    }

    @GetMapping("/qr/code/pay")
    @ApiOperation("微信扫码支付预下单")
    public void qrCodePay(Long orderId, HttpServletRequest request, HttpServletResponse response) {
        wxPayService.qrCodePay("1", response, request);
    }

    @ApiOperation("微信扫码支付回调")
    @RequestMapping(value = "/qr/code/notify", method = {RequestMethod.GET, RequestMethod.POST})
    public void qrCodeNotify(Long orderId) {
    }


    @GetMapping("/xcx/pay")
    @ApiOperation("小程序扫码支付预下单")
    public Result xcxPay(Long orderId, HttpServletRequest request, HttpServletResponse response) {
        return Result.success(wxPayService.xcxPay(orderId, request));
    }

    @ApiOperation("小程序码支付回调")
    @RequestMapping(value = "/xcx/notify", method = {RequestMethod.GET, RequestMethod.POST})
    public void xcxNotify(Long orderId, HttpServletRequest request) {
        wxPayService.xcxPay(orderId, request);
    }

}
