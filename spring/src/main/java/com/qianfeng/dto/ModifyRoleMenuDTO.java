package com.qianfeng.dto;



import java.util.List;


public class ModifyRoleMenuDTO {
    int roleId;
    List<Integer> menuIds;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "ModifyRoleMenuDTO{" +
                "roleId=" + roleId +
                ", menuIds=" + menuIds +
                '}';
    }
}
