package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Email;

import java.util.List;


public interface EmailService {
    List<Email> getAllEmails();

    void saveEmail(Email email);

    Email getEmail(int id);

    void deleteEmail(int id);

    long getEmailCount();

}
