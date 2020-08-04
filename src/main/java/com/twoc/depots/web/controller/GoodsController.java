package com.twoc.depots.web.controller;

import com.twoc.depots.bean.dto.GoodsDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 查询货物存储详情
     *
     * @param goodsDTO
     * @return
     */
    @GetMapping("/list")
    public LayuiData getGoodsList(GoodsDTO goodsDTO) {
        return goodsService.getGoodsList(goodsDTO);
    }

    /**
     * 根据id查询
     *
     * @param goodsId
     * @return
     */
    @PostMapping("/selectById/{goodsId}")
    public ResultDto getGoodsById(@PathVariable Integer goodsId) {
        return goodsService.selectById(goodsId);
    }
}
