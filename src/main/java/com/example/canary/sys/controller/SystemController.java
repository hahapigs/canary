package com.example.canary.sys.controller;

import com.example.canary.common.api.ApiVersion;
import com.example.canary.sys.entity.LoginAO;
import com.example.canary.sys.entity.LoginVO;
import com.example.canary.sys.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * system
 *
 * @since 1.0
 * @author zhaohongliang
 */
@Validated
@ApiVersion
@RestController
@RequestMapping("/sys")
public class SystemController {

    private final SystemService systemService;

    @Autowired
    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    /**
     * login
     *
     * @param loginAo
     * @return
     */
    @PostMapping("/login")
    public LoginVO login(@Validated @RequestBody LoginAO loginAo) {
        return systemService.login(loginAo);
    }

    /**
     * logout
     *
     * @param token
     */
    @PostMapping("/logout")
    public void logout(@RequestHeader("token") String token) {
        systemService.logout(token);
    }

}
