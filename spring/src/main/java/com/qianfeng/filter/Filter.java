package com.qianfeng.filter;

import com.qianfeng.pojo.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Filter implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
       //查看session中有没有用户信息
        HttpSession session = httpServletRequest.getSession();
        //如果没有？ 如果有？
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        if (userInfo==null){
            String requestURI = httpServletRequest.getRequestURI();
            if(requestURI.equals("/loginCheck")||requestURI.equals("/registerUserInfo")||requestURI.equals("/login.html")||requestURI.equals("/reg.html")){
                return true;
            }
        }else {
            return true;
        }
        return false;
    }
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
