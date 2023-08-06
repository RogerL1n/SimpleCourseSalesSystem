package com.test.k12.dao;

import com.test.k12.pojo.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserDAO {
    List<AdminUser> getUserList(AdminUser user);

    AdminUser getUserByEmail(String email);

    void addAdminUser(AdminUser user);

    void updateAdminUser(AdminUser user);

    AdminUser getUserById(Integer id);

    List<Integer> getUserRoleIds(Integer userId);

    void addUserRole(@Param("roleId") Integer roleId, @Param("userId") Integer userId);

    void deleteUserRole(Integer userId);
}
