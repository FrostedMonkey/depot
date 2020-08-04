package com.twoc.depots.web.controller;

import com.twoc.depots.entity.Dict;
import com.twoc.depots.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DictController {

    @Autowired
    private DictService dictService;

    /**
     * 获取主分类
     *
     * @return
     */
    @PostMapping("/dict/getPdict")
    public List<Dict> getPdict() {
        return dictService.getPdict();
    }

    /**
     * 获取子分类
     *
     * @param goodsPid
     * @return
     */
    @PostMapping("/dict/getDict/{goodsPid}")
    public List<Dict> getDict(@PathVariable Integer goodsPid) {
        return dictService.getDict(goodsPid);
    }

}
