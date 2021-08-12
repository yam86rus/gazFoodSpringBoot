package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet;
import com.gazfood.gazfoodspringboot.entity.Recept;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.exports.PhoneNumberInCabinetExcelExporter;
import com.gazfood.gazfoodspringboot.exports.ReceptExcelExporter;
import com.gazfood.gazfoodspringboot.service.ReceptService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class SamobrankaController {
    @Autowired
    private UserService userService;

    @Autowired
    private ReceptService receptService;


    @RequestMapping("/samobranka")
    public String showAllSamobranka(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        long receptCount = receptService.getCountRecept();
        model.addAttribute("receptCount", receptCount);
        return "all-samobranka";
    }

    @RequestMapping("/recept")
    public String showAllRecept(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        List<Recept> allRecept = receptService.getAllRecept();
        model.addAttribute("allRecept", allRecept);
        return "all-recept";
    }

    @RequestMapping("/addNewRecept")
    public String addNewRecept(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        Recept recept = new Recept();
        model.addAttribute("recept", recept);

        return "recept-form";
    }

    @RequestMapping("/saveRecept")
    public String saveRecept(@ModelAttribute("recept") Recept recept) {
        receptService.saveRecept(recept);
        return "redirect:recept";
    }

    @RequestMapping("/updateRecept")
    public String updateRecept(@RequestParam("receptId") int id, Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        Recept recept = receptService.getRecept(id);
        model.addAttribute("recept", recept);
        return "recept-form";
    }

    @RequestMapping("/deleteRecept")
    public String deteleRecept(@RequestParam("receptId") int id) {
        receptService.deleteRecept(id);
        return "redirect:recept";
    }

    @RequestMapping("/samobrankaAkt")
    public String obrabotkaAktov(Model model,Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("receptService",receptService);
        return "all-samobrankaAkt";
    }

    @RequestMapping("/checkAkt")
    public String checkAct(Model model,Principal principal)  {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        receptService.checkAct();
        return "redirect:samobrankaAkt";
    }

    @GetMapping("samobranka/export/excel")
    private void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Recept_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Recept> ListRecept = receptService.getAllRecept();
        ReceptExcelExporter receptExcelExporter = new ReceptExcelExporter(ListRecept);
        receptExcelExporter.export(response);

    }


}
