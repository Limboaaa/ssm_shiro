package com.qianfeng.mapper;

import com.qianfeng.dto.UserRoleDTO;
import com.qianfeng.pojo.RoleInfo;
import com.qianfeng.vo.RoleInfoVO;

import java.util.List;

public interface RoleInfoMapper {
    public RoleInfo selectRoleInfoById(int id);

    public List<RoleInfoVO> listRoleByUserId(int userId);

    public int addUserRole(UserRoleDTO userRoleDTO);

    public int removeUserRole(UserRoleDTO userRoleDTO);
}
