package com.twoc.depots.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_rm")
public class RM {
    @TableField("module_id")
    private Integer moduleId;
    @TableField("role_id")
    private Integer roleId;

}
