package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Partner;
import com.gazfood.gazfoodspringboot.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    @RequestMapping("/partners")
    public String getAllPartners(Model model) {
        List<Partner> allPartners = partnerService.getAllPartners();
        model.addAttribute("allPartners", allPartners);
        return "all-partners";
    }

    @RequestMapping("/addNewPartner")
    public String addNewPartner(Model model) {
        Partner partner = new Partner();
        model.addAttribute("partner", partner);
        return "partner-form";
    }

    @RequestMapping("/savePartner")
    public String savePartner(Partner partner) {
        partnerService.savePartner(partner);
        return "redirect:partners";
    }

    @RequestMapping("/updatePartner")
    public String updatePartner(@RequestParam("partnerId") int id, Model model) {
        Partner partner = partnerService.getPartner(id);
        model.addAttribute("partner", partner);
        return "partner-form";
    }

    @GetMapping("/deletePartner")
    public String deletePartner(@RequestParam("partnerId") int id) {
        partnerService.deletePartner(id);
        return "redirect:partners";

    }
}
