package com.twoc.depots.web.controller;

import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.bean.dto.TradeDTO;
import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.bean.vo.TradeVO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;


@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private TradeService tradeService;

    /**
     * 查询出入库申请列表
     *
     * @param tradeDTO
     * @return
     */
    @GetMapping("/list")
    public LayuiData selectList(TradeDTO tradeDTO) {
        return tradeService.selectTrades(tradeDTO);
    }

    /**
     * 审核申请
     *
     * @return
     */
    @PostMapping("/update/{tradeId}/{tradeStatus}")
    public ResultDto updateStaus(@PathVariable Integer tradeId, @PathVariable Integer tradeStatus, HttpSession session, @RequestBody TradeDTO tradeDTO) {

        tradeDTO.setTradeId(tradeId);
        tradeDTO.setTradeStatus(tradeStatus);
        return tradeService.updateStaus(tradeDTO, session);
    }


    /**
     * 添加计划
     *
     * @return
     */
    @PostMapping("/add")
    public ResultDto addRole(@RequestBody TradeDTO tradeDTO, HttpSession session) {
        UserDTO loginUser = (UserDTO) session.getAttribute("userLogin");
        tradeDTO.setApplyPerson(loginUser.getEmployeeName());
        tradeDTO.setApplyTime(new Date());
        //添加当前用户
        return tradeService.addPlan(tradeDTO);
    }

    /**
     * 查询计划信息
     *
     * @return
     */
    @PostMapping("/selectById/{tradeId}")
    public TradeVO selectById(@PathVariable Integer tradeId) {
        return tradeService.selectById(tradeId);
    }

    /**
     * 修改状态
     *
     * @param tradeDTO
     * @return
     */
    @PostMapping("/updates")
    public ResultDto updates(@RequestBody TradeDTO tradeDTO) {
        return tradeService.updates(tradeDTO);
    }
}
