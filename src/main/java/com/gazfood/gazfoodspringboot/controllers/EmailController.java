package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Email;
import com.gazfood.gazfoodspringboot.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/emails")
    public String getAllEmails(Model model) {
        List<Email> allEmails = emailService.getAllEmails();
        model.addAttribute("allEmails", allEmails);
        return "all-emails";
    }

    @GetMapping("/deleteEmail")
    public String deleteEmail(@RequestParam("emailId") int id) {
        emailService.deleteEmail(id);
        return "redirect:emails";
    }
}
