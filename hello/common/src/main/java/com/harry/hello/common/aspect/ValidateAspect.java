package com.harry.hello.common.aspect;

import com.harry.hello.common.utils.LogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Date;

@Aspect
@Component
public class ValidateAspect {

//    @Pointcut("execution (* com.harry.hello.*.serviceimpl.*.*(..))" )
//    private void cut(){ }

    @Before(value = "execution (* com.harry.hello.*.serviceimpl.*.*(..))")
    public void validateNull(JoinPoint joinPoint){
        LogUtil.LOGGER.info("AOP参数检验开始" + new Date());
        String sign = joinPoint.getSignature().toLongString();
        LogUtil.LOGGER.info("方法签名：" + sign );
        Object[] args = joinPoint.getArgs();
        for(int i = 0; i< args.length ;i++){
            if(args[i] == null){
                throw new RuntimeException("第" + (i + 1) + "个参数为空");
            }
        }
        LogUtil.LOGGER.info("AOP参数检验结束" + new Date());
    }

}
