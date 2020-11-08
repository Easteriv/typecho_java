package com.github.typecho_java.service.impl;

import com.github.typecho_java.dao.User;
import com.github.typecho_java.mapper.UserMapper;
import com.github.typecho_java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaojiejun
 * @date 2020/11/8 6:00 下午
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return 用户信息
     */
    @Override
    public User getUser(Integer userId) {
        User user = userMapper.selectById(userId);
        return user;
    }
}
