package com.leone.pay.mapper;

import com.leone.pay.entity.OrderItem;
import org.mapstruct.Mapper;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-23
 **/
@Mapper
public interface OrderItemMapper {

    int deleteByPrimaryKey(String id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}