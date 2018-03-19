package com.harry.hello.wechat.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harry.hello.common.utils.HttpUtil;
import com.harry.hello.common.utils.LogUtil;
import com.harry.hello.entity.wechat.UserWechat;
import com.harry.hello.wechat.service.UserWechatService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service("userWechatService")
public class UserWechatServiceImpl implements UserWechatService {

    private String loginUrl = "https://api.weixin.qq.com/sns/jscode2session";

    @Value("${appID}")
    private String appID;
    @Value("${appSecret}")
    private String appSecret;

    @Override
    public void login(String code, UserWechat userWechat){
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("appID",appID);
        params.put("appSecret",appSecret);
        params.put("grant_type","authorization_code");
        params.put("js_code",code);
        String res = HttpUtil.post(loginUrl,null,params);
        Map<String,String> map = null;
        try {
            map = new ObjectMapper().readValue(res,Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.LOGGER.error("数据转换失败:",e);
        }
        LogUtil.LOGGER.info("结果：" + map);
    }
}
