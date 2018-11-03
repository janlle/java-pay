package com.andy.pay.service;

import com.andy.pay.common.exception.ExceptionMessage;
import com.andy.pay.mapper.UserMapper;
import com.andy.pay.pojos.entity.User;
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
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User findOne(Long userId) {
        User user = userMapper.findByUserId(userId);
        Assert.notNull(user, ExceptionMessage.USER_NOT_EXIST.getMessage());
        return user;
    }
}
