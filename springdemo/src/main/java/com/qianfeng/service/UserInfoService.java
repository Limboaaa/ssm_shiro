package com.qianfeng.service;

import com.qianfeng.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    public boolean register(UserInfo userInfo);

    public boolean loginCheck(UserInfo UserInfo);

    public List<UserInfo> getAllUserInfo();
}
