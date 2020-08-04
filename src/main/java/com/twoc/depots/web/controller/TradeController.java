package com.twoc.depots.web.controller;

import com.twoc.depots.bean.dto.TradeDTO;
import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.service.TradeService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 仓库管理Controller
 */
@RestController
@RequestMapping("/trade")
public class TradeController {
    @Autowired
    private TradeService tradeService;

    /**
     * 入库列表
     *
     * @param tradeDTO
     * @return
     */
    @GetMapping("/comeList")
    public LayuiData getComeLists(TradeDTO tradeDTO) {
        return tradeService.getComeLists(tradeDTO);
    }

    /**
     * 出库列表
     *
     * @param tradeDTO
     * @return
     */
    @GetMapping("/outList")
    public LayuiData getOutLists(TradeDTO tradeDTO) {

        return tradeService.getOutLists(tradeDTO);
    }

    /**
     * 修改状态
     *
     * @return
     */
    @PostMapping("/update/{tradeStatus}")
    public ResultDto updateStatus(@RequestBody TradeDTO tradeDTO, @PathVariable Integer tradeStatus, HttpSession session) {
        tradeDTO.setTradeStatus(tradeStatus);
        return tradeService.updateStaus(tradeDTO, session);
    }

    /**
     * 查看快递详情
     *
     * @param kuaiDi
     * @return
     */
    @GetMapping("/express/{kuaiDi}")
    public ResultDto selectExpress(@PathVariable String kuaiDi) {
        return tradeService.selectExpress(kuaiDi);
    }

    /**
     * 添加快递单号
     *
     * @param tradeDTO
     * @return
     */
    @PostMapping("/kuadi")
    public ResultDto outKuaidi(@RequestBody TradeDTO tradeDTO) {
        tradeDTO.setTradeStatus(30);

        return tradeService.kuaidi(tradeDTO);
    }

    /**
     * 出入库报表
     *
     * @param tradeType
     * @param goodsPname
     * @return
     */
    @PostMapping("/echatrs/{tradeType}/{goodsPname}")
    public ResultDto getMessage(@PathVariable Integer tradeType, @PathVariable String goodsPname) {
        return tradeService.getMessage(tradeType, goodsPname);
    }

    /**
     * 获取父分类
     *
     * @return
     */
    @PostMapping("/Yechatrs/{tradeType}")
    public ResultDto getPMessage(@PathVariable Integer tradeType) {
        return tradeService.getPMessage(tradeType);
    }

    /**
     * 获取出入库历史
     */
    @GetMapping("/log")
    public LayuiData getLog(TradeDTO tradeDTO) {
        return tradeService.getLog(tradeDTO);
    }
}
