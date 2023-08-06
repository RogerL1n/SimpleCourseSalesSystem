package com.test.k12.admin.interceptor;

import com.test.k12.admin.util.SystemConstants;
import com.test.k12.pojo.AdminUser;
import com.test.k12.pojo.Menu;
import com.test.k12.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lry
 */

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private MenuService menuService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AdminUser user = (AdminUser) request.getSession().getAttribute(SystemConstants.SESSION_USER);
        List<Menu> menuList = menuService.getUserMenu(user.getId());
        String path = request.getServletPath();
        if (menuList != null) {
            for (Menu menu : menuList) {
                if (menu.getUrl() != null && menu.getUrl().equals(path)) {
                    return true;//放行
                }
            }
        }
        return false;
    }
}
