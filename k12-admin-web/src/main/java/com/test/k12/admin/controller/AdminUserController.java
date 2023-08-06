package com.test.k12.admin.controller;

import com.github.pagehelper.PageInfo;
import com.test.k12.admin.util.AjaxMessage;
import com.test.k12.admin.util.TableData;
import com.test.k12.pojo.AdminUser;
import com.test.k12.pojo.Role;
import com.test.k12.service.AdminUserService;
import com.test.k12.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lry
 */
@Controller
@RequestMapping("/auth/adminuser.html")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private RoleService roleService;

    @RequestMapping
    public String page() {
        return "admin_user";
    }

    @RequestMapping(params = "act=table")
    @ResponseBody
    public TableData table(AdminUser adminUser, Integer page, Integer limit) {
        PageInfo<AdminUser> pageInfo = adminUserService.getUserList(adminUser, page, limit);
        return new TableData(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping(params = "act=role_tree")
    @ResponseBody
    public List<Role> roleList() {
        return roleService.getRoleList(null);
    }

    @RequestMapping(params = "act=assign_role")
    @ResponseBody
    public AjaxMessage assignRole(Integer userId, Integer[] roleIds) {
        try {
            adminUserService.addUserRole(userId, roleIds);
            return new AjaxMessage(true, "分配成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage(false, "分配失败");
    }

    @RequestMapping(params = "act=user_role")
    @ResponseBody
    public List<Integer> userRole(Integer userId) {
        return adminUserService.getUserRoleIds(userId);
    }

    @RequestMapping(params = "act=go_edit")
    @ResponseBody
    public AdminUser goEdit(Integer id) {
        return adminUserService.getUserById(id);
    }

    @RequestMapping(params = "act=edit")
    @ResponseBody
    public AjaxMessage edit(AdminUser adminUser) {
        try {
            if (adminUser.getId() == null) {
                adminUserService.addAdminUser(adminUser);
            } else {
                adminUserService.updateAdminUser(adminUser);
            }
            return new AjaxMessage(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxMessage(true, "编辑失败");
        }
    }
}
