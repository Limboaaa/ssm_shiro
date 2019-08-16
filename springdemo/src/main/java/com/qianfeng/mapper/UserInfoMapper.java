package com.qianfeng.mapper;

import com.qianfeng.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    public int register(UserInfo userInfo);

    public UserInfo loginCheck(UserInfo userInfo);

    public List<UserInfo> getAllUserInfo();
}
