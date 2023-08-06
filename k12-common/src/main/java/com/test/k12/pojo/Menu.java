package com.test.k12.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lry
 */
public class Menu {
    //easyui要求的属性必须是这几个
    private Integer id;
    private Integer parentId;
    private String text;
    private String url;
    private List<Menu> children = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
