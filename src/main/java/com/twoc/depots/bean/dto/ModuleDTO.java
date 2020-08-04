package com.twoc.depots.bean.dto;

import lombok.Data;

import java.util.List;

@Data
public class ModuleDTO {

    private Integer moduleId;

    private String moduleName;

    private String moduleUrl;

    private boolean checked;
    private List<ModuleDTO> subMenuList;
}
