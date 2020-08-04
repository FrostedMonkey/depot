package com.twoc.depots.enums;

public enum GoEasyEnum {
    /**
     * 系统管理员消息
     */
    SysMessage(1, "SysMessage"),
    /**
     * 仓库主管消息
     */
    TwoMessage(2, "TwoMessage"),
    /**
     * 仓库管理员消息
     */
    ThreeMessage(3, "ThreeMessage");


    // 成员变量
    private Integer code;
    private String name;

    // 构造方法
    private GoEasyEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(String code) {
        for (GoEasyEnum status : GoEasyEnum.values()) {
            if (status.code.equals(code)) {
                return status.name;
            }
        }
        return code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
