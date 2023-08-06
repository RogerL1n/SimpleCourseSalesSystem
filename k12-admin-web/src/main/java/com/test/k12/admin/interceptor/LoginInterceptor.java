package com.test.k12.admin.interceptor;

import com.test.k12.admin.util.SystemConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lry
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute(SystemConstants.SESSION_USER);
        if (user == null) {//没有登录
            response.sendRedirect("/login.html");
            return false;//被拦截
        }
        return true;//放行，进入controller
    }
}
