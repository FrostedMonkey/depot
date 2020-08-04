package com.twoc.depots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twoc.depots.entity.Module;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ModuleMapper extends BaseMapper<Module> {
    /**
     * 查询用户权限
     *
     * @param roleId
     * @return
     */
    List<Module> selectByRole(Integer roleId);

    /**
     * 根据角色id查询权限
     *
     * @param userId
     * @return
     */
    List<Module> selectByRoleId(Integer userId);

    /**
     * 查询所有权限
     *
     * @return
     */
    List<Module> selectAll();
}
