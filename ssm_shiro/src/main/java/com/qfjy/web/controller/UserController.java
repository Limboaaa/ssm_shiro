package com.qfjy.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * UserController
 *
 * @author GuiYuan Zhang
 * @date 2019/9/3
 */
@Controller
@RequestMapping("users")
public class UserController {
    /*
    登录功能
    如果登录失败，跳到登录页面login.jsp
    如果登录成功，跳到主页面mian.jsp
     */
    @RequestMapping("login") //users/login
    public ModelAndView login(@RequestParam("username")String username,
                              @RequestParam("password")String password){
        ModelAndView model = new ModelAndView();
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            //前台用户传入的用户名和密码（将用户名和密码封装到UsernamePasswordToken对象中）
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);//记住我
            try {
                //进行认证（登录）功能
                currentUser.login(token);
            } catch (UnknownAccountException uae) {//未知账户异常
                System.out.println(uae.getMessage());
                model.setViewName("/login.jsp");
                model.addObject("msg","用户名不存在");
                return model;
            } catch (IncorrectCredentialsException ice) {//不正确的凭据异常
                System.out.println(ice.getMessage());
                model.setViewName("/login.jsp");
                model.addObject("msg","密码输入错误");
                return model;
            } catch (LockedAccountException lae) {//锁定帐户例外（将来要在业务逻辑中进行判断）
                System.out.println(lae.getMessage());
                model.setViewName("/login.jsp");
                model.addObject("msg","账户已被锁定");
                return model;
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {//身份验证异常，上面三个异常类都是该子类
                //unexpected condition?  error?
                return null;
            }
        }
        model.setViewName("redirect:/main.jsp");
        return model;
    }

    /**
     * 登出功能
     * @return 返回至登录页面
     */
    @RequestMapping("logout")//users/logout
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "/login.jsp";
    }
}
