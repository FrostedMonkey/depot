package com.twoc.depots.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;


@Data
@Accessors(chain = true)
@TableName("depot_trade")
public class Trade {
    /**
     * 交易单号
     */
    @TableField("trade_id")
    private Integer tradeId;
    /**
     * 商品id
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 数量
     */
    @TableField("number")
    private Integer number;
    /**
     * 状态
     */
    @TableField("trade_status")
    private Integer tradeStatus;

    /**
     * 类型 0：入库 1：出库
     */
    @TableField("trade_type")
    private Integer tradeType;
    /**
     * 申请人
     */
    @TableField(value = "apply_person")
    private String applyPerson;
    /**
     * 申请时间
     */
    @TableField(value = "apply_time")
    private Date applyTime;
    /**
     * 审核人
     */
    @TableField("approval_person")
    private String approvalPerson;
    /**
     * 审核时间
     */
    @TableField(value = "approval_time")
    private Date approvalTime;
    /**
     * 检验人
     */
    @TableField("checkout_person")
    private String checkoutPerson;
    /**
     * 检验时间
     */
    @TableField(value = "checkout_time")
    private Date checkoutTime;
    /**
     * 确认人
     */
    @TableField("enter_person")
    private String enterPerson;
    /**
     * 确认时间
     */
    @TableField(value = "enter_time")
    private Date enterTime;
    /**
     * 出入库确认人
     */
    @TableField("come_out_person")
    private String comeOutPerson;
    /**
     * 出入库时间
     */
    @TableField(value = "come_out_time")
    private Date comeOutTime;


}
