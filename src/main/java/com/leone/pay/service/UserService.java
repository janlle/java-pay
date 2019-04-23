package com.leone.pay.service;

import com.leone.pay.common.exception.ExceptionMessage;
import com.leone.pay.entity.User;
import com.leone.pay.mapper.UserMapper;
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
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     *
     * @param userId
     * @return
     */
    public User findOne(Long userId) {
        User user = userMapper.findByUserId(userId);
        Assert.notNull(user, ExceptionMessage.USER_NOT_EXIST.getMessage());
        return user;
    }


}
