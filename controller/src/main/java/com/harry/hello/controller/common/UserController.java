package com.harry.hello.controller.common;

import com.harry.hello.common.utils.JsonResult;
import com.harry.hello.common.utils.LogUtil;
import com.harry.hello.common.service.UserService;
import com.harry.hello.entity.common.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @RequestMapping("register")
    public JsonResult register(@Valid User user, BindingResult bindingResult){
        validate(bindingResult);
        userService.addUser(user);
        return new JsonResult(true);
    }

    @RequestMapping("{uid}")
    @RequiresRoles("admin")
    public JsonResult get(@PathVariable Integer uid){
        User user = userService.getById(uid);
        return new JsonResult(user);
    }

    @RequestMapping("login")
    public JsonResult login(String username, String password, Boolean remember){

        //创建subject实例
        Subject subject = SecurityUtils.getSubject();
        LogUtil.LOGGER.info("登录用户名：" + username + "，密码：" + password);
        //判断当前的subject是否登录
        if(subject.isAuthenticated() == true){
            return new JsonResult(JsonResult.SUCCESS,"已登录","success");
        }
        //将用户名和密码存入UsernamePasswordToken中
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //设置记住我
        if(remember != null){
            token.setRememberMe(remember);
        }
        try {
            //将存有用户名和密码的token存进subject中
            subject.login(token);
        } catch (UnknownAccountException uae){
            LogUtil.LOGGER.debug("没有用户名为"+token.getPrincipal()+"的用户",uae);
            return new JsonResult("用户不存在");
        } catch (IncorrectCredentialsException ice){
            LogUtil.LOGGER.debug("用户名为："+token.getPrincipal()+"的用户密码不正确",ice);
            return new JsonResult("密码错误");
        } catch (LockedAccountException lae){
            LogUtil.LOGGER.debug("用户名为："+token.getPrincipal()+"的用户已被冻结",lae);
            return new JsonResult("用户已被冻结");
        }catch (DisabledAccountException dae){
            LogUtil.LOGGER.debug("账号被禁用");
            return new JsonResult("账号被禁用");
        }catch (ExcessiveAttemptsException eae){
            LogUtil.LOGGER.debug("登录失败次数过多");
            return new JsonResult("登录失败次数过多");
        }catch (ExpiredCredentialsException ece){
            LogUtil.LOGGER.debug("密码已过期");
            return new JsonResult("密码已过期");
        } catch (AuthenticationException e){
            LogUtil.LOGGER.debug("登录失败",e);
            return new JsonResult("登录失败:" + e.getMessage());
        }
        //更新用户登录时间
        User user = new User();
        user.setUsername(username);
        user.setLogtime(new Date());
        userService.updateByUsername(user);
        return new JsonResult(JsonResult.SUCCESS,username,"success");
        
    }

    @RequestMapping("logout")
    public JsonResult logout(RedirectAttributes redirectAttributes ){
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
//        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return new JsonResult(JsonResult.SUCCESS,"登出成功","您已安全退出");
    }

    @RequestMapping("notLogin")
    public JsonResult notLogin(){
        return new JsonResult("用户未登录");
    }

//    @RequestMapping("hasLogin")
//    public JsonResult hasLogin(){
//        return new JsonResult(JsonResult.SUCCESS,"success","登录成功");
//    }

//    @RequestMapping("403")
//    public JsonResult _403(){
//        return new JsonResult("无访问权限");
//    }
    
    




}
