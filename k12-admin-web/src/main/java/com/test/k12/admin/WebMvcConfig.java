package com.test.k12.admin;

import com.test.k12.admin.interceptor.AuthInterceptor;
import com.test.k12.admin.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author lry
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override//静态资源映射 不找controller
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/upload/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override//设置欢迎界面
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/login.html");
    }

    @Override//返回json
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);//不匹配后缀
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/auth/**").order(1);
        registry.addInterceptor(authInterceptor).addPathPatterns("/auth/**").excludePathPatterns("/auth/side.html", "/auth/index.html").order(2);
    }
}
