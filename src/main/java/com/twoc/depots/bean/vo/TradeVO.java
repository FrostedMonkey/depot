package com.twoc.depots.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TradeVO {
    /**
     * 交易单号
     */
    private Integer tradeId;
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 员工id
     */
    private Integer employeeId;
    /**
     * 受理时间
     */
    private Date updateAt;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 状态
     */
    private Integer tradeStatus;

    /**
     * 类型 0：入库 1：出库
     */
    private Integer tradeType;
    private String employeeName;
    private String comeOutPerson;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String comeOutTime;
    private String applyPerson;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String applyTime;
    private Integer userId;
    private Integer goodsPId;
    private String goodsName;
    private String goodsPname;

    private String kuaiDi;
}
