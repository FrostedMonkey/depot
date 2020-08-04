package com.twoc.depots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Module;
import com.twoc.depots.entity.Role;
import com.twoc.depots.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询用户权限
     *
     * @return
     */
    List<Module> getModulesOfUser(Integer userId);

    /**
     * 修改用户信息
     *
     * @param userDTO
     * @return
     */
    int updateUser(UserDTO userDTO);

    /**
     * 查询用户
     *
     * @param userDTO
     * @return
     */
    User selectUser(UserDTO userDTO);

    /**
     * 查询用户角色
     *
     * @param userId
     * @return
     */
    List<Role> selectRoleByUserId(Integer userId);

    /**
     * 查询仓库主管
     *
     * @param roleName
     * @return
     */
    UserDTO selectByRoleName(String roleName);

    /**
     * 修改多条
     *
     * @param uIds
     * @param uStatus
     * @return
     */
    int updateStatus(@Param("uIds") String[] uIds, @Param("uStatus") String uStatus);
}
