package com.twoc.depots.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@TableName("sys_user")
public class User {
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 用户姓名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户密码
     */
    @TableField("user_pwd")
    private String userPwd;
    /**
     * 用户状态
     */
    @TableField("user_status")
    private Integer userStatus;
    /**
     * 姓名
     */
    @TableField("employee_name")
    private String employeeName;
    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;
    /**
     * 联系地址
     */
    @TableField("employee_address")
    private String employeeAddress;
    /**
     * 出生日期
     */
    @TableField("birthday")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    /**
     * 性别
     */
    @TableField("sex")
    private Integer sex;
    /**
     * 身份证号码
     */
    @TableField("id_card")
    private String idCard;
    /**
     * 用户角色
     */

}
