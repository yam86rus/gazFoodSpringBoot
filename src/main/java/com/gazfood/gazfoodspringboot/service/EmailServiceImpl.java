package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.EmailRepository;
import com.gazfood.gazfoodspringboot.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    @Override
    public void saveEmail(Email email) {
    emailRepository.save(email);
    }

    @Override
    public Email getEmail(int id) {
        Email email = null;
        Optional<Email> optional = emailRepository.findById(id);
        if (optional.isPresent()){
            email = optional.get();
        }
        return email;
    }

    @Override
    public void deleteEmail(int id) {
    emailRepository.deleteById(id);
    }

    @Override
    public long getEmailCount() {
        return emailRepository.count();
    }
}
