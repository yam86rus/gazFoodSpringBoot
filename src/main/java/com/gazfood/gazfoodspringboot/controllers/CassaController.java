package com.gazfood.gazfoodspringboot.controllers;


import com.gazfood.gazfoodspringboot.entity.Cassa;
import com.gazfood.gazfoodspringboot.entity.City;
import com.gazfood.gazfoodspringboot.entity.Employee;
import com.gazfood.gazfoodspringboot.service.CassaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CassaController {

    @Autowired
    private CassaService cassaService;

    @GetMapping("/casses")
    private String showCassaPage(Model model) {
        List<Cassa> allCasses = cassaService.getAllCassesOrder();
        model.addAttribute("allCasses", allCasses);
        return "all-casses";
    }

    @RequestMapping("/addNewCassa")
    public String addNewCassa(Model model) {
        Cassa cassa = new Cassa();
        model.addAttribute("cassa", cassa);
        return "cassa-form";
    }

    @RequestMapping("saveCassa")
    public String saveCassa(@ModelAttribute("cassa") Cassa cassa) {
        cassaService.saveCassa(cassa);
        return "redirect:casses";
    }

    @RequestMapping("updateCassa")
    public String updateCassa(@RequestParam("cassaId") int id,Model model) {
        Cassa cassa = cassaService.getCassa(id);
        model.addAttribute("cassa",cassa);
        return "cassa-form";
    }

    @RequestMapping("deleteCassa")
    public String deleteCassa(@RequestParam("cassaId") int id) {
        cassaService.deleteCassa(id);
        return "redirect:casses";
    }


    @RequestMapping("/detailsCassa")
    public String detailsCassa(@RequestParam("cassaId") int id,Model model){
        Cassa cassa = cassaService.getCassa(id);
        model.addAttribute("cassa",cassa);

        return "cassa-form";
    }

}
