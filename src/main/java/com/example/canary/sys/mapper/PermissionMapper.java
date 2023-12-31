package com.example.canary.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.canary.sys.entity.PermissionDTO;
import com.example.canary.sys.entity.PermissionPO;
import com.example.canary.sys.entity.PermissionVO;
import com.example.canary.sys.entity.UserPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限
 *
 * @author zhaohongliang 2023-09-13 18:59
 * @since 1.0
 */
@Repository
public interface PermissionMapper extends BaseMapper<PermissionPO> {


    /**
     * 查询正在使用该权限的用户
     *
     * @param permissionId
     * @return
     */
    List<UserPO> selectUserByPermissionId(@Param("permissionId") String permissionId);

    /**
     * delete
     *
     * @param id
     * @return
     */
    @Update("UPDATE sys_permission SET is_deleted = id WHERE id = #{id}")
    int deleteById(@Param("id") String id);

    /**
     * list
     *
     * @return
     */
    List<PermissionVO> list();

    /**
     * 根据角色id 查询权限
     *
     * @param roleIds
     * @return
     */
    List<PermissionPO> selectByRoleIds(@Param("roleIds") List<String> roleIds);

    /**
     * 根据用户id 查询权限
     *
     * @param userId
     * @return
     */
    List<PermissionDTO> selectByUserId(@Param("userId") String userId);
}
