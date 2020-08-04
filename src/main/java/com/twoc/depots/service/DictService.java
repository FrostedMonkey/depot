package com.twoc.depots.service;

import com.twoc.depots.entity.Dict;

import java.util.List;

/**
 * 字典Service
 */
public interface DictService {
    /**
     * 获取主分类
     *
     * @return
     */
    List<Dict> getPdict();

    /**
     * 获取子分类
     *
     * @param goodsPid
     * @return
     */
    List<Dict> getDict(Integer goodsPid);
}
