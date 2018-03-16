package com.harry.hello.common.service;

import com.harry.hello.entity.common.User;

public interface UserService {

    /**
     * 通过ID查询用户
     * @param uid
     * @return
     */
    public User getById(Integer uid);

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    public User getByUsername(String username);

    public void addUser(User user);

    public void deleteUser(Integer id);

    public void updateById(User user);

    public void updateByUsername(User user);

}
