package com.twoc.depots.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@TableName("sys_role")
public class Role {
    /**
     * id
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 名称
     */
    @TableField("role_name")
    private String roleName;
    /**
     * 备注
     */
    @TableField("role_remark")
    private String roleRemark;
    /**
     * 状态
     */
    @TableField("role_status")
    private Integer roleStatus;


}