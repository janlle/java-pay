package com.leone.pay.service;

import com.leone.pay.common.exception.ExceptionMessage;
import com.leone.pay.entity.Order;
import com.leone.pay.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author leone
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
