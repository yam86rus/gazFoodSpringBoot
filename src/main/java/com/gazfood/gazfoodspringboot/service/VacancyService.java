package com.gazfood.gazfoodspringboot.service;



import com.gazfood.gazfoodspringboot.entity.Vacancy;

import java.util.List;

public interface VacancyService {
    public List<Vacancy> getAllVacancies();
    public void saveVacancy (Vacancy vacancy);
    public Vacancy getVacancy(int id);
    public void deleteVacancy(int id);

}
