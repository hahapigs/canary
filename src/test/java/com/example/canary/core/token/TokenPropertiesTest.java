package com.example.canary.core.token;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhaohongliang
 * @version 1.0
 */
@Slf4j
@SpringBootTest
class TokenPropertiesTest {

    @Autowired
    private TokenProperties tokenProperties;

    @Test
    void test() {
        Duration duration = tokenProperties.getExpires();
        log.info("expires:{}" , duration.toMillis());
    }

}