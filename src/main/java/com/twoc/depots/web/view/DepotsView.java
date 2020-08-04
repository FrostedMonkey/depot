package com.twoc.depots.web.view;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepotsView {
    /**
     * 申请页面
     *
     * @return
     */
    @RequiresPermissions("出入库申请")
    @RequestMapping("/plan/toPlan")
    public String toPlan() {
        return "plan";
    }

    /**
     * 入库页面
     *
     * @return
     */
    @RequiresPermissions("入库管理")
    @RequestMapping("/depot/toCome")
    public String toCome() {
        return "come";
    }

    /**
     * 出库页面
     *
     * @return
     */
    @RequiresPermissions("出库管理")
    @RequestMapping("/depot/toOut")
    public String toOut() {
        return "out";
    }

    /**
     * 仓储页面
     *
     * @return
     */
    @RequiresPermissions("仓库存储")
    @RequestMapping("/goods/toGoods")
    public String toGoods() {
        return "goods";
    }

    /**
     * 出库历史
     *
     * @return
     */
    @RequiresPermissions("出库统计")
    @RequestMapping("/depot/toOutEcharts")
    public String toEcharts() {
        return "echarts";
    }

    /**
     * 入库历史
     *
     * @return
     */
    @RequiresPermissions("入库统计")
    @RequestMapping("/depot/toComeEcharts")
    public String toComeEcharts() {
        return "echarts2";
    }

    /**
     * 出入库历史数据
     *
     * @return
     */
    @GetMapping(value = "/depot/toLog")
    public String toLog() {
        return "log";
    }

    @GetMapping("/ceshi")
    public String toLogs() {
        return "demo";
    }
}
