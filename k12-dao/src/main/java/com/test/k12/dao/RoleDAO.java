package com.test.k12.dao;

import com.test.k12.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDAO {

    void addRole(Role role);

    void updateRole(Role role);

    List<Role> getRoleList(Role role);

    Role getRoleById(Integer id);

    void addRoleMenu(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);

    void deleteRoleMenu(Integer roleId);

    List<Integer> getRoleMenuIds(Integer roleId);
}
