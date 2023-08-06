package com.test.k12.dao;

import com.test.k12.pojo.Menu;

import java.util.List;

public interface MenuDAO {
    List<Menu> getAllMenu();

    void deleteMenu(Integer id);

    void addMenu(Menu menu);

    Menu getMenuById(Integer id);

    void updateMenu(Menu menu);

    void updateParentId(Integer id);


    List<Menu> getUserMenu(Integer userId);
}
