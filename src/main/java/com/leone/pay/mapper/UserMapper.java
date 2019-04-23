package com.leone.pay.mapper;

import com.leone.pay.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User findByUserId(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}