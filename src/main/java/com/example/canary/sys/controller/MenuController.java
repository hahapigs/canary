package com.example.canary.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.canary.common.api.ApiVersion;
import com.example.canary.common.exception.ValidGroup;
import com.example.canary.sys.entity.MenuAO;
import com.example.canary.sys.entity.MenuQuery;
import com.example.canary.sys.entity.MenuVO;
import com.example.canary.sys.service.MenuService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单
 *
 * @author zhaohongliang 2023-09-08 20:34
 * @since 1.0
 */
@Validated
@ApiVersion
@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * pages
     *
     * @param query
     * @return
     */
    @GetMapping("/pages")
    public IPage<MenuVO> pagesMenu(MenuQuery query) {
        return menuService.pagesMenu(query);
    }

    /**
     * add
     *
     * @param menuAo
     * @return
     */
    @PostMapping("/add")
    public MenuVO addMenu(@Validated({ ValidGroup.Add.class }) @RequestBody MenuAO menuAo) {
        return menuService.addMenu(menuAo);
    }

    /**
     * edit
     *
     * @param menuAo
     * @return
     */
    @PutMapping("/edit")
    public MenuVO editMenu(@Validated({ ValidGroup.Edit.class }) @RequestBody MenuAO menuAo) {
        return menuService.editMenu(menuAo);
    }

    /**
     * delete
     *
     * @param id
     */
    @DeleteMapping("/delete")
    public void deleteMenu(@NotBlank String id) {
        menuService.deleteMenu(id);
    }



}