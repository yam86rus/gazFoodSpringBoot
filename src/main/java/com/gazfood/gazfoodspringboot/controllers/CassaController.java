package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Cassa;
import com.gazfood.gazfoodspringboot.exports.CassaExcelExporter;
import com.gazfood.gazfoodspringboot.service.CassaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Controller
public class CassaController {

    @Autowired
    private CassaService cassaService;

    @GetMapping("/casses")
    private String showCassaPage(Model model) {
        List<Cassa> allCasses = cassaService.getAllCassesOrder();
        model.addAttribute("allCasses", allCasses);

        LocalDate todaydate = LocalDate.now();

        model.addAttribute("todaydate", todaydate);
        return "all-casses";
    }

    @GetMapping("/casses/export/excel")
    private void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=casses_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Cassa> listCasses = cassaService.getAllCassesOrder();;

        CassaExcelExporter excelExporter = new CassaExcelExporter(listCasses);

        excelExporter.export(response);
    }

    @RequestMapping("/addNewCassa")
    public String addNewCassa(Model model) {
        Cassa cassa = new Cassa();
        model.addAttribute("cassa", cassa);
        return "cassa-form";
    }

    @RequestMapping("saveCassa")
    public String saveCassa(@ModelAttribute("cassa") Cassa cassa) {
        cassaService.saveCassa(cassa);
        return "redirect:casses";
    }

    @RequestMapping("updateCassa")
    public String updateCassa(@RequestParam("cassaId") int id, Model model) {
        Cassa cassa = cassaService.getCassa(id);
        model.addAttribute("cassa", cassa);
        return "cassa-form";
    }

    @RequestMapping("deleteCassa")
    public String deleteCassa(@RequestParam("cassaId") int id) {
        cassaService.deleteCassa(id);
        return "redirect:casses";
    }


    @RequestMapping("/detailsCassa")
    public String detailsCassa(@RequestParam("cassaId") int id, Model model) {
        Cassa cassa = cassaService.getCassa(id);
        model.addAttribute("cassa", cassa);

        return "cassa-form";
    }

}
