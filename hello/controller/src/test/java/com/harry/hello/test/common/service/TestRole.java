package com.harry.hello.test.common.service;

import com.github.pagehelper.PageInfo;
import com.harry.hello.common.service.RoleService;
import com.harry.hello.common.utils.LogUtil;
import com.harry.hello.entity.common.Role;
import com.harry.hello.test.base.BaseCase;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class TestRole extends BaseCase {

    @Resource
    private RoleService roleService;

    @Test
    public void testQueryByUser(){
        int userId = 2;
        PageInfo<Role> pageInfo = roleService.queryByUser(userId);
        for(Role role : pageInfo.getList()){
            LogUtil.LOGGER.info(role.toString());
        }
    }

    @Test
    public void testQueryById(){
        int id = 1;
        Role role = roleService.queryById(id);
        LogUtil.LOGGER.info(role.toString());
    }


}
