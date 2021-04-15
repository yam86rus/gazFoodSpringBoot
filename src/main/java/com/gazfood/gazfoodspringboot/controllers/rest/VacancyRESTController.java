package com.gazfood.gazfoodspringboot.controllers.rest;
import com.gazfood.gazfoodspringboot.entity.Vacancy;
import com.gazfood.gazfoodspringboot.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VacancyRESTController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping("/vacancies")
    public List<Vacancy> showAllEmployees() {
        List<Vacancy> allVacancies = vacancyService.getAllVacancies();
        return allVacancies;
    }

}
