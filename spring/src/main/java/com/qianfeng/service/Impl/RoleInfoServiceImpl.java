package com.qianfeng.service.Impl;

import com.qianfeng.dto.UserRoleDTO;
import com.qianfeng.mapper.RoleInfoMapper;
import com.qianfeng.service.RoleInfoService;
import com.qianfeng.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    RoleInfoMapper roleInfoMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<RoleInfoVO> listRoleByUserId(int userId) {
        return roleInfoMapper.listRoleByUserId(userId);
    }

    @Transactional
    public boolean addUserRole(UserRoleDTO userRoleDTO) {
        return roleInfoMapper.addUserRole(userRoleDTO)>0;
    }
    @Transactional
    public boolean removeUserRole(UserRoleDTO userRoleDTO) {
        return roleInfoMapper.removeUserRole(userRoleDTO)>0;
    }
}