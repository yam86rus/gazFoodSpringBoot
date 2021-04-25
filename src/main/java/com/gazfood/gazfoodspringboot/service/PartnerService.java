package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Partner;

import java.util.List;

public interface PartnerService {

    List<Partner> getAllPartners();

    void savePartner(Partner partner);

    Partner getPartner (int id);

    void deletePartner(int id);

    long getCountPartners();
}
