package com.qianfeng.controller;

import com.qianfeng.pojo.UserInfo;
import com.qianfeng.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

//RestController不仅是一个控制器,还是一个符合restful风格的网络接口
@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    @RequestMapping("registerUserInfo")
    public Object registerUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.register(userInfo);
    }

    /**
     * 根据用户名密码 登录账户
     * @param userInfo
     * @return
     */
    @RequestMapping("loginCheck")
    public Object loginCheck(@RequestBody UserInfo userInfo ){
        System.out.println(userInfo);
        boolean loginCheck = userInfoService.loginCheck(userInfo);
        return loginCheck;
    }

    /**
     * 根据用户状态,获取信息
     * @return
     */
    public Object getAllUserInfo(){
        List<UserInfo> allUserInfo = userInfoService.getAllUserInfo();
        return allUserInfo;
    }
}
