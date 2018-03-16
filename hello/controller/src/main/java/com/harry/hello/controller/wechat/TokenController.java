package com.harry.hello.controller.wechat;

import com.harry.hello.controller.common.BaseController;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequestMapping("token")
@RestController
public class TokenController extends BaseController {

    private static final String TOKEN = "HANY09";

    /**
     * 验证调用者是否为微信服务器
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param echostr 随机字符串
     * @return
     */
    @RequestMapping("check")
    public String check(String signature, String timestamp, String nonce, String echostr){
        //1）将token、timestamp、nonce三个参数进行字典序排序
        if(signature == null || timestamp == null || nonce == null || echostr == null){
            throw new RuntimeException("参数不能为空");
        }
        String[] strs = {TOKEN,timestamp,nonce};
        Arrays.sort(strs);
        //2）将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
        }
        String mine = DigestUtils.sha1Hex(sb.toString());
        //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        boolean isValid =  signature.equals(mine);
        if(isValid){
            return echostr;
        }
        return null;
    }
}
