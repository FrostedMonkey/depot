package com.twoc.depots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twoc.depots.bean.dto.MenuDTO;
import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.entity.Module;
import com.twoc.depots.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色mapper
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 查询列表
     *
     * @param page
     * @return
     */
    IPage<Role> selectPageVo(Page page);

    /**
     * 查询用户角色信息
     *
     * @param userId
     * @return
     */
    List<RoleDTO> selectByUser(Integer userId);

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    List<RoleDTO> selectAllByUser(Integer userId);

    /**
     * 查询角色资源
     *
     * @param roId
     * @return
     */
    List<MenuDTO> getRoleModules(Integer roId);

    /**
     * 删除原有角色资源
     *
     * @param roleId
     * @return
     */
    int deleteModuleById(Integer roleId);

    /**
     * 角色分资源
     *
     * @param roleId
     * @param mIds
     * @return
     */
    int insertRoleModules(Integer roleId, Integer[] mIds);

    /**
     * 修改多条
     *
     * @param rIds
     * @param rStatus
     * @return
     */
    int updateStatus(@Param("rIds") String[] rIds, @Param("rStatus") String rStatus);
}
