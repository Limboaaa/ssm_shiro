package com.qfjy.service;

import com.qfjy.pojo.Users;

/**
 * UsersService
 *
 * @author GuiYuan Zhang
 * @date 2019/9/3
 */
public interface UsersService {
    /**
     * 根据用户名查询用户对象是否存在
     * @param username
     * @return Users
     */
    Users selectByUsername(String username);
}
