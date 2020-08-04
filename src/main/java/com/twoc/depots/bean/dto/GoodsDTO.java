package com.twoc.depots.bean.dto;

import lombok.Data;

@Data
public class GoodsDTO {
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 存储数量
     */
    private Integer goodsNumber;
    /**
     * 商品id
     */
    private Integer goodsPid;
    /**
     * 商品名称
     */
    private String goodsPname;
    private int page;
    private int limit;
}
