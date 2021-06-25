package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Email;
import com.gazfood.gazfoodspringboot.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @RequestMapping("/emails")
    public String getAllEmails(Model model) {
        List<Email> allEmails = emailService.getAllEmails();
        model.addAttribute("allEmails", allEmails);
        return "all-emails";
    }


    @RequestMapping("/addNewEmail")
    public String addNewEmail(Model model) {
        Email emails = new Email();
        model.addAttribute("emails", emails);
        return "email-form";
    }

    @RequestMapping("/deleteEmail")
    public String deleteEmail(@RequestParam("emailId") int id) {
        emailService.deleteEmail(id);
        return "redirect:emails";
    }

    @RequestMapping("/saveEmail")
    public String saveEmail(@ModelAttribute("emails") Email email) {
        emailService.saveEmail(email);
        return "redirect:emails";
    }

    @RequestMapping("/updateEmail")
    public String updateEmail(@RequestParam("emailId") int id, Model model) {
        Email emails = emailService.getEmail(id);
        model.addAttribute("emails", emails);
        return "email-form";
    }


}
