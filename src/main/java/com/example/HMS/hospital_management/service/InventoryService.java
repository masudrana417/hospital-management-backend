package com.example.HMS.hospital_management.service;

import com.example.HMS.hospital_management.entity.Inventory;
import com.example.HMS.hospital_management.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getInventoryList() {
        return inventoryRepository.findAll();
    }
}
