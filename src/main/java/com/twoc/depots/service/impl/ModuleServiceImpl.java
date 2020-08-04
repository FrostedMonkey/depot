package com.twoc.depots.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.twoc.depots.entity.Module;
import com.twoc.depots.mapper.ModuleMapper;
import com.twoc.depots.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public List<Module> selectByRole(Integer roleId) {
        return moduleMapper.selectByRole(roleId);
    }

    @Override
    public List<Module> getAllUrl() {
        return moduleMapper.selectAll();
    }
}
