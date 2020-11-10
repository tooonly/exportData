package com.tooonly.bean;

import java.util.List;

public class Excel {
    private String[] heads;

    private List<List<Object>> bodys;

    public Excel(String[] heads,List<List<Object>> bodys) {
        this.heads = heads;
        this.bodys = bodys;
    }

    public String[] getHeads() {
        return heads;
    }

    public void setHeads(String[] heads) {
        this.heads = heads;
    }

    public List<List<Object>> getBodys() {
        return bodys;
    }

    public void setBodys(List<List<Object>> bodys) {
        this.bodys = bodys;
    }
}
