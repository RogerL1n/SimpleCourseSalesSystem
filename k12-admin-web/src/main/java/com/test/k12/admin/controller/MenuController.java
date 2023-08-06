package com.test.k12.admin.controller;

import com.test.k12.admin.util.AjaxMessage;
import com.test.k12.pojo.Menu;
import com.test.k12.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lry
 */
@Controller
@RequestMapping("/auth/menu.html")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping//进入controller默认执行的方法
    public String page() {
        return "menu";
    }

    @RequestMapping(params = "act=tree")
    @ResponseBody
    public List<Menu> tree() {
        return menuService.getMenuTree();
    }

    @RequestMapping(params = "act=go_edit")
    @ResponseBody
    public Menu goEdit(Integer id, Model model) {
        return menuService.getMenuById(id);
    }

    @RequestMapping(params = "act=edit")
    @ResponseBody
    public AjaxMessage edit(Menu menu) {
        try {
            if (menu.getId() == null) {//添加
                menuService.addMenu(menu);
            } else {//修改
                menuService.updateMenu(menu);
            }
            return new AjaxMessage(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false, "编辑失败");
        }
    }

    @RequestMapping(params = "act=delete")
    @ResponseBody
    public AjaxMessage delete(Integer[] ids) {
        try {
            menuService.deleteMenus(ids);
            return new AjaxMessage(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false, "删除失败");
        }
    }
}
