package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Partner;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.PartnerService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    @Autowired
    private UserService userService;


    @RequestMapping("/partners")
    public String getAllPartners(Model model, Principal principal) {
        List<Partner> allPartners = partnerService.getAllPartners();
        model.addAttribute("allPartners", allPartners);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-partners";
    }

    @RequestMapping("/addNewPartner")
    public String addNewPartner(Model model,Principal principal) {
        Partner partner = new Partner();
        model.addAttribute("partner", partner);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "partner-form";
    }

    @RequestMapping("/savePartner")
    public String savePartner(Partner partner) {
        partnerService.savePartner(partner);
        return "redirect:partners";
    }

    @RequestMapping("/updatePartner")
    public String updatePartner(@RequestParam("partnerId") int id, Model model,Principal principal) {
        Partner partner = partnerService.getPartner(id);
        model.addAttribute("partner", partner);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "partner-form";
    }

    @GetMapping("/deletePartner")
    public String deletePartner(@RequestParam("partnerId") int id) {
        partnerService.deletePartner(id);
        return "redirect:partners";

    }
}
