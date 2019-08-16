package com.qianfeng.service;

import com.qianfeng.dto.UserRoleDTO;
import com.qianfeng.vo.RoleInfoVO;

import java.util.List;

public interface RoleInfoService {
    public List<RoleInfoVO> listRoleByUserId(int userId);

    public boolean addUserRole(UserRoleDTO userRoleDTO);

    public boolean removeUserRole(UserRoleDTO userRoleDTO);
}
