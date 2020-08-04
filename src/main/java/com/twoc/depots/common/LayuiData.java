package com.twoc.depots.common;

import lombok.Data;

@Data
public class LayuiData {
    private int code;
    private String msg;
    private int count;
    private Object data;
    private Object pageInfo;

    public static LayuiData SETDATA(int code, String msg, int count, Object obj, Object pageInfo) {
        LayuiData data = new LayuiData();
        data.setCode(code);
        data.setMsg(msg);
        data.setCount(count);
        data.setData(obj);
        data.setPageInfo(pageInfo);
        return data;
    }

    @Override
    public String toString() {
        return "LayuiData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                ", pageInfo=" + pageInfo +
                '}';
    }
}


