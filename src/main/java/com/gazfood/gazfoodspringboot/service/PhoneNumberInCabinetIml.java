package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.PhoneNumberInCabinetRepository;
import com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberInCabinetIml implements PhoneNumberInCabinetService{
    @Autowired
    private PhoneNumberInCabinetRepository phoneNumberInCabinetRepository;

    @Override
    public List<PhoneNumberInCabinet> getAllPhoneNumbersInCabinet() {
       List<PhoneNumberInCabinet> allPhoneNumberInCabinet = phoneNumberInCabinetRepository.findAll();
        return allPhoneNumberInCabinet;
    }

    @Override
    public void savePhoneNumberInCabinet(PhoneNumberInCabinet phoneNumberInCabinet) {

    }

    @Override
    public PhoneNumberInCabinet getPhoneNumberInCabinet(int id) {
        return null;
    }

    @Override
    public void deletePhoneNumberInCabinet(int id) {

    }

    @Override
    public long getCountPhoneNumberInCabinet() {
        return phoneNumberInCabinetRepository.count();
    }
}
