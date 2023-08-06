package com.test.k12.service.impl;

import com.test.k12.dao.MenuDAO;
import com.test.k12.pojo.Menu;
import com.test.k12.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lry
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO menuDAO;

    //获取菜单树
    @Override
    public List<Menu> getMenuTree() {
        List<Menu> menus = menuDAO.getAllMenu();//查询所有menu
        return makeMenuTree(menus);
    }

    public List<Menu> makeMenuTree(List<Menu> menus) {
        List<Menu> firstMenu = new ArrayList<>();//一级菜单的集合
        Map<Integer, Menu> menuMap = new HashMap<>();
        for (Menu menu : menus) {
            menuMap.put(menu.getId(), menu);
            if (menu.getParentId() == null) {//没有父节点，它是一级菜单
                firstMenu.add(menu);
            }
        }
        for (Menu menu : menus) {
            //父节点不是null,代表它是子节点；并且它的父节点存在，是有效节点
            if (menu.getParentId() != null && menuMap.containsKey(menu.getParentId())) {
                //根据父节点id找到父节点,并且把子节点放到父节点的children里
                menuMap.get(menu.getParentId()).getChildren().add(menu);
            }
        }
        return firstMenu;
    }

    @Override
    public void deleteMenus(Integer[] ids) {
        for (Integer id : ids) {
            menuDAO.updateParentId(id);//将子菜单变成一级菜单
            menuDAO.deleteMenu(id);
        }
    }

    @Override
    public void addMenu(Menu menu) {
        menuDAO.addMenu(menu);
    }

    @Override
    public Menu getMenuById(Integer id) {
        return menuDAO.getMenuById(id);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuDAO.updateMenu(menu);
    }

    @Override
    public List<Menu> getUserMenuTree(Integer userId) {
        List<Menu> menus = menuDAO.getUserMenu(userId);
        return makeMenuTree(menus);
    }

    @Override
    public List<Menu> getUserMenu(Integer userId) {
        return menuDAO.getUserMenu(userId);
    }
}
