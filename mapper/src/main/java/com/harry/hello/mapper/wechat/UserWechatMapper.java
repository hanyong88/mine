package com.harry.hello.mapper.wechat;

import com.harry.hello.entity.wechat.UserWechat;

public interface UserWechatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWechat record);

    int insertSelective(UserWechat record);

    UserWechat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWechat record);

    int updateByPrimaryKey(UserWechat record);
}