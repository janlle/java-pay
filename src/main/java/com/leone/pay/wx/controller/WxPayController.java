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
@RequestMapping("/api/wx/pay")
public class WxPayController {

    @Resource
    private WxPayService wxPayService;

    @GetMapping("/app")
    @ApiOperation("微信App支付预下单")
    public Result appPay(Long orderId, HttpServletRequest request, HttpServletResponse response) {
        return Result.success(wxPayService.appPay(request, orderId));
    }

    @ApiOperation("微信App支付退款")
    @GetMapping("/app/refund")
    public Result appRefund(Long orderId) throws Exception {
        return wxPayService.wxRefund(orderId);
    }

    @GetMapping("/qrcode")
    @ApiOperation("微信扫码支付预下单")
    public Result qrCodePay(Long orderId, HttpServletRequest request, HttpServletResponse response) {
        return wxPayService.qrCodePay(orderId, response, request);
    }

    @GetMapping("/xcx")
    @ApiOperation("小程序扫支付预下单")
    public Result xcxPay(Long orderId, HttpServletRequest request, HttpServletResponse response) {
        return wxPayService.xcxPay(orderId, request);
    }

    @ApiOperation("微信支付通知")
    @RequestMapping(value = "/notify", method = {RequestMethod.GET, RequestMethod.POST})
    public void appNotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        wxPayService.notify(request, response);
    }

}
