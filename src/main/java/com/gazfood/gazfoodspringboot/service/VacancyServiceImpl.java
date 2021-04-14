package com.gazFood.service;


import com.gazFood.dao.VacancyDAO;
import com.gazFood.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService{
    @Autowired
    private VacancyDAO vacancyDAO;

    @Override
    @Transactional
    public List<Vacancy> getAllVacancies() {
        return vacancyDAO.getAllVacancies();
    }

    @Override
    @Transactional
    public void saveVacancy(Vacancy vacancy) {
        vacancyDAO.saveVacancy(vacancy);
    }

    @Override
    @Transactional
    public Vacancy getVacancy(int id) {
        return vacancyDAO.getVacancy(id);
    }

    @Override
    @Transactional
    public void deleteVacancy(int id) {
        vacancyDAO.deleteVacancy(id);
    }
}
