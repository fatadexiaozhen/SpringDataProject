package com.imooc.domain;

import javax.persistence.Entity;
import java.util.HashMap;
import java.util.List;

@Entity
public class LayuiResponse extends HashMap<String,Object> {
    private Integer code = 0;
    private String msg = "";
    private Integer count;
    private List<?> data;
    private String filepath;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
