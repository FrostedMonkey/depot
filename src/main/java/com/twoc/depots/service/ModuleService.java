package com.twoc.depots.service;

import com.twoc.depots.entity.Module;

import java.util.List;

/**
 * 资源Service
 */
public interface ModuleService {
    /**
     * 根据角色id查询资源
     *
     * @param roleId
     * @return
     */
    List<Module> selectByRole(Integer roleId);

    /**
     * 获取所有权限
     *
     * @return
     */
    List<Module> getAllUrl();
}
