package com.qianfeng.controller;

import com.qianfeng.dto.SearchUserInfoDTO;
import com.qianfeng.pojo.MenuInfo;
import com.qianfeng.pojo.UserInfo;
import com.qianfeng.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserInfoController {

    //自动注入
    @Autowired
    UserInfoService userInfoService;

    //请求映射
    @RequestMapping("loginCheck")
    //该方法的返回值(无论类型),都以json字符串返回.
//    @ResponseBody
    //@RequestBody:声明一个对象，凡是请求过来参数的name和这个对象属性名相同的话，框架就进行封装
    //@RequestParam:声明这是一个请求的参数
    public Object loginCheck(@RequestBody UserInfo userInfo, HttpSession session){
        System.out.println(userInfo);
        UserInfo userInfo1 = userInfoService.loginCheck(userInfo);
        //登陆成功
        if (userInfo1!=null){
            session.setAttribute("userInfo",userInfo1);
            //缓存
            List<MenuInfo> menuInfos = userInfoService.userLoginInit(userInfo);
            session.setAttribute("menuInfoList",menuInfos);
        }else{
            //登陆失败
        }
        return userInfo1!=null;
    }

    @RequestMapping("registerUserInfo")
//    @ResponseBody
    public Object registerUserInfo(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        boolean register = userInfoService.register(userInfo);
        return register;
    }

    @RequestMapping(value = "listAllUserInfo",method = RequestMethod.POST)
    public Object listAllUserInfo(@RequestBody SearchUserInfoDTO searchUserInfoDTO){
        return this.userInfoService.getAllUserInfo(searchUserInfoDTO);
    }

    @RequestMapping("removeUserInfoById")
    public Object removeUserInfoById(@RequestParam int userid){
        System.out.println("id="+userid);
        return this.userInfoService.removeUserInfoById(userid);
    }

    @RequestMapping("getUserInfoById")
    public Object getUserInfoById(@RequestParam int userid){
        System.out.println("id="+userid);
        return this.userInfoService.getUserInfoById(userid);
    }
    @RequestMapping("editUserInfoById")
    public boolean editUserInfoById(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        return this.userInfoService.editUserInfoById(userInfo);
    }

    @RequestMapping("initMenuList")
    public Object initMenuList(@RequestBody(required = false) UserInfo userInfo,HttpSession session){
        if(session.getAttribute("menuInfoList")==null){
            if(userInfo!=null){
                return userInfoService.userLoginInit(userInfo);
            }else {
                return null;
            }
        }else{
            return session.getAttribute("menuInfoList");
        }
    }


    @RequestMapping("pathVariableTest/{uname}-{pwd}")
    public Object pathVariableTest(@PathVariable("uname") String uname,@PathVariable("pwd") String pwd){
        System.out.println(uname+":"+pwd);
        return uname+":"+pwd;
    }


    @RequestMapping("getCookieValue")
    public Object getCookieValue(@CookieValue(name = "name",required = false) String username){
        System.out.println(username);
        return username;
    }

    @RequestMapping("getRequestHeaderValue")
    public Object getRequestHeaderValue(@RequestHeader(value = "Content-Length")String host){
        System.out.println(host);
        return host;
    }
}