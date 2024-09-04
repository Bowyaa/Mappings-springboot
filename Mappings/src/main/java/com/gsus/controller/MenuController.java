package com.gsus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsus.entity.Menu;
import com.gsus.serv.MenuService;

@RestController
@RequestMapping("/api/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/create")
    public Menu createMenu(@RequestBody Menu menu) {
        return menuService.save(menu);
    }

    @GetMapping("/all")
    public List<Menu> getAllMenus() {
        return menuService.findAll();
    }

    @GetMapping("/search{id}")
    public Optional<Menu> getMenuById(@PathVariable Long id) {
        return menuService.findById(id);
    }

    @PutMapping("/update{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody Menu menuDetails) {
        Menu menu = menuService.findById(id).orElseThrow();
        menu.setName(menuDetails.getName());
        return menuService.save(menu);
    }

    @DeleteMapping("/del{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteById(id);
    }
}
