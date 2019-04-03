package com.imooc.domain;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Table{
    private String tablename;
    private List<Field> fieldList;
    private Integer length;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
