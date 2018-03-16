package com.harry.hello.common.shiro;

import com.harry.hello.common.service.RoleService;
import com.harry.hello.common.service.UserService;
import com.harry.hello.common.utils.LogUtil;
import com.harry.hello.entity.common.Role;
import com.harry.hello.entity.common.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
//    @Resource
//    private PermissionService permissionService;

    //权限管理
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user  = (User)principals.getPrimaryPrincipal();
        user = userService.getByUsername(user.getUsername());
        if (user == null){
            return null;
        }
        List<Role> roles = roleService.queryByUser(user.getId());
        for(Role role: roles){
            authorizationInfo.addRole(role.getName());
//            List<Permission> permissions = permissionService.queryByRole(role.getId());
//            for(Permission p: permissions){
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
        }
        return authorizationInfo;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //拿到账号（username）
        String username = (String) token.getPrincipal();
        LogUtil.LOGGER.info("用户登录:" + username);
        //检查token的信息
        System.out.println(token.getCredentials());
        User user = userService.getByUsername(username);
        LogUtil.LOGGER.info("用户信息:" + user);
        //更新登录时间
        if (user==null){
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        return info;
    }


}
