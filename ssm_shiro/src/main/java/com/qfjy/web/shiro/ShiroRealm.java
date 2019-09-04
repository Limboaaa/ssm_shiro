package com.qfjy.web.shiro;

import com.qfjy.pojo.Users;
import com.qfjy.service.UsersService;
import jdk.nashorn.internal.parser.Token;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ShiroRealm
 *
 * @author GuiYuan Zhang
 * @date 2019/9/3
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UsersService usersService;

    /**
     *认证
     * 1、什么情况下会被调用
     * currentUser.login(token) //进行认证（登录）功能
     * 2、该方法的入参是什么数据
     * UsernamePasswordToken
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //1.得到输入的用户名
        String username = upToken.getUsername();
        //2.判断当前用户在数据库中是否存在
        Users users = usersService.selectByUsername(username);
        //3.如果用户名不存在 主动抛出异常 UnknownAccountException
        if (users==null){
            throw new UnknownAccountException ("用户名不存在");
        }
        //4.如果用户名存在密码错误

        //5. 如果用户状态 为锁定状态 LockedAccountException status = 0
        if (users.getStatus()==0){
            throw new LockedAccountException("该账户已被锁定");
        }
        //6.密码的比较（前台的密码=数据库中查询的密码） 由Shiro内部来完成的。
        Object principal = username;
        Object credentials = users.getPassword();//数据库中查询出的密码
        AuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal,credentials,super.getName());


        return simpleAuthenticationInfo;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
