package com.twoc.depots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twoc.depots.bean.dto.GoodsDTO;
import com.twoc.depots.bean.dto.TradeDTO;
import com.twoc.depots.bean.vo.GoodsVO;
import com.twoc.depots.bean.vo.TradeVO;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Trade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TradeMapper extends BaseMapper<Trade> {
    /**
     * 查询申请列表
     *
     * @param tradeDTO
     * @return
     */
    IPage<TradeVO> selectPlans(Page page, @Param("tradeDTO") TradeDTO tradeDTO);

    /**
     * 更新
     *
     * @param tradeDTO
     * @return
     */
    int updates(TradeDTO tradeDTO);

    /**
     * 查询出库信息
     *
     * @param tradeDTO
     * @return
     */
    List<TradeVO> getOut(TradeDTO tradeDTO);

    /**
     * 查询入库信息
     *
     * @param tradeDTO
     * @return
     */
    List<TradeVO> selectCome(TradeDTO tradeDTO);

    /**
     * 出库
     *
     * @param tradeDTO
     * @return
     */
    int updateTrades(TradeDTO tradeDTO);

    /**
     * 出入库信息统计
     *
     * @return
     */
    List<TradeDTO> getMessage(@Param("tradeType") Integer tradeType, @Param("goodsPname") String goodsPname);

    /**
     * 父类型出入库数据
     *
     * @return
     */
    List<TradeDTO> getPMessage(Integer tradeType);

    /**
     * 根据单号查询
     *
     * @param tradeId
     * @return
     */
    TradeDTO selectMessageById(Integer tradeId);

    /**
     * 查询出入库历史
     *
     * @param tradePage
     * @param tradeDTO
     * @return
     */
    IPage<TradeVO> selectLog(Page tradePage, @Param("tradeDTO") TradeDTO tradeDTO);
}
