package com.harry.hello.common.service;

import com.github.pagehelper.PageInfo;
import com.harry.hello.entity.common.Role;

import java.util.List;

public interface RoleService {

    public List<Role> queryByUser(Integer uid);

    public Role queryById(Integer id);

    public void add(Role role);

    public void delete(Integer id);

    public void update(Role role);


}
