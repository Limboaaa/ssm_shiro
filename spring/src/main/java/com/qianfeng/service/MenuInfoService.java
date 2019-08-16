package com.qianfeng.service;

import com.qianfeng.dto.ModifyRoleMenuDTO;
import com.qianfeng.vo.MenuInfoVO;
import com.qianfeng.vo.MenuListVO;

import java.util.List;

public interface MenuInfoService {
    public List<MenuInfoVO> listMenuByRoleId(int roleId);

    public boolean updateRoleMenu(ModifyRoleMenuDTO modifyRoleMenuDTO);

    public List<MenuListVO> listAllMenu();
}
