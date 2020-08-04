package com.twoc.depots.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_module")
public class Module {
    /**
     * 资源id
     */
    @TableField("module_id")
    private Integer moduleId;
    /**
     * 编号
     */
    @TableField("module_pid")
    private Integer modulePid;
    /**
     * 名称
     */
    @TableField("module_name")
    private String moduleName;
    /**
     * url
     */
    @TableField("module_url")
    private String moduleUrl;
    /**
     * 是否菜单
     */
    @TableField("module_ismenu")
    private Integer moduleIsmenu;
    /**
     * 状态
     */
    @TableField("module_status")
    private Integer moduleStatus;

}
