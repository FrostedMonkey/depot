package com.twoc.depots.bean.dto;

import com.twoc.depots.entity.Module;
import com.twoc.depots.entity.Role;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserDTO implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPwd;
    /**
     * 用户状态
     */
    @NotNull(message = "用户状态不能为空")
    private Integer userStatus;
    /**
     * 姓名
     */
    private String employeeName;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 联系地址
     */
    private String employeeAddress;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 身份证号码
     */
    private String idCard;
    private List<RoleDTO> roles;
    private int page;
    private int limit;

    public interface Add {

    }

    public interface Updates {

    }
}
