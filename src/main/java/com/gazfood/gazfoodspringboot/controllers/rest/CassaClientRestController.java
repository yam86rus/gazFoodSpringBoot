package com.gazfood.gazfoodspringboot.controllers.rest;

import com.gazfood.gazfoodspringboot.service.CassaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CassaClientRestController {
    @Autowired
    private CassaService cassaService;

    @PostMapping("/cassaClient")
    public void ShowInfo(@RequestBody String str) {
        System.out.println("К нам постучали с кассы: " + str);
        cassaService.updateOnlineData(str);
    }

}
