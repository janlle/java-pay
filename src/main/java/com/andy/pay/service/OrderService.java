package com.andy.pay.service;

import com.andy.pay.common.exception.ExceptionMessage;
import com.andy.pay.mapper.OrderMapper;
import com.andy.pay.pojos.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author Leone
 * @since 2018-06-03
 **/
@Slf4j
@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    /**
     * 查找订单
     *
     * @param orderId
     * @return
     */
    public Order findOne(Long orderId) {
        Order order = orderMapper.findByOrderId(orderId);
        Assert.notNull(order, ExceptionMessage.ORDER_NOT_EXIST.getMessage());
        return order;
    }


}
