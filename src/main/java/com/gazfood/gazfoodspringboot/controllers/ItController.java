package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.CassaService;
import com.gazfood.gazfoodspringboot.service.PhoneNumberInCabinetService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ItController {
    @Autowired
    private UserService userService;

    @Autowired
    private CassaService cassaService;

    @Autowired
    private PhoneNumberInCabinetService phoneNumberInCabinetService;

    @RequestMapping("/it")
    public String showAllIt(Model model, Principal principal){
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        model.addAttribute("cassaCount", cassaService.getCountCasses());
        model.addAttribute("phoneNumberInCabinet", phoneNumberInCabinetService.getCountPhoneNumberInCabinet());
        return "all-it";
    }
}
