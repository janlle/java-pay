package com.leone.pay.mapper;

import com.leone.pay.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *
 * @author leone
 * @since 2019-04-23
 **/
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User findByUserId(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}