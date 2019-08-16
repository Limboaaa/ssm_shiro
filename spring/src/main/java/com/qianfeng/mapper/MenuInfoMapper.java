package com.qianfeng.mapper;

import com.qianfeng.dto.ModifyRoleMenuDTO;
import com.qianfeng.pojo.MenuInfo;
import com.qianfeng.pojo.RoleMenu;
import com.qianfeng.vo.MenuInfoVO;
import com.qianfeng.vo.MenuListVO;

import java.util.List;

public interface MenuInfoMapper {

    public List<MenuInfo> listParentMenu();

    public List<MenuInfoVO> listMenuByRoleId(int roleId);

    public int removeRoleMenuByMenuId(ModifyRoleMenuDTO modifyRoleMenuDTO);

    public List<RoleMenu> listRoleMenuByRoleId(ModifyRoleMenuDTO modifyRoleMenuDTO);

    public int addRoleMenuByRoleId(ModifyRoleMenuDTO modifyRoleMenuDTO);

    public List<MenuListVO> listAllMenu();
}
