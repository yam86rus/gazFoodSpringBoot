package com.gazfood.gazfoodspringboot.controllers;


import com.gazfood.gazfoodspringboot.entity.Cassa;
import com.gazfood.gazfoodspringboot.service.CassaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CassaController {

    @Autowired
    private CassaService cassaService;

    @GetMapping("/casses")
    private String showCassaPage(Model model){
        List<Cassa> allCasses = cassaService.getAllCasses();
        model.addAttribute("allCasses",allCasses);
        return "all-casses";
    }
}
