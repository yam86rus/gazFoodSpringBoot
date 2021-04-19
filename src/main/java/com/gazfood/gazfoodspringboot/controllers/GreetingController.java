package com.gazfood.gazfoodspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("")
    public String main() {
        return "index";
    }

    @GetMapping("/restapi")
    public String restapi(){
        return "restapi";
    }

}
