package com.example.canary.sys.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.canary.sys.entity.RolePermissionPO;
import com.example.canary.sys.mapper.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 角色权限关联关系
 *
 * @author zhaohongliang 2023-09-21 10:29
 * @since 1.0
 */
@Service
public class RolePermissionRepositoryImpl implements RolePermissionRepository {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    /**
     * insert
     *
     * @param rolePermissionPo
     * @return
     */
    @Override
    public int insert(RolePermissionPO rolePermissionPo) {
        return 0;
    }

    /**
     * batch insert
     *
     * @param list
     * @return
     */
    @Override
    public int batchInsert(List<RolePermissionPO> list) {
        return rolePermissionMapper.batchInsert(list);
    }

    /**
     * delete by roleId
     *
     * @param roleId
     * @return
     */
    @Override
    public int deleteByRoleId(String roleId) {
        LambdaQueryWrapper<RolePermissionPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RolePermissionPO::getRoleId, roleId);
        return rolePermissionMapper.delete(queryWrapper);
    }
}