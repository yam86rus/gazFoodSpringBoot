package com.gazfood.gazfoodspringboot.controllers.rest;

import com.gazfood.gazfoodspringboot.dao.PartnerRepository;
import com.gazfood.gazfoodspringboot.entity.Partner;
import com.gazfood.gazfoodspringboot.service.CassaService;
import com.gazfood.gazfoodspringboot.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PartnerRestController {
    @Autowired
    private PartnerService partnerService;

    @GetMapping("/partners")
    public List<Partner> showAllPartners (){
        List<Partner> allPartners = partnerService.getAllPartners();
        return allPartners;
    }
}
