package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.PartnerRepository;
import com.gazfood.gazfoodspringboot.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImp implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public List<Partner> getAllPartners() {
        List<Partner> allPartners = partnerRepository.findAll();
        return allPartners;
    }

    @Override
    public void savePartner(Partner partner) {
        partnerRepository.save(partner);
    }

    @Override
    public Partner getPartner(int id) {

        Partner partner = null;
        Optional<Partner> optional = partnerRepository.findById(id);
        if (optional.isPresent()) {
            partner = optional.get();
        }
        return partner;
    }

    @Override
    public void deletePartner(int id) {
        partnerRepository.deleteById(id);
    }


    @Override
    public long getCountPartners() {
        return partnerRepository.count();
    }


}
