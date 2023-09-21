package com.example.canary.sys.repository;

import com.example.canary.sys.entity.UserRolePO;

import java.util.List;

/**
 * 用户角色关联关系
 *
 * @author zhaohongliang 2023-09-21 14:15
 * @since 1.0
 */
public interface UserRoleRepository {

    /**
     * insert
     *
     * @param userRole
     * @return
     */
    int insert(UserRolePO userRolePo);

    /**
     * batch insert
     *
     * @param list
     * @return
     */
    int batchInsert(List<UserRolePO> list);

    /**
     * delete by userId
     *
     * @param id
     * @return
     */
    int deleteByUserId(String userId);
}