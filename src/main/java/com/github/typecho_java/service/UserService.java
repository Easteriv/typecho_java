package com.github.typecho_java.service;

import com.github.typecho_java.dao.User;

/**
 * 用户service
 * @author zhaojiejun
 */
public interface UserService {
    /**
     * 根据用户ID查询用户
     * @param userId 用户ID
     * @return 用户信息
     */
    User getUser(Integer userId);
}
