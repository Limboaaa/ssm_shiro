package com.qianfeng.mapper;

import com.qianfeng.dto.SearchUserInfoDTO;
import com.qianfeng.pojo.MenuInfo;
import com.qianfeng.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    public List<MenuInfo> userLoginInit(UserInfo userInfo);

    public List<UserInfo> listAll(SearchUserInfoDTO searchUserInfoDTO);

    public int deleteUserById(int id);

    public UserInfo loginCheck(UserInfo userInfo);

    public int register(UserInfo userInfo);

    public List<UserInfo> getAllUserInfo();

    public int removeUserInfoById(int id);

    public UserInfo getUserInfoById(int id);

    public int editUserInfoById(UserInfo userInfo);
}
