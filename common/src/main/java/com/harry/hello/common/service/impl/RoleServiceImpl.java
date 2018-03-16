package com.harry.hello.common.service.impl;

import com.github.pagehelper.PageInfo;
import com.harry.hello.common.service.RoleService;
import com.harry.hello.entity.common.Role;
import com.harry.hello.entity.common.UserRole;
import com.harry.hello.mapper.common.RoleMapper;
import com.harry.hello.mapper.common.UserRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryByUser(Integer uid) {
        List<Role> roles = roleMapper.selectByUser(uid);
        return roles;
    }

    @Override
    public Role queryById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void delete(Integer id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }
}
