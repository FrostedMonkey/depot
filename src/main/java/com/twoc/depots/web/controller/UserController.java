package com.twoc.depots.web.controller;


import com.twoc.depots.bean.dto.GoodsDTO;
import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.config.MD5Util;
import com.twoc.depots.entity.Goods;
import com.twoc.depots.entity.Role;
import com.twoc.depots.entity.User;
import com.twoc.depots.service.GoodsService;
import com.twoc.depots.service.RoleService;
import com.twoc.depots.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户Controller
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 查询用户列表
     *
     * @param userDTO
     * @return
     */
    @GetMapping(value = "/list")
    public LayuiData selectList(UserDTO userDTO) {
        return userService.selectList(userDTO);

    }

    /**
     * 修改用户状态
     *
     * @return
     */
    @PostMapping(value = "/update/{userId}/{userStaus}", consumes = "application/json")
    public ResultDto updateUserStatus(@PathVariable Integer userId, @PathVariable Integer userStaus) {
        UserDTO user = new UserDTO();
        user.setUserId(userId);
        user.setUserStatus(userStaus);
        return userService.updateUserStatus(user);
    }

    /**
     * 添加用户信息
     *
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/add", consumes = "application/json")
    public ResultDto addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    @PostMapping(value = "/selectById/{userId}", consumes = "application/json")
    public User selectById(@PathVariable Integer userId) {
        return userService.selectById(userId);
    }

    /**
     * 修改用户信息
     *
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/updates", consumes = "application/json")
    public ResultDto updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @GetMapping(value = "/doLogin")
    public ResultDto doLogin(UserDTO userDTO, HttpSession session) {
        System.out.println("aaaaaaaaaaaa");
        System.out.println(userDTO);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userDTO.getUserName(), userDTO.getUserPwd());
        System.out.println("bbbbbbbbbb");
        System.out.println(token);
        try {
            subject.login(token);
            UserDTO u = (UserDTO) subject.getPrincipal();
            session.setAttribute("userLogin", u);
            List<Role> roles = userService.selectRoleByUserId(u.getUserId());
            session.setAttribute("userRoles", roles);
            return ResultDto.succeedResult();
        } catch (UnknownAccountException e) {
            return ResultDto.failResult("用户名不存在");
        } catch (IncorrectCredentialsException e) {
            return ResultDto.failResult("密码错误");
        }
    }

    /**
     * 用户分配权限
     *
     * @param roleIds
     * @param userId
     * @return
     */
    @PostMapping(value = "/quanx/{userId}")
    public ResultDto getRole(@RequestBody Integer[] roleIds, @PathVariable String userId) {
        return userService.getRole(roleIds, userId);
    }


    /**
     * 注册
     *
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/regist")
    public ResultDto UserRegist(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    /**
     * 更新用信息
     *
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/updateUser")
    public ResultDto UserUpdate(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    /**
     * 根据id查询用户信息
     *
     * @param userId
     * @return
     */
    @PostMapping(value = "/selectUser/{userId}")
    public User UserRegist(@PathVariable Integer userId) {
        return userService.selectById(userId);
    }

    @PostMapping(value = "selectOld/{userId}/{oldPwd}/{userName}")
    public ResultDto checkPwd(@PathVariable Integer userId, @PathVariable String oldPwd, @PathVariable String userName) {
        User user = userService.selectById(userId);
        if (user.getUserPwd().equals(MD5Util.GetMD5Object(userName, oldPwd).toString())) {
            return ResultDto.succeedResult();
        } else {
            return ResultDto.failResult();
        }
    }

    /**
     * 修改密码
     *
     * @param userId
     * @param userPwd
     * @param userName
     * @return
     */
    @PostMapping(value = "/updatePwd/{userId}/{userPwd}/{userName}")
    public ResultDto updatePwd(@PathVariable Integer userId, @PathVariable String userPwd, @PathVariable String userName) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setUserPwd(MD5Util.GetMD5Object(userName, userPwd).toString());
        return userService.updateUser(userDTO);
    }

    /**
     * 同事修改多个用户状态
     *
     * @param uIds
     * @param uStatus
     * @return
     */
    @PostMapping("/status/{uStatus}")
    public ResultDto updateStatus(@RequestBody String[] uIds, @PathVariable String uStatus) {
        return userService.updateStatus(uIds, uStatus);
    }

    @PostMapping("/getMessage")
    public ResultDto GetMessgae() {
        goodsService.selectNumber();
        System.out.println("===================================");
        return ResultDto.succeedResult();
    }
}
