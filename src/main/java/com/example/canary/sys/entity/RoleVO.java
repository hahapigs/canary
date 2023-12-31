package com.example.canary.sys.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

/**
 * 角色
 *
 * @author zhaohongliang 2023-08-13 17:01
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleVO extends RoleBase {

    private static final long serialVersionUID = 3164952697835641373L;

    public RoleVO() {
    }

    public RoleVO(RolePO rolePo) {
        BeanUtils.copyProperties(rolePo, this);
    }
}
