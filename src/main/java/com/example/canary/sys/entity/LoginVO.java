package com.example.canary.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Duration;

/**
 * login
 *
 * @since 1.0
 * @author zhaohongliang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -3880883170325579213L;

    /**
     * token
     */
    private String token;

    /**
     * 失效时间（单位：秒）
     */
    private Long expire;
}
