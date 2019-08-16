package com.qianfeng.pojo;

import lombok.Data;

import java.util.List;
import java.util.Set;
@Data
public class UserInfo {
    int userid;
    String username;
    String password;

    String account;
    String email;
    String mobile;
    String areaCode;
    int status;
    String icon;

    List<RoleInfo> roleInfoList;
    Set<MenuInfo> menuInfoList;
}
