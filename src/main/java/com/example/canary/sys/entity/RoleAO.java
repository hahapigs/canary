package com.example.canary.sys.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

/**
 * 角色
 *
 * @author zhaohongliang 2023-08-13 17:00
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleAO extends RoleBase {

    private static final long serialVersionUID = -9153554946923170562L;

    public RolePO convertToPo() {
        RolePO rolePo = new RolePO();
        BeanUtils.copyProperties(this, rolePo);
        return rolePo;
    }
}
