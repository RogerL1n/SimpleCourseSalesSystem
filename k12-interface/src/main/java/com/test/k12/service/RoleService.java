package com.test.k12.service;

import com.github.pagehelper.PageInfo;
import com.test.k12.pojo.Role;

import java.util.List;

public interface RoleService {
    /**
     * 分页查询角色列表
     *
     * @param role
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Role> getRoleList(Role role, Integer pageNum, Integer pageSize);

    List<Role> getRoleList(Role role);

    /**
     * 添加
     */
    void addRole(Role role);

    /**
     * 修改
     *
     * @param role
     */
    void updateRole(Role role);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Role getRoleById(Integer id);

    /**
     * 给角色授权
     *
     * @param roleId
     * @param menuIds
     */
    void addRoleMenu(Integer roleId, Integer[] menuIds);

    /**
     * 查询角色已经拥有的权限
     *
     * @param roleId
     * @return
     */

    List<Integer> getRoleMenuIds(Integer roleId);
}
