package com.gazfood.gazfoodspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CassaController {

    @GetMapping("/casses")
    private String getAllCassa(){
        return "all-cassas";
    }
}
