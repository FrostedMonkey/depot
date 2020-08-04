package com.twoc.depots.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twoc.depots.entity.UR;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface URMapper extends BaseMapper<UR> {
    int roledeleteAllUr(String userId);

    int insertList(Integer[] roleIds, String userId);
}
