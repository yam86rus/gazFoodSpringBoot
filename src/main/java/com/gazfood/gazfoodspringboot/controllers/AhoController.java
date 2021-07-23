package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Cassa;
import com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.exports.CassaExcelExporter;
import com.gazfood.gazfoodspringboot.exports.PhoneNumberInCabinetExcelExporter;
import com.gazfood.gazfoodspringboot.service.PhoneNumberInCabinetService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AhoController {
    @Autowired
    private UserService userService;

    @Autowired
    private PhoneNumberInCabinetService phoneNumberInCabinetService;

    @RequestMapping("/aho")
    public String showAllAho(Model model, Principal principal) {

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("phoneNumberInCabinet", phoneNumberInCabinetService.getCountPhoneNumberInCabinet());
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
}
