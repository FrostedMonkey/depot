package com.twoc.depots.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("depot_dict")
public class Dict {
    /**
     * id
     */
    @TableField("dict_id")
    private Integer dictId;
    /**
     * 商品id
     */
    @TableField("goods_id")
    private Integer goodsId;
    /**
     * 商品所属大类别id
     */
    @TableField("goods_pid")
    private Integer goodsPid;
    /**
     * 大类别名称
     */
    @TableField("goods_pname")
    private String goodsPname;
    /**
     * 商品名称
     */
    @TableField("goods_name")
    private String goodsName;

}
