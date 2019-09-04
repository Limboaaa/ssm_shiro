package com.qfjy.service.impl;

import com.qfjy.dao.UsersMapper;
import com.qfjy.pojo.Users;
import com.qfjy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UsersServiceImpl
 *
 * @author GuiYuan Zhang
 * @date 2019/9/3
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;
    /**
     * 根据用户名查询用户对象是否存在
     *
     * @param username
     * @return Users
     */
    @Override
    public Users selectByUsername(String username) {
        return usersMapper.selectByUsername(username);
    }
}
