package com.harry.hello.mapper.common;

import com.harry.hello.entity.common.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<UserRole> selectByUser(Integer uid);
}