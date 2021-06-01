package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Cafeteria;
import com.gazfood.gazfoodspringboot.entity.CafeteriaAndMenu;
import com.gazfood.gazfoodspringboot.entity.Menu;
import com.gazfood.gazfoodspringboot.service.CafeteriaAndMenuService;
import com.gazfood.gazfoodspringboot.service.CafeteriaService;
import com.gazfood.gazfoodspringboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class CafeteriaAndMenuController {
    @Autowired
    private CafeteriaAndMenuService cafeteriaAndMenuService;

    @Autowired
    private CafeteriaService cafeteriaService;

    @Autowired
    private MenuService menuService;


    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    @RequestMapping("/cafeteriaAndMenu")
    public String showAllCafeteriaAndMenu(Model model) {
        List<CafeteriaAndMenu> allCafeteriaAndMenu = cafeteriaAndMenuService.getAllCafeteriaAndMenu();
        model.addAttribute("allCafeteriaAndMenu", allCafeteriaAndMenu);
        return "all-cafeteriaAndMenu";
    }

    @RequestMapping("/addNewCafeteriaAndMenu")
    public String addNewCafeteriaAndMenu(Model model){
        CafeteriaAndMenu cafeteriaAndMenu = new CafeteriaAndMenu();
        model.addAttribute("cafeteriaAndMenu",cafeteriaAndMenu);

        List<Cafeteria> allCafeterias = cafeteriaService.getAllCafeterias().stream()
                .filter(e->e.isActive()==true)
                .collect(Collectors.toList());
        model.addAttribute("allCafeterias",allCafeterias);

        List<Menu> allMenus = menuService.getAllMenus().stream()
                .filter(distinctByKey(Menu::getMenuList))
                .collect(Collectors.toList());

        System.out.println(allMenus);
        model.addAttribute("allMenus",allMenus);


        return "cafeteriaAndMenu-form";
    }

    @RequestMapping("/saveCafeteriaAndMenu")
    public String saveCafeteriaAndMenu(CafeteriaAndMenu cafeteriaAndMenu){
        cafeteriaAndMenuService.savaCafeteriaAndMenu(cafeteriaAndMenu);
        return "redirect:/cafeteriaAndMenu";
    }

    @RequestMapping("/deleteCafeteriaAndMenu")
    public String deleteCafeteriaAndMenu(@RequestParam("cafeteriaAndMenuId") int id){
        cafeteriaAndMenuService.deleteCafeteriaAndMenu(id);
        return "redirect:/cafeteriaAndMenu";
    }

    @RequestMapping("/updateCafeteriaAndMenu")
    public String updateCafeteriaAndMenu(@RequestParam("cafeteriaAndMenuId") int id, Model model){
        CafeteriaAndMenu cafeteriaAndMenu = cafeteriaAndMenuService.getCafeteriaAndMenu(id);
        model.addAttribute("cafeteriaAndMenu",cafeteriaAndMenu);

        List<Cafeteria> allCafeterias = cafeteriaService.getAllCafeterias().stream()
                .filter(e->e.isActive()==true)
                .collect(Collectors.toList());
        model.addAttribute("allCafeterias",allCafeterias);

        List<Menu> allMenus = menuService.getAllMenus().stream()
                .filter(distinctByKey(Menu::getMenuList))
                .collect(Collectors.toList());

        model.addAttribute("allMenus",allMenus);

        return "cafeteriaAndMenu-form";
    }
}
