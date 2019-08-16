package com.qianfeng.service.Impl;

import com.qianfeng.mapper.UserInfoMapper;
import com.qianfeng.pojo.UserInfo;
import com.qianfeng.service.UserInfoService;
import com.qianfeng.toolkit.MD5;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    public boolean register(UserInfo userInfo) {
        //使用md5加密方式进行加密
        String newPassword = MD5.encodePassword(userInfo.getPassword());
        //将加密后的密码放入userInfo中
        userInfo.setPassword(newPassword);
        int register = userInfoMapper.register(userInfo);
        return register>0;
    }

    /**
     *根据用户名 密码,登录账号
     * @param
     * @return
     */
    public boolean loginCheck(UserInfo userInfo) {
        //将输入的明文密码使用MD5加密,匹配数据库中的数据
        String password = MD5.encodePassword(userInfo.getPassword());
        userInfo.setPassword(password);
        UserInfo userInfo1 = userInfoMapper.loginCheck(userInfo);
        //如果查询的结果不为空,则代表数据库已有该用户
        //`若查询的结果为空,则代表数据库没有该用户,需跳转到注册页面
        return userInfo1!=null;
    }

    /**
     * 根据用户状态查询信息
     * @return
     */
    public List<UserInfo> getAllUserInfo() {
        List<UserInfo> allUserInfo = userInfoMapper.getAllUserInfo();
        return allUserInfo;
    }
}
