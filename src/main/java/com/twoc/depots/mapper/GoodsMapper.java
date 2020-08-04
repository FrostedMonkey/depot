package com.twoc.depots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twoc.depots.bean.dto.GoodsDTO;
import com.twoc.depots.bean.dto.TradeDTO;
import com.twoc.depots.bean.vo.GoodsVO;
import com.twoc.depots.entity.Goods;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 查询存储列表
     *
     * @param goodsDTO
     * @return
     */
    IPage<GoodsVO> selectGoods(Page page, GoodsDTO goodsDTO);

    /**
     * 入库修改库存
     *
     * @param tradeDTO
     * @return
     */
    int updateNumber(TradeDTO tradeDTO);

    /**
     * 出库修改库存
     *
     * @param tradeDTO
     * @return
     */
    int updateNumber2(TradeDTO tradeDTO);

    /**
     * 查询货物
     *
     * @param goodsId
     * @return
     */
    Goods selectByGoodsId(Integer goodsId);

    /**
     * 查询库存量不足的
     *
     * @return
     */
    List<GoodsVO> selectNumber();

}
