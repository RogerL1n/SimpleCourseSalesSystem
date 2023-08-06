package com.test.k12.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.k12.dao.RoleDAO;
import com.test.k12.pojo.Role;
import com.test.k12.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lry
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    /**
     * 分页查询角色列表
     *
     * @param role
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Role> getRoleList(Role role, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(roleDAO.getRoleList(role));
    }

    /**
     * 添加
     *
     * @param role
     */
    @Override
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    /**
     * 修改
     *
     * @param role
     */
    @Override
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Role getRoleById(Integer id) {
        return roleDAO.getRoleById(id);
    }

    /**
     * 给角色授权
     *
     * @param roleId
     * @param menuIds
     */
    @Override
    public void addRoleMenu(Integer roleId, Integer[] menuIds) {
        roleDAO.deleteRoleMenu(roleId);//删除原来的权限
        for (Integer menuId : menuIds) {//添加新的权限
            roleDAO.addRoleMenu(roleId, menuId);
        }
    }

    /**
     * 查询角色已经拥有的权限
     *
     * @param roleId
     * @return
     */
    @Override
    public List<Integer> getRoleMenuIds(Integer roleId) {
        return roleDAO.getRoleMenuIds(roleId);
    }

    @Override
    public List<Role> getRoleList(Role role) {
        return roleDAO.getRoleList(role);
    }
}
