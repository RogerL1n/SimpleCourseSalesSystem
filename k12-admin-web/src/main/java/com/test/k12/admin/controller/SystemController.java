package com.test.k12.admin.controller;

import com.test.k12.admin.util.SystemConstants;
import com.test.k12.pojo.AdminUser;
import com.test.k12.pojo.Menu;
import com.test.k12.service.AdminUserService;
import com.test.k12.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lry
 */
@Controller
public class SystemController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("/auth/index.html")
    public String index() {
        return "index";
    }

    @RequestMapping("/auth/side.html")
    @ResponseBody
    public List<Menu> getMenuTree(HttpSession session) {
        AdminUser user = (AdminUser) session.getAttribute(SystemConstants.SESSION_USER);
        //return menuService.getMenuTree();
        return menuService.getUserMenuTree(user.getId());
    }

    @RequestMapping("login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("logout.html")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @RequestMapping("dologin.html")
    public ModelAndView login(String email, String password, HttpSession session) {
        AdminUser user = adminUserService.doLogin(email, password);
        if (user == null) {
            return new ModelAndView("login", "message", "用户名或密码错误");
        }
        session.setAttribute(SystemConstants.SESSION_USER, user);
        return new ModelAndView(new RedirectView("auth/index.html"));
    }
}
