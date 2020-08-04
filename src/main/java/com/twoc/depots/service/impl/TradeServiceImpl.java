package com.twoc.depots.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twoc.depots.bean.dto.EchartDto;
import com.twoc.depots.bean.dto.TradeDTO;
import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.bean.vo.TradeVO;
import com.twoc.depots.common.HttpUtils;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.MessageUtils;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Goods;
import com.twoc.depots.entity.Trade;
import com.twoc.depots.enums.GoEasyEnum;
import com.twoc.depots.mapper.GoodsMapper;
import com.twoc.depots.mapper.TradeMapper;
import com.twoc.depots.mapper.UserMapper;
import com.twoc.depots.service.TradeService;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeMapper tradeMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public LayuiData selectTrades(TradeDTO tradeDTO) {
        Page tradePage = new Page(tradeDTO.getPage(), tradeDTO.getLimit());
        IPage<TradeVO> tradeVOIPage = tradeMapper.selectPlans(tradePage, tradeDTO);
        return LayuiData.SETDATA(0, "成功", new Long(tradeVOIPage.getTotal()).intValue(), tradeVOIPage.getRecords(), tradeVOIPage);
    }

    @Override
    public ResultDto updateStaus(TradeDTO tradeDTO, HttpSession session) {
        UserDTO loginUser = (UserDTO) session.getAttribute("userLogin");
        int result = 0;
        if (tradeDTO.getTradeStatus() == 1) {
            result = tradeMapper.update(new Trade().setTradeStatus(tradeDTO.getTradeStatus()).setApprovalPerson(loginUser.getEmployeeName()).setApprovalTime(new Date()), new UpdateWrapper<Trade>()
                    .eq("trade_id", tradeDTO.getTradeId()));
            TradeDTO tradeDTO1 = tradeMapper.selectMessageById(tradeDTO.getTradeId());
            if (tradeDTO1 != null) {
                MessageUtils.returnMessageTP13(tradeDTO1.getApplyPerson(), "通过", tradeDTO1.getPhone(), "TP1905013");
            }
            MessageUtils.pushGoEasy("ThreeMessage", "您的申请已处理请及时查看！");

        }
        if (tradeDTO.getTradeStatus() == 2) {
            result = tradeMapper.update(new Trade().setTradeStatus(tradeDTO.getTradeStatus()).setApprovalPerson(loginUser.getEmployeeName()).setApprovalTime(new Date()), new UpdateWrapper<Trade>()
                    .eq("trade_id", tradeDTO.getTradeId()));
            /**
             * 申请被驳回后若类型为出库则将库存还原
             */
            goodsMapper.updateNumber(tradeDTO);
            TradeDTO tradeDTO1 = tradeMapper.selectMessageById(tradeDTO.getTradeId());
            if (tradeDTO1 != null) {
                MessageUtils.returnMessageTP13(tradeDTO1.getApplyPerson(), "被驳回", tradeDTO1.getPhone(), "TP1905013");
            }
            MessageUtils.pushGoEasy("ThreeMessage", "您的申请已处理请及时查看！");
        }
        if (tradeDTO.getTradeStatus() == 5 || tradeDTO.getTradeStatus() == 20) {
            result = tradeMapper.update(new Trade().setTradeStatus(tradeDTO.getTradeStatus()).setCheckoutPerson(loginUser.getEmployeeName()).setCheckoutTime(new Date()), new UpdateWrapper<Trade>().eq("trade_id", tradeDTO.getTradeId()));
        }
        if (tradeDTO.getTradeStatus() == 10 || tradeDTO.getTradeStatus() == 25) {
            result = tradeMapper.update(new Trade().setTradeStatus(tradeDTO.getTradeStatus()).setEnterPerson(loginUser.getEmployeeName()).setEnterTime(new Date()), new UpdateWrapper<Trade>()
                    .eq("trade_id", tradeDTO.getTradeId()));
        }
        if (tradeDTO.getTradeStatus() == 15) {
            System.out.println(tradeDTO);
            result = tradeMapper.update(new Trade().setTradeStatus(tradeDTO.getTradeStatus()).setComeOutPerson(loginUser.getEmployeeName()).setComeOutTime(new Date()), new UpdateWrapper<Trade>()
                    .eq("trade_id", tradeDTO.getTradeId()));
            Goods goods = goodsMapper.selectByGoodsId(tradeDTO.getGoodsId());
            if (goods != null) {
                goodsMapper.updateNumber(tradeDTO);
            } else {
                Goods goods1 = new Goods();
                BeanUtils.copyProperties(tradeDTO, goods1);
                goods1.setGoodsNumber(tradeDTO.getNumber());
                goodsMapper.insert(goods1);
            }

        }
        if (tradeDTO.getTradeStatus() == 30) {
            result = tradeMapper.update(new Trade().setTradeStatus(tradeDTO.getTradeStatus()).setComeOutPerson(loginUser.getEmployeeName()).setComeOutTime(new Date()), new UpdateWrapper<Trade>()
                    .eq("trade_id", tradeDTO.getTradeId()));
        }
        if (result > 0) {
            return ResultDto.succeedResult("操作成功");
        }
        return ResultDto.failResult("操作失败");

    }

    @Override
    public ResultDto addPlan(TradeDTO tradeDTO) {
        System.out.println(tradeDTO);
        Trade trade = new Trade();
        BeanUtils.copyProperties(tradeDTO, trade);
        int result = tradeMapper.insert(trade);
        /**
         * 添加出库申请后，库存减少
         */
        if (tradeDTO.getTradeType() == 1) {
            goodsMapper.updateNumber2(tradeDTO);
        }
        UserDTO userDTO = userMapper.selectByRoleName("仓库主管");
        if (result > 0) {
            if (userDTO != null) {
                MessageUtils.returnMessageTP12(userDTO.getEmployeeName(), userDTO.getPhone(), "TP1905012");
            }
            MessageUtils.pushGoEasy("TwoMessage", "您有一条新的申请需要处理！");

            return ResultDto.succeedResult("添加成功");
        }
        return ResultDto.failResult("添加成功");
    }

    @Override
    public TradeVO selectById(Integer tradeId) {
        Trade trade = tradeMapper.selectOne(new QueryWrapper<Trade>().eq("trade_id", tradeId));
        TradeVO tradeVO = new TradeVO();
        BeanUtils.copyProperties(trade, tradeVO);
        return tradeVO;
    }

    @Override
    public ResultDto updates(TradeDTO tradeDTO) {
        int result = tradeMapper.updates(tradeDTO);
        if (result > 0) {
            return ResultDto.succeedResult("修改成功");
        }
        return ResultDto.failResult("修改失败");
    }

    @Override
    public LayuiData getComeLists(TradeDTO tradeDTO) {
        Page tradePage = new Page(tradeDTO.getPage(), tradeDTO.getLimit());
        List<TradeVO> trade = tradeMapper.selectCome(tradeDTO);
        tradePage.setRecords(trade);
        return LayuiData.SETDATA(0, "成功", new Long(trade.size()).intValue(), trade, tradePage);
    }

    @Override
    public LayuiData getOutLists(TradeDTO tradeDTO) {
        Page tradePage = new Page(tradeDTO.getPage(), tradeDTO.getLimit());
        List<TradeVO> trade = tradeMapper.getOut(tradeDTO);
        tradePage.setRecords(trade);
        return LayuiData.SETDATA(0, "成功", new Long(trade.size()).intValue(), trade, tradePage);
    }

    @Override
    public ResultDto selectExpress(String tradeId) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + "59480b29e53040b3a9cba826adc18184"); //格式为:Authorization:APPCODE 83359fd73fe11248385f570e3c139xxx
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("no", tradeId);
        try {
            HttpResponse response = HttpUtils.doGet("https://wuliu.market.alicloudapi.com", "/kdi", "GET", headers, querys);
            return ResultDto.succeedResult("成功", EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultDto kuaidi(TradeDTO tradeDTO) {
        int result = tradeMapper.updateTrades(tradeDTO);
        if (result > 0) {
            return ResultDto.succeedResult("成功");
        }
        return ResultDto.failResult("失败");
    }

    @Override
    public ResultDto getMessage(Integer tradeType, String goodsPname) {
        List<TradeDTO> list = tradeMapper.getMessage(tradeType, goodsPname);
        List<String> goodsName = new ArrayList<>();
        List<Integer> goodsNumber = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        for (TradeDTO t : list) {
            goodsName.add(t.getGoodsName());
            goodsNumber.add(t.getNumber());
        }
        map.put("goodsName", goodsName);
        map.put("goodsNumber", goodsNumber);
        return ResultDto.succeedResult("成功", map);
    }

    @Override
    public ResultDto getPMessage(Integer tradeType) {
        List<TradeDTO> list = tradeMapper.getPMessage(tradeType);
        List<EchartDto> list1 = new ArrayList<>();
        for (TradeDTO t : list) {
            EchartDto e = new EchartDto();
            e.setName(t.getGoodsPname());
            e.setValue(t.getNumber());
            list1.add(e);
        }
        return ResultDto.succeedResult("成功", list1);
    }

    @Override
    public LayuiData getLog(TradeDTO tradeDTO) {
        Page tradePage = new Page(tradeDTO.getPage(), tradeDTO.getLimit());
        IPage<TradeVO> tradeVOIPage = tradeMapper.selectLog(tradePage, tradeDTO);
        return LayuiData.SETDATA(0, "成功", new Long(tradeVOIPage.getTotal()).intValue(), tradeVOIPage.getRecords(), tradeVOIPage);
    }
}