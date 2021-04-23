package com.gazfood.gazfoodspringboot.controllers.rest;

import com.gazfood.gazfoodspringboot.entity.Cassa;
import com.gazfood.gazfoodspringboot.service.CassaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CassaRestController {
    @Autowired
    private CassaService cassaService;

    @GetMapping("/casses")
    public List<Cassa> showAllCasses(){
        List<Cassa> allCasses = cassaService.getAllCasses();
        return allCasses;
    }

    @GetMapping("/casses/{id}")
    public Cassa getCassa(@PathVariable int id){
        Cassa cassa = cassaService.getCassa(id);
        return cassa;
    }

}
