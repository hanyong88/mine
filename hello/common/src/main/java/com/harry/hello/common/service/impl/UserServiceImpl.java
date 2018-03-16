package com.harry.hello.common.service.impl;

import com.harry.hello.entity.common.User;
import com.harry.hello.mapper.common.UserMapper;
import com.harry.hello.common.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getById(Integer uid) {
        User user = userMapper.selectByPrimaryKey(uid);
        user.setPassword(null);
        return user;
    }

    @Override
    public User getByUsername(String username) {
        User user  = userMapper.selectByUsername(username);
        return user;
    }

    @Override
    public void addUser(User user) {
        String password = user.getPassword();
        password = DigestUtils.md5Hex(password);
        user.setPassword(password);
        user.setRegtime(new Date());
        userMapper.insert(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updateByUsername(User user) {
        userMapper.updateByUsernameSelective(user);
    }
}
