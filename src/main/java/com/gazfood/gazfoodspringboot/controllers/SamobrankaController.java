package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Recept;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.ReceptService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class SamobrankaController {
    @Autowired
    private UserService userService;

    @Autowired
    private ReceptService receptService;


    @RequestMapping("/samobranka")
    public String showAllSamobranka(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        long receptCount = receptService.getCountRecept();
        model.addAttribute("receptCount", receptCount);
        return "all-samobranka";
    }

    @RequestMapping("/recept")
    public String showAllRecept(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        List<Recept> allRecept = receptService.getAllRecept();
        model.addAttribute("allRecept", allRecept);
        return "all-recept";
    }

    @RequestMapping("/addNewRecept")
    public String addNewRecept(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        Recept recept = new Recept();
        model.addAttribute("recept", recept);

        return "recept-form";
    }

    @RequestMapping("/saveRecept")
    public String saveRecept(@ModelAttribute("recept") Recept recept) {
        receptService.saveRecept(recept);
        return "redirect:recept";
    }

    @RequestMapping("/updateRecept")
    public String updateRecept(@RequestParam("receptId") int id, Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        Recept recept = receptService.getRecept(id);
        model.addAttribute("recept", recept);
        return "recept-form";
    }

    @RequestMapping("/deleteRecept")
    public String deteleRecept(@RequestParam("receptId") int id) {
        receptService.deleteRecept(id);
        return "redirect:recept";
    }

    @RequestMapping("/samobrankaAkt")
    public String obrabotkaAktov(Model model,Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("receptService",receptService);
        return "all-samobrankaAkt";
    }

    @RequestMapping("/checkAkt")
    public String checkAct(Model model,Principal principal) throws IOException {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        receptService.checkAct();
        return "redirect:samobrankaAkt";
    }


}
