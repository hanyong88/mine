package com.harry.hello.wechat.service;

import com.harry.hello.entity.wechat.UserWechat;

import java.io.IOException;

public interface UserWechatService {

    public void login(String code,UserWechat userWechat);

}
