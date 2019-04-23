package com.leone.pay.ali.controller;

import com.leone.pay.ali.service.AliPayService;
import com.leone.pay.common.Result;
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
 * @author leone
 * @since 2018-06-16
 **/
@Slf4j
@RestController
@Api(tags = "支付宝支付")
@RequestMapping(value = "/api/pay/ali")
public class AliPayController {

    @Resource
    private AliPayService aliPayService;

    @GetMapping("/app")
    @ApiOperation("支付宝App支付预下单")
    public Result appPay(Long orderId, HttpServletRequest request, HttpServletResponse response) {
        return Result.success(aliPayService.appPay(orderId, request));
    }

    @GetMapping("/qrcode")
    @ApiOperation("支付宝扫码支付预下单")
    public Result qrCodePay(Long orderId, HttpServletResponse response) throws Exception {
        return aliPayService.aliQrCodePay(orderId, response);
    }

    @ApiOperation("支付宝App支付退款")
    @GetMapping("/refund")
    public Result appRefund(Long orderId, HttpServletRequest request) throws Exception {
        return aliPayService.aliRefund(orderId, request);
    }


    @ApiOperation("支付宝支付通知")
    @RequestMapping(value = "/notify", method = {RequestMethod.GET, RequestMethod.POST})
    public void aliNotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        aliPayService.aliNotify(request, response);
    }


}
