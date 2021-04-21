package com.gazfood.gazfoodspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/users")
    public String getAllUsers() {
        return "all-users";
    }
}
