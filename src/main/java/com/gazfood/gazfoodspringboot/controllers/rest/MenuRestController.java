package com.gazfood.gazfoodspringboot.controllers.rest;

import com.gazfood.gazfoodspringboot.entity.Menu;
import com.gazfood.gazfoodspringboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuRestController {
    @Autowired
    private MenuService menuService;

    @GetMapping("menus")
    public List<Menu> showAllMenus(){
        List<Menu> allMenus = menuService.getAllMenus();
        return allMenus;
    }

    @GetMapping("menus/{id}")
    public Menu getMenu(@PathVariable int id ){
        Menu menu = menuService.getMenu(id);
        if(menu == null){
            throw new RuntimeException("There is no menu with ID = " + id + " in Database");
        }
        return menu;
    }
}
