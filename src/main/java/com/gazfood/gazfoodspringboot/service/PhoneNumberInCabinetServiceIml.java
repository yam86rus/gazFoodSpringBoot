package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.PhoneNumberInCabinetRepository;
import com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberInCabinetServiceIml implements PhoneNumberInCabinetService{
    @Autowired
    private PhoneNumberInCabinetRepository phoneNumberInCabinetRepository;

    @Override
    public List<PhoneNumberInCabinet> getAllPhoneNumbersInCabinet() {
       List<PhoneNumberInCabinet> allPhoneNumberInCabinet = phoneNumberInCabinetRepository.findAll();
        return allPhoneNumberInCabinet;
    }

    @Override
    public void savePhoneNumberInCabinet(PhoneNumberInCabinet phoneNumberInCabinet) {
        phoneNumberInCabinetRepository.save(phoneNumberInCabinet);
    }

    @Override
    public PhoneNumberInCabinet getPhoneNumberInCabinet(int id) {
        PhoneNumberInCabinet phoneNumberInCabinet = null;
        Optional<PhoneNumberInCabinet> optional = phoneNumberInCabinetRepository.findById(id);
        if (optional.isPresent()){
            phoneNumberInCabinet = optional.get();
        }
        return phoneNumberInCabinet;
    }

    @Override
    public void deletePhoneNumberInCabinet(int id) {
        phoneNumberInCabinetRepository.deleteById(id);
    }

    @Override
    public long getCountPhoneNumberInCabinet() {
        return phoneNumberInCabinetRepository.count();
    }
}
