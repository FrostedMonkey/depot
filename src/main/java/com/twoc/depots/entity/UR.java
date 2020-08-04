package com.twoc.depots.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_ur")
public class UR {
    @TableField("user_id")
    private Integer userId;
    @TableField("role_id")
    private Integer roleId;

}
