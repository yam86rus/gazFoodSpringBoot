package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet;

import java.util.List;


public interface PhoneNumberInCabinetService {

    List<PhoneNumberInCabinet> getAllPhoneNumbersInCabinet();

    void savePhoneNumberInCabinet(PhoneNumberInCabinet phoneNumberInCabinet);

    PhoneNumberInCabinet getPhoneNumberInCabinet(int id);

    void deletePhoneNumberInCabinet(int id);

    long getCountPhoneNumberInCabinet();
}
