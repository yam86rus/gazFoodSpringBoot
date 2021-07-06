package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet;
import com.gazfood.gazfoodspringboot.service.PhoneNumberInCabinetService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class PhoneNumberInCabinetController {
    @Autowired
    private PhoneNumberInCabinetService phoneNumberInCabinetService;

    @Autowired
    private UserService userService;

    @GetMapping("/phoneNumberInCabinet")
    public String getAllPhoneNumbersInCabinet(Model model, Principal principal) {
        List<PhoneNumberInCabinet> allPhoneNumberInCabinet = phoneNumberInCabinetService.getAllPhoneNumbersInCabinet();
        model.addAttribute("allPhoneNumberInCabinet", allPhoneNumberInCabinet);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-phoneNumberInCabinet";
    }

    @RequestMapping("/addNewPhoneNumberInCabinet")
    public String addNewPhoneNumberInCabinet(Model model, Principal principal) {
        com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet phoneNumberInCabinet = new com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet();

        model.addAttribute("phoneNumberInCabinet", phoneNumberInCabinet);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "phoneNumberInCabinet-form";

    }

    @RequestMapping("/savePhoneNumberInCabinet")
    public String savePhoneNumberInCabinet(@ModelAttribute("phoneNumberInCabinet") PhoneNumberInCabinet phoneNumberInCabinet) {
        phoneNumberInCabinetService.savePhoneNumberInCabinet(phoneNumberInCabinet);
        return "redirect:phoneNumberInCabinet";
    }

    @RequestMapping("/deletePhoneNumberInCabinet")
    public String deletePhoneNumberInCabinet(@RequestParam("phoneNumberInCabinetId") int id) {
        phoneNumberInCabinetService.deletePhoneNumberInCabinet(id);
        return "redirect:phoneNumberInCabinet";
    }

    @RequestMapping("/updatePhoneNumberInCabinet")
    public String updatePhoneNumberInCabinet(@RequestParam("phoneNumberInCabinetId") int id, Model model,Principal principal){
        PhoneNumberInCabinet phoneNumberInCabinet = phoneNumberInCabinetService.getPhoneNumberInCabinet(id);
        model.addAttribute("phoneNumberInCabinet",phoneNumberInCabinet);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "phoneNumberInCabinet-form";
    }
}
