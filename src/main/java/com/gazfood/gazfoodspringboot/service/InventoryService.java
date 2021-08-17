package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> getAllInventory();

    void saveInventory(Inventory inventory);

    Inventory getInventory(int id);

    void deleteInventory(int id);

    long getCountInventory();
}
