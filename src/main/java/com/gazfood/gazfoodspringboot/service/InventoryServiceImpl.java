package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.InventoryRepository;
import com.gazfood.gazfoodspringboot.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public void saveInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getInventory(int id) {
        return inventoryRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteInventory(int id) {
    inventoryRepository.deleteById(id);
    }


    @Override
    public long getCountInventory() {
        return inventoryRepository.count();
    }
}
