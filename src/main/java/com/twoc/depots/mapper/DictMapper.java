package com.twoc.depots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twoc.depots.entity.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DictMapper extends BaseMapper<Dict> {
    /**
     * 获取主分类
     *
     * @return
     */
    List<Dict> selectPdict();

    /**
     * 获取子分类
     *
     * @return
     */
    List<Dict> selectDict(Integer goodsPid);
}
