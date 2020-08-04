package com.twoc.depots.config;

import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.entity.Module;
import com.twoc.depots.entity.Role;
import com.twoc.depots.entity.User;
import com.twoc.depots.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.*;

/**
 * Shiro Realm
 * <p>
 * 授权&登录
 *
 * @version ：1.0.0
 * @date ：Created in 2019/4/24 15:20
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    @Lazy
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Subject subject = SecurityUtils.getSubject();
        UserDTO sysUser = (UserDTO) subject.getPrincipal();
        //定义rolesList存放roleName
        List<String> rolesList = new ArrayList<>();
        //定义permissions存放ModuleName
        List<String> permissions = new ArrayList<>();
        List<RoleDTO> roles = sysUser.getRoles();
        if (roles.size() > 0) {
            for (RoleDTO role : roles) {
                rolesList.add(role.getRoleName());
                List<Module> menus = role.getModules();
                if (menus != null && menus.size() > 0) {
                    for (Module menu : menus) {
                        permissions.add(menu.getModuleUrl());
                        permissions.add(menu.getModuleName());

                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中
        info.addRoles(rolesList);//将角色放入shiro中
        return info;
    }

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        UsernamePasswordToken utoken = (UsernamePasswordToken) authenticationToken;//获取用户输入的token
        String account = utoken.getUsername();

        //根据用户名去查用户信息
        UserDTO user = userService.selectByName(account);
        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUserPwd(), this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
        return info;
    }
}
