package com.example.canary.task.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.canary.common.entity.ValidGroup;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 任务
 *
 * @ClassName TaskBase
 * @Description 任务
 * @Author zhaohongliang
 * @Date 2023-06-26 16:16
 * @Since 1.0
 */
@Data
public class TaskBase implements Serializable {

    @Serial
    private static final long serialVersionUID = -5765905120230979856L;

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    @NotBlank(groups = { ValidGroup.Edit.class })
    private String id;

    /**
     * 名称
     */
    @NotBlank(groups = { ValidGroup.Add.class, ValidGroup.Edit.class })
    private String name;

    /**
     * 名称（英文）
     */
    private String nameEn;

    /**
     * 描述
     */
    private String description;

    /**
     * 表达式
     */
    @NotBlank(groups = { ValidGroup.Add.class, ValidGroup.Edit.class })
    private String cronExpression;

    /**
     * 类名
     */
    @NotBlank(groups = { ValidGroup.Add.class, ValidGroup.Edit.class })
    private String className;

    /**
     * 方法名
     */
    @NotBlank(groups = { ValidGroup.Add.class, ValidGroup.Edit.class })
    private String methodName;

    /**
     * 方法参数
     */
    private String methodParams;

    /**
     * 是否禁用
     * @see com.example.canary.common.enums.DisabledStatusEnum
     */
    @Max(value = 1, groups = { ValidGroup.Add.class, ValidGroup.Edit.class })
    @Min(value = 0, groups = { ValidGroup.Add.class, ValidGroup.Edit.class })
    @TableField(value = "is_disabled")
    private Integer disabled;

}
