package com.test.k12.admin.controller;

import com.github.pagehelper.PageInfo;
import com.test.k12.admin.util.AjaxMessage;
import com.test.k12.admin.util.TableData;
import com.test.k12.pojo.Menu;
import com.test.k12.pojo.Role;
import com.test.k12.service.MenuService;
import com.test.k12.service.RoleService;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lry
 */
@Controller
@RequestMapping("/auth/role.html")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping
    public String page() {
        return "role";
    }

    @RequestMapping(params = "act=table")
    @ResponseBody
    public TableData table(Role role, Integer page, Integer limit) {
        PageInfo<Role> pageInfo = roleService.getRoleList(role, page, limit);
        return new TableData(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping(params = "act=edit")
    @ResponseBody
    public AjaxMessage edit(Role role) {
        try {
            if (role.getId() == null) {//添加
                roleService.addRole(role);
            } else {
                roleService.updateRole(role);
            }
            return new AjaxMessage(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false, "编辑失败");
        }
    }

    @RequestMapping(params = "act=go_edit")
    @ResponseBody
    public Role goEdit(Integer id) {
        return roleService.getRoleById(id);
    }

    @RequestMapping(params = "act=menu_tree")
    @ResponseBody
    public List<Menu> menuTree() {
        return menuService.getMenuTree();
    }

    @RequestMapping(params = "act=role_menu")
    @ResponseBody
    public List<Integer> roleMenu(Integer roleId) {
        return roleService.getRoleMenuIds(roleId);
    }

    @RequestMapping(params = "act=assign_menu")
    @ResponseBody
    public AjaxMessage assign(Integer roleId, Integer[] menuIds) {
        try {
            roleService.addRoleMenu(roleId, menuIds);
            return new AjaxMessage(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(false, "授权失败");
        }
    }
}
