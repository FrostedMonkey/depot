package com.twoc.depots.web.view;

import com.twoc.depots.bean.dto.ModuleDTO;
import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.service.RoleService;
import com.twoc.depots.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class SaftView {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 角色页面
     *
     * @return
     */
    /*  @RequiresRoles("系统管理员")*/
    @RequiresPermissions("/role/toRole")
    @GetMapping("/role/toRole")
    public String toRole() {
        return "role";
    }

    /**
     * 用户页面
     *
     * @return
     */
    @RequiresPermissions("/user/toUser")
    @GetMapping(value = "/user/toUser")
    public String toUser() {
        return "user";
    }

    /**
     * 登录页面
     *
     * @return
     */
    @GetMapping(value = "/saft/login_to")
    public String toLogin() {
        return "loginIndex";
    }

    /**
     * 主页
     *
     * @return
     */
    @GetMapping(value = "/saft/home_to")
    public String toHome() {
        return "index";
    }

    /**
     * 用户分角色
     *
     * @param userId
     * @param model
     * @param session
     * @param request
     * @return
     */
    @GetMapping(value = "/user/doUser/{userId}")
    public String doUser(@PathVariable Integer userId, Model model, HttpSession session, HttpServletRequest request) {
        Map<Integer, RoleDTO> integerRoleDTOMap = roleService.selectRoleByUser(userId);
        model.addAttribute("roles", integerRoleDTOMap);
        request.setAttribute("nowUserId", userId);
        return "editUser";
    }

    /**
     * 角色分权限
     *
     * @param roleId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/role/doRole/{roleId}", method = RequestMethod.GET)
    public String roleModule(@PathVariable Integer roleId, Model model, HttpServletRequest request) {
        List<ModuleDTO> list = roleService.getRoleModules(roleId);
        request.setAttribute("nowRoleId", roleId);
        model.addAttribute("menuList", list);
        return "editRole";
    }

    /**
     * 异常页面
     *
     * @return
     */
    @GetMapping(value = "/403")
    public String error() {
        return "403";
    }

    /**
     * 退出
     *
     * @param session
     * @return
     */
    @GetMapping("/user/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "loginIndex";
    }

    @GetMapping("/user/exit2")
    public String exit2() {
        return "loginIndex";
    }


}
