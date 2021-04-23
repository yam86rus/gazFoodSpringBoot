package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Cassa;

import java.util.List;

public interface CassaService {
    List<Cassa> getAllCasses();

    void saveCassa(Cassa casse);

    Cassa getCassa(int id);

    void deleteCassa(int id);

    long getCountCasses();
}
