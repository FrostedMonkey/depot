package com.twoc.depots.service;

import com.twoc.depots.bean.dto.TradeDTO;
import com.twoc.depots.bean.vo.TradeVO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;

import javax.servlet.http.HttpSession;

/**
 * 出入库Service
 */
public interface TradeService {
    /**
     * 查询申请列表
     *
     * @param tradeDTO
     * @return
     */
    LayuiData selectTrades(TradeDTO tradeDTO);

    /**
     * 审核出入库申请
     *
     * @param tradeDTO
     * @return
     */
    ResultDto updateStaus(TradeDTO tradeDTO, HttpSession session);

    /**
     * 添加计划
     *
     * @param tradeDTO
     * @return
     */
    ResultDto addPlan(TradeDTO tradeDTO);

    /**
     * 根据id查询
     *
     * @param tradeId
     * @return
     */
    TradeVO selectById(Integer tradeId);

    /**
     * 更新
     *
     * @param tradeDTO
     * @return
     */
    ResultDto updates(TradeDTO tradeDTO);

    /**
     * 获取入库信息
     *
     * @param tradeDTO
     * @return
     */
    LayuiData getComeLists(TradeDTO tradeDTO);

    /**
     * 获取出库信息
     *
     * @param tradeDTO
     * @return
     */
    LayuiData getOutLists(TradeDTO tradeDTO);

    /**
     * 查询快递信息
     *
     * @return
     */
    ResultDto selectExpress(String tradeId);

    /**
     * 出库
     *
     * @param tradeDTO
     * @return
     */
    ResultDto kuaidi(TradeDTO tradeDTO);

    /**
     * 出入库数据统计
     *
     * @return
     */
    ResultDto getMessage(Integer tradeType, String goodsPname);

    /**
     * 父类型出入库数据
     *
     * @return
     */
    ResultDto getPMessage(Integer tradeType);

    /**
     * 出入库历史
     *
     * @param tradeDTO
     * @return
     */
    LayuiData getLog(TradeDTO tradeDTO);
}
