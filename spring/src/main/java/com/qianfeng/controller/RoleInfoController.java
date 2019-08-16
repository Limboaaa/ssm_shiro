package com.qianfeng.controller;

import com.qianfeng.dto.UserRoleDTO;
import com.qianfeng.service.MenuInfoService;
import com.qianfeng.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleInfoController {

    @Autowired
    RoleInfoService roleInfoService;


    @RequestMapping("listRoleInfoByUserId")
    public Object listRoleInfoByUserId(@RequestParam int userId){
        return roleInfoService.listRoleByUserId(userId);
    }


    @RequestMapping("insertUserRole")
    public Object insertUserRole(@RequestBody UserRoleDTO userRoleDTO){
        System.out.println(userRoleDTO);
        return roleInfoService.addUserRole(userRoleDTO);
    }

    @RequestMapping("removeUserRole")
    public Object removeUserRole(@RequestBody UserRoleDTO userRoleDTO){
        System.out.println(userRoleDTO);
        return roleInfoService.removeUserRole(userRoleDTO);
    }


}
