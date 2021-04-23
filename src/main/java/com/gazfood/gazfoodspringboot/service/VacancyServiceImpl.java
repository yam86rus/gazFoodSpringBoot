package com.gazfood.gazfoodspringboot.service;


import com.gazfood.gazfoodspringboot.dao.VacancyRepository;
import com.gazfood.gazfoodspringboot.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyServiceImpl implements VacancyService{
    @Autowired
    private VacancyRepository vacancyRepository;

    @Override
    public List<Vacancy> getAllVacancies() {
        return vacancyRepository.findAll();
    }

    @Override
    public void saveVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy getVacancy(int id) {
        Vacancy vacancy = null;
        Optional<Vacancy> optional = vacancyRepository.findById(id);
        if (optional.isPresent()){
            vacancy = optional.get();
        }
        return vacancy;
    }

    @Override
    public void deleteVacancy(int id) {
        vacancyRepository.deleteById(id);
    }

    @Override
    public long getCountVacancies() {
        return vacancyRepository.count();
    }
}
