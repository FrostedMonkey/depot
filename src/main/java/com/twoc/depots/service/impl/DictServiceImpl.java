package com.twoc.depots.service.impl;

import com.twoc.depots.entity.Dict;
import com.twoc.depots.mapper.DictMapper;
import com.twoc.depots.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;

    @Override
    public List<Dict> getPdict() {
        return dictMapper.selectPdict();
    }

    @Override
    public List<Dict> getDict(Integer goodsPid) {
        List<Dict> dicts = dictMapper.selectDict(goodsPid);
        List<Dict> dictList = new ArrayList<>();
        for (Dict d : dicts) {
            if (d != null) {
                dictList.add(d);
            }
        }
        return dictList;
    }

}
