package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.PhoneNumberInCabinetService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class PhoneNumberInCabinet {
    @Autowired
    private PhoneNumberInCabinetService phoneNumberInCabinetService;

    @Autowired
    private UserService userService;

    @GetMapping("/phoneNumberInCabinet")
    public String getAllPhoneNumbersInCabinet(Model model, Principal principal) {
        List<com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet> allPhoneNumberInCabinet = phoneNumberInCabinetService.getAllPhoneNumbersInCabinet();
        model.addAttribute("allPhoneNumberInCabinet", allPhoneNumberInCabinet);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-phoneNumberInCabinet";
    }

    @RequestMapping("/addNewPhoneNumberInCabinet")
    public String addNewPhoneNumberInCabinet(Model model,Principal principal) {
        com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet phoneNumberInCabinet = new com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet();

        model.addAttribute("phoneNumberInCabinet", phoneNumberInCabinet);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "phoneNumberInCabinet-form";

    }

}
