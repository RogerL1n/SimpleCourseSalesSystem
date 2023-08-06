package com.test.k12.service;

import com.github.pagehelper.PageInfo;
import com.test.k12.pojo.AdminUser;

import java.util.List;

public interface AdminUserService {
    /**
     * 登陆
     *
     * @param email
     * @param password
     * @return
     */
    AdminUser doLogin(String email, String password);

    PageInfo<AdminUser> getUserList(AdminUser user, Integer pageNum, Integer pageSize);

    void addAdminUser(AdminUser user);

    void updateAdminUser(AdminUser user);

    AdminUser getUserById(Integer id);

    /**
     * 给用户授权
     *
     * @param userId
     * @param roleIds
     */
    void addUserRole(Integer userId, Integer[] roleIds);

    /**
     * 获取用户已经拥有的角色
     *
     * @param userId
     * @return
     */
    List<Integer> getUserRoleIds(Integer userId);
}
