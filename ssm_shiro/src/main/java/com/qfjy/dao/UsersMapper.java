package com.qfjy.dao;

import com.qfjy.pojo.Users;
import org.apache.ibatis.annotations.Select;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    //根据用户名查询用户对象是否存在
    @Select("select * from users where username=#{username}")
    Users selectByUsername(String username);
}