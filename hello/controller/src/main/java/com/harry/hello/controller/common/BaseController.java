package com.harry.hello.controller.common;

import com.harry.hello.common.utils.JsonResult;
import com.harry.hello.common.utils.LogUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class BaseController {

    @ExceptionHandler(Exception.class)
    public JsonResult exception(Exception e){
        LogUtil.LOGGER.error(e.getMessage(),e);
        return new JsonResult(e.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public JsonResult unauthorizedException(UnauthorizedException e){
        LogUtil.LOGGER.error("用户无访问权限",e);
        return new JsonResult("无访问权限");

    }

    //Bean 参数检验的方法
    public void validate(BindingResult bindingResult){
        StringBuffer sb = new StringBuffer();
        if(!bindingResult.hasErrors()){
            return;
        }
        for(ObjectError objectError : bindingResult.getAllErrors()){
            FieldError error = (FieldError)objectError;
            sb.append(error.getField());
            sb.append(objectError.getDefaultMessage());
        }
        throw new RuntimeException(sb.toString());
    }


}
