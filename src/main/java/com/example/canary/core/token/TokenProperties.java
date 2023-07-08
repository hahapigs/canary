package com.example.canary.core.token;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * token properties
 *
 * @ClassName TokenProperties
 * @Description token properties
 * @Author zhaohongliang
 * @Date 2023-07-06 13:28
 * @Since 1.0
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "token" )
public class TokenProperties {

    private TokenProperties() {}

    /**
     * 密钥
     */
    private String secret;

    /**
     * 到期时间
     */
    private Long expires;



}