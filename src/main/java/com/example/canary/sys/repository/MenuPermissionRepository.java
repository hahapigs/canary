package com.example.canary.sys.repository;

import com.example.canary.sys.entity.MenuPermissionPO;

import java.util.List;

/**
 * 菜单权限关联关系
 *
 * @author zhaohongliang 2023-09-20 23:04
 * @since 1.0
 */
public interface MenuPermissionRepository {

    /**
     * insert
     *
     * @param menuPermissionPo
     * @return
     */
    int insert(MenuPermissionPO menuPermissionPo);

    /**
     * 根据 permissionId 删除
     *
     * @param permissionId
     * @return
     */
    int deleteByPermissionId(String permissionId);

    /**
     * 根据 menuId 查询
     *
     * @param menuId
     * @return
     */
    List<MenuPermissionPO> selectByMenuId(String menuId);

}
