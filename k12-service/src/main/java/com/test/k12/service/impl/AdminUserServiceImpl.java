package com.test.k12.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.k12.dao.AdminUserDAO;
import com.test.k12.pojo.AdminUser;
import com.test.k12.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lry
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDAO adminUserDAO;

    /**
     * 登陆
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public AdminUser doLogin(String email, String password) {
        AdminUser user = adminUserDAO.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public PageInfo<AdminUser> getUserList(AdminUser user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(adminUserDAO.getUserList(user));
    }

    @Override
    public void addAdminUser(AdminUser user) {
        adminUserDAO.addAdminUser(user);
    }

    @Override
    public void updateAdminUser(AdminUser user) {
        adminUserDAO.updateAdminUser(user);
    }

    @Override
    public AdminUser getUserById(Integer id) {
        return adminUserDAO.getUserById(id);
    }

    /**
     * 给用户授权
     *
     * @param userId
     * @param roleIds
     */
    @Override
    public void addUserRole(Integer userId, Integer[] roleIds) {
        adminUserDAO.deleteUserRole(userId);
        if (roleIds != null) {
            for (Integer roleId : roleIds) {
                adminUserDAO.addUserRole(roleId, userId);
            }
        }
    }

    /**
     * 获取用户已经拥有的角色
     *
     * @param userId
     * @return
     */
    @Override
    public List<Integer> getUserRoleIds(Integer userId) {
        return adminUserDAO.getUserRoleIds(userId);
    }
}
