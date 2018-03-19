package com.harry.hello.controller.wechat;

import com.harry.hello.common.utils.JsonResult;
import com.harry.hello.entity.wechat.UserWechat;
import com.harry.hello.wechat.service.UserWechatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
@RestController
@RequestMapping("wechat")
public class UserWechatController {

    @Resource
    private UserWechatService userWechatService;

    @RequestMapping("login")
    public JsonResult login(String code, UserWechat userWechat){
        userWechatService.login(code,userWechat);
        return null;
    }




}
