package com.test.k12.service;

import com.test.k12.pojo.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getMenuTree();

    //批量删除
    void deleteMenus(Integer[] ids);

    void addMenu(Menu menu);

    Menu getMenuById(Integer id);

    void updateMenu(Menu menu);

    List<Menu> getUserMenuTree(Integer userId);

    List<Menu> getUserMenu(Integer userId);
}
