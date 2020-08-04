package com.twoc.depots.service;

import com.twoc.depots.bean.dto.GoodsDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;

public interface GoodsService {
    /**
     * 获取商品列表
     *
     * @param goodsDTO
     * @return
     */
    LayuiData getGoodsList(GoodsDTO goodsDTO);

    /**
     * 查询单个物品
     *
     * @param goodsId
     * @return
     */
    ResultDto selectById(Integer goodsId);

    /**
     * 查询库存不足的
     */
    void selectNumber();
}
