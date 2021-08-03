package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.ReceptRepository;
import com.gazfood.gazfoodspringboot.entity.Recept;
import com.gazfood.gazfoodspringboot.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptServiceImpl implements ReceptService {
    @Autowired
    private ReceptRepository receptRepository;

    @Override
    public List<Recept> getAllRecept() {
        List<Recept> allRecepts = receptRepository.findAll();
        return allRecepts;
    }

    @Override
    public long getCountRecept() {
        return receptRepository.count();
    }

    @Override
    public void saveRecept(Recept recept) {
        receptRepository.save(recept);
    }

    @Override
    public Recept getRecept(int id) {
        Recept recept = null;
        Optional<Recept> optional = receptRepository.findById(id);
        if(optional.isPresent()){
            recept = optional.get();
        }
        return recept;
    }

    @Override
    public void deleteRecept(int id) {
        receptRepository.deleteById(id);
    }
}
