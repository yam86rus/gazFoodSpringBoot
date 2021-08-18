package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Inventory;
import com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.exports.PhoneNumberInCabinetExcelExporter;
import com.gazfood.gazfoodspringboot.service.InventoryService;
import com.gazfood.gazfoodspringboot.service.PhoneNumberInCabinetService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class AhoController {
    @Autowired
    private UserService userService;

    @Autowired
    private PhoneNumberInCabinetService phoneNumberInCabinetService;

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("/aho")
    public String showAllAho(Model model, Principal principal) {

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("phoneNumberInCabinet", phoneNumberInCabinetService.getCountPhoneNumberInCabinet());
        model.addAttribute("countInventory", inventoryService.getCountInventory());
        return "all-aho";
    }

    @GetMapping("aho/export/excel")
    private void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=PhoneNumber_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<PhoneNumberInCabinet> ListPhoneNumber = phoneNumberInCabinetService.getAllPhoneNumbersInCabinet();

        PhoneNumberInCabinetExcelExporter phoneNumberInCabinetExcelExporter = new PhoneNumberInCabinetExcelExporter(ListPhoneNumber);
        phoneNumberInCabinetExcelExporter.export(response);
    }

    @RequestMapping("/aho/allInventory")
    private String showAllInventory(Model model, Principal principal) {
        List<Inventory> allInventory = inventoryService.getAllInventory();
        model.addAttribute("allInventory", allInventory);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "all-inventory";
    }

    @RequestMapping("/aho/addNewInventory")
    public String addNewInventory(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        Inventory inventory = new Inventory();
        inventory.setEditingDate(LocalDate.now());
        inventory.setEditingPerson(user.getUserLastName() + " " + user.getUserName() + " " + user.getPatronymic());
        model.addAttribute("inventory", inventory);
        return "inventory-form";
    }

    @RequestMapping("/aho/saveInventory")
    public String saveInventory(Inventory inventory) {
        inventoryService.saveInventory(inventory);
        return "redirect:/aho/allInventory";
    }

    @RequestMapping("/aho/deleteInventory")
    public String deleteInventory(@RequestParam("inventoryId") int id) {
        inventoryService.deleteInventory(id);
        return "redirect:/aho/allInventory";

    }

    @RequestMapping("/aho/updateInventory")
    public String editInventory(@RequestParam("inventoryId") int id, Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        Inventory inventory = inventoryService.getInventory(id);
        inventory.setEditingDate(LocalDate.now());
        inventory.setEditingPerson(user.getUserLastName() + " " + user.getUserName() + " " + user.getPatronymic());
        model.addAttribute("inventory", inventory);



        return "inventory-form";

    }


}
