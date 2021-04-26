package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Status;
import com.gazfood.gazfoodspringboot.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StatusController {

    @Autowired
    private StatusService statusService;

    @RequestMapping("/statuses")
    public String showAllStatuses(Model model) {
        List<Status> allStatuses = statusService.getAllStatuses();
        model.addAttribute("allStatuses", allStatuses);
        return "all-statuses";
    }

    @RequestMapping("/deleteStatus")
    public String deleteStatus(@RequestParam("statusId") int id) {
        statusService.deleteStatus(id);
        return "redirect:statuses";
    }

    @RequestMapping("/addNewStatus")
    public String adddNewStatus(Model model) {
        Status status = new Status();
        model.addAttribute("status", status);
        return "status-form";
    }

    @RequestMapping("/saveStatus")
    public String saveStatus(@ModelAttribute("status") Status status) {
        statusService.saveStatus(status);
        return "redirect:statuses";
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(@RequestParam("statusId") int id, Model model) {
        Status status = statusService.getStatus(id);
        model.addAttribute("status", status);
        return "status-form";
    }
}
