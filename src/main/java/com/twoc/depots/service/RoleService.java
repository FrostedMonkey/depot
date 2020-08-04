package com.twoc.depots.service;

import com.twoc.depots.bean.dto.ModuleDTO;
import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * 角色Service
 */
public interface RoleService {
    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    ResultDto addRole(RoleDTO role);

    /**
     * 修改角色状态
     *
     * @param role
     * @return
     */
    ResultDto updateRole(RoleDTO role);

    /**
     * 查询列表
     *
     * @param role
     * @return
     */
    LayuiData selectList(RoleDTO role);

    /**
     * 查询角色信息
     *
     * @param roleId
     * @return
     */
    Role selectById(Integer roleId);

    /**
     * 修改角色信息
     *
     * @param roleDTO
     * @return
     */
    ResultDto updates(RoleDTO roleDTO);

    /**
     * 查询用户角色
     */
    List<RoleDTO> selectByUser(Integer userId);

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    Map<Integer, RoleDTO> selectRoleByUser(Integer userId);

    /**
     * 角色分权限
     *
     * @param roId
     * @return
     */
    List<ModuleDTO> getRoleModules(Integer roId);

    /**
     * 修改角色权限
     *
     * @param mIds
     * @param roleId
     * @return
     */
    ResultDto setRoleModules(Integer[] mIds, Integer roleId);

    /**
     * 修改多条
     *
     * @param rIds
     * @param rStatus
     * @return
     */
    ResultDto updateStatus(String[] rIds, String rStatus);
}
