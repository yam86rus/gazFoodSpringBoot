package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.PriceCategoryRepository;
import com.gazfood.gazfoodspringboot.entity.PriceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PriceCategoryServiceImpl implements PriceCategoryService {

    @Autowired
    private PriceCategoryRepository priceCategoryRepository;

    @Override
    public List<PriceCategory> getAllPriceCategories() {
        List<PriceCategory> allPriceCategory = priceCategoryRepository.findAll();
        return allPriceCategory;
    }

    @Override
    public void savePriceCategory(PriceCategory priceCategory) {
        priceCategoryRepository.save(priceCategory);
    }

    @Override
    public PriceCategory getPriceCategory(int id) {
        PriceCategory priceCategory = null;
        Optional<PriceCategory> optional = priceCategoryRepository.findById(id);
        if (optional.isPresent()) {
            priceCategory = optional.get();
        }
        return priceCategory;
    }

    @Override
    public void deletePriceCategory(int id) {
        priceCategoryRepository.deleteById(id);
    }

    @Override
    public long getCountPriceCategories() {
        return priceCategoryRepository.count();
    }

}
