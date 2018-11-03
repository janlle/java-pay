package com.andy.pay.wx.controller;

import com.andy.pay.wx.service.WxPayService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信支付
 *
 * @author Leone
 * @since 2018-05-20
 **/
@Slf4j
@RestController
@Api(tags = "微信支付接口")
@RequestMapping("/wx")
public class WxPayController {

    @Autowired
    private WxPayService weChatPayService;

//    @GetMapping("/app/pay")
//    @ApiOperation("微信App支付预下单")
//    public void appPay(String orderId, HttpServletRequest request, HttpServletResponse response) {
//        weChatPayService.appPay(request, orderId);
//    }
//
//    @ApiOperation("微信App支付回调")
//    @RequestMapping(value = "/app/notify", method = {RequestMethod.GET, RequestMethod.POST})
//    public void appNotify(String orderId) {
//    }
//
//    @ApiOperation("微信App支付退款")
//    @GetMapping("/app/refund")
//    public void appRefund(String orderId) {
//        weChatPayService.appPayRefund(orderId);
//    }
//
//    @GetMapping("/qr/code/pay")
//    @ApiOperation("微信扫码支付预下单")
//    public void qrCodePay(String orderId, HttpServletRequest request, HttpServletResponse response) {
//        weChatPayService.payHandler(request, orderId);
//    }
//
//    @ApiOperation("微信扫码支付回调")
//    @RequestMapping(value = "/qr/code/notify", method = {RequestMethod.GET, RequestMethod.POST})
//    public void qrCodeNotify(String orderId) {
//    }
//
//    @ApiOperation("微信扫码支付退款")
//    @GetMapping("/qr/code/refund")
//    public void qrCodeRefund(String orderId) {
//        weChatPayService.wxPayRefund(orderId, 12);
//    }
//
//    @GetMapping("/xcx/pay")
//    @ApiOperation("小程序扫码支付预下单")
//    public void xcxPay(String orderId, HttpServletRequest request, HttpServletResponse response) {
//        weChatPayService.payHandler(request, orderId);
//    }
//
//    @ApiOperation("小程序码支付回调")
//    @RequestMapping(value = "/xcx/notify", method = {RequestMethod.GET, RequestMethod.POST})
//    public void xcxNotify(String orderId, HttpServletRequest request) {
//        weChatPayService.xcxPay(orderId, request);
//    }
//
//    @ApiOperation("小程序扫码支付退款")
//    @GetMapping("/xcx/refund")
//    public void xcxRefund(String orderId) {
//        weChatPayService.wxPayRefund(orderId, 12);
//    }

}
