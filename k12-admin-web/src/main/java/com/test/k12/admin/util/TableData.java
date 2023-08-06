package com.test.k12.admin.util;

import java.util.List;

public class TableData<T> {
    private int code;
    private String msg;
    private long count;
    private List<T> data;

    public TableData() {

    }

    public TableData(long count, List<T> data) {
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
