package com.twoc.depots.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twoc.depots.bean.dto.GoodsDTO;
import com.twoc.depots.bean.vo.GoodsVO;
import com.twoc.depots.bean.vo.TradeVO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.MessageUtils;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Goods;
import com.twoc.depots.mapper.GoodsMapper;
import com.twoc.depots.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsService goodsService;

    @Override
    public LayuiData getGoodsList(GoodsDTO goodsDTO) {
        Page tradePage = new Page(goodsDTO.getPage(), goodsDTO.getLimit());
        IPage<GoodsVO> goodsVOIPage = goodsMapper.selectGoods(tradePage, goodsDTO);
        return LayuiData.SETDATA(0, "成功", new Long(goodsVOIPage.getTotal()).intValue(), goodsVOIPage.getRecords(), goodsVOIPage);
    }

    @Override
    public ResultDto selectById(Integer goodsId) {
        GoodsDTO goodsDTO = null;
        Goods goodsId1 = goodsMapper.selectOne(new QueryWrapper<Goods>().eq("goods_id", goodsId));
        if (goodsId1 != null) {
            goodsDTO = new GoodsDTO();
            BeanUtils.copyProperties(goodsId1, goodsDTO);
        } else {
            goodsDTO = new GoodsDTO();
            goodsDTO.setGoodsNumber(0);
        }

        return ResultDto.succeedResult("成功", goodsDTO);

    }

    @Override
    public void selectNumber() {
        List<GoodsVO> goodsVOS = goodsMapper.selectNumber();

        StringBuilder message = new StringBuilder();
        if (goodsVOS != null && goodsVOS.size() != 0) {
            for (int i = 0; i < goodsVOS.size(); i++) {
                message.append(goodsVOS.get(i).getGoodsName() + "、");
                if (i == goodsVOS.size() - 1) {
                    message.append(goodsVOS.get(i).getGoodsName() + ",存储量不足请及时添加库存。");
                }
            }
        }
        MessageUtils.pushGoEasy("ThreeMessage", message.toString());
    }
}
