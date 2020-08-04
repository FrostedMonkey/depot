package com.twoc.depots.bean.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class TradeDTO {
    private Integer tradeId;
    private Integer goodsId;
    private Integer number;
    private Integer tradeStatus;
    private Integer tradeType;
    private String goodsName;
    private String goodsPname;
    private String applyPerson;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime;
    private String kuaiDi;
    private String approvalPerson;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date approvalTime;
    private String checkoutPerson;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkoutTime;
    private String enterPerson;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date enterTime;
    private String comeOutPerson;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date comeOutTime;
    private String phone;
    private int page;
    private int limit;
}
