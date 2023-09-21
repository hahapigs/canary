package com.example.canary.sys.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.canary.sys.entity.MenuPermissionPO;
import com.example.canary.sys.mapper.MenuPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜单权限关联关系
 *
 * @author zhaohongliang 2023-09-20 23:04
 * @since 1.0
 */
@Service
public class MenuPermissionRepositoryImpl implements MenuPermissionRepository {

    @Autowired
    private MenuPermissionMapper menuPermissionMapper;

    /**
     * insert
     *
     * @param menuPermissionPo
     * @return
     */
    @Override
    public int insert(MenuPermissionPO menuPermissionPo) {
        return menuPermissionMapper.insert(menuPermissionPo);
    }

    /**
     * 根据 permissionId 删除
     *
     * @param permissionId
     * @return
     */
    @Override
    public int deleteByPermissionId(String permissionId) {
        LambdaQueryWrapper<MenuPermissionPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MenuPermissionPO::getPermissionId, permissionId);
        return menuPermissionMapper.delete(queryWrapper);
    }
}